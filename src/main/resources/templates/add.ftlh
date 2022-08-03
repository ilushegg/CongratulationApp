<#import "parts/common.ftlh" as c>

<@c.page>
    <div class="container">
        <form class="form form_person" action="/add" method="post" enctype="multipart/form-data">
            <h3 class="form__title">Add a new person</h3>
            <div>

                    <img class="avatar user_avatar" id="blah" src="/img/no_image.png" onclick='files.click()' alt="">

            </div>

            <p>
                <input class="form__input" accept="image/*"  onchange="loadFile(event)" type="file" name="file" id="files" hidden/>
            </p>
            <p>
                <input class="form__input" type="text" name="name" placeholder="Name"/>
            </p>
            <p>
                <input class="form__input" type="date" name="birthday" placeholder="Birthday" />
            </p>
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <p>
                <input class="button block-item__btn" type="submit" value="Add"/>
            </p>
        </form>
    </div>
</@c.page>