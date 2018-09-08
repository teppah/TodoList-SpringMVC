<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.yfy.util.Mappings" %>
<html>
<head>
    <title>Item Details</title>
</head>
<body>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>Details of item</h2></caption>
        <tr>
            <td><label>ID</label></td>
            <td><c:out value="${todoItem.id}"/></td>
        </tr>
        <tr>
            <td><label>Title</label></td>
            <td><c:out value="${todoItem.title}"/></td>
        </tr>
        <tr>
            <td><label>Details</label></td>
            <td><c:out value="${todoItem.details}"/></td>
        </tr>
        <tr>
            <td><label>Deadline</label></td>
            <td><c:out value="${todoItem.deadline}"/></td>
        </tr>
    </table>
    <c:url var="itemsUrl" value="${Mappings.ITEMS}"/>

    <a href="${itemsUrl}">Back to the list of items</a>
</div>

</body>
</html>
