/*
 *InterviewAction.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (面談情報管理業務)
 *クラス一覧：
 * NO クラス名 概要
 * 1 InterviewAction 各アクションへ誘導するクラスです。
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
import jp.co.sqt.dao.EducationDao;
import jp.co.sqt.dao.InterviewDao;
import jp.co.sqt.dao.ReportDao;
import jp.co.sqt.dao.TestDao;
import jp.co.sqt.entity.Account;
import jp.co.sqt.entity.CalendarUnq;
import jp.co.sqt.entity.Comment;
import jp.co.sqt.entity.Education;
import jp.co.sqt.entity.Interview;
import jp.co.sqt.entity.Report;
import jp.co.sqt.entity.Test;

/**
 * <dd>クラス名：面談情報検索情報受け渡しクラス
 * <dd>クラス説明：検索条件入力/検索一覧画面より受け取った検索条件をDaoへ受け渡します。 検索条件を正しい値かチェックします。
 *
 * @version 1.00 2016/06/01
 * @author SQT）加瀬
 */
public class InterviewAction implements Action {

	/**
	 * <dd>メソッド名：面談情報検索情報受け渡しメソッド
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

			if ("InfInterview_btn".equals(request.getParameter("action"))) {

				/** 面談情報リスト */
				List<Interview> interviewList = InterviewDao.search("", "ASC");

				session.setAttribute("interviewList", interviewList);

				session.setAttribute("count", interviewList.size());

				servletPath = "/inf_interview/list.jsp";

