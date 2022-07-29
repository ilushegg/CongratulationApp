<#import "parts/common.ftlh" as c>

<@c.page>
    <form method="post">
        <div>Set the time for sending messages to your email</div>
        <input type="time" name="sendingTime" value="${user.sendingTime?ifExists}">
        <label>
            <input type="checkbox" name="allowSend" value="on" <#if user.allowSend?ifExists>checked</#if>>Allow sending messages by email
            <input type="hidden" name="allowSend" value="false"/>
        </label>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input class="button" type="submit" value="Save" />
    </form>
</@c.page>

