<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<html xmlns:th="http://www.thymeleaf.org" xmlns:spring="http://java.sun.com/xml/ns/javaee" xmlns:c="http://java.sun.com/jsp/jstl/core">

<@c.page>
    <div class="container">
        <div class="row  d-flex justify-content-end">
            <@l.logout />
        </div>
        <div class="row">
            <h2><a href="/user">User list</a></h2>
        </div>
        <div class="row">
            <form method="post" enctype="multipart/form-data">
                <input type="text" name="text" placeholder="Введите сообщение" class="form-control" />
                <input type="text" name="tag" placeholder="Тэг" class="form-control" >
                <input type="file" name="file" >
                <input type="hidden" name="_csrf" value="${_csrf.token}" class="form-control" />
                <button type="submit" class="btn btn-primary">Добавить</button>
            </form>
        </div>
        <div class="row">
            <div class="col-12">

                <form method="get" action="/main" class="row">
                    <input type="text" name="filter" value="${filter?ifExists}" class="form-control" >
                    <button type="submit" class="btn btn-primary">Найти</button>
                </form>

                <#list messages as message>
                    <div class="messages-item row">
                        <div class="col-12">
                            <b>${message.id}</b>
                            <span>${message.text}</span>
                            <i>${message.tag}</i>
                            <strong>${message.authorName}</strong>

                            <div>
                                <#if message.nameFile??>
                                    <h5>Название файла</h5>
                                    <p>${message.getNameFile()}</p>
                                    <h5 class="mt-5">Содержание файла</h5>
                                    <p>${message.getContainsFile()}</p>
                                </#if>
                            </div>

                            <form method="get" action="edit">
                                <input type="hidden" name="editFile" value="${message.getContainsFile()}" class="form-control" >
                                <input type="hidden" name="idMessage" value="${message.id}" class="form-control" />
                                <button type="submit" class="btn btn-primary">Редактировать</button>
                            </form>

                            <form method="get" action="actionfile">
                                <#list message.file.listAction>
                                    <#items as actionfile>
                                        <button type="submit" class="btn btn-primary" name="nameAction"value="${actionfile.nameAction}">${actionfile.nameAction}</button>
                                        <input type="hidden" name="idMessage" value="${message.id}" class="form-control" >
                                    </#items>

                                </#list>
                            </form>
                        </div>
                    </div>
                <#else>
                    No message
                </#list>
            </div>
        </div>
    </div>
    </div>
</@c.page>
