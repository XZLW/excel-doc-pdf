package ivyy.taobao.com.doc.docx4j;

import java.io.File;
import java.util.HashMap;
//��������Github,ԭ��ַ����,���뱻�ҸĹ�һ����
public class DocxTemplaterTest {
	public static void main(String[] args) {
		DocxTemplater templater = new DocxTemplater("f:/saveFile/temp/test_c");
		File f = new File(
				"f:/saveFile/temp/doc_template.docx");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("TITLE", "�����滻����ĵ�");
		map.put("XUHAO", "1");
		map.put("NAME", "÷��");
		map.put("NAME2", "�ӻ�");
		map.put("WORD", "��������Ϊ����");
		map.put("DATA", "2014-9-28");
		map.put("BOSS", "Github");
		templater.process(f, map);
	}
}
