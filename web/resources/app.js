var myApp = angular.module('myApp', []);


myApp.controller('firstCtrl', function ($scope, $http) {
    $scope.brands = [];

    $scope.deleteBrand = function (brand) {
        $http
            .delete('/api/' + brand.id)
            .then(function (response) {
                update();
            })
    };

    $scope.addBrand = function (brand) {
        $http
            .post('/api/', {name: brand.name})
            .then(function(response){
                update();
            });
    };

    var update = function() {
        $http
            .get('/api/')
            .then(function (response) {
                $scope.brands = response.data;
            });
    };

    update();


});