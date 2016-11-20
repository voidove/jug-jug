/**
 * Created by owang on 11/19/16.
 */

$(document).ready(function() {
  $('a.add-photo').on('click', function() {
    $('#myModal').foundation('reveal','open');
  });

  $('.upload-photo').on('click', function () {
    $.getJSON("../mock/data/image.json", function(data){
      var template = '{{#files}}<li class="column">'
        + '<div class="column small-1">{{id}}</div>'
        + '<div class="column small-3 img"><img src="{{url}}"></div>'
        + '<div class="column small-2 title">{{title}}</div>'
        + '<div class="column small-2 size">{{size}}</div>'
        + '<div class="column small-4 progress radius round" aria-valuenow="50"><span class="meter" style="width: 50%"></span></div>'
        +'</li>{{/files}}';
      var imgList = Mustache.render(template, data);
      $('.photo-list').html(imgList);
    });
  });

  $.getJSON("../mock/data/data.json", function(data){
    var template = '{{#files}}<li><a><img src="{{url}}"></a></li>{{/files}}';
    var imgList = Mustache.render(template, data);
    $('.content ul').html(imgList);
  });

});

