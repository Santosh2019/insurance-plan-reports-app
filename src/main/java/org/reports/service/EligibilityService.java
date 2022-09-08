package org.reports.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.reports.request.SearchRequest;
import org.reports.response.SearchResponse;

import com.lowagie.text.DocumentException;

public interface EligibilityService {

	List<String> getUniquePlanNames();

	List<String> getUniquePlanStatus();

	public List<SearchResponse> search(SearchRequest request);

	public void generatePDF(HttpServletResponse response) throws DocumentException, IOException;

	public void generateExcel(HttpServletResponse response) throws IOException;

}
