<#import "parts/common.ftlh" as c>
<@c.page>
    <form action="/registration" method="post">
        <div class="">
            <label>Username: </label>
            <input type="text" name="username">
            <label>Password: </label>
            <input type="password" name="password">
            <label>Email: </label>
            <input type="email" name="email">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <input type="submit" value="Sign Up"/>
        </div>
    </form>
</@c.page>
