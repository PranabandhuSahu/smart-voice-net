package com.smartvoicenet.model.gramaticalerror;

import java.util.List;

public class GrammaticalError {
	private Integer grammaticalError;
	private List<String> grammaticalErrorPhrases;

	public Integer getGrammaticalError() {
		return grammaticalError;
	}

	public void setGrammaticalError(Integer grammaticalError) {
		this.grammaticalError = grammaticalError;
	}

	public List<String> getGrammaticalErrorPhrases() {
		return grammaticalErrorPhrases;
	}

	public void setGrammaticalErrorPhrases(List<String> grammaticalErrorPhrases) {
		this.grammaticalErrorPhrases = grammaticalErrorPhrases;
	}

}
