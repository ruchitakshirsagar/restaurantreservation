/*
 *	SERVICE: Menu services
 *	TASK: 
 *		getMenus 
 * 			-- get all the menu details from the database. 
 *			-- returns promise (success or reject), the data returned is formated as per the requirements of 'jqTree'
 * 			
 */

var homeModule = angular.module('reservationSystem');

homeModule.service('loadMenuService', function($http, $q) {

	// Returns an object which contains various tasks/functions related to Menu
	// services.
	var menuService = ({

		getMenus : getMenus,

	});
	return menuService;

	
	
	
	// Get Menu task
	function getMenus() {

		var menus = []; // Menus information array
		var deferred = $q.defer(); // Create a new instance of 'deferred'.

		// A async http get request to get the data from database.
		$http({
			method : 'GET',
			url : 'http://localhost:8080/reservation/webapi/menu',
			contentType : "application/json",
		}).success(function(data, status, headers, config) {
			console.dir(data);
			// Handles success -- if success then send the retrieved data
			// along with the promise.

			// To print the 'menus' as a tree view 'jqTree' needs the json
			// data in a differnet format.
			var formatedJSON = formatMenus(data);
			
			// send the formated data to the controller
			deferred.resolve(formatedJSON);

		}).error(function(data, status, headers, config) {

			// Problem in retrieving data, send error message.
			deferred.reject("An unknown error occurred.");
		});

		// Return 'promise' from 'getMenus' instead of call back functions.
		return deferred.promise;

	}

	
	
	
	// 'jqTree' is used to display the menu's in a tree structure. It needs
	// data in a particular format.
	// This function, formats the JSON data retrieved from database into an
	// acceptable format.
	function formatMenus(data) {

		var formatedData = [];

		for ( var index in data) {
			var menu = data[index];

			var newMenu = {};
			newMenu.label = menu.menuCategory;
			newMenu.children = [];
			var descr = menu.descriptions;
			for ( var index in descr) {
				var newDesc = {};
				newDesc.label = descr[index];
				newMenu.children.push(newDesc);
				// console.dir(descr[index]);
			}
			formatedData.push(newMenu);
		}

		return formatedData;

	}

});
