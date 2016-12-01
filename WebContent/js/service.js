/**
 * Created by Administrator on 2016/11/22.
 * 业务模块（模型层）
 * （在这里创建各种服务）
 */
angular.module('bbs.service',[ ])
	//发送post请求必须要设置修改请求报头为x-www-form-urlencoded，否则以json字符串形式发送到服务器端!!!
	.config(function($httpProvider) {
	    $httpProvider.defaults.headers.put['Content-Type'] = 'application/x-www-form-urlencoded';
	    $httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
	 
	    // Override $http service's default transformRequest
	    $httpProvider.defaults.transformRequest = [function(data) {
	        /**
	         * The workhorse; converts an object to x-www-form-urlencoded serialization.
	         * @param {Object} obj
	         * @return {String}
	         */
	        var param = function(obj) {
	            var query = '';
	            var name, value, fullSubName, subName, subValue, innerObj, i;
	 
	            for (name in obj) {
	                value = obj[name];
	 
	                if (value instanceof Array) {
	                    for (i = 0; i < value.length; ++i) {
	                        subValue = value[i];
	                        fullSubName = name + '[' + i + ']';
	                        innerObj = {};
	                        innerObj[fullSubName] = subValue;
	                        query += param(innerObj) + '&';
	                    }
	                } else if (value instanceof Object) {
	                    for (subName in value) {
	                        subValue = value[subName];
	                        fullSubName = name + '[' + subName + ']';
	                        innerObj = {};
	                        innerObj[fullSubName] = subValue;
	                        query += param(innerObj) + '&';
	                    }
	                } else if (value !== undefined && value !== null) {
	                    query += encodeURIComponent(name) + '='
	                            + encodeURIComponent(value) + '&';
	                }
	            }
	 
	            return query.length ? query.substr(0, query.length - 1) : query;
	        };
	 
	        return angular.isObject(data) && String(data) !== '[object File]'
	                ? param(data)
	                : data;
	    }];
	})
	// 登录业务
	.service('loginService', ['$http', function($http) {
		return {
			// 登录验证功能
			login:function(username,userpwd) {

				var params = {
					username:username,
					userpwd:userpwd
				}

				var promise = $http.post(baseUrl + '/LoginServlet',params);

				return promise;
			}
		}
	}])
	// 评论业务
	.service('msgService', ['$http', function($http) {

		return {

			// 发表评论功能
			insertMsg:function(obj) {

				var promise = $http.post(baseUrl + '/InsertMessageServlet',obj);

				return promise;
			},
			// 分页查询评论功能
			queryMsg:function(pageNum,pageSize) {

				var params = {
					pageNum:pageNum,
					pageSize:pageSize
				}

				var promise = $http.get(baseUrl + '/QueryMsgServlet',{
					params:params
				});

				return promise;
			},
			// 点赞功能
			updateHit:function(id) {

				var promise = $http.get(baseUrl + '/UpdateHitServlet',{
					params:{
						id:id
					}
				});

				return promise;
			},
			// 删除评论功能
			deleteMsg:function(id) {

				var promise = $http.get(baseUrl + '/DeleteMsgServlet',{
					params:{
						id:id
					}
				});

				return promise;
			},
			// 根据id查询单条数据功能
			getMsg:function(id) {

				var promise = $http.get(baseUrl + '/GetMsgServlet',{
					params:{
						id:id
					}
				});

				return promise;
			},
			// 更新评论功能
			updateMsg:function(obj) {

				var promise = $http.post(baseUrl + '/UpdateMsgServlet',obj);

				return promise;
			}

		}
		
	}])
