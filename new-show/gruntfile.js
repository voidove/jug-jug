/**
 * Created by owang on 11/19/16.
 */
module.exports = function(grunt) {

  require('load-grunt-tasks')(grunt);

  // Configure task(s)
  grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),
    sass: {               // task
      options: {
        sourceMap: true
      },
      dist: {
        files: {
          'build/main.css': 'app/styles/main.scss'       // 'destination': 'source'
        }
      }
    }

  });

  // Register task(s)
  grunt.registerTask('default', [
    'sass'
  ]);

};