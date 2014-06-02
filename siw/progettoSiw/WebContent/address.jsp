<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!DOCTYPE html>

<html>
<head>
<title>Address </title>
</head>
<body>
	<f:view>
		<div>street:  ${requestAddressController.address.street}</div>
		<div>country:  ${requestAddressController.address.country}</div>
		<div>state:  ${requestAddressController.address.state}</div>
		<div>zipcode:  ${requestAddressController.address.zipcode}</div>
	</f:view>
</body>
</html>

