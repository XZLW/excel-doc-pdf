package ivyy.taobao.com.excel.dao;

import ivyy.taobao.com.entity.UserInfo;
import ivyy.taobao.com.utils.ConfigDbHelper;
import ivyy.taobao.com.utils.DBHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *@DEMO:excel-doc-pdf
 *@Java��UserInfoDao.java
 *@Date:2015-1-11����10:21:31
 *@Author:liangjilong
 *@Email:jilongliang@sina.com
 *@Weibo:http://weibo.com/jilongliang
 *@Version:1.0
 *@Description��https://github.com/jilongliang/JL_OutExcel
 */
@SuppressWarnings("all")
public class UserInfoDao {

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	/**
	 * ��ȡȫ���ͻ�
	 */
	public List<UserInfo> getAllUserInfo(String sqlWhere) {
		List<UserInfo> infoList = new ArrayList<UserInfo>();
		// ��ѯ��ƷSQL
		String sql = "select * from userInfo " + sqlWhere;
		try {
			/**
			 * ����ǳ��õ�DbHelper����
			 */
			// conn = DbHelper.getInstance().getMSSQLConnection();
			/**
			 * ��ȡ���õ����ӷ�ʽ
			 */
			conn = ConfigDbHelper.getInstance().getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				UserInfo userInfo = new UserInfo();
				userInfo.setId(rs.getString("id"));
				userInfo.setTelephone(rs.getString("telephone"));
				userInfo.setAddress(rs.getString("address"));
				userInfo.setUsername(rs.getString("username"));
				infoList.add(userInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.Relesae(rs, stmt, conn);
		}
		return infoList;
	}
}
