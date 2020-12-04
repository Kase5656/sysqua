/*
 *Report.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (受講生管理業務)
 *クラス一覧：
 * NO クラス名 概要
 * 1 Report データベースから取得した情報を保持するクラスです。
 *履歴：
 * NO 日付 Ver 更新者 内容
 * 1 2017/00/00 V1L1.0 SQT）加瀬 初版。
 */

package jp.co.sqt.entity;

import java.io.Serializable;

/**
 * <dd>クラス名：レポート情報エンティティクラス
 * <dd>クラス説明：レポートID、レポート名を扱います。 データベースから取得した情報を保持します。
 *
 * @version 1.00 2017/00/00
 * @author SQT）加瀬
 */
public class Report implements Serializable {

	/** 直列化ID */
	private static final long serialVersionUID = 1L;

	/** アカウントNo */
	private int accountNo;

	/** レポートNo */
	private int reportNo;

	/** レポート登録日 */
	private String reportDate;

	/** レポート登録日時 */
	private String reportDateTime;

	/** レポート更新日時 */
	private String reportLastDateTime;

	/** 研修項目１~5 */
	private String contentsItem1, contentsItem2, contentsItem3, contentsItem4, contentsItem5;

	/** 実施時間(開始)1~5 */
	private String contentsStartTime1, contentsStartTime2, contentsStartTime3, contentsStartTime4,
			contentsStartTime5;

	/** 実施時間(終了)1~5 */
	private String contentsEndTime1, contentsEndTime2, contentsEndTime3, contentsEndTime4, contentsEndTime5;

	/** 進捗度1~5 */
	private int contentsProgress1, contentsProgress2, contentsProgress3, contentsProgress4, contentsProgress5;

	/** 理解度1~5 */
	private String contentsUnderStanding1, contentsUnderStanding2, contentsUnderStanding3, contentsUnderStanding4,
			contentsUnderStanding5;

	/** 所感1~5 */
	private String contentsImpression1, contentsImpression2, contentsImpression3, contentsImpression4,
			contentsImpression5;

	/** 今月の目標1~2 */
	private String monthGoal1, monthGoal2;

	/** 今日の目標1~2 */
	private String todayGoal1, todayGoal2;

	/**今日の目標達成度 */
	private int todayGoalScore;

	/** 満足だった点、不満足だった点 */
	private String todaySatisfaction, todayDisSatisfaction;

	/** 本日の問題点、対策 */
	private String todayProblem, todayMeasures;

	/** 明日(次週)の予定 */
	private String nextPlan;

	/** 全体の今月の目標及び疑問点 */
	private String allImpression;

	/**
	 * <dd>メソッド名：Reportデフォルトコンストラクタメソッド
	 * <dd>メソッド説明：インスタンスの生成を可能にします。
	 */
	public Report() {
	}

