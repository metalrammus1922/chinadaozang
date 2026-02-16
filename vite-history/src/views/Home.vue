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

// 完整的中国主要城市坐标数据
const chinaCities = [
  { name: '北京', value: [116.4, 39.9], pinyin: 'beijing' },
  { name: '上海', value: [121.47, 31.23], pinyin: 'shanghai' },
  { name: '广州', value: [113.23, 23.16], pinyin: 'guangzhou' },
  { name: '深圳', value: [114.07, 22.62], pinyin: 'shenzhen' },
  { name: '杭州', value: [120.19, 30.26], pinyin: 'hangzhou' },
  { name: '南京', value: [118.78, 32.04], pinyin: 'nanjing' },
  { name: '西安', value: [108.95, 34.27], pinyin: 'xian' },
  { name: '成都', value: [104.06, 30.67], pinyin: 'chengdu' },
  { name: '武汉', value: [114.31, 30.52], pinyin: 'wuhan' },
  { name: '重庆', value: [106.54, 29.59], pinyin: 'chongqing' },
  { name: '天津', value: [117.2, 39.13], pinyin: 'tianjin' },
  { name: '苏州', value: [120.62, 31.32], pinyin: 'suzhou' },
  { name: '郑州', value: [113.65, 34.76], pinyin: 'zhengzhou' },
  { name: '长沙', value: [113, 28.21], pinyin: 'changsha' },
  { name: '沈阳', value: [123.38, 41.8], pinyin: 'shenyang' },
  { name: '青岛', value: [120.33, 36.07], pinyin: 'qingdao' },
  { name: '大连', value: [121.62, 38.92], pinyin: 'dalian' },
  { name: '厦门', value: [118.1, 24.46], pinyin: 'xiamen' },
  { name: '昆明', value: [102.73, 25.04], pinyin: 'kunming' },
  { name: '哈尔滨', value: [126.63, 45.75], pinyin: 'haerbin' }
]

// 加载真实的中国地图数据
const loadChinaMap = async () => {
  try {
    // 尝试从多个数据源加载中国地图
    const sources = [
      'https://geo.datav.aliyun.com/areas_v3/bound/100000_full.json',
      'https://cdn.jsdelivr.net/npm/echarts@5/map/json/china.json'
    ]
    
    for (const source of sources) {
      try {
        const response = await fetch(source)
        if (response.ok) {
          const chinaGeoJSON = await response.json()
          echarts.registerMap('china', chinaGeoJSON)
          console.log('成功加载中国地图数据:', source)
          return true
        }
      } catch (error) {
        console.warn('地图数据源加载失败:', source, error)
      }
    }
    
    // 如果所有数据源都失败，使用内置的简化地图
    throw new Error('所有地图数据源都加载失败')
    
  } catch (error) {
    console.warn('使用简化中国地图:', error)
    // 简化版中国地图轮廓
    const simplifiedChina = {
      type: 'FeatureCollection',
      features: [
        {
          type: 'Feature',
          properties: { name: '中国' },
          geometry: {
            type: 'Polygon',
            coordinates: [[
              [73.66, 18.17], [135.05, 18.17], [135.05, 53.56], [73.66, 53.56], [73.66, 18.17]
            ]]
          }
        }
      ]
    }
    echarts.registerMap('china', simplifiedChina)
    return false
  }
}

// 初始化地图
const initMap = async () => {
  const chartDom = document.getElementById('china-map')
  if (!chartDom) return
  
  mapInstance.value = echarts.init(chartDom)
  
  // 加载中国地图数据
  await loadChinaMap()
  
  updateMap()
}

// 更新地图显示
const updateMap = () => {
  if (!mapInstance.value) return
  
  // 过滤当前年份的事件
  const currentEvents = mockEvents.filter(event => 
    Math.abs(event.year - currentYear.value) <= 100 // 显示前后100年的事件
  )
  
  const option = {
    backgroundColor: '#1e1e1e',
    title: {
      text: `中国历史地图 - ${currentYear.value > 0 ? '公元' + currentYear.value + '年' : '公元前' + Math.abs(currentYear.value) + '年'}`,
      left: 'center',
      textStyle: {
        color: '#fff',
        fontSize: 20
      }
    },
    tooltip: {
      trigger: 'item',
      backgroundColor: 'rgba(0,0,0,0.8)',
      borderColor: '#555',
      textStyle: {
        color: '#fff'
      },
      formatter: function(params) {
        if (params.componentType === 'series') {
          if (params.seriesType === 'scatter') {
            return `<div style="padding: 5px;">
              <strong style="color: #ffd700;">${params.data.name}</strong><br/>
              ${params.data.description}<br/>
              <span style="color: #ccc;">坐标: ${params.data.value[0]}, ${params.data.value[1]}</span>
            </div>`
          }
        }
        return params.name
      }
    },
    legend: {
      orient: 'vertical',
      right: 20,
      top: 'center',
      textStyle: {
        color: '#fff'
      },
      data: ['战争事件', '政治事件', '主要城市']
    },
    geo: {
      map: 'china',
      roam: true,
      zoom: 1,
      center: [104.0, 36.0],
      label: {
        show: true,
        color: '#fff',
        fontSize: 10
      },
      itemStyle: {
        areaColor: '#2f3640',
        borderColor: '#57606f',
        borderWidth: 0.5
      },
      emphasis: {
        label: {
          show: true,
          color: '#fff'
        },
        itemStyle: {
          areaColor: '#4a5568'
        }
      },
      select: {
        label: {
          show: true,
          color: '#fff'
        },
        itemStyle: {
          areaColor: '#4a5568'
        }
      }
    },
    series: [
      {
        name: '主要城市',
        type: 'effectScatter',
        coordinateSystem: 'geo',
        data: chinaCities,
        symbolSize: function(val) {
          return val[2] / 1000;
        },
        showEffectOn: 'render',
        rippleEffect: {
          brushType: 'stroke'
        },
        hoverAnimation: true,
        label: {
          formatter: '{b}',
          position: 'right',
          show: true
        },
        itemStyle: {
          color: '#46bee9',
          shadowBlur: 10,
          shadowColor: '#333'
        },
        zlevel: 1
      },
      {
        name: '战争事件',
        type: 'scatter',
        coordinateSystem: 'geo',
        data: currentEvents.filter(e => e.type === 'war').map(event => ({
          name: event.name,
          value: event.location,
          description: event.description,
          symbolSize: 15
        })),
        symbol: 'pin',
        symbolSize: 30,
        label: {
          show: true,
          formatter: '{b}',
          color: '#fff',
          backgroundColor: 'rgba(255,0,0,0.7)',
          padding: [2, 4],
          borderRadius: 2
        },
        itemStyle: {
          color: '#ff4d4f'
        },
        emphasis: {
          label: {
            show: true
          }
        }
      },
      {
        name: '政治事件',
        type: 'scatter',
        coordinateSystem: 'geo',
        data: currentEvents.filter(e => e.type === 'politics').map(event => ({
          name: event.name,
          value: event.location,
          description: event.description,
          symbolSize: 12
        })),
        symbol: 'circle',
        symbolSize: 25,
        label: {
          show: true,
          formatter: '{b}',
          color: '#fff',
          backgroundColor: 'rgba(24,144,255,0.7)',
          padding: [2, 4],
          borderRadius: 2
        },
        itemStyle: {
          color: '#1890ff'
        }
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
