<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Survey</title>
    <link rel="stylesheet" href="main.css" type="text/css"/>
</head>
<body>
    <div class="container">
         <header>
            <img src="murachlogo.png" alt="Murach Logo" style="height:100px;">
        </header>
        
        <h2>Thank you for completing our survey!</h2>
        <p>
            We truly appreciate the time you've taken to share your thought.<br>
            Here is the information you provided:
        </p>

        <div class="info-row"><div class="info-label">Email:</div>
            <div class="info-value">${user.email}</div></div>

        <div class="info-row"><div class="info-label">First Name:</div>
            <div class="info-value">${user.firstName}</div></div>

        <div class="info-row"><div class="info-label">Last Name:</div>
            <div class="info-value">${user.lastName}</div></div>

        <div class="info-row"><div class="info-label">Date of Birth:</div>
            <div class="info-value">${user.dateOfBirth}</div></div>

        <div class="info-row"><div class="info-label">How did you hear about us?</div>
            <div class="info-value">${user.hearAbout}</div></div>

        <div class="info-row"><div class="info-label">Announcements (offers):</div>
            <div class="info-value">${user.announceOffers}</div></div>

        <div class="info-row"><div class="info-label">Announcements (email):</div>
            <div class="info-value">${user.announceEmails}</div></div>

        <div class="info-row"><div class="info-label">Preferred Contact:</div>
            <div class="info-value">${user.contactMethod}</div></div>

        <p>
            Once again, thank you for your valuable input.<br>
            Please visit us again soon to stay updated on our latest products and special offers!
        </p>

        <form action="" method="get">
            <input type="hidden" name="action" value="join">
            <input type="submit" value="Return" id="submit">
        </form>
    </div>
</body>
</html>
