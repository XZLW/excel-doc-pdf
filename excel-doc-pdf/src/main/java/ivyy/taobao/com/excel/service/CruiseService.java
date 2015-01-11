package ivyy.taobao.com.excel.service;

import ivyy.taobao.com.entity.Cruise;

import java.util.Arrays;
import java.util.List;

/**
 *@DEMO:excel-doc-pdf
 *@Java��CruiseService.java
 *@Date:2015-1-11����10:21:31
 *@Author:liangjilong
 *@Email:jilongliang@sina.com
 *@Weibo:http://weibo.com/jilongliang
 *@Version:1.0
 *@Description��
 */
public class CruiseService {

	/**
	 * ��ȡ����
	 * @return
	 */
	public static List<Cruise> getCruiseLocationList() {
		Cruise csl[] = new Cruise[21];
		csl[0] = new Cruise("T001", "������", "�����ܲ�", "bj", "�廪��ѧ",
				20);
		csl[1] = new Cruise("T001", "������", "�����ܲ�", "bj", "������ѧ",
				30);
		csl[2] = new Cruise("T001", "������", "��������", "bjhd",
				"��ֱ��", 15);
		csl[3] = new Cruise("T001", "������", "��������", "bjhd",
				"�׶�����", 50);
		csl[4] = new Cruise("T001", "������", "��������", "bjhd",
				"�йش�", 23);
		csl[5] = new Cruise("T001", "������", "���Ǿ�����", "bjdc",
				"������վ", 4);
		csl[6] = new Cruise("T001", "������", "���Ǿ�����", "bjdc",
				"������վ", 12);
		csl[7] = new Cruise("T001", "����ʡ", "����������", "lndl",
				"�ӿ����԰", 15);
		csl[8] = new Cruise("T001", "����ʡ", "����������", "lndl",
				"�������ڷ����԰", 13);
		csl[9] = new Cruise("T001", "����ʡ", "����������", "lndl",
				"����԰���Ŵ��", 11);
		csl[10] = new Cruise("T001", "����ʡ", "�����ڶ�������", "lndl2",
				"����㳡", 8);
		csl[11] = new Cruise("T001", "����ʡ", "�����ڶ�������", "lndl2",
				"�����㳡", 17);
		csl[12] = new Cruise("T001", "����ʡ", "�����ڶ�������", "lndl2",
				"��һ�㳡", 12);
		csl[13] = new Cruise("T001", "����ʡ", "����������", "lnsy",
				"�����ʹ�", 16);
		csl[14] = new Cruise("T001", "����ʡ", "����������", "lnsy",
				"������վ", 4);
		csl[15] = new Cruise("T001", "����ʡ", "����������", "jlcc",
				"���ִ�ѧ", 4);
		csl[16] = new Cruise("T001", "����ʡ", "����������", "jlcc",
				"������վ", 4);
		csl[17] = new Cruise("T002", "������ʡ", "������������", "hljhrb",
				"������", 12);
		csl[18] = new Cruise("T002", "������ʡ", "�������������",
				"hljqqhr", "��վ", 21);
		csl[19] = new Cruise("T003", "�ӱ�ʡ", "ʯ��ׯ������", "hbsjz",
				"��վ", 4);
		csl[20] = new Cruise("", "", "", "", "", 0);// �ϲ��㷨��׽���һ�������⣬����һ����Ч���ݣ�����ʱȥ��

		return Arrays.asList(csl);
	}

}
