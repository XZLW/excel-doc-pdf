package ivyy.taobao.com.excel.domain.jxl;

import java.io.File;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.junit.Test;

/**
 *@DEMO:excel_doc_pdf
 *@Java��CreateExcel.java
 *@Date:2015-1-10����9:43:49
 *@Author:liangjilong
 *@Email:jilongliang@sina.com
 *@Weibo:http://weibo.com/jilongliang
 *@Version:1.0
 *@Description������һ��Excel�ļ�
 */
public class CreateExcel {
	
	@Test
	public void testCreateExcel(String[] args) {
		try {
			// ���ļ�
			WritableWorkbook book = Workbook.createWorkbook(new File("test.xls "));
			// ������Ϊ����һҳ���Ĺ���������0��ʾ���ǵ�һҳ
			WritableSheet sheet = book.createSheet("��һҳ ", 0);
			// ��Label����Ĺ�������ָ����Ԫ��λ���ǵ�һ�е�һ��(0,0)
			// �Լ���Ԫ������Ϊcolumn,row,count
			Label label = new Label(0, 0, " �|����ˇ ");//column,row,count
			// ������õĵ�Ԫ����ӵ���������
			sheet.addCell(label);
			/*
			 * ����һ���������ֵĵ�Ԫ�� ����ʹ��Number��������·�����������﷨���� ��Ԫ��λ���ǵڶ��У���һ�У�ֵΪ789.123
			 */
			jxl.write.Number number = new jxl.write.Number(1, 0, 555.12541);
			sheet.addCell(number);
			// д�����ݲ��ر��ļ�
			book.write();
			book.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
