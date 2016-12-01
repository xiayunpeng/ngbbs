/**
 * Created by Administrator on 2016/11/22.
 * 核心模块：核心配置，路由配置
 */
var  bbsApp = angular.module('bbsApp',['ui.router','bbs.controller','bbs.service','bbs.directive','bbs.filter']);

//在config中配置路由，注入$stateProvider,$urlRouterProvider两个服务
bbsApp.config(['$stateProvider','$urlRouterProvider',function($stateProvider,$urlRouterProvider){

//	配置路由对应的页面url地址
	$stateProvider
		.state('login',{
			url:'/login',
			templateUrl:'tpls/login.html',
			controller:'loginController'
		})
		.state('InsertMsg',{
			url:'/InsertMsg',
			templateUrl:'tpls/InsertMsg.html',
			controller:'insertMsgController'
		})
		.state('QueryMsg',{
			url:'/QueryMsg/:pageNum',
			templateUrl:'tpls/QueryMsg.html',
			controller:'queryMsgController'
		})
		.state('UpdateMsg',{
			url:'/UpdateMsg/:id/:pageNum',
			templateUrl:'tpls/UpdateMsg.html',
			controller:'updateMsgController'
		})
		.state('QueryLoadMsg',{
			url:'/QueryLoadMsg/:pageNum',
			templateUrl:'tpls/QueryLoadMsg.html',
			controller:'queryLoadMsgController'
		})
		.state('QueryAutoMsg',{
			url:'/QueryAutoMsg/:pageNum',
			templateUrl:'tpls/QueryAutoMsg.html',
			controller:'queryAutoMsgController'
		})
		

//	配置默认路由跳转地址（如果路由url不存在）
	$urlRouterProvider.otherwise('/login');

}]);