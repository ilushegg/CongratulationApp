<#import "parts/common.ftlh" as c>
<@c.page>
    <div>
        <#if message??>
            ${message}
        </#if>
    </div>
    <form class="form mt" action="/login" method="post">
        <div class="mb-3">
            <label class="form-label">Email: </label>
            <input class="form-control" type="email" name="email" />
            <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
        </div>
        <div class="mb-3">
            <label class="form-label">Password: </label>
            <input class="form-control" type="password" name="password" />
        </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <input class="button" type="submit" value="Sign In"/>
    </form>
</@c.page>
