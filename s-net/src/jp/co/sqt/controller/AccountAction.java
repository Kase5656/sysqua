/*
 *AccountAction.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (受講生管理業務)
 *クラス一覧：
 * NO クラス名 概要
 * 1 AccountAction 各アクションへ誘導するクラスです。
 *履歴：
 * NO 日付 Ver 更新者 内容
 * 1 2016/06/01 V1L1.0 SQT）加瀬 初版。
 */

package jp.co.sqt.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.sqt.dao.AccountDao;
import jp.co.sqt.dao.CorporationDao;
import jp.co.sqt.entity.Account;
import jp.co.sqt.entity.Corporation;

/**
 * <dd>クラス名：受講生検索情報受け渡しクラス
 * <dd>クラス説明：検索条件入力/検索一覧画面より受け取った検索条件をDaoへ受け渡します。 検索条件を正しい値かチェックします。
 *
 * @version 1.00 2016/06/01
 * @author SQT）加瀬
 */
public class AccountAction implements Action {

	/**
	 * <dd>メソッド名：受講生検索情報受け渡しメソッド
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

			if ("InfAccount_btn".equals(request.getParameter("action"))) {

				/** セッション削除 */
				session.removeAttribute("aName");

				session.removeAttribute("aPassword");

				session.removeAttribute("arePassword");

				session.removeAttribute("accountEditing");

				session.removeAttribute("educationKananameSearch");

				session.removeAttribute("corporationNoSearch");

				session.removeAttribute("orderSearch");

				session.removeAttribute("order");

				/** アカウント情報リスト */
				List<Account> accountList = AccountDao.search("", 0, "account_no");

				session.setAttribute("accountList", accountList);

				session.setAttribute("count", accountList.size());

				session.setAttribute("corporationList", CorporationDao.findAll());

				servletPath = "inf_account/list.jsp";

