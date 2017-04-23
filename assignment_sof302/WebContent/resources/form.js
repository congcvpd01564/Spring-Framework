//Trang LOGIN;
function checkLogin() {
	var x = document.login;
	//check username
	if(x.username.value==""){
		alert("Username is not empty");
		x.username.focus();
		return false;
	}
	//check password;
	if(x.password.value==""){
		alert("Password is not empty");
		x.password.focus();
		return false;
	}
	return true;	
}
//Trang Account

function checkAccount(){
	var a = document.account;
	if(a.username.value==""){
		alert("Username is not empty");
		a.username.focus();
		return false;
	}
	if(a.password.value==""){
		alert("Password is not empty");
		a.password.focus();
		return false;
	}
	if(a.fullname.value==""){
		alert("FullName is not empty");
		a.fullname.focus();
		return false;
	}
	return true;
}

//Trang Departs

function checkDepart(){
	var b = document.depart;
	//check id;
	if(b.id.value==""){
		alert("ID is not empty");
		b.id.focus();
		return false;
	}
	//check name;
	if(b.name.value==""){
		alert("Name is not empty");
		b.name.focus();
		return false;
	}
	return true;
}

//Trang Records
function checkRecord(){
	var c = document.record;
	//check id;
	if(c.id.value==""){
		alert("ID is not empty");
		c.id.focus();
		return false;
	}
	
	//check reason;
	if(c.reason.value==""){
		alert("Reason is not empty");
		c.reason.focus();
		return false;
	}
	//check type
	var one = document.getElementById("one");
	var zero = document.getElementById("zero");
	if ((one.checked == false) && (zero.checked == false)) {
    	alert("Please select type");
    	return false;
	//check date;
	if(c.date.value==""){
		alert("Date is not empty");
		c.date.focus();
		return false;
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
}
//Trang Staffs
function checkStaff(){
	var d= document.staff;
	//check id
	if(d.id.value==""){
		alert("ID is not empty");
		d.id.focus();
		return false;
	}
	//check name
	if(d.name.value==""){
		alert("Name is not empty");
		d.name.focus();
		return false;
	}
	//check gender
	var male = document.getElementById("male");
	var female = document.getElementById("female");
	if ((male.checked == false) && (female.checked == false)) {
    	alert("Please select gender");
    	return false;
	}
	//check photo.
	if(d.photo.value==""){
		alert("Photo is not empty");
		d.photo.focus();
		return false;
	}
	//check birthday
	if(d.birthday.value==""){
		alert("Birthday is not empty");
		d.birthday.focus();
		return false;
	}
	//check salary;
	var checksalary = isNaN(d.salary.value);
	if(d.salary.value==""){
		alert("Salary is not empty");
		d.salary.focus();
		return false;
	}
	//Salary is number.
	if(checksalary== true){
		alert("Salary format is number");
		d.salary.focus();
		return false;
	}
	//check email;
	/*
	1.Email không được rỗng
	2. Email phai ít nhất có 5 ký tự
	3.Email không bắt đầu bằng @.
	4.Sau ký tự '.' phải là ít nhất một ký tự khác nữa
	5.Giữa hai ký tự @ và '.' phải có ký tự.
	*/
	var mail = document.all.email.value;
	var acong = mail.indexOf('@');
	var dodai = mail.length-1;
	var daucham = mail.lastIndexOf('.');
	var daucach = mail.indexOf( );

	//check email
	
	if((dodai<=5)||(acong<1)||(daucham<=acong+1)||(daucach!=-1))
		{
    		alert("Please enter the email format. For example: abc@gmail.com");
    		d.email.focus();
    		return false;
		}
	//check phone
	var checkphone = isNaN(d.phone.value); //isNaN: is not a number;
	if(d.phone.value==""){
		alert("Phone is not empty");
		d.phone.focus();
		return false;
	}
	//Phone is number;
	if(checkphone==true){
		alert("Phone format is number");
		return false;
	}
	//check phone num 10 and 11;
	if((d.phone.value.length <10)||(d.phone.value.length >11)){
		alert("Phone numbers are 10 or 11 digits");
		d.phone.focus();
		return false;
	}
	//check notes
	if(d.notes.value==""){
		alert("Note is not empty");
		d.notes.focus();
		return false;
	}
	return true;
}
    
   
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

