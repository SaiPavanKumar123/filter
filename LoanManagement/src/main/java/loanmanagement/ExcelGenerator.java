package loanmanagement;

import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelGenerator {

	public static Workbook createExcel(List<Loan> loans) throws Exception {
		Workbook book = new XSSFWorkbook();
		org.apache.poi.ss.usermodel.Sheet sheet = book.createSheet("Loan Applications");

		Row headerRow = sheet.createRow(0);

		headerRow.createCell(0).setCellValue("ApplicantID");
		headerRow.createCell(1).setCellValue("customerid");
		headerRow.createCell(2).setCellValue("applicationdate");
		headerRow.createCell(3).setCellValue("loantype");
		headerRow.createCell(4).setCellValue("amountreq");
		headerRow.createCell(5).setCellValue("emirangefrom");
		headerRow.createCell(6).setCellValue("emirangeto");
		headerRow.createCell(7).setCellValue("monthsreq");
		headerRow.createCell(8).setCellValue("annualincome");
		headerRow.createCell(9).setCellValue("disposalincome");
		headerRow.createCell(10).setCellValue("cibilscore");
		headerRow.createCell(11).setCellValue("status");
		headerRow.createCell(12).setCellValue("remarks");
		headerRow.createCell(13).setCellValue("processeduser");
		headerRow.createCell(14).setCellValue("processeddate");

		int rowNum = 1;
		for (Loan applicant : loans) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(applicant.getApplicantid());
			row.createCell(1).setCellValue(applicant.getCustomerid());
			row.createCell(2).setCellValue(applicant.getApplicationdate());
			row.createCell(3).setCellValue(applicant.getLoantype());
			row.createCell(4).setCellValue(applicant.getAmountreq());
			row.createCell(5).setCellValue(applicant.getAmountreq());
			row.createCell(6).setCellValue(applicant.getEmirangefrom());
			row.createCell(7).setCellValue(applicant.getEmirangeto());
			row.createCell(8).setCellValue(applicant.getMonthsreq());
			row.createCell(9).setCellValue(applicant.getAnnualincome());
			row.createCell(10).setCellValue(applicant.getDisposalincome());
			row.createCell(11).setCellValue(applicant.getCibilscore());
			row.createCell(12).setCellValue(applicant.getStatus());
			row.createCell(13).setCellValue(applicant.getRemarks());
			row.createCell(13).setCellValue(applicant.getProcesseduser());
			row.createCell(13).setCellValue(applicant.getProcesseddate());

		}
		return book;
	}
}
