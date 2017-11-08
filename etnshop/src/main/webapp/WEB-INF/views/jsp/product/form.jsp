<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>etnShop</title>

<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css"
	var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
</head>

<div class="container">
	<h2>Add Product</h2>
     <form:form method="POST" action="${pageContext.request.contextPath}/product/add" modelAttribute="product">
        <c:if test="${not empty product.id}">
            <form:input type="hidden" path="id" value="${product.id}" /></td>
        </c:if>
        <table>
           <tr>
               <td><form:label path="name">Name</form:label></td>
               <td><form:input path="name"/></td>
           </tr>
           <tr>
               <td><form:label path="serialNumber">Serial Number</form:label></td>
               <td><form:input path="serialNumber"/>${serialNumberErr}</td>
           </tr>
           <tr>
               <td><input type="submit" value="Submit"/></td>
           </tr>
       </table>
     </form:form>
	<p>
		<a class="btn btn-primary btn-lg" href="/etnshop" role="button">Back to homepage</a>
		<a class="btn btn-primary btn-lg" href="/etnshop/product/list" role="button">Back to List</a>
	</p>
	<footer>
		<p>&copy; Etnetera a.s. 2015</p>
	</footer>
</div>

<spring:url value="/resources/core/css/bootstrap.min.js"
	var="bootstrapJs" />

<script src="${bootstrapJs}"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</body>
</html>