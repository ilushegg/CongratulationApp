<#import "parts/common.ftlh" as c>
<@c.page>
    <div>
        <#if message??>
            ${message}
        </#if>
    </div>
    <form action="/login" method="post">
        <div class="">
            <label>Email: </label>
            <input type="email" name="email" />
            <label>Password: </label>
            <input type="password" name="password" />
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <input type="submit" value="Sign In"/>
        </div>
    </form>

    <#include "parts/logout.ftlh">
</@c.page>
