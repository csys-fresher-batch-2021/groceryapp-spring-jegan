<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Purchase Details</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<h3>UserPurchase Details</h3>
	<form onsubmit="userPurchaseDetails()" method="post">
	<p id="message"></p>
	<table class="table table-bordered">
		<caption>List of UserPurchase details</caption>
		<thead>
			<tr>
			    <th id="col">SNO</th>
			    <th id="col">ID</th>
				<th id="col">User Email</th>
				<th id="col">Total Amount</th>
				<th id="col">Purchase Date</th>
			</tr>
		</thead>
		<tbody id="userPurchase">
		</tbody>
	</table>
	</form>
</main>
	<script>
		  function userPurchaseDetails()
		  {
			  
			  let url="PurchaseHistroy";
			  fetch(url).then(res=> res.json()).then(res=>{
				  console.log("Response",res);
				  let userPurchase= res;
				 let content = "";
				 let role = localStorage.getItem("ROLE");
				 console.log(role);
				 let i=0;
				 for(let purchase of userPurchase)
					 {
					      content+="<tr><td>"+ ++i +  "</td><td>" + purchase.id + "</td><td> " + purchase.userEmail + "</td><td>" + purchase.totalAmount +"</td><td>" + purchase.purchaseDate +"</td>";
					 }
			         console.log("Content",content);
				 document.querySelector("#userPurchase").innerHTML = content;
			  });
		  }
		  
		  userPurchaseDetails();
		 </script>
</body>
</html>