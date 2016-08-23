/**
 * http://usejsdoc.org/
 * 
 * 
 * 
 */

define(['bootstrap'],function () {
    
	function RestClient() {
		
	};
	
	RestClient.prototype.getName = function () {
			$.ajax({
				type : "GET",
				dataType : "json",
				url : "rest/myservices/getName",
				success : function(data) {
					return data.Name;
				}
			});
	};
	
	return new RestClient();
});




