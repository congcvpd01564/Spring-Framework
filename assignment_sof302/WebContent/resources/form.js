//Trang LOGIN;
function checkLogin() {
	var x = document.login;
	//check username
	if(x.username.value==""){
		//alert("Username is not empty");
		document.getElementById("error_username").innerHTML="Username is not empty !";
		x.username.focus();
		return false;
	}else{
		document.getElementById("error_username").innerHTML="";
	}
	//check password;
	if(x.password.value==""){
		//alert("Password is not empty");
		document.getElementById("error_password").innerHTML="Password is not empty !";
		x.password.focus();
		return false;
	}else{
		document.getElementById("error_password").innerHTML="";
	}
	return true;	
}
//Trang Account

function checkAccount(){
	var a = document.account;
	if(a.username.value==""){
		//alert("Username is not empty");
		document.getElementById("error_username").innerHTML="Username is not empty !";
		a.username.focus();
		return false;
	}else{
		document.getElementById("error_username").innerHTML="";
	}
	
	if(a.password.value==""){
		//alert("Password is not empty");
		document.getElementById("error_password").innerHTML="Password is not empty !";
		a.password.focus();
		return false;
	}else{
		document.getElementById("error_password").innerHTML="";
	}
	if(a.fullname.value==""){
		//alert("FullName is not empty");
		document.getElementById("error_fullname").innerHTML="Fullname is not empty !";
		a.fullname.focus();
		return false;
	}else{
		document.getElementById("error_fullname").innerHTML="";
	}
	return true;
}

//Trang Departs

function checkDepart(){
	var b = document.depart;
	//check id;
	if(b.id.value==""){
		//alert("ID is not empty");
		document.getElementById("error_id").innerHTML="Id is not empty !";
		b.id.focus();
		return false;
	}else{
		document.getElementById("error_id").innerHTML="";
	}
	//check name;
	if(b.name.value==""){
		//alert("Name is not empty");
		document.getElementById("error_name").innerHTML="Name is not empty !";
		b.name.focus();
		return false;
	}else{
		document.getElementById("error_name").innerHTML="";
	}
	return true;
}




   
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

