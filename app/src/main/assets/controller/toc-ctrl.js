// SettingsController
//
simpeTools.controller('TOCController', function($scope) {


  init();

  function init() {
    //check for app readiness

    if (typeof Android !== "undefined" && Android !== null) {
      var reccount = Android.runAndroidMethod("readyRSMApp", "", "");
      if(reccount > 0)
      {
       $scope.isTOCAppReady = "true";
      }
      else
      {
       $scope.isTOCAppReady = "false";
      }
    } else {
      alert("Not viewing in webview");
    }
  }
  $scope.step1 = function() {
    if (typeof Android !== "undefined" && Android !== null) {
      Android.runAndroidMethod("step1", "", "");
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
  $scope.step4 = function() {
    if (typeof Android !== "undefined" && Android !== null) {
      Android.runAndroidMethod("step4", "", "2338");
    } else {
      alert("Not viewing in webview");
    }
  }
  $scope.initApp = function() {
    console.log("calling init RSM app");
    if (typeof Android !== "undefined" && Android !== null) {
      Android.runAndroidMethod("initRSMApp", "", "");
    } else {
      alert("Not viewing in webview");
    }
  }
  $scope.readyRSMApp = function() {
    if (typeof Android !== "undefined" && Android !== null) {
      Android.runAndroidMethod("readyRSMApp", "", "");
    } else {
      alert("Not viewing in webview");
    }
  }
});