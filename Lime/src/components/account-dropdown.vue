<template>
  <div class="q-pa-md out-pad" style="border-radius: 15px">
    <q-btn-dropdown
      rounded
      flat
      dense
      color="secondary"
    >
      <div class="row no-wrap q-pa-md">
        <div class="column glass-pad">
          <div class="text-h6 q-mb-md">Settings</div>
          <q-toggle v-model="mobileData" label="Use Mobile Data" />
          <q-toggle v-model="bluetooth" label="Bluetooth" />
        </div>

        <q-separator vertical inset class="q-mx-lg" />

        <div class="column items-center">
          <q-avatar class="shadow-4"  size="72px">
            <img src="https://cdn.quasar.dev/img/boy-avatar.png">
          </q-avatar>

          <div class="text-subtitle1 q-mt-md q-mb-xs"> {{nick}} </div>

          <q-btn
            color="primary"
            label="Logout"
            push
            size="sm"
            v-close-popup
          />
        </div>
      </div>
    </q-btn-dropdown>
  </div>
</template>

<script>
export default {
  name: "account-dropdown",
  data () {
    return {
      mobileData: true,
      bluetooth: false
    }
  },
  props : ['avatar','nick'],
}
</script>

<style scoped>
.out-pad {
  /*backdrop-filter: blur(10px);*/
  padding: 0;
}
.glass-pad {
  backdrop-filter: blur(8px);
}
</style>
