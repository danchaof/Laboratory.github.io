/**
 * 
 */
window.onload = function() {
	var search = document.getElementById("search");

	search.onclick = function() {
		var urlshuju2 = "sname=" + document.getElementById("sname").value;

		var request = new XMLHttpRequest();	
		request.open("POST", "/Shiyanshi2/FindByNameServlet", true);
		request.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded");
		request.send(urlshuju2)

	};

};