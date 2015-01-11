package ivyy.taobao.com.excel.domain.jxl;

import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.junit.Test;

/**
 *@DEMO:excel_doc_pdf
 *@Java��ReadExcel.java
 *@Date:2015-1-10����9:50:08
 *@Author:liangjilong
 *@Email:jilongliang@sina.com
 *@Weibo:http://weibo.com/jilongliang
 *@Version:1.0
 *@Description����ȡExcel
 */
public class ReadExcel {
	@Test
	public void testReadExcel() {
		try {
			Workbook book = Workbook.getWorkbook(new File("test.xls"));
			// ��õ�һ�����������
			Sheet sheet = book.getSheet(0);
			// �õ���һ�е�һ�еĵ�Ԫ��
			Cell cell1 = sheet.getCell(0, 0);
			String result = cell1.getContents();
			System.out.println(result);
			book.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}