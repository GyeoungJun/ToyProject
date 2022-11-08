<template>
	<div>
		<h2>게시판 리스트</h2>

		<div class="searchWrap">
			<input type="text"  @keyup.enter="" /><a href="javascript:;" class="btnSearch btn">검색</a>
		</div>
		<div class ="listWrap">
			<table class = "tbList">
				<colgroup>
					<col width="6%" />
					<col width="*" />
					<col width="10%" />
					<col width="15%" />
				</colgroup>
				<tr>
					<th>no</th>
					<th>제목</th>
					<th>글쓴이</th>
					<th>등록 날짜</th>
				</tr>
				<tr v-for = "(item, index) in a" v-bind:key="index">
					<th scope = "row">{{index+1}}</th>
					<td class = "txt_left"><a href="javascript:;" @click="fnView(`${item.id}`)">{{item.title}}</a></td>
					<td>{{item.register_id}}</td>
					<td>{{item.register_time.substring(0,10)}}</td>
				</tr>
			</table>
		</div>

		<div class="btnRightWrap">
			<a @click="fnAdd" href="javascript:;" class="btn">등록</a>
		</div>
	</div>

</template>

<script>
export default {
    name : 'App',
	data(){
		return{
			body : '',
			id : '',
			title : '',
			content : '',
			register_id : '',
			register_time : '',
			a : ''
		}
	},

	mounted() {
		this.getList()

	},

	methods:{
		getList() {
			this.body = {
				id : this.id
			}
			this.$axios.get('/api/board', {params : this.body})
			.then((res)=>{
                this.a = res.data;
			})
			.then((err)=>{
				console.log(err);
			})
		}

		,fnAdd(){
			this.$router.push("./write");
		}

		,fnView(id){
			this.body.id = id;
			this.$router.push({path:'./view', query : this.body});
		}
	}
}
</script>

<style scoped>
.searchWrap{border:1px solid #888; border-radius:5px; text-align:center; padding:20px 0; margin-bottom:40px;}
	.searchWrap input{width:60%; height:36px; border-radius:3px; padding:0 10px; border:1px solid #888;}
	.searchWrap .btnSearch{display:inline-block; margin-left:10px;}
	.tbList th{border-top:1px solid #888;}
	.tbList th, .tbList td{border-bottom:1px solid #eee; padding:5px 0;}
	.tbList td.txt_left{text-align:left;}
	.btnRightWrap{text-align:right; margin:10px 0 0 0;}
</style>