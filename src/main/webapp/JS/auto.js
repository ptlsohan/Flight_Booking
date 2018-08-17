

let val=[];
$(document).ready(function() {
	 $('#from').blur(function(event) {
            var name = $('#from').val();
            $.get('autocomplete', {
                    city : name
            }, function(data) {
            	console.log(data);
            	val.push(data);
            	console.log(val);
           });
            
           
	 } );
	 $("#from").autocomplete({
         source: val
       });
           
            $('#to').change(function(event) {
                var name = $('#to').val();
                $.get('autocomplete', {
                        city : name
                }, function(data) {
                	console.log(data);
                	val.push(data);
                	console.log(val);
               });
                
                $("#to").autocomplete({
                    source: val
                  });
            } );
            
//            $.get('autocomplete',{ city:name},function(data){
//           	   console.log('autocomplete data',data);
//            	alert('callback called');
//            	return data;
//            });
//            $("#from").autocomplete({
//            source: data
//          });
//            $.ajax("autocomplete", {
//            	dataType: "json",
//            	data: name,
//            	success: function(data) {
//            	console.log(data);
//            	list:data
//            	},
//            	error: function(jqXHR, textStatus, errorThrown) {
//            	console.log(textStatus); //error logging
//            	}
//            	});
//            
//            $("#from").autocomplete({
//              source: list
//            });
            
            
            
	
});

