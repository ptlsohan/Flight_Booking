
    let url = "autocomplete?searchId=" + escape(from.value); 

$(function() {

     $.get(url, function (data) {
       
          return d.name
      
       $("#from").autocomplete({
         source: result
       });
      });
  });