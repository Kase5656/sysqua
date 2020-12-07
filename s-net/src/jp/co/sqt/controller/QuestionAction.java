/*
 *QuestionAction.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (アンケート管理業務)
 *クラス一覧：
 * NO クラス名 概要
 * 1 QuestionAction 各アクションへ誘導するクラスです。
 *履歴：
 * NO 日付 Ver 更新者 内容
 * 1 2019/08/24 V1L1.0 SQT）長谷川
 */

package jp.co.sqt.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.sqt.dao.CalenderDao;
import jp.co.sqt.dao.CommentDao;
import jp.co.sqt.dao.QuestionDao;
import jp.co.sqt.dao.ReportDao;
import jp.co.sqt.dao.TestDao;
import jp.co.sqt.entity.Account;
import jp.co.sqt.entity.CalendarUnq;
import jp.co.sqt.entity.Comment;
import jp.co.sqt.entity.Education;
import jp.co.sqt.entity.Question;
import jp.co.sqt.entity.Report;
import jp.co.sqt.entity.Test;

/**
 * <dd>クラス名：
 * <dd>クラス説明：
 *
 * @version 1.00 2019/08/24
 * @author SQT）長谷川
 */
public class QuestionAction implements Action {

	/**
	 * <dd>メソッド名：
	 * <dd>メソッド説明：
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

			if ("Question_btn".equals(request.getParameter("action"))) {

				servletPath = "/inf_question/question.jsp";

			} else if ("Answer_btn".equals(request.getParameter("action"))) {

				// インスタンス生成

				Question question = new Question();

				// setデータ作成

				int questionNo = (QuestionDao.getLastNo() + 1);

				// Daoのセット

				/** No */
				question.setNo(questionNo);

				/** アカウントNo */
				Account account = (Account) session.getAttribute("account");

				question.setAccountNo(account.getAccountNo());

				/** 回答日付 */
				Date date = new Date();