				/** アカウント情報一覧画面からの遷移 */
			} else if ("AccountRegister_btn".equals(request.getParameter("action"))) {

				session.setAttribute("corporationList", CorporationDao.findAll());

				servletPath = "/inf_account/registerInput.jsp";

				/** アカウント情報登録確認画面からの遷移 */
			} else if ("AccountRegisterInput_btn".equals(request.getParameter("action"))) {

				servletPath = "/inf_account/registerInput.jsp";

				/** アカウント情報登録入力画面からの遷移 */
			} else if ("AccountRegisterCheck_btn".equals(request.getParameter("action"))) {

				/** アカウント情報 */
				Account account = new Account();

				/** アカウント名 */
				String accountName = request.getParameter("accountName");

				/** パスワード */
				String accountPassword = request.getParameter("accountPassword");

				/** 再入力パスワード */
				String accountRePassword = request.getParameter("accountRePassword");

				account.setAccountNo(AccountDao.getLastNo() + 1);

				account.setAccountId(request.getParameter("accountId"));

				account.setAccountAuthority(Integer.parseInt(request.getParameter("accountAuthority")));

				account.setAccountRemarks(request.getParameter("Remarks_txt"));

				String corporation = request.getParameter("corporation");

				if (!corporation.equals("0")) {

					/** 企業情報 */
					String[] corporationParts = corporation.split("/");

					account.setCorp(new Corporation(Integer.parseInt(corporationParts[0]), corporationParts[1]));

				} else {

					account.setCorp(new Corporation(0, ""));

				}

				session.setAttribute("aName", accountName);

				session.setAttribute("aPassword", accountPassword);

				session.setAttribute("arePassword", accountRePassword);

				session.setAttribute("accountEditing", account);

				/** 登録判定 */
				List<String> errorList = Check.checkAccount(account, accountName, accountPassword,
						accountRePassword);

				if (errorList.size() > 0) {

					request.setAttribute("errorList", errorList);

					servletPath = "/inf_account/registerInput.jsp";

				} else {

					servletPath = "/inf_account/registerCheck.jsp";

				}

			} else if ("AccountRegisterComplete_btn".equals(request.getParameter("action"))) {

				/** アカウント情報 */
				Account account = (Account) session.getAttribute("accountEditing");

				/** アカウント名 */
				String accountName = (String) session.getAttribute("aName");

				/** パスワード */
				String accountPassword = (String) session.getAttribute("aPassword");

				/** パスワード再入力 */
				String accountRePassword = (String) session.getAttribute("arePassword");

				/** 表示ボタン判定フラグ */
				int flg = 0;

				AccountDao.insert(account, accountName, accountPassword, accountRePassword);

				/** 表示ボタン判定 */
				if (account.getAccountAuthority() == 2) {

					flg = 1;

				}

				request.setAttribute("buttonflg", flg);

				servletPath = "/inf_account/registerComplete.jsp";

			} else if ("AccountUpdate_btn".equals(request.getParameter("action"))) {

				/** チェックボックスのvalue情報 */
				String[] checkList = request.getParameterValues("InfAccount_chk");

				session.setAttribute("selectedCheckList", checkList);

				List<String> errorList = new ArrayList<>();

				/** アカウント情報一覧のアカウント情報 */
				List<Account> accountList = (List<Account>) session.getAttribute("accountList");

				/** チェックボックス未選択エラーフラグ */
				errorList = Check.UpdateCheckbox(checkList, 0);

				if (errorList.size() > 0) {

					request.setAttribute("errorList", errorList);

					servletPath = "/inf_account/list.jsp";

				} else {

					for (String check : checkList) {

						for (Account account : accountList) {

							if (Integer.parseInt(check) == account.getAccountNo()) {

								session.setAttribute("accountEditing", account);

								session.setAttribute("aName", account.getAccountName());

								session.setAttribute("aPassword", account.getAccountPassword());

								session.setAttribute("arePassword", account.getAccountRePassword());

								break;

							}

						}

					}

					servletPath = "/inf_account/updateInput.jsp";

				}

			} else if ("AccountUpdateInput_btn".equals(request.getParameter("action"))) {

				servletPath = "/inf_account/updateInput.jsp";

				/** アカウント情報変更入力画面からの遷移 */
			} else if ("AccountUpdateCheck_btn".equals(request.getParameter("action"))) {

				/** アカウント情報 */
				Account account = new Account();

				/** アカウント名 */
				String accountName = request.getParameter("accountName");

				/** パスワード */
				String accountPassword = request.getParameter("accountPassword");

				/** 再入力パスワード */
				String accountRePassword = request.getParameter("accountRePassword");

				account = (Account) session.getAttribute("accountEditing");

				account.setAccountId(request.getParameter("accountId"));

				account.setAccountAuthority(Integer.parseInt(request.getParameter("accountAuthority")));

				account.setAccountRemarks(request.getParameter("Remarks_txt"));

				account.setCorp(account.getCorporation());

				session.setAttribute("aName", accountName);

				session.setAttribute("aPassword", accountPassword);

				session.setAttribute("arePassword", accountRePassword);

				session.setAttribute("accountEditing", account);

				/** 登録判定 */
				List<String> errorList = Check.checkAccount(account, accountName, accountPassword, accountRePassword);

				if (errorList.size() > 0) {

					request.setAttribute("errorList", errorList);

					servletPath = "/inf_account/updateInput.jsp";

				} else {

					servletPath = "/inf_account/updateCheck.jsp";

				}

				/** アカウント情報変更確認画面からの遷移 */
			} else if ("AccountUpdateComplete_btn".equals(request.getParameter("action"))) {

				Account account = (Account) session.getAttribute("accountEditing");

				String accountName = session.getAttribute("aName").toString();

				String accountPassword = session.getAttribute("aPassword").toString();

				String accountRePassword = session.getAttribute("arePassword").toString();

				/** update文を実行 */
				AccountDao.update(account, accountName, accountPassword, accountRePassword);

				/** update2文を実行 */
				AccountDao.update2(account);

				/** セッション削除 */
				session.removeAttribute("selectedCheckList");

				servletPath = "/inf_account/updateComplete.jsp";

			} else if ("AccountDelete_btn".equals(request.getParameter("action"))) {

				/** 削除対象のアカウント情報 */
				List<Account> accountDeleteList = new ArrayList<Account>();

				/** チェックボックスのvalue情報 */
				String[] checkList = request.getParameterValues("InfAccount_chk");

				session.setAttribute("selectedCheckList", checkList);

				List<String> errorList = new ArrayList<>();

				/** アカウント情報一覧のアカウント情報 */
				List<Account> accountList = (List<Account>) session.getAttribute("accountList");

				/** チェックボックス未選択エラーフラグ */
				errorList = Check.DeleteCheckbox(checkList, 0);

				if (errorList.size() > 0) {

					request.setAttribute("errorList", errorList);

					servletPath = "/inf_account/list.jsp";

				} else {

					for (String check : checkList) {

						for (Account account : accountList) {

							if (Integer.parseInt(check) == account.getAccountNo()) {

								accountDeleteList.add(account);

							}

						}

					}

					session.setAttribute("accountDeleteList", accountDeleteList);

					servletPath = "/inf_account/deleteCheck.jsp";

				}

				/** アカウント削除確認画面からの遷移 */
			} else if ("AccountDeleteComplete_btn".equals(request.getParameter("action"))) {

				List<Account> accountList = (List<Account>) request.getSession().getAttribute("accountDeleteList");

				AccountDao.deleteAccount(accountList);

				for (int i = 0; accountList.size() > 0; i++) {

					AccountDao.deleteAttendance(accountList.get(i).getAccountNo());

					AccountDao.deleteCommnet(accountList.get(i).getAccountNo());

					AccountDao.deleteEducation(accountList.get(i).getAccountNo());

					AccountDao.deleteInterview(accountList.get(i).getAccountNo());

					AccountDao.deleteQuestion(accountList.get(i).getAccountNo());

					AccountDao.deleteReport(accountList.get(i).getAccountNo());

					AccountDao.deleteTechnologyLevel(accountList.get(i).getAccountNo());

					AccountDao.deleteTest(accountList.get(i).getAccountNo());

				}

				servletPath = "/inf_account/deleteComplete.jsp";

			} else if ("BackMaintenance_btn".equals(request.getParameter("action"))) {

				servletPath = "/inf_maintenance/index.jsp";

			}

		}

		return servletPath;

	}

}
