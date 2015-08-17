
/*
 *	SERVICE: Current Seating services
 *	TASK: 
 *		getAllocatedTables 
 *			-- returns promise (success or reject)
 * 
 */

	angular.module('reservationSystem').service('currentSeatingService',function($http, $q) {

						// Returns an object which contains various tasks/functions 
						// related to 'Message'
						// services.
						var reservService = ({

							getAllocatedTables : getAllocatedTables

						});
						return reservService;
						
						

						// Send message to user
						function getAllocatedTables() {

							var deferred = $q.defer(); // Create a new instance
														// of 'deferred'.

							// A async http get request to get data from DB.
							$http(
									{
										method : 'GET',
										url : 'http://localhost:8080/reservation/webapi/seating',
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

							// Return 'promise' from 'getAllocatedTables'
							// instead of call back
							// functions.
							return deferred.promise;

						};

						
					});

	
