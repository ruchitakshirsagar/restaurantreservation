
	angular.module('reservationSystem').controller('SeatingController',
			SeatingControllerFunc);

	SeatingControllerFunc.$inject = [ 'currentSeatingService' ];

	function SeatingControllerFunc(currentSeatingService) {
		console.log('inside seating');

		// Uses this inside controllers to get bound to $scope, here use
		// controllerAs with vm.
		var seatingVm = this;
		seatingVm.rows = [ 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J' ]; // Bindable members at top of fun.
		seatingVm.cols = [ 1, 2, 3 ];
		// Set reserved and selected
		var reserved = [];
		var selected = [];

		// define functions on the vm.
		seatingVm.getStatus = getStatus;
		seatingVm.seatClicked = seatClicked;
		seatingVm.getReservedTable = getReservedTable;
		
		
		getReservedTable();

		
		
		function getReservedTable() {
			// get the previously allocated tables.
			var promise = currentSeatingService.getAllocatedTables();

			promise.then(function(data) {

				// get the table numbers and update the view.
				// messageService.clearMessage(messageVm);
				console.dir(data);
				for ( var index in data.bookedTables) {
					console.log("booked :  " + data.bookedTables[index]);
					reserved.push(data.bookedTables[index]);
				}

			}, function(error) {
				console.log(error);
			});
		}

		
		
		// seat onClick
		function seatClicked(seatPos) {

			console.log("Inside service selected Seat: " + seatPos);

			var index = selected.indexOf(seatPos);
			if (index != -1) {
				// seat already selected, remove
				selected.splice(index, 1);
			} else {
				// new seat, push
				selected.push(seatPos);
			}
		};

		
		
		// get seat status
		function getStatus(seatPos) {
			if (reserved.indexOf(seatPos) > -1) {
				return 'reserved';
			} else if (selected.indexOf(seatPos) > -1) {
				return 'selected';
			}
		};

		
		
	} // end of controller

	
	