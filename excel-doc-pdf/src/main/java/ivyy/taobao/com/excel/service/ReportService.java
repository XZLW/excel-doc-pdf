package ivyy.taobao.com.excel.service;

import ivyy.taobao.com.entity.Cruise;

import java.util.Arrays;
import java.util.List;

/**
 * ��������ҵ����
 * 
 * 
 */
public class ReportService {
	/**
	 * ��ȡ����
	 * 
	 * @return
	 */
	public List<Cruise> getCruiseLocationList() {
		Cruise csl[] = new Cruise[21];
		csl[0] = new Cruise("T001", "������", "�����ܲ�", "bj", "�廪��ѧ",
				20);
		csl[20] = new Cruise("", "", "", "", "", 0);// �ϲ��㷨��׽���һ�������⣬����һ����Ч���ݣ�����ʱȥ��

		return Arrays.asList(csl);
	}
}