<template>
  <div class="container">
<!--<img src="~assets/bg.png">-->
    <video class="bg-video" autoplay loop muted>
      <source src="~assets/rain-station.mp4" type="video/mp4"/>
      Your browser does not support the video tag.
    </video>
    <div id="content-pad" class="glass row" v-bind:class="{ 'glass row' : islogin, 'glass-register row' : !islogin }">
      <transition name="fade" mode = "in-out">
        <div id="register-pad" style=" border-radius:9px 0 0 9px; " class="col-8 pad-item bg-secondary" v-show="!islogin">
          <div class="q-pa-md" style="max-width: 500px; margin-top: 20px; margin-left: auto; margin-right: auto">
            <q-form
              @submit="onSubmit"
              @reset="onReset"
              class="q-gutter-md"
              style="margin: 0 auto"
            >
              <q-input
                dense
                filled
                v-model="account"
                label="邮箱"
                hint="输入邮箱地址"
                type="email"
                lazy-rules
                :rules="[ val => val && val.length > 0 || '请输入邮箱地址']"
              >
                <template v-slot:prepend>
                  <q-icon name="email" />
                </template>
                <template v-slot:after>
                  <q-select dense standout style="min-width: 100px" v-model="type" :options="options" label="作为？"/>
                </template>
              </q-input>
              <q-input
                dense
                filled
                v-model="validate_num"
                label="验证码"
                hint="输入验证码"
                lazy-rules
                :rules="[ val => val && val.length > 0 || '请输入收到的验证码']"
              >
                <template v-slot:prepend>
                  <q-icon name="verified_user" />
                </template>
                <template v-slot:after>
                  <q-btn push color="primary" label="发送"/>
                </template>
              </q-input>
              <q-input
                dense
                filled
                v-model="nick_name"
                label="昵称"
                hint="输入预设昵称"
                lazy-rules
                :rules="[ val => val && val.length > 0 || '请输入预设昵称']"
                v-if="type === '个人'"
              >
                <template v-slot:prepend>
                  <q-icon name="badge" />
                </template>
              </q-input>
              <q-input
                dense
                filled
                v-model="ofc_name"
                label="机构名称"
                hint="输入机构名称"
                lazy-rules
                :rules="[ val => val && val.length > 0 || '请输入机构名称']"
                v-if="type === '官方'"
              >
                <template v-slot:prepend>
                  <q-icon name="home_work" />
                </template>
              </q-input>
              <q-input
                dense
                filled
                v-model="register_password"
                :type="isPwd ? 'password' : 'text'"
                label="密码"
                hint="输入密码"
                lazy-rules
                :rules="[ val => val && val.length > 0 || '请输入密码']"
              >
                <template v-slot:prepend>
                  <q-icon name="lock" />
                </template>
                <template v-slot:append>
                  <q-icon
                    :name="isPwd ? 'visibility_off' : 'visibility'"
                    class="cursor-pointer"
                    @click="isPwd = !isPwd"
                  />
                </template>
              </q-input>
              <q-input
                dense
                filled
                v-model="register_password_again"
                :type="isPwd ? 'password' : 'text'"
                label="确认密码"
                hint="再次输入密码"
                lazy-rules
                :rules="[ val => val && val.length > 0 || '请再次输入密码']"
              >
                <template v-slot:prepend>
                  <q-icon name="lock" />
                </template>
                <template v-slot:append>
                  <q-icon
                    :name="isPwd ? 'visibility_off' : 'visibility'"
                    class="cursor-pointer"
                    @click="isPwd = !isPwd"
                  />
                </template>
              </q-input>
              <div class="q-gutter-sm">
                <q-checkbox style="color: #01a5a2" dense v-model="register_accept" label="点击同意我们的协议"/>
              </div>
              <div>
                <q-btn color="primary" icon-right="send" label="注册" type="submit"/>
                <q-btn label="已有账号？去登录" color="primary" @click="switchLogin" flat class="q-ml-sm" />
              </div>
            </q-form>
          </div>
        </div>
      </transition>
      <div id="glass-pad" class="col-4 column" style="padding: 10px">
            <div class="col-1" style="padding-top: 20px; text-shadow: -1px 3px 3px #656B79; font-size: 28px; color: #034e47; font-family: 'Bookman Old Style',serif; font-style: italic; margin: 0 auto;">
              {{title}}
            </div>
            <div class="logo col-10 column">
              <div class="logo-text" style="line-height: 150px">
                LIME
              </div>
            </div>
        <q-space />
            <div class="col-1" style="font-size: 5px; color: #d7fffb; margin: 0 auto;">
              Design By @Akira
            </div>
        </div>
      <transition name="fade" mode = "in-out">
        <div id="login-pad" style="border-radius:0 9px 9px 0;" class="col-8 pad-item bg-secondary" v-show="islogin">
          <div class="q-pa-md" style="max-width: 382px; margin-top: 20px; margin-left: auto; margin-right: auto">
            <q-form
              @submit="onSubmit"
              @reset="onReset"
              class="q-gutter-md"
              style="margin: 0 auto;"
            >
              <q-input
                filled
                outlined size="xs"
                v-model="account"
                label="用户名"
                hint="输入用户名（邮箱）"
                type="email"
                lazy-rules
                :rules="[ val => val && val.length > 0 || '请输入用户名']"
              >
                <template v-slot:prepend>
                  <q-icon name="account_circle" />
                </template>
                <template v-slot:after>
                  <q-select standout style="min-width: 100px" v-model="type" :options="options" label="作为？"/>
                </template>
              </q-input>
              <q-input
                filled
                outlined
                v-model="password"
                :type="isPwd ? 'password' : 'text'"
                label="密码"
                hint="输入密码"
                lazy-rules
                :rules="[ val => val && val.length > 0 || '请输入密码']"
              >
                <template v-slot:prepend>
                  <q-icon name="lock" />
                </template>
                <template v-slot:append>
                  <q-icon
                    :name="isPwd ? 'visibility_off' : 'visibility'"
                    class="cursor-pointer"
                    @click="isPwd = !isPwd"
                  />
                </template>
              </q-input>

              <q-toggle v-model="login_remember_me" label="记住我" />
              <div>
                <q-btn color="primary" icon="login" label="登录" type="submit"/>
                <q-btn label="没有账号？去注册" color="primary" @click="switchLogin" flat class="q-ml-sm" />
              </div>
            </q-form>
          </div>
        </div>
      </transition>
    </div>
  </div>
