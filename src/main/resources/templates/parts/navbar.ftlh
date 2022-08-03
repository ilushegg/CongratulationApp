<#include "values.ftlh">
<div class="container">
  <div class="navbar">
    <ul class="navbar_section">
      <li class="navbar_item">
        <a class="navbar_hl" href="/main">Main</a>
      </li>
      <li class="navbar_item">
        <a class="navbar_hl" href="/persons">Persons</a>
      </li>
      <li class="navbar_item">
        <a class="navbar_hl" href="/add">Add</a>
      </li>
      <li class="navbar_item">
        <a class="navbar_hl" href="/user/profile">Profile</a>
      </li>
    </ul>
    <ul class="navbar_section">
      <li class="navbar_item">
      <#if user??>
          <a class="navbar_hl" href="/user/settings">Settings</a>
      <#else>
          <a class="navbar_hl" class="signup_nav" href="/registration">Sign Up</a>
      </#if>
      </li>
      <li class="navbar_item">
        <#if user??>
          <a class="navbar_hl" href="#" onclick="document.getElementById('logout').submit(); return false;">Sign Out</a>
        <#else>
          <a class="navbar_hl" href="/login">Sign In</a>
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