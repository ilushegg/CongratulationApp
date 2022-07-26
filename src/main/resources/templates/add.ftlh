<#import "parts/common.ftlh" as c>

<@c.page>
    <form action="/add" method="post" enctype="multipart/form-data">
            <label for="">Name</label>
            <input type="text" name="name" />
            <label for="">Birthday</label>
            <input type="date" name="birthday">
            <label for="">Photo</label>
            <input type="file" name="file">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <input type="submit" value="Add">
        </form>
</@c.page>