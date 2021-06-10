<template>
  <div class="q-pa-md root-pad">
    <q-layout view="hHh Lpr lff">
      <q-header elevated class="my-header" style="border-radius: 15px">
        <q-toolbar class="" style="background-image: linear-gradient(to right, #00adb5, #a8f6f6, #00adb5);">
          <q-btn flat round icon="menu" class="q-mr-sm" @click="drawer = !drawer"/>

          <q-toolbar-title class="header-title" style="max-width: 250px; margin-right: 5px;"><q-img src="~assets/logo.png"/></q-toolbar-title>

          <q-input class="GPL__toolbar-input" dense standout="bg-primary" v-model="search" placeholder="Search">
            <template v-slot:prepend>
              <q-icon v-if="search === ''" name="search" />
              <q-icon v-else name="clear" class="cursor-pointer" @click="search = ''" />
            </template>
          </q-input>

          <q-space />

          <q-btn stretch flat label="Link" />

          <q-separator dark vertical inset />

          <q-btn stretch flat label="Link" />

          <q-separator dark vertical inset />

          <q-btn stretch flat label="Link" />

          <q-btn dense rounded flat size="20px" style="color: #393e46; font-size: 15px">
            曾立功
            <q-avatar round size="55px">
              <img src="https://cdn.quasar.dev/img/boy-avatar.png" style="border: 3px solid white">
            </q-avatar>
            <q-tooltip>账户信息</q-tooltip>
          </q-btn>
          <MyAvatar nick="曾立功"/>
        </q-toolbar>
      </q-header>

      <q-drawer
        v-model="drawer"
        show-if-above
        :mini="miniState"
        @mouseover="miniState = false"
        @mouseout="miniState = true"
        mini-to-overlay
        :width="200"
        :breakpoint="500"
        :content-style="{}"
        bordered
      >
          <q-list padding class="menu-list">
            <q-item clickable v-ripple :active="active_items[0]" @click="router_push(0,'index')">
              <q-item-section avatar>
                <q-icon name="inbox" />
              </q-item-section>

              <q-item-section>
                主页
              </q-item-section>
            </q-item>

            <q-item clickable v-ripple :active="active_items[1]" @click="router_push(1,'treehole')">
              <q-item-section avatar>
                <q-icon name="star" />
              </q-item-section>

              <q-item-section>
                树洞
              </q-item-section>
            </q-item>

            <q-item clickable v-ripple :active="active_items[2]">
              <q-item-section avatar>
                <q-icon name="send" />
              </q-item-section>

              <q-item-section>
                匹配
              </q-item-section>
            </q-item>

            <q-item clickable v-ripple :active="active_items[3]">
              <q-item-section avatar>
                <q-icon name="drafts" />
              </q-item-section>

              <q-item-section>
                大本营
              </q-item-section>
            </q-item>

            <q-separator />

            <q-item clickable v-ripple :active="active_items[4]">
              <q-item-section avatar>
                <q-icon name="drafts" />
              </q-item-section>

              <q-item-section>
                好友
              </q-item-section>
            </q-item>
          </q-list>
      </q-drawer>

      <q-page-container>
        <router-view/>
      </q-page-container>
    </q-layout>
  </div>
</template>

<script>
import MyAvatar from "components/account-dropdown"
export default {
  name: 'MainLayout',
  components: {
    MyAvatar
  },
  data () {
    return {
      drawer: false,
      miniState: true,
      active_items: [
        false,false,false,false,false
      ]
    }
  },
  methods: {
    switchDark () {
      this.$q.dark.toggle();
    },
    router_push(index, path) {
      this.active_items.forEach((item, index) => {this.active_items[index] = false});
      this.active_items[index] = true;
      this.$router.push({path: "/" + path});
    },

  },
}
</script>
<style scoped>
.menu-list>.q-item{
  border-radius: 0 15px 15px 0;
  font-size: 17px;
  text-shadow: -2px 2px 3px #d3ece4;
}
.my-header{
  border-radius: 15px;
}
.header-title {
  color: white;
  font-size: 32px;
  /*font-weight: bold;*/
  font-family: "Comic Sans MS", cursive, cursive,cursive;
  letter-spacing: 6px;
  /*background-image: url(~assets/bg-Lime.jpeg);*/
  /*-webkit-background-clip: text;*/
  /*-webkit-text-stroke: 1px #182121;*/
  /*-webkit-text-fill-color: transparent;*/
  text-shadow:
    0 0 10px #14ecd7,
    0 0 20px #12d7c4,
    0 0 50px #10bdac,
    0 0 100px #0c9386
}

.q-drawer {
  background: rgba(0,0,0,0.5);
}
.root-pad {
  background: url("~assets/bg1.png") bottom center no-repeat fixed;
  background-size: 100% 100%;

}
</style>
