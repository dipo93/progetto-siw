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
		<h1>Order "#{requestOrderController.currentOrder.id}"</h1>
		<div>Creation Date:  "${requestOrderController.currentOrder.creationTime}"</div>
		<div>Closure Date:  "${requestOrderController.currentOrder.closureTime}"</div>
		<div>Filling Date:  "${requestOrderController.currentOrder.fillingTime}"</div>
		<div>Status:  "${requestOrderController.currentOrder.status}"</div>
	
		<h2>OrderLines</h2>
			
		<tr>
			<th>Product</th>
			<th>Price per unit</th>
			<th>Requested Quantity</th>		
		</tr>
		<c:forEach var="orderLine" items="#{requestOrderController.orderLines}">
			<tr>
				<td>
					<h:commandLink value="#{orderLine.product.name}" action="#{requestProductController.findOrder}">
						<f:param name="productId" value="#{orderLine.product.id}"/>
					</h:commandLink>
				</td>
				<td>"#{orderLine.unitPrice}"</td>
				<td>"#{orderLine.quantity}"</td>
			</tr>
		</c:forEach>		
	</f:view>
</body>
</html>