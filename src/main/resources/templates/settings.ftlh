<#import "parts/common.ftlh" as c>

<@c.page>
<div class="container">
    <form method="post" class="form form_person">
        <div>Set the time for sending messages to your email</div>
        <div>
        <input class="form__input width" type="time" name="sendingTime" value="${user.sendingTime?ifExists}">
        </div>
        <div>
        <label>
            <input type="checkbox" name="allowSend" value="on" <#if user.allowSend?ifExists>checked</#if>>Allow sending messages by email
            <input type="hidden" name="allowSend" value="false"/>
        </label>
        </div>
        <div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input class="button block-item__btn" type="submit" value="Save" />
        </div>
    </form>
</div>
</@c.page>

