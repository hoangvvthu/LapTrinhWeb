<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Checkout</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>
<h1>Checkout</h1>
<p>Your order has been placed successfully!</p>
<form action="cart" method="post">
    <input type="hidden" name="action" value="shop">
    <input type="hidden" name="fromCheckout" value="true"> 
    <input type="submit" value="Return to Shop">
</form>
</body>
</html>

