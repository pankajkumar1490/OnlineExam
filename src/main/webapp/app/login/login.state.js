(function() {
    'use strict';

    angular
        .module('onlineProjectApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('login-main', {
            parent: 'app',
            url: '/login-page',
            data: {
                authorities: []
            },
            views: {
                'content@': {
                    templateUrl: 'app/login/login.html',
                    controller: 'LoginController',
                    controllerAs: 'vm'
                }
            }
        });
    }
})();
