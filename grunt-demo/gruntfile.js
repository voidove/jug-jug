/**
 * Created by owang on 9/24/15.
 */
module.exports = function(grunt) {

    require('load-grunt-tasks')(grunt);

    // Configure task(s)
    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),
        bower: {
            install: {
                options: {
                    targetDir: 'app/vendor',
                    cleanTargetDir: true,
                    layout: 'byComponent'
                }
            }
        },
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
        'bower',
        'sass'
    ]);

};
