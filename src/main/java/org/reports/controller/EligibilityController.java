package org.reports.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.reports.request.SearchRequest;
import org.reports.response.SearchResponse;
import org.reports.service.EligibilityService;
import org.reports.serviceimpl.EligibilityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;

@RestController
public class EligibilityController {

	@Autowired
	private EligibilityServiceImpl reportsServiceImpl;
	
	@Autowired
	private EligibilityService eligibilityService;
	
	
	
	@GetMapping("/plans")
	public ResponseEntity<List<String>> getPlanNames() {

		List<String> planList = eligibilityService.getUniquePlanNames();

		return new ResponseEntity<>(planList, HttpStatus.OK);
	}

	@GetMapping("/status")
	public ResponseEntity<List<String>> getPlanStatus() {

		List<String> planList = eligibilityService.getUniquePlanStatus();

		return new ResponseEntity<>(planList, HttpStatus.OK);
	}

	@PostMapping("/search")
	public ResponseEntity<List<SearchResponse>> getSearch(@RequestBody SearchRequest request) {

		List<SearchResponse> response = eligibilityService.search(request);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/excel")
	public void excelReposrt(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=Plan-Report.xls";
		response.setHeader(headerKey, headerValue);
		reportsServiceImpl.generateExcel(response);
	}

	@GetMapping("/pdf")
	public void excelPdf(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=data.pdf";
		response.setHeader(headerKey, headerValue);
		reportsServiceImpl.generatePDF(response);

	}

}
