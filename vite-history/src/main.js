import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import router from './router'
import Antd from 'ant-design-vue'
import 'ant-design-vue/dist/reset.css'
import * as Icons from '@ant-design/icons-vue';

import axios from 'axios';

axios.defaults.baseURL = import.meta.env.VITE_API_BASE_URL;

/**
 * axios拦截器
 */
axios.interceptors.request.use(
    config => {
        console.log('请求参数：',config);
        return config;
    },
    error => {
        return Promise.reject(error);
    }
);
axios.interceptors.response.use(
    response => {
        console.log('响应参数：',response);
        return response;
    },
    error => {
        return Promise.reject(error);
    }
)

const app= createApp(App);
app.use(router).use(Antd).mount('#app');

//使用全局图标
const icons = Icons;
for (const i in icons) {
    app.component(i, icons[i]);
}

console.log('环境：',import.meta.env.MODE);
console.log('服务端：',import.meta.env.VITE_API_BASE_URL);
