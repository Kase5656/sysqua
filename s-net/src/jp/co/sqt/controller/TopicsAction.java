/*
 *TopicsAction.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (お知らせ管理業務)
 *クラス一覧：
 * NO クラス名 概要
 * 1 TopicsAction 各アクションへ誘導するクラスです。
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

import jp.co.sqt.dao.TopicsDao;
import jp.co.sqt.entity.Topics;

/**
 * <dd>クラス名：
 * <dd>クラス説明：
 *
 * @version 1.00 2016/06/01
 * @author SQT）加瀬
 */
public class TopicsAction implements Action {

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

			if ("InfTopics_btn".equals(request.getParameter("action"))) {

				/** お知らせ情報リスト */
				List<Topics> topicsList = TopicsDao.search("", "topics_no ASC");

				session.setAttribute("topicsList", topicsList);

				session.setAttribute("count", topicsList.size());

				servletPath = "inf_topics/list.jsp";

			} else if ("TopicsRegister_btn".equals(request.getParameter("action"))) {

				Topics topics = new Topics();

				session.setAttribute("topics", topics);

				servletPath = "/inf_topics/registerInput.jsp";

			} else if ("TopicsRegisterInput_btn".equals(request.getParameter("action"))) {

				servletPath = "/inf_topics/registerInput.jsp";

			} else if ("TopicsRegisterCheck_btn".equals(request.getParameter("action"))) {

				Topics topics = new Topics();

				topics.setTopicsNo(TopicsDao.getLastNo() + 1);

				/** お知らせ作成日時 */
				Date date = new Date();

				String sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);

				topics.setTopicsDate(sdf1);

				topics.setTopicsTitle(request.getParameter("TopicsTitle_txt"));

				topics.setTopicsContents(request.getParameter("TopicsContents_txt"));

				/** お知らせ表示用ステータス */
				topics.setTopicsFlg(Integer.parseInt(request.getParameter("Status_cmb")));

				topics.setDeleteFlg(0);

				/** 登録判定 */
				List<String> errorList = Check.checkTopics(topics);

				if (errorList.size() > 0) {

					request.setAttribute("errorList", errorList);

					servletPath = "/inf_topics/registerInput.jsp";

				} else {

					session.setAttribute("topics", topics);

					servletPath = "/inf_topics/registerCheck.jsp";

				}

			} else if ("TopicsRegisterComplete_btn".equals(request.getParameter("action"))) {

				/** お知らせ情報 */
				Topics topics = (Topics) session.getAttribute("topics");

				TopicsDao.insert(topics);

				servletPath = "/inf_topics/registerComplete.jsp";

			} else if ("TopicsUpdate_btn".equals(request.getParameter("action"))) {

				/** チェックボックスのvalue情報 */
				String[] checkList = request.getParameterValues("InfTopics_chk");

				session.setAttribute("selectedCheckList", checkList);

				List<String> errorList = new ArrayList<>();

				/** お知らせ情報一覧のお知らせ情報 */
				List<Topics> topicsList = (List<Topics>) session.getAttribute("topicsList");

				/** チェックボックス未選択エラーフラグ */
				errorList = Check.UpdateCheckbox(checkList, 1);

				if (errorList.size() > 0) {

					request.setAttribute("errorList", errorList);

					servletPath = "/inf_topics/list.jsp";

				} else {

					for (String check : checkList) {

						for (Topics topics : topicsList) {

							if (Integer.parseInt(check) == topics.getTopicsNo()) {

								session.setAttribute("topics", topics);

								break;

							}

						}

					}

					servletPath = "/inf_topics/updateInput.jsp";

				}

			} else if ("TopicsUpdateInput_btn".equals(request.getParameter("action"))) {

				servletPath = "/inf_topics/updateInput.jsp";

			} else if ("TopicsUpdateCheck_btn".equals(request.getParameter("action"))) {

				/** お知らせ情報 */
				Topics topics = (Topics) session.getAttribute("topics");

				/*			topics.setTopicsNo(topics.getTopicsNo());
				*/
				/** お知らせタイトル */
				topics.setTopicsTitle(request.getParameter("TopicsTitle_txt"));

				/** お知らせ内容 */
				topics.setTopicsContents(request.getParameter("TopicsContents_txt"));

				/** お知らせ表示用ステータス */
				topics.setTopicsFlg(Integer.parseInt(request.getParameter("Status_cmb")));

				/** 表示・非表示用ステータス */
				topics.setDeleteFlg(Integer.parseInt(request.getParameter("deleteStatus_cmb")));

				/** 登録判定 */
				List<String> errorList = Check.checkTopics(topics);

				if (errorList.size() > 0) {

					request.setAttribute("errorList", errorList);

					servletPath = "/inf_topics/updateInput.jsp";

				} else {

					session.setAttribute("topics", topics);

					servletPath = "/inf_topics/updateCheck.jsp";

				}

			} else if ("TopicsUpdateComplete_btn".equals(request.getParameter("action"))) {

				Topics topics = (Topics) session.getAttribute("topics");

				/** update文を実行 */
				TopicsDao.update(topics);

				/** セッション削除 */
				session.removeAttribute("selectedCheckList");

				servletPath = "/inf_topics/updateComplete.jsp";

			} else if ("TopicsDelete_btn".equals(request.getParameter("action"))) {

				/** 削除対象のお知らせ情報 */
				List<Topics> topicsDeleteList = new ArrayList<Topics>();

				/** チェックボックスのvalue情報 */
				String[] checkList = request.getParameterValues("InfTopics_chk");

				session.setAttribute("selectedCheckList", checkList);

				List<String> errorList = new ArrayList<>();

				/** お知らせ情報一覧のお知らせ情報 */
				List<Topics> topicsList = (List<Topics>) session.getAttribute("topicsList");

				/** チェックボックス未選択エラーフラグ */
				errorList = Check.DeleteCheckbox(checkList, 1);

				if (errorList.size() > 0) {

					request.setAttribute("errorList", errorList);

					servletPath = "/inf_topics/list.jsp";

				} else {

					for (String check : checkList) {

						for (Topics topics : topicsList) {

							if (Integer.parseInt(check) == topics.getTopicsNo()) {

								topicsDeleteList.add(topics);

							}

						}

					}

					session.setAttribute("topicsDeleteList", topicsDeleteList);

					servletPath = "/inf_topics/deleteCheck.jsp";

				}

			} else if ("TopicsDeleteComplete_btn".equals(request.getParameter("action"))) {

				List<Topics> topicsList = (List<Topics>) request.getSession().getAttribute("topicsDeleteList");

				TopicsDao.delete(topicsList);

				servletPath = "/inf_topics/deleteComplete.jsp";

			} else if ("BackMaintenance_btn".equals(request.getParameter("action"))) {

				servletPath = "/inf_maintenance/index.jsp";

			}

		}

		return servletPath;

	}

}
