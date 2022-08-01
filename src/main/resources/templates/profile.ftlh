<#import "parts/common.ftlh" as c>

<@c.page>
    <div class="container">
        <form class="form form_person" method="post" enctype="multipart/form-data">
            <#if user.avatar??>
                <img class="avatar user_avatar" src="/img/${user.avatar?ifExists}" alt="">
            <#else>
                <img class="avatar user_avatar" src="/img/no_image.png" alt="">
            </#if>
            <input class="form__input" type="file" name="avatar"/>
            <input class="form__input" type="email" name="email" value="${user.email}" placeholder="Change your email"/>
            <input class="form__input" type="password" name="password" placeholder="Change your password" />
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <input class="button" type = "submit" value="Save" />
        </form>
    <div>

</@c.page>