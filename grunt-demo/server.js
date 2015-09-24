/**
 * Created by owang on 9/24/15.
 */
/* *****************
 * Require Imports *
 * *****************/

var express = require('express');
var path = require('path');

/* ***********************
 * Initialize Middleware *
 * **********************/

// Instantiate the express object
var app = express();

// Use the static assets from the same directory as this server.js file
app.use(express.static(path.resolve("./")));

/* **************
 * GET Requests *
 * **************/

// index.html
app.get('/', function(req, res) {
    res.sendFile('index.html');
});

/* ******************
 * Start the server *
 * ******************/

var port = process.env.PORT || 8000;

var server = app.listen(port, function() {
    console.log('Listening on port:', port);
});