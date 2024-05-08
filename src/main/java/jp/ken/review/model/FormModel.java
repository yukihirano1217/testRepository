package jp.ken.review.model;

public class FormModel {

	private String date;
	private String name;
	private String lessonType;
	private String privacy;
	private String contents;
	private String comprehensionLevel;
	private String unclearPoints;
	private String evaluation;
	private String commentOfInstructor;
	private String commentOfToday;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLessonType() {
		return lessonType;
	}

	public void setLessonType(String lessonType) {
		this.lessonType = lessonType;
	}

	public String getPrivacy() {
		return privacy;
	}

	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getComprehensionLevel() {
		return comprehensionLevel;
	}

	public void setComprehensionLevel(String comprehensionLevel) {
		this.comprehensionLevel = comprehensionLevel;
	}

	public String getUnclearPoints() {
		return unclearPoints;
	}

	public void setUnclearPoints(String unclearPoints) {
		this.unclearPoints = unclearPoints;
	}

	public String getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}

	public String getCommentOfInstructor() {
		return commentOfInstructor;
	}

	public void setCommentOfInstructor(String commentOfInstructor) {
		this.commentOfInstructor = commentOfInstructor;
	}

	public String getCommentOfToday() {
		return commentOfToday;
	}

	public void setCommentOfToday(String commentOfToday) {
		this.commentOfToday = commentOfToday;
	}

}
