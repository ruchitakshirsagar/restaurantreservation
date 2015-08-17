// IIFE 
(function() {
	'use strict';

	angular.module('reservationSystem').controller('MessageController',
			MessageControllerFunc);

	MessageControllerFunc.$inject = [ '$rootScope', 'messageService' ];

	function MessageControllerFunc($rootScope, messageService) {
		
		// Uses this inside controllers to get bound to $scope, here use controllerAs with vm.
		var messageVm = this;
		console.log('inside message');
		messageVm.sendEmail = sendEmail;
		
		
		
		// Request for the 'Menus' and then attach them with actual model.
		function sendEmail(form) {
			if (form.$valid === true && $rootScope.dessiKattaOwnerAccess==="VALID") {
				// send valid data to server
				var promise = messageService.sendMessage(messageVm);

				promise.then(function(data) {

					// clear the view by clearing the model
					messageService.clearMessage(messageVm);
					alert("Your message was send successfully.");
					
				}, function(error) {
					console.log(error);
				});
			}else{
				alert("Please login as Owner to send messages.");
			}
		};

		
		
		
		
	}
	
	
	

})();
