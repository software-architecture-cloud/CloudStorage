<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<div class="container">
    <div class="row d-flex justify-content-center">
        <div class="col-6">
            <h2>Add new user</h2>
            ${message?ifExists}
            <@l.login "/registration" />
        </div>
    </div>
    </@c.page>
