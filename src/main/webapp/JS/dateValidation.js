

$().ready(function(){
	$.validator.addMethod( "dateNL", function( value, element ) {
		return this.optional( element ) || /^([12]\d)?(\d\d)[\.\/\-](0?[1-9]|1[012])[\.\/\-](0?[1-9]|[12]\d|3[01])$/.test( value );
	}, $.validator.messages.date );
	


	$('form').validate({
		rules: {
		
		ondate: {
			required: true,
			dateNL: true
		}
		},messages: {
			ondate: {
					required: "Please enter departure date",
					dateNL : "Invalid date format"
				}
		}

	});

	});
