package com.smartvoicenet.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.smartvoicenet.configuration.SVNCustomGenerator;

@Entity
@Table(name="SVNDB")
public class InspectionResultEntity {
	@Id
	@Column(name="isId")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INSPECTION_SEQ")
	@GenericGenerator(name = "INSPECTION_SEQ", strategy = "com.smartvoicenet.configuration.SVNCustomGenerator", parameters = {
			@Parameter(name = SVNCustomGenerator.INCREMENT_PARAM, value = "01"),
			@Parameter(name = SVNCustomGenerator.VALUE_PREFIX_PARAMETER, value = "SVN_"),
			@Parameter(name = SVNCustomGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String inspectionId;

	@Column(name="ph_nbr")
	private String phoneNumber;
	@Column(name="isp_rslt")
	private String inspectionResult;
	@Column(name="clstartTm")
	private String callStartTime;
	@Column(name="duration")
	private String durationOfCall;
	@Column(name="clrname")
	private String callername;
	@Column(name="clr_typ")
	private String callerType;
	@Column
	private String authScore;
	@Column(name="htsptphrcnt")
	private Integer hotspotPhraseCount;
		
	@Column
	private Integer totalHotspot;
	
	@ElementCollection
	@CollectionTable(name = "hotspot_phrase_mapping", joinColumns = {
			@JoinColumn(name = "htpstPhrId", referencedColumnName = "isId") })
	@MapKeyColumn(name = "htspt_phrs")
	private Map<String, Integer> hotspotPhrases = new HashMap<String, Integer>();

	@ElementCollection
	@CollectionTable(name = "urgency_phrase_mapping", joinColumns = {
			@JoinColumn(name = "urg_phr_id", referencedColumnName = "isId") })
	@MapKeyColumn(name = "urgency_phrase")
	private Map<String, Integer> urgencyPhrases = new HashMap<String, Integer>();

	@Column
	private Integer urgencyPhraseCount;
	
	@Column
	private Integer totalUrgency;
	
	@Column
	private Integer grammaticalErrorCounts;

	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "grmrPhrs")
	@OrderColumn(name = "gramm_err_index")
	@Column(name = "gramm_err_phrases")
	@JoinColumn(name = "gramm_err_fid", referencedColumnName = "isId")
	private List<String> grammaticalErrorPhrases = new ArrayList<String>();

	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "smrprbTbl")
	@OrderColumn(name = "smartprobe_err_index")
	@Column(name = "smartprobe_err_qs")
	@JoinColumn(name = "smrtErrId", referencedColumnName = "isId")
	private List<String> smartProbeErrorQs = new ArrayList<String>();
	@Column
	private Integer smartProbeErrorCounts;
	@Column
	private Integer repeatationCount;
	@Column
	private String language;
	@Column
	private String callerId;
	@Column
	private Integer userThreshold;
	@Column
	private String inspectionMode;
	@Column
	private String filename;
	@Column
	private LocalDateTime inspectionDate;
	@Column
	private String donatedTime;
	@Column
	private String callType;
	@Column
	private String convertedText;
	@Column
	private String protectionAction;
	@Column
	private String callEndTime;
	@Column
	private String protectionActionTime;
	@Column
	private String inspectionResultUpdate;

	public String getInspectionId() {
		return inspectionId;
	}

	public void setInspectionId(String inspectionId) {
		this.inspectionId = inspectionId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getInspectionResult() {
		return inspectionResult;
	}

	public void setInspectionResult(String inspectionResult) {
		this.inspectionResult = inspectionResult;
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

	public String getAuthScore() {
		return authScore;
	}

	public void setAuthScore(String authScore) {
		this.authScore = authScore;
	}

	public Integer getHotspotPhraseCount() {
		return hotspotPhraseCount;
	}

	public void setHotspotPhraseCount(Integer hotspotPhraseCount) {
		this.hotspotPhraseCount = hotspotPhraseCount;
	}

	public Map<String, Integer> getHotspotPhrases() {
		return hotspotPhrases;
	}

	public void setHotspotPhrases(HashMap<String, Integer> hotspotPhrases) {
		this.hotspotPhrases = hotspotPhrases;
	}

	public Integer getUrgencyPhraseCount() {
		return urgencyPhraseCount;
	}

	public void setUrgencyPhraseCount(Integer urgencyPhraseCount) {
		this.urgencyPhraseCount = urgencyPhraseCount;
	}

	public Map<String, Integer> getUrgencyPhrases() {
		return urgencyPhrases;
	}

	public void setUrgencyPhrases(HashMap<String, Integer> urgencyPhrases) {
		this.urgencyPhrases = urgencyPhrases;
	}

	public Integer getGrammaticalErrorCounts() {
		return grammaticalErrorCounts;
	}

	public void setGrammaticalErrorCounts(Integer grammaticalErrorCounts) {
		this.grammaticalErrorCounts = grammaticalErrorCounts;
	}

	public List<String> getGrammaticalErrorPhrases() {
		return grammaticalErrorPhrases;
	}

	public void setGrammaticalErrorPhrases(List<String> grammaticalErrorPhrases) {
		this.grammaticalErrorPhrases = grammaticalErrorPhrases;
	}

	public Integer getSmartProbeErrorCounts() {
		return smartProbeErrorCounts;
	}

	public void setSmartProbeErrorCounts(Integer smartProbeErrorCounts) {
		this.smartProbeErrorCounts = smartProbeErrorCounts;
	}

	public List<String> getSmartProbeErrorQs() {
		return smartProbeErrorQs;
	}

	public void setSmartProbeErrorQs(List<String> smartProbeErrorQs) {
		this.smartProbeErrorQs = smartProbeErrorQs;
	}

	public Integer getRepeatationCount() {
		return repeatationCount;
	}

	public void setRepeatationCount(Integer repeatationCount) {
		this.repeatationCount = repeatationCount;
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

	public LocalDateTime getInspectionDate() {
		return inspectionDate;
	}

	public void setInspectionDate(LocalDateTime localDateTime) {
		this.inspectionDate = localDateTime;
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

	public String getConvertedText() {
		return convertedText;
	}

	public void setConvertedText(String convertedText) {
		this.convertedText = convertedText;
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

	public String getInspectionResultUpdate() {
		return inspectionResultUpdate;
	}

	public void setInspectionResultUpdate(String inspectionResultUpdate) {
		this.inspectionResultUpdate = inspectionResultUpdate;
	}

	public Integer getTotalHotspot() {
		return totalHotspot;
	}

	public void setTotalHotspot(Integer totalHotspot) {
		this.totalHotspot = totalHotspot;
	}

	public Integer getTotalUrgency() {
		return totalUrgency;
	}

	public void setTotalUrgency(Integer totalUrgency) {
		this.totalUrgency = totalUrgency;
	}

	public void setHotspotPhrases(Map<String, Integer> hotspotPhrases) {
		this.hotspotPhrases = hotspotPhrases;
	}

	public void setUrgencyPhrases(Map<String, Integer> urgencyPhrases) {
		this.urgencyPhrases = urgencyPhrases;
	}
	
	

}