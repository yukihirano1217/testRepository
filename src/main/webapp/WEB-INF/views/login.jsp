<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>

<form:form modelAttribute="loginModel">


	<p>名前を入力してください。*<br>
	<form:textarea path="name"/></p>

	<p>パスワードを入力してください。*<br>
	<form:textarea path="password"/></p>

	<input type="submit" value="ログイン">
	<a href="http://localhost:8080/review/regist">新規登録</a>
</form:form>
</body>
</html>