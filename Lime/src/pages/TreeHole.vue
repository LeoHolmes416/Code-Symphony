<template>
<div>
  <div class="row" style="padding-left: 10px; padding-right: 10px">
    <q-tabs
      v-model="tab"
      dense
      align="justify"
      style="background: rgba(255,255,255,0.2); border-radius: 15px"
    >
      <q-tab class="text-warning" name="mails" icon="mail" label="Mails"/>
      <q-tab class="text-blue-6" name="alarms" icon="alarm" label="Alarms" />
      <q-tab class="text-negative" name="movies" icon="movie" label="Movies" />
    </q-tabs>
    <q-space/>
    <q-btn-toggle
      v-model="view_setting"
      class="my-custom-toggle"
      no-caps
      unelevated
      toggle-color="primary"
      text-color="primary"
      style="border-radius: 15px; border: 2px solid #00adb5"
      :options="[
          {label: 'Option 1', value: 'one'},
          {label: 'Option 2', value: 'two'}
        ]"
    />
  </div>

  <div class="row">
    <div class="column col-md-4 col-sm-6 col-xs-12" style="padding: 10px">
      <q-intersection
        transition="slide-right"
      >
        <q-card class="my-card bg-secondary" v-for="card in card_list1" :key="card.pub_time">
          <div class="mycard-header mycard-header-blue">
          </div>
          <q-card-section class="row" style="margin-top: -9%; padding-left: 0; padding-right: 15px; padding-top: 5px; padding-bottom: 0;">


            <q-btn
              rounded
              dense
              flat
              size="21px"
              style="top: 0; left: 12px; font-size: 15px;"
            >
              <q-avatar size="50px">
                <img src="https://cdn.quasar.dev/img/boy-avatar.png" style="border: 2px solid #e0f8f8;">
              </q-avatar>
              {{card.nick_name}}
            </q-btn>
            <q-space/>
            <div class="pub-time" style="font-size: 15px;">
              {{card.pub_time}}
            </div>

          </q-card-section>
          <q-card-section class="q-pt-none">
            <div class="text-capitalize hljs-emphasis" style="padding-top: 5px">
              {{card.contents}}
            </div>
            <div>
              <q-chip class="glossy" color="primary" text-color="white" icon="local_offer">
                开心
              </q-chip>
              <q-chip class="glossy" color="primary" text-color="white" icon="local_offer">
                快乐
              </q-chip>
            </div>
          </q-card-section>

          <q-separator />

          <q-card-actions align="right" style="max-height: 60px">
            <div style="font-size: 15px; color: #90a4ae"><q-icon size="20px" name="visibility"/>1,500</div>
            <q-space/>
            <q-btn flat rounded dense icon="thumb_up_alt" style="color: #f7ba5e">{{card.like}}</q-btn>
            <q-btn flat rounded dense icon="thumb_down_alt" style="color: #f56c6c">{{card.dislike}}</q-btn>
            <q-btn flat rounded dense icon="comment" style="color: #56585a" @click="showComment"/>
          </q-card-actions>
        </q-card>
      </q-intersection>

    </div>
    <div class="column col-md-4 col-sm-6 col-xs-12" style="padding: 10px">

      <q-intersection
        transition="jump-up"
      >
        <q-card class="my-card bg-secondary" v-for="card in card_list2" :key="card.pub_time">
          <div class="mycard-header  mycard-header-yellow">
          </div>
          <q-card-section class="row" style="margin-top: -9%; padding-left: 0; padding-right: 15px; padding-top: 5px; padding-bottom: 0;">


            <q-btn
              rounded
              dense
              flat
              size="21px"
              style="top: 0; left: 12px; font-size: 15px;"
            >
              <q-avatar size="50px">
                <img src="https://cdn.quasar.dev/img/boy-avatar.png" style="border: 2px solid #e0f8f8;">
              </q-avatar>
              {{card.nick_name}}
            </q-btn>
            <q-space/>
            <div class="pub-time" style="font-size: 15px;">
              {{card.pub_time}}
            </div>

          </q-card-section>
          <q-card-section class="q-pt-none">
            <div class="text-capitalize hljs-emphasis" style="padding-top: 5px">
              {{card.contents}}
            </div>
            <div>
              <q-chip class="glossy" color="primary" text-color="white" icon="local_offer">
                开心
              </q-chip>
              <q-chip class="glossy" color="primary" text-color="white" icon="local_offer">
                快乐
              </q-chip>
            </div>
          </q-card-section>

          <q-separator />

          <q-card-actions align="right" style="max-height: 60px">
            <div style="font-size: 15px; color: #90a4ae"><q-icon size="20px" name="visibility"/>1,500</div>
            <q-space/>
            <q-btn flat rounded dense icon="thumb_up_alt" style="color: #f7ba5e">{{card.like}}</q-btn>
            <q-btn flat rounded dense icon="thumb_down_alt" style="color: #f56c6c">{{card.dislike}}</q-btn>
            <q-btn flat rounded dense icon="comment" style="color: #56585a" @click="showComment"/>
          </q-card-actions>
        </q-card>
      </q-intersection>

    </div>
    <div class="column col-md-4 col-sm-6 col-xs-12" style="padding: 10px">

      <q-intersection
        transition="slide-left"
      >
        <q-card class="my-card bg-secondary" v-for="card in card_list1" :key="card.pub_time">
        <div class="mycard-header mycard-header-green">
        </div>
          <q-card-section class="row" style="margin-top: -9%; padding-left: 0; padding-right: 15px; padding-top: 5px; padding-bottom: 0;">


            <q-btn
              rounded
              dense
              flat
              size="21px"
              style="top: 0; left: 12px; font-size: 15px;"
            >
              <q-avatar size="50px">
                <img src="https://cdn.quasar.dev/img/boy-avatar.png" style="border: 2px solid #e0f8f8;">
              </q-avatar>
              {{card.nick_name}}
            </q-btn>
            <q-space/>
            <div class="pub-time" style="font-size: 15px;">
              {{card.pub_time}}
            </div>

          </q-card-section>
          <q-card-section class="q-pt-none">
            <div class="text-capitalize hljs-emphasis" style="padding-top: 5px">
              {{card.contents}}
            </div>
            <div>
              <q-chip class="glossy" color="primary" text-color="white" icon="local_offer">
                开心
              </q-chip>
              <q-chip class="glossy" color="primary" text-color="white" icon="local_offer">
                快乐
              </q-chip>
            </div>
          </q-card-section>

        <q-separator />

        <q-card-actions align="right" style="max-height: 60px">
          <div style="font-size: 15px; color: #90a4ae"><q-icon size="20px" name="visibility"/>1,500</div>
          <q-space/>
          <q-btn flat rounded dense icon="thumb_up_alt" style="color: #f7ba5e">{{card.like}}</q-btn>
          <q-btn flat rounded dense icon="thumb_down_alt" style="color: #f56c6c">{{card.dislike}}</q-btn>
          <q-btn flat rounded dense icon="comment" style="color: #56585a" @click="showComment"/>
        </q-card-actions>
      </q-card>
      </q-intersection>

    </div>

  </div>
  <CommentDialog :is-opening.sync="dialog_is_opening"/>
