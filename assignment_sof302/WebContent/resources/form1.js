//Trang Records
function checkRecord(){
	var c = document.record;
	//check id;
	if(c.id.value==""){
		//alert("ID is not empty");
		document.getElementById("error_id").innerHTML="ID is not empty !";
		c.id.focus();
		return false;
	}else{
		document.getElementById("error_id").innerHTML="";
	}
	
	//check reason;
	if(c.reason.value==""){
		//alert("Reason is not empty");
		document.getElementById("error_reason").innerHTML="Reason is not empty !";
		c.reason.focus();
		return false;
	}else{
		document.getElementById("error_reason").innerHTML="";
	}
	//check type
	var one = document.getElementById("one");
	var zero = document.getElementById("zero");
	if ((one.checked == false) && (zero.checked == false)) {
    	//alert("Please select type");
		document.getElementById("error_type").innerHTML="Please select type !";
    	return false;
	}else{
		document.getElementById("error_type").innerHTML="";
	}
	//check date;
	if(c.date.value==""){
		//alert("Date is not empty");
		document.getElementById("error_date").innerHTML="Date is not empty !";
		c.date.focus();
		return false;
	}else{
		document.getElementById("error_date").innerHTML="";
	}
	
	return true;
	/*
	var comp = document.all.dates.split('/')
    var d = parseInt(comp[0], 10)
    var m = parseInt(comp[1], 10)
    var y = parseInt(comp[2], 10)
    var date = new Date(y,m-1,d);
    if (date.getFullYear() == y && date.getMonth() + 1 == m && date.getDate() == d) {
      return true
    }
    alert(" Date format is mm/dd/yyyy ");
    c.date.focus();
    return false   
    */
}