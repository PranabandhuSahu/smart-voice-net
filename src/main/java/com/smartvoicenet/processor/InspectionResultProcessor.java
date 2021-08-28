package com.smartvoicenet.processor;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.smartvoicenet.model.InspectionResultEntity;
import com.smartvoicenet.model.InspectionResultModel;

@Component
public class InspectionResultProcessor {

	public InspectionResultEntity processInspectionResultModelToEntity(InspectionResultModel model) {

		InspectionResultEntity entity = new InspectionResultEntity();
		if (model != null) {
			entity.setAuthScore(Optional.ofNullable(model.getScore()).orElse(null));
			entity.setCallEndTime(Optional.ofNullable(model.getCallEndTime()).orElse(null));
			entity.setCallerId(Optional.ofNullable(model.getCallerId()).orElse(null));
			entity.setCallername(Optional.ofNullable(model.getCallername()).orElse(null));
			entity.setCallerType(Optional.ofNullable(model.getCallerType()).orElse(null));
			entity.setCallStartTime(Optional.ofNullable(model.getCallStartTime()).orElse(null));
			entity.setCallType(Optional.ofNullable(model.getCallType()).orElse(null));
			entity.setConvertedText(Optional.ofNullable(model.getTranscript()).orElse(null));
			entity.setDonatedTime(Optional.ofNullable(model.getDonatedTime()).orElse(null));
			entity.setDurationOfCall(Optional.ofNullable(model.getDurationOfCall()).orElse(null));
			entity.setFilename(Optional.ofNullable(model.getFilename()).orElse(null));
			entity.setInspectionDate(Optional.ofNullable(model.getDate()).orElse(null));
			entity.setInspectionMode(Optional.ofNullable(model.getInspectionMode()).orElse(null));
			entity.setInspectionResult(Optional.ofNullable(model.getoriginalResult()).orElse(null));
			entity.setInspectionResultUpdate(Optional.ofNullable(model.getType()).orElse(null));
			entity.setLanguage(Optional.ofNullable(model.getLanguage()).orElse(null));
			entity.setPhoneNumber(Optional.ofNullable(model.getPhone()).orElse(null));
			entity.setProtectionAction(Optional.ofNullable(model.getProtectionAction()).orElse(null));
			entity.setProtectionActionTime(Optional.ofNullable(model.getProtectionActionTime()).orElse(null));
			entity.setUserThreshold(Optional.ofNullable(model.getUserThreshold()).orElse(null));
			entity.setRepeatationCount(model.getPhrase().getRepeatationIndicator());

			entity.setGrammaticalErrorCounts(
					Optional.ofNullable(model.getPhrase().getGrammaticalErrors().getGrammaticalError()).orElse(null));
			entity.setGrammaticalErrorPhrases(Optional
					.ofNullable(model.getPhrase().getGrammaticalErrors().getGrammaticalErrorPhrases()).orElse(null));
			entity.setHotspotPhraseCount(
					Optional.ofNullable(model.getPhrase().getHotspotPhrases().getPhraseCount()).orElse(null));
			entity.setHotspotPhrases(
					Optional.ofNullable(model.getPhrase().getHotspotPhrases().getPhraseRptCount()).orElse(null));
			entity.setTotalHotspot(
					Optional.ofNullable(model.getPhrase().getHotspotPhrases().getTotalPhrases()).orElse(null));
			entity.setTotalUrgency(
					Optional.ofNullable(model.getPhrase().getUrgencyPhrases().getTotalPhrases()).orElse(null));
			entity.setUrgencyPhraseCount(
					Optional.ofNullable(model.getPhrase().getUrgencyPhrases().getPhraseCount()).orElse(null));
			entity.setUrgencyPhrases(
					Optional.ofNullable(model.getPhrase().getUrgencyPhrases().getPhraseRptCount()).orElse(null));
			entity.setSmartProbeErrorCounts(Optional
					.ofNullable(model.getPhrase().getSmartProbeErrors().getSmartProbeErrorCounts()).orElse(null));
			entity.setSmartProbeErrorQs(
					Optional.ofNullable(model.getPhrase().getSmartProbeErrors().getSmartProbeErrorQs()).orElse(null));
		}
		return entity;
	}

	public InspectionResultModel processInspectionResultEntityToModel(InspectionResultEntity entity) {

		InspectionResultModel model = new InspectionResultModel();
		if (entity != null) {
			ExplainResultProcessor explainResultProcessor = new ExplainResultProcessor();
			model.setPhrase(
					Optional.ofNullable(explainResultProcessor.processExplainResultDetails(entity)).orElse(null));

			model.setInspectionId(Optional.ofNullable(entity.getInspectionId()).orElse(null));
			model.setScore(Optional.ofNullable(entity.getAuthScore()).orElse(null));
			model.setCallEndTime(Optional.ofNullable(entity.getCallEndTime()).orElse(null));
			model.setCallerId(Optional.ofNullable(entity.getCallerId()).orElse(null));
			model.setCallername(Optional.ofNullable(entity.getCallername()).orElse(null));
			model.setCallerType(Optional.ofNullable(entity.getCallerType()).orElse(null));
			model.setCallStartTime(Optional.ofNullable(entity.getCallStartTime()).orElse(null));
			model.setCallType(Optional.ofNullable(entity.getCallType()).orElse(null));
			model.setTranscript(Optional.ofNullable(entity.getConvertedText()).orElse(null));
			model.setDonatedTime(Optional.ofNullable(entity.getDonatedTime()).orElse(null));
			model.setDurationOfCall(Optional.ofNullable(entity.getDurationOfCall()).orElse(null));
			model.setFilename(Optional.ofNullable(entity.getFilename()).orElse(null));
			model.setDate(Optional.ofNullable(entity.getInspectionDate()).orElse(null));
			model.setInspectionMode(Optional.ofNullable(entity.getInspectionMode()).orElse(null));
			model.setoriginalResult(Optional.ofNullable(entity.getInspectionResult()).orElse(null));
			model.setType(Optional.ofNullable(entity.getInspectionResultUpdate()).orElse(null));
			model.setLanguage(Optional.ofNullable(entity.getLanguage()).orElse(null));
			model.setPhoneNumber(Optional.ofNullable(entity.getPhoneNumber()).orElse(null));
			model.setProtectionAction(Optional.ofNullable(entity.getProtectionAction()).orElse(null));
			model.setProtectionActionTime(Optional.ofNullable(entity.getProtectionActionTime()).orElse(null));
			model.setUserThreshold(Optional.ofNullable(entity.getUserThreshold()).orElse(null));
			//Newly added based on Reports Tab//
			model.setAudioSrc("");
			if(entity.getCallType()=="Live") {
				model.setLive(true);
			}else {
				model.setLive(false);
			}
			
		}
		return model;
	}

}
