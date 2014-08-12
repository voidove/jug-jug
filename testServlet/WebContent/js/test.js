
$(document).ready(function() {
  $('#somebutton').click(function() {                  // Locate HTML DOM element with ID "somebutton" and assign the following function to its "click" event...
    $.get('TestAjaxServlet', function(responseJson) {    // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON...
        var $ul = $('<ul>').appendTo($('#somediv')); // Create HTML <ul> element and append it to HTML DOM element with ID "somediv".
        $.each(responseJson, function(index, item) { // Iterate over the JSON array.
            $('<li>').text(item).appendTo($ul);      // Create HTML <li> element, set its text content with currently iterated item and append it to the <ul>.
        });
    });
});
});
