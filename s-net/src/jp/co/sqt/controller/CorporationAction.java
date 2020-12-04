/*
 *CorporationAction.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (企業管理業務)
 *クラス一覧：
 * NO クラス名 概要
 * 1 CorporationAction 各アクションへ誘導するクラスです。
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

import jp.co.sqt.dao.CorporationDao;
import jp.co.sqt.entity.Corporation;

/**
 * <dd>クラス名：企業検索情報受け渡しクラス
 * <dd>クラス説明：検索条件入力/検索一覧画面より受け取った検索条件をDaoへ受け渡します。 検索条件を正しい値かチェックします。
 *
 * @version 1.00 2016/06/01
 * @author SQT）加瀬
 */
public class CorporationAction implements Action {

	/**
	 * <dd>メソッド名：企業検索情報受け渡しメソッド
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

			if ("InfCorporation_btn".equals(request.getParameter("action"))) {

				/** 企業情報リスト */
				List<Corporation> corporationList = CorporationDao.search("", "ASC");

				session.setAttribute("corporationList", corporationList);

				session.setAttribute("count", corporationList.size());

				servletPath = "/inf_corporation/list.jsp";

			} else if ("CorporationRegister_btn".equals(request.getParameter("action"))) {

				/** 企業情報 */
				Corporation corporation = new Corporation();

				session.setAttribute("corporation", corporation);

				servletPath = "/inf_corporation/registerInput.jsp";

			} else if ("CorporationRegisterCheck_btn".equals(request.getParameter("action"))) {

				/** 企業情報 */
				Corporation corporation = new Corporation();

				corporation.setCorporationNo(CorporationDao.getLastNo() + 1);

				corporation.setCorporationName(request.getParameter("CorporationName_txt"));

				corporation.setCorporationKanaName(request.getParameter("CorporationKanaName_txt"));

				corporation.setCorporationPostalcode(request.getParameter("CorporationPostalcode_txt"));

				corporation.setCorporationAddress(request.getParameter("CorporationAddress_txt"));

				corporation.setCorporationTel(request.getParameter("CorporationTel_txt"));

				corporation.setCorporationRepresentativeName(request.getParameter("CorporationRepresentativeName_txt"));

				/** 登録判定 */
				List<String> errorList = Check.checkCorporation(corporation);

				if (errorList.size() > 0) {

					request.setAttribute("errorList", errorList);

					servletPath = "/inf_corporation/registerInput.jsp";

				} else {

					session.setAttribute("corporation", corporation);

					servletPath = "/inf_corporation/registerCheck.jsp";

				}

			} else if ("CorporationRegisterComplete_btn".equals(request.getParameter("action"))) {

				/** 企業情報 */
				Corporation corporation = (Corporation) session.getAttribute("corporation");

				CorporationDao.insert(corporation);

				servletPath = "/inf_corporation/registerComplete.jsp";

			} else if ("CorporationUpdateInput_btn".equals(request.getParameter("action"))) {

				servletPath = "/inf_corporation/updateInput.jsp";

			} else if ("CorporationUpdate_btn".equals(request.getParameter("action"))) {

				/** チェックボックスのvalue情報 */
				String[] checkList = request.getParameterValues("InfCorporation_chk");

				session.setAttribute("selectedCheckList", checkList);

				List<String> errorList = new ArrayList<>();

				/** 企業情報一覧の企業情報 */
				List<Corporation> corporationList = (List<Corporation>) session.getAttribute("corporationList");

				/** チェックボックス未選択エラーフラグ */
				errorList = Check.UpdateCheckbox(checkList, 2);

				if (errorList.size() > 0) {

					request.setAttribute("errorList", errorList);

					servletPath = "/inf_corporation/list.jsp";

				} else {

					for (String check : checkList) {

						for (Corporation corporation : corporationList) {

							if (Integer.parseInt(check) == corporation.getCorporationNo()) {

								session.setAttribute("corporation", corporation);

								break;

							}

						}

					}

					servletPath = "/inf_corporation/updateInput.jsp";

				}

			} else if ("CorporationUpdateCheck_btn".equals(request.getParameter("action"))) {

				/** 企業情報 */
				Corporation corporation = (Corporation) session.getAttribute("corporation");

				/** 企業タイトル */
				corporation.setCorporationName(request.getParameter("CorporationName_txt"));

				/** 企業内容 */
				corporation.setCorporationKanaName(request.getParameter("CorporationKanaName_txt"));

				/** 企業表示用ステータス */
				corporation.setCorporationPostalcode(request.getParameter("CorporationPostalcode_txt"));

				/** 表示・非表示用ステータス */
				corporation.setCorporationAddress(request.getParameter("CorporationAddress_txt"));

				/** 企業タイトル */
				corporation.setCorporationTel(request.getParameter("CorporationTel_txt"));

				/** 企業内容 */
				corporation.setCorporationFax(request.getParameter("CorporationFax_txt"));

				/** 企業タイトル */
				corporation.setCorporationRepresentative(request.getParameter("CorporationRepresentative_txt"));

				/** 企業内容 */
				corporation.setCorporationRepresentativeName(request.getParameter("CorporationRepresentativeName_txt"));

				/** 登録判定 */
				List<String> errorList = Check.checkCorporation(corporation);

				if (errorList.size() > 0) {

					request.setAttribute("errorList", errorList);

					servletPath = "/inf_corporation/updateInput.jsp";

				} else {

					session.setAttribute("corporation", corporation);

					servletPath = "/inf_corporation/updateCheck.jsp";

				}

			} else if ("CorporationUpdateComplete_btn".equals(request.getParameter("action"))) {

				Corporation corporation = (Corporation) session.getAttribute("corporation");

				/** update文を実行 */
				CorporationDao.update(corporation);

				/** セッション削除 */
				session.removeAttribute("selectedCheckList");

				servletPath = "/inf_corporation/updateComplete.jsp";

			} else if ("CorporationDelete_btn".equals(request.getParameter("action"))) {

				/** 削除対象の企業情報 */
				List<Corporation> corporationDeleteList = new ArrayList<Corporation>();

				/** チェックボックスのvalue情報 */
				String[] checkList = request.getParameterValues("InfCorporation_chk");

				session.setAttribute("selectedCheckList", checkList);

				List<String> errorList = new ArrayList<>();

				/** 企業情報一覧の企業情報 */
				List<Corporation> corporationList = (List<Corporation>) session.getAttribute("corporationList");

				/** チェックボックス未選択エラーフラグ */
				errorList = Check.DeleteCheckbox(checkList, 2);

				if (errorList.size() > 0) {

					request.setAttribute("errorList", errorList);

					servletPath = "/inf_corporation/list.jsp";

				} else {

					for (String check : checkList) {

						for (Corporation corporation : corporationList) {

							if (Integer.parseInt(check) == corporation.getCorporationNo()) {

								corporationDeleteList.add(corporation);

							}

						}

					}

					session.setAttribute("corporationDeleteList", corporationDeleteList);

					servletPath = "/inf_corporation/deleteCheck.jsp";

				}

			} else if ("CorporationDeleteComplete_btn".equals(request.getParameter("action"))) {

				List<Corporation> corporationList = (List<Corporation>) request.getSession()
						.getAttribute("corporationDeleteList");

				CorporationDao.delete(corporationList);

				/** セッション削除 */
				session.removeAttribute("selectedCheckList");

				servletPath = "/inf_corporation/deleteComplete.jsp";

			} else if ("BackMaintenance_btn".equals(request.getParameter("action"))) {

				servletPath = "/inf_maintenance/index.jsp";

			}

		}

		return servletPath;

	}

}
