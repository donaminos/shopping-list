<!doctype html>
<html lang="en" ng-app="shopping-list">
<head>
<meta charset="utf-8">
<title>Shopping List</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href='http://fonts.googleapis.com/css?family=Nixie+One' rel='stylesheet' type='text/css'>
<link href="lib/fontello/css/fontello.css" rel="stylesheet">
<link href="lib/fontello/css/animation.css" rel="stylesheet">
<link rel="stylesheet" href="css/app.css" />
</head>
<body ng-controller="HomeController">

	<div class="container main">
		<div class="row">
			<div class="span2 offset3">
				<div class="menu">
					<header>
						<i class="icon-basket-alt"></i>
						<h4 class="title">Shopping List</h54>
					</header>
					<ul class="unstyled">
						<li ng-repeat="list in lists" ><a ng-click="loadList(list);" class="menu-item">{{list.name}}</a></li>
					</ul>
					<div class="btn-wrapper">
						<a ng-click="createList();" class="btn btn-block btn-warning">Nouvelle Liste</a>
					</div>
				</div>
			</div>
			<div class="span4">
				<div ng-show="lists.length>0" class="list">
					<h4 class="title" editable="updateList" contentEditable="true" ng-model="currentList.name" ></h4>
					<div class="wrapper">
						<form ng-submit="addItem()">
							<input ng-model="newItem" autofocus placeholder="Ajouter à la liste..." class="input-block-level" />
						</form>
						<ul class="unstyled items">
							<li ng-repeat="item in currentList.items">
								<a ng-click="removeItem(item);" class="pull-right"><i class="icon-cancel-circle"></i></a>
								<div editable="updateList" contentEditable="true" ng-model="item.name"></div>
							</li>
						</ul>
					</div>
					<!-- <section class="total">
						Total 19.30
					</section> -->
					<section class="actions">
						<a ng-click="deleteList();"><i class="icon-trash-1"></i> Supprimer</a>
					</section>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
	 -->
	<script src="lib/jquery-1.9.0.min.js"></script>

	<!-- In production use:
	<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.0.4/angular.min.js"></script>
	-->
	<script src="lib/angular/angular.min.js"></script>
	<script src="lib/angular/angular-resource.min.js"></script>
	
	<script src="js/app.js"></script>
	<script src="js/services.js"></script>
	<script src="js/controllers.js"></script>
	<script src="js/filters.js"></script>
	<script src="js/directives.js"></script>
</body>
</html>