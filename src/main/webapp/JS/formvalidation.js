$().ready(function(){
$('form').validate({
rules: {
uname: {
required: true,
minlength: 2
},
fname: {
	required: true,
	minlength: 2
},
lname: {
	required: true,
	minlength: 2
},
ssn:{
required:true,
minlength:9,
maxlength:9
},
email:{
	required:true
},
age:{
	min:18,
	max:100
	},
street: {
	required: true
},
apt: {
	required:true
},
city: {
	required:true
},
state: {
	required:true
},
password: {
required: true,
minlength: 5
},
confirm_password: {
required: true,
minlength: 5,
equalTo: password
}
},
messages: {
confirm_password: {
	equalTo: "please enter the same password"
},
ssn: {
	minlength:"Please enter valid ssn",
	maxlength:"Please enter valid ssn"
}
}

});

});
