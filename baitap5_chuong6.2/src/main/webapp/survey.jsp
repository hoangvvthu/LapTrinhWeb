<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Survey Result</title>
    <link rel="stylesheet" href="main.css" type="text/css"/>
</head>
<body>
<h1>Thanks for taking our survey!</h1>
<p>Here is the information that you entered:</p>
<p>Email: ${user.email}</p>
<p>First Name: ${user.firstName}</p>
<p>Last Name: ${user.lastName}</p>
<p>Heard From: ${user.heardFrom}</p>
<p>Wants Updates: ${user.wantsUpdates}</p>
<p>Contact Via: ${user.contactVia}</p>

<form action="index.html" method="get">
    <input type="submit" value="Return">
</form>
</body>
</html>
