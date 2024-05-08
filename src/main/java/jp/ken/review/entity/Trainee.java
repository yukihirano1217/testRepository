package jp.ken.review.entity;

import java.io.Serializable;

public class Trainee implements Serializable{
	private Integer traineeId;
	private String traineeName;
	private String passwaord;
	private String companyName;


	public Integer getTraineeId() {
		return traineeId;
	}
	public void setTraineeId(Integer traineeId) {
		this.traineeId = traineeId;
	}
	public String getTraineeName() {
		return traineeName;
	}
	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}
	public String getPasswaord() {
		return passwaord;
	}
	public void setPasswaord(String passwaord) {
		this.passwaord = passwaord;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}



}
