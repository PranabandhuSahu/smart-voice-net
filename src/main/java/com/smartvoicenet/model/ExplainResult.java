package com.smartvoicenet.model;

import com.smartvoicenet.model.gramaticalerror.GrammaticalError;
import com.smartvoicenet.model.smartprobe.SmartProbe;

public class ExplainResult {

	private PhraseCounter hotspotPhrases;
	private PhraseCounter urgencyPhrases;
	private Integer repeatationIndicator;
	private GrammaticalError grammaticalErrors;
	private SmartProbe smartProbeErrors;

	public PhraseCounter getHotspotPhrases() {
		return hotspotPhrases;
	}

	public void setHotspotPhrases(PhraseCounter hotspotPhrases) {
		this.hotspotPhrases = hotspotPhrases;
	}

	public PhraseCounter getUrgencyPhrases() {
		return urgencyPhrases;
	}

	public void setUrgencyPhrases(PhraseCounter urgencyPhrases) {
		this.urgencyPhrases = urgencyPhrases;
	}

	public Integer getRepeatationIndicator() {
		if(repeatationIndicator!=null) {
			return repeatationIndicator;
		}else {
			this.repeatationIndicator = this.hotspotPhrases.getPhraseCount() + this.urgencyPhrases.getPhraseCount();
		}
		return repeatationIndicator;
	}

	public void setRepeatationIndicator(Integer repeatationIndicator) {
		
		this.repeatationIndicator=repeatationIndicator;
	}

	public GrammaticalError getGrammaticalErrors() {
		return grammaticalErrors;
	}

	public void setGrammaticalErrors(GrammaticalError grammaticalErrors) {
		this.grammaticalErrors = grammaticalErrors;
	}

	public SmartProbe getSmartProbeErrors() {
		return smartProbeErrors;
	}

	public void setSmartProbeErrors(SmartProbe smartProbeErrors) {
		this.smartProbeErrors = smartProbeErrors;
	}

}
