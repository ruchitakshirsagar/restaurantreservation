
/*
 * Factory:	ImageLoadFactory
 *			- Loads the image URL from the server
 */

var homeModule = angular.module('reservationSystem'); 

homeModule.factory('imageLoadFactory',	function($http) {

				var factory = {};

				homeModule.photoGallery = [];
				$http({
					method : 'GET',
					url : 'http://localhost:8080/reservation/webapi/home',
					contentType : "application/json",
				}).success(function(data, status, headers, config) {

					// HomeController will first create a 'homeModule', when
					// factory will complete it's task the
					// retrieved image url's will be saved onto 'homeModule'
					// instance.
					console.log("The get call for images was successful");
					homeModule.photoGallery = data;

				}).error(function(data, status, headers, config) {
					console.log("The get call was not-successful");
				});

				return factory;
			});
