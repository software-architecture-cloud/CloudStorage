<#import "parts/common.ftl" as c>

<@c.page>
    Edit file
    <form method="post" action="/edit">
    <input type="text" name="editFile" value="${messageEdit.getContainsFile()}">
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <button type="submit">Сохранить</button>
</@c.page>