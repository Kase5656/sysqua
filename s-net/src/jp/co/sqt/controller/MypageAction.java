/*
 *MypageAction.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (マイページ管理業務)
 *クラス一覧：
 * NO クラス名 概要
 * 1 MypageAction 各アクションへ誘導するクラスです。
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

import jp.co.sqt.dao.AccountDao;
import jp.co.sqt.dao.DutiesDao;
import jp.co.sqt.dao.EducationDao;
import jp.co.sqt.dao.LoginDao;
import jp.co.sqt.dao.TechnologyLevelDao;
import jp.co.sqt.dao.TopicsDao;
import jp.co.sqt.entity.Account;
import jp.co.sqt.entity.Education;
import jp.co.sqt.entity.TechnologyLevel;

/**
 * <dd>クラス名：マイページ検索情報受け渡しクラス
 * <dd>クラス説明：検索条件入力/検索一覧画面より受け取った検索条件をDaoへ受け渡します。 検索条件を正しい値かチェックします。
 *
 * @version 1.00 2016/06/01
 * @author SQT）加瀬
 */
public class MypageAction implements Action {

	/**
	 * <dd>メソッド名：マイページ検索情報受け渡しメソッド
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

			if ("EducationUpdate_btn".equals(request.getParameter("action"))) {

				/** アカウント情報 */
				Education education = (Education) session.getAttribute("education");

				session.setAttribute("education", education);

				session.setAttribute("dutiesList", DutiesDao.findAll());

