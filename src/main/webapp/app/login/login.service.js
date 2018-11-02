(function () {
    'use strict';

    angular
        .module('onlineProjectApp')
        .factory('LoginService', LoginService);

    LoginService.$inject = ['$resource'];

    function LoginService ($resource) {
        var service = $resource('api/loginAuth', {}, {
            'query': {method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    data = angular.fromJson(data);
                    return data;
                }
            },
            'save': { method:'POST' },
            'update': { method:'PUT' },
            'delete':{ method:'DELETE'}
            
        });

        return service;
    }
    
})();

