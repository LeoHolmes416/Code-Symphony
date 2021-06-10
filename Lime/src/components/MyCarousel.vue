<template>
  <div class="q-pa-md" style="padding: 0;">
    <q-carousel
      swipeable
      animated
      transition-prev="jump-right"
      transition-next="jump-left"
      v-model="slide"
      :autoplay="autoplay"
      ref="carousel"
      infinite
      style="border-radius: 15px"
      class="shadow-2"
    >
      <q-carousel-slide :name="1" img-src="https://cdn.quasar.dev/img/mountains.jpg">
        <div class="absolute-bottom custom-caption">
          <div class="text-h2">First stop</div>
          <div class="text-subtitle1">Mountains</div>
        </div>
      </q-carousel-slide>
      <q-carousel-slide :name="2" img-src="https://cdn.quasar.dev/img/parallax1.jpg">
        <div class="absolute-bottom custom-caption">
          <div class="text-h2">First stop</div>
          <div class="text-subtitle1">Mountains</div>
        </div>
      </q-carousel-slide>
      <q-carousel-slide :name="3" img-src="https://cdn.quasar.dev/img/parallax2.jpg">
        <div class="absolute-bottom custom-caption">
          <div class="text-h2">First stop</div>
          <div class="text-subtitle1">Mountains</div>
        </div>
      </q-carousel-slide>
      <q-carousel-slide :name="4" img-src="https://cdn.quasar.dev/img/quasar.jpg">
        <div class="absolute-bottom custom-caption">
          <div class="text-h2">First stop</div>
          <div class="text-subtitle1">Mountains</div>
        </div>
      </q-carousel-slide>

      <template v-slot:control>
        <q-carousel-control
          position="top-right"
          :offset="[18, 18]"
          class="text-white rounded-borders"
          style="background: rgba(0, 0, 0, .3); padding: 4px 8px;"
        >
          <q-toggle dense dark color="#01a5a2" v-model="autoplay" label="Auto Play" />
        </q-carousel-control>

        <q-carousel-control
          position="bottom-right"
          :offset="[18, 18]"
          class="q-gutter-xs"
        >
          <q-btn
            push round dense class="bg-primary" text-color="black" icon="arrow_left"
            @click="$refs.carousel.previous()"
          />
          <q-btn
            push round dense class="bg-primary" text-color="black" icon="arrow_right"
            @click="$refs.carousel.next()"
          />
        </q-carousel-control>
      </template>
    </q-carousel>
  </div>
</template>
<script>
export default {
  name: "MyCarousel",
  data () {
    return {
      slide: '1',
      autoplay: true
    }
  }
}
</script>

<style lang="sass" scoped>
.custom-caption
  text-align: center
  padding: 12px
  color: white
  background-color: rgba(0, 0, 0, .3)
</style>
