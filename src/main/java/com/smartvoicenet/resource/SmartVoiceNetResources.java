package com.smartvoicenet.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smartvoicenet.model.ExplainResult;
import com.smartvoicenet.model.InspectionResultModel;
import com.smartvoicenet.model.UpdateResultModel;
import com.smartvoicenet.service.SVNUIServices;

@RestController
@RequestMapping("/svn")
public class SmartVoiceNetResources {

	@Autowired
	private SVNUIServices service;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/explain/{recordId}")
	public ExplainResult getExplainResultDetails(@PathVariable("recordId") String recordId) {
		System.out.println("********* Explain Result ID *******"+recordId);
		return service.getExplainResult(recordId);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/save")
	public List<InspectionResultModel> saveInspectionResult(@RequestBody List<InspectionResultModel> modelList) {

		return service.saveInspectionResultList(modelList);

	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/update")
	public String updateInspectionResult(@RequestBody UpdateResultModel updateModel) {
		
		return service.updateResult(updateModel);

	}
	
	/*
	 * @PostMapping(value = "/save1", consumes = { "multipart/form-data",
	 * "application/json" }) public List<InspectionResultModel>
	 * save(@RequestPart("file") MultipartFile[] files,
	 * 
	 * @RequestPart("inspectionResultModel") List<InspectionResultModel> modelList)
	 * {
	 * 
	 * for (MultipartFile file : files) { for (InspectionResultModel model :
	 * modelList) { System.err.println(file.getOriginalFilename());
	 * 
	 * System.err.println(model.getPhoneNumber()); } ///
	 * 
	 * } return new ArrayList<InspectionResultModel>(); }
	 */

	@GetMapping("/byDate")
	public List<InspectionResultModel> getInspectionResultByDate(
			@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate) {

		return service.getResultByDate(startDate, endDate);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/findAll")
	public List<InspectionResultModel> getAllRecord() {

		return service.findAll();
	}
	//Commit from GIT
}
