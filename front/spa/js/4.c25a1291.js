(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[4],{2661:function(t,a,s){"use strict";s("9445")},"7ce7":function(t,a,s){"use strict";var e=function(){var t=this,a=t.$createElement,s=t._self._c||a;return s("div",{staticClass:"q-pa-md",staticStyle:{padding:"0"}},[s("q-carousel",{ref:"carousel",staticClass:"shadow-2",staticStyle:{"border-radius":"15px"},attrs:{swipeable:"",animated:"","transition-prev":"jump-right","transition-next":"jump-left",autoplay:t.autoplay,infinite:""},scopedSlots:t._u([{key:"control",fn:function(){return[s("q-carousel-control",{staticClass:"text-white rounded-borders",staticStyle:{background:"rgba(0, 0, 0, .3)",padding:"4px 8px"},attrs:{position:"top-right",offset:[18,18]}},[s("q-toggle",{attrs:{dense:"",dark:"",color:"#01a5a2",label:"Auto Play"},model:{value:t.autoplay,callback:function(a){t.autoplay=a},expression:"autoplay"}})],1),s("q-carousel-control",{staticClass:"q-gutter-xs",attrs:{position:"bottom-right",offset:[18,18]}},[s("q-btn",{staticClass:"bg-primary",attrs:{push:"",round:"",dense:"","text-color":"black",icon:"arrow_left"},on:{click:function(a){return t.$refs.carousel.previous()}}}),s("q-btn",{staticClass:"bg-primary",attrs:{push:"",round:"",dense:"","text-color":"black",icon:"arrow_right"},on:{click:function(a){return t.$refs.carousel.next()}}})],1)]},proxy:!0}]),model:{value:t.slide,callback:function(a){t.slide=a},expression:"slide"}},[s("q-carousel-slide",{attrs:{name:1,"img-src":"https://www.getui.com/picture/2019/12/20/7d16bf96a41e4938a2df95791d9b2eaf.png"}},[s("div",{staticClass:"absolute-bottom custom-caption"},[s("div",{staticClass:"text-h2"},[t._v("欢迎新用户")]),s("div",{staticClass:"text-subtitle1"},[t._v("专注于丰富大学生社交活动")])])]),s("q-carousel-slide",{attrs:{name:2,"img-src":"https://img.zcool.cn/community/01bf555cc29e61a801208f8b7fc719.jpg@1280w_1l_2o_100sh.jpg"}},[s("div",{staticClass:"absolute-bottom custom-caption"},[s("div",{staticClass:"text-h2"},[t._v("立即加入大本营")]),s("div",{staticClass:"text-subtitle1"},[t._v("订阅官方用户可获得相应内容")])])]),s("q-carousel-slide",{attrs:{name:3,"img-src":"https://cdn.quasar.dev/img/parallax2.jpg"}},[s("div",{staticClass:"absolute-bottom custom-caption"},[s("div",{staticClass:"text-h2"},[t._v("First stop")]),s("div",{staticClass:"text-subtitle1"},[t._v("Mountains")])])]),s("q-carousel-slide",{attrs:{name:4,"img-src":"https://cdn.quasar.dev/img/quasar.jpg"}},[s("div",{staticClass:"absolute-bottom custom-caption"},[s("div",{staticClass:"text-h2"},[t._v("First stop")]),s("div",{staticClass:"text-subtitle1"},[t._v("Mountains")])])])],1)],1)},i=[],r={name:"MyCarousel",data(){return{slide:"1",autoplay:!0}}},c=r,o=(s("2661"),s("2877")),n=s("880c"),l=s("62cd"),d=s("32a7"),u=s("9564"),p=s("9c40"),m=s("eebe"),b=s.n(m),v=Object(o["a"])(c,e,i,!1,null,"87365a50",null);a["a"]=v.exports;b()(v,"components",{QCarousel:n["a"],QCarouselSlide:l["a"],QCarouselControl:d["a"],QToggle:u["a"],QBtn:p["a"]})},8041:function(t,a,s){"use strict";s("cb9a")},"8b24":function(t,a,s){"use strict";s.r(a);var e=function(){var t=this,a=t.$createElement,s=t._self._c||a;return s("q-page",{staticClass:"flex-center"},[s("div",{staticClass:"row"},[s("div",{staticClass:"col-sm-12 col-md-9 shadow-2"},[s("MyCarousel"),s("q-separator",{staticStyle:{"margin-top":"15px","background-image":"linear-gradient(to right, #00adb5, #a8f6f6)",height:"2px"},attrs:{inset:""}}),s("div",{staticClass:"row",staticStyle:{"margin-top":"15px"}},t._l(t.ofc_contents,(function(a,e){return s("q-card",{key:a.ofc_content_id,staticClass:"ofc-card col"},[s("q-img",{staticStyle:{"border-radius":"15px",height:"220px"},attrs:{src:t.ofcConSrc[e]}}),s("q-card-section",[s("q-btn",{staticClass:"absolute",staticStyle:{top:"0",right:"12px",transform:"translateY(-50%)","backdrop-filter":"blur(8px)"},attrs:{round:"",size:"25px"}},[s("q-avatar",{attrs:{size:"60px"}},[s("img",{attrs:{src:t.ofcAvtSrc[e]}})])],1),s("div",{staticClass:"row no-wrap items-center"},[s("div",{staticClass:"col ofc-card-title"},[t._v("\n                    "+t._s(a.title)+"\n                  ")])])],1),s("q-card-section",{staticClass:"q-pt-none"},[s("div",[t._v("\n                  "+t._s(a.pub_time)+"\n                ")]),s("div",{staticClass:"text-subtitle1"},[t._v("\n                  "+t._s(a.ofc_name)+"\n                ")]),s("div",{staticClass:"text-caption text-grey ellipsis-2-lines"},[t._v("\n                  "+t._s(a.contents)+"\n                ")])]),s("q-separator"),s("q-card-actions",{staticStyle:{"max-height":"60px"},attrs:{align:"right"}},[s("div",[t._v(" 浏览量："),s("span",{staticClass:"views"},[t._v(t._s(a.views))])]),s("q-space"),s("q-btn",{attrs:{flat:"",round:"",color:"red",icon:"thumb_up_alt"}}),s("q-btn",{attrs:{flat:"",round:"",color:"teal",icon:"thumb_down_alt"}}),s("q-btn",{attrs:{flat:"",round:"",color:"primary",icon:"share"},on:{click:function(a){return t.followOfc()}}})],1)],1)})),1),s("q-separator",{staticStyle:{"margin-top":"15px","background-image":"linear-gradient(to right, #00adb5, #a8f6f6)",height:"2px"},attrs:{inset:""}}),s("div",{staticClass:"q-gutter-y-md",staticStyle:{"margin-top":"15px"}},[s("q-card",{staticStyle:{"border-radius":"15px"}},[s("q-tabs",{staticClass:"text-grey",attrs:{dense:"","active-color":"primary","indicator-color":"primary",align:"justify","narrow-indicator":""},model:{value:t.tab,callback:function(a){t.tab=a},expression:"tab"}},[s("q-tab",{attrs:{name:"mails",label:"Mails"}}),s("q-tab",{attrs:{name:"alarms",label:"Alarms"}}),s("q-tab",{attrs:{name:"movies",label:"Movies"}})],1),s("q-separator"),s("q-tab-panels",{attrs:{animated:""},model:{value:t.tab,callback:function(a){t.tab=a},expression:"tab"}},[s("q-tab-panel",{attrs:{name:"mails"}},[s("div",{staticClass:"text-h6"},[t._v("Mails")]),t._v("\n                    Lorem ipsum dolor sit amet consectetur adipisicing elit.\n                  ")]),s("q-tab-panel",{attrs:{name:"alarms"}},[s("div",{staticClass:"text-h6"},[t._v("Alarms")]),t._v("\n                    Lorem ipsum dolor sit amet consectetur adipisicing elit.\n                  ")]),s("q-tab-panel",{attrs:{name:"movies"}},[s("div",{staticClass:"text-h6"},[t._v("Movies")]),t._v("\n                    Lorem ipsum dolor sit amet consectetur adipisicing elit.\n                  ")])],1)],1)],1)],1),s("div",{staticClass:"col-sm-12 col-md-3"},[s("div",{staticStyle:{"margin-left":"25px"}},[s("q-card",{staticClass:"my-card text-white",staticStyle:{"background-color":"#00adb5"}},[s("q-card-section",[s("div",{staticStyle:{"font-size":"18px"}},[t._v("活跃用户")])]),s("q-separator",{staticStyle:{background:"#00adb5",height:"2px"}}),s("q-card-section",[s("div",{staticClass:"q-gutter-lg"},t._l(t.active_stu,(function(a){return s("div",{key:a.nickname,staticClass:"inline-block column"},[s("q-avatar",{staticStyle:{background:"#00bcd4"},attrs:{size:"57px"}},[s("img",{staticStyle:{border:"4px solid #00adb5"},attrs:{src:"https://cdn.quasar.dev/img/boy-avatar.png"}})]),s("div",{staticStyle:{"text-align":"center"}},[t._v("\n                      "+t._s(a.nickname)+"\n                    ")])],1)})),0)])],1),s("q-card",{staticClass:"my-card text-white",staticStyle:{"background-color":"#00adb5"}},[s("q-card-section",[s("div",{staticStyle:{"font-size":"18px"}},[t._v("以下是我们的广告合作商")]),s("div",{staticClass:"text-subtitle2"},[t._v("可选择关闭")])]),s("q-separator",{staticStyle:{background:"#00adb5",height:"2px"}}),s("q-card-actions",{attrs:{align:"around"}},[s("q-btn",{attrs:{flat:""}},[t._v("全部关闭")]),s("q-btn",{attrs:{flat:""}},[t._v("无所谓")])],1)],1),s("q-card",{staticClass:"my-card"},[s("q-img",{attrs:{src:"https://cdn.quasar.dev/img/parallax2.jpg"}},[s("div",{staticClass:"absolute-bottom"},[s("div",{staticClass:"text-h6"},[t._v("Our Changing Planet")]),s("div",{staticClass:"text-subtitle2"},[t._v("by John Doe")])])]),s("q-card-actions",{attrs:{align:"around"}},[s("q-btn",{attrs:{flat:""}},[t._v("详情")]),s("q-btn",{attrs:{flat:""}},[t._v("关闭")])],1)],1),s("q-card",{staticClass:"my-card"},[s("q-img",{attrs:{src:"https://cdn.quasar.dev/img/parallax2.jpg"}},[s("div",{staticClass:"absolute-bottom"},[s("div",{staticClass:"text-h6"},[t._v("Our Changing Planet")]),s("div",{staticClass:"text-subtitle2"},[t._v("by John Doe")])])]),s("q-card-actions",{attrs:{align:"around"}},[s("q-btn",{attrs:{flat:""}},[t._v("详情")]),s("q-btn",{attrs:{flat:""}},[t._v("关闭")])],1)],1),s("q-card",{staticClass:"my-card"},[s("q-img",{attrs:{src:"https://cdn.quasar.dev/img/parallax2.jpg"}},[s("div",{staticClass:"absolute-bottom"},[s("div",{staticClass:"text-h6"},[t._v("Our Changing Planet")]),s("div",{staticClass:"text-subtitle2"},[t._v("by John Doe")])])]),s("q-card-actions",{attrs:{align:"around"}},[s("q-btn",{attrs:{flat:""}},[t._v("详情")]),s("q-btn",{attrs:{flat:""}},[t._v("关闭")])],1)],1),s("q-space")],1)])]),s("div",{staticClass:"row page-footer shadow-2",staticStyle:{"margin-top":"30px","border-radius":"15px","min-height":"100px"}},[t._v("\n    版权所有\n  ")]),s("q-page-scroller",{attrs:{position:"bottom-right","scroll-offset":150,offset:[18,18]}},[s("q-btn",{attrs:{fab:"",icon:"keyboard_arrow_up",color:"dark"}})],1)],1)},i=[],r=s("7ce7"),c={name:"PageIndex",data(){return{value:"",mkValue:"",tab:"mails",ofc_contents:[],active_stu:[],ofcAvtSrc:["https://tse2-mm.cn.bing.net/th/id/OIP._CloLwkyh1826RZ9JtzAzwHaHZ?pid=ImgDet&rs=1","https://i.loli.net/2020/02/27/6tCJyIGW95z82Er.png","https://gss0.baidu.com/-vo3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/5366d0160924ab189a0f046d37fae6cd7b890b4a.jpg"],ofcConSrc:["https://www.3dmgame.com/uploads/allimg/170223/347_170223095204_1.png","https://img.zcool.cn/community/01ca1a59dad31aa80121ae0cbcd00b.png@2o.png","https://img.zcool.cn/community/016f035ae413eea80120927bfd490c.jpg@1280w_1l_2o_100sh.jpg"]}},components:{MyCarousel:r["a"]},methods:{getValue(t,a){this.mkValue=a},loadOfcContents(){this.$axios.get("/showNewOfcContents").then((t=>{alert(t.data),this.ofc_contents=t.data}))},loadActiveStuUser(){this.$axios.get("/showActiveStuUsers").then((t=>{alert(t.data),this.active_stu=t.data}))}},computed:{nickname:{get(){return this.$store.state.userstate.nickname},set(t){this.$store.commit("userstate/updateNickname",t)}}},created(){this.loadOfcContents(),this.loadActiveStuUser()}},o=c,n=(s("8041"),s("2877")),l=s("9989"),d=s("eb85"),u=s("f09f"),p=s("068f"),m=s("a370"),b=s("9c40"),v=s("cb32"),g=s("4b7e"),f=s("2c91"),h=s("429b"),_=s("7460"),q=s("adad"),x=s("823b"),C=s("5096"),y=s("eebe"),w=s.n(y),k=Object(n["a"])(o,e,i,!1,null,null,null);a["default"]=k.exports;w()(k,"components",{QPage:l["a"],QSeparator:d["a"],QCard:u["a"],QImg:p["a"],QCardSection:m["a"],QBtn:b["a"],QAvatar:v["a"],QCardActions:g["a"],QSpace:f["a"],QTabs:h["a"],QTab:_["a"],QTabPanels:q["a"],QTabPanel:x["a"],QPageScroller:C["a"]})},9445:function(t,a,s){},cb9a:function(t,a,s){}}]);