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