	/**
	 * <dd>メソッド名：Reportコンストラクタメソッド
	 * <dd>メソッド説明：レポート情報を初期化します。
	 *
	 * @param
	 */
	public Report(int reportNo, int accountNo, String reportDate, String reportDateTime, String reportLastDateTime,
			String contentsItem1, String contentsStartTime1, String contentsEndTime1,
			int contentsProgress1, String contentsUnderStanding1, String contentsImpression1,
			String contentsItem2, String contentsStartTime2, String contentsEndTime2,
			int contentsProgress2, String contentsUnderStanding2, String contentsImpression2,
			String contentsItem3, String contentsStartTime3, String contentsEndTime3,
			int contentsProgress3, String contentsUnderStanding3, String contentsImpression3,
			String contentsItem4, String contentsStartTime4, String contentsEndTime4,
			int contentsProgress4, String contentsUnderStanding4, String contentsImpression4,
			String contentsItem5, String contentsStartTime5, String contentsEndTime5,
			int contentsProgress5, String contentsUnderStanding5, String contentsImpression5,
			String monthGoal1, String monthGoal2, String todayGoal1, String todayGoal2,
			int todayGoalScore, String todaySatisfaction, String today_dissatisfaction,
			String todayProblem, String todayMeasures, String nextPlan, String allImpression) {

		super();

		this.reportNo = reportNo;

		this.accountNo = accountNo;

		this.reportDate = reportDate;

		this.reportDateTime = reportDateTime;

		this.reportLastDateTime = reportLastDateTime;

		this.contentsItem1 = contentsItem1;

		this.contentsStartTime1 = contentsStartTime1;

		this.contentsEndTime1 = contentsEndTime1;

		this.contentsProgress1 = contentsProgress1;

		this.contentsUnderStanding1 = contentsUnderStanding1;

		this.contentsImpression1 = contentsImpression1;

		this.contentsItem2 = contentsItem2;

		this.contentsStartTime2 = contentsStartTime2;

		this.contentsEndTime2 = contentsEndTime2;

		this.contentsProgress2 = contentsProgress2;

		this.contentsUnderStanding2 = contentsUnderStanding2;

		this.contentsImpression2 = contentsImpression2;

		this.contentsItem3 = contentsItem3;

		this.contentsStartTime3 = contentsStartTime3;

		this.contentsEndTime3 = contentsEndTime3;

		this.contentsProgress3 = contentsProgress3;

		this.contentsUnderStanding3 = contentsUnderStanding3;

		this.contentsImpression3 = contentsImpression3;

		this.contentsItem4 = contentsItem4;

		this.contentsStartTime4 = contentsStartTime4;

		this.contentsEndTime4 = contentsEndTime4;

		this.contentsProgress4 = contentsProgress4;

		this.contentsUnderStanding4 = contentsUnderStanding4;

		this.contentsImpression4 = contentsImpression4;

		this.contentsItem5 = contentsItem5;

		this.contentsStartTime5 = contentsStartTime5;

		this.contentsEndTime5 = contentsEndTime5;

		this.contentsProgress5 = contentsProgress5;

		this.contentsUnderStanding5 = contentsUnderStanding5;

		this.contentsImpression5 = contentsImpression5;

		this.monthGoal1 = monthGoal1;

		this.monthGoal2 = monthGoal2;

		this.todayGoal1 = todayGoal1;

		this.todayGoal2 = todayGoal2;

		this.todayGoalScore = todayGoalScore;

		this.todaySatisfaction = todaySatisfaction;

		this.todayDisSatisfaction = today_dissatisfaction;

		this.todayProblem = todayProblem;

		this.todayMeasures = todayMeasures;

		this.nextPlan = nextPlan;

		this.allImpression = allImpression;

	}

	/**
	 * <dd>メソッド名：レポートNo取得メソッド
	 * <dd>メソッド説明：レポートNoを取得します。
	 *
	 * @return reportNo レポートNo
	 */
	public int getReportNo() {

		return reportNo;

	}

	/**
	 * <dd>メソッド名：レポートNo設定メソッド
	 * <dd>メソッド説明：レポートNoを設定します。
	 *
	 * @param reportNo
	 *            レポートNo
	 */
	public void setReportNo(int reportNo) {

		this.reportNo = reportNo;

	}

	/**
	 * <dd>メソッド名：アカウントNo取得メソッド
	 * <dd>メソッド説明：アカウントNoを取得します。
	 *
	 * @return accountNo アカウントNo
	 */
	public int getAccountNo() {

		return accountNo;

	}

	/**
	 * <dd>メソッド名：アカウントNo設定メソッド
	 * <dd>メソッド説明：アカウントNoを設定します。
	 *
	 * @param accountNo
	 *            アカウントNo
	 */
	public void setAccountNo(int accountNo) {

		this.accountNo = accountNo;

	}

	/**
	 * <dd>メソッド名：レポート登録日時取得メソッド
	 * <dd>メソッド説明：レポート登録日時を取得します。
	 *
	 * @return reportDate レポート登録日時
	 */
	public String getReportDate() {

		return reportDate;

	}

	/**
	 * <dd>メソッド名：レポート登録日時設定メソッド
	 * <dd>メソッド説明：レポート登録日時を設定します。
	 *
	 * @param reportDate
	 *            レポート日付
	 */
	public void setReportDate(String reportDate) {

		this.reportDate = reportDate;

	}

	/**
	 * <dd>メソッド名：レポート登録日時取得メソッド
	 * <dd>メソッド説明：レポート登録日時を取得します。
	 *
	 * @return reportDateTime レポート登録日時
	 */
	public String getReportDateTime() {

		return reportDateTime;

	}

	/**
	 * <dd>メソッド名：レポート登録日時設定メソッド
	 * <dd>メソッド説明：レポート登録日時を設定します。
	 *
	 * @param reportDateTime
	 *            レポート日付
	 */
	public void setReportDateTime(String reportDateTime) {

		this.reportDateTime = reportDateTime;

	}

