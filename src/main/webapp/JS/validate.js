

$().ready(function(){
	$.validator.addMethod( "dateNL", function( value, element ) {
		return this.optional( element ) || /^([12]\d)?(\d\d)[\.\/\-](0?[1-9]|1[012])[\.\/\-](0?[1-9]|[12]\d|3[01])$/.test( value );
	}, $.validator.messages.date );
	

	$.validator.addMethod( "time", function( value, element ) {
		return this.optional( element ) || /^([01]\d|2[0-3]|[0-9])(:[0-5]\d){1,2}(:[0-5]\d){1,2}$/.test( value );
	}, "Please enter a valid time, between 00:00:00 and 23:59:59" );
	$('form').validate({
	rules: {
	fno: {
	required: true
	},
	dtime: {
		required: true,
		time: true
	},
	ddate: {
		required: true,
		dateNL : true
	},
	atime: {
		required: true,
		time: true
	},
	adate: {
		required: true,
		dateNL : true
	},
	air_id: {
		required: true
	},
	d_city: {
		required:true
	},
	a_city: {
		required:true
	},
	eseat: {
		required:true
	},
	fseat: {
		required:true
	},
	bseat: {
		required:true
	}
	},
	messages: {
		fno: {
			required: "Please enter flight number"
			},
			dtime: {
				required: "Please enter departure time"
			},
			ddate: {
				required: "Please enter departure date",
				dateNL : "Invalid date format"
			},
			atime: {
				required: "Please enter arrival time"
			},
			adate: {
				required: "Please enter arrival date",
				dateNL : "Invalid date format"
			},
			air_id: {
				required: "Please select airplane id"
			},
			d_city: {
				required:"Enter departure city"
			},
			a_city: {
				required:"Enter arrival city"
			},
			eseat: {
				required:"Please enter seat number"
			},
			fseat: {
				required:"Please enter seat number"
			},
			bseat: {
				required:"Please enter seat number"
			}
	}

	});

	});
