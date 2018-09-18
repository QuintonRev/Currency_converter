<script>
var app = angular.module('myapp', []);

app.controller('myappcontroller', function($scope, $http) {
	$scope.items = []
	$scope.itemform = {
			
			
			id : "",
			decription : "",
		
			
	};
            $scope.saveProduct = function ()
            {
                console.log($scope.saveProduct());
                
            }

	getUserDetails();

	function getUserDetails() {
		$http({
			method : 'GET',
			url : '/GetProducts + '
		}).then(function successCallback(response) {
			$scope.products = response.data;
		}, function errorCallback(response) {
			console.log(response.statusText);
		});
	}
</script>