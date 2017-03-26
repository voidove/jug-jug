module.exports = {
  context: __dirname + '/app',
  entry: __dirname + "/app/index.js",
  output : {
    path: __dirname + "/app",
    filename: "bundle.js"
  },
  module: {
    loaders: [
      {test: /\.js$/, loader: 'babel-loader', exclude: /node_modules/, query: {presets: ['es2015']}},
      {test: /\.scss$/, loader: 'style-loader!css-loader!sass-loader', exclude: /node_modules/}
    ]
  },
  devtool: "#inline-source-map"
}