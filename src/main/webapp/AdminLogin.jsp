<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
  
	<main class="container-fluid">
	<h1>Admin Login</h1>
      <br>
      <p id="message"></p>
      <form onsubmit="adminLogin()" method="post">
     <label for="userEmail"><strong>User Email </strong> : </label>
     <input type="text" name="userEmail" id="userEmail" placeholder="Enter the email" required autofocus>
     <br>
     <br>
     <label for="passWord"><strong>Password </strong>: </label>
     <input type="password" name="passWord" id="passWord" placeholder="Enter the password" required autofocus>
     <br>
     <br>
     <button class="btn btn-primary" type="submit">Submit</button>
      </form>
      </main>
      
      <script>
     
     function adminLogin()
     {
     	event.preventDefault();
     	let userEmail =  document.querySelector("#userEmail").value;
     	let passWord =  document.querySelector("#passWord").value;
         let admin = {
         		"userEmail" : userEmail,
         		"passWord" : passWord
         };
         console.log(admin);
         localStorage.setItem("ROLE","ADMIN");
         let url = "AdminLogin";
         let content = "";
         axios.post(url,admin).then(res=>{
         	console.log("Success");
     		let data = res.data;
     		console.log(data);
     		content+=data.infoMessage;
     		alert(content);
     		window.location.href = "AddVegetable.jsp";
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