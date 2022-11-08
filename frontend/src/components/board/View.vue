<template>
	<div>
		<h1>게시판 상세보기</h1>
		<div class="AddWrap">
			<form>
				<table class="tbAdd">
					<colgroup>
						<col width="15%" />
						<col width="*" />
					</colgroup>
					<tr>
						<th>제목</th>
						<td>{{title}}</td>
					</tr>
					<tr>
						<th>작성자</th>
						<td class="register_id" v-html="register_id"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td class = "txt_cont" v-html = "content"></td>
					</tr>
				</table>
			</form>
		</div>

		<div class="btnWrap">
			<a href="javascript:;" @click="fnList" class="btn">목록</a>
			<a href="javascript:;" @click="fnUpdate" class="btnAdd btn">수정</a>
			<a v-if="id" href="javascript:;" @click="fnDeleteProc" class="btnDelete btn">삭제</a>
		</div>	
	</div>
</template>

<script>
export default {
    name : 'App',
	data() {
		return {
			body : this.$route.query,
			title : '',
			content : '',
			register_id : '',
			view : '',
			id : this.$route.query.id
		}
	},

	mounted() {
		this.getView()
	},

	methods:{
		getView() {
			this.$axios.get('/api/view?id='+ this.body.id)
			.then((res)=>{
                this.view = res.data[0];
				this.title = this.view.title;
				this.register_id = this.view.register_id;
				this.content = this.view.content.replace(/(\n)/g,'<br/>');
			})
			.then((err)=>{
				console.log(err);
			})
		},

		fnList(id){
			delete this.body.id;
			this.$router.push({path:'./list', query:this.body})
		},

		fnUpdate(){
			this.$router.push({path:'./update', query:this.body});
		},

		fnDeleteProc(){
			if(confirm("삭제하시겠습니까?")){
				this.$axios.delete('http://localhost:8080/api/delete?id=' + this.body.id)
				.then((res)=>{
					if(res.data.result == "success") {
						alert("삭제되었습니다.");
						this.fnList();
					} else {
						alert("실행중 실패했습니다.\n다시 이용해 주세요.");
					}
				})
				.catch((err)=>{
					console.log(err);
				})
			}
		}
	}
}
</script>

<style scoped>
	.tbAdd{border-top:1px solid #888;}
	.tbAdd th, .tbAdd td{border-bottom:1px solid #eee; padding:5px 0; }
	.tbAdd td{padding:10px 10px; box-sizing:border-box; text-align:left;}
	.tbAdd td.txt_cont{height:300px; vertical-align:top;}
	.btnWrap{text-align:center; margin:20px 0 0 0;}
	.btnWrap a{margin:0 10px;}
	.btnAdd {background:#43b984}
	.btnDelete{background:#f00;}
</style>