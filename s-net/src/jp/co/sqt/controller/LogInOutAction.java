/*
 *LoginOutAction.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (受講生管理業務)
 *クラス一覧：
 * NO クラス名 概要
 * 1 LoginOutAction ログイン・ログアウトに関するクラスです。
 *履歴：
 * NO 日付 Ver 更新者 内容
 * 1 2017/00/00 V1L1.0 SQT）加瀬 初版。
 */

package jp.co.sqt.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.sqt.dao.EducationDao;
import jp.co.sqt.dao.LoginDao;
import jp.co.sqt.dao.TopicsDao;
import jp.co.sqt.entity.Account;
import jp.co.sqt.entity.Education;

/**
 * <dd>クラス名：クラス
 * <dd>クラス説明：
 *
 * @version 1.00 2017/00/00
 * @author SQT）加瀬
 */
public class LogInOutAction implements Action {

	/**
	 * <dd>メソッド名：メソッド
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

		if ("".equals(request.getParameter("action"))) {

			java.util.Calendar objCal1 = java.util.Calendar.getInstance();

			java.util.Calendar objCal2 = java.util.Calendar.getInstance();

			objCal2.set(1970, 0, 1, 0, 0, 0);

			response.setDateHeader("Last-Modified", objCal1.getTime().getTime());

			response.setDateHeader("Expires", objCal2.getTime().getTime());

			response.setHeader("Proama", "no-cache");

			response.setHeader("Cache-Control", "no-cache");

			session = request.getSession(false);

			servletPath = "/index.jsp";

		} else {

			if ("Login_btn".equals(request.getParameter("action"))) {

				if (session == null) {

					session = request.getSession(true);

				}

				/** アカウント情報リスト */
				Account account = new Account();
				/*			account.setAccountId(request.getParameter("ID_txt"));

							account.setAccountPassword(request.getParameter("Password_txt"));
				*/
				String accountId = request.getParameter("ID_txt");

				String accountPassword = request.getParameter("Password_txt");

				session.setAttribute("accountId", accountId);

				session.setAttribute("accountPassword", accountPassword);

				/** エラーリスト */
				List<String> errorList = Check.checkLogin(accountId, accountPassword);

				if (errorList.size() > 0) {

					request.setAttribute("errorList", errorList);

					servletPath = "/index.jsp";

				} else {

					/** アカウント情報リスト */
					account = LoginDao.findAccount(accountId, 0);

					if (account.getAccountAuthority() == 2) {

						account = LoginDao.findAccount(accountId, 1);

					}

					session.setAttribute("account", account);

					session.setAttribute("topicsList", TopicsDao.findTopics("", "topics_date DESC", 1));

					/** 社員情報リスト */
					List<Education> education = EducationDao.search1(account.getCorporationNo(),
							account.getAccountAuthority());

					session.setAttribute("education", education);

					Date date = new Date();

					String sdf1 = new SimpleDateFormat("yyyy/MM/dd").format(date);

					SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd");

					if (account.getAccountAuthority() == 2) {

						boolean attendanceflg = false;

						if (account.getEnterningDate().substring(5, 7).equals("04")) {

							String endDate = String.valueOf(session.getAttribute("end3Date4"));

							Date date1 = null;

							try {

								date1 = sdFormat.parse(endDate);

							} catch (ParseException e) {

								// TODO 自動生成された catch ブロック
								e.printStackTrace();

							}

							if (!date.after(date1)) {

								session.setAttribute("end1date",
										DateUtil.getDateDiff(sdf1, String.valueOf(session.getAttribute("end1Date4"))));

								session.setAttribute("end2date",
										DateUtil.getDateDiff(sdf1, String.valueOf(session.getAttribute("end2Date4"))));

								session.setAttribute("end3date",
										DateUtil.getDateDiff(sdf1, String.valueOf(session.getAttribute("end3Date4"))));

								attendanceflg = true;

							} else {

								session.setAttribute("end1date", 0);

								session.setAttribute("end2date", 0);

								session.setAttribute("end3date", 0);

							}

						} else {

							String endDate = String.valueOf(session.getAttribute("end3Date10"));

							Date date1 = null;

							try {

								date1 = sdFormat.parse(endDate);

							} catch (ParseException e) {

								// TODO 自動生成された catch ブロック
								e.printStackTrace();

							}

							if (!date.after(date1)) {

								session.setAttribute("end1date",
										DateUtil.getDateDiff(sdf1, String.valueOf(session.getAttribute("end1Date10"))));

								session.setAttribute("end2date",
										DateUtil.getDateDiff(sdf1, String.valueOf(session.getAttribute("end2Date10"))));

								session.setAttribute("end3date",
										DateUtil.getDateDiff(sdf1, String.valueOf(session.getAttribute("end3Date10"))));

/*								attendanceflg = true;

*/							} else {

								session.setAttribute("end1date", 0);

								session.setAttribute("end2date", 0);

								session.setAttribute("end3date", 0);

							}

						}

						session.setAttribute("attendanceflg", attendanceflg);

					}

					servletPath = "/top.jsp";

				}

			} else if ("LoginBack_btn".equals(request.getParameter("action"))) {

				servletPath = "/index.jsp";

			} else if ("LogoutComplete_btn".equals(request.getParameter("action"))) {

				servletPath = "/inf_loginout/logoutComplete.jsp";

			} else if ("Fqa_btn".equals(request.getParameter("action"))) {

				servletPath = "/fqaSend.jsp";

			}

		}

		return servletPath;

	}

}
