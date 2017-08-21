const express = require('express');
const path = require('path');

const app = express();

// Use the static assets from the same directory as this server.js file
app.use(express.static(path.resolve("./")));

app.get('/', function(req, res) {
	res.sendFile('index.html');
});

const port = process.env.PORT || 3000;

const server = app.listen(port, function () {
	console.log('Listening on port:', port);
});