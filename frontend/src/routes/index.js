import Vue from 'vue';
import Router from 'vue-router';
import HelloWorld from '@/components/HelloWorld'; //메인 컴포넌트 호출
import List from '@/components/board/List'; //게시판 리스트 컴포넌트 호출
import Write from '@/components/board/Write'; // 게시판 리스트 컴포넌트 호출
import View from '@/components/board/View';
import Update from '@/components/board/Update';

Vue.use(Router); //vue 라우터 사용

export default new Router({ //라우터 연결
	routes:[
		{
			path:'/'
			,name:HelloWorld
			,component:HelloWorld
		}
		,{
			path:'/board/list'
			,name:List
			,component:List

		}
		,{
			path:'/board/write'
			,name:Write
			,component:Write
		}
		,{
			path:'/board/view'  //상세페이지 추가
			,name:View
			,component:View
		}
		,{
			path:'/board/update'
			,name:Update
			,component:Update
		}
		
	]
})