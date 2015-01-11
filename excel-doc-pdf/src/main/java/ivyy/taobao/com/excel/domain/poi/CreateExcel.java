package ivyy.taobao.com.excel.domain.poi;
import ivyy.taobao.com.entity.Student;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.POIXMLProperties;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
/**
 *@DEMO:excel-doc-pdf
 *@Java��CreateExcel.java
 *@Date:2015-1-11����9:53:06
 *@Author:liangjilong
 *@Email:jilongliang@sina.com
 *@Weibo:http://weibo.com/jilongliang
 *@Version:1.0
 *@Description������Excelʾ����2003��2007
 */
public class CreateExcel {
	
	private static List<Student> studentList = null;
	private static Student[] students = new Student[4];
	/**
	 * ��̬���ʼ������
	 */
	static {
		studentList = new ArrayList<Student>();
		students[0] = new Student("����", "��", 23, "һ��", 94);
		students[1] = new Student("����", "Ů", 20, "һ��", 92);
		students[2] = new Student("����", "��", 21, "һ��", 87);
		students[3] = new Student("����", "Ů", 22, "һ��", 83);
		studentList.addAll(Arrays.asList(students));
	}
	/**
	 * ����2003�ļ��ķ���
	 * 
	 * @param filePath
	 */
	public static void createExcel2003(String filePath) {
		// �ȴ�������������
		HSSFWorkbook workbook2003 = new HSSFWorkbook();
		//------------------------ �����ı�����  -----------------------
		workbook2003.createInformationProperties();
		SummaryInformation si = workbook2003.getSummaryInformation();
		si.setAuthor("liangjilong");
		si.setTitle("ѧ����Ϣ��");
		si.setComments("POI�������");
		DocumentSummaryInformation dsi = workbook2003.getDocumentSummaryInformation();
		dsi.setCompany("Pioneer");

		
		// �����������������
		HSSFSheet sheet = workbook2003.createSheet("ѧ����Ϣͳ�Ʊ�");
		// �������϶��󴴽��к͵�Ԫ��
		for (int i = 0; i < studentList.size(); i++) {
			// ȡ��Student����
			Student student = studentList.get(i);
			// ������
			HSSFRow row = sheet.createRow(i);
			// ��ʼ������Ԫ�񲢸�ֵ
			HSSFCell nameCell = row.createCell(0);
			nameCell.setCellValue(student.getName());
			HSSFCell genderCell = row.createCell(1);
			genderCell.setCellValue(student.getGender());
			HSSFCell ageCell = row.createCell(2);
			ageCell.setCellValue(student.getAge());
			HSSFCell sclassCell = row.createCell(3);
			sclassCell.setCellValue(student.getClassz());
			HSSFCell scoreCell = row.createCell(4);
			scoreCell.setCellValue(student.getScore());
		}
		// �����ļ�
		File file = new File(filePath);
		if(!file.exists()){
			file.exists();
		}
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			workbook2003.write(fos);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
 
	/***
	 * ����2007�ķ���..
	 * @param filePath
	 */
	public static void createExcel2007(String filePath){
		// ����Excel2007����������
		XSSFWorkbook workbook2007 = new XSSFWorkbook();
		
		//------------------------ �����ı�����  -----------------------
        POIXMLProperties.CoreProperties props = workbook2007.getProperties().getCoreProperties();  
        props.setCreator("liangjilong");  
        props.setCategory("POI�������");  
        props.setTitle("ѧ����Ϣ��");  
        // ������չ����  
        POIXMLProperties.ExtendedProperties extProps = workbook2007.getProperties().getExtendedProperties();  
        // �����Զ�������  
        POIXMLProperties.CustomProperties customProps = workbook2007.getProperties().getCustomProperties();  
		
		//------------------ �����������������------------------
		XSSFSheet sheet = workbook2007.createSheet("ѧ����Ϣͳ�Ʊ�");
		//֮�������ø�ʽ��
		// �������е�Ĭ�Ͽ�Ⱥ͸߶�
		sheet.setColumnWidth(0, 32 * 80);// ��A�����ÿ��Ϊ80����
		sheet.setColumnWidth(1, 32 * 80);
		sheet.setColumnWidth(2, 32 * 80);
		sheet.setColumnWidth(3, 32 * 80);
		sheet.setColumnWidth(4, 32 * 80);
		// -------------------������ʽ------------------
		XSSFFont font = workbook2007.createFont();
		XSSFCellStyle headerStyle = workbook2007.createCellStyle();
		// ���ô�ֱ����
		headerStyle.setAlignment(HorizontalAlignment.CENTER);
		headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		// ���ñ߿�
		headerStyle.setBorderTop(BorderStyle.THIN);
		headerStyle.setBorderBottom(BorderStyle.THIN);
		headerStyle.setBorderLeft(BorderStyle.THIN);
		headerStyle.setBorderRight(BorderStyle.THIN);
		headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);//�Ӵ�
		headerStyle.setFillForegroundColor(IndexedColors.RED.getIndex());//�Ե�һ�м��Ϻ�ɫ
		// ����Ӵ�
		font.setBold(true);
		// ���ó��ı��Զ�����
		headerStyle.setWrapText(true);
		headerStyle.setFont(font);

		// ������ͷ
		XSSFRow headerRow = sheet.createRow(0);
		headerRow.setHeightInPoints(25f);// �����и߶�
		XSSFCell nameHeader = headerRow.createCell(0);
		nameHeader.setCellValue("����");
		nameHeader.setCellStyle(headerStyle);
		XSSFCell genderHeader = headerRow.createCell(1);
		genderHeader.setCellValue("�Ա�");
		genderHeader.setCellStyle(headerStyle);
		XSSFCell ageHeader = headerRow.createCell(2);
		ageHeader.setCellValue("����");
		ageHeader.setCellStyle(headerStyle);
		XSSFCell classHeader = headerRow.createCell(3);
		classHeader.setCellValue("�༶");
		classHeader.setCellStyle(headerStyle);
		XSSFCell scoreHeader = headerRow.createCell(4);
		scoreHeader.setCellValue("�ɼ�");
		scoreHeader.setCellStyle(headerStyle);

		// �ϲ��༶
		sheet.addMergedRegion(new CellRangeAddress(1, 4, 3, 3));
		
		for (int i = 0; i < studentList.size(); i++) {
			XSSFRow row = sheet.createRow(i + 1);
			row.setHeightInPoints(20f);
			Student student = studentList.get(i);
			XSSFCell nameCell = row.createCell(0);
			nameCell.setCellValue(student.getName());
			CellStyle cellStyle=row.getRowStyle();
			nameCell.setCellStyle(cellStyle);
			XSSFCell genderCell = row.createCell(1);
			genderCell.setCellValue(student.getGender());
			genderCell.setCellStyle(cellStyle);
			XSSFCell ageCell = row.createCell(2);
			ageCell.setCellValue(student.getAge());
			ageCell.setCellStyle(cellStyle);
			XSSFCell classCell = row.createCell(3);
			classCell.setCellValue(student.getClassz());
			classCell.setCellStyle(cellStyle);
			XSSFCell scoreCell = row.createCell(4);
			scoreCell.setCellValue(student.getScore());
			scoreCell.setCellStyle(cellStyle);
		}
		OutputStream os = null;
		try {
			// �����ļ�
			File file = new File(filePath);
			if(!file.exists()){
				file.createNewFile();
			}
			os = new FileOutputStream(file);
			workbook2007.write(os);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
				}
			}
		}
	}
	
	@Test
	public void testExcel2003() {
		long start = System.currentTimeMillis();
		String xls2003="D:/test/office2003.xls";//office2003
		createExcel2003(xls2003);
		long end = System.currentTimeMillis();
		System.out.println((end - start) + " ms done!");
	}
	
	@Test
	public void testExcel2007() {
		long start = System.currentTimeMillis();
		String xls2007="D:/test/office2007.xlsx";//office2007
		createExcel2007(xls2007);
		long end = System.currentTimeMillis();
		System.out.println((end - start) + " ms done!");
	}
}