				String sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);

				question.setDate(sdf1);

				/** 回答 */
				if (request.getParameter("a1_1_1") == null) {

					question.setAns1_1_1(0);

				} else {

					question.setAns1_1_1(Integer.parseInt(request.getParameter("a1_1_1")));

				}

				question.setAns1_1_2(request.getParameter("a1_1_2"));

				if (request.getParameter("a1_2_1") == null) {

					question.setAns1_2_1(0);

				} else {

					question.setAns1_2_1(Integer.parseInt(request.getParameter("a1_2_1")));

				}

				question.setAns1_2_2(request.getParameter("a1_2_2"));

				if (request.getParameter("a1_3_1") == null) {

					question.setAns1_3_1(0);

				} else {

					question.setAns1_3_1(Integer.parseInt(request.getParameter("a1_3_1")));

				}

				if ("".equals(request.getParameter("a1_3_2"))) {

					question.setAns1_3_2(0);

				} else {

					question.setAns1_3_2(Integer.parseInt(request.getParameter("a1_3_2")));

				}

				if (request.getParameter("a2_1_1") == null) {

					question.setAns2_1_1(0);

				} else {

					question.setAns2_1_1(Integer.parseInt(request.getParameter("a2_1_1")));

				}

				if (request.getParameter("a2_1_2") == null) {

					question.setAns2_1_2(0);

				} else {

					question.setAns2_1_2(Integer.parseInt(request.getParameter("a2_1_2")));

				}

				if (request.getParameter("a2_1_3") == null) {

					question.setAns2_1_3(0);

				} else {

					question.setAns2_1_3(Integer.parseInt(request.getParameter("a2_1_3")));

				}

				if (request.getParameter("a2_1_4") == null) {

					question.setAns2_1_4(0);

				} else {

					question.setAns2_1_4(Integer.parseInt(request.getParameter("a2_1_4")));

				}

				if ("".equals(request.getParameter("a2_1_5"))) {

					question.setAns2_1_5(0);

				} else {

					question.setAns2_1_5(Integer.parseInt(request.getParameter("a2_1_5")));

				}

				question.setAns2_1_6(request.getParameter("a2_1_6"));

				if (request.getParameter("a2_2_1") == null) {

					question.setAns2_2_1(0);

				} else {

					question.setAns2_2_1(Integer.parseInt(request.getParameter("a2_2_1")));

				}

				if (request.getParameter("a2_2_2") == null) {

					question.setAns2_2_2(0);

				} else {

					question.setAns2_2_2(Integer.parseInt(request.getParameter("a2_2_2")));

				}

				if (request.getParameter("a2_2_3") == null) {

					question.setAns2_2_3(0);

				} else {

					question.setAns2_2_3(Integer.parseInt(request.getParameter("a2_2_3")));

				}

				if (request.getParameter("a2_2_4") == null) {

					question.setAns2_2_4(0);

				} else {

					question.setAns2_2_4(Integer.parseInt(request.getParameter("a2_2_4")));

				}

				if ("".equals(request.getParameter("a2_2_5"))) {

					question.setAns2_2_5(0);

				} else {

					question.setAns2_2_5(Integer.parseInt(request.getParameter("a2_2_5")));

				}

				question.setAns2_2_6(request.getParameter("a2_2_6"));

				if (request.getParameter("a2_3_1") == null) {

					question.setAns2_3_1(0);

				} else {

					question.setAns2_3_1(Integer.parseInt(request.getParameter("a2_3_1")));

				}

				if (request.getParameter("a2_3_2") == null) {

					question.setAns2_3_2(0);

				} else {

					question.setAns2_3_2(Integer.parseInt(request.getParameter("a2_3_2")));

				}

				if (request.getParameter("a2_3_3") == null) {

					question.setAns2_3_3(0);

				} else {

					question.setAns2_3_3(Integer.parseInt(request.getParameter("a2_3_3")));

				}

				if (request.getParameter("a2_3_4") == null) {

					question.setAns2_3_4(0);

				} else {

					question.setAns2_3_4(Integer.parseInt(request.getParameter("a2_3_4")));

				}

				if ("".equals(request.getParameter("a2_3_5"))) {

					question.setAns2_3_5(0);

				} else {

					question.setAns2_3_5(Integer.parseInt(request.getParameter("a2_3_5")));

				}

				question.setAns2_3_6(request.getParameter("a2_3_6"));

				if (request.getParameter("a2_4_1") == null) {

					question.setAns2_4_1(0);

				} else {

					question.setAns2_4_1(Integer.parseInt(request.getParameter("a2_4_1")));

				}

				if (request.getParameter("a2_4_2") == null) {

					question.setAns2_4_2(0);

				} else {

					question.setAns2_4_2(Integer.parseInt(request.getParameter("a2_4_2")));

				}

				if (request.getParameter("a2_4_3") == null) {

					question.setAns2_4_3(0);

				} else {

					question.setAns2_4_3(Integer.parseInt(request.getParameter("a2_4_3")));

				}

				if (request.getParameter("a2_4_4") == null) {

					question.setAns2_4_4(0);

				} else {

					question.setAns2_4_4(Integer.parseInt(request.getParameter("a2_4_4")));

				}

				if ("".equals(request.getParameter("a2_4_5"))) {

					question.setAns2_4_5(0);

				} else {

					question.setAns2_4_5(Integer.parseInt(request.getParameter("a2_4_5")));

				}

				question.setAns2_4_6(request.getParameter("a2_4_6"));

				if (request.getParameter("a2_5_1") == null) {

					question.setAns2_5_1(0);

				} else {

					question.setAns2_5_1(Integer.parseInt(request.getParameter("a2_5_1")));

				}

				if (request.getParameter("a2_5_2") == null) {

					question.setAns2_5_2(0);

				} else {

					question.setAns2_5_2(Integer.parseInt(request.getParameter("a2_5_2")));

				}

				if (request.getParameter("a2_5_3") == null) {

					question.setAns2_5_3(0);

				} else {

					question.setAns2_5_3(Integer.parseInt(request.getParameter("a2_5_3")));

				}

				if (request.getParameter("a2_5_4") == null) {

					question.setAns2_5_4(0);

				} else {

					question.setAns2_5_4(Integer.parseInt(request.getParameter("a2_5_4")));

				}

				if ("".equals(request.getParameter("a2_5_5"))) {

					question.setAns2_5_5(0);

				} else {

					question.setAns2_5_5(Integer.parseInt(request.getParameter("a2_5_5")));

				}

				question.setAns2_5_6(request.getParameter("a2_5_6"));

				if (request.getParameter("a2_6_1") == null) {

					question.setAns2_6_1(0);

				} else {

					question.setAns2_6_1(Integer.parseInt(request.getParameter("a2_6_1")));

				}

				if (request.getParameter("a2_6_2") == null) {

					question.setAns2_6_2(0);

				} else {

					question.setAns2_6_2(Integer.parseInt(request.getParameter("a2_6_2")));

				}

				if (request.getParameter("a2_6_3") == null) {

					question.setAns2_6_3(0);

				} else {

					question.setAns2_6_3(Integer.parseInt(request.getParameter("a2_6_3")));

				}

				if (request.getParameter("a2_6_4") == null) {

					question.setAns2_6_4(0);

				} else {

					question.setAns2_6_4(Integer.parseInt(request.getParameter("a2_6_4")));

				}

				if ("".equals(request.getParameter("a2_6_5"))) {

					question.setAns2_6_5(0);

				} else {

					question.setAns2_6_5(Integer.parseInt(request.getParameter("a2_6_5")));

				}

				question.setAns2_6_6(request.getParameter("a2_6_6"));

				question.setAns3_1(request.getParameter("a3_1"));

				question.setAns3_2(request.getParameter("a3_2"));

				session.setAttribute("question", question);

				Map<String, Integer> map1 = new LinkedHashMap<String, Integer>();

				/** 必須項目未入力エラー処理用 */
				map1.put("1.(1)", question.getAns1_1_1());

				map1.put("1.(2)", question.getAns1_2_1());

				map1.put("1.(3)", question.getAns1_3_1());

				map1.put("2.(1)①", question.getAns2_1_1());

				map1.put("2.(1)②", question.getAns2_1_2());

				map1.put("2.(1)③", question.getAns2_1_3());

				map1.put("2.(1)④", question.getAns2_1_4());

				map1.put("2.(2)①", question.getAns2_2_1());

				map1.put("2.(2)②", question.getAns2_2_2());

				map1.put("2.(2)③", question.getAns2_2_3());

				map1.put("2.(2)④", question.getAns2_2_4());

				map1.put("2.(3)①", question.getAns2_3_1());

				map1.put("2.(3)②", question.getAns2_3_2());

				map1.put("2.(3)③", question.getAns2_3_3());

				map1.put("2.(3)④", question.getAns2_3_4());

				map1.put("2.(4)①", question.getAns2_4_1());

				map1.put("2.(4)②", question.getAns2_4_2());

				map1.put("2.(4)③", question.getAns2_4_3());

				map1.put("2.(4)④", question.getAns2_4_4());

				map1.put("2.(5)①", question.getAns2_5_1());

				map1.put("2.(5)②", question.getAns2_5_2());

				map1.put("2.(5)③", question.getAns2_5_3());

				map1.put("2.(5)④", question.getAns2_5_4());

				map1.put("2.(6)①", question.getAns2_6_1());

				map1.put("2.(6)②", question.getAns2_6_2());

				map1.put("2.(6)③", question.getAns2_6_3());

				map1.put("2.(6)④", question.getAns2_6_4());

				/** 全角半角入力エラー処理用 */
				Map<String, Boolean> map2 = new LinkedHashMap<String, Boolean>();

				map2.put("1.(3)", Check.checkChar(request.getParameter("a1_3_2")));

				map2.put("2.(1)⑤", Check.checkChar(request.getParameter("a2_1_5")));

				map2.put("2.(2)⑤", Check.checkChar(request.getParameter("a2_2_5")));

				map2.put("2.(3)⑤", Check.checkChar(request.getParameter("a2_3_5")));

				map2.put("2.(4)⑤", Check.checkChar(request.getParameter("a2_4_5")));

				map2.put("2.(5)⑤", Check.checkChar(request.getParameter("a2_5_5")));

				map2.put("2.(6)⑤", Check.checkChar(request.getParameter("a2_6_5")));

				/** 登録判定 */
				List<String> errorList = Check.checkQuestionAnswer(map1, map2);

				if (errorList.size() > 0) {

					request.setAttribute("errorList", errorList);

					servletPath = "/inf_question/question.jsp";

				} else {


					Question question_ins = (Question) session.getAttribute("question");

					QuestionDao.insert(question_ins);

					session.setAttribute("questionFlg", 0);

					servletPath = "/inf_question/questionComplete.jsp";

				}

			} else if ("QuestionComplete_btn".equals(request.getParameter("action"))) {

				Question question = (Question) session.getAttribute("question");

				QuestionDao.insert(question);

				servletPath = "/inf_question/questionComplete.jsp";

			} else if ("EducationTopSearch_btn".equals(request.getParameter("action"))) {

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

				List<Test> testList = TestDao.checkTestDetail2(
						String.valueOf(session.getAttribute("year")),
						String.valueOf(session.getAttribute("startMonth4")),
						String.valueOf(session.getAttribute("endMonth4")), education.getAccountNo());

				List<Report> reportList = ReportDao.checkReportDetail2(education.getAccountNo());

				List<Comment> commentList = CommentDao.checkComment(education.getAccountNo());

				List<CalendarUnq> calenderList = CalenderDao.search(
						String.valueOf(session.getAttribute("year")),
						String.valueOf(session.getAttribute("startMonth4")),
						String.valueOf(session.getAttribute("endMonth4")), "ASC");

				Date date = new Date();

				String sdf1 = new SimpleDateFormat("yyyy/MM/dd").format(date);

				if (sdf1.equals(String.valueOf(session.getAttribute("questionLastDate")))) {

					session.setAttribute("questionFlg", 1);

				} else {

					session.setAttribute("questionFlg", 0);
				}

				boolean flg = false;

				boolean chk = false;

				List<String> result = new ArrayList<String>();

				List<String> result2 = new ArrayList<String>();

				// テスト一覧
				for (CalendarUnq cal : calenderList) {

					flg = false;

					chk = false;

					int diff = cal.getCalenderOnDate().compareTo(String.valueOf(session.getAttribute("testLastDate")));

					int diff2 = cal.getCalenderOnDate().compareTo(sdf1);

					if (diff > 0 || diff2 > 0) {

						chk = true;

					}

					if (!testList.isEmpty() && !chk) {

						for (Test test : testList) {

							if (cal.getCalenderOnDate()
									.equals(test.getTestDate().replaceAll("-", "/"))) {

								if (cal.getCalenderOnDate()
										.equals(String.valueOf(session.getAttribute("testLastDate")))) {

									chk = true;

									break;

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

				// 日報一覧
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
