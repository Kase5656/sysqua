/*
 *DutiesAction.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (役割管理業務)
 *クラス一覧：
 * NO クラス名 概要
 * 1 DutiesAction 各アクションへ誘導するクラスです。
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
import jp.co.sqt.dao.DutiesDao;
import jp.co.sqt.dao.ReportDao;
import jp.co.sqt.dao.TestDao;
import jp.co.sqt.entity.Account;
import jp.co.sqt.entity.CalendarUnq;
import jp.co.sqt.entity.Comment;
import jp.co.sqt.entity.Duties;
import jp.co.sqt.entity.Education;
import jp.co.sqt.entity.Report;
import jp.co.sqt.entity.Test;

/**
 * <dd>クラス名：役割検索情報受け渡しクラス
 * <dd>クラス説明：検索条件入力/検索一覧画面より受け取った検索条件をDaoへ受け渡します。 検索条件を正しい値かチェックします。
 *
 * @version 1.00 2016/06/01
 * @author SQT）加瀬
 */
public class DutiesAction implements Action {

	/**
	 * <dd>メソッド名：役割検索情報受け渡しメソッド
	 * <dd>メソッド説明：指定された検索条件を、Daoへ受け渡すメソッドです。 検索条件を正しい値かチェックします。
	 *
	 * @param request
	 *            リクエスト
	 * @param response
	 *            レスポンス
	 * @return servletPath 遷移する画面のサーブレットパス
	 */
	@SuppressWarnings("unchecked")
	@Override
	public String doService(HttpServletRequest request, HttpServletResponse response) {

		/** セッション */
		HttpSession session = request.getSession(false);

		/** サーブレットパス */
		String servletPath = request.getServletPath();

		if (session == null || session.getAttribute("accountId") == null) {

			servletPath = "sessionLost.jsp";

		} else {

			if ("InfDuties_btn".equals(request.getParameter("action"))) {

				/** 役割情報リスト */
				List<Duties> dutiesList = DutiesDao.search("", "ASC");

				session.setAttribute("dutiesList", dutiesList);

				session.setAttribute("count", dutiesList.size());

				servletPath = "/inf_duties/list.jsp";

			} else if ("DutiesRegister_btn".equals(request.getParameter("action"))) {

				/** 役割情報 */
				Duties duties = new Duties();

				session.setAttribute("duties", duties);

				servletPath = "/inf_duties/registerInput.jsp";

				/** 役割情報登録確認画面からの遷移 */
			} else if ("DutiesRegisterInput_btn".equals(request.getParameter("action"))) {

				servletPath = "/inf_duties/registerInput.jsp";

			} else if ("DutiesRegisterCheck_btn".equals(request.getParameter("action"))) {

				/** 役割情報 */
				Duties duties = new Duties();

				duties.setDutiesNo(DutiesDao.getLastNo() + 1);

				duties.setDutiesName(request.getParameter("DutiesName_txt"));

				duties.setDutiesRemarks(request.getParameter("DutiesRemarks_txt"));

				/** 登録判定 */
				List<String> errorList = Check.checkDuties(duties);

				if (errorList.size() > 0) {

					request.setAttribute("errorList", errorList);

					servletPath = "/inf_duties/registerInput.jsp";

				} else {

					session.setAttribute("duties", duties);

					servletPath = "/inf_duties/registerCheck.jsp";

				}

			} else if ("DutiesRegisterComplete_btn".equals(request.getParameter("action"))) {

				/** 役割情報 */
				Duties duties = (Duties) session.getAttribute("duties");

				DutiesDao.insert(duties);

				servletPath = "/inf_duties/registerComplete.jsp";

			} else if ("DutiesUpdate_btn".equals(request.getParameter("action"))) {

				/** チェックボックスのvalue情報 */
				String[] checkList = request.getParameterValues("InfDuties_chk");

				session.setAttribute("selectedCheckList", checkList);

				List<String> errorList = new ArrayList<>();

				/** 役割情報一覧の役割情報 */
				List<Duties> dutiesList = (List<Duties>) session.getAttribute("dutiesList");

				/** チェックボックス未選択エラーフラグ */
				errorList = Check.UpdateCheckbox(checkList, 4);

				if (errorList.size() > 0) {

					request.setAttribute("errorList", errorList);

					servletPath = "/inf_duties/list.jsp";

				} else {

					for (String check : checkList) {

						for (Duties duties : dutiesList) {

							if (Integer.parseInt(check) == duties.getDutiesNo()) {

								session.setAttribute("duties", duties);

								break;

							}

						}

					}

					servletPath = "/inf_duties/updateInput.jsp";

				}

			} else if ("DutiesUpdateInput_btn".equals(request.getParameter("action"))) {

				servletPath = "/inf_duties/updateInput.jsp";

			} else if ("DutiesUpdateCheck_btn".equals(request.getParameter("action"))) {

				Duties duties = (Duties) session.getAttribute("duties");

				/*			duties.setDutiesNo(Integer.parseInt(request.getParameter("dutiesNo")));
				*/
				duties.setDutiesName(request.getParameter("DutiesName_txt"));

				duties.setDutiesRemarks(request.getParameter("DutiesRemarks_txt"));

				List<String> errorList = Check.checkDuties(duties);

				if (errorList.size() > 0) {

					request.setAttribute("errorList", errorList);

					servletPath = "/inf_duties/updateInput.jsp";

				} else {

					session.setAttribute("duties", duties);

					servletPath = "/inf_duties/updateCheck.jsp";

				}

			} else if ("DutiesUpdateComplete_btn".equals(request.getParameter("action"))) {

				Duties duties = (Duties) session.getAttribute("duties");

				DutiesDao.update(duties);

				/** セッション削除 */
				session.removeAttribute("selectedCheckList");

				servletPath = "/inf_duties/updateComplete.jsp";

			} else if ("DutiesDelete_btn".equals(request.getParameter("action"))) {

				/** 削除対象の役割情報 */
				List<Duties> dutiesDeleteList = new ArrayList<Duties>();

				/** チェックボックスのvalue情報 */
				String[] checkList = request.getParameterValues("InfDuties_chk");

				session.setAttribute("selectedCheckList", checkList);

				List<String> errorList = new ArrayList<>();

				/** 役割情報一覧の役割情報 */
				List<Duties> dutiesList = (List<Duties>) session.getAttribute("dutiesList");

				/** チェックボックス未選択エラーフラグ */
				errorList = Check.DeleteCheckbox(checkList, 3);

				if (errorList.size() > 0) {

					request.setAttribute("errorList", errorList);

					servletPath = "/inf_duties/list.jsp";

				} else {

					for (String check : checkList) {

						for (Duties duties : dutiesList) {

							if (Integer.parseInt(check) == duties.getDutiesNo()) {

								dutiesDeleteList.add(duties);

							}

						}

					}

					session.setAttribute("dutiesDeleteList", dutiesDeleteList);

					servletPath = "/inf_duties/deleteCheck.jsp";

				}

			} else if ("DutiesDeleteComplete_btn".equals(request.getParameter("action"))) {

				List<Duties> dutiesList = (List<Duties>) request.getSession().getAttribute("dutiesDeleteList");

				DutiesDao.delete(dutiesList);

				/** セッション削除 */
				session.removeAttribute("selectedCheckList");

				servletPath = "/inf_duties/deleteComplete.jsp";

			} else if ("BackMaintenance_btn".equals(request.getParameter("action"))) {

				servletPath = "/inf_maintenance/index.jsp";

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

				// テスト一覧
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

							if (cal.getCalenderOnDate().equals(test.getTestDate())) {

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
