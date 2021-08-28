package com.smartvoicenet.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhraseCounter {

	private List<String> phrases;
	private HashMap<String, Integer> phraseRptCount;
	private Integer phraseCount;
	private Integer totalPhrases;
	
	public Integer getTotalPhrases() {
		if(totalPhrases!=null) {
			return totalPhrases;
		}else {
			int counter=0;
			for(Map.Entry<String, Integer> entry:this.phraseRptCount.entrySet()) {
				counter=Math.addExact(counter, entry.getValue());
			}
			this.totalPhrases=counter;
		}
		return totalPhrases;
	}

	public void setTotalPhrases(Integer totalPhrases) {
		this.totalPhrases = totalPhrases;
	}

	public List<String> getPhrases() {
		return phrases;
	}

	public void setPhrases(List<String> phrases) {
		this.phrases = phrases;
	}

	public HashMap<String, Integer> getPhraseRptCount() {
		return phraseRptCount;
	}

	public void setPhraseRptCount(HashMap<String, Integer> phraseRptCount) {
		this.phraseRptCount = phraseRptCount;
	}

	public Integer getPhraseCount() {
		return phraseRptCount.size();
	}

	public void setPhraseCount(Integer phraseCount) {
		this.phraseCount = phraseCount;
	}

}
