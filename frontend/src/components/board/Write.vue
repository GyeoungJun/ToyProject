<template>
    <div>
        <h1>게시판 등록</h1>
        <div class = "AddWrap">
            <form>
                <table class = "tbAdd">
                    <colgroup>
                        <col width="15%"/>
                        <col width="*"/>
                    </colgroup>
                    <tr>
                        <th>제목</th>
                        <td><input type="text" v-model="title" ref="title" /></td>
                    </tr>
                    <tr>
                        <th>작성자</th>
                        <td><input type="text" v-model="register_id" ref="register_id" /></td>
                    </tr>
                    <tr>
						<th>내용</th>
						<td><textarea v-model="content" ref="content"></textarea></td>
					</tr>
                </table>
            </form>
        </div>

        <div class="btnWrap">
			<a href="javascript:;" @click="fnList" class="btn">목록</a>
			<a href="javascript:;" @click="fnAddProc" class="btnAdd btn">등록</a>
		</div>	
    </div>
</template>

<script>
export default{
    name : 'App',
    data() {
        return {
            id : ''
            , title : ''
            , content : ''
            , register_id : ''
            , register_time : ''
            , update_time : ''

        }
    }
    , methods : {
        fnList(){
            this.$router.push({path:'./list', query:this.body});
        }
        , fnAddProc(){
            if(!this.title){
                alert('제목을 입력해 주세요');
                this.$refs.title.focus();
                return;
            }

            if(!this.register_id){
                alert('작성자를 입력해 주세요');
                this.$refs.register_id.focus();
                return;
            }

            const form = {
                id : this.id
                , title : this.title
                , content : this.content
                , register_id : this.register_id
                , register_time : this.register_time
                , update_time : this.update_time
            }

            this.$axios.post('/api/add', form)
            .then((res) => {
                console.log(res)

                if(res.data.result == "success"){
                    alert('등록되었습니다.');
                    this.fnList();
                }else{
                    alert('실패하였습니다.')
                }
            })
            .catch((err) => {
                console.log(err);
            })
        }
    }
}

</script>

<style scoped>
	.tbAdd{border-top:1px solid #888;}
	.tbAdd th, .tbAdd td{border-bottom:1px solid #eee; padding:5px 0;}
	.tbAdd td{padding:10px 10px; box-sizing:border-box;}
	.tbAdd td input{width:100%; min-height:30px; box-sizing:border-box; padding:0 10px;}
	.tbAdd td textarea{width:100%; min-height:300px; padding:10px; box-sizing:border-box;}
	.btnWrap{text-align:center; margin:20px 0 0 0;}
	.btnWrap a{margin:0 10px;}
	.btnAdd {background:#43b984}
	.btnDelete{background:#f00;}
</style>