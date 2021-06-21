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
		<h3>List Of Vegetables</h3>
		<p id="message"></p>
		<table class="table table-bordered">
		<caption>Showing the List of Vegetables</caption>
		<thead>
		<tr><th id="col">Sno</th> <th id="col">Vegetable Name</th> <th id="col">Price(per kg)</th> 
		<th id="col">Quantity(kg)</th>
		<th id="col">Delete</th>
	    </tr>
		
		</thead>
		<tbody id="vegetable">	
			
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
				 let i=0;
				 for(let vegetable of vegetables)
					 {
					      content+="<tr><td>"+ ++i +  "</td><td>" + vegetable.vegetableName + "</td><td> Rs. " + vegetable.price + "</td><td>" + vegetable.quantity + " kg</td>"; 
					      content+="<td><button class = 'btn btn-danger' onclick = \"remove('"+vegetable.id+"')\">Remove</button</td></tr>"; 
					 }
			         console.log("Content",content);
				 document.querySelector("#vegetable").innerHTML = content;
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
		  getAllVegetables();
		</script>
</main>	
</body>
</html>