	/**
	 * <dd>メソッド名：レポート更新日時取得メソッド
	 * <dd>メソッド説明：レポート更新日時を取得します。
	 *
	 * @return reportLastDateTime レポート更新日時
	 */
	public String getReportLastDateTime() {

		return reportLastDateTime;

	}

	/**
	 * <dd>メソッド名：レポート更新日時設定メソッド
	 * <dd>メソッド説明：レポート更新日時を設定します。
	 *
	 * @param reportLastDateTime
	 *            レポート更新日時
	 */
	public void setReportLastDateTime(String reportLastDateTime) {

		this.reportLastDateTime = reportLastDateTime;

	}

	/**
	 * <dd>メソッド名：研修項目1取得メソッド
	 * <dd>メソッド説明：研修項目1を取得します。
	 *
	 * @return contentsItem1 研修項目1
	 */
	public String getContentsItem1() {

		return contentsItem1;

	}

	/**
	 * <dd>メソッド名：研修項目1設定メソッド
	 * <dd>メソッド説明：研修項目1を設定します。
	 *
	 * @param contentsItem1 研修項目1
	 */
	public void setContentsItem1(String contentsItem1) {

		this.contentsItem1 = contentsItem1;

	}

	/**
	 * <dd>メソッド名：研修項目2取得メソッド
	 * <dd>メソッド説明：研修項目2を取得します。
	 *
	 * @return contentsItem2 研修項目2
	 */
	public String getContentsItem2() {

		return contentsItem2;

	}

	/**
	 * <dd>メソッド名：研修項目2設定メソッド
	 * <dd>メソッド説明：研修項目2を設定します。
	 *
	 * @param contentsItem2 研修項目2
	 */
	public void setContentsItem2(String contentsItem2) {

		this.contentsItem2 = contentsItem2;

	}

	/**
	 * <dd>メソッド名：研修項目3取得メソッド
	 * <dd>メソッド説明：研修項目3を取得します。
	 *
	 * @return contentsItem3 研修項目3
	 */
	public String getContentsItem3() {

		return contentsItem3;

	}

	/**
	 * <dd>メソッド名：研修項目3設定メソッド
	 * <dd>メソッド説明：研修項目3を設定します。
	 *
	 * @param contentsItem3 研修項目3
	 */
	public void setContentsItem3(String contentsItem3) {

		this.contentsItem3 = contentsItem3;

	}

	/**
	 * <dd>メソッド名：研修項目4取得メソッド
	 * <dd>メソッド説明：研修項目4を取得します。
	 *
	 * @return contentsItem4 研修項目4
	 */
	public String getContentsItem4() {

		return contentsItem4;

	}

	/**
	 * <dd>メソッド名：研修項目設定メソッド
	 * <dd>メソッド説明：研修項目を設定します。
	 *
	 * @param contentsItem4 研修項目4
	 */
	public void setContentsItem4(String contentsItem4) {

		this.contentsItem4 = contentsItem4;

	}

	/**
	 * <dd>メソッド名：研修項目5取得メソッド
	 * <dd>メソッド説明：研修項目5を取得します。
	 *
	 * @return contentsItem5 研修項目5
	 */
	public String getContentsItem5() {

		return contentsItem5;

	}

	/**
	 * <dd>メソッド名：研修項目5設定メソッド
	 * <dd>メソッド説明：研修項目5を設定します。
	 *
	 * @param contentsItem5 研修項目5
	 */
	public void setContentsItem5(String contentsItem5) {

		this.contentsItem5 = contentsItem5;

	}

	/**
	 * <dd>メソッド名：実施時間(開始)1 取得メソッド
	 * <dd>メソッド説明：実施時間(開始)1を取得します。
	 *
	 * @return contentsStartTime1 実施時間(開始)1
	 */
	public String getContentsStartTime1() {

		return contentsStartTime1;

	}

	/**
	 * <dd>メソッド名：実施時間(開始)1設定メソッド
	 * <dd>メソッド説明：実施時間(開始)1を設定します。
	 *
	 * @param contentsStartTime1 実施時間(開始)1
	 */
	public void setContentsStartTime1(String contentsStartTime1) {

		this.contentsStartTime1 = contentsStartTime1;

	}

	/**
	 * <dd>メソッド名：実施時間(開始)2 取得メソッド
	 * <dd>メソッド説明：実施時間(開始)2を取得します。
	 *
	 * @return contentsStartTime2 実施時間(開始)2
	 */
	public String getContentsStartTime2() {

		return contentsStartTime2;

	}

