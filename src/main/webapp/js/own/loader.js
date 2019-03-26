$(document).ready(function() {
	loadCategories('MLC');
	loadCurrencies('MCO');
	loadListingTypes('MCO');
});

function loadCategories(countryId){
	$.ajax({ 
	      url: 'categories/list', 
	      data: 'countryId='+countryId, 
	      dataType: 'json',
	    })
	    .done(function(data) {
	    	$.each(data.data, function(index, item){
	    		$('#category').append($('<option>', { 
	    	        value: item.id,
	    	        text : item.name 
	    	    }));
	    	});	    		    	
	    });
}
function loadCurrencies(countryId){
	$.ajax({ 
	      url: 'https://api.mercadolibre.com/sites/'+countryId, 	   
	      dataType: 'json',
	    })
	    .done(function(data) {
	    	$.each(data.currencies, function(index, item){
	    		$('#currency').append($('<option>', { 
	    	        value: item.id,
	    	        text : item.id 
	    	    }));
	    	});	    		    	
	    });
}
function loadListingTypes(countryId){
	$.ajax({ 
	      url: 'listingtypes/list', 
	      data: 'countryId='+countryId, 
	      dataType: 'json',
	    })
	    .done(function(data) {
	    	$.each(data.data, function(index, item){
	    		$('#listingtype').append($('<option>', { 
	    	        value: item.id,
	    	        text : item.name 
	    	    }));
	    	});	    		   		    	
	    });
}