/*
 *EducationDao.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (受講生管理業務)
 *クラス一覧：
 * NO クラス名 概要
 * 1 EducationDao 各アクションへ誘導するクラスです。
 *履歴：
 * NO 日付 Ver 更新者 内容
 * 1 2016/06/01 V1L1.0 SQT）加瀬 初版。
 */

package jp.co.sqt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import jp.co.sqt.entity.Corporation;
import jp.co.sqt.entity.Education;

/**
 * <dd>クラス名：受講生情報Daoクラス
 * <dd>クラス説明：データベースの受講生テーブルに対して処理を行います。
 *
 * @version 1.00 2016/06/01
 * @author SQT）加瀬
 */
public class EducationDao {

	/**
	 * <dd>メソッド名：受講生情報検索メソッド
	 * <dd>メソッド説明：指定した条件で受講生情報を取得します。
	 *
	 * @param educationKanaName
	 *            氏名（カナ）
	 * @param corporationNo
	 *            企業No
	 * @param year
	 *            入社年
	 * @param month
	 *            入社月
	 * @param order
	 *            並び替えする列名
	 * @return educationList 受講生情報リスト
	 */
	public static List<Education> search(String educationKanaName, String corporationNo, String year, String month,
			String order) {

		/** 受講生情報リスト */
		List<Education> educationList = new ArrayList<Education>();

		/** SQL文にANDを付けるか判別する変数 */
		boolean check = false;

		/** 受講生情報を取得するSQL文 */
		String sql = "SELECT d.no, d.account_no, d.education_name, d.education_kananame,"
				+ " d.education_gender, d.education_birthday, d.education_postalcode,"
				+ " d.education_address, d.education_phonenumber, d.education_emailaddress,"
				+ " e.corporation_no, e.corporation_name, e.corporation_kananame,"
				+ " e.corporation_postalcode, e.corporation_address, e.corporation_tel,"
				+ " e.corporation_fax, e.corporation_representative, e.corporation_representativename,"
				+ " d.enterning_date, d.duties_no1, d.duties_no2, d.duties_no3, d.education_remarks,"
				+ " (SELECT D1.duties_name AS a FROM m_duties AS D1 WHERE D1.duties_no = d.duties_no1) AS duties_nameno1,"
				+ " (SELECT D1.duties_name AS b FROM m_duties AS D1 WHERE D1.duties_no = d.duties_no2) AS duties_nameno2,"
				+ " (SELECT D1.duties_name AS c FROM m_duties AS D1 WHERE D1.duties_no = d.duties_no3) AS duties_nameno3"
				+ " FROM t_education AS d JOIN m_corporation AS e USING (corporation_no)";

		if (!(educationKanaName.equals("") && corporationNo.equals("0") && year.equals("0") && month.equals("0"))) {

			sql += " WHERE";

			if (!(educationKanaName.equals(""))) {

				sql += " d.education_kananame LIKE '%" + educationKanaName + "%'";

				check = true;

			}

			if (!(corporationNo.equals("0"))) {

				if (check) {

					sql += " AND " + "e.corporation_no = " + corporationNo + "";

				} else {

					sql += " e.corporation_no = " + corporationNo + "";

				}

				check = true;

			}

			if (!(year.equals("0") && month.equals("0"))) {

				if (check) {

					if (month.equals("0")) {

						sql += " AND " + "d.enterning_date LIKE '" + year + "-__-__'";

					} else if (year.equals("0")) {

						sql += " AND " + "d.enterning_date LIKE '____-" + month + "-__'";

					} else {

						sql += " AND " + "d.enterning_date LIKE '" + year + "-" + month + "-__'";

					}

				} else {

					if (month.equals("0")) {

						sql += " d.enterning_date LIKE '" + year + "-__-__'";

					} else if (year.equals("0")) {

						sql += " d.enterning_date LIKE '____-" + month + "-__'";

					} else {

						sql += " d.enterning_date LIKE '" + year + "-" + month + "-__'";

					}

				}

			}

		}

		sql += " ORDER BY " + order + " ;";

		/** データソース */
		DataSource ds = null;

		try {

			ds = DataSourceFactory.getDataSource();

		} catch (DaoException e) {

			e.printStackTrace();

		}

		try (Connection conn = ds.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {

				educationList.add(new Education(rs.getInt("no"), rs.getInt("account_no"),
						rs.getString("education_name"), rs.getString("education_kananame"),
						rs.getInt("education_gender"), rs.getString("education_birthday"),
						rs.getString("education_postalcode"), rs.getString("education_address"),
						rs.getString("education_phonenumber"), rs.getString("education_emailaddress"),
						new Corporation(rs.getInt("corporation_no"), rs.getString("corporation_name"),
								rs.getString("corporation_kananame"), rs.getString("corporation_postalcode"),
								rs.getString("corporation_address"), rs.getString("corporation_tel"),
								rs.getString("corporation_fax"), rs.getString("corporation_representative"),
								rs.getString("corporation_representativename")),
						rs.getString("enterning_date"),
						rs.getInt("duties_no1"), rs.getString("duties_nameno1"),
						rs.getInt("duties_no2"), rs.getString("duties_nameno2"),
						rs.getInt("duties_no3"), rs.getString("duties_nameno3"), rs.getString("education_remarks")));
			}

		} catch (SQLException e) {

			System.err.println(e.getMessage());

		}

		return educationList;

	}

