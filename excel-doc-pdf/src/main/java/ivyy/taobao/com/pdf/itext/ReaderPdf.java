package ivyy.taobao.com.pdf.itext;
/**
 *@Author:jilongliang
 *@Date  :2012-8-12
 *@Project:JAVA7
 *@Description:
 */
import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;

import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;

/**
 *@DEMO:excel-doc-pdf
 *@Java��PdfWatermark.java
 *@Date:2015-1-11����9:53:06
 *@Author:liangjilong
 *@Email:jilongliang@sina.com
 *@Weibo:http://weibo.com/jilongliang
 *@Version:1.0
 *@Description��pdf����ˮӡ
 */

@SuppressWarnings("all")
public class ReaderPdf {
	public static void main(String[] args) throws Exception {
		String filePath=ReaderPdf.class.getClassLoader().getResource("pdf/pdf.pdf").getPath();
		
		// ����ˮӡ���ļ�
		PdfReader reader = new PdfReader(filePath);
		
		String newFilePath="D:/test/newPdf.pdf";
		File f=new File(newFilePath);
		if(!f.exists()){
			f.createNewFile();
		}
		
		// ����ˮӡ���ļ�
		PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(newFilePath));
		int total = reader.getNumberOfPages() + 1;

		PdfContentByte content;
		// ��������
		BaseFont baseFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.EMBEDDED);
		

		//BaseFont baseFont = BaseFont.createFont("STSong-Light",BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED); 
		 //BaseFont baseFont = BaseFont.createFont("C:/Windows/Fonts/SIMYOU.TTF",BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);
		// ˮӡ����
		String waterText = "------�㶫ʡ�Ƹ�����ݺ·��������------";
		int leng = waterText.length(); // ���ֳ���
		char c = 0;
		int height = 0;// �߶�
		// ѭ����ÿҳ����ˮӡ
		for (int i = 1; i < total; i++) {
			// ˮӡ����ʼ
			height = 500;
			content = stamper.getUnderContent(i);
			// ��ʼ
			content.beginText();
			// ������ɫ
			content.setColorFill(Color.GRAY);
			// �������弰�ֺ�
			content.setFontAndSize(baseFont, 18);
			// ������ʼλ��
			content.setTextMatrix(500, 780);
			// ��ʼд��ˮӡ
			for (int k = 0; k < leng; k++) {
				content.setTextRise(14);
				c = waterText.charAt(k);
				// ��charת���ַ���
				content.showText(c + "");
				height -= 5;
			}
			content.endText();
		}
		stamper.close();
	}
}