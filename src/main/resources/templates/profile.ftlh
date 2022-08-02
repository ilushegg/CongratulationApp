<#import "parts/common.ftlh" as c>

<@c.page>
    <div class="container">
        <form class="form form_person" method="post" enctype="multipart/form-data">
            <div>
                <#if user.avatar??>
                    <img class="avatar user_avatar" id="blah" src="/img/${user.avatar?ifExists}"  onclick='files.click()' alt="">
                <#else>
                    <img class="avatar user_avatar" src="/img/no_image.png" onclick='files.click()' alt="">
                </#if>
            </div>
            <div>
                <p>
                    <input class="form__input" accept="image/*"  onchange="loadFile(event)" type="file" name="avatar" id="files" hidden/>
                </p>
                <p>
                    <input class="form__input width" type="email" name="email" value="${user.email}" placeholder="Change your email"/>
                </p>
                <p>
                    <input class="form__input width" type="password" name="password" placeholder="Change your password" />
                </p>
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
            </div>
            <div class="column">
            <input class="button" type = "submit" value="Save" />
            </div>
        </form>
    <div>

</@c.page>