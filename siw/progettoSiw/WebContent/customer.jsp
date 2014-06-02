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
		<h1>Customer Information</h1>

		<h2>General Information</h2>
		<div>FirstName:  ${requestCustomerController.currentCustomer.firstName}</div>
		<div>LastName:  ${requestCustomerController.currentCustomer.lastName}</div>
		<div>Date of birth:  ${requestCustomerController.currentCustomer.dateOfBirth}</div>
		<div>Registration date:  ${requestCustomerController.currentCustomer.registrationDate}</div>


		<h2>Contacts</h2>
		<div>eMail:  ${requestCustomerController.currentCustomer.eMail}</div>
		<div>phone number:  ${requestCustomerController.currentCustomer.phoneNumber}</div>

		<h2><h:commandLink value="Address" action="#{requestAddressController.findAddress}">
				<f:param name="addressId" value="#{order.address_id}"/>
			</h:commandLink>
		</h2>
		
	</f:view>
</body>
</html>