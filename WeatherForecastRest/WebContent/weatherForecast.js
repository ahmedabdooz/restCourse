function viewAllLications(){
	dojo.xhrGet({
		url : "/WeatherForecastRest/Observation",
		timeout : 5000,
		headers : {"Content-Type" : "application/json"},
		preventCache : true,
		handleAs : "json",
		handle : function(locations, ioArgs) {
			
			for (var i = 0; i < locations.length; i++) {
				var locationSelectionVar = document.getElementById("locationSelection");
				locationSelectionVar.style.display = "block";
				var option = document.createElement("option");
				option.text = locations[i].city;
				option.value = locations[i].id;
				locationSelectionVar.add(option);
			}
		}
	});
}

function getObservation(){
	var selection = document.getElementById("locationSelection");
	
	var selectionLocationId =selection.options[selection.selectedIndex].value;
	
	dojo.xhrGet({
		url : "../WeatherForecastRest/Observation/"+selectionLocationId,
		timeout : 5000,
		headers : {"Content-Type" : "application/json"},
		preventCache : true,
		handleAs : "json",
		handle : function(observation, ioArgs) {
			
				var observationDiv = document.getElementById("observationDiv");
				observationDiv.innerHTML = "<br/> the tempreture is "+observation.tempreture +"<br/><br/>"+
				"the weather is "+observation.weather;
		}
	});
}