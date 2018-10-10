$(document).ready(function(){
	
	let id;
	$.get('fetchAirId', function(data){
		console.log(data);
		id=data;
		for(let i of data){
		var o = new Option(i, i);
		/// jquerify the DOM object 'o' so we can use the html method
		$(o).html(i);
		$("#air_id").append(o);
		}
		}
	);
	console.log('id list',id);
});