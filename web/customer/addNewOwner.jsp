<%--
  Created by IntelliJ IDEA.
  User: Justin
  Date: 7/26/16
  Time: 10:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addNewOwner</title>
</head>
<body>
Add Owner
<br><br>
<form name="newOwnerForm" method="POST" action="/mvc_cust/saveNewOwner">
    First Name: <input type="text" name="firstname" /><br>
    Last Name: <input type="text" name="lastname" /><br>
    Phone: <input type="text" name="phone" /><br>
    Address: <input type="text" name="address" /><br>
    <input type="submit">
</form>
<a href="/">HOME</a>

</body>
</html>
