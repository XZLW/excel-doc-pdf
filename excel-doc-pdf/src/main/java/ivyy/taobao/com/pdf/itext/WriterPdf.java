package ivyy.taobao.com.pdf.itext;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

/**
 *@DEMO:excel-doc-pdf
 *@Java��WriterPdf.java
 *@Date:2015-1-11����11:42:38
 *@Author:liangjilong
 *@Email:jilongliang@sina.com
 *@Weibo:http://weibo.com/jilongliang
 *@Version:1.0
 *@Description��
 */
public class WriterPdf {
	public static void main(String[] args) {

		System.out.println("��������");
		// ��һ��������һ��document����
		Document document = new Document();
		try {
			
			String filePath="D:/test/Writer.Pdf";
			
			File f=new File(filePath);
			
			if(!f.exists()){
				f.createNewFile();
			}
			// �ڶ�����
			// ����һ��PdfWriterʵ����
			// ���ļ������ָ��һ���ļ���
			PdfWriter.getInstance(document, new FileOutputStream(filePath));

			// �����������ĵ���
			document.open();
			// ���Ĳ������ĵ�������һ�����䡣
			document.add(new Paragraph("��������" + "," + "��������"+ "," + "��������"));
		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		// ���岽���ر��ĵ���
		document.close();
		// ��������Ƿ��������е����
		System.out.println("��ȥ������");
	}    
}