	/**
	 * <dd>メソッド名：実施時間(開始)2設定メソッド
	 * <dd>メソッド説明：実施時間(開始)2を設定します。
	 *
	 * @param contentsStartTime2 実施時間(開始)2
	 */
	public void setContentsStartTime2(String contentsStartTime2) {

		this.contentsStartTime2 = contentsStartTime2;

	}

	/**
	 * <dd>メソッド名：実施時間(開始)3 取得メソッド
	 * <dd>メソッド説明：実施時間(開始)3を取得します。
	 *
	 * @return contentsStartTime3 実施時間(開始)3
	 */
	public String getContentsStartTime3() {

		return contentsStartTime3;

	}

	/**
	 * <dd>メソッド名：実施時間(開始)3設定メソッド
	 * <dd>メソッド説明：実施時間(開始)3を設定します。
	 *
	 * @param contentsStartTime3 実施時間(開始)3
	 */
	public void setContentsStartTime3(String contentsStartTime3) {

		this.contentsStartTime3 = contentsStartTime3;

	}

	/**
	 * <dd>メソッド名：実施時間(開始)4 取得メソッド
	 * <dd>メソッド説明：実施時間(開始)4を取得します。
	 *
	 * @return contentsStartTime4 実施時間(開始)4
	 */
	public String getContentsStartTime4() {

		return contentsStartTime4;

	}

	/**
	 * <dd>メソッド名：実施時間(開始)4設定メソッド
	 * <dd>メソッド説明：実施時間(開始)4を設定します。
	 *
	 * @param contentsStartTime4 実施時間(開始)4
	 */
	public void setContentsStartTime4(String contentsStartTime4) {

		this.contentsStartTime4 = contentsStartTime4;

	}

	/**
	 * <dd>メソッド名：実施時間(開始)5 取得メソッド
	 * <dd>メソッド説明：実施時間(開始)5を取得します。
	 *
	 * @return contentsStartTime5 実施時間(開始)5
	 */
	public String getContentsStartTime5() {

		return contentsStartTime5;

	}

	/**
	 * <dd>メソッド名：実施時間(開始)5設定メソッド
	 * <dd>メソッド説明：実施時間(開始)5を設定します。
	 *
	 * @param contentsStartTime5 実施時間(開始)5
	 */
	public void setContentsStartTime5(String contentsStartTime5) {

		this.contentsStartTime5 = contentsStartTime5;

	}

	/**
	 * <dd>メソッド名：実施時間(終了)1 取得メソッド
	 * <dd>メソッド説明：実施時間(終了)1を取得します。
	 *
	 * @return contentsEndTime1 実施時間(終了)1
	 */
	public String getContentsEndTime1() {

		return contentsEndTime1;

	}

	/**
	 * <dd>メソッド名：実施時間(終了)1設定メソッド
	 * <dd>メソッド説明：実施時間(終了)1を設定します。
	 *
	 * @param contentsEndTime1 実施時間(終了)1
	 */
	public void setContentsEndTime1(String contentsEndTime1) {

		this.contentsEndTime1 = contentsEndTime1;

	}

	/**
	 * <dd>メソッド名：実施時間(終了)2 取得メソッド
	 * <dd>メソッド説明：実施時間(終了)2を取得します。
	 *
	 * @return contentsEndTime2 実施時間(終了)2
	 */
	public String getContentsEndTime2() {

		return contentsEndTime2;

	}

	/**
	 * <dd>メソッド名：実施時間(終了)2設定メソッド
	 * <dd>メソッド説明：実施時間(終了)2を設定します。
	 *
	 * @param contentsEndTime2 実施時間(終了)2
	 */
	public void setContentsEndTime2(String contentsEndTime2) {

		this.contentsEndTime2 = contentsEndTime2;

	}

	/**
	 * <dd>メソッド名：実施時間(終了)3 取得メソッド
	 * <dd>メソッド説明：実施時間(終了)3を取得します。
	 *
	 * @return contentsEndTime3 実施時間(終了)3
	 */
	public String getContentsEndTime3() {

		return contentsEndTime3;

	}

	/**
	 * <dd>メソッド名：実施時間(終了)3設定メソッド
	 * <dd>メソッド説明：実施時間(終了)3を設定します。
	 *
	 * @param contentsEndTime3 実施時間(終了)3
	 */
	public void setContentsEndTime3(String contentsEndTime3) {

		this.contentsEndTime3 = contentsEndTime3;

	}

