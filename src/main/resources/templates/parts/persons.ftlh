
<table class="table">
  <tbody>
    <#list persons as person>
        <tr>
          <td>
            <img class="avatar" src="/img/${person.filename}" alt="">
          </td>
          <td>
            ${person.name}
          </td>
          <td>
            ${(person.birthday).getMonth()} ${(person.birthday).getDayOfMonth()}, ${(person.birthday).getYear()}
          </td>
        </tr>
    </#list>
  </tbody>
</table>