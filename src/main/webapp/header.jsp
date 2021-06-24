<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/fontawesome.min.css">
<link rel="stylesheet" href="assets/css/style.css">

<script src="assets/js/axios.min.js"></script>
<%
String userEmail = (String)session.getAttribute("LOGGED_IN_USEREMAIL");
String role=(String)session.getAttribute("ROLE");
%>

<header>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
  <a class="navbar-brand" href="Home.jsp">GroceryApp</a>
  <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#collapsibleNavId" aria-controls="collapsibleNavId"
      aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavId">
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      <li class="nav-item active">
        <a class="nav-link" href="Home.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
       <% if(role != null && role.equalsIgnoreCase("ADMIN")) {%>
      <li class="nav-item">
        <a class="nav-link" href="AddVegetable.jsp">Add Vegetables</a>
      </li>
    <%} %>
       <li class="nav-item">
        <a class="nav-link" href="ListVegetable.jsp">Vegetables</a>
      </li>
    </ul>
     <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
      <li class="nav-item active">
      <%if (userEmail == null && role==null) {%>
        <a class="nav-link" href="UserRegistration.jsp">Register</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="UserLogin.jsp">Login</a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="AdminLogin.jsp">AdminLogin</a>
      </li>
      <%}else { %>
     <%  if(role!=null && role.equalsIgnoreCase("admin")){ %>
      <li class="nav-item active">
        <a class="nav-link" href="#">Welcome <%=role %></a>
      </li>
     <%} else if(role!=null && role.equalsIgnoreCase("USER")){ %>
     <li class="nav-item active">
     <a class="nav-link" href="#">Welcome <%=userEmail %></a>
   </li>
   <%} %>
      <li class="nav-item">
        <a class="nav-link" href="orderDetails.jsp">Cart</a>
      </li>
     <%} %>
      <li class="nav-item">
        <a class="nav-link" href="Logout" onclick="logout()">Logout</a>
      </li>
      </ul>
   
  </div>
</nav>
</header>
<script>
function logout(){
	localStorage.clear();
	sessionStorage.clear();
}
</script>