'use strict';

/* Services */
angular.module('shopping-list.services', ['ngResource']).

factory('ShoppingList', function($resource){
	return $resource('api/shoppinglists/:id', {id:'@id'});
});