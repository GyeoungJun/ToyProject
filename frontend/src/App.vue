<template>
  <div id="app">
    <!-- 추가된 헤더 컴포넌트 사용 -->
    <Header></Header>
    
    <router-view> </router-view>

    <!-- 추가된 풋터 컴포넌트 사용 -->
    <Footer></Footer>
  </div>
</template>

<script>
import Header from './components/common/Header';
import HelloWorld from './components/HelloWorld.vue'
import Footer from './components/common/Footer';

export default {
  name: 'App',
  components: {
    Header
    , HelloWorld
    , Footer
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
