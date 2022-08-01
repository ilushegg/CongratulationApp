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
        <a href="#">Profile</a>
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
    </ul>
  </div>
</div>