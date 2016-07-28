<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Justin
  Date: 7/26/16
  Time: 10:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Pet</title>
</head>
<body>
View Pet
<br><br>
<table>
    <tr>
        <td>PetID:</td>
        <td><c:out value="${pet.petId}" /></td>
    </tr>
    <tr>
        <td>Pet Name:</td>
        <td><c:out value="${pet.name}" /></td>
    </tr>
    <tr>
        <td>Pet Type:</td>
        <td><c:out value="${pet.petType}" /></td>
    </tr>
    <tr>
        <td>Owner Id:</td>
        <td><c:out value="${pet.ownerId}" /></td>
    </tr>
</table>
<br><br>
<a href="/">HOME</a>
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="/mvc_cust/viewAllPets">All Pets</a>
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="/mvc_cust/addNewPet"> Add Pets</a>
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="/mvc_cust/editPet?petId=<c:out value="${pet.petId}" />">Edit Pet</a>


</body>
</html>
