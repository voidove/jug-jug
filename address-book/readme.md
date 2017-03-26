# Address Book with AngularJS and Webpack
It's a simple CRUD application with angularjs and webpack.
## Quick start
```bash
# change directory to your app
$ cd address-book

# install the dependencies with npm
$ npm install

# start the server
$ npm start
```
go to `http://localhost:8080` in your browser, if port`8080` is available.

## Introduction
### Project structure
```
address-book
|____app
| |____addressbook
| | |____controllers
| | | |____address-book-controller.js
| | |____directives
| | | |____address-book-directive.js
| | | |____address-book.html
| | | |____address-book.scss
| | |____models
| | | |____address-book-model.js
| |____addresses.json
| |____index.html
| |____index.js
|____package.json
|____readme.md
|____webpack.config.js
```

### Model
Model in AngularJS is a singleton defined by service. It provide API to access and manipulate data.

### Controller
Just an interlayer between model and view.

### View
In this application, we use `directive`.

### Scope
Each AngularJS application has exactly one `$rootScope`, all other scopes are descendant scopes of the root scope.
#### Directives that Create Scopes
In `/app/index.html` file, `ng-controller` create new instances of scope, `$scope`.
```html
  <div class="address-book-wrapper" ng-controller="addressBookCtrl">
    <address-book></address-book>
  </div>
```

Directive `address-book` nested in `ng-controller` with `scope: false`, it does not create a new scope and use the `ng-controller` scope object.

`ng-repeat` nested in `address-book` directive creates new scope.