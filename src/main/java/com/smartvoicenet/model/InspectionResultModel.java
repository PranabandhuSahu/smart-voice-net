package com.smartvoicenet.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class InspectionResultModel {

	private String inspectionId;
	private String phone;
	private String originalResult;//1st filed name was inspectionResult
	private String callStartTime;
	private String durationOfCall;
	private String callername;
	private String callerType;
	private String Score;
	private ExplainResult phrase;
	private String language;
	private String callerId;
	private Integer userThreshold;
	private String inspectionMode;
	private String filename;
	
	@JsonFormat(pattern="MM-dd-yyyy HH:mm:ss")
	private LocalDateTime date;
	private String donatedTime;
	private String callType;
	private String transcript;//orginal filed is convertedText
	private String protectionAction;
	private String callEndTime;
	private String protectionActionTime;
	private String type;//earlier filed name was inspectionResultUpdate
	private String audioSrc;//newly added filed
	private boolean live;//added as per Spandan's requirement
	
	public String getInspectionId() {
		return inspectionId;
	}
	public void setInspectionId(String inspectionId) {
		this.inspectionId = inspectionId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhoneNumber(String phone) {
		this.phone = phone;
	}
	public String getoriginalResult() {
		return originalResult;
	}
	public void setoriginalResult(String originalResult) {
		this.originalResult = originalResult;
	}
	public String getCallStartTime() {
		return callStartTime;
	}
	public void setCallStartTime(String callStartTime) {
		this.callStartTime = callStartTime;
	}
	public String getDurationOfCall() {
		return durationOfCall;
	}
	public void setDurationOfCall(String durationOfCall) {
		this.durationOfCall = durationOfCall;
	}
	public String getCallername() {
		return callername;
	}
	public void setCallername(String callername) {
		this.callername = callername;
	}
	public String getCallerType() {
		return callerType;
	}
	public void setCallerType(String callerType) {
		this.callerType = callerType;
	}
	public ExplainResult getPhrase() {
		return phrase;
	}
	public void setPhrase(ExplainResult phrase) {
		this.phrase = phrase;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCallerId() {
		return callerId;
	}
	public void setCallerId(String callerId) {
		this.callerId = callerId;
	}
	public Integer getUserThreshold() {
		return userThreshold;
	}
	public void setUserThreshold(Integer userThreshold) {
		this.userThreshold = userThreshold;
	}
	public String getInspectionMode() {
		return inspectionMode;
	}
	public void setInspectionMode(String inspectionMode) {
		this.inspectionMode = inspectionMode;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public String getDonatedTime() {
		return donatedTime;
	}
	public void setDonatedTime(String donatedTime) {
		this.donatedTime = donatedTime;
	}
	public String getCallType() {
		return callType;
	}
	public void setCallType(String callType) {
		this.callType = callType;
	}
	public String getProtectionAction() {
		return protectionAction;
	}
	public void setProtectionAction(String protectionAction) {
		this.protectionAction = protectionAction;
	}
	public String getCallEndTime() {
		return callEndTime;
	}
	public void setCallEndTime(String callEndTime) {
		this.callEndTime = callEndTime;
	}
	public String getProtectionActionTime() {
		return protectionActionTime;
	}
	public void setProtectionActionTime(String protectionActionTime) {
		this.protectionActionTime = protectionActionTime;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAudioSrc() {
		return audioSrc;
	}
	public void setAudioSrc(String audioSrc) {
		this.audioSrc = audioSrc;
	}
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	public String getTranscript() {
		return transcript;
	}
	public void setTranscript(String transcript) {
		this.transcript = transcript;
	}
	public String getScore() {
		return Score;
	}
	public void setScore(String score) {
		Score = score;
	}

}
