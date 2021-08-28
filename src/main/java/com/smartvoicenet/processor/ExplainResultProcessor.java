package com.smartvoicenet.processor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.smartvoicenet.model.ExplainResult;
import com.smartvoicenet.model.InspectionResultEntity;
import com.smartvoicenet.model.PhraseCounter;
import com.smartvoicenet.model.gramaticalerror.GrammaticalError;
import com.smartvoicenet.model.smartprobe.SmartProbe;

@Component
public class ExplainResultProcessor {

	private InspectionResultEntity inspectionResultEntity;

	public ExplainResult processExplainResultDetails(InspectionResultEntity entity) {

		this.inspectionResultEntity = entity;

		ExplainResult result = new ExplainResult();

		result.setGrammaticalErrors(getGrammaticalError());
		result.setHotspotPhrases(getHotspotPhraseCounter());
		result.setSmartProbeErrors(getSmartProbe());
		result.setUrgencyPhrases(getUrgencyPhraseCounter());
		result.setRepeatationIndicator(entity.getRepeatationCount());

		return result;
	}

	private Integer getPhraseRepeatationCount(ExplainResult result) {
		return result.getHotspotPhrases().getPhraseCount() + result.getUrgencyPhrases().getPhraseCount();

	}

	private PhraseCounter getHotspotPhraseCounter() {

		PhraseCounter hotspotPhraseCounter = new PhraseCounter();
		HashMap<String, Integer> hotspotPhraseMapFromEntity = new HashMap<String, Integer>();

		//fetching Hibernate PersistentMap data and storing it in a HashMap
		inspectionResultEntity.getHotspotPhrases().forEach((k, v) -> {
			hotspotPhraseMapFromEntity.put(k, v);
		});
		List<String> hotspotPhrases = new ArrayList<String>();

		// iterating over entity map to get list of phrases
		for (Map.Entry<String, Integer> entry : hotspotPhraseMapFromEntity.entrySet()) {
			hotspotPhrases.add(entry.getKey());
		}

		hotspotPhraseCounter.setPhraseCount(hotspotPhrases.size());
		hotspotPhraseCounter.setPhraseRptCount(hotspotPhraseMapFromEntity);
		hotspotPhraseCounter.setPhrases(hotspotPhrases);
		hotspotPhraseCounter.setTotalPhrases(inspectionResultEntity.getTotalHotspot());
		
		return hotspotPhraseCounter;
	}

	private PhraseCounter getUrgencyPhraseCounter() {

		PhraseCounter urgencyPhraseCounter = new PhraseCounter();
		HashMap<String, Integer> urgencyPhraseMapFromEntity = new HashMap<String, Integer>();

		//fetching Hibernate PersistentMap data and storing it in a HashMap
		inspectionResultEntity.getUrgencyPhrases().forEach((k, v) -> {
			urgencyPhraseMapFromEntity.put(k, v);
		});
		List<String> urgencyPhrases = new ArrayList<String>();

		// iterating over entity map to get list of phrases
		for (Map.Entry<String, Integer> entry : urgencyPhraseMapFromEntity.entrySet()) {
			urgencyPhrases.add(entry.getKey());
		}

		urgencyPhraseCounter.setPhraseCount(urgencyPhrases.size());
		urgencyPhraseCounter.setPhraseRptCount(urgencyPhraseMapFromEntity);
		urgencyPhraseCounter.setPhrases(urgencyPhrases);
		urgencyPhraseCounter.setTotalPhrases(inspectionResultEntity.getTotalUrgency());
		
		return urgencyPhraseCounter;
	}

	private GrammaticalError getGrammaticalError() {

		GrammaticalError grammaticalErr = new GrammaticalError();
		List<String> grammaticalErrPhrasesFromEntity = inspectionResultEntity.getGrammaticalErrorPhrases();
		grammaticalErr.setGrammaticalError(grammaticalErrPhrasesFromEntity.size());
		grammaticalErr.setGrammaticalErrorPhrases(grammaticalErrPhrasesFromEntity);
		return grammaticalErr;
	}

	private SmartProbe getSmartProbe() {

		SmartProbe probe = new SmartProbe();
		List<String> probeQsFromEntity = inspectionResultEntity.getSmartProbeErrorQs();
		probe.setSmartProbeErrorCounts(probeQsFromEntity.size());
		probe.setSmartProbeErrorQs(probeQsFromEntity);
		return probe;
	}
}
