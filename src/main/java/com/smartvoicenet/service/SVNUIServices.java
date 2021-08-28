package com.smartvoicenet.service;

import java.util.List;

import com.smartvoicenet.model.ExplainResult;
import com.smartvoicenet.model.InspectionResultModel;
import com.smartvoicenet.model.UpdateResultModel;

public interface SVNUIServices {
	public ExplainResult getExplainResult(String inspectionId);

	// public InspectionResultEntity updateInspectionResult(String inspectionId);

	// public InspectionResultModel saveInspectionResult(InspectionResultModel
	// resultEntity);

	public List<InspectionResultModel> saveInspectionResultList(List<InspectionResultModel> modelList);

	public String updateResult(UpdateResultModel model);
	
	public List<InspectionResultModel> getResultByDate(String startDate,String endDate);
	
	public List<InspectionResultModel> findAll(); 
}
