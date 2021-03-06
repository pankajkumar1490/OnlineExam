(function() {
    'use strict';

    angular
        .module('onlineProjectApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('home', {
            parent: 'app',
            url: '/',
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
