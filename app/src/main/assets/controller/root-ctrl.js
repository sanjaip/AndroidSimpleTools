simpeTools.controller('RootController', function($scope,recommendedMoviesFactory,$window){
	$scope.recommendedMovies = [];
    $scope.STdata = [];
    $scope.STdataCnt = 1;
    $scope.STdataStr = "";
    $scope.STdatum = [];
    $scope.started = false;
    console.log( $scope.started);
	init();
    // $scope.saiBaba = function(){alert(); };
    //$scope.collectResponseBits=function(txt){
   //     $scope.STdataStr  = $scope.STdataStr + txt;
   // };
    //$window.collectResponseBits = $scope.collectResponseBits;
	function init(){
     $scope.started = true;
        if (typeof Android !== "undefined" && Android !== null) {
            $scope.STdataStr = Android.runAndroidMethod("step3", "", "");
            $scope.STdata = JSON.parse($scope.STdataStr);
             console.log($scope.STdata);
            $scope.currSTKey = 0;
            getDetail($scope.STdata[$scope.currSTKey]);
            console.log($scope.STdatum);
        } else {
            alert("Not viewing in webview");
        }
    }
     $scope.step2 = function() {

            if (typeof Android !== "undefined" && Android !== null) {
             Android.runAndroidMethod("step2", "", "");

            } else {
                alert("Not viewing in webview");
            }
        }
     $scope.next = function() {
        $scope.currSTKey = $scope.currSTKey + 1;
        if($scope.currSTKey < $scope.STdata.length)
        {
         getDetail($scope.STdata[$scope.currSTKey]);
        }
     }
      $scope.prev = function() {
             $scope.currSTKey = $scope.currSTKey - 1 ;
             if($scope.currSTKey > -1)
             {
                 getDetail($scope.STdata[$scope.currSTKey]);
             }
          }
    function getDetail(mpcode) {
        if (typeof Android !== "undefined" && Android !== null) {
            var str = Android.runAndroidMethod("step5", "", mpcode);
            console.log("result of " +mpcode+ " is " + str);
            $scope.STdatum = JSON.parse(str);
            console.log($scope.STdatum);
        } else {
            alert("Not viewing in webview");
        }

    }
});