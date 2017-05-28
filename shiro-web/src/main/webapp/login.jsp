<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="${pageContext.request.contextPath}/">
    <title>Title</title>
</head>
<body>

<form action="login.action" method="post">

    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username"/></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="text" name="password"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="提交"/></td>

        </tr>
    </table>


</form>


</body>
</html>
