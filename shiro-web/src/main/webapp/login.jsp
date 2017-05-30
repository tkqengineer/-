<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="${pageContext.request.contextPath}/">
    <title>login</title>
</head>
<body>
登陆jsp

<form action="login.action" method="post">

    <input type="text" name="username">
    <input type="text" name="password">
    <input type="submit" value="提交">

</form>

</body>
</html>
