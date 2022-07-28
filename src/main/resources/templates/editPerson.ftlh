<#import "parts/common.ftlh" as c>

<@c.page>
    <form method="post" enctype="multipart/form-data">
            <label for="">Name</label>
            <input type="text" name="name" value="${person.name?ifExists}"/>
            <label for="">Birthday</label>
            <input type="date" name="birthday" value="${person.birthday?ifExists}">
            <label for="">Photo</label>
            <input type="file" name="file">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <input type="submit" value="Edit">
        </form>
</@c.page>