<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Order Details</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
	
	<main class="container-fluid">
	<h3>Order Details</h3>
	<table class="table table-bordered">
		<caption>List of order details</caption>
		<thead>
			<tr>
			    <th id="col">SNO</th>
			    <th id="col">vegetableID</th>
				<th id="col">Vegetable Name</th>
				<th id="col">Price(per kg)</th>
				<th id="col">Quantity</th>
				<th id="col">Total Price</th>
			</tr>
		</thead>
		<tbody id="cart">
		</tbody>
	</table>
	<label for="grossTotal"><strong>Gross Total :</strong></label>
		<input type="number" id="grossTotal" name="grossTotal" readonly>
	
	<br>
	<br>
	<a class="btn btn-success" role="button" href="ListVegetable.jsp"><strong>order again</strong></a>
	</main>
	<script>
	function orderedList(){
		let cartItemStr = localStorage.getItem("CART_ITEMS");
		let cartItems = cartItemStr == null ? [] : JSON
				.parse(cartItemStr);
		console.log(cartItems);
		 let content = "";
		 let i=0;
		 let sum =0;
		for(let cart of cartItems){
			console.log(cart);
			 content+="<tr><td>"+ ++i + "</td><td>" + cart.vegId +  "</td><td>" + cart.vegName + "</td><td> Rs. " + cart.price + "</td><td>" + cart.quantity + " kg</td><td>" + cart.totalPrice +"</td>";
				let price = parseInt(cart.totalPrice);
			 let obj = JSON.stringify(cart);
				sum += price;
		}
		console.log("Content"+ content);
		 document.querySelector("#cart").innerHTML = content;
		 document.querySelector("#grossTotal").value = sum;


	}
	
	orderedList();
	</script>
</body>
</html>