	/**
	 * <dd>メソッド名：実施時間(終了)4 取得メソッド
	 * <dd>メソッド説明：実施時間(終了)4を取得します。
	 *
	 * @return contentsEndTime4 実施時間(終了)4
	 */
	public String getContentsEndTime4() {

		return contentsEndTime4;

	}

	/**
	 * <dd>メソッド名：実施時間(終了)4設定メソッド
	 * <dd>メソッド説明：実施時間(終了)4を設定します。
	 *
	 * @param contentsEndTime4 実施時間(終了)4
	 */
	public void setContentsEndTime4(String contentsEndTime4) {

		this.contentsEndTime4 = contentsEndTime4;

	}

	/**
	 * <dd>メソッド名：実施時間(終了)5 取得メソッド
	 * <dd>メソッド説明：実施時間(終了)5を取得します。
	 *
	 * @return contentsEndTime5 実施時間(終了)5
	 */
	public String getContentsEndTime5() {

		return contentsEndTime5;

	}

	/**
	 * <dd>メソッド名：実施時間(終了)5設定メソッド
	 * <dd>メソッド説明：実施時間(終了)5を設定します。
	 *
	 * @param contentsEndTime5 実施時間(終了)5
	 */
	public void setContentsEndTime5(String contentsEndTime5) {

		this.contentsEndTime5 = contentsEndTime5;

	}

	/**
	 * <dd>メソッド名：進捗度1取得メソッド
	 * <dd>メソッド説明：進捗度1を取得します。
	 *
	 * @return contentsProgress1 進捗度1
	 */
	public int getContentsProgress1() {

		return contentsProgress1;

	}

	/**
	 * <dd>メソッド名：進捗度1設定メソッド
	 * <dd>メソッド説明：進捗度1を設定します。
	 *
	 * @param contentsProgress1
	 *            進捗度1
	 */
	public void setContentsProgress1(int contentsProgress1) {

		this.contentsProgress1 = contentsProgress1;

	}

	/**
	 * <dd>メソッド名：進捗度2取得メソッド
	 * <dd>メソッド説明：進捗度2を取得します。
	 *
	 * @return contentsProgress2 進捗度2
	 */
	public int getContentsProgress2() {

		return contentsProgress2;

	}

	/**
	 * <dd>メソッド名：進捗度2設定メソッド
	 * <dd>メソッド説明：進捗度2を設定します。
	 *
	 * @param contentsProgress2
	 *            進捗度2
	 */
	public void setContentsProgress2(int contentsProgress2) {

		this.contentsProgress2 = contentsProgress2;

	}

	/**
	 * <dd>メソッド名：進捗度3取得メソッド
	 * <dd>メソッド説明：進捗度3を取得します。
	 *
	 * @return contentsProgress3 進捗度3
	 */
	public int getContentsProgress3() {

		return contentsProgress3;

	}

	/**
	 * <dd>メソッド名：進捗度3設定メソッド
	 * <dd>メソッド説明：進捗度3を設定します。
	 *
	 * @param contentsProgress3
	 *            進捗度3
	 */
	public void setContentsProgress3(int contentsProgress3) {

		this.contentsProgress3 = contentsProgress3;

	}

	/**
	 * <dd>メソッド名：進捗度4取得メソッド
	 * <dd>メソッド説明：進捗度4を取得します。
	 *
	 * @return contentsProgress4 進捗度4
	 */
	public int getContentsProgress4() {

		return contentsProgress4;

	}

	/**
	 * <dd>メソッド名：進捗度4設定メソッド
	 * <dd>メソッド説明：進捗度4を設定します。
	 *
	 * @param contentsProgress4
	 *            進捗度4
	 */
	public void setContentsProgress4(int contentsProgress4) {

		this.contentsProgress4 = contentsProgress4;

	}

	/**
	 * <dd>メソッド名：進捗度5取得メソッド
	 * <dd>メソッド説明：進捗度5を取得します。
	 *
	 * @return contentsProgress5 進捗度5
	 */
	public int getContentsProgress5() {

		return contentsProgress5;

	}

	/**
	 * <dd>メソッド名：進捗度5設定メソッド
	 * <dd>メソッド説明：進捗度5を設定します。
	 *
	 * @param contentsProgress5
	 *            進捗度5
	 */
	public void setContentsProgress5(int contentsProgress5) {

		this.contentsProgress5 = contentsProgress5;

	}

