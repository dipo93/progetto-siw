<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Products</title>
</head>
<body>
	<f:view>
		<h1>Closed Orders</h1>
		<table>
			<tr>
				<th>ID</th>
				<th>Closure Time</th>
				<th>CustomerID</th>
			</tr>

			<c:forEach var="order" items="#{requestOrderController.orders}">
				<tr>
					<td>"#{order.id}"</td>
					<td>"#{order.closureTime}"</td>
					<td>
						<h:commandLink value="#{order.customer_id}" action="#{requestCustomerController.findCustomer}">
							<f:param name="customerId" value="#{order.customer_id}"/>
						</h:commandLink>
					</td>
					<td>
						<h:commandButton value="FILL" action="#{sessionOrderController.prepareOrderFilling}">
							<f:param name="id" value="#{order}"/>
						</h:commandButton>
					<td> 
				</tr>
			</c:forEach>
		</table>
	</f:view>
</body>
</html>