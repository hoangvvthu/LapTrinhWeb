<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Survey Result</title>
    <link rel="stylesheet" href="main.css" type="text/css"/>
</head>
<body>
<h1>Thanks for taking our survey!</h1>

<p>Here is the information that you entered:</p>

<label>Email:</label>
<span>${user.email}</span><br>

<label>First Name:</label>
<span>${user.firstName}</span><br>

<label>Last Name:</label>
<span>${user.lastName}</span><br>

<label>Heard From:</label>
<span>${user.heardFrom}</span><br>

<label>Wants Updates:</label>
<span>${user.wantsUpdates}</span><br>

<label>Contact Via:</label>
<span>${user.contactVia}</span><br>

<p>To take the survey again, click Return below.</p>

<!-- Return về form: gọi /survey?action=join (GET) -->
<form action="survey" method="get">
    <input type="hidden" name="action" value="join">
    <input type="submit" value="Return">
</form>
</body>
</html>
