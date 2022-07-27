<#macro page>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
    <title>Congratulation Application</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/static/style.css">
</head>
<body>
<header>
    <#include "navbar.ftlh">
</header>
<div class="container mt-5">

    <#nested>
</div>
<#include "logout.ftlh">
</body>
</html>
</#macro>