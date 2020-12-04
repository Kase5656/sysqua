/*
 *TechnologyLevelAction.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (技術目標管理業務)
 *クラス一覧：
 * NO クラス名 概要
 * 1 TechnologyLevelAction 各アクションへ誘導するクラスです。
 *履歴：
 * NO 日付 Ver 更新者 内容
 * 1 2016/06/01 V1L1.0 SQT）加瀬 初版。
 */

package jp.co.sqt.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.sqt.dao.CalenderDao;
import jp.co.sqt.dao.CommentDao;
import jp.co.sqt.dao.ReportDao;
import jp.co.sqt.dao.TechnologyLevelDao;
import jp.co.sqt.dao.TestDao;
import jp.co.sqt.entity.Account;
import jp.co.sqt.entity.CalendarUnq;
import jp.co.sqt.entity.Comment;
import jp.co.sqt.entity.Education;
import jp.co.sqt.entity.Report;
import jp.co.sqt.entity.TechnologyLevel;
import jp.co.sqt.entity.Test;

/**
 * <dd>クラス名：技術目標検索情報受け渡しクラス
 * <dd>クラス説明：検索条件入力/検索一覧画面より受け取った検索条件をDaoへ受け渡します。 検索条件を正しい値かチェックします。
 *
 * @version 1.00 2016/06/01
 * @author SQT）加瀬
 */
public class TechnologyLevelAction implements Action {

