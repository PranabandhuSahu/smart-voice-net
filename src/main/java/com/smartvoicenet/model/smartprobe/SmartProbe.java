package com.smartvoicenet.model.smartprobe;

import java.util.List;

//@Entity
public class SmartProbe {

	private Integer smartProbeErrorCounts;
	private List<String> smartProbeErrorQs;

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

		
}