	public static List<Education> search1(int corporationNo, int accountAuthority) {

		/** 受講生情報リスト */
		List<Education> educationList = new ArrayList<Education>();

		String sql = "";

		/** 受講生情報を取得するSQL文 */
		if (accountAuthority == 0) {

			sql = "SELECT * FROM t_education;";

		} else {

			sql = "SELECT * FROM t_education WHERE corporation_no = " + corporationNo + "";

		}

		/** データソース */
		DataSource ds = null;

		try {

			ds = DataSourceFactory.getDataSource();

		} catch (DaoException e) {

			e.printStackTrace();

		}

		try (Connection conn = ds.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {

				educationList.add(new Education(rs.getInt("no"), rs.getInt("account_no"),
						rs.getString("education_name"), rs.getString("education_kananame"),
						rs.getInt("education_gender"), rs.getString("education_birthday"),
						rs.getString("education_postalcode"), rs.getString("education_address"),
						rs.getString("education_phonenumber"), rs.getString("education_emailaddress"),
						rs.getInt("corporation_no"), rs.getString("enterning_date"), rs.getInt("duties_no1"),
						rs.getInt("duties_no2"), rs.getInt("duties_no3"), rs.getString("education_remarks")));

			}

		} catch (SQLException e) {

			System.err.println(e.getMessage());

		}

		return educationList;

	}

	public static Education search2(int accountNo) {

		/** 受講生情報リスト */
		Education education = new Education();

		/** 受講生情報を取得するSQL文 */
		String sql = "SELECT E1.account_no, E1.education_name,"
				+ " (SELECT C1.corporation_name AS c FROM m_corporation AS C1 WHERE C1.corporation_no = E1.corporation_no) AS corporation_name,"
				+ " (SELECT D1.duties_name AS a FROM m_duties AS D1 WHERE D1.duties_no = E1.duties_no1) AS duties_nameno1,"
				+ " (SELECT D1.duties_name AS b FROM m_duties AS D1 WHERE D1.duties_no = E1.duties_no2) AS duties_nameno2,"
				+ " (SELECT D1.duties_name AS c FROM m_duties AS D1 WHERE D1.duties_no = E1.duties_no3) AS duties_nameno3"
				+ " FROM t_education AS E1 WHERE E1.account_no = " + accountNo + ";";

		/** データソース */
		DataSource ds = null;

		try {

			ds = DataSourceFactory.getDataSource();

		} catch (DaoException e) {

			e.printStackTrace();

		}

		try (Connection conn = ds.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			rs.next();

			education.setAccountNo(rs.getInt("account_no"));

			education.setEducationName(rs.getString("education_name"));

			education.setCorporationName(rs.getString("corporation_name"));

			education.setDutiesNameNo1(rs.getString("duties_nameno1"));

			education.setDutiesNameNo2(rs.getString("duties_nameno2"));

			education.setDutiesNameNo3(rs.getString("duties_nameno3"));

		} catch (SQLException e) {

			System.err.println(e.getMessage());

		}

		return education;

	}