	/**
	 * <dd>メソッド名：理解度1取得メソッド
	 * <dd>メソッド説明：理解度1を取得します。
	 *
	 * @return contentsUnderStanding1 理解度1
	 */
	public String getContentsUnderStanding1() {

		return contentsUnderStanding1;

	}

	/**
	 * <dd>メソッド名：理解度1設定メソッド
	 * <dd>メソッド説明：理解度1を設定します。
	 *
	 * @param contentsUnderStanding1
	 *            理解度1
	 */
	public void setContentsUnderStanding1(String contentsUnderStanding1) {

		this.contentsUnderStanding1 = contentsUnderStanding1;

	}

	/**
	 * <dd>メソッド名：理解度2取得メソッド
	 * <dd>メソッド説明：理解度2を取得します。
	 *
	 * @return contentsUnderStanding2 理解度2
	 */
	public String getContentsUnderStanding2() {

		return contentsUnderStanding2;

	}

	/**
	 * <dd>メソッド名：理解度2設定メソッド
	 * <dd>メソッド説明：理解度2を設定します。
	 *
	 * @param contentsUnderStanding2
	 *            理解度2
	 */
	public void setContentsUnderStanding2(String contentsUnderStanding2) {

		this.contentsUnderStanding2 = contentsUnderStanding2;

	}

	/**
	 * <dd>メソッド名：理解度3取得メソッド
	 * <dd>メソッド説明：理解度3を取得します。
	 *
	 * @return contentsUnderStanding3 理解度3
	 */
	public String getContentsUnderStanding3() {

		return contentsUnderStanding3;

	}

	/**
	 * <dd>メソッド名：理解度3設定メソッド
	 * <dd>メソッド説明：理解度3を設定します。
	 *
	 * @param contentsUnderStanding3
	 *            理解度3
	 */
	public void setContentsUnderStanding3(String contentsUnderStanding3) {

		this.contentsUnderStanding3 = contentsUnderStanding3;

	}

	/**
	 * <dd>メソッド名：理解度4取得メソッド
	 * <dd>メソッド説明：理解度4を取得します。
	 *
	 * @return contentsUnderStanding4 理解度4
	 */
	public String getContentsUnderStanding4() {

		return contentsUnderStanding4;

	}

	/**
	 * <dd>メソッド名：理解度4設定メソッド
	 * <dd>メソッド説明：理解度4を設定します。
	 *
	 * @param contentsUnderStanding4
	 *            理解度4
	 */
	public void setContentsUnderStanding4(String contentsUnderStanding4) {

		this.contentsUnderStanding4 = contentsUnderStanding4;

	}

	/**
	 * <dd>メソッド名：理解度5取得メソッド
	 * <dd>メソッド説明：理解度5を取得します。
	 *
	 * @return contentsUnderStanding5 理解度5
	 */
	public String getContentsUnderStanding5() {

		return contentsUnderStanding5;

	}

	/**
	 * <dd>メソッド名：理解度5設定メソッド
	 * <dd>メソッド説明：理解度5を設定します。
	 *
	 * @param contentsUnderStanding5
	 *            理解度5
	 */
	public void setContentsUnderStanding5(String contentsUnderStanding5) {

		this.contentsUnderStanding5 = contentsUnderStanding5;

	}

	/**
	 * <dd>メソッド名：今月の目標1取得メソッド
	 * <dd>メソッド説明：今月の目標1を取得します。
	 *
	 * @return contentsImpression1 今月の目標1
	 */
	public String getContentsImpression1() {

		return contentsImpression1;

	}

	/**
	 * <dd>メソッド名：今月の目標1設定メソッド
	 * <dd>メソッド説明：今月の目標1を設定します。
	 *
	 * @param contentsImpression1
	 *            今月の目標1
	 */
	public void setContentsImpression1(String contentsImpression1) {

		this.contentsImpression1 = contentsImpression1;

	}

	/**
	 * <dd>メソッド名：今月の目標2取得メソッド
	 * <dd>メソッド説明：今月の目標2を取得します。
	 *
	 * @return contentsImpression2 今月の目標2
	 */
	public String getContentsImpression2() {

		return contentsImpression2;

	}

	/**
	 * <dd>メソッド名：今月の目標2設定メソッド
	 * <dd>メソッド説明：今月の目標2を設定します。
	 *
	 * @param contentsImpression2
	 *            今月の目標2
	 */
	public void setContentsImpression2(String contentsImpression2) {

		this.contentsImpression2 = contentsImpression2;

	}

