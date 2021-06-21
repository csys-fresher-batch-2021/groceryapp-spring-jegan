<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>ADD VEGETABLE</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
		
	
	<main class="container-fluid">

	<h1>Add Vegetable</h1>
	<form onsubmit="addVegetable()" method="post">
	<p id="message"></p>
		<label for="vegetableName">Vegetable Name : </label> <input
			type="text" name="vegetableName" id="vegetableName"
			placeholder="Enter the VegetableName" required autofocus /> <br>
		<br> <label for="vegetablePrice">Vegetable Price(Rs.) : </label> <input
			type="number" name="vegetablePrice" id="vegetablePrice" placeholder="Enter the price"
			required autofocus min="10"/> <br> <br> <label
			for="vegetableQuantity">Vegetable Quantity(kg) : </label> <input
			type="text" name="vegetableQuantity" id="vegetableQuantity" placeholder="Enter the quantity"
			required autofocus /> <br> <br>
		<button class="btn btn-primary" type="submit">Submit</button>
</form>
<script>
function addVegetable()
{
	event.preventDefault();
	let vegetableName =  document.querySelector("#vegetableName").value;
	let vegetablePrice =  document.querySelector("#vegetablePrice").value;
	let vegetableQuantity =  document.querySelector("#vegetableQuantity").value;
    let vegetable = {
    		"vegetableName" : vegetableName,
    		"price" : vegetablePrice,
    		"quantity" : vegetableQuantity,
    };
    console.log(vegetable);
    let url = "AddVegetable";
    content = "";
    axios.post(url,vegetable).then(res=>{
    	console.log("Success");
		let data = res.data;
		console.log(data);
		content+=data.infoMessage;
		document.querySelector("#message").innerHTML= content;	
    }).catch(err=>{
		console.log("Error");
		let data = err.response.data;
		console.log(data);	
		content+=data.errorMessage;
		document.querySelector("#message").innerHTML= content;
    });
	}
</script>
</main>
</body>
</html>