<template>
  <div id="app">
    <!-- 추가된 헤더 컴포넌트 사용 -->
    <Header></Header>

    <div class = "container">
      <router-view></router-view>
    </div>

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
html,body{padding:0; margin:0;}
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
h1{color:#43b984;}
table{width:100%; border-collapse:collapse;}
.wrap{width:100%;}
.container{width:800px; margin:0 auto;}
a{text-decoration:none;}
.btn{padding:10px; background:#34445c; color:#fff;}
</style>
