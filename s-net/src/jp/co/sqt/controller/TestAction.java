/*
 *TestAction.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (テスト管理業務)
 *クラス一覧：
 * NO クラス名 概要
 * 1 TestAction 各アクションへ誘導するクラスです。
 *履歴：
 * NO 日付 Ver 更新者 内容
 * 1 2016/06/01 V1L1.0 SQT）加瀬 初版。
 */

package jp.co.sqt.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.sqt.dao.CalenderDao;
import jp.co.sqt.dao.CommentDao;
import jp.co.sqt.dao.ReportDao;
import jp.co.sqt.dao.TestDao;
import jp.co.sqt.entity.Account;
import jp.co.sqt.entity.CalendarUnq;
import jp.co.sqt.entity.Comment;
import jp.co.sqt.entity.Education;
import jp.co.sqt.entity.Report;
import jp.co.sqt.entity.Test;
import jp.co.sqt.entity.Test_Contents;

/**
 * <dd>クラス名：テスト検索情報受け渡しクラス
 * <dd>クラス説明：検索条件入力/検索一覧画面より受け取った検索条件をDaoへ受け渡します。 検索条件を正しい値かチェックします。
 *
 * @version 1.00 2016/06/01
 * @author SQT）加瀬
 */
public class TestAction implements Action {

	/**
	 * <dd>メソッド名：テスト検索情報受け渡しメソッド
	 * <dd>メソッド説明：指定された検索条件を、Daoへ受け渡すメソッドです。 検索条件を正しい値かチェックします。
	 *
	 * @param request
	 *            リクエスト
	 * @param response
	 *            レスポンス
	 * @return servletPath 遷移する画面のサーブレットパス
	 */
	@Override
	public String doService(HttpServletRequest request, HttpServletResponse response) {

		/** セッション */
		HttpSession session = request.getSession(false);

		/** サーブレットパス */
		String servletPath = request.getServletPath();

		if (session == null || session.getAttribute("accountId") == null) {

			servletPath = "sessionLost.jsp";

		} else {

			if ("TestDetail_btn".equals(request.getParameter("action"))) {

				Boolean a = (Boolean) session.getAttribute("attendanceflg");

				Account account = (Account) session.getAttribute("account");

				String date = request.getParameter("impdate").replace("/", "-");

				session.setAttribute("date", date);

				int accountNo = Integer.parseInt(request.getParameter("accountNo"));

				int testchk = TestDao.checkTestCnt(0, date, accountNo, 1);

				session.setAttribute("accountNo", accountNo);

				if (testchk > 0 || (accountNo != account.getAccountNo())) {

					session.setAttribute("testList", TestDao.checkTestDetail(date, accountNo, 1));

					servletPath = "/inf_test/registerComplete.jsp";

				} else {

					List<String> errorList = Check.checkTestSelect(TestDao.findTestCnt(date));

					if (errorList.size() > 0) {

						request.setAttribute("errorList", errorList);

						servletPath = "/detail.jsp";

					} else {

						/** テスト情報リスト */
						session.setAttribute("TestContentsList", TestDao.findTest(date));

						servletPath = "/inf_test/registerInput.jsp";

					}

				}

			} else if ("TestContents_btn".equals(request.getParameter("action"))) {

				/** テスト解答年月日 時分秒 */
				Date date = new Date();

				String sdf1 = "";

				sdf1 = new SimpleDateFormat("yyyy-MM-dd").format(date);

				/** テスト日時 */
				/*				if (session.getAttribute("actionFlg").equals("0")) {

								} else {

									sdf1 = String.valueOf(session.getAttribute("testUnqDate"));

								}
				*/
				/** テスト情報リスト */
				List<Test_Contents> TestContentsList = TestDao.findTest(sdf1);

				session.setAttribute("TestContentsList", TestContentsList);

				servletPath = "/inf_test/registerInput.jsp";

			} else if ("TestRegister_btn".equals(request.getParameter("action"))) {

				/** テスト情報 */
				Test test = new Test();

				int accountNo = Integer.parseInt(String.valueOf(session.getAttribute(("accountNo"))));

				int testNo = Integer.parseInt(request.getParameter("testNo"));

				/** No */
				test.setNo(TestDao.getLastNo() + 1);

				/** アカウントNo */
				test.setAccountNo(accountNo);

				/** 問題No */
				test.setTestNo(testNo);

				/** 回数 */
				test.setTestCount(
						TestDao.checkTestCnt(testNo, "", accountNo, 0) + 1);

				/** 解答1～5 */
				test.setTestAnswer1(
						Arrays.toString(request.getParameterValues("test1")).replace(" ", "").replace(",", "")
								.replace("[", "").replace("]", ""));

				test.setTestAnswer2(
						Arrays.toString(request.getParameterValues("test2")).replace(" ", "").replace(",", "")
								.replace("[", "").replace("]", ""));

				test.setTestAnswer3(
						Arrays.toString(request.getParameterValues("test3")).replace(" ", "").replace(",", "")
								.replace("[", "").replace("]", ""));

				test.setTestAnswer4(
						Arrays.toString(request.getParameterValues("test4")).replace(" ", "").replace(",", "")
								.replace("[", "").replace("]", ""));

				test.setTestAnswer5(
						Arrays.toString(request.getParameterValues("test5")).replace(" ", "").replace(",", "")
								.replace("[", "").replace("]", ""));

				String[] test1 = new String[] { Arrays.toString(request.getParameterValues("test1")),
						Arrays.toString(request.getParameterValues("test2")),
						Arrays.toString(request.getParameterValues("test3")),
						Arrays.toString(request.getParameterValues("test4")),
						Arrays.toString(request.getParameterValues("test5")) };

				/** 登録判定 */
				List<String> errorList = Check.checkRegisterTest(test1);

				if (errorList.size() > 0) {

					request.setAttribute("errorList", errorList);

					servletPath = "/inf_test/registerInput.jsp";

				} else {

					List<String> answer = TestDao.findTestAns(testNo);

					int i = 0;

					int score = 0;

					boolean flg = false;

					for (String s : answer) {

						if ((test1[i].replace(" ", "").replace("[", "").replace("]", "")).equals(s)) {

							errorList.add("第" + (i + 1) + "問：正解");

							score = score + 20;

						} else {

							errorList.add("第" + (i + 1) + "問：不正解");

							flg = true;

						}

						i = i + 1;

					}

					/** 点数 */
					test.setTestScore(score);

					/** テスト解答年月日 時分秒 */
					Date date = new Date();

					String sdf1 = "";

					sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);

					/** テスト日時 */
					/*					if (session.getAttribute("actionFlg").equals("0")) {

										} else {

											sdf1 = String.valueOf(session.getAttribute("testUnqDateTime"));

										}
					*/
					test.setTestDate(String.valueOf(session.getAttribute("date")));

					test.setTestDateTime(sdf1);

					TestDao.insert(test);

					session.setAttribute("testDate", sdf1);

					String date2 = sdf1.substring(0, 10).replaceAll("/", "-");

					session.setAttribute("date", date2);

					if (flg) {

						request.setAttribute("errorList", errorList);

					}

					servletPath = "/inf_test/registerCheck.jsp";

				}

			} else if ("EducationDetailSearch_btn".equals(request.getParameter("action"))) {

				/** 社員情報 */
				Education education = (Education) session.getAttribute("education");

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
											.equals(String.valueOf(session.getAttribute("testLastDate4")))) {

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

			}

		}

		return servletPath;

	}

}
