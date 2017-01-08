/**
 * Created by Chiranjeevi on 1/4/2017.
 */
(function () {
    'use strict';

    angular
        .module('app')
        .controller('BookingsController', BookingsController);

    BookingsController.$inject = ['$http'];

    function BookingsController($http) {
        var vm = this;

        vm.bookings = [];
        vm.getAll = getAll;
        vm.getAffordable = getAffordable;
        vm.deleteBooking = deleteBooking;

        init();

        function init(){
            getAll();
        }

        function getAll(){
            var url = "/bookings/all";
            var bookingsPromise = $http.get(url);
            bookingsPromise.then(function(response){
                vm.bookings = response.data;
            });
        }

        function getAffordable(){
            var url = "/bookings/affordable/" + 100;
            var bookingsPromise = $http.get(url);
            bookingsPromise.then(function(response){
                vm.bookings = response.data;
            });
        }

        function deleteBooking(id){
            var url = "/bookings/delete/" + id;
            $http.post(url).then(function(response){
                vm.bookings = response.data;
            });
        }
    }

    angular
        .module('app')
        .controller('EditController',EditController);

    EditController.$inject = ['$http','$routeParams','$location'];
    
    function EditController($http,$routeParams,$location) {
        var em = this;
        em.booking = [];
        em.editBooking = editBooking;
        em.updateBooking = updateBooking;

        editBooking();
        function editBooking() {
            var url = "/bookings/edit/" + $routeParams.id;
            $http.get(url).then(function (response) {
                em.booking = response.data;
            });
        }

        function updateBooking(b){
            var bookingObj = {
                        "id": $routeParams.id,
                        "hotelName": b.hotelName,
                        "pricePerNight": b.pricePerNight,
                        "noOfNights": b.noOfNights
                    };
            var url = "/bookings/edit/" + $routeParams.id;
            $http.post(url, bookingObj).then(function (response) {
            });
            $location.path("/");
        }
    }


    angular
        .module('app')
        .controller('CreateController',CreateController);

    CreateController.$inject = ['$http','$location'];
    function CreateController($http,$location) {
        var cm = this;
        cm.createBooking = createBooking;

        function createBooking(c){
            var createObj = {
                "hotelName": c.hotelName,
                "pricePerNight": c.pricePerNight,
                "noOfNights": c.noOfNights
            };
            var url = "/bookings/create"
            $http.post(url, createObj).then(function (response) {});
            $location.path("/");
        }
    }


})();