</template>

<script>
export default {
name: "Login",
  data () {
    return {
      account: '',
      password: '',
      register_password: '',
      register_password_again: '',
      validate_num: '',
      nick_name: '',
      ofc_name: '',
      isPwd: true,
      register_accept: false,
      login_remember_me: false,
      islogin: true,
      type: '个人',
      options: [
        '官方', '个人'
      ],
      title: '~Login~',
    }
  },

  methods: {
    onSubmit () {
      // if (this.register_accept !== true) {
      //   this.$q.notify({
      //     color: 'red-5',
      //     textColor: 'white',
      //     icon: 'warning',
      //     message: 'You need to accept the license and terms first'
      //   })
      // }
      // else {
      //   this.$q.notify({
      //     color: 'green-4',
      //     textColor: 'white',
      //     icon: 'cloud_done',
      //     message: 'Submitted'
      //   })
      // }

      this.$axios
        .post('/login',{
          username: this.account,
          type: this.type,
          password: this.password
        })
        .then(successResponse => {
          alert(successResponse.data.code);
          // if(successResponse.data.code === '666') {
          //     alert("")
          // }
        })
        .catch(failResponse => {
          alert(failResponse);
        })
    },

    onReset () {
      this.name = null
      this.age = null
      this.accept = false
    },

    switchLogin() {
      this.islogin = !this.islogin;
      if(this.islogin === true) {
        this.title = '~Login~';
      } else {
        this.title = '~Register~';
      }
    },
  }
}
</script>

<style scoped>
.glass {
  position: absolute;
  min-width: 615px;
  min-height: 398px;
  /*width: 40%;*/
  /*height: 55%;*/
  border-radius: 10px;
  /*border: 2px outset #74bfb5;*/
  box-shadow: -3px 3px 20px #232424;
  backdrop-filter: blur(6px);
  background: rgba(49,48,48, 0.1);
}

.glass-register {
  min-width: 850px;
  min-height: 550px;
}

#content-pad {
  transition: all .6s;
}
.container {
  width: 100vw;
  height: 100vh;
  display: grid;
  place-items: center;
  position: relative;
  z-index:1;
}

.q-pa-md {
  width: 100%;
  height: 100%;
  object-fit: cover;
  position: absolute;
}

video{
  position: fixed;
  right: 0px;
  bottom: 0px;
  min-width: 100%;
  min-height: 100%;
  max-height: 120%;
  height: auto;
  width: auto;
  z-index:-1;
  /*加滤镜*/
  /*filter: blur(15px); //背景模糊设置*/
  /*-webkit-filter: grayscale(100%);*/
  /*filter:grayscale(100%); //背景灰度设置*/
  /*z-index:-11*/
}
source{
  min-width: 100%;
  min-height: 100%;
  height: auto;
  width: auto;
}
.logo {
  height: 150px;
  width: 150px;
  margin-left: auto;
  margin-right: auto;
  margin-top: 100px;
  border-radius
  :
    75px;
  background
  :
linear-gradient(225deg, rgba(197,248,235,0),rgba(197,248,235,0.2), rgba(197, 246, 234, 0.9));
  box-shadow
  :
    /*inset -20px 20px 30px rgba(197,248,235,1), inset 20px -20px 30px rgba(197,248,235,0.1)*/
    -20px 20px 40px rgba(73,76,76,1), 20px -20px 40px rgba(205,226,226,1);  /*border: 3px inset #d9f8ef;*/
  text-align: center;

}
.logo-text {
  color: white;
  font-size: 34px;
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

.fade-enter-active {
  transition: all .6s ease;
}
.fade-leave-active {
  transition: all .6s ease;
}
.fade-enter, .fade-leave-to
  /* .slide-fade-leave-active for below version 2.1.8 */ {
  /*transform: translateX(10px);*/
  width: 0;
  opacity: 0;
}

</style>
