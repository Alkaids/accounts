angular.module('account', ['ng', 'ngRoute']).controller('accCtr', function ($scope, $http, $location) {

    var acc = this;

    acc.acctMoney = null;
    acc.dealDate = null;
    acc.desc = null;
    acc.type = null;

    $http.get("/accounts/getItemList/")
        .then(function (result) {
            console.log(result);
            console.log(result.data);
            $scope.acctItems = result.data;
        });
    $http.get("/accounts/getMoneyInfo/")
        .then(function (result) {
            console.log(result);
            console.log(result.data);
            $scope.balance = result.data.balance;
            $scope.count = result.data.count;
        });
    acc.getTime = function () {
        laydate({
            elem: '#date',
            istime: true,
            format: 'YYYY-MM-DD hh:mm:ss',
            choose: function (dates) { //选择好日期的回调
                acc.dealDate = dates;
            }
        });
    }
    acc.postData = function () {
        var postMsg = {
            "acctMoney": acc.acctMoney,
            "dealDate": acc.dealDate,
            "userId": "1",
            "userName": "金鑫",
            "acctDesc": acc.desc,
            "type": acc.type
        }
        $http({

            method: 'POST',

            url: '/accounts/saveItem/',

            data: postMsg

        }).success(function (req) {
            if (req == '1') {
                alert("保存成功!");
            } else {
                alert("保存失败，请联系金鑫查看！");
            }
            $location.path('/');
        })
    }
    acc.getData = function () {

    }
}).config(['$routeProvider', function ($routeProvider) {
    $routeProvider
        .when('/', {templateUrl: 'list.html'})
        .when('/add', {templateUrl: 'add.html'})
        .when('/about', {template: '关于我们'})
        .otherwise({redirectTo: '/'});
}]);

// var app = angular.module('acctTableData', []);
// app.controller('acctTableCtrl', function($scope, $http) {
//     $http.get("/accounts/getItemList/")
//         .then(function (result) {
//             $scope.acctItems = result.data.records;
//         });
// });