	public static Education search3(int accountNo) {

		/** 受講生情報リスト */
		Education education = new Education();

		/** 受講生情報を取得するSQL文 */
		String sql = "SELECT *,"
				+ " (SELECT C1.corporation_name AS c FROM m_corporation AS C1 WHERE C1.corporation_no = E1.corporation_no) AS corporation_name,"
				+ " (SELECT D1.duties_name AS a FROM m_duties AS D1 WHERE D1.duties_no = E1.duties_no1) AS duties_nameno1,"
				+ " (SELECT D1.duties_name AS b FROM m_duties AS D1 WHERE D1.duties_no = E1.duties_no2) AS duties_nameno2,"
				+ " (SELECT D1.duties_name AS c FROM m_duties AS D1 WHERE D1.duties_no = E1.duties_no3) AS duties_nameno3"
				+ " FROM t_education AS E1 WHERE E1.account_no = " + accountNo + ";";

		/** データソース */
		DataSource ds = null;

		try {

			ds = DataSourceFactory.getDataSource();

		} catch (DaoException e) {

			e.printStackTrace();

		}

		try (Connection conn = ds.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			rs.next();

			education.setEducationNo(rs.getInt("no"));

			education.setAccountNo(rs.getInt("account_no"));

			education.setEducationName(rs.getString("education_name"));

			education.setEducationKanaName(rs.getString("education_kananame"));

			education.setEducationGender(rs.getInt("education_gender"));

			education.setEducationBirthday(rs.getString("education_birthday"));

			education.setEducationPostalcode(rs.getString("education_postalcode"));

			education.setEducationAddress(rs.getString("education_address"));

			education.setEducationPhoneNumber(rs.getString("education_phonenumber"));

			education.setEducationEmailAddress(rs.getString("education_emailaddress"));

			education.setCorporationNo(rs.getInt("corporation_no"));

			education.setCorporationName(rs.getString("corporation_name"));

			education.setEnterningDate(rs.getString("enterning_date"));

			education.setDutiesNo1(rs.getInt("duties_no1"));

			education.setDutiesNo2(rs.getInt("duties_no2"));

			education.setDutiesNo3(rs.getInt("duties_no3"));

			education.setDutiesNameNo1(rs.getString("duties_nameno1"));

			education.setDutiesNameNo2(rs.getString("duties_nameno2"));

			education.setDutiesNameNo3(rs.getString("duties_nameno3"));

			education.setEducationRemarks(rs.getString("education_remarks"));

		} catch (SQLException e) {

			System.err.println(e.getMessage());

		}

		return education;

	}

