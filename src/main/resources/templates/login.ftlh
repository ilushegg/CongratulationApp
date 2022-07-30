<#import "parts/common.ftlh" as c>
<@c.page>

<article class="form_container">
    <div class="form_container-inner">
    <div class="block">
        <section class="block__item block-item">
            <h2 class="block-item__title">Do you have an account?</h2>
            <button class="button block-item__btn signin-btn">Sign In</button>
        </section>
        <section class="block__item block-item">
            <h2 class="block-item__title signup-title">Don't you have an account?</h2>
            <button class="button block-item__btn signup-btn">Sign Up</button>
        </section>
        </div>
        <div>
            <#if message??>
                ${message}
            </#if>
        </div>
        <div class="form-box">
            <form class="form form_signin" action="/login" method="post">
                <h3 class="form__title">Sign In</h3>
                <p>
                    <input class="form__input" type="email" name="email" placeholder="Email"/>
                    <label class="form__text">We'll never share your email with anyone else.</label>
                </p>
                <p>
                    <input class="form__input" type="password" name="password" placeholder="Password" />
                </p>
                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <p>
                    <input class="button block-item__btn" type="submit" value="Sign In"/>
                    <a class="form__forgot" href="#">Forgot your password?</a>
                </p>
                <p>

                </p>
            </form>
            <form class="form form_signup" action="/registration" method="post">
                <h3 class="form__title">Sign Up</h3>
                <p>
                    <input class="form__input" type="text" name="username" placeholder="Username"/>
                </p>
                <p>
                    <input class="form__input" type="email" name="email" placeholder="Email"/>
                    <label class="form__text">We'll never share your email with anyone else.</label>
                </p>
                <p>
                    <input class="form__input" type="password" name="password" placeholder="Password" />
                </p>
                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <p>
                    <input class="button block-item__btn" type="submit" value="Sign Up"/>
                </p>
                <p>

                </p>
            </form>

        </div>
    </div>
</article>
</@c.page>
