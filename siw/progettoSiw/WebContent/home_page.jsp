<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Siw Project</title>
</head>
<body>
	<f:view>
		<h1>Siw Project</h1>
		<h3>by Andrea di Fonzo, Elena Nieddu, Andrea Rossi</h3>
		<ul>
			<li><a href='<c:url value="/faces/customer_login.jsp" />'>autenticati come Cliente</a></li>
			<li><a href='<c:url value="/faces/admin_login.jsp" />'>autenticati come Amministratore</a></li>
			<li><a href='<c:url value="/faces/user_home_page.jsp" />'>prosegui senza autenticarti</a></li>
		</ul>
	</f:view>
</body>
</html>
