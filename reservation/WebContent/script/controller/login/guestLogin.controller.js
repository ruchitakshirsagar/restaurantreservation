// IIFE
(function() {
	'use strict';

	angular.module('reservationSystem').controller('GuestLoginController',
			GuestLoginControllerFunc);

	GuestLoginControllerFunc.$inject = [ '$http', 'guestLoginService' ];

	// handles the control for guestLogin page.
	function GuestLoginControllerFunc($http, guestLoginService) {

		// Uses this inside controllers to get bound to $scope, here use
		// controllerAs with vm.
		var guestLoginVm = this;
		console.log('inside guestLogin');
		guestLoginVm.sendData = sendData;
		guestLoginVm.makeReservation = makeReservation;

		
		
		function makeReservation(form) {

			// Check whether all fields entered by user in the form are valid.
			if (form.$valid) {

				// convert to epoch time
				var epochTime = guestLoginVm.newPerson.time.getTime()	+ guestLoginVm.newPerson.date.getTime();
				var personData = guestLoginVm.newPerson;
				personData.time = epochTime;
				guestLoginVm.sendData(personData);		// call send data func
				
			}

		};

		
		
		function sendData(personData) {
			// send the form data to the sever to save it to DB.
			var promise = guestLoginService.sendGuestReservationInfo(personData);

			promise.then(function(data) {

				// The service call was successful now clear the view by
				// clearing the model
				guestLoginService.clearGuestLogin(guestLoginVm);

			}, function(error) {
				console.log(error);
			});
		}

		
		
		
	}

})();
