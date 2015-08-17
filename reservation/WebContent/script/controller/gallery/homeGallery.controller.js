/*
 * The 'HomeController' IIFE takes in the 'homeModule' as input. We can attach the Image objects on to it for successive calls. * 
 */

var homeModule = angular.module('reservationSystem');

// IIFE
(function(homeModule) {
	'use strict';

	angular.module('reservationSystem').controller('HomeController',
			HomeControllerFunc);

	HomeControllerFunc.$inject = [ '$http', '$rootScope', 'imageLoadFactory' ];

	// handles the control for home page.
	function HomeControllerFunc($http, $rootScope, imageLoadFactory) {

		// Uses this inside controllers to get bound to $scope, here use controllerAs with vm.	
		var homeVm = this;	// bind able members at top of fun. 
		var imageArray = [];
		var index = 0;

		// The image obtained is cached so that next time it is called it can be
		// retrieved quickly.
		// cache the image data by creating new Image object.
		// 'homeModule.photoGallery' is the image data retrieved from the server
		// by factory.
		for (var i = 0; i < (homeModule.photoGallery).length; i++) {
			imageArray[i] = new Image(); // create a new image object
			imageArray[i].src = (homeModule.photoGallery)[index].imageLink; // save
		}

		// display images in the gallery after every 3 Second.
		var showPhotosOnInterval = setInterval(
				function() {

					if (index < (homeModule.photoGallery).length) {
						document.getElementById('galleryImage').src = (homeModule.photoGallery)[index].imageLink;
					} else {
						index = 0;
						document.getElementById('galleryImage').src = (homeModule.photoGallery)[index].imageLink;
					}
					index = index + 1;

				}, 3000);

		// disable the 'interval' after user switches to another view.
		$rootScope.$on("$locationChangeStart", function(event, next, current) {

			if (next != current)
				clearInterval(showPhotosOnInterval);

		});

	}

})(homeModule);
