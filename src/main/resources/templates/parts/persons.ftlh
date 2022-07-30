<div class="container mt-5">
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
          <td>
             <a class="button" href="/persons/edit/${person.id}">Edit</a>
          </td>
          <td>
             <a class="button" href="/persons/delete/${person.id}">Delete</a>
          </td>
        </tr>
    </#list>
  </tbody>
</table>
</div>