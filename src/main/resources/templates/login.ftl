<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<div class="container">
    <div class="row d-flex justify-content-center">
        <div class="col-6">
            <h2>Login page</h2>
            <@l.login "/login" />
            <a href="/registration">Add new user</a>
        </div>
    </div>
    </@c.page>
