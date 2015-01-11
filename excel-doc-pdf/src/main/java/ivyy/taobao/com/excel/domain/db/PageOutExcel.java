package ivyy.taobao.com.excel.domain.db;


import ivyy.taobao.com.entity.UserInfo;
import ivyy.taobao.com.excel.service.UserInfoService;

import java.io.File;
import java.io.IOException;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * ��������excel����,ÿҳ����excel�������65536�����а���ͷ��
 *@DEMO:excel_doc_pdf
 *@Java��PageOutExcel.java
 *@Date:2015-1-10����9:25:31
 *@Author:liangjilong
 *@Email:jilongliang@sina.com
 *@Weibo:http://weibo.com/jilongliang
 *@Version:1.0
 *@Description��
 */
public class PageOutExcel {
	public static void main(String[] args) {
		try {
			String sqlWhere = " where 1=1 ";
			// String sqlWhere="where rownum<1000 order by id desc";
			
			UserInfoService cutomerService = new UserInfoService();
			List<UserInfo> userInfoList = cutomerService.getAllUserInfo(sqlWhere);
					
			// ���ļ���û���򴴽�
			WritableWorkbook book = Workbook.createWorkbook(new File("src/info.xls"));

			int pageNum = 0; // ����ҳ
			int pageSize = 50000;//ÿ����f�l����
			pageNum = (userInfoList.size() % pageSize > 0) ? (userInfoList.size() / pageSize + 1) : (userInfoList.size() / pageSize);
			
			for (int i = 0; i < pageNum; i++) {
				String[] topText = { "���", "����", "�绰��Ϣ", "��ַ" };
				//����excel��������
				WritableSheet sheet = book.createSheet("�ͻ�����" + i, i);
				//i+1�ǵڼ�ҳ...�ٳ���pageSize�ǵ�Nҳ��β�е�������
				int count = (i + 1) * pageSize > userInfoList.size() ? userInfoList.size() : (i + 1) * pageSize;
				
				// System.out.println(i * pageSize);
				// System.out.println(zz);
				for (int z = 0, j = i * pageSize; j < count; j++, z++) {
					
					for (int k = 0; k < topText.length; k++) {
						Label label = new Label(k, 0, topText[k].toString());
						sheet.addCell(label);
						/**
						 * ��Cell��ֵ..
						 */
						UserInfo info = userInfoList.get(j);
						Label id = new Label(0, z + 1, info.getId());
						Label username = new Label(1, z + 1, info.getUsername());
						Label tel = new Label(2, z + 1, info.getTelephone());
						Label address = new Label(3, z + 1, info.getAddress());
						// �����ɵĵ�Ԫ����ӵ���������
						sheet.addCell(id);
						sheet.addCell(username);
						sheet.addCell(tel);
						sheet.addCell(address);
						sheet.setColumnView(8, 28);// �п�
					}
				}
			}
			book.write();
			book.close();
			System.out.println("��������...!");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}

}