	/**
	 * <dd>メソッド名：今月の目標3取得メソッド
	 * <dd>メソッド説明：今月の目標3を取得します。
	 *
	 * @return contentsImpression3 今月の目標3
	 */
	public String getContentsImpression3() {

		return contentsImpression3;

	}

	/**
	 * <dd>メソッド名：今月の目標3設定メソッド
	 * <dd>メソッド説明：今月の目標3を設定します。
	 *
	 * @param contentsImpression3
	 *            今月の目標3
	 */
	public void setContentsImpression3(String contentsImpression3) {

		this.contentsImpression3 = contentsImpression3;

	}

	/**
	 * <dd>メソッド名：今月の目標4取得メソッド
	 * <dd>メソッド説明：今月の目標4を取得します。
	 *
	 * @return contentsImpression4 今月の目標4
	 */
	public String getContentsImpression4() {

		return contentsImpression4;

	}

	/**
	 * <dd>メソッド名：今月の目標4設定メソッド
	 * <dd>メソッド説明：今月の目標4を設定します。
	 *
	 * @param contentsImpression4
	 *            今月の目標4
	 */
	public void setContentsImpression4(String contentsImpression4) {

		this.contentsImpression4 = contentsImpression4;

	}

	/**
	 * <dd>メソッド名：今月の目標5取得メソッド
	 * <dd>メソッド説明：今月の目標5を取得します。
	 *
	 * @return contentsImpression5 今月の目標5
	 */
	public String getContentsImpression5() {

		return contentsImpression5;

	}

	/**
	 * <dd>メソッド名：今月の目標5設定メソッド
	 * <dd>メソッド説明：今月の目標5を設定します。
	 *
	 * @param contentsImpression5
	 *            今月の目標5
	 */
	public void setContentsImpression5(String contentsImpression5) {

		this.contentsImpression5 = contentsImpression5;

	}

	/**
	 * <dd>メソッド名：今月の目標1取得メソッド
	 * <dd>メソッド説明：今月の目標1を取得します。
	 *
	 * @return monthGoal1 今月の目標1
	 */
	public String getMonthGoal1() {

		return monthGoal1;

	}

	/**
	 * <dd>メソッド名：今月の目標1設定メソッド
	 * <dd>メソッド説明：今月の目標1を設定します。
	 *
	 * @param monthGoal1
	 *            今月の目標1
	 */
	public void setMonthGoal1(String monthGoal1) {

		this.monthGoal1 = monthGoal1;

	}

	/**
	 * <dd>メソッド名：今月の目標2取得メソッド
	 * <dd>メソッド説明：今月の目標2を取得します。
	 *
	 * @return monthGoal2 今月の目標2
	 */
	public String getMonthGoal2() {

		return monthGoal2;

	}

	/**
	 * <dd>メソッド名：今月の目標2設定メソッド
	 * <dd>メソッド説明：今月の目標2を設定します。
	 *
	 * @param monthGoal2
	 *            今月の目標2
	 */
	public void setMonthGoal2(String monthGoal2) {

		this.monthGoal2 = monthGoal2;

	}

	/**
	 * <dd>メソッド名：今日の目標1取得メソッド
	 * <dd>メソッド説明：今日の目標1を取得します。
	 *
	 * @return todayGoal1 今日の目標1
	 */
	public String getTodayGoal1() {

		return todayGoal1;

	}

	/**
	 * <dd>メソッド名：今日の目標1設定メソッド
	 * <dd>メソッド説明：今日の目標1を設定します。
	 *
	 * @param todayGoal1
	 *            今日の目標1
	 */
	public void setTodayGoal1(String todayGoal1) {

		this.todayGoal1 = todayGoal1;

	}

	/**
	 * <dd>メソッド名：今日の目標2取得メソッド
	 * <dd>メソッド説明：今日の目標2を取得します。
	 *
	 * @return todayGoal2 今日の目標2
	 */
	public String getTodayGoal2() {

		return todayGoal2;

	}

	/**
	 * <dd>メソッド名：今日の目標2設定メソッド
	 * <dd>メソッド説明：今日の目標2を設定します。
	 *
	 * @param todayGoal2
	 *            今日の目標2
	 */
	public void setTodayGoal2(String todayGoal2) {

		this.todayGoal2 = todayGoal2;

	}

