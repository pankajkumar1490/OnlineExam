(function() {
    'use strict';

    angular
        .module('onlineProjectApp')
        .controller('LoginController', LoginController);

    LoginController.$inject = ['$stateParams', 'entity', 'LoginService','$state','$http','toastr'];

    function LoginController ($stateParams, entity,LoginService,$state,$http,toastr) {
        var vm = this;   
        vm.login = login;
        vm.loginEntity = entity;
      
        function login() {
        	LoginService.save(vm.login, onSaveSuccess, onSaveError);
                          }        
        
        function onSaveSuccess (result,headers) {
        	toastr.success("User Matched successfully "+vm.user.uname)
                          }
        
        function onSaveError() {
        	toastr.success("User Not Matched successfully ")
                                }
           
        }
    
})();
