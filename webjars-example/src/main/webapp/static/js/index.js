/* global angular */
(function () {
    'use strict';
    angular.module('webApp', ['ui.bootstrap'])
        .controller('WebController',
            ['$scope',
                function ($scope) {
                    $scope.val = 'Welcome To Angular!'
                }])
        .controller('CollapseDemoCtrl', function ($scope) {
            $scope.isNavCollapsed = true;
            $scope.isCollapsed = false;
            $scope.isCollapsedHorizontal = false;
        });
})();