	/**
	 * <dd>メソッド名：受講生情報検索メソッド
	 * <dd>メソッド説明：指定した条件で受講生情報を取得します。
	 *
	 * @param education
	 *            受講生情報
	 * @return educationFlg 重複件数
	 */
	public static int doubleCheck(Education education) {

		String sql = "SELECT COUNT(account_no) AS double_account_no FROM t_education"
				+ " WHERE education_name = '" + education.getEducationName() + "'"
				+ " AND education_kananame = '" + education.getEducationKanaName() + "';";

		/** 受講生重複件数 */
		int educationFlg = 0;

		/** データソース */
		DataSource ds = null;

		try {

			ds = DataSourceFactory.getDataSource();

		} catch (DaoException e1) {

			e1.printStackTrace();

		}

		try (Connection conn = ds.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			rs.next();

			educationFlg = rs.getInt("double_account_no");

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		return educationFlg;

	}

	/**
	 * <dd>メソッド名：最大受講生ID取得メソッド
	 * <dd>メソッド説明：受講生IDの最大値を取得します。
	 *
	 * @return maxId 最大受講生ID
	 */
	public static int getLastId() {

		/** 現在の最大受講生IDを取得するSQL文 */
		String sql = "SELECT MAX(account_no) AS max_account_no FROM t_education";

		/** 受講生ID最大値 */
		int maxId = 0;

		/** データソース */
		DataSource ds = null;

		try {

			ds = DataSourceFactory.getDataSource();

		} catch (DaoException e1) {

			e1.printStackTrace();

		}

		try (Connection conn = ds.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			rs.next();

			maxId = rs.getInt("max_account_no");

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		return maxId;

	}

	/**
	 * <dd>メソッド名：件数取得メソッド
	 * <dd>メソッド説明：現在の登録件数を数えます。
	 *
	 * @return record 登録件数
	 */
	public static int countRecord() {

		/** 現在の登録数を数えるSQL文 */
		String sql = "SELECT count(account_no) AS SUM FROM t_education";

		/** 登録件数 */
		int record = 0;

		/** データソース */
		DataSource ds = null;

		try {

			ds = DataSourceFactory.getDataSource();

		} catch (DaoException e1) {

			e1.printStackTrace();

		}

		try (Connection conn = ds.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			rs.next();

			record = rs.getInt("SUM");

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

		return record;

	}

	/**
	 * <dd>メソッド名：受講生情報登録メソッド
	 * <dd>メソッド説明：受け取った受講生情報を登録します。
	 *
	 * @param education
	 *            受講生情報
	 */
	public static void insert(Education education) {

		/** 受講生情報を登録するSQL文 */
		String sql = "INSERT INTO t_education (no, account_no, education_name, education_kananame, "
				+ "education_gender, education_birthday, education_postalcode, education_address, "
				+ "education_phonenumber, education_emailaddress, corporation_no, enterning_date, "
				+ "duties_no1, duties_no2, duties_no3, education_remarks) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		/** データソース */
		DataSource ds = null;

		try {

			ds = DataSourceFactory.getDataSource();

		} catch (DaoException e) {

			e.printStackTrace();

		}

		try (Connection conn = ds.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, education.getEducationNo());

			stmt.setInt(2, education.getAccountNo());

			stmt.setString(3, education.getEducationName());

			stmt.setString(4, education.getEducationKanaName());

			stmt.setInt(5, education.getEducationGender());

			stmt.setString(6, education.getEducationBirthday());

			stmt.setString(7, education.getEducationPostalcode());

			stmt.setString(8, education.getEducationAddress());

			stmt.setString(9, education.getEducationPhoneNumber());

			stmt.setString(10, education.getEducationEmailAddress());

			stmt.setInt(11, education.getCorporation().getCorporationNo());

			stmt.setString(12, education.getEnterningDate());

			stmt.setInt(13, education.getDutiesNo1());

			stmt.setInt(14, education.getDutiesNo2());

			stmt.setInt(15, education.getDutiesNo3());

			stmt.setString(16, education.getEducationRemarks());

			stmt.executeUpdate();

			conn.commit();

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

	}

	/**
	 * <dd>メソッド名：受講生情報変更メソッド
	 * <dd>メソッド説明：受け取った受講生情報を変更します。
	 *
	 * @param education
	 *            受講生情報
	 */
	public static void update(Education education) {

		/** お知らせ情報を変更するSQL文 */
		String sql = "UPDATE t_education SET account_no = ?, education_name = ?, education_kananame = ?, "
				+ " education_gender = ?, education_birthday = ?, education_postalcode = ?, education_address = ?, "
				+ " education_phonenumber = ?, education_emailaddress = ?, enterning_date = ?, "
				+ " duties_no1 = ?, duties_no2 = ?, duties_no3 = ?, education_remarks = ?"
				+ " WHERE no = ? ;";

		/** データソース */
		DataSource ds = null;

		try {

			ds = DataSourceFactory.getDataSource();

		} catch (DaoException e) {

			e.printStackTrace();

		}

		try (Connection conn = ds.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, education.getAccountNo());

			stmt.setString(2, education.getEducationName());

			stmt.setString(3, education.getEducationKanaName());

			stmt.setInt(4, education.getEducationGender());

			stmt.setString(5, education.getEducationBirthday());

			stmt.setString(6, education.getEducationPostalcode());

			stmt.setString(7, education.getEducationAddress());

			stmt.setString(8, education.getEducationPhoneNumber());

			stmt.setString(9, education.getEducationEmailAddress());

			stmt.setString(10, education.getEnterningDate());

			stmt.setInt(11, education.getDutiesNo1());

			stmt.setInt(12, education.getDutiesNo2());

			stmt.setInt(13, education.getDutiesNo3());

			stmt.setString(14, education.getEducationRemarks());

			stmt.setInt(15, education.getEducationNo());

			stmt.executeUpdate();

			conn.commit();

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

	}

	/**
	 * <dd>メソッド名：受講生情報削除メソッド
	 * <dd>メソッド説明：選択した受講生情報を論理削除します。
	 *
	 * @param educationList
	 *            受講生情報
	 */
	public static void delete(List<Education> educationList) {

		String sql = "DELETE from t_education WHERE no = " + educationList.get(0).getEducationNo();

		if (educationList.size() > 1) {

			for (int i = 1; i < educationList.size(); i++) {

				sql += " OR no = " + educationList.get(i).getEducationNo();

			}

			sql += ";";

		}

		/** データソース */
		DataSource ds = null;

		try {

			ds = DataSourceFactory.getDataSource();

		} catch (DaoException e1) {

			e1.printStackTrace();

		}

		try (Connection conn = ds.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();

			conn.commit();

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}

	}

	/**
	 * <dd>メソッド名：文字列year取得メソッド
	 * <dd>Dateから文字列としてyearを取得します。
	 *
	 * @param date
	 *            日付
	 * @return new SimpleDateFormat("yyyy").format(date) 年
	 */
	public static String dateToStringYear(Date date) {

		return (new SimpleDateFormat("yyyy").format(date));

	}

	/**
	 * <dd>メソッド名：文字列month取得メソッド
	 * <dd>Dateから文字列としてmonthを取得します。
	 *
	 * @param date
	 *            日付
	 * @return new SimpleDateFormat("MM").format(date) 月
	 */
	public static String dateToStringMonth(Date date) {

		return (new SimpleDateFormat("MM").format(date));

	}

}
