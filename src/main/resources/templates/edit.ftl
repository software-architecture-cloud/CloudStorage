<#import "parts/common.ftl" as c>

<@c.page>
    <div class="container">
        <div class="row">
            <div class="col-12" style="text-align: center">
                <h2>Edit file</h2>
                <form method="post" action="/edit">
                    <input type="text" name="editFile"  value="${messageEdit.getContainsFile()}" class="form-control">
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <div>
                        <#if messageEdit.getTypeFile() == "bmp">
                            <h2>Lol</h2>
                            <img src="/img/${messageEdit.nameFile}">
                        </#if>
                    </div>
                    <button type="submit" class="btn btn-primary">Сохранить</button>
            </div>
        </div>
    </div>
</@c.page>