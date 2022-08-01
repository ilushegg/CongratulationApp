<#include "values.ftlh">
<div class="container">
  <div class="navbar">
    <ul class="navbar_section">
      <li class="navbar_item">
        <a href="/main">Main</a>
      </li>
      <li class="navbar_item">
        <a href="/persons">Persons</a>
      </li>
      <li class="navbar_item">
        <a href="/add">Add</a>
      </li>
      <li class="navbar_item">
        <a href="/user/profile">Profile</a>
      </li>
    </ul>
    <ul class="navbar_section">
      <li class="navbar_item">
      <#if user??>
          <a href="/user/settings">Settings</a>
      <#else>
          <a class="signup_nav" href="/registration">Sign Up</a>
      </#if>
      </li>
      <li class="navbar_item">
        <#if user??>
          <a href="#" onclick="document.getElementById('logout').submit(); return false;">Sign Out</a>
        <#else>
          <a href="/login">Sign In</a>
        </#if>
      </li>
      <li class="navbar_avatar">
          <#if user??>
            <#if user.avatar??>
                <img class="avatar user_navbar" src="/img/${user.avatar?ifExists}" alt="">
            <#else>
                <img class="avatar user_navbar" src="/img/no_image.png" alt="">
            </#if>
          </#if>
      </li>
    </ul>
  </div>
</div>