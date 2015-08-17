// controller only directs the flow.  
// IIFE 
(function() {
	'use strict';

	angular.module('reservationSystem').controller('MenuController',
			MenuControllerFunc);

	// Inject the required dependencies for the controller.
	MenuControllerFunc.$inject = [ '$http', 'loadMenuService' ];

	function MenuControllerFunc($http, loadMenuService) {

		// Uses this inside controllers to get bound to $scope, here use
		// controllerAs with vm.
		var menuVm = this;
		menuVm.showMenus = [];
		menuVm.getMenuItems = getMenuItems;
		menuVm.setViewData = setViewData;
		
		getMenuItems();
		
				
		function getMenuItems() {
			// Request for the 'Menus' and then attach them with actual model.
			var promise = loadMenuService.getMenus();

			promise.then(function(formatedData) {
									        	
				setViewData(formatedData);

			}, function(error) {
				console.log(error);
								
			});
		}
		
		
		
		function setViewData(formatedData){
			// Set retrieved formatedData onto model.
			$(function() {
				$('#tree1').tree({
					data : formatedData
				});
			});
		}
		
		

	}

})();
