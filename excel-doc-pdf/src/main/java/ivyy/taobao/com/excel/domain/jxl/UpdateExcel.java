package ivyy.taobao.com.excel.domain.jxl;

import java.io.File;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.junit.Test;

/**
 * @DEMO:excel_doc_pdf
 * @Java��UpdateExcel.java
 * @Date:2015-1-10����9:51:11
 * @Author:liangjilong
 * @Email:jilongliang@sina.com
 * @Weibo:http://weibo.com/jilongliang
 * @Version:1.0
 * @Description��
 */
public class UpdateExcel {
	
	@Test
	public  void testUpdateExcel() {
		try {
			// Excel����ļ�
			Workbook wb = Workbook.getWorkbook(new File("test.xls"));
			// ��һ���ļ��ĸ���������ָ������д�ص�ԭ�ļ�
			WritableWorkbook book = Workbook.createWorkbook(new File("test.xls"), wb);
			// ���һ��������
			WritableSheet sheet = book.createSheet("�ڶ�ҳ ", 1);//���õ�2����Sheet
			sheet.addCell(new Label(0, 0, "��ӭ���������չ���"));
			book.write();
			book.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
