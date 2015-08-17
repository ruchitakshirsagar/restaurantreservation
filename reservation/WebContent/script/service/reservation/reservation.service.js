/*
 *	SERVICE: Reservation services
 *	TASK: 
 *		getReservationDetails  
 *			-- returns promise (success or reject)
 * 
 */


	angular.module('reservationSystem').service('reservationDetailsService',function($http, $q) {

						// Returns an object which contains various tasks/functions 
						// related to 'Reservation' services.
						var reservService =  ({

							getReservationDetails : getReservationDetails

						});
						return reservService;
						
						

						// Send message to user
						function getReservationDetails() {

							var deferred = $q.defer(); // Create a new instance
														// of 'deferred'.

							// A async http post request to send the data from
							// database.
							$http(
									{
										method : 'GET',
										url : 'http://localhost:8080/reservation/webapi/userReservation/all',
										contentType : "application/json",
									})
									.success(
											function(data, status, headers,
													config) {

												deferred.resolve(data);

											})
									.error(
											function(data, status, headers,
													config) {

												// Problem in retrieving data,
												// send error message.
												deferred
														.reject("An unknown error occurred.");

											});

							// Return 'promise' from 'getMenus' instead of call
							// back functions.
							return deferred.promise;

						};

						
					});


