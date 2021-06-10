<template>
  <q-dialog :value="isOpening" persistent transition-show="jump-right" transition-hide="jump-right">
    <q-card class="my-card bg-secondary">
      <div class="mycard-header mycard-header-blue" style="">
        <q-bar style="background: none">
          <q-icon name="comment" />
          <div>详情</div>

          <q-space />

          <q-btn dense rounded flat icon="close" @click="closeDialog">
            <q-tooltip anchor="top middle" self="bottom middle" :offset="[10, 10]">关闭</q-tooltip>
          </q-btn>
        </q-bar>
      </div>
      <q-card-section class="row" style="margin-top: -6.5%; padding-left: 20px; padding-right: 25px; padding-top: 10px; padding-bottom: 10px;">
        <q-btn
          rounded
          dense
          flat
          size="21px"
          style="top: 0; left: 12px; font-size: 18px;"
        >
          <q-avatar size="65px">
            <img src="https://cdn.quasar.dev/img/boy-avatar.png" style="border: 4px solid #e0f8f8;">
          </q-avatar>
          {{dialog_contents.nick_name}}
        </q-btn>
        <q-space/>
        <div class="pub-time" style="font-size: 18px;">
           {{dialog_contents.pub_time}}
        </div>
      </q-card-section>
      <q-card-section class="q-pt-none" style="padding: 0 15px 5px 15px">
        <div class="text-capitalize hljs-emphasis" style="padding-top: 0; padding-bottom: 0; font-size: 15px; line-height: 24px; padding-left: 5px; padding-right: 5px">
          {{dialog_contents.contents}}
        </div>
        <div>
          <q-chip color="primary" text-color="white" icon="local_offer">
            开心
          </q-chip>
          <q-chip color="primary" text-color="white" icon="local_offer">
            快乐
          </q-chip>
        </div>
      </q-card-section>

      <q-card-actions style="max-height: 60px; padding-left: 15px; padding-right: 15px">
        <div style="font-size: 15px; color: #90a4ae"><q-icon size="25px" name="visibility"/>1,500</div>
        <q-space/>
        <q-btn flat rounded icon="thumb_up_alt" style="color: #f7ba5e">{{dialog_contents.like}}</q-btn>
        <q-btn flat rounded icon="thumb_down_alt" style="color: #f56c6c">{{dialog_contents.dislike}}</q-btn>
      </q-card-actions>
      <q-separator inset/>
      <q-card-section style="padding-left: 15px; padding-right: 15px">
        <q-scroll-area style="height: 230px;">
          <div v-for="comment in dialog_contents.comments" :key="comment.pub_time">
            <q-item style="border-bottom: 1px solid #d6eee9">
              <q-item-section side>
                <q-avatar round size="48px">
                  <img src="https://cdn.quasar.dev/img/avatar.png" />
                  <q-badge floating color="primary">new</q-badge>
                </q-avatar>
              </q-item-section>
              <q-item-section>
                <q-item-label caption>{{comment.nick_name}}</q-item-label>
                <q-item-label>{{comment.contents}}</q-item-label>
              </q-item-section>
              <q-item-section side>
                {{comment.pub_time}}
              </q-item-section>
            </q-item>
          </div>

        </q-scroll-area>

      </q-card-section>

    </q-card>


  </q-dialog>
</template>

<script>
export default {
  name: "Comment-Dialog",
  data() {
    return {
      dialog_contents: {
        nick_name: '曾立功',
        pub_time: '2021/06/05',
        contents: '啊哈哈哈为什么我总是这么容易心软，经不起软磨硬泡…总觉得是我的错容易内疚总感觉是自己的问题…在友情中我总是比较卑微的那一方，别人说啥就是啥不怎么敢发表自己的意见和想法…别人说去哪我总是随叫随到…而我喊她们的时候她们总是有各种各样的事情…我讨厌这样的自己…什么时候才能做出改变',
        like: '20',
        dislike: '15',
        comments: [{
          nick_name: '张顺路',
          pub_time: '2021/06/06',
          contents: '一般一般也就一般也就一般也就一般也就一般也就一般也就一般也就一般也就一般也就一般一般也就一般也就一般也就一般也就一般也就一般也就一般也就一般'
        },{
          nick_name: '张顺路',
          pub_time: '2021/06/07',
          contents: '还成也就一般也就一般也就一般也就一般也就一般也就一般也就一般也就一般也就一般也就一般也就一般也就一般也就一般也就一般也就一般也就一般也就一般也就一'
        },
          {
            nick_name: '张顺路',
            pub_time: '2021/06/08',
            contents: '也就一般也就一般也就一般也就一般也就一般也就一般也就一般也就一般也就一般也就一般也就一般也就一般也就一般也就一般也就一般也就一般也就一般也就一般也就一般'
          },
          {
            nick_name: '张顺路',
            pub_time: '2021/06/08',
            contents: '也就一般也就一般也就一般也就一般也就一般也就一般也就一般也就一般也就一般也就一般也就一般也就一般也就一般也就一般也就一般也就一般也就一般也就一般也就一般'
          },
          {
            nick_name: '张顺路',
            pub_time: '2021/06/08',
            contents: '也就一般也就一般也就一般也就一般也就一般也就一般也就一般也就一般也就一般也就一般也就一般也就一般也就一般也就一般也就一般也就一般也就一般也就一般也就一般'
          },
        ]
      },
    }
  },
  props: ['isOpening'],
  methods: {
    closeDialog() {
      this.$emit('update:isOpening', false);
    },
  },
}
</script>

<style scoped>
.my-card {
  min-height: 600px;
  min-width: 900px;
  border-radius: 15px;
}
.mycard-header {
  height: 100px;
  border-radius: 15px;
}
.mycard-header-blue {
  background-color: rgba(0,173,181,0.7);
  background-image: linear-gradient(-45deg, rgba(255, 255, 255, .2) 20%, transparent 20%, transparent 50%, rgba(255, 255, 255, .2) 50%, rgba(255, 255, 255, .2) 80%, transparent 80%, transparent);
}
.pub-time {
  text-align: right;
  color: white;
  display: flex;
  flex-direction: column;
  justify-content: center;
}
</style>
