/*
 *MenuAction.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (受講生管理業務)
 *クラス一覧：
 * NO クラス名 概要
 * 1 MenuAction 各アクションへ誘導するクラスです。
 *履歴：
 * NO 日付 Ver 更新者 内容
 * 1 2016/06/01 V1L1.0 SQT）加瀬 初版。
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
 * <dd>クラス名：メニュー画面遷移クラス
 * <dd>クラス説明：メニュー画面へ遷移します。
 *
 * @version 1.00 2016/06/01
 * @author SQT）加瀬
 *
 */
public class MenuAction implements Action {

	/**
	 * <dd>メソッド名：メニュー画面遷移メソッド
	 * <dd>メソッド説明：メニュー画面へ遷移します。
	 *
	 * @param request
	 *            リクエスト
	 * @param response
	 *            レスポンス
	 */
	@Override
	public String doService(HttpServletRequest request, HttpServletResponse response) {

		/** セッション */
		HttpSession session = request.getSession(false);

		/** サーブレットパス */
		String servletPath = request.getServletPath();

		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		if (session == null || session.getAttribute("accountId") == null) {

			servletPath = "sessionLost.jsp";

		} else {

			if ("Menu_btn".equals(request.getParameter("action"))) {

				String accountId = request.getParameter("NowloginId");

				/** アカウント情報リスト */
				Account account = LoginDao.findAccount(accountId, 1);

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

							attendanceflg = true;

						} else {

							session.setAttribute("end1date", 0);

							session.setAttribute("end2date", 0);

							session.setAttribute("end3date", 0);

						}

					}

					session.setAttribute("attendanceflg", attendanceflg);

				}

				servletPath = "/top.jsp";

			} else if ("BackLogin_btn".equals(request.getParameter("action"))) {

				servletPath = "/index.jsp";

			} else if ("InfAccount_btn".equals(request.getParameter("action"))) {

				servletPath = "/inf_account/list.jsp";

			} else if ("BackTop_btn".equals(request.getParameter("action"))) {

				servletPath = "/top.jsp";

			} else if ("MainteMenu_btn".equals(request.getParameter("action"))) {

				servletPath = "/inf_maintenance/index.jsp";

			} else if ("SubsidyMenu_btn".equals(request.getParameter("action"))) {

				servletPath = "/inf_subsidy/index.jsp";

			} else if ("CareerList1_btn".equals(request.getParameter("action"))) {

				servletPath = "/inf_subsidy/careerlist1.jsp";

			} else if ("CareerList2_btn".equals(request.getParameter("action"))) {

				servletPath = "/inf_subsidy/careerlist2.jsp";

				//		} else if ("Mypagelist_btn".equals(request.getParameter("action"))) {
				//
				//			String accountId = request.getParameter("NowloginId");
				//
				//			Account account = LoginDao.findAccount(accountId);
				//
				//			session.setAttribute("account", account);
				//
				//			if (account.getAccountAuthority() == 2) {
				//
				//				Education education = EducationDao.search3(account.getAccountNo());
				//
				//				session.setAttribute("education", education);
				//
				//			}
				//
				//			servletPath = "/inf_mypage/list.jsp";

			} else if ("Mypage_btn".equals(request.getParameter("action"))) {

				session.setAttribute("referer", request.getHeader("REFERER"));

				Account account = LoginDao.findAccount(request.getParameter("NowloginId"), 0);

				session.setAttribute("accountId", account.getAccountId());

				session.setAttribute("accountPassword", account.getAccountPassword());

				session.setAttribute("accountRePassword", account.getAccountRePassword());

				/*				session.setAttribute("account", account);
				*/
				if (account.getAccountAuthority() == 2) {

					Education education = EducationDao.search3(account.getAccountNo());

					session.setAttribute("education", education);

				}

				servletPath = "/inf_mypage/list.jsp";

			} else if ("Logout_btn".equals(request.getParameter("action"))) {

				servletPath = "/inf_loginout/logoutCheck.jsp";

			}

		}

		return servletPath;

	}

}
