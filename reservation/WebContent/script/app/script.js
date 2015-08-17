

(function(){
  'use strict';
  
  angular.module('reservationSystem',['ngRoute','ngMessages']);
  
  angular.module('reservationSystem').config(moduleConfigFunc);
  
  moduleConfigFunc.$inject = ['$routeProvider'];
  
  // use $routeProvider service
  function moduleConfigFunc($routeProvider){
    
    // when route is 'reservation' use specified URL for template, and invoke mentioned controller and refer
    // to the scope of controller inside controller template as 'reservationVm'. 
	  
	// Using "controllerAs" syntax. for example the controller  'HomeController' is referred to as 'homeVm'.  
    $routeProvider
    .when('/home', {
      templateUrl: 'view/template/gallery/homeGallery.tmpl.html', 
      controller: 'HomeController',
      controllerAs: 'homeVm'
    })
    .when('/reservation', {
      templateUrl: 'view/template/reservation/reservation.tmpl.html', 
      controller: 'ReservationController',
      controllerAs: 'reservationVm'
    })
    .when('/message', {
      templateUrl: 'view/template/message/message.tmpl.html', 
      controller: 'MessageController',
      controllerAs: 'messageVm'
    })
    .when('/seating', {
      templateUrl: 'view/template/seating/seating.tmpl.html', 
      controller: 'SeatingController',
      controllerAs: 'seatingVm'
    })
    .when('/menu', {
      templateUrl: 'view/template/menu/menu.tmpl.html', 
      controller: 'MenuController',
      controllerAs: 'menuVm'
    })
    .when('/login', {
      templateUrl: 'view/template/login/login.tmpl.html', 
      controller: 'LoginController',
      controllerAs: 'loginVm'
    })
    .when('/guestLogin', {
      templateUrl: 'view/template/login/guestLogin.tmpl.html', 
      controller: 'GuestLoginController',
      controllerAs: 'guestLoginVm'
    })
    .when('/ownerLogin', {
      templateUrl: 'view/template/login/ownerLogin.tmpl.html', 
      controller: 'OwnerLoginController',
      controllerAs: 'ownerLoginVm'
    })
    .otherwise({
      templateUrl: 'view/template/login/login.tmpl.html', 
      controller: 'LoginController',
      controllerAs: 'loginVm'
    });
        
  }
  
})();


