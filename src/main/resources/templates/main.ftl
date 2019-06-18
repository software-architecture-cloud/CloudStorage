<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<html xmlns:th="http://www.thymeleaf.org" xmlns:spring="http://java.sun.com/xml/ns/javaee" xmlns:c="http://java.sun.com/jsp/jstl/core">

<@c.page>
<div>
    <@l.logout />
    <span><a href="/user">User list</a></span>
</div>
<div>
    <form method="post" enctype="multipart/form-data">
        <input type="text" name="text" placeholder="Введите сообщение"/>
        <input type="text" name="tag" placeholder="Тэг">
        <input type="file" name="file">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit">Добавить</button>
    </form>
</div>
<div>Список сообщений</div>
<form method="get" action="/main">
    <input type="text" name="filter" value="${filter?ifExists}">
    <button type="submit">Найти</button>
</form>
    <#list messages as message>
<div>
    <b>${message.id}</b>
    <span>${message.text}</span>
    <i>${message.tag}</i>
    <strong>${message.authorName}</strong>

<#--<div>-->
<#--<#if message.filename??>-->
<#--<img src="/img/${message.filename}">-->
<#--</#if>-->
<#--</div>-->

    <div>
    <#if message.nameFile??>
        <div>Название файла</div>
        <span>${message.getNameFile()}</span>
        <div>Содержание файла</div>
        <span>${message.getContainsFile()}</span>
    </#if>
    </div>



    <form method="get" action="edit">
        <input type="hidden" name="editFile" value="${message.getContainsFile()}">
        <input type="hidden" name="idMessage" value="${message.id}"/>
        <button type="submit">Редактировать</button>
    </form>

        <#list message.file.listAction>
            <#items as actionfile>
            <button type="submit">${actionfile.nameAction}</button>
            </#items>

        </#list>
        <#--<td th:each="actionfile : ${actionsfile}">-->
            <#--<tr><span th:text="${actionfile.nameAction}"> 123 </span></tr>-->
             <#--&lt;#&ndash;<a th:href="@{/main/(nameAction = ${action.getNameAction()})}" >&ndash;&gt;-->
             <#--&lt;#&ndash;<button type="button" class="btn btn-primary" th:text="#{action.getNameAction()}"></button>&ndash;&gt;-->
        <#--</td>-->
    <#--<span th:text="${actions}">12</span>-->

</div>
    <#else>
No message
    </#list>
</@c.page>
