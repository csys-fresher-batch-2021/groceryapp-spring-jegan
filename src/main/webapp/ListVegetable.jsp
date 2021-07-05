<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Grocery</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<%
		String role = (String) session.getAttribute("ROLE");
		%>
		<h3>List Of Vegetables</h3>
		<p id="message"></p>
		<table class="table table-bordered" id="vegetable_table">
			<caption>Showing the List of Vegetables</caption>
			<thead>
				<tr>
					<th id="col">Sno</th>
					<th id="col">Vegetable Name</th>
					<th id="col">Price(per kg)</th>
					<th id="col">Quantity(kg)</th>
					<%
					if (role != null && role.equalsIgnoreCase("ADMIN")) {
					%>
					<th id="col">Delete</th>
					<%
					}
					%>
					<%
					if (role != null && role.equalsIgnoreCase("USER")) {
					%>
					<th id="col">Book</th>
				</tr>
				<%
				}
				%>
			</thead>
			<tbody>

			</tbody>
		</table>

		<script>
		  function getAllVegetables()
		  {
			  
			  let url="ListVegetables";
			  fetch(url).then(res=> res.json()).then(res=>{
				  console.log("Response",res);
				  let vegetables = res;
				 let content = "";
				 let role = localStorage.getItem("ROLE");
				 console.log(role);
				 let i=0;
				 $("#vegetable_table tbody").empty();
				 if (Object.keys(vegetables).length === 0)	
                 {
					 content+="<tr><td>"+ "No Items" +  "</td></tr>"
                 }
				 else
					 {
				        for(let vegetable of vegetables)
					 {     
				        	content+="<tr><td>"+ ++i +  "</td><td>" + vegetable.vegetableName + "</td><td> Rs. " + vegetable.price + "</td><td>" + vegetable.quantity + " kg</td>";
					   
					      if(role == "USER")
					    	  {
					    	  	let obj = JSON.stringify(vegetable);
					    	  content+="<td><button class = 'btn btn-primary' onclick='order("+obj+")'>Add to Cart</button</td></tr>"					    	  }
					      if(role == "ADMIN")
					    	  {
					             content+="<td><button class = 'btn btn-danger' onclick = \"remove('"+vegetable.id+"')\">Remove</button</td></tr>"; 
					    	  }
					 }
					 }
			         console.log("Content",content);
			         $("#vegetable_table tbody").append(content);
			     	$('#vegetable_table').DataTable();
			  });
		  }
		  
		   function remove(id)
		  {
			  let url = "DeleteVegetableById?id=" + id;
			  console.log(url);
			  content="";
				fetch(url).then(res=> res.json()).then(res=>{
					console.log("Success");
					 let data = res;
					console.log(data);
					content+=data.infoMessage;
					alert(content);
					window.location.href="ListVegetable.jsp";
				}).catch(err=>{
					console.log("Error");
					 let data = err.response;
					console.log(data);	
					content+=data.errorMessage;
					document.querySelector("#message").innerHTML= content; 	 
				});
		  } 
		   
		   function order(order)
		   {
			   alert("Added to your cart");
			   localStorage.setItem("order",JSON.stringify(order));
			   window.location.href="Order.jsp";
			  
		   }
		   
		   
		  getAllVegetables();
		</script>
	</main>
</body>
</html>
