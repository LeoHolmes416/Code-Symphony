<template>
<div>
  <video class="bg-video" autoplay loop muted>
    <source src="~assets/rain-station.mp4" type="video/mp4"/>
    Your browser does not support the video tag.
  </video>
  <div class="container-wrap">
    <div class="container">
      <div class="more"></div>
      <div class="more"></div>
      <div class="more"></div>
      <div class="more"></div>
      <div class="item">
        <img src="~assets/circle.png">
      </div>
    </div>
  </div>
</div>
</template>
<script>
export default {
  name: "MatchFriends"
}
</script>

<style scoped>
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
.rotate-center {
  -webkit-animation: rotate-center 3s linear infinite both;
  animation: rotate-center 3s linear infinite both;
}
@-webkit-keyframes rotate-center {
  0% {
    -webkit-transform: rotate(0);
    transform: rotate(0);
  }
  100% {
    -webkit-transform: rotate(360deg);
    transform: rotate(360deg);
  }
}
@keyframes rotate-center {
  0% {
    -webkit-transform: rotate(0);
    transform: rotate(0);
  }
  100% {
    -webkit-transform: rotate(360deg);
    transform: rotate(360deg);
  }
}
.container-wrap {
  width: 750px;
  height: 1000px;
  display: block;
  margin: 50px auto 0 auto;
  overflow: hidden;
}

.container {
  position: relative;
  width: 300px;
  height: 300px;
  margin: 0 auto;
  border-radius: 50%;
  margin-top: 200px;
}

.container .more {
  position: absolute;
  opacity: 1;
  left: 0;
  right: 0;
  top: 0;
  bottom: 0;
  margin: auto;
  width: 300px;
  height: 300px;
  border-radius: 50%;
  border: 1px solid black;
  animation: routerView 4s linear 0s infinite;
}
.container .more::after {
  content: "";
  position: absolute;
  top: -4px;
  left: 50%;
  width: 6px;
  height: 6px;
  overflow: hidden;
  border-radius: 5px;
  background-color: orangered;
}
.container .more:nth-child(2) {
  animation-delay: 1s;
}

.container .more:nth-child(3) {
  animation-delay: 2s;
}

.container .more:nth-child(4) {
  animation-delay: 3s;
}

.item {
  width: 300px;
  height: 300px;
  border-radius: 50%;
  overflow: hidden;
}

.item img {
  width: 100%;
  height: 100%;
  animation: rotation 12s linear infinite;
}

@keyframes rotation {
  from {
    transform: rotate(0deg);
  }

  to {
    transform: rotate(360deg);
  }
}

@keyframes routerView {
  0%{
    opacity: 1;
    transform: rotate(0deg) scale(1);
  }
  25%{
    opacity: 0.75;
    transform: rotate(72deg) scale(1.25);
  }
  50%{
    opacity: 0.5;
    transform: rotate(144deg) scale(1.5);
  }
  75%{
    opacity: 0.25;
    transform: rotate(216deg) scale(1.75);
  }
  100%{
    opacity: 0;
    transform: rotate(360deg) scale(2);
  }
}
</style>
