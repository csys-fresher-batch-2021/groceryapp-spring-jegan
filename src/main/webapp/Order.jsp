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
		<form onsubmit="orderVegetbale()">
			<label for="vegetableName">Vegetable Name : </label> <input
				type="text" name="vegetableName" id="vegetableName" required
				autofocus readonly /> <br> <br> <label
				for="vegetablePrice">Vegetable Price(Rs.) : </label> <input
				type="text" name="vegetablePrice" id="rate" required autofocus
				readonly /> <br> <br> <label for="vegetableQuantity">Vegetable
				Quantity(kg) : </label> <input type="text" name="vegetableQuantity"
				id="quantity" required autofocus />
			<button type="button" onclick="calculateTotalPrice()">Get
				Price</button>
			<br> <br> <label for="totalPrice"> Total
				Price(Rs.): </label> <input type="text" name="totalPrice" id="totalPrice"
				autofocus /> <br> <br>
			<button type="submit">order</button>
		</form>

	</main>
	<script>
		let order = JSON.parse(localStorage.getItem('order'));
		console.log(order);
		document.querySelector("#vegetableName").value = order.vegetableName;
		document.querySelector("#rate").value = order.price;
		let vegetablePrice = document.querySelector("#rate").value;
		let vegetableQuantity = document.querySelector("#quantity");
		function orderVegetbale() {
			event.preventDefault();
			let vegetableId = order.id;
			let vegetableName = document.querySelector("#vegetableName").value
			let total = document.getElementById("totalPrice").value

			let cartItem = {
				vegId : vegetableId,
				vegName : vegetableName,
				quantity : vegetableQuantity.value,
				price : vegetablePrice,
				totalPrice : total
			};

			let cartItemStr = localStorage.getItem("CART_ITEMS");
			let cartItems = cartItemStr == null ? []: JSON.parse(cartItemStr);
			cartItems.push(cartItem);
			console.log(cartItems);

			localStorage.setItem("CART_ITEMS", JSON.stringify(cartItems)); 
			window.location.href = "OrderDetails.jsp";		
			}
		function calculateTotalPrice() {
			
			document.getElementById("totalPrice").value = vegetablePrice
					* vegetableQuantity.value;
		}
	</script>

</body>
</html>