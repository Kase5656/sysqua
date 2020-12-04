/*
 *ReportAction.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (レポート管理業務)
 *クラス一覧：
 * NO クラス名 概要
 * 1 ReportAction 各アクションへ誘導するクラスです。
 *履歴：
 * NO 日付 Ver 更新者 内容
 * 1 2016/06/01 V1L1.0 SQT）加瀬 初版。
 */

package jp.co.sqt.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.sqt.dao.CalenderDao;
import jp.co.sqt.dao.CommentDao;
import jp.co.sqt.dao.EducationDao;
import jp.co.sqt.dao.ReportDao;
import jp.co.sqt.dao.TestDao;
import jp.co.sqt.entity.Account;
import jp.co.sqt.entity.CalendarUnq;
import jp.co.sqt.entity.Comment;
import jp.co.sqt.entity.Education;
import jp.co.sqt.entity.Report;
import jp.co.sqt.entity.Test;

/**
 * <dd>クラス名：レポート検索情報受け渡しクラス
 * <dd>クラス説明：検索条件入力/検索一覧画面より受け取った検索条件をDaoへ受け渡します。 検索条件を正しい値かチェックします。
 *
 * @version 1.00 2016/06/01
 * @author SQT）加瀬
 */
public class ReportAction implements Action {

	/**
	 * <dd>メソッド名：レポート検索情報受け渡しメソッド
	 * <dd>メソッド説明：指定された検索条件を、Daoへ受け渡すメソッドです。 検索条件を正しい値かチェックします。
	 *
	 * @param request
	 *            リクエスト
	 * @param response
	 *            レスポンス
	 * @return servletPath 遷移する画面のサーブレットパス
	 * @throws UnsupportedEncodingException
	 */
	@Override
	public String doService(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {

		/** セッション */
		HttpSession session = request.getSession(false);

		/** サーブレットパス */
		String servletPath = request.getServletPath();

		session.removeAttribute("errorList");

		if (session == null || session.getAttribute("accountId") == null) {

			servletPath = "sessionLost.jsp";

		} else {

			if ("EducationDetailSearch_btn".equals(request.getParameter("action"))) {

				/** 社員情報 */
				Education education = (Education) session.getAttribute("education2");

				Account account = (Account) session.getAttribute("account");

				if (account.getAccountAuthority() == 0) {

					session.setAttribute("JspFlg", 0);

				} else if (account.getAccountAuthority() == 1) {

					session.setAttribute("JspFlg", 1);

				} else if (account.getAccountAuthority() == 2) {

					session.setAttribute("JspFlg", 2);

				}

				education.setAccountNo(education.getAccountNo());

				education.setEducationName(education.getEducationName());

				session.setAttribute("education", education);

				List<Test> testList = null;

				List<CalendarUnq> calenderList = null;

				Date date = new Date();

				String sdf1 = new SimpleDateFormat("yyyy/MM/dd").format(date);

				if (education.getEnterningDate().substring(5, 7).equals("04")) {

					testList = TestDao.checkTestDetail2(
							String.valueOf(session.getAttribute("year")),
							String.valueOf(session.getAttribute("startMonth4")),
							String.valueOf(session.getAttribute("endMonth4")), education.getAccountNo());

					calenderList = CalenderDao.search(
							String.valueOf(session.getAttribute("year")),
							String.valueOf(session.getAttribute("startMonth4")),
							String.valueOf(session.getAttribute("endMonth4")), "ASC");

					if (sdf1.equals(String.valueOf(session.getAttribute("questionLastDate")))) {

						session.setAttribute("questionFlg", 1);

					} else {

						session.setAttribute("questionFlg", 0);
					}

				} else {

					testList = TestDao.checkTestDetail2(
							String.valueOf(session.getAttribute("year")),
							String.valueOf(session.getAttribute("startMonth10")),
							String.valueOf(session.getAttribute("endMonth10")), education.getAccountNo());

					calenderList = CalenderDao.search(
							String.valueOf(session.getAttribute("year")),
							String.valueOf(session.getAttribute("startMonth10")),
							String.valueOf(session.getAttribute("endMonth10")), "ASC");

					if (sdf1.equals(String.valueOf(session.getAttribute("questionLastDate")))) {

						session.setAttribute("questionFlg", 1);

					} else {

						session.setAttribute("questionFlg", 0);
					}

				}

				List<Report> reportList = ReportDao.checkReportDetail2(education.getAccountNo());

				List<Comment> commentList = CommentDao.checkComment(education.getAccountNo());

				boolean flg = false;

				boolean chk = false;

				List<String> result = new ArrayList<String>();

				List<String> result2 = new ArrayList<String>();

				//			テスト一覧
				for (CalendarUnq cal : calenderList) {

					flg = false;

					chk = false;

					int diff = 0;

					if (education.getEnterningDate().substring(5, 7).equals("04")) {

						diff = cal.getCalenderOnDate()
								.compareTo(String.valueOf(session.getAttribute("testLastDate4")));

					} else {

						diff = cal.getCalenderOnDate()
								.compareTo(String.valueOf(session.getAttribute("testLastDate10")));

					}

					int diff2 = cal.getCalenderOnDate().compareTo(sdf1);

					if (diff > 0 || diff2 > 0) {

						chk = true;

					}

					if (!testList.isEmpty() && !chk) {

						for (Test test : testList) {

							if (cal.getCalenderOnDate()
									.equals(test.getTestDate().replaceAll("-", "/"))) {

								if (education.getEnterningDate().substring(5, 7).equals("04")) {

									if (cal.getCalenderOnDate()
											.equals(String.valueOf(session.getAttribute("testLastDate")))) {

										chk = true;

										break;

									}

								} else {

									if (cal.getCalenderOnDate()
											.equals(String.valueOf(session.getAttribute("testLastDate10")))) {

										chk = true;

										break;

									}

								}

								flg = true;

								result.add(String.valueOf(test.getTestScore()));

								break;

							}

						}

					}

					if (chk) {

						result.add("無");

					} else if (!flg) {

						result.add("未実施");

					}

				}

				//			日報一覧
				for (CalendarUnq cal : calenderList) {

					flg = false;

					for (Report report : reportList) {

						if (cal.getCalenderOnDate()
								.equals(report.getReportDate().replaceAll("-", "/"))) {

							flg = true;

							result2.add("実施済み");

							break;

						}

					}

					if (!flg) {

						result2.add("未実施");

					}

				}

				session.setAttribute("result", result);

				session.setAttribute("result2", result2);

				session.setAttribute("commentList", commentList);

				session.setAttribute("calenderList", calenderList);

				servletPath = "/detail.jsp";

			} else if ("ReportDetail_btn".equals(request.getParameter("action"))) {

				Account account = (Account) session.getAttribute("account");

				String date = request.getParameter("impdate");

				int accountNo = Integer.parseInt(request.getParameter("accountNo"));

				session.setAttribute("date", date);

				session.setAttribute("accountNo", accountNo);

				int reportNo = ReportDao.checkReportCnt(date.replaceAll("/", "-"), accountNo, 1);

				if (reportNo > 0 || (accountNo != account.getAccountNo())) {

					Report report = ReportDao.checkReportDetail(date.replaceAll("/", "-"), accountNo, 1);

					session.setAttribute("report", report);

					List<Comment> comment = CommentDao.checkCommentDetail(report.getReportNo());

					session.setAttribute("comment", comment);

					servletPath = "/inf_report/Check.jsp";

				} else {

					Report report = new Report();

					Report report2 = new Report();

					switch (date.substring(5, 7)) {

					case "04":

						report2 = ReportDao.checkReportDetail(String.valueOf(session.getAttribute("monthGoalDate4")),
								accountNo, 1);

						break;

					case "05":

						report2 = ReportDao.checkReportDetail(String.valueOf(session.getAttribute("monthGoalDate5")),
								accountNo, 1);

						break;

					case "06":

						report2 = ReportDao.checkReportDetail(String.valueOf(session.getAttribute("monthGoalDate6")),
								accountNo, 1);

						break;

					}

					if (report2.getMonthGoal1() != null) {

						report.setMonthGoal1(Check.change2(report2.getMonthGoal1()));

					}

					if (report2.getMonthGoal2() != null) {

						report.setMonthGoal2(Check.change2(report2.getMonthGoal2()));

					}
					session.setAttribute("report", report);

					servletPath = "/inf_report/registerInput.jsp";

				}

			} else if ("CheckReportDetail_btn".equals(request.getParameter("action"))) {

				String date = (String) session.getAttribute("date");

				int accountNo = (Integer) session.getAttribute("accountNo");

				session.setAttribute("date", date);

				session.setAttribute("accountNo", accountNo);

				Report report = ReportDao.checkReportDetail(date.replaceAll("/", "-"), accountNo, 1);

				session.setAttribute("report", report);

				session.setAttribute("commentList", CommentDao.checkCommentDetail(report.getReportNo()));

				servletPath = "/inf_report/Check.jsp";

			} else if ("ReportRegisterInput_btn".equals(request.getParameter("action"))) {

				servletPath = "/inf_report/registerInput.jsp";

			} else if ("ReportRegisterCheck_btn".equals(request.getParameter("action"))) {

				/** レポート情報 */
				Report report = new Report();

				/** レポートNo */
				report.setReportNo(ReportDao.getLastNo() + 1);

				/** アカウントNo */
				report.setAccountNo(Integer.parseInt((String.valueOf(session.getAttribute("accountNo")))));

				Education education = EducationDao
						.search2(Integer.parseInt((String.valueOf(session.getAttribute("accountNo")))));

				session.setAttribute("education", education);

				Date date = new Date();

				String sdf1 = new SimpleDateFormat("yyyy-MM-dd").format(date);

				String sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);

				report.setReportDate(sdf1);

				report.setReportDateTime(sdf2);

				/** レポート作成日時 */
/*				if (session.getAttribute("actionFlg").equals("0")) {

				} else {

					report.setReportDate(String.valueOf(session.getAttribute("testUnqDate")));

					report.setReportDateTime(String.valueOf(session.getAttribute("testUnqDateTime")));

				}
*/
				/** 研修項目1 */
				report.setContentsItem1(Check.change(request.getParameter("item_txt1")));

				/** 実施時間(開始)1 */
				report.setContentsStartTime1(request.getParameter("starttime_txt1"));

				/** 実施時間(終了)1 */
				report.setContentsEndTime1(request.getParameter("endtime_txt1"));

				/** 進捗度1 */
				report.setContentsProgress1(Integer.parseInt(request.getParameter("progress_cmb1")));

				/** 理解度1 */
				report.setContentsUnderStanding1(request.getParameter("understanding_cmb1"));

				/** 所感1 */
				report.setContentsImpression1(Check.change(request.getParameter("impression_txt1")));

				/** 研修項目2 */
				report.setContentsItem2(Check.change(request.getParameter("item_txt2")));

				/** 実施時間(開始)2 */
				report.setContentsStartTime2(request.getParameter("starttime_txt2"));

				/** 実施時間(終了)2 */
				report.setContentsEndTime2(request.getParameter("endtime_txt2"));

				/** 進捗度2 */
				report.setContentsProgress2(Integer.parseInt(request.getParameter("progress_cmb2")));

				/** 理解度2 */
				report.setContentsUnderStanding2(request.getParameter("understanding_cmb2"));

				/** 所感2 */
				report.setContentsImpression2(Check.change(request.getParameter("impression_txt2")));

				/** 研修項目3 */
				report.setContentsItem3(Check.change(request.getParameter("item_txt3")));

				/** 実施時間(開始)3 */
				report.setContentsStartTime3(request.getParameter("starttime_txt3"));

				/** 実施時間(終了)3 */
				report.setContentsEndTime3(request.getParameter("endtime_txt3"));

				/** 進捗度3 */
				report.setContentsProgress3(Integer.parseInt(request.getParameter("progress_cmb3")));

				/** 理解度3 */
				report.setContentsUnderStanding3(request.getParameter("understanding_cmb3"));

				/** 所感3 */
				report.setContentsImpression3(Check.change(request.getParameter("impression_txt3")));

				/** 研修項目4 */
				report.setContentsItem4(Check.change(request.getParameter("item_txt4")));

				/** 実施時間(開始)4 */
				report.setContentsStartTime4(request.getParameter("starttime_txt4"));

				/** 実施時間(終了)4 */
				report.setContentsEndTime4(request.getParameter("endtime_txt4"));

				/** 進捗度4 */
				report.setContentsProgress4(Integer.parseInt(request.getParameter("progress_cmb4")));

				/** 理解度4 */
				report.setContentsUnderStanding4(request.getParameter("understanding_cmb4"));

				/** 所感4 */
				report.setContentsImpression4(Check.change(request.getParameter("impression_txt4")));

				/** 研修項目5 */
				report.setContentsItem5(Check.change(request.getParameter("item_txt5")));

				/** 実施時間(開始)5 */
				report.setContentsStartTime5(request.getParameter("starttime_txt5"));

				/** 実施時間(終了)5 */
				report.setContentsEndTime5(request.getParameter("endtime_txt5"));

				/** 進捗度5 */
				report.setContentsProgress5(Integer.parseInt(request.getParameter("progress_cmb5")));

				/** 理解度5 */
				report.setContentsUnderStanding5(request.getParameter("understanding_cmb5"));

				/** 所感5 */
				report.setContentsImpression5(Check.change(request.getParameter("impression_txt5")));

				/** 今月の目標1 */
				report.setMonthGoal1(Check.change(request.getParameter("monthgoal_txt1")));

				/** 今月の目標2 */
				report.setMonthGoal2(Check.change(request.getParameter("monthgoal_txt2")));

				/** 今日の目標1 */
				report.setTodayGoal1(Check.change(request.getParameter("todaygoal_txt1")));

				/** 今日の目標2 */
				report.setTodayGoal2(Check.change(request.getParameter("todaygoal_txt2")));

				/** 今日の目標達成度 */
				report.setTodayGoalScore(Integer.parseInt(request.getParameter("todaygoalscore_cmb")));

				/** 満足だった点 */
				report.setTodaySatisfaction(Check.change(request.getParameter("todaysatisfaction_txt")));

				/** 不満を残した点 */
				report.setTodayDisSatisfaction(Check.change(request.getParameter("todaydissatisfaction_txt")));

				/** 本日の問題点 */
				report.setTodayProblem(Check.change(request.getParameter("todayproblem_txt")));

				/** 対策 */
				report.setTodayMeasures(Check.change(request.getParameter("todaymeasures_txt")));

				/** 明日(次週)の予定 */
				report.setNextPlan(Check.change(request.getParameter("nextplan_txt")));

				/** 全体の所感・疑問点等 */
				report.setAllImpression(Check.change(request.getParameter("allimpression_txt")));

				/** 登録判定 */
				List<String> errorList = Check.checkRegisterReport(report);

				if (errorList.size() > 0) {

					request.setAttribute("errorList", errorList);

					servletPath = "/inf_report/registerInput.jsp";

				} else {

					session.setAttribute("report", report);

					servletPath = "/inf_report/registerCheck.jsp";

				}

			} else if ("ReportRegisterComplete_btn".equals(request.getParameter("action"))) {

				Report report = (Report) session.getAttribute("report");

				report.setReportDate(String.valueOf(session.getAttribute("date")));

				ReportDao.insert(report);

				servletPath = "/inf_report/registerComplete.jsp";

			} else if ("ReportUpdateInput_btn".equals(request.getParameter("action"))) {

				/** レポート情報 */
				Report report = (Report) session.getAttribute("report");

				report.setContentsItem1(Check.change2(report.getContentsItem1()));

				report.setContentsItem2(Check.change2(report.getContentsItem2()));

				report.setContentsItem3(Check.change2(report.getContentsItem3()));

				report.setContentsItem4(Check.change2(report.getContentsItem4()));

				report.setContentsItem5(Check.change2(report.getContentsItem5()));

				report.setContentsImpression1(Check.change2(report.getContentsImpression1()));

				report.setContentsImpression2(Check.change2(report.getContentsImpression2()));

				report.setContentsImpression3(Check.change2(report.getContentsImpression3()));

				report.setContentsImpression4(Check.change2(report.getContentsImpression4()));

				report.setContentsImpression5(Check.change2(report.getContentsImpression5()));

				report.setMonthGoal1(Check.change2(report.getMonthGoal1()));

				report.setMonthGoal2(Check.change2(report.getMonthGoal2()));

				report.setTodayGoal1(Check.change2(report.getTodayGoal1()));

				report.setTodayGoal2(Check.change2(report.getTodayGoal2()));

				report.setTodaySatisfaction(Check.change2(report.getTodaySatisfaction()));

				report.setTodayDisSatisfaction(Check.change2(report.getTodayDisSatisfaction()));

				report.setTodayProblem(Check.change2(report.getTodayProblem()));

				report.setTodayMeasures(Check.change2(report.getTodayMeasures()));

				report.setNextPlan(Check.change2(report.getNextPlan()));

				report.setAllImpression(Check.change2(report.getAllImpression()));

				servletPath = "/inf_report/updateInput.jsp";

			} else if ("ReportUpdateCheck_btn".equals(request.getParameter("action"))) {

				/** レポート情報 */
				Report report = (Report) session.getAttribute("report");

				/** アカウントNo */
				report.setAccountNo(Integer.parseInt((String.valueOf(session.getAttribute("accountNo")))));

				report.setReportDate(String.valueOf(session.getAttribute("date")));

				Date date = new Date();

				String sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);

				report.setReportLastDateTime(sdf1);

				/** レポート日時 */
/*				if (session.getAttribute("actionFlg").equals("0")) {

				} else {

					report.setReportLastDateTime(String.valueOf(session.getAttribute("testUnqDateTime")));

				}
*/
				/** 研修項目1 */
				report.setContentsItem1(Check.change(request.getParameter("item_txt1")));

				/** 実施時間(開始)1 */
				report.setContentsStartTime1(request.getParameter("starttime_txt1"));

				/** 実施時間(終了)1 */
				report.setContentsEndTime1(request.getParameter("endtime_txt1"));

				/** 進捗度1 */
				report.setContentsProgress1(Integer.parseInt(request.getParameter("progress_cmb1")));

				/** 理解度1 */
				report.setContentsUnderStanding1(request.getParameter("understanding_cmb1"));

				/** 所感1 */
				report.setContentsImpression1(Check.change(request.getParameter("impression_txt1")));

				/** 研修項目2 */
				report.setContentsItem2(Check.change(request.getParameter("item_txt2")));

				/** 実施時間(開始)2 */
				report.setContentsStartTime2(request.getParameter("starttime_txt2"));

				/** 実施時間(終了)2 */
				report.setContentsEndTime2(request.getParameter("endtime_txt2"));

				/** 進捗度2 */
				report.setContentsProgress2(Integer.parseInt(request.getParameter("progress_cmb2")));

				/** 理解度2 */
				report.setContentsUnderStanding2(request.getParameter("understanding_cmb2"));

				/** 所感2 */
				report.setContentsImpression2(Check.change(request.getParameter("impression_txt2")));

				/** 研修項目3 */
				report.setContentsItem3(Check.change(request.getParameter("item_txt3")));

				/** 実施時間(開始)3 */
				report.setContentsStartTime3(request.getParameter("starttime_txt3"));

				/** 実施時間(終了)3 */
				report.setContentsEndTime3(request.getParameter("endtime_txt3"));

				/** 進捗度3 */
				report.setContentsProgress3(Integer.parseInt(request.getParameter("progress_cmb3")));

				/** 理解度3 */
				report.setContentsUnderStanding3(request.getParameter("understanding_cmb3"));

				/** 所感3 */
				report.setContentsImpression3(Check.change(request.getParameter("impression_txt3")));

				/** 研修項目4 */
				report.setContentsItem4(Check.change(request.getParameter("item_txt4")));

				/** 実施時間(開始)4 */
				report.setContentsStartTime4(request.getParameter("starttime_txt4"));

				/** 実施時間(終了)4 */
				report.setContentsEndTime4(request.getParameter("endtime_txt4"));

				/** 進捗度4 */
				report.setContentsProgress4(Integer.parseInt(request.getParameter("progress_cmb4")));

				/** 理解度4 */
				report.setContentsUnderStanding4(request.getParameter("understanding_cmb4"));

				/** 所感4 */
				report.setContentsImpression4(Check.change(request.getParameter("impression_txt4")));

				/** 研修項目5 */
				report.setContentsItem5(Check.change(request.getParameter("item_txt5")));

				/** 実施時間(開始)5 */
				report.setContentsStartTime5(request.getParameter("starttime_txt5"));

				/** 実施時間(終了)5 */
				report.setContentsEndTime5(request.getParameter("endtime_txt5"));

				/** 進捗度5 */
				report.setContentsProgress5(Integer.parseInt(request.getParameter("progress_cmb5")));

				/** 理解度5 */
				report.setContentsUnderStanding5(request.getParameter("understanding_cmb5"));

				/** 所感5 */
				report.setContentsImpression5(Check.change(request.getParameter("impression_txt5")));

				/** 今月の目標1 */
				report.setMonthGoal1(Check.change(request.getParameter("monthgoal_txt1")));

				/** 今月の目標2 */
				report.setMonthGoal2(Check.change(request.getParameter("monthgoal_txt2")));

				/** 今日の目標1 */
				report.setTodayGoal1(Check.change(request.getParameter("todaygoal_txt1")));

				/** 今日の目標2 */
				report.setTodayGoal2(Check.change(request.getParameter("todaygoal_txt2")));

				/** 今日の目標達成度 */
				report.setTodayGoalScore(Integer.parseInt(request.getParameter("todaygoalscore_cmb")));

				/** 満足だった点 */
				report.setTodaySatisfaction(Check.change(request.getParameter("todaysatisfaction_txt")));

				/** 不満を残した点 */
				report.setTodayDisSatisfaction(Check.change(request.getParameter("todaydissatisfaction_txt")));

				/** 本日の問題点 */
				report.setTodayProblem(Check.change(request.getParameter("todayproblem_txt")));

				/** 対策 */
				report.setTodayMeasures(Check.change(request.getParameter("todaymeasures_txt")));

				/** 明日(次週)の予定 */
				report.setNextPlan(Check.change(request.getParameter("nextplan_txt")));

				/** 全体の所感・疑問点等 */
				report.setAllImpression(Check.change(request.getParameter("allimpression_txt")));

				/** 登録判定 */
				List<String> errorList = Check.checkRegisterReport(report);

				if (errorList.size() > 0) {

					request.setAttribute("errorList", errorList);

					servletPath = "/inf_report/updateInput.jsp";

				} else {

					session.setAttribute("report", report);

					servletPath = "/inf_report/updateCheck.jsp";

				}

			} else if ("ReportUpdateComplete_btn".equals(request.getParameter("action"))) {

				Report report = (Report) session.getAttribute("report");

				Date date = new Date();

				String sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);

				report.setReportLastDateTime(sdf1);

				/** レポート日時 */
/*				if (session.getAttribute("actionFlg").equals("0")) {

				} else {

					report.setReportLastDateTime(String.valueOf(session.getAttribute("testUnqDateTime")));

				}
*/
				ReportDao.update(report);

				servletPath = "/inf_report/updateComplete.jsp";

			} else if ("CommnetRegisterSend_btn".equals(request.getParameter("action"))) {

				String inputText = request.getParameter("comment_txt");

				/** コメント情報 */
				Comment comment = new Comment();

				/** 登録判定 */
				List<String> errorList = Check.checkComment(inputText);

				if (errorList.size() > 0) {

					request.setAttribute("errorList", errorList);

				} else {

					//なんで更新するとコメントが増えるのか←一旦更新をしない程で進める
					Account account = (Account) session.getAttribute("account");

					Date date1 = new Date();

					String sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date1);

					int accountNo = (int) session.getAttribute("accountNo");

					/** コメントNo */
					comment.setCommentNo(CommentDao.getLastNo() + 1);

					comment.setReportNo(Integer.parseInt(request.getParameter("reportNo")));

					comment.setToAccountNo(accountNo);

					comment.setFromAccountNo(account.getAccountNo());

					comment.setCommentDate(sdf);

					comment.setComment(Check.change(inputText));

					if (CommentDao.reSearch(comment) == 0) {

						CommentDao.insert(comment);

					}

					String date = (String) session.getAttribute("date");

					session.setAttribute("date", date);

					session.setAttribute("accountNo", accountNo);

					session.setAttribute("report",
							ReportDao.checkReportDetail(date.replaceAll("/", "-"), accountNo, 1));

					session.setAttribute("commentList",
							CommentDao.checkCommentDetail(Integer.parseInt(request.getParameter("reportNo"))));

				}

				servletPath = "/inf_report/Check.jsp";

			} else if ("CommnetDeleteSend_btn".equals(request.getParameter("action"))) {

				Integer commnetNo = Integer.parseInt(request.getParameter("commentNo"));

				CommentDao.delete(commnetNo);

				String date = (String) session.getAttribute("date");

				int accountNo = (int) session.getAttribute("accountNo");

				session.setAttribute("date", date);

				session.setAttribute("accountNo", accountNo);

				session.setAttribute("report", ReportDao.checkReportDetail(date.replaceAll("/", "-"), accountNo, 1));

				session.setAttribute("commentList",
						CommentDao.checkCommentDetail(Integer.parseInt(request.getParameter("reportNo"))));

				servletPath = "/inf_report/Check.jsp";

			}

		}

		return servletPath;

	}

}
