let values;

$("#parent-list").on("click", function(e) {
e.preventDefault();
//
		console.log("List item ", e.target.previousSibling.value);
//console.log(e.target.parentNode.parentNode);
//var tds = $(this).find('td');
//console.log(tds);
//$.each(tds, function(index, item) {
//	if(index===0){
//		values=item.innerHTML;
//	}
//});
//alert(values);
	
});