require.config({
    //By default load any module IDs from js/lib
   // baseUrl: 'js/lib',
    //except, if the module ID starts with "app",
    //load it from the js/app directory. paths
    //config is relative to the baseUrl, and
    //never includes a ".js" extension since
    //the paths config could be for a directory.
	 shim : {
		 "bootstrap" : { "deps" :['jQuery'] }
	    },
    paths: {
    	jQuery: 'lib/jquery',
    	bootstrap:'lib/bootstrap',
        restClient: 'app/rest-client'
    }
});

// Start the main app logic.
require([
         'restClient'
        ],
function   (restClient) {
	
	$("#jQueryId").click(function(){
		var name = restClient.getName();
		$("#nameResult").text(name);
		
	});
	

	
});