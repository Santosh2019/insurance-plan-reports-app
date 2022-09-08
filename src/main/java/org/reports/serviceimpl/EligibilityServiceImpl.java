
package org.reports.serviceimpl;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.reports.bean.EligibilityDetails;
import org.reports.dao.EligibilityRepository;
import org.reports.request.SearchRequest;
import org.reports.response.SearchResponse;
import org.reports.service.EligibilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class EligibilityServiceImpl implements EligibilityService {

	@Autowired
	EligibilityRepository eligibilityRepository;

	@Override
	public List<String> getUniquePlanNames() {
		return eligibilityRepository.findPlanNames();
	}

	@Override
	public List<String> getUniquePlanStatus() {
		// TODO Auto-generated method stub
		return eligibilityRepository.findPlanStatus();
	}

	@Override
	public List<SearchResponse> search(SearchRequest request) {
		// TODO Auto-generated method stub

		List<SearchResponse> response = new ArrayList<>();

		EligibilityDetails eligibilityDetails = new EligibilityDetails();

		String planName = request.getPlanName();
		if (planName != null && !planName.equals("")) {
			eligibilityDetails.setPlanName("");
		}
		String planStatus = request.getPlanStatus();
		System.out.println(planStatus);
		if (planStatus != null && !planStatus.equals(""))
		{
			eligibilityDetails.setPlanStatus(planStatus);
		}

		System.out.println(eligibilityDetails);
		
		Example<EligibilityDetails>example=Example.of(eligibilityDetails);
		
		List<EligibilityDetails> entities = eligibilityRepository.findAll(example);

		for (EligibilityDetails entity : entities) {

			SearchResponse sr = new SearchResponse();

			BeanUtils.copyProperties(entity, sr);

			response.add(sr);

		}

		return response;
	}

	@Override
	public void generateExcel(HttpServletResponse response) throws IOException {

		List<EligibilityDetails> entities = eligibilityRepository.findAll();

		HSSFWorkbook workBook = new HSSFWorkbook();

		HSSFSheet sheet = workBook.createSheet();

		HSSFRow headerRow = sheet.createRow(0);

		headerRow.createCell(0).setCellValue("Name");

		headerRow.createCell(1).setCellValue("Plan Name");

		headerRow.createCell(2).setCellValue("Mobile");

		headerRow.createCell(3).setCellValue("Gender");

		headerRow.createCell(4).setCellValue("Email");

		headerRow.createCell(5).setCellValue("SSN");

		int i = 0;
		for (EligibilityDetails entity : entities) {

			HSSFRow dataRow = sheet.createRow(i);

			dataRow.createCell(0).setCellValue(entity.getName());

			dataRow.createCell(1).setCellValue(entity.getPlanName());

			dataRow.createCell(2).setCellValue(entity.getMobileNumber());

			dataRow.createCell(3).setCellValue(String.valueOf(entity));

			dataRow.createCell(4).setCellValue(entity.getEmaiId());

			dataRow.createCell(5).setCellValue(entity.getSsn());

			i++;

		}

		ServletOutputStream outPutStream = response.getOutputStream();

		workBook.write(outPutStream);

		workBook.close();

		outPutStream.close();
	}

	@Override
	public void generatePDF(HttpServletResponse response) throws DocumentException, IOException {
		// TODO Auto-generated method stub
		List<EligibilityDetails> entities = eligibilityRepository.findAll();

		Document document = new Document(PageSize.A4);

		PdfWriter.getInstance(document, response.getOutputStream());

		document.open();

		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

		font.setSize(18);
		font.setColor(Color.BLUE);

		Paragraph paragraph = new Paragraph("Search Report", font);

		paragraph.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(paragraph);

		PdfPTable table = new PdfPTable(6);

		table.setWidthPercentage(100f);

		table.setWidths(new float[] { 1.5f, 3.0f, 3.0f, 1.0f, 2.5f, 3.5f });
		table.setSpacingBefore(10);

		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.BLUE);
		cell.setPadding(5);

		font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);

		cell.setPhrase(new Phrase("Name", font));

		table.addCell(cell);

		cell.setPhrase(new Phrase("Plan Status", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("phone Number", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Gender", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("SSN", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Email", font));
		table.addCell(cell);

		for (EligibilityDetails entity : entities) {

			table.addCell(entity.getPlanName());
			table.addCell(entity.getPlanStatus());
			table.addCell(String.valueOf(entity.getMobileNumber()));
			table.addCell(String.valueOf((Character) entity.getGender()));
			table.addCell(String.valueOf(entity.getSsn()));
			table.addCell(entity.getEmaiId());
		}
		document.add(table);
		document.close();
	}

}
