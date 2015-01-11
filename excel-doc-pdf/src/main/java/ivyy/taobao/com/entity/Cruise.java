package ivyy.taobao.com.entity;

import java.io.Serializable;

/**
 *@DEMO:excel-doc-pdf
 *@Java��Cruise.java
 *@Date:2015-1-10����10:37:54
 *@Author:liangjilong
 *@Email:jilongliang@sina.com
 *@Weibo:http://weibo.com/jilongliang
 *@Version:1.0
 *@Description��
 */
public class Cruise implements Serializable{
	private String division;// ��ҵ��
	private String province;// ʡ��
	private String dealerName;// ����������
	private String dealerCode;// �����̴���
	private String location;// Ѳ������ص�
	private double miles;// Ѳ���������
	private int locationNum;// �ص�����
	private double totalDealer;// �����̺ϼ�
	private double totalProvince;// ʡ�ݺϼ�
	private double totalDivision;// ��ҵ���ϼ�

	public Cruise() {
		super();
	}

	public Cruise(String division, String province,
			String dealerName, String dealerCode, String location, double miles) {
		super();
		this.division = division;
		this.province = province;
		this.dealerName = dealerName;
		this.dealerCode = dealerCode;
		this.location = location;
		this.miles = miles;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public String getDealerCode() {
		return dealerCode;
	}

	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getMiles() {
		return miles;
	}

	public void setMiles(double miles) {
		this.miles = miles;
	}

	public int getLocationNum() {
		return locationNum;
	}

	public void setLocationNum(int locationNum) {
		this.locationNum = locationNum;
	}

	public double getTotalDealer() {
		return totalDealer;
	}

	public void setTotalDealer(double totalDealer) {
		this.totalDealer = totalDealer;
	}

	public double getTotalProvince() {
		return totalProvince;
	}

	public void setTotalProvince(double totalProvince) {
		this.totalProvince = totalProvince;
	}

	public double getTotalDivision() {
		return totalDivision;
	}

	public void setTotalDivision(double totalDivision) {
		this.totalDivision = totalDivision;
	}
}