	/**
	 * <dd>メソッド名：今日の目標達成度取得メソッド
	 * <dd>メソッド説明：今日の目標達成度を取得します。
	 *
	 * @return todayGoalScore 今日の目標達成度
	 */
	public int getTodayGoalScore() {

		return todayGoalScore;

	}

	/**
	 * <dd>メソッド名：今日の目標達成度設定メソッド
	 * <dd>メソッド説明：今日の目標達成度を設定します。
	 *
	 * @param todayGoalScore
	 *            今日の目標達成度
	 */
	public void setTodayGoalScore(int todayGoalScore) {

		this.todayGoalScore = todayGoalScore;

	}

	/**
	 * <dd>メソッド名：満足だった点取得メソッド
	 * <dd>メソッド説明：満足だった点を取得します。
	 *
	 * @return todaySatisfaction 満足だった点
	 */
	public String getTodaySatisfaction() {

		return todaySatisfaction;

	}

	/**
	 * <dd>メソッド名：満足だった点設定メソッド
	 * <dd>メソッド説明：満足だった点を設定します。
	 *
	 * @param todaySatisfaction
	 *            満足だった点
	 */
	public void setTodaySatisfaction(String todaySatisfaction) {

		this.todaySatisfaction = todaySatisfaction;

	}

	/**
	 * <dd>メソッド名：不満足だった点取得メソッド
	 * <dd>メソッド説明：不満足だった点を取得します。
	 *
	 * @return today_dissatisfaction 不満足だった点
	 */
	public String getTodayDisSatisfaction() {

		return todayDisSatisfaction;

	}

	/**
	 * <dd>メソッド名：不満足だった点設定メソッド
	 * <dd>メソッド説明：不満足だった点を設定します。
	 *
	 * @param today_dissatisfaction
	 *            不満足だった点
	 */
	public void setTodayDisSatisfaction(String today_dissatisfaction) {

		this.todayDisSatisfaction = today_dissatisfaction;

	}

	/**
	 * <dd>メソッド名：本日の問題点取得メソッド
	 * <dd>メソッド説明：本日の問題点を取得します。
	 *
	 * @return todayProblem 本日の問題点
	 */
	public String getTodayProblem() {

		return todayProblem;

	}

	/**
	 * <dd>メソッド名：本日の問題点設定メソッド
	 * <dd>メソッド説明：本日の問題点を設定します。
	 *
	 * @param todayProblem
	 *            本日の問題点
	 */
	public void setTodayProblem(String todayProblem) {

		this.todayProblem = todayProblem;

	}

	/**
	 * <dd>メソッド名：本日の対策取得メソッド
	 * <dd>メソッド説明：本日の対策を取得します。
	 *
	 * @return todayMeasures 本日の対策
	 */
	public String getTodayMeasures() {

		return todayMeasures;

	}

	/**
	 * <dd>メソッド名：本日の対策設定メソッド
	 * <dd>メソッド説明：本日の対策を設定します。
	 *
	 * @param todayMeasures
	 *            本日の対策
	 */
	public void setTodayMeasures(String todayMeasures) {

		this.todayMeasures = todayMeasures;

	}

	/**
	 * <dd>メソッド名：明日(次週)の予定取得メソッド
	 * <dd>メソッド説明：明日(次週)の予定を取得します。
	 *
	 * @return nextPlan 明日(次週)の予定
	 */
	public String getNextPlan() {

		return nextPlan;

	}

	/**
	 * <dd>メソッド名：明日(次週)の予定設定メソッド
	 * <dd>メソッド説明：明日(次週)の予定を設定します。
	 *
	 * @param nextPlan
	 *            明日(次週)の予定
	 */
	public void setNextPlan(String nextPlan) {

		this.nextPlan = nextPlan;

	}

	/**
	 * <dd>メソッド名：全体の所感及び疑問点取得メソッド
	 * <dd>メソッド説明：全体の所感及び疑問点を取得します。
	 *
	 * @return allImpression 全体の所感及び疑問点
	 */
	public String getAllImpression() {

		return allImpression;

	}

	/**
	 * <dd>メソッド名：全体の所感及び疑問点設定メソッド
	 * <dd>メソッド説明：全体の所感及び疑問点を設定します。
	 *
	 * @param allImpression
	 *            全体の所感及び疑問点
	 */
	public void setAllImpression(String allImpression) {

		this.allImpression = allImpression;

	}

}
