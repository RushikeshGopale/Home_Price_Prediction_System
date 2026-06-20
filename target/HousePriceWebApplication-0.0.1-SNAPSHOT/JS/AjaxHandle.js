//function for search state
let searchState=(str)=>{
	let tableBody=document.getElementById("tbody");
	tableBody.innerHTML="";
	let xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange=function(){
		if(this.readyState==4 && this.status==200)
			{
				tableBody.innerHTML=this.responseText;
			}
	};
	xhttp.open("GET","/HousePriceWebApplication/SearchStateServlet?s="+ encodeURIComponent(str),true);
		xhttp.send();
}
//function for view city by state
let fetchCities=()=>{
	let stateDropDown=document.getElementById("state");
	let stateId=stateDropDown.value;
	if(stateId==="" || stateId==null)
		   {
		       console.log("No state selected");
		       return; //
		   }
	let Xhttp=new XMLHttpRequest();
	Xhttp.onreadystatechange=function(){
	    if(this.readyState==4 && this.status==200)
	    {
	           document.getElementById("d").innerHTML=this.responseText;
	     }
	        else
	        {
	            console.log("Error: "+this.status);
	        }
	}
Xhttp.open("GET","/HousePriceWebApplication/FetchStateWiseCity?stid="+encodeURIComponent(stateId),true);
			Xhttp.send();
}
//function for view location by city
let fetchCitiesForLoc=()=>{
	let stateDropDown=document.getElementById("state");
	let stateId=stateDropDown.value;
	let Xhttp=new XMLHttpRequest();
	Xhttp.onreadystatechange=function(){
	    if(this.readyState==4 && this.status==200)
	    {
	           document.getElementById("city").innerHTML=this.responseText;
			  // document.getElementById("loc").innerHTML="<option>Select Location</option>";
	     }
	}
Xhttp.open("GET","/HousePriceWebApplication/FetchStateWiseCityForLoc?stid="+encodeURIComponent(stateId),true);
			Xhttp.send();

}

function fetchUserProperty()
{
	alert("function called");
    let locid=document.getElementById("loc").value;
    let xhttp=new XMLHttpRequest();
    xhttp.onreadystatechange=function()
    {
        if(this.readyState==4 && this.status==200)
        {
            document.getElementById("tbody").innerHTML=this.responseText;
        }
    };
    xhttp.open("GET","/HousePriceWebApplication/FetchPropForUser?locid="+locid,true);
    xhttp.send();
}






let fetchLocForProperty=()=>{
	let stateDropDown=document.getElementById("city");
	let cityId=stateDropDown.value;
	let Xhttp=new XMLHttpRequest();
	Xhttp.onreadystatechange=function(){
	    if(this.readyState==4 && this.status==200)
	    {
	           document.getElementById("loc").innerHTML=this.responseText;
	     }
	};
Xhttp.open("GET","/HousePriceWebApplication/FetchCityWiseLoc?cityid="+encodeURIComponent(cityId),true);
			Xhttp.send();

}
//function for view location by city
function fetchLocation()
{
    let cityId=document.getElementById("city").value;
    let xhttp=new XMLHttpRequest();
    xhttp.onreadystatechange=function()
    {
        if(this.readyState==4 && this.status==200)
        {
            document.getElementById("locationData").innerHTML=this.responseText;
        }
    };
    xhttp.open("GET","/HousePriceWebApplication/ViewLocation?cityid="+cityId,true);
    xhttp.send();
}
//function for view property by location
function fetchProperty()
{
    let lId=document.getElementById("loc").value;
    let xhttp=new XMLHttpRequest();
    xhttp.onreadystatechange=function()
    {
        if(this.readyState==4 && this.status==200)
        {
            document.getElementById("propertyData").innerHTML=this.responseText;
        }
    };
    xhttp.open("GET","/HousePriceWebApplication/ViewProperty?lid="+lId,true);
    xhttp.send();
}

let checkUserExistance=(str)=>{
	let Xhttp=new XMLHttpRequest();
	Xhttp.onreadystatechange=function(){
	    if(this.readyState==4 && this.status==200)
	    {
	           document.getElementById("s").innerHTML=this.responseText;
	     }
	};
Xhttp.open("GET","/HousePriceWebApplication/CheckUserExistence?u="+encodeURIComponent(str),true);
			Xhttp.send();

}
