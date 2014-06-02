<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>Product</title>
</head>
<body>
	<f:view>
		<h1>Order "#{sessionOrderController.currentOrder.id}"</h1>
		<div>Creation Date:  "${sessionOrderController.currentOrder.creationTime}"</div>
		<div>Closure Date:  "${sessionOrderController.currentOrder.closureTime}"</div>
	
		<h2>OrderLines</h2>
			
		<tr>
			<th>Product</th>
			<th>Price per unit</th>
			<th>Requested Quantity</th>
			<th>Available Quantity</th>
		
		</tr>
		<c:forEach var="orderLine" items="#{sessionOrderController.orderLines}">
			<tr>
				<td>
					<h:commandLink value="#{orderLine.product.name}" action="#{requestProductController.findProduct}">
						<f:param name="customerId" value="#{orderLine.product.id}"/>
					</h:commandLink>
				</td>
				<td>"#{orderLine.unitPrice}"</td>
				<td>"#{orderLine.quantity}"</td>
				<td>"#{orderLine.product.quantity}"</td>
			</tr>
		</c:forEach>
		<div>
			<h:commandLink value="#{orderLine.product.name}" action="#{requestCustomerController.findCustomer}">
				<f:param name="customerId" value="#{order.customer_id}"/>
			</h:commandLink>
		</div>
			
		<h:commandButton value="FILL" action="#{sessionOrderController.fillCurrentOrder}"/>
	</f:view>
</body>
</html>