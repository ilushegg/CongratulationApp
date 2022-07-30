<#macro page>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
    <title>Congratulation Application</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/static/style.css">
    <script src="/static/script.js" defer></script>
</head>
<body>
<header>
    <#include "navbar.ftlh">
</header>


    <#nested>

<#include "logout.ftlh">
</body>
</html>
</#macro>