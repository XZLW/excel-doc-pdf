package ivyy.taobao.com.excel.dao;

import ivyy.taobao.com.entity.Cruise;
import ivyy.taobao.com.excel.service.CruiseService;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;


/**
 *@DEMO:excel-doc-pdf
 *@Java��CruiseDao.java
 *@Date:2015-1-11����10:21:31
 *@Author:liangjilong
 *@Email:jilongliang@sina.com
 *@Weibo:http://weibo.com/jilongliang
 *@Version:1.0
 *@Description��
 */
public class CruiseDao{

	public static HSSFWorkbook getCruiseLocationList() throws Exception {
		HSSFWorkbook workbook = new HSSFWorkbook();
		
		CruiseService cruiseService=new CruiseService();
		// ��model�л�ȡ���ݶ���
		List<Cruise> cruiseServiceLocationList =cruiseService.getCruiseLocationList();
		// ����������
		HSSFSheet sheet = workbook.createSheet("Ѳ������ͳ�Ʊ���");
		sheet.setColumnWidth(0, 32 * 80);
		sheet.setColumnWidth(1, 32 * 80);
		sheet.setColumnWidth(2, 32 * 140);
		sheet.setColumnWidth(3, 32 * 80);
		sheet.setColumnWidth(4, 32 * 180);
		// ��Ԫ����ʽ
		HSSFCellStyle style = workbook.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		style.setWrapText(true);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		// �Ӵ־�����ʽ
		HSSFFont font = workbook.createFont();
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		HSSFCellStyle biStyle = workbook.createCellStyle();
		biStyle.setFont(font);
		biStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		biStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		biStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		biStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		biStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		biStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		// ������ͷ
		HSSFRow header = sheet.createRow(0);
		HSSFCell divisionHeader = header.createCell(0);
		divisionHeader.setCellValue("��ҵ��");
		divisionHeader.setCellStyle(style);
		HSSFCell provinceHeader = header.createCell(1);
		provinceHeader.setCellValue("ʡ��");
		provinceHeader.setCellStyle(style);
		HSSFCell dealerNameHeader = header.createCell(2);
		dealerNameHeader.setCellValue("������");
		dealerNameHeader.setCellStyle(style);
		HSSFCell dealerCodeHeader = header.createCell(3);
		dealerCodeHeader.setCellValue("�����̴���");
		dealerCodeHeader.setCellStyle(style);
		HSSFCell locationHeader = header.createCell(4);
		locationHeader.setCellValue("Ѳ���ص�");
		locationHeader.setCellStyle(style);
		HSSFCell milesHeader = header.createCell(5);
		milesHeader.setCellValue("���");
		milesHeader.setCellStyle(style);
		// �ϼ����ļ���
		Cruise cslTotal = null;
		List<Cruise> cslList = new ArrayList<Cruise>();
		// �ϲ��������
		double totalDealer = 0;
		double totalProvince = 0;
		double totalDivision = 0;
		int locationNum = 0;
		// ѭ������List
		for (int i = 0; i < cruiseServiceLocationList.size(); i++) {
			cslList.add(cruiseServiceLocationList.get(i));
			// �Ƿ������һ����¼�Ŀ���
			boolean last = (i == cruiseServiceLocationList.size() - 1);
			// ȡ�����ڵ�������¼���бȽ�
			Cruise csl1 = null;
			Cruise csl2 = null;
			if (!last) {
				csl1 = cruiseServiceLocationList.get(i);
				csl2 = cruiseServiceLocationList.get(i + 1);
			} else {
				// ��ֹ���һ����¼�޷����뼯��
				csl1 = cruiseServiceLocationList.get(i);
				if (cruiseServiceLocationList.size() != 1)
					csl2 = cruiseServiceLocationList.get(i - 1);
				else
					csl2 = cruiseServiceLocationList.get(i);
			}
			// ��ʼ����
			if (csl1.getDealerName().equals(csl2.getDealerName())) {
				locationNum++;
				totalDealer += csl1.getMiles();
			} else {
				locationNum++;
				totalDealer += csl1.getMiles();
				cslTotal = new Cruise();
				cslTotal.setTotalDealer(totalDealer);
				cslTotal.setLocationNum(locationNum);
				cslList.add(cslTotal);
				totalDealer = 0;
				locationNum = 0;
			}
			if (csl1.getProvince().equals(csl2.getProvince())) {
				totalProvince += csl1.getMiles();
			} else {
				totalProvince += csl1.getMiles();
				cslTotal = new Cruise();
				cslTotal.setTotalProvince(totalProvince);
				cslList.add(cslTotal);
				totalProvince = 0;
			}
			if (csl1.getDivision().equals(csl2.getDivision())) {
				totalDivision += csl1.getMiles();
			} else {
				totalDivision += csl1.getMiles();
				cslTotal = new Cruise();
				cslTotal.setTotalDivision(totalDivision);
				cslList.add(cslTotal);
				totalDivision = 0;
			}
		}
		// ʡ�ݺϼƺ���ҵ���ϼ�ʱ���еļ�������
		int comboProvince = 0;
		int comboDivision = 0;
		List<Integer> indexComboProvice = new ArrayList<Integer>();
		List<Integer> indexComboDivision = new ArrayList<Integer>();
		for (int i = 0; i < cslList.size() - 4; i++) {
			Cruise csl = cslList.get(i);
			HSSFRow row = sheet.createRow(i + 1);
			row.setHeightInPoints(20f);
			if (csl.getDivision() != null) {
				HSSFCell divisionCell = row.createCell(0);
				divisionCell.setCellValue(csl.getDivision());
				divisionCell.setCellStyle(style);
				HSSFCell provinceCell = row.createCell(1);
				provinceCell.setCellValue(csl.getProvince());
				provinceCell.setCellStyle(style);
				HSSFCell dealerNameCell = row.createCell(2);
				dealerNameCell.setCellValue(csl.getDealerName());
				dealerNameCell.setCellStyle(style);
				HSSFCell dealerCodeCell = row.createCell(3);
				dealerCodeCell.setCellValue(csl.getDealerCode());
				dealerCodeCell.setCellStyle(style);
				HSSFCell locationCell = row.createCell(4);
				locationCell.setCellValue(csl.getLocation());
				locationCell.setCellStyle(style);
				HSSFCell milesCell = row.createCell(5);
				milesCell.setCellValue(csl.getMiles());
				milesCell.setCellStyle(style);
			}
			if (csl.getTotalDealer() != 0) {
				row.createCell(0).setCellStyle(style);
				row.createCell(1).setCellStyle(style);
				HSSFCell t_dealer = row.createCell(2);
				t_dealer.setCellValue("�����̺ϼ�");
				t_dealer.setCellStyle(biStyle);
				sheet.addMergedRegion(new CellRangeAddress(i + 1, i + 1, 2, 4));
				HSSFCell t_dealer_value = row.createCell(5);
				t_dealer_value.setCellValue(csl.getTotalDealer());
				t_dealer_value.setCellStyle(biStyle);
				sheet.addMergedRegion(new CellRangeAddress(i
						- csl.getLocationNum() + 1, i, 2, 2));
				sheet.addMergedRegion(new CellRangeAddress(i
						- csl.getLocationNum() + 1, i, 3, 3));
			}
			if (csl.getTotalProvince() != 0) {
				HSSFCell t_province = row.createCell(1);
				row.createCell(0).setCellStyle(style);
				row.createCell(3).setCellStyle(style);
				row.createCell(4).setCellStyle(style);
				t_province.setCellValue("ʡ�ݺϼ�");
				t_province.setCellStyle(biStyle);
				sheet.addMergedRegion(new CellRangeAddress(i + 1, i + 1, 1, 4));
				HSSFCell t_province_value = row.createCell(5);
				t_province_value.setCellValue(csl.getTotalProvince());
				t_province_value.setCellStyle(biStyle);
				indexComboProvice.add(i);
				// �ϲ���
				if (comboProvince == 0) {
					sheet.addMergedRegion(new CellRangeAddress(1, i, 1, 1));
				} else if (comboProvince == 1) {
					sheet.addMergedRegion(new CellRangeAddress(indexComboProvice.get(comboProvince - 1)+ comboProvince + 1, i, 1, 1));
				} else {
					sheet.addMergedRegion(new CellRangeAddress(indexComboProvice.get(comboProvince - 1)+ comboProvince, i, 1, 1));

				}
				comboProvince++;
			}
			if (csl.getTotalDivision() != 0) {
				HSSFCell t_division = row.createCell(0);
				row.createCell(1).setCellStyle(style);
				row.createCell(2).setCellStyle(style);
				row.createCell(3).setCellStyle(style);
				row.createCell(4).setCellStyle(style);
				t_division.setCellValue("��ҵ���ϼ�");
				t_division.setCellStyle(biStyle);
				sheet.addMergedRegion(new CellRangeAddress(i + 1, i + 1, 0, 4));
				HSSFCell t_division_value = row.createCell(5);
				t_division_value.setCellValue(csl.getTotalDivision());
				t_division_value.setCellStyle(biStyle);
				indexComboDivision.add(i);
				// �ϲ���
				if (comboDivision == 0) {
					sheet.addMergedRegion(new CellRangeAddress(1, i, 0, 0));
				} else if (comboDivision == 1) {
					sheet.addMergedRegion(new CellRangeAddress(indexComboDivision.get(comboDivision - 1)+ comboDivision + 1, i, 0, 0));
				} else {
					sheet.addMergedRegion(new CellRangeAddress(indexComboDivision.get(comboDivision - 1) + comboDivision, i, 0, 0));
				}
				comboDivision++;
			}

		}
		
		return workbook;
		
	}

}
