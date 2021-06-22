<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
</head>
<body>
  
   <jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid"></main>

   <h1>User Registration</h1>
   <form onsubmit="addUser()" method=post>
   <p id="message"></p>
   <label for="userName">User Name : </label> 
   <input type="text" name="userName" id="userName" placeholder="Enter the UserName" required autofocus /> 
   <br>
   <br>
   <label for="passWord">PassWord : </label> 
   <input type="password" name="passWord" id="passWord" placeholder="Enter the PassWord" required autofocus /> 
   <br>
   <br>
   <label for="userName">MobileNumber : </label>
   <input type="number" name="userMobileNumber" id="userMobileNumber" placeholder="start with 91" required autofocus />
    <br>
    <br>
	<label for="userEmail">User Email: </label> 
   <input type="text" name="userEmail" id="userEmail" placeholder="Enter the UserEmail"  required autofocus /> 
   <br>
   <br>		
	<button class="btn btn-primary" type="submit">Submit</button>	
	</form>	
<br>
<ul>
<li><h5>username only contains characters and number</h5></li>
<li><h5>password contains characters,special characters and numbers[Eg.Jegan@123]</h5></li>

</ul>
<script>
function addUser()
{
	event.preventDefault();
	let userName =  document.querySelector("#userName").value;
	let passWord =  document.querySelector("#passWord").value;
	let userMobileNumber =  document.querySelector("#userMobileNumber").value;
	let userEmail =  document.querySelector("#userEmail").value;
    let userDetails = {
    		"userName" : userName,
    		"passWord" : passWord,
    		"mobileNumber" : userMobileNumber,
    		"userEmail" : userEmail
    };
    console.log(userDetails);
    let url = "AddUser";
    let content = "";
    axios.post(url,userDetails).then(res=>{
    	console.log("Success");
		let data = res.data;
		console.log(data);
		content+=data.infoMessage;
		alert(content);
		window.location.href = "ListVegetable.jsp";
    }).catch(err=>{
		console.log("Error");
		let data = err.response.data;
		console.log(data);	
		content+=data.errorMessage;
		document.querySelector("#message").innerHTML= content;
    });
	}
</script>
</body>
</html>