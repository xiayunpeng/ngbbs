/**
 * Created by Administrator on 2016/11/22.
 * 过滤器模块
 * （在这个模块创建各种过滤器）
 */
angular.module('bbs.filter',[ ])
	// 转换回车空格制表位的过滤器
	.filter('repSpace',['$sce',function($sce) {

		return function(str) {
			
			str = str.replace(/&/g,'&amp;');
			str = str.replace(/</g,'&lt;');
			str = str.replace(/>/g,'&gt;');
			str = str.replace(/"/g,'&quot;');

			str = str.replace(/\r\n/g,'<br>');
			str = str.replace(/\n/g,'<br>');
			str = str.replace(/ /g,'&nbsp;');
			str = str.replace(/\t/g,'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;');

			str = $sce.trustAsHtml(str);

			return str;
		}
		
	}]);