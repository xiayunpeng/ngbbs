/**
 *获得请求参数的插件
*/
$.extend({
	getParam:function(key) {

		var url = location.href;

		var index = url.indexOf('?');

		var str = url.substring(index + 1);

		var arr = str.split('&');

		for (var i = 0;i < arr.length;i ++) {
			var param = arr[i].split('=');
			
			if (param[0] == key) {
				return param[1];
			}

		}
	}
});