import Vue from 'vue'
import axios from 'axios'

Vue.prototype.$axios = axios

import mavonEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'

// use
Vue.use(mavonEditor)

// 一鸣的wifi
// axios.defaults.baseURL = 'http://192.168.43.50:8443/api'
// 我的wifi
// axios.defaults.baseURL = 'http://192.168.43.89:8443/api'
// 宿舍网
axios.defaults.baseURL = 'http://192.168.1.41:8443/api'


new Vue({
  'el': '#main',
  data() {
    return { value: '' }
  }
})
