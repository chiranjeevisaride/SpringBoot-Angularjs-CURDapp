/**
 * Created by Chiranjeevi on 1/4/2017.
 */

(function () {
    'use strict';
     angular
         .module('app', ['ngRoute'])
         .config(function ($routeProvider) {
             $routeProvider
                 .when("/", { controller: 'BookingsController', templateUrl: "app/partials/bookings_list.html"})
                 .when("/edit/:id", { controller: 'EditController', templateUrl: "app/partials/edit_booking.html"})
                 .when("/new", { controller: 'CreateController', templateUrl: "app/partials/create_booking.html"})
                 .otherwise({ redirectTo: "/"})
         });
})();