	/**
	 * <dd>メソッド名：技術目標検索情報受け渡しメソッド
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

		Account account = (Account) session.getAttribute("account");

		if (account.getAccountAuthority() == 0) {

			session.setAttribute("JspFlg", 0);

		} else if (account.getAccountAuthority() == 1) {

			session.setAttribute("JspFlg", 1);

		} else if (account.getAccountAuthority() == 2) {

			session.setAttribute("JspFlg", 2);

		}

		if (session == null || session.getAttribute("accountId") == null) {

			servletPath = "sessionLost.jsp";

		} else {

			if ("TechnologyApril_btn".equals(request.getParameter("action"))) {

				TechnologyLevel technologylevel = (TechnologyLevel) session.getAttribute("technologylevel");

				if (technologylevel.getAccountNo() != 0) {

					technologylevel.setLevel4Action(Check.change2(technologylevel.getLevel4Action()));

				}

				session.setAttribute("technologylevel", technologylevel);

				servletPath = "/inf_technologylevel/aprilregisterInput.jsp";

			} else if ("TechnologyAprilRegisterInput_btn".equals(request.getParameter("action"))) {

				TechnologyLevel technologylevel = (TechnologyLevel) session.getAttribute("technologylevel");

				boolean flg = false;

				if (technologylevel.getTechnologyLevelNo() == 0) {

					flg = true;

				}

				if (flg) {

					technologylevel.setTechnologyLevelNo(TechnologyLevelDao.getLastNo() + 1);

				} else {

					technologylevel = (TechnologyLevel) session.getAttribute("technologylevel");

					technologylevel.setTechnologyLevelNo(technologylevel.getTechnologyLevelNo());

				}

				technologylevel.setAccountNo(Integer.parseInt(request.getParameter("AccountNo")));

				technologylevel.setLevel4(request.getParameter("level4_txt"));

				technologylevel.setLevel5Goal(request.getParameter("level5Goal_txt"));

				technologylevel.setLevel4Action(Check.change(request.getParameter("level4Action_txt")));

				List<String> errorList = Check.checkTechnologyLevel(technologylevel, 0);

				if (errorList.size() > 0) {

					request.setAttribute("errorList", errorList);

					servletPath = "/inf_technologylevel/aprilregisterInput.jsp";

				} else {

					if (flg) {

						TechnologyLevelDao.insert(technologylevel);

					} else {

						TechnologyLevelDao.update(technologylevel, 0);

					}

					session.setAttribute("technologylevel", technologylevel);

					servletPath = "/inf_technologylevel/list.jsp";

				}

			} else if ("TechnologyMay_btn".equals(request.getParameter("action"))) {

				TechnologyLevel technologylevel = (TechnologyLevel) session.getAttribute("technologylevel");

				if (technologylevel.getAccountNo() != 0) {

					technologylevel.setLevel5GoalReason(Check.change2(technologylevel.getLevel5GoalReason()));

					technologylevel.setLevel5Action(Check.change2(technologylevel.getLevel5Action()));

				}

				session.setAttribute("technologylevel", technologylevel);

				servletPath = "/inf_technologylevel/mayregisterInput.jsp";

			} else if ("TechnologyMayRegisterInput_btn".equals(request.getParameter("action"))) {

				TechnologyLevel technologylevel = (TechnologyLevel) session.getAttribute("technologylevel");

				technologylevel.setTechnologyLevelNo(technologylevel.getTechnologyLevelNo());

				technologylevel.setAccountNo(Integer.parseInt(request.getParameter("AccountNo")));

				technologylevel.setLevel5(request.getParameter("level5_txt"));

				technologylevel.setLevel6Goal(request.getParameter("level6Goal_txt"));

				technologylevel.setLevel5GoalReason(Check.change(request.getParameter("level5GoalReason_txt")));

				technologylevel.setLevel5Action(Check.change(request.getParameter("level5Action_txt")));

				List<String> errorList = Check.checkTechnologyLevel(technologylevel, 1);

				if (errorList.size() > 0) {

					request.setAttribute("errorList", errorList);

					servletPath = "/inf_technologylevel/mayregisterInput.jsp";

				} else {

					TechnologyLevelDao.update(technologylevel, 1);

					servletPath = "/inf_technologylevel/list.jsp";

				}

			} else if ("TechnologyJune_btn".equals(request.getParameter("action"))) {

				TechnologyLevel technologylevel = (TechnologyLevel) session.getAttribute("technologylevel");

				if (technologylevel.getAccountNo() != 0) {

					technologylevel.setLevel6GoalReason(Check.change2(technologylevel.getLevel6GoalReason()));

					technologylevel.setLevel6Action(Check.change2(technologylevel.getLevel6Action()));

				}

				session.setAttribute("technologylevel", technologylevel);

				servletPath = "/inf_technologylevel/juneregisterInput.jsp";

			} else if ("TechnologyJuneRegisterInput_btn".equals(request.getParameter("action"))) {

				TechnologyLevel technologylevel = (TechnologyLevel) session.getAttribute("technologylevel");

				technologylevel.setTechnologyLevelNo(technologylevel.getTechnologyLevelNo());

				technologylevel.setAccountNo(Integer.parseInt(request.getParameter("AccountNo")));

				technologylevel.setLevel6(request.getParameter("level6_txt"));

				technologylevel.setLevel7Goal(request.getParameter("level7Goal_txt"));

				technologylevel.setLevel6GoalReason(Check.change(request.getParameter("level6GoalReason_txt")));

				technologylevel.setLevel6Action(Check.change(request.getParameter("level6Action_txt")));

				List<String> errorList = Check.checkTechnologyLevel(technologylevel, 2);

				if (errorList.size() > 0) {

					request.setAttribute("errorList", errorList);

					servletPath = "/inf_technologylevel/juneregisterInput.jsp";

				} else {

					TechnologyLevelDao.update(technologylevel, 2);

					servletPath = "/inf_technologylevel/list.jsp";

				}

			} else if ("EducationDetailSearch_btn".equals(request.getParameter("action"))) {

				/** 社員情報 */
				Education education = (Education) session.getAttribute("education");

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

			} else if ("InfTechnologyLevel_btn".equals(request.getParameter("action"))) {

				Education education = (Education) session.getAttribute("education");

				TechnologyLevel technologylevel = TechnologyLevelDao.search(education);

				if (!technologylevel.equals(null)) {

					session.setAttribute("technologylevel", technologylevel);

				}

				servletPath = "/inf_technologylevel/list.jsp";

			}

		}

		return servletPath;

	}

}
