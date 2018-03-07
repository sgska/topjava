<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.4/css/bootstrap.min.css" integrity="2hfp1SzUoho7/TsGGGDaFdsuuDL0LX2hnUp6VkX3CUQ2K4K+xjboZdsXyp4oUHZj" crossorigin="anonymous">
    <title>Meals</title>
</head>
<body>
<div class="container">
<h3><a href="index.html">Home</a></h3>
<h2>Meals</h2>
<c:if test="${!empty meals}">
    <table class="table table-bordered table-hover">
        <thead>
        <tr>
            <th class="bg-info">Date time</th>
            <th class="bg-info">Description</th>
            <th class="bg-info">Calories</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${meals}" var="meal">
            <tr style="background: ${meal.exceed ? "red" : "green"}">
                <td>${localDateTimeFormat.parse(meal.dateTime)}</td>
                <td>${meal.description}</td>
                <td>${meal.calories}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

</div>
</body>
</html>