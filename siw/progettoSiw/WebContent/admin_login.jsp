<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Administrator Login</title>
</head>
<body>
	<f:view>
		<h:form>
			<div>
				Mail:
				<h:inputText value="#{sessionAdminController.eMail}" required="true"
					requiredMessage="mail address is mandatory" id="eMail" />
				<h:message for="eMail" />
			</div>
			<div>
				Password:
				<h:inputText value="" required="true"
					requiredMessage="password is mandatory" id="password" />
				<h:message for="password" />
			</div>
			<div>
				<h:commandButton value="Submit"
					action="#{sessionAdminController.logAdmin}" />
			</div>
		</h:form>
		
		<h1> ${loginError} </h1>
		
		<a href="/project-siw/faces/homePage.jsp">Indietro</a>
		<a href='<c:url value="/faces/homePage.jsp" />'>Indietro2</a>
	</f:view>
</body>
</html>