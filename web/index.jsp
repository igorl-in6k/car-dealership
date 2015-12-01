<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <%--<script src="js/app.js"></script>--%>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.5.0-beta.2/angular.min.js"></script>
</head>
<script>
    var myApp = angular.module('myApp', []);
    myApp.controller('brandController', function ($scope, $http) {
        $scope.brands = [];
        $scope.deleteBrand = function(brand) {
            $http
                    .delete('/allbrands/' + brand.id)
                    .then(function (response) {
                        updateBrands();
                    })
        };
        $scope.addBrand = function(brand) {
            $http
                    .post('/allbrands/', {name: brand.name})
                    .then(function (response) {
                        updateBrands();
                    });
        };
        var updateBrands = function () {
            $http
                    .get('/allbrands/')
                    .then(function (response) {
                        $scope.brands = response.data;
                    });
        };

        $scope.cars = [];
        $scope.deleteCar = function(car) {
            $http
                    .delete('/allcars/' + car.id)
                    .then(function (response) {
                        updateCars();
                    })
        };
        $scope.addCar = function(car) {
            $http
                    .post('/allcars/', {brand: $scope.selectedBrand,
                        model: $scope.inputModel, price: $scope.inputPrice})
                    .then(function (response) {
                        updateCars();
                    });
        };
        var updateCars = function () {
            $http
                    .get('/allcars/')
                    .then(function (response) {
                        $scope.cars = response.data;
                    });
        };

        updateCars();
        updateBrands();
    });
</script>
<body ng-app="myApp">
<div ng-controller="brandController">
    <table width="100%" border="1">
        <tr>
            <th width="20%">Name</th>
            <th></th>
        </tr>
        <tr ng-repeat="brand in brands">
            <td>{{brand.name}}</td>
            <td>
                <button ng-click="deleteBrand(brand)">Remove</button>
            </td>
        </tr>
    </table>
    Brand name: <input type="text" ng-model="brand.name"><br>
    <button ng-click="addBrand(brand)">Add</button>

    <br><br>
    <table width="100%" border="1">
        <tr>
            <th>Brand</th>
            <th>Model</th>
            <th>Price</th>
            <th>SaleDate</th>
            <th>Remove</th>
        </tr>
        <tr ng-repeat="car in cars">
            <td>{{car.brand.name}}</td>
            <td>{{car.model}}</td>
            <td>{{car.price}}</td>
            <td>{{car.saleDate}}</td>
            <td><button ng-click="deleteCar(car)">Remove</button></td>
        </tr>
    </table>
    Brand:
    <select name="brandSelect" id="brandSelect"
            ng-options="brand.name for brand in brands track by brand.id"
            ng-model="selectedBrand">
    </select>
    Model: <input type="text" ng-model="inputModel"><br>
    Price: <input type="number" ng-model="inputPrice"><br>
    <button ng-click="addCar()">Add</button>
</div>

</body>
</html>