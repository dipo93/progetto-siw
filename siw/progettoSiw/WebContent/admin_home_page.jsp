<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Siw Project</title>
</head>
<body>
	<f:view>
		<h1>Administrator HomePage</h1>
		<h2>"#{sessionAdminController.currentAdmin.firstName}" "#{sessionAdminController.currentAdmin.lastName}"</h2>
		<ul>
			<li><a href='<c:url value="/faces/newProduct.jsp" />'>Insert a new product</a></li>
			<li><h:commandLink action="#{requestOrderController.getClosedOrders}" value="FILL AN ORDER"/></li>
			<li><h:commandLink action="#{requestOrderController.getAllOrders}" value="SEE ALL ORDERS"/></li>
		</ul>
	</f:view>
</body>
</html>
