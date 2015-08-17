// IIFE 
(function() {
	'use strict';

	angular.module('reservationSystem').controller('ReservationController',
			ReservationControllerFunc);

	ReservationControllerFunc.$inject = [ '$http', 'reservationDetailsService' ];

	function ReservationControllerFunc($http, reservationDetailsService) {

		// Uses this inside controllers to get bound to $scope, here use
		// controllerAs with vm.
		var reservationVm = this;
		reservationVm.reservations = [];
		reservationVm.getReservations = getReservations;
		reservationVm.searchBy = searchBy;
		console.log('inside reservation');

		
		getReservations();
		
		
		function getReservations() {

			// Request for the 'Menus' and then attach them with actual model.
			var promise = reservationDetailsService.getReservationDetails();

			promise.then(function(data) {

				for ( var item in data) {

					var reservation = data[item];
					reservationVm.reservations.push(reservation);

				}

			}, function(error) {
				console.log(error);
			});

		}
		

		function searchBy() {
			reservationVm.searchingText = reservationVm.userText;
		};
		

	}

})();
