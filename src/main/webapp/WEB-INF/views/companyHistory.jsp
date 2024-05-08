<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>過去の振り返り（企業担当者様）</title>
</head>
<body>

	<p>${loginModel.name}さん</p>


	<form:form modelAttribute="historyModel">

	<form:textarea path="date"/>
		<form:textarea path="contents" />
			<%--<form:textarea path="comprehensionLevel" />--%>


		<input type="submit" value="検索">
	</form:form>


		<c:if test="${!empty formList}">
	<c:forEach var="form" items="${formList}">

	<p>${form.date}</p>
	<p>${form.name}</p>
	<p>${form.lessonType}</p>
	<p>${form.privacy}</p>
	<p>${form.contents}</p>
	<p>${form.comprehensionLevel}</p>
	<p>${form.unclearPoints}</p>
	<p>${form.evaluation}</p>
	<p>${form.commentOfInstructor}</p>
	<p>${form.commentOfToday}</p>


	</c:forEach>
	</c:if>

</body>
</html>