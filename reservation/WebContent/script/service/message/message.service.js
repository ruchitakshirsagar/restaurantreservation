/*
 *	SERVICE: Message services
 *	TASK: 
 *		sendMessage 
 * 			-- send the message as a email to the user. 
 *			-- returns promise (success or reject)
 * 
 */


angular.module('reservationSystem').service('messageService',
		function($http, $q) {

			// Returns an object which contains various tasks/ functions
			// related to 'Message' services.
			var msgService = ({

				sendMessage : sendMessage,
				clearMessage : clearMessage

			});
			return msgService;
			
			

			// Send message to user
			function sendMessage(messageVm) {

				var deferred = $q.defer(); // Create a new instance
				// of 'deferred'.

				// A async http post request to send the data from
				// database.
				$http({
					method : 'POST',
					url : 'http://localhost:8080/reservation/webapi/message',
					contentType : "application/json",
					data : JSON.stringify(messageVm.userMessage),
				}).success(function(data, status, headers, config) {

					deferred.resolve(data);

				}).error(function(data, status, headers, config) {

					// Problem in retrieving data,
					// send error message.
					deferred.reject("An unknown error occurred.");

				});

				// Return 'promise' from 'getMenus' instead of call
				// back functions.
				return deferred.promise;

			};

			
			
			// Clears the model so that the view is reset
			function clearMessage(messageVm) {

				// reset the data in 'userMessage' object
				messageVm.userMessage = null;
			};

			
			
		});
