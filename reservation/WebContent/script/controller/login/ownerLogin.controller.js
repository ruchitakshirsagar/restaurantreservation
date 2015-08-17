// IIFE
(function() {
	'use strict';

	angular.module('reservationSystem').controller('OwnerLoginController',
			OwnerLoginControllerFunc);

	OwnerLoginControllerFunc.$inject = [ '$rootScope', 'ownerLoginService' ];

	function OwnerLoginControllerFunc($rootScope, ownerLoginService) {
		
		// Uses this inside controllers to get bound to $scope, here use controllerAs with vm.
		var ownerLoginVm = this;
		console.log('inside owner');

		
		
		
		// Request for the 'Menus' and then attach them with actual model.
		ownerLoginVm.ownerLogin = function(form) {

			console.log("valid:   " + form.$valid);
			if (form.$valid === true) {
				// send valid data to server
				var promise = ownerLoginService.doOwnerLogin(ownerLoginVm);

				promise.then(function(data) {

					// If user is valid then perform necessary operations.
					if (data.authOwner === "VALID") {
						console.log("User auth val:  " + data.authOwner);
						$rootScope.dessiKattaOwnerAccess = "VALID";
						alert("Welcome!! to Dessi Katta.");
					}else{
						$rootScope.dessiKattaOwnerAccess = "INVALID";
						alert("Login failed. Try to login back as Owner.");
					}

					// clear the view by clearing the model
					ownerLoginService.clearOwnerLogin(ownerLoginVm);

				}, function(error) {
					console.log(error);
				});
			}
		};
		
		
		
		
	}

})();
