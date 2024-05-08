<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録画面</title>
</head>
<body>
<h1>登録画面</h1>

	<form:form modelAttribute="traineeModel">

	<p>*必須</p>

	<p>ご自身の名前を入力してください。*<br>
	<form:textarea path="name"/></p>

	<p>パスワードを設定してください。*<br>
	<form:textarea path="password"/></p>

	<p>会社名を入力してください。*<br>
	<form:textarea path="companyName"/></p>

	<input type="submit" value="送信">
	</form:form>
</body>
</html>