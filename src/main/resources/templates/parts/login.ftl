<#macro login path>
    <form action="${path}" method="post">
        <div class="form-group">
            <label> User Name : <input type="text" name="username" class="form-control"/> </label>
        </div>
        <div><label> Password: <input type="password" name="password" class="form-control"/> </label></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div><input type="submit" value="Sign In" class="btn btn-primary"/></div>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input type="submit" class="btn btn-primary" value="Sign Out"/>
    </form>
</#macro>