				servletPath = "/inf_mypage/educationupdateInput.jsp";

			} else if ("EducationUpdateCheck_btn".equals(request.getParameter("action"))) {

				/** マイページ情報 */
				Education education = (Education) session.getAttribute("education");

				/*			education.setAccountNo(Integer.parseInt(request.getParameter("AccoutNo_txt")));
				*/

				education.setEducationName(request.getParameter("EducationName_txt"));

				education.setEducationKanaName(request.getParameter("EducationKanaName_txt"));

				education.setEducationGender(Integer.parseInt(request.getParameter("Gender_rdo")));

				education.setEducationBirthday(request.getParameter("Birthday_txt"));

				education.setEducationPostalcode(request.getParameter("PostalCode_txt"));

				education.setEducationAddress(request.getParameter("Address_txt"));

				education.setEducationPhoneNumber(request.getParameter("Phone_txt"));

				education.setEducationEmailAddress(request.getParameter("EmailAddress_txt"));

				education.setEnterningDate(request.getParameter("EnterningDate_txt"));

				String duties1 = request.getParameter("Duties_cmb1");

				/** 役割No1 */
				String[] duties1Parts = duties1.split("/");

				if (!duties1.equals("0")) {

					education.setDutiesNo1(Integer.parseInt(duties1Parts[0]));

					education.setDutiesNameNo1(duties1Parts[1]);

				} else {

					education.setDutiesNo1(0);

					education.setDutiesNameNo1("");

				}

				String duties2 = request.getParameter("Duties_cmb2");

				/** 役割No2 */
				String[] duties2Parts = duties2.split("/");

				if (!duties2.equals("0")) {

					education.setDutiesNo2(Integer.parseInt(duties2Parts[0]));

					education.setDutiesNameNo2(duties2Parts[1]);

				} else {

					education.setDutiesNo2(0);

					education.setDutiesNameNo2("");

				}

				String duties3 = request.getParameter("Duties_cmb3");

				/** 役割No3 */
				String[] duties3Parts = duties3.split("/");

				if (!duties3.equals("0")) {

					education.setDutiesNo3(Integer.parseInt(duties3Parts[0]));

					education.setDutiesNameNo3(duties3Parts[1]);

				} else {

					education.setDutiesNo3(0);

					education.setDutiesNameNo3("");

				}

				education.setEducationRemarks(request.getParameter("Remarks_txt"));

				/** 登録判定 */
				session.setAttribute("education", education);

				List<String> errorList = Check.checkEducation(education, false);

				if (errorList.size() > 0) {

					request.setAttribute("errorList", errorList);

					servletPath = "/inf_mypage/educationupdateInput.jsp";

				} else {

					servletPath = "/inf_mypage/educationupdateCheck.jsp";

				}

			} else if ("EducationUpdateComplete_btn".equals(request.getParameter("action"))) {

				Education education = (Education) session.getAttribute("education");

				/** update文を実行 */
				EducationDao.update(education);

				servletPath = "/inf_mypage/educationupdateComplete.jsp";

			} else if ("Mypage_btn".equals(request.getParameter("action"))) {

				Account account = (Account) session.getAttribute("account");

				account = LoginDao.findAccount(account.getAccountId(), 0);

				session.setAttribute("account", account);

				if (account.getAccountAuthority() == 2) {

					Education education = (Education) session.getAttribute("education");

					education = EducationDao.search3(education.getAccountNo());

					session.setAttribute("education", education);

				}

				servletPath = "/inf_mypage/list.jsp";

			} else if ("AccountUpdate_btn".equals(request.getParameter("action"))) {

				Account account = (Account) session.getAttribute("account");

				account = LoginDao.findAccount(account.getAccountId(), 0);

				session.setAttribute("accountId", account.getAccountId());

				session.setAttribute("account", account);

				servletPath = "/inf_mypage/accountupdateInput.jsp";

			} else if ("AccountUpdateBack_btn".equals(request.getParameter("action"))) {

				session.setAttribute("accountId", session.getAttribute("accountId"));

				session.setAttribute("accountPassword", session.getAttribute("accountPassword"));

				session.setAttribute("accountRePassword", session.getAttribute("accountRePassword"));

				servletPath = "/inf_mypage/accountupdateInput.jsp";

			} else if ("AccountUpdateCheck_btn".equals(request.getParameter("action"))) {

				/** アカウント情報 */
				Account account = (Account) session.getAttribute("account");

				/*				*//** アカウントID */
				/*
				account.setAccountId(request.getParameter("AccountId_txt"));

				*//** パスワード */
				/*
				account.setAccountPassword(request.getParameter("AccountPassword_txt"));

				*//** 再入力パスワード *//*
									account.setAccountRePassword(request.getParameter("AccountRePassword_txt"));

									session.setAttribute("account", account);
									*/
				/** アカウントID */
				session.setAttribute("accountId", request.getParameter("AccountId_txt"));

				/** パスワード */
				session.setAttribute("accountPassword", request.getParameter("AccountPassword_txt"));

				/** 再入力パスワード */
				session.setAttribute("accountRePassword", request.getParameter("AccountRePassword_txt"));

				/** 登録判定 */
				List<String> errorList = Check.checkAccount2(request.getParameter("AccountId_txt"),
						request.getParameter("AccountPassword_txt"), request.getParameter("AccountRePassword_txt"),
						account.getAccountNo());

				if (errorList.size() > 0) {

					request.setAttribute("errorList", errorList);

					servletPath = "/inf_mypage/accountupdateInput.jsp";

				} else {

					servletPath = "/inf_mypage/accountupdateCheck.jsp";

				}

			} else if ("AccountUpdateComplete_btn".equals(request.getParameter("action"))) {

				Account account = (Account) session.getAttribute("account");

				account.setAccountId(String.valueOf(session.getAttribute("accountId")));

				account.setAccountPassword(String.valueOf(session.getAttribute("accountPassword")));

				account.setAccountRePassword(String.valueOf(session.getAttribute("accountPassword")));

				/** update文を実行 */
				AccountDao.update(account);

				servletPath = "/inf_mypage/accountupdateComplete.jsp";

			} else if ("InfLogin_btn".equals(request.getParameter("action"))) {

				session.invalidate();

				servletPath = "/index.jsp";

			} else if ("Login_btn".equals(request.getParameter("action"))) {

				Account account = (Account) session.getAttribute("account");

				session.setAttribute("account", account);

				session.setAttribute("topicsList", TopicsDao.findTopics("", "topics_date DESC", 1));

				/** 社員情報リスト */
				List<Education> educationList = EducationDao.search1(account.getCorporationNo(),
						account.getAccountAuthority());

				session.setAttribute("education", educationList);

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

			} else if ("Random_btn".equals(request.getParameter("action"))) {

				String url = (String) session.getAttribute("referer");

				servletPath = response.encodeURL(url).substring(25);

			} else if ("InfTechnologyLevel_btn".equals(request.getParameter("action"))) {

				Education education = (Education) session.getAttribute("education");

				TechnologyLevel technologylevel = TechnologyLevelDao.search(education);

				session.setAttribute("technologylevel", technologylevel);

				servletPath = "/inf_technologylevel/list.jsp";

			}

		}

		return servletPath;

	}

}
