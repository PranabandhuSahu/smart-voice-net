package com.smartvoicenet.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.smartvoicenet.model.ExplainResult;
import com.smartvoicenet.model.InspectionResultEntity;
import com.smartvoicenet.model.InspectionResultModel;
import com.smartvoicenet.model.UpdateResultModel;
import com.smartvoicenet.processor.DateTimeProcessor;
import com.smartvoicenet.processor.ExplainResultProcessor;
import com.smartvoicenet.processor.InspectionResultProcessor;
import com.smartvoicenet.repository.SVNRecordRepo;
import com.smartvoicenet.service.SVNUIServices;

@Service
public class SVNUIServicesImpl implements SVNUIServices {

	@Autowired
	private SVNRecordRepo repository; //

	@Autowired
	private ExplainResultProcessor explainResultProcessor;

	@Autowired
	private InspectionResultProcessor inspectionProcessor;

	@Autowired
	private DateTimeProcessor dateTimeProcessor;
	

	@Override
	public ExplainResult getExplainResult(String inspectionId) {
		return explainResultProcessor.processExplainResultDetails(getInspectionResultEntity(inspectionId));

	}
	
	private InspectionResultEntity getInspectionResultEntity(String inspectionId) {
		// fetching data from DB
		Optional<InspectionResultEntity> optionalResultEntity = repository.findByInspectionId(inspectionId);
		return optionalResultEntity.get();
	}

	@Override
	public List<InspectionResultModel> saveInspectionResultList(List<InspectionResultModel> modelList) {
		List<InspectionResultModel> savedModel = new ArrayList<InspectionResultModel>();
		modelList.forEach(model -> savedModel.add(saveInspectionResult(model)));
		return savedModel;
	}

	private InspectionResultModel saveInspectionResult(InspectionResultModel resultModel) {
		InspectionResultEntity entity = inspectionProcessor.processInspectionResultModelToEntity(resultModel);
		return inspectionProcessor.processInspectionResultEntityToModel(repository.save(entity));
	}

	@Override
	public String updateResult(UpdateResultModel model) {

		repository.updateInspectionResultEntity(model.getInspectionId(), model.getInspectionResultUpdate());
		InspectionResultEntity updatedEntity = getInspectionResultEntity(model.getInspectionId());
		if (!updatedEntity.getInspectionResultUpdate().equalsIgnoreCase(model.getInspectionResultUpdate())) {
			System.err.println(updatedEntity.getInspectionResultUpdate());
			return "Update failed";
		} else {
			System.err.println(updatedEntity.getInspectionResultUpdate());
			return "Update Success";
		}
	}

	@Override
	public List<InspectionResultModel> getResultByDate(String startDate, String endDate) {

		//parsing dates to required format
		LocalDateTime startDateTime=dateTimeProcessor.processDateTime(startDate);
		LocalDateTime endDateTime=dateTimeProcessor.processDateTime(endDate);
		
		List<InspectionResultModel> modelList = new ArrayList<InspectionResultModel>();
		
		List<InspectionResultEntity> entityList = repository.findAllByInspectionDateBetween(startDateTime, endDateTime);
		if (entityList != null) {
			entityList.forEach(entity -> {
				modelList.add(inspectionProcessor.processInspectionResultEntityToModel(entity));
			});
		}
		
		return modelList;
	}

	@Override
	public List<InspectionResultModel> findAll() {
		List<InspectionResultModel> modelList = new ArrayList<InspectionResultModel>();
		Pageable pageable = PageRequest.of(0, 10);
		List<InspectionResultEntity> entityList = (List<InspectionResultEntity>) repository.findAll(pageable);
		if (entityList != null) {
			entityList.forEach(entity -> {
				modelList.add(inspectionProcessor.processInspectionResultEntityToModel(entity));
			});
		}
		return modelList;
	}


}
