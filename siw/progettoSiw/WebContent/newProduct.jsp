<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Siw Project</title>
</head>
<body>
	<f:view>
		<h1>Insert new Product</h1>
		<h:form>
			<div>
				Name:
				<h:inputText value="#{RequestProductController.name}" 
					required="true" 
					requiredMessage="Name is mandatory" 
					id="name" />
				<h:message for="name" />
			</div>
			<div>
				Code:
				<h:inputText value="#{RequestProductController.code}"
					required="true" 
					requiredMessage="Code is mandatory" 
					id="code" />
				<h:message for="code" />
			</div>
			<div>
				Price:
				<h:inputText value="#{RequestProductController.price}"
					required="true" 
					requiredMessage="Price is mandatory"
					converterMessage="Price must be a number" 
					id="price" />
				<h:message for="price" />
			</div>
			<div>
				Description:
				<h:inputTextarea value="#{RequestProductController.description}"
					required="false" 
					cols="20" 
					rows="5" />
			</div>
			<div>
				<h:commandButton value="Submit"
					action="#{RequestProductController.createProduct}"/>
			</div>
			<h:commandLink action="#{RequestProductController.listProducts}"  value="List all Products" />
		</h:form>
	</f:view>
</body>
</html>