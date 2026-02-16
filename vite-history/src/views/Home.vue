<script setup>
import { ref, onMounted, watch } from 'vue'
import axios from 'axios'
import * as echarts from 'echarts'

// 响应式数据
const currentYear = ref(1000) // 默认显示公元1000年
const eventsData = ref([])
const mapInstance = ref(null)

// 时间轴范围
const timelineRange = {
  min: -2000, // 公元前2000年
  max: 2024    // 公元2024年
}

// 模拟历史事件数据
const mockEvents = [
  { id: 1, year: -1046, name: '武王伐纣', location: [116.4, 39.9], type: 'war', description: '周武王灭商朝' },
  { id: 2, year: -221, name: '秦始皇统一', location: [108.9, 34.2], type: 'politics', description: '秦朝统一六国' },
  { id: 3, year: 618, name: '唐朝建立', location: [108.9, 34.2], type: 'politics', description: '李渊建立唐朝' },
  { id: 4, year: 1279, name: '南宋灭亡', location: [120.2, 30.2], type: 'war', description: '元朝灭南宋' },
  { id: 5, year: 1368, name: '明朝建立', location: [118.8, 32.1], type: 'politics', description: '朱元璋建立明朝' }
]

// 初始化地图
const initMap = () => {
  const chartDom = document.getElementById('china-map')
  if (!chartDom) return
  
  mapInstance.value = echarts.init(chartDom)
  
  // 注册中国地图
  echarts.registerMap('china', {
    // 这里需要真实的中国地图GeoJSON数据
    // 实际项目中需要从外部加载
    type: 'FeatureCollection',
    features: []
  })
  
  updateMap()
}

// 更新地图显示
const updateMap = () => {
  if (!mapInstance.value) return
  
  // 过滤当前年份的事件
  const currentEvents = mockEvents.filter(event => 
    Math.abs(event.year - currentYear.value) <= 50 // 显示前后50年的事件
  )
  
  const option = {
    title: {
      text: `中国历史地图 - 公元${currentYear.value > 0 ? currentYear.value : Math.abs(currentYear.value) + 'BC'}年`,
      left: 'center'
    },
    tooltip: {
      trigger: 'item',
      formatter: function(params) {
        if (params.componentType === 'series') {
          return `${params.data.name}<br/>${params.data.description}`
        }
        return params.name
      }
    },
    legend: {
      orient: 'vertical',
      right: 10,
      top: 'center',
      data: ['战争事件', '政治事件', '城池', '人口密度']
    },
    visualMap: {
      type: 'piecewise',
      orient: 'horizontal',
      left: 'center',
      bottom: 10,
      pieces: [
        {min: 1000000, label: '高密度', color: '#ff4d4f'},
        {min: 500000, max: 1000000, label: '中密度', color: '#ff7a45'},
        {min: 100000, max: 500000, label: '低密度', color: '#ffa940'},
        {max: 100000, label: '稀疏', color: '#ffd666'}
      ]
    },
    series: [
      {
        name: '中国地图',
        type: 'map',
        map: 'china',
        roam: true,
        emphasis: {
          label: {
            show: true
          }
        },
        itemStyle: {
          areaColor: '#f0f2f5',
          borderColor: '#d9d9d9'
        }
      },
      {
        name: '历史事件',
        type: 'scatter',
        coordinateSystem: 'geo',
        data: currentEvents.map(event => ({
          name: event.name,
          value: event.location,
          description: event.description,
          symbolSize: event.type === 'war' ? 20 : 15,
          itemStyle: {
            color: event.type === 'war' ? '#ff4d4f' : '#1890ff'
          }
        })),
        symbol: 'circle'
      }
    ]
  }
  
  mapInstance.value.setOption(option)
}

// 加载真实数据
const loadEventsData = async () => {
  try {
    const response = await axios.get(import.meta.env.VITE_API_BASE_URL + '/event/list')
    eventsData.value = response.data.content || []
  } catch (error) {
    console.error('加载事件数据失败:', error)
    eventsData.value = mockEvents // 使用模拟数据
  }
}

// 监听年份变化
watch(currentYear, () => {
  updateMap()
})

onMounted(() => {
  loadEventsData()
  setTimeout(initMap, 100) // 延迟初始化确保DOM已渲染
})

// 响应窗口大小变化
window.addEventListener('resize', () => {
  if (mapInstance.value) {
    mapInstance.value.resize()
  }
})

</script>

<template>
  <a-layout-content style="padding: 0">
    <!-- 地图容器 -->
    <div style="height: 70vh; position: relative;">
      <div id="china-map" style="width: 100%; height: 100%;"></div>
      
      <!-- 图例面板 -->
      <div style="position: absolute; top: 20px; right: 20px; background: rgba(255,255,255,0.9); padding: 16px; border-radius: 8px; box-shadow: 0 2px 8px rgba(0,0,0,0.1); min-width: 200px;">
        <h4 style="margin: 0 0 12px 0;">图例</h4>
        <div style="display: flex; align-items: center; margin-bottom: 8px;">
          <div style="width: 12px; height: 12px; background: #ff4d4f; border-radius: 50%; margin-right: 8px;"></div>
          <span>战争事件</span>
        </div>
        <div style="display: flex; align-items: center; margin-bottom: 8px;">
          <div style="width: 12px; height: 12px; background: #1890ff; border-radius: 50%; margin-right: 8px;"></div>
          <span>政治事件</span>
        </div>
        <div style="display: flex; align-items: center; margin-bottom: 8px;">
          <div style="width: 12px; height: 12px; background: #52c41a; border-radius: 50%; margin-right: 8px;"></div>
          <span>城池位置</span>
        </div>
      </div>
    </div>
    
    <!-- 时间轴 -->
    <div style="background: #fff; padding: 24px; border-top: 1px solid #d9d9d9;">
      <div style="display: flex; align-items: center; gap: 16px;">
        <span style="min-width: 80px;">年代:</span>
        <a-slider 
          v-model:value="currentYear" 
          :min="timelineRange.min" 
          :max="timelineRange.max" 
          style="flex: 1;"
          :tooltip="{ formatter: (value) => value > 0 ? `${value}年` : `${Math.abs(value)}BC` }"
        />
        <span style="min-width: 100px;">
          {{ currentYear > 0 ? `公元${currentYear}年` : `公元前${Math.abs(currentYear)}年` }}
        </span>
      </div>
    </div>
  </a-layout-content>
</template>

<style scoped>
#china-map {
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
}
</style>