</div>
</template>

<script>
import CommentDialog from "components/Comment-Dialog";
export default {
  name: "TreeHole",
  data() {
    return {
      tab: 'mails',
      view_setting: '',
      dialog_is_opening: false,
      card_list1: [
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeleo\nloleoeloleoelole\noeloeloeloeoloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeleooleoeloleoelol\neloeloeloeooeloeloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leole\noeleoeleo\nleoleoleoe\nloleoelo\noeloeloeooleoel\noleoeloleo\neloeloeloeoleole\noeleoeleo\nleoleoleoe\nloleoelo\noeloeloeooleoel\noleoeloleo\neloeloeloeoleole\noeleoeleo\nleoleoleoe\nloleoelo\noeloeloeooleoel\noleoeloleo\neloeloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleooleoelol\nloleoeloeloeloeoloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleooleoe\noeloeloeloeooeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleooleoeloleoe\noeoleoeloleoeloeloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeleole\noeloeloeloeooeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeloleoelole\neloeloeoloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeleoleoleoleoelo\neoeloleoeloeloeloeooeloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeleoleoleoo\noeloeoleoeloeloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeleoleo\nloleoeloleoeloeloe\neoeloleoeloleoeloeloeloeo',
          like: '20',
          dislike: '15'
        },        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeleo\nloleoeloleoelole\noeloeloeloeoloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeleooleoeloleoelol\neloeloeloeooeloeloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leole\noeleoeleo\nleoleoleoe\nloleoelo\noeloeloeooleoel\noleoeloleo\neloeloeloeoleole\noeleoeleo\nleoleoleoe\nloleoelo\noeloeloeooleoel\noleoeloleo\neloeloeloeoleole\noeleoeleo\nleoleoleoe\nloleoelo\noeloeloeooleoel\noleoeloleo\neloeloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleooleoelol\nloleoeloeloeloeoloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleooleoe\noeloeloeloeooeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleooleoeloleoe\noeoleoeloleoeloeloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeleole\noeloeloeloeooeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeloleoelole\neloeloeoloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeleoleoleoleoelo\neoeloleoeloeloeloeooeloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeleoleoleoo\noeloeoleoeloeloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeleoleo\nloleoeloleoeloeloe\neoeloleoeloleoeloeloeloeo',
          like: '20',
          dislike: '15'
        },        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeleo\nloleoeloleoelole\noeloeloeloeoloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeleooleoeloleoelol\neloeloeloeooeloeloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leole\noeleoeleo\nleoleoleoe\nloleoelo\noeloeloeooleoel\noleoeloleo\neloeloeloeoleole\noeleoeleo\nleoleoleoe\nloleoelo\noeloeloeooleoel\noleoeloleo\neloeloeloeoleole\noeleoeleo\nleoleoleoe\nloleoelo\noeloeloeooleoel\noleoeloleo\neloeloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleooleoelol\nloleoeloeloeloeoloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleooleoe\noeloeloeloeooeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleooleoeloleoe\noeoleoeloleoeloeloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeleole\noeloeloeloeooeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeloleoelole\neloeloeoloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeleoleoleoleoelo\neoeloleoeloeloeloeooeloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeleoleoleoo\noeloeoleoeloeloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeleoleo\nloleoeloleoeloeloe\neoeloleoeloleoeloeloeloeo',
          like: '20',
          dislike: '15'
        },

      ],
      card_list2: [
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeleo\nloleoeloleoelol\neloeloeloeooeloeoeloleoelole\noeloeloeloeoloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeleooleoeloleoelol\neloeloeloeooeloeloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leole\noeleoeleo\nleoloeloleoelol\neloeloeloeooeloeleole\noeleoeleo\nleoleoleoe\nloleoelo\noeloeloeooleoel\noleoeloleo\neloeloeloeoleole\noeleoeleo\nleoleoleoe\nloleoelo\noeloeloeooleoel\noleoeloleo\neloeloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoooeloleoelol\neloeloeloeooeloeloeloeloeoloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleooeloleoelol\neloeloeloeooeloee\noeloeloeloeooeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeloleoelol\neloeloeloeooeloeeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeleole\noeloeloeloeooeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeloleoelol\neloeloeloeooeloeoloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeleoeloleoelol\neloeloeloeooeloeleoeloeloeloeooeloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleooeloleoelol\neloeloeloeooeloeeoeloeloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeloleoelol\neloeloeloeooeloe\neoeloleoeloleoeloeloeloeo',
          like: '20',
          dislike: '15'
        },        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeleo\nloleoeloleoelole\noeloeloeloeoloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeleooleoeloleoelol\neloeloeloeooeloeloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leole\noeleoeleo\nleoleoleoe\nloleoelo\noeloeloeooleoel\noleoeloleo\neloeloeloeoleole\noeleoeleo\nleoleoleoe\nloleoelo\noeloeloeooleoel\noleoeloleo\neloeloeloeoleole\noeleoeleo\nleoleoleoe\nloleoelo\noeloeloeooleoel\noleoeloleo\neloeloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleooleoelol\nloleoeloeloeloeoloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleooleoe\noeloeloeloeooeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleooleoeloleoe\noeoleoeloleoeloeloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeleole\noeloeloeloeooeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeloleoelole\neloeloeoloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeleoleoleoleoelo\neoeloleoeloeloeloeooeloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeleoleoleoo\noeloeoleoeloeloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeleoleo\nloleoeloleoeloeloe\neoeloleoeloleoeloeloeloeo',
          like: '20',
          dislike: '15'
        },        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeleo\nloleoeloleoelole\noeloeloeloeoloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeleooleoeloleoelol\neloeloeloeooeloeloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leole\noeleoeleo\nleoleoleoe\nloleoelo\noeloeloeooleoel\noleoeloleo\neloeloeloeoleole\noeleoeleo\nleoleoleoe\nloleoelo\noeloeloeooleoel\noleoeloleo\neloeloeloeoleole\noeleoeleo\nleoleoleoe\nloleoelo\noeloeloeooleoel\noleoeloleo\neloeloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleooleoelol\nloleoeloeloeloeoloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleooleoe\noeloeloeloeooeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleooleoeloleoe\noeoleoeloleoeloeloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeleole\noeloeloeloeooeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeloleoelole\neloeloeoloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeleoleoleoleoelo\neoeloleoeloeloeloeooeloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeleoleoleoo\noeloeoleoeloeloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeleoleo\nloleoeloleoeloeloe\neoeloleoeloleoeloeloeloeo',
          like: '20',
          dislike: '15'
        },

      ],
      card_list3: [
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeleo\nloleoeloleoelole\noeloeloeloeoloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeoeloleoelol\neloeloeloeooeloeoelol\neloeloeloeooeloeloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leole\noeleoeleo\nleooeloleoelol\neloeloeloeooeloeloeloeoleole\noeleoeleo\nleoleoleoe\nloleoelo\noeloeloeooleoel\noleoeloleo\neloeloeloeoleole\noeleoeleo\nleoleoleoe\nloleoelo\noeloeloeooleoel\noleoeloleo\neloeloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleooleoeoeloleoelol\neloeloeloeooeloeloeoloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoloeloleoelol\neloeloeloeooeloeoeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleooleoeoeloleoelol\neloeloeloeooeloeloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeeloeooeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoelole\neloeoeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeloeloleoelol\neloeloeloeooeloeo\neoeloleoeloeloeloeooeloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleooeloleoelol\neloeloeloeooeloeoeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeleoleo\nloleoeloleoeloeloe\neoeloleoeloleoeloeloeloeo',
          like: '20',
          dislike: '15'
        },        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeleo\nloleoeloleoelole\noeloeloeloeoloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeleooleoeloleoelol\neloeloeloeooeloeloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leole\noeleoeleo\nleoleoleoe\nloleoelo\noeloeloeooleoel\noleoeloleo\neloeloeloeoleole\noeleoeleo\nleoleoleoe\nloleoelo\noeloeloeooleoel\noleoeloleo\neloeloeloeoleole\noeleoeleo\nleoleoleoe\nloleoelo\noeloeloeooleoel\noleoeloleo\neloeloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleooleoelol\nloleoeloeloeloeoloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleooleoe\noeloeloeloeooeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleooleoeloleoe\noeoleoeloleoeloeloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeleole\noeloeloeloeooeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeloleoelole\neloeloeoloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeleoleoleoleoelo\neoeloleoeloeloeloeooeloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeleoleoleoo\noeloeoleoeloeloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeleoleo\nloleoeloleoeloeloe\neoeloleoeloleoeloeloeloeo',
          like: '20',
          dislike: '15'
        },        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeleo\nloleoeloleoelole\noeloeloeloeoloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeleooleoeloleoelol\neloeloeloeooeloeloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leole\noeleoeleo\nleoleoleoe\nloleoelo\noeloeloeooleoel\noleoeloleo\neloeloeloeoleole\noeleoeleo\nleoleoleoe\nloleoelo\noeloeloeooleoel\noleoeloleo\neloeloeloeoleole\noeleoeleo\nleoleoleoe\nloleoelo\noeloeloeooleoel\noleoeloleo\neloeloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleooleoelol\nloleoeloeloeloeoloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleooleoe\noeloeloeloeooeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleooleoeloleoe\noeoleoeloleoeloeloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeleole\noeloeloeloeooeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeloleoelole\neloeloeoloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeleoleoleoleoelo\neoeloleoeloeloeloeooeloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeleoleoleoo\noeloeoleoeloeloeloeo',
          like: '20',
          dislike: '15'
        },
        {
          nick_name: '曾立功',
          pub_time: '2021/06/05',
          contents: 'leoleoeleoeleoleo\nloleoeloleoeloeloe\neoeloleoeloleoeloeloeloeo',
          like: '20',
          dislike: '15'
        },

      ],

    }
  },
  components: {
    CommentDialog,
  },
  methods: {
    showComment() {
      this.dialog_is_opening = true;
    },
  },
}
</script>

<style scoped>
.my-card {
  margin-bottom: 10px;
  border-radius: 15px;
}
.mycard-header {
  height: 50px;
}
.mycard-header-blue {
  background-color: #0696bb;
  background-image: linear-gradient(-45deg, rgba(255, 255, 255, .2) 20%, transparent 20%, transparent 50%, rgba(255, 255, 255, .2) 50%, rgba(255, 255, 255, .2) 80%, transparent 80%, transparent);
}
.mycard-header-yellow {
  background-color: #f7ba5e;
  background-image: linear-gradient(-45deg, rgba(255, 255, 255, .2) 20%, transparent 20%, transparent 50%, rgba(255, 255, 255, .2) 50%, rgba(255, 255, 255, .2) 80%, transparent 80%, transparent);
}
.mycard-header-green {
  background-color: #7dc758;
  background-image: linear-gradient(-45deg, rgba(255, 255, 255, .2) 20%, transparent 20%, transparent 50%, rgba(255, 255, 255, .2) 50%, rgba(255, 255, 255, .2) 80%, transparent 80%, transparent);
}
.bg-gray-stripe {
  background-color: rgba(255,255,255, 0.3);
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
