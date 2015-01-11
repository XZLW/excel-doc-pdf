package ivyy.taobao.com.pdf.Jacob;
import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
/***
 * Java jacob ��Word ����PDF�ļ�
 * @author liangjilong
 */
public class WordToPdf {

	private ActiveXComponent wordCom = null;
	private Dispatch wordDoc = null;
	private final Variant False = new Variant(false);
	private final Variant True = new Variant(true);

	/**
	 * ��word�ęn
	 * 
	 * @param filePath
	 *            word�ęn
	 * @return ����word���ļ�����
	 */
	public boolean openWord(String filePath) {
		// ����ActiveX����
		wordCom = new ActiveXComponent("Word.Application");
		try {
			// ����wrdCom.Documents��Dispatch
			Dispatch wrdDocs = wordCom.getProperty("Documents").toDispatch();
			// ����wrdCom.Documents.Open������ָ����word�ęn������wordDoc
			wordDoc = Dispatch.invoke(wrdDocs, "Open", Dispatch.Method,
					new Object[] { filePath }, new int[1]).toDispatch();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	/**
	 * �ر�word�ęn
	 */
	public void closeWord() {
		// �ر�word�ļ�
		if (wordCom != null) {
			int save = 0;
			Variant doNotSaveChanges = new Variant(save);
			wordCom.invoke("Quit", new Variant[] { doNotSaveChanges });
			wordCom = null;
			ComThread.Release();
		}
	}
	
	/**
	 * ɾ����ʱ�ļ�
	 */
	public void deletetmpFile(String psfileName,String logFileName){
		File psfile = new File(psfileName);
		
		String  s [] = new String(logFileName).split(".pdf");
		File logfile = new File(s[0]+".log");
		System.out.println(logfile.getName());
		
        if (psfile.exists()) {
        	psfile.delete();
        	System.out.println("ɾ����ʱPS�ļ�");
        }
        if(logfile.exists()){
        	logfile.delete();
        	System.out.println("ɾ����ʱ��־�ļ�");
        }
        
	}

	/**
	 * ��word�ęn��ӡΪPS�n��ʹ��Distiller��PS�nת��ΪPDF�n
	 * 
	 * @param sourceFilePath
	 *            Դ�ļ�·��
	 * @param destinPSFilePath
	 *            �������ɵ�PS�ļ�·��
	 * @param destinPDFFilePath
	 *            ����PDF�ļ�·��
	 */
	public void docToPDF(String sourceFilePath, String destinPSFilePath,
			String destinPDFFilePath) {
		if (!openWord(sourceFilePath)) {
			closeWord();
			return;
		}
		// ����Adobe Distiller��com����
		ActiveXComponent distiller = new ActiveXComponent("PDFDistiller.PDFDistiller.1");
		
		try {
			// ���õ�ǰʹ�õĴ�ӡ�����ҵ�Adobe Distiller��ӡ������Ϊ"Adobe PDF"
			wordCom.setProperty("ActivePrinter", new Variant("Adobe PDF"));
			
			// �Ƿ��ں�̨����
			Variant Background = False;
			
			// �Ƿ�׷�Ӵ�ӡ
			Variant Append = False;
			
			// ��ӡ�����ęn
			int wdPrintAllDocument = 0;
			
			Variant Range = new Variant(wdPrintAllDocument);
			
			// �����postscript�ļ���·��
			Variant OutputFileName = new Variant(destinPSFilePath);
			
			// ����word�ļ������PrintOut��������word�ęn��ӡΪpostscript�ęn�����ps�ęn
			Dispatch.callN(wordDoc, "PrintOut", new Variant[] { Background,
					Append, Range, OutputFileName });
			
			System.out.println("��word�ęn��ӡΪps�ęn�ɹ���");

			// ����Distiller�����FileToPDF�������õĲ�������ϸ���ݲο�Distiller Api�ֲ�
			// ��Ϊ�����ps���ļ�·��
			Variant inputPostScriptFilePath = new Variant(destinPSFilePath);
			
			// ��Ϊ�����pdf���ļ���·��
			Variant outputPDFFilePath = new Variant(destinPDFFilePath);
			
			// ����FileToPDF����Ҫʹ��adobe pdf�����ļ���·����������û�и�ֵ��ʾ����ʹ��pdf�����ļ�
			Variant PDFOption = new Variant("");
			
			// ����FileToPDF������ps�ęnת��Ϊpdf�ęn
			Dispatch.callN(distiller, "FileToPDF", new Variant[] {
					inputPostScriptFilePath, outputPDFFilePath, PDFOption });
		
			
			System.out.println("��ps�ęnת��Ϊpdf�ęn�ɹ���");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			closeWord();
			deletetmpFile(destinPSFilePath,destinPDFFilePath);
		}
	}

	
	/**
	 */
	@Test
	public void testWordToPdf(){
		String dirPath=WordToPdf.class.getClassLoader().getResource("doc/pdf.doc").getPath();
		String wordPs="d:/test/word.ps";
		String wordPdf="d:/test/word.pdf";
		
		File f1=new File(wordPs);
		
		if(!f1.exists()){
			try {
				f1.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		File f2=new File(wordPdf);
		
		if(!f2.exists()){
			try {
				f2.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		docToPDF(dirPath,wordPs,wordPdf);
	}
	
 
}