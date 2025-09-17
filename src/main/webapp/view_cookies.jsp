<%@ page import="jakarta.servlet.http.Cookie" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Cookies</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>
<h1>Cookies</h1>
<p>Here's a table with all of the cookies that this browser is sending to the current server.</p>

<table border="1" cellpadding="5" cellspacing="0">
    <tr><th>Name</th><th>Value</th></tr>
    <%
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
    %>
    <tr>
        <td><%= c.getName() %></td>
        <td><%= c.getValue() %></td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>
