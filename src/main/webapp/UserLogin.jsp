<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
</head>
<body>
 <jsp:include page="header.jsp"></jsp:include>
         
	<main class="container-fluid">

     <h1>User Login</h1>
     <br>
    <p id="message"></p>
    <form onsubmit="userLogin()" method="post">
     <label for="userEmail">UserEmail : </label>
     <input type="email" name="userEmail" id="userEmail" placeholder="Enter the Email" required autofocus>
     <br>
     <br>
     <label for="passWord">Password : </label>
     <input type="password" name="passWord" id="passWord" placeholder="Enter the password" required autofocus>
     <br>
     <br>
     <button class="btn btn-primary" type="submit">Submit</button>
     </form>
     </main>
     <script>
     
     function userLogin()
     {
     	event.preventDefault();
     	let userEmail =  document.querySelector("#userEmail").value;
     	let passWord =  document.querySelector("#passWord").value;
         let user = {
         		"userEmail" : userEmail,
         		"passWord" : passWord
         };
         console.log(user);
         localStorage.setItem("ROLE","USER");
         let url = "UserLogin";
         let content = "";
         axios.post(url,user).then(res=>{
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