				//		} else if ("InterviewSearch_btn".equals(request.getParameter("action"))) {
				//
				//			/** 面談情報リスト */
				//			List<Interview> interviewList;
				//
				//			/** 面談名 */
				//			String interviewName = request.getParameter("InterviewName_txt");
				//
				//			session.setAttribute("interviewNameSearch", interviewName);
				//
				//			/** 並び替え列名 */
				//			String order = null;
				//
				//			if ("interview_name1".equals(request.getParameter("Order_cmb"))) {
				//
				//				order = "ASC";
				//
				//			} else {
				//
				//				order = "DESC";
				//
				//			}
				//
				//			session.setAttribute("orderSearch", request.getParameter("Order_cmb"));
				//
				//			interviewList = InterviewDao.search(interviewName, order);
				//
				//			session.setAttribute("interviewList", interviewList);
				//
				//			session.setAttribute("count", interviewList.size());
				//
				//			servletPath = "/inf_interview/list.jsp";
				//
			} else if ("InterviewRegister_btn".equals(request.getParameter("action"))) {

				/** 面談情報 */
				Interview interview = new Interview();

				session.setAttribute("interview", interview);

				/** 社員情報リスト */
				List<Education> education = EducationDao.search1(0, 0);

				session.setAttribute("education", education);

				servletPath = "/inf_interview/adminregisterInput.jsp";

				/** 面談情報登録確認画面からの遷移 */
			} else if ("InterviewRegisterInput_btn".equals(request.getParameter("action"))) {

				servletPath = "/inf_interview/adminregisterInput.jsp";

			} else if ("InterviewRegisterCheck_btn".equals(request.getParameter("action"))) {

				/** 面談情報 */
				Interview interview = new Interview();

				interview.setInterviewNo(InterviewDao.getLastNo() + 1);

				String[] edu = request.getParameter("Education_cmb").split("/");

				interview.setAccountNo(Integer.parseInt(edu[0]));

				interview.setCorporationNo(Integer.parseInt(edu[1]));

				interview.setEducationName(edu[2]);

				interview.setAccountInformation(request.getParameter("AccountInformation_txt"));

				interview.setInterviewDate1(request.getParameter("InterviewDate1_txt"));

				interview.setInterviewEduContents1(request.getParameter("InterviewEduContents1_txt"));

				interview.setInterviewTraContents1(request.getParameter("InterviewTraContents1_txt"));

				interview.setInterviewContents1(request.getParameter("InterviewContents1_txt"));

				interview.setInterviewDate2(request.getParameter("InterviewDate2_txt"));

				interview.setInterviewEduContents2(request.getParameter("InterviewEduContents2_txt"));

				interview.setInterviewTraContents2(request.getParameter("InterviewTraContents2_txt"));

				interview.setInterviewContents2(request.getParameter("InterviewContents2_txt"));

				interview.setInterviewDate3(request.getParameter("InterviewDate3_txt"));

				interview.setInterviewEduContents3(request.getParameter("InterviewEduContents3_txt"));

				interview.setInterviewTraContents3(request.getParameter("InterviewTraContents3_txt"));

				interview.setInterviewContents3(request.getParameter("InterviewContents3_txt"));

				/** 登録判定 */
				List<String> errorList = Check.checkInterview(interview);

				if (errorList.size() > 0) {

					request.setAttribute("errorList", errorList);

					servletPath = "/inf_interview/adminregisterInput.jsp";

				} else {

					session.setAttribute("interview", interview);

					servletPath = "/inf_interview/adminregisterCheck.jsp";

				}

			} else if ("InterviewRegisterComplete_btn".equals(request.getParameter("action"))) {

				/** 面談情報 */
				Interview interview = (Interview) session.getAttribute("interview");

				InterviewDao.insert(interview);

				servletPath = "/inf_interview/adminregisterComplete.jsp";

			} else if ("InterviewUpdate_btn".equals(request.getParameter("action"))) {

				/** チェックボックスのvalue情報 */
				String[] checkList = request.getParameterValues("InfInterview_chk");

				session.setAttribute("selectedCheckList", checkList);

				List<String> errorList = new ArrayList<>();

				/** 面談情報一覧の面談情報 */
				List<Interview> interviewList = (List<Interview>) session.getAttribute("interviewList");

				/** チェックボックス未選択エラーフラグ */
				errorList = Check.UpdateCheckbox(checkList, 5);

				if (errorList.size() > 0) {

					request.setAttribute("errorList", errorList);

					servletPath = "/inf_interview/list.jsp";

				} else {

					for (String check : checkList) {

						for (Interview interview : interviewList) {

							if (Integer.parseInt(check) == interview.getInterviewNo()) {

								session.setAttribute("interview", interview);

								break;

							}

						}

					}

					servletPath = "/inf_interview/adminupdateInput.jsp";

				}

			} else if ("InterviewUpdateInput_btn".equals(request.getParameter("action"))) {

				servletPath = "/inf_interview/adminupdateInput.jsp";

			} else if ("InterviewUpdateCheck_btn".equals(request.getParameter("action"))) {

				/** 面談情報 */
				Interview interview = (Interview) session.getAttribute("interview");

				interview.setAccountInformation(request.getParameter("AccountInformation_txt"));

				interview.setInterviewDate1(request.getParameter("InterviewDate1_txt"));

				interview.setInterviewEduContents1(request.getParameter("InterviewEduContents1_txt"));

				interview.setInterviewTraContents1(request.getParameter("InterviewTraContents1_txt"));

				interview.setInterviewContents1(request.getParameter("InterviewContents1_txt"));

				interview.setInterviewDate2(request.getParameter("InterviewDate2_txt"));

				interview.setInterviewEduContents2(request.getParameter("InterviewEduContents2_txt"));

				interview.setInterviewTraContents2(request.getParameter("InterviewTraContents2_txt"));

				interview.setInterviewContents2(request.getParameter("InterviewContents2_txt"));

				interview.setInterviewDate3(request.getParameter("InterviewDate3_txt"));

				interview.setInterviewEduContents3(request.getParameter("InterviewEduContents3_txt"));

				interview.setInterviewTraContents3(request.getParameter("InterviewTraContents3_txt"));

				interview.setInterviewContents3(request.getParameter("InterviewContents3_txt"));

				List<String> errorList = Check.checkInterview(interview);

				if (errorList.size() > 0) {

					request.setAttribute("errorList", errorList);

					servletPath = "/inf_interview/adminupdateInput.jsp";

				} else {

					session.setAttribute("interview", interview);

					servletPath = "/inf_interview/adminupdateCheck.jsp";

				}

			} else if ("InterviewUpdateComplete_btn".equals(request.getParameter("action"))) {

				Interview interview = (Interview) session.getAttribute("interview");

				InterviewDao.update(interview, 0);

				/** セッション削除 */
				session.removeAttribute("selectedCheckList");

				servletPath = "/inf_interview/adminupdateComplete.jsp";

			} else if ("InterviewDelete_btn".equals(request.getParameter("action"))) {

				/** 削除対象の面談情報 */
				List<Interview> interviewDeleteList = new ArrayList<Interview>();

				/** チェックボックスのvalue情報 */
				String[] checkList = request.getParameterValues("InfInterview_chk");

				session.setAttribute("selectedCheckList", checkList);

				List<String> errorList = new ArrayList<>();

				/** 面談情報一覧の面談情報 */
				List<Interview> interviewList = (List<Interview>) session.getAttribute("interviewList");

				/** チェックボックス未選択エラーフラグ */
				errorList = Check.DeleteCheckbox(checkList, 3);

				if (errorList.size() > 0) {

					request.setAttribute("errorList", errorList);

					servletPath = "/inf_interview/list.jsp";

				} else {

					for (String check : checkList) {

						for (Interview interview : interviewList) {

							if (Integer.parseInt(check) == interview.getInterviewNo()) {

								interviewDeleteList.add(interview);

							}

						}

					}

					session.setAttribute("interviewDeleteList", interviewDeleteList);

					servletPath = "/inf_interview/admindeleteCheck.jsp";

				}

			} else if ("InterviewDeleteComplete_btn".equals(request.getParameter("action"))) {

				List<Interview> interviewList = (List<Interview>) request.getSession()
						.getAttribute("interviewDeleteList");

				InterviewDao.delete(interviewList);

				/** セッション削除 */
				session.removeAttribute("selectedCheckList");

				servletPath = "/inf_interview/admindeleteComplete.jsp";

			} else if ("BackMaintenance_btn".equals(request.getParameter("action"))) {

				servletPath = "/inf_maintenance/index.jsp";

			} else if ("InterviewEducation_btn".equals(request.getParameter("action"))) {

				Account account = (Account) session.getAttribute("account");

				Interview interview = new Interview();

				if (InterviewDao.getCnt(account.getAccountNo()) != 0) {

					interview = InterviewDao.findSearch(account.getAccountNo());

				}

				session.setAttribute("interview", interview);

				servletPath = "/inf_interview/educationregisterInput.jsp";

			} else if ("InterviewEducationRegisterCheck_btn".equals(request.getParameter("action"))) {

				Account account = (Account) session.getAttribute("account");

				Interview interview = new Interview();

				if (InterviewDao.getCnt(account.getAccountNo()) == 0) {

					interview.setInterviewNo(InterviewDao.getLastNo() + 1);

					interview.setAccountNo(account.getAccountNo());

				} else {

					interview = (Interview) session.getAttribute("interview");

				}

				interview.setInterviewDate1(request.getParameter("InterviewDate1_txt"));

				interview.setInterviewEduContents1(request.getParameter("InterviewEduContents1_txt"));

				interview.setInterviewDate2(request.getParameter("InterviewDate2_txt"));

				interview.setInterviewEduContents2(request.getParameter("InterviewEduContents2_txt"));

				interview.setInterviewDate3(request.getParameter("InterviewDate3_txt"));

				interview.setInterviewEduContents3(request.getParameter("InterviewEduContents3_txt"));

				List<String> errorList = Check.checkInterview(interview);

				if (errorList.size() > 0) {

					request.setAttribute("errorList", errorList);

					servletPath = "/inf_interview/educationregisterInput.jsp";

				} else {

					session.setAttribute("interview", interview);

					servletPath = "/inf_interview/educationregisterCheck.jsp";

				}

			} else if ("InterviewEducationRegisterComplete_btn".equals(request.getParameter("action"))) {

				Account account = (Account) session.getAttribute("account");

				Interview interview = (Interview) session.getAttribute("interview");

				if (InterviewDao.getCnt(account.getAccountNo()) == 0) {

					InterviewDao.insert(interview);

				} else {

					InterviewDao.update(interview, 1);

				}

				servletPath = "/inf_interview/educationregisterComplete.jsp";

			} else if ("InterviewEducationRegisterInput_btn".equals(request.getParameter("action"))) {

				servletPath = "/inf_interview/educationregisterInput.jsp";

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

			}

		}

		return servletPath;

	}

}
