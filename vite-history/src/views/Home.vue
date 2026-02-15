<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'

onMounted(() => {
 axios.get(import.meta.env.VITE_API_BASE_URL+'/event/list?name=spring').then(res => {
      console.log(res);
    });
})

</script>

<template>
  <a-layout-content style="padding: 0 50px">
      <a-breadcrumb style="margin: 16px 0">
        <a-breadcrumb-item>Home</a-breadcrumb-item>
        <a-breadcrumb-item>List</a-breadcrumb-item>
        <a-breadcrumb-item>App</a-breadcrumb-item>
      </a-breadcrumb>
      <div :style="{ background: '#fff', padding: '24px', minHeight: '280px' }">Content</div>
    </a-layout-content>
</template>
