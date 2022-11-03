<template>
	<div>
		<h2>게시판 리스트</h2>
		<a href="javascript:;" @click="getList">GET 방식 데이터 접근</a>
        <p>{{a}}</p>
	</div>
</template>

<script>
export default {
    name : 'App',
    data: () => ({
        a: ''
    }),

	methods:{
		getList() {
			this.$axios.get('/api/board')
			.then((res)=>{
				console.log(res);
                this.a = res.data
			})
			.then((err)=>{
				console.log(err);
			})
		}
	}
}
</script>

<style scoped>

</style>