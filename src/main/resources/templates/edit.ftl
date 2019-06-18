<#import "parts/common.ftl" as c>

<@c.page>
    Edit file
    <form method="post" action="/edit">
    <input type="text" name="editFile" value="${messageEdit.getContainsFile()}">
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <div>
    <#if messageEdit.getTypeFile() == ".bmp">
    <img src="/img/${messageEdit.getNameFile()}">
    </#if>
    </div>

    <button type="submit">Сохранить</button>
</@c.page>