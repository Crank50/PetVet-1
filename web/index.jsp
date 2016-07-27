<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link type = "text/css" rel="stylesheet" href="Style.css">
  <title>$Title$</title>
</head>
<body style="background-color: lightblue">
<center> <h1>Welcome to the Pet Vet</h1> </center>
<form autocomplete="on">
  Enter Full Name:
  <input type="text" name="Full Name"/><br>
  <br>
  Join Email List:
  <input type="text" name="Email List"/> <br>
</form>
<p>Owner Options</p>
<table border="2">
  <th>
    <li><a href="mvc_cust/addNewOwner">Add New Owner</a><br></li>
    <br>
    <li><a href="mvc_cust/editOwner">Edit Owner</a><br></li>
    <br>
    <li><a href="mvc_cust/viewAllOwners">View All Owners</a><br></li>
    <br>
    <li><a href="mvc_cust/viewOwner">View Owner</a><br></li>
    <br>
  </th>
</table>

<p>Pet Options</p>
<table border ="2">
  <th>
    <li><a href="mvc_cust/addNewPet">Add New Pet</a><br></li>
    <br>
    <li><a href="mvc_cust/editPet">Edit Pet</a><br></li>
    <br>
    <li><a href="mvc_cust/viewAllPets">View All Pets</a><br></li>
    <br>
    <li><a href="mvc_cust/viewPet">View Pet</a><br></li>
    <br>
  </th>
</table>

</body>
</html>
