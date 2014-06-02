<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Product</title>
</head>
<body>
	<f:view>
		<h1>${requestProductController.product.name}</h1>
		<h2>Details</h2>
		<div>Code: ${requestProductController.product.code}</div>
		<div>Price: ${requestProductController.product.price}</div>
		<div>Description:
			${requestProductController.product.description}</div>
	</f:view>
</body>
</html>