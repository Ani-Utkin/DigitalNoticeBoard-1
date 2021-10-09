<#import "/spring.ftl" as spring />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Activate account with Spring Boot, MongoDB, NGINX, Docker Compose</title>
</head>
<body>
   

    <@spring.bind "verificationForm"/>
    
    Sent a confirmation link to your inbox ${verificationForm.email}<br>
    
</body>
</html>