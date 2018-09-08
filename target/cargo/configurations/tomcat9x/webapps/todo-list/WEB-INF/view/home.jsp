<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.yfy.util.Mappings" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Todo List Application</title>
</head>
<body>
<div align="center">
    <c:url var="itemsLink" value="${Mappings.ITEMS}"/>
    <h2>
        <a href="${itemsLink}">Show Todo Items</a>
    </h2>
</div>
</body>
</html>