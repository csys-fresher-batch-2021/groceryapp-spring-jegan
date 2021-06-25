<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Order</title>
</head>
<body>
 <jsp:include page="header.jsp"></jsp:include>
	
	<main class="container-fluid">
		<h2>place an order</h2>
		
			<label for="vegetableName">Vegetable Name : </label> <input
				type="text" name="vegetableName" id="vegetableName" required
				autofocus  readonly/> <br> <br> <label
				for="vegetablePrice">Vegetable Price(Rs.) : </label> <input type="text"
				name="vegetablePrice" id="rate"  required
				autofocus  readonly/> <br> <br> <label
				for="vegetableQuantity">Vegetable Quantity(kg) : </label> <input
				type="text" name="vegetableQuantity" id="quantity" required
				autofocus />
			<button type="button" onclick="calculateTotalPrice()">Get Price</button>
			<br> <br> <label for="totalPrice"> Total
				Price(Rs.): </label> <input type="text" name="totalPrice" id="totalPrice"
				autofocus /> <br> <br>
			<button type="submit">order</button>

		
	</main>
	<script>
	function calculateTotalPrice()
    {
		let vegetablePrice =  document.querySelector("#rate").value;
		let vegetableQuantity =  document.querySelector("#quantity").value;
		document.getElementById("totalPrice").value = vegetablePrice
		* vegetableQuantity;
		let vegetable = {
	    		
	    		"price" : vegetablePrice,
	    		"quantity" : vegetableQuantity
	    };
	    console.log(vegetable);
		
    }
	let order = JSON.parse(localStorage.getItem('order'));	
	console.log(order);
	document.querySelector("#vegetableName").value = order.vegetableName;
	document.querySelector("#rate").value = order.price;
	</script>
    
</body>
</html>