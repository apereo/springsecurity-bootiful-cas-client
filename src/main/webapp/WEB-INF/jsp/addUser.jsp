<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Add Users</title>
</head>
<jsp:include page="menu.jsp"/>
<body>
<h3 style="color: red;">Add New User</h3>

<div id="addUser">
    <form:form action="/addUser" method="post"
               modelAttribute="usr">
        <p>
            <label>Enter Employee Id</label>
            <form:input path="userId"/>
        </p>
        <p>
            <label>Enter Name</label>
            <form:input path="userName"/>
        </p>
        <input type="SUBMIT" value="Submit"/>
    </form:form>
</div>
</body>
</html>
