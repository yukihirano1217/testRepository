<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学習振り返りフォーム</title>
</head>
<body>

	<h1>
		<strong>学習振り返りフォーム</strong>
		<p>
			<small>本日の振り返りを記入してください。<br> ※不明点があればスタッフにお声がけください。</small>
		</p>
	</h1>

	<main>

	<form:form modelAttribute="formModel">
	<p>*必須</p>

	<p>1.回答日を選択してください。*<br>
	<form:textarea path="date"/></p>

	<p>2.ご自身の名前を入力してください*<br>
	<form:textarea path="name"/></p>

	<p>3.学習方法を選択してください。*<br>
	<form:textarea path="lessonType"/></p>

	<p>4.「肖像権使用同意書　兼　個人情報利用承諾書」の内容に同意していますか？<br>
		※「肖像権使用同意書　兼　個人情報利用承諾書」の案内を受けていない方はスタッフまでお声がけください<br>
	<form:textarea path="privacy"/></p>

	<p>5.本日の学習コンテンツをご記入ください。（例：AutoCAD、Java、Excel基礎etc..）*<br>
	<form:textarea path="contents"/></p>

	<p>6.本日の学習内容に対しての理解度を5段階評価してください。（最高評価：☆５）*<br>
	<form:textarea path="comprehensionLevel"/></p>

	<p>7.自分が今一番理解できていないと思うことをご記入ください。*<br>
	<form:textarea path="unclearPoints"/></p>

	<p>8.本日対応した講師について5段階評価してください。（最高評価：☆５）<br>
		※今後の参考とさせていただきます。厳粛な評価をお願い申し上げます。*<br>
	<form:textarea path="evaluation"/></p>

	<p>9.講師の対応に対して意見があればご記入ください。<br>
		※任意<br>
	<form:textarea path="commentOfInstructor"/></p>


	<p>10.本日の感想をご記入ください。（何が分かるようになって、何が分からなかったかetc..）*<br>
	<form:textarea path="commentOfToday"/></p>

	<input type="submit" value="送信" />
	<a href="http://localhost:8080/review/history"> 過去の振り返り </a>

</form:form>
	</main>
</body>
</html>