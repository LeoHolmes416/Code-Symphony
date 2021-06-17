package com.example.demo.Tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint(value = "/websocket/{sname}")
@Component
public class MyWebSocket {
    private final static Logger log = LoggerFactory.getLogger(MyWebSocket.class);
    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;
    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
    private static CopyOnWriteArraySet<MyWebSocket> webSocketSet = new CopyOnWriteArraySet<MyWebSocket>();
    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;
    private String name;
    /**
     * 连接建立成功调用的方法*/
    @OnOpen
    public void onOpen(Session session,@PathParam("sname") String sname) {
        this.name=sname;
        this.session = session;
        webSocketSet.add(this);     //加入set中
        addOnlineCount();           //在线数加1
        System.out.println("有新连接加入:"+sname+"！当前在线人数为" + getOnlineCount());
        try {
            sendMessage(sname,",连接成功，当前时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:SS").format(new Date().getTime()));
        } catch (IOException e) {
            System.out.println("IO异常");
        }
    }
    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);  //从set中删除
        subOnlineCount();           //在线数减1
        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
    }
    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息*/
    @OnMessage
    public void onMessage(String message, Session session,@PathParam("sname") String sname) {
        System.out.println("来自客户端"+name+"的消息:" + message);
        //群发消息
        for (MyWebSocket item : webSocketSet) {
            try {
                //给等陆这机子推送
                item.sendMessage(name,message);

                System.out.println("推送消息给:"+item.name+",消息是===》"+message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 发生错误时调用
     * */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }
    /**
     * 服务端给客户端发送消息
     * @param message
     * @throws IOException
     */
    public void sendMessage(String name,String message) throws IOException {
        this.session.getBasicRemote().sendText(name+"回应消息:"+message+"------------->"+"原酿我这一生不羁放在自由，那会怕有一天会跌倒");
        //this.session.getAsyncRemote().sendText(message);
    }
    /**
     * 群发自定义消息
     * */
    public static void sendInfo(@PathParam("sname") String sname,String message) throws IOException {
        for (MyWebSocket item : webSocketSet) {
            try {
                //这里可以设定只推送给这个sid的，为null则全部推送
                if(sname==null) {
                    item.sendMessage(sname,message);
                    System.out.println("推送消息给:"+item.name+",消息是===》"+message);
                }else if(item.name.equals(sname)){
                    item.sendMessage(sname,message);
                    System.out.println("推送消息给:"+item.name+",消息是===》"+message);
                }else {
                    log.error("此人不存在或没上线！");
                    continue;
                }
            } catch (IOException e) {
                log.error("在执行"+item+"时遇到错误！");
                continue;
            }
        }
    }
    public static synchronized int getOnlineCount() {
        return onlineCount;
    }
    public static synchronized void addOnlineCount() {
        MyWebSocket.onlineCount++;
    }
    public static synchronized void subOnlineCount() {
        MyWebSocket.onlineCount--;
    }
}
