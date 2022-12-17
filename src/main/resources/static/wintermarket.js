angular.module('app',[]).controller('indexController', function($scope, $http){


    console.log("test console.log: wintermarket.js - is working!")

//    $http.get('http://localhost:8189/winter/api/v1/products')
//    .then(function(response){
//    console.log(response.data)
//    let products = response.data;
//    console.log(products[0].title)
//    });

    const contextPath = 'http://localhost:8189/winter/api/v1';
    $scope.pageNumber = 1;

//Получение списка продуктов
$scope.loadProducts = function() {
                $http({
                    url: contextPath +'/products',
                    method: 'GET',
                    params: {
                             p: $scope.pageNumber,
                             min_price: $scope.filter ? $scope.filter.min_price : null,
                             max_price: $scope.filter ? $scope.filter.max_price : null,
                             title_part: $scope.filter ? $scope.filter.title_part : null
                    }
                }).then(function(response) {
                                  $scope.productList = response.data.content;
                })
}
$scope.showProductInfo = function(productId){
    $http.get(contextPath + '/products/'+productId)
            .then(function(response){
            alert(response.data.title);
    })
}
$scope.deleteProductById = function(id){
            $http.delete(contextPath + '/products/' + id)
            .then(function(response) {
                $scope.loadProducts();
            })
}

$scope.addToCart = function(productId){
    $http.get(contextPath + '/cart/add/' + productId).then(function(response){
    $scope.loadCart();
    })
}

$scope.loadCart = function(){
    $http.get(contextPath + '/cart').then(function(response){
    $scope.cart = response.data;
    })
}
//Пагинация
$scope.change_page = function(pageVar) {
             $scope.pageNumber = $scope.pageNumber + pageVar;
             if($scope.pageNumber <= 0){
                    $scope.pageNumber = 1
             }
             $http({
                    url: contextPath +'/products',
                    method: 'GET',
                    params: {
                             p: $scope.pageNumber,
                             min_price: $scope.filter ? $scope.filter.min_price : null,
                             max_price: $scope.filter ? $scope.filter.max_price : null,
                             title_part: $scope.filter ? $scope.filter.title_part : null
                    }
             }).then(function(response) {
                     $scope.productList = response.data.content;
             })
}



$scope.loadProducts();
$scope.loadCart();

});
