/*
 *EducationAction.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (受講生管理業務)
 *クラス一覧：
 * NO クラス名 概要
 * 1 EducationAction 各アクションへ誘導するクラスです。
 *履歴：
 * NO 日付 Ver 更新者 内容
 * 1 2016/06/01 V1L1.0 SQT）加瀬 初版。
 */

package jp.co.sqt.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.sqt.dao.CalenderDao;
import jp.co.sqt.dao.CommentDao;
import jp.co.sqt.dao.CorporationDao;
import jp.co.sqt.dao.DutiesDao;
import jp.co.sqt.dao.EducationDao;
import jp.co.sqt.dao.LoginDao;
import jp.co.sqt.dao.ReportDao;
import jp.co.sqt.dao.TestDao;
import jp.co.sqt.dao.TopicsDao;
import jp.co.sqt.entity.Account;
import jp.co.sqt.entity.CalendarUnq;
import jp.co.sqt.entity.Comment;
import jp.co.sqt.entity.Education;
import jp.co.sqt.entity.Report;
import jp.co.sqt.entity.Test;

/**
 * <dd>クラス名：受講生検索情報受け渡しクラス
 * <dd>クラス説明：検索条件入力/検索一覧画面より受け取った検索条件をDaoへ受け渡します。 検索条件を正しい値かチェックします。
 *
 * @version 1.00 2016/06/01
 * @author SQT）加瀬
 */
public class EducationAction implements Action {

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

			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.addHeader("Cache-Control", "no-store");
			response.setDateHeader("Expires", 0);
			session.invalidate();
			servletPath = "sessionLost.jsp";

		} else {

			if ("InfEducation_btn".equals(request.getParameter("action"))) {

				/** 受講生情報リスト */
				List<Education> educationList = EducationDao.search("", "0", "0", "0", "education_kananame");

				session.setAttribute("educationList", educationList);

				session.setAttribute("count", educationList.size());

				session.setAttribute("corporationList", CorporationDao.findAll());

				servletPath = "inf_education/list.jsp";

			} else if ("EducationTopSearch_btn".equals(request.getParameter("action"))) {

				/** 社員情報 */
				Education education = new Education();

				String[] edu = request.getParameter("Education_cmb").split("/");

				List<String> errorList = Check.checkEducationSelect(edu[0]);

				Education education2 = (Education) EducationDao.search3(Integer.parseInt(edu[0]));

				Account account = (Account) session.getAttribute("account");

				if (account.getAccountAuthority() == 0) {

					session.setAttribute("JspFlg", 0);

				} else if (account.getAccountAuthority() == 1) {

					session.setAttribute("JspFlg", 1);

				} else if (account.getAccountAuthority() == 2) {

					session.setAttribute("JspFlg", 2);

				}

				if (errorList.size() > 0) {

					request.setAttribute("errorList", errorList);

					/** 社員情報リスト */
					List<Education> educationList = EducationDao.search1(account.getCorporationNo(),
							account.getAccountAuthority());

					session.setAttribute("education", educationList);

					Date date = new Date();

					String sdf1 = new SimpleDateFormat("yyyy/MM/dd").format(date);

					SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd");

					if (account.getAccountAuthority() == 2) {

						boolean attendanceflg = false;

						if (education2.getEnterningDate().substring(5, 7).equals("04")) {

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

								*/ } else {

								session.setAttribute("end1date", 0);

								session.setAttribute("end2date", 0);

								session.setAttribute("end3date", 0);

							}

						}

						session.setAttribute("attendanceflg", attendanceflg);

					}

					servletPath = "/top.jsp";

				} else {

					/** 解答年月日 時分秒 */
					education = EducationDao.search3(Integer.parseInt(edu[0]));

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
					List<Report> reportList = ReportDao.checkReportDetail2(Integer.parseInt(edu[0]));

					/*					List<Comment> commentList = CommentDao.checkComment(Integer.parseInt(edu[0]));
					*/ List<Comment> commentList = CommentDao.checkComment2(Integer.parseInt(edu[0]));

					boolean flg = false;

					boolean chk = false;

					List<String> result = new ArrayList<String>();

					List<String> result2 = new ArrayList<String>();

					List<String> result3 = new ArrayList<String>();

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

								if (cal.getCalenderOnDate().equals(test.getTestDate().replaceAll("-", "/"))) {

									if (education.getEnterningDate().substring(5, 7).equals("04")) {

										if (cal.getCalenderOnDate()
												.equals(String.valueOf(session.getAttribute("testLastDate4")))) {

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

							if (cal.getCalenderOnDate().equals(report.getReportDate().replaceAll("-", "/"))) {

								flg = true;

								result2.add("実施済み");

								break;

							}

						}

						if (!flg) {

							result2.add("未実施");

						}

					}

					// コメント一覧
					for (CalendarUnq cal : calenderList) {

						flg = false;

						for (Comment comment : commentList) {

							if (cal.getCalenderOnDate().equals(comment.getReportDate())) {

								flg = true;

								result3.add("コメント数：" + comment.getCommentCnt() + "<br />" + "最終コメント日時："
										+ comment.getCommentDate());

								break;

							}

						}

						if (!flg) {

							result3.add("");

						}

					}

					session.setAttribute("education2", education2);

					session.setAttribute("result", result);

					session.setAttribute("result2", result2);

					session.setAttribute("result3", result3);

					session.setAttribute("calenderList", calenderList);

					servletPath = "/detail.jsp";

				}

			} else if ("EducationDetailSearch_btn".equals(request.getParameter("action"))) {

				/** 社員情報 */
				Education education = new Education();

				Account account = (Account) session.getAttribute("account");

				if (account.getAccountAuthority() == 0) {

					session.setAttribute("JspFlg", 0);

				} else if (account.getAccountAuthority() == 1) {

					session.setAttribute("JspFlg", 1);

				} else if (account.getAccountAuthority() == 2) {

					session.setAttribute("JspFlg", 2);

				}

				String month = request.getParameter("month");

				education = EducationDao.search3(Integer.parseInt(request.getParameter("accountNo")));

				session.setAttribute("monthSearch", month);

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

				List<Report> reportList = ReportDao
						.checkReportDetail2(Integer.parseInt(request.getParameter("accountNo")));

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

					if (account.getEnterningDate().substring(5, 7).equals("04")) {

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
											.equals(String.valueOf(session.getAttribute("testLastDate4")))) {

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

				servletPath = "/detail.jsp";

			} else if ("EducationRegister_btn".equals(request.getParameter("action"))) {

				/** 受講生情報 */
				Education education = new Education();

				/** アカウント情報 */
				Account account = (Account) session.getAttribute("accountEditing");

				education.setCorporation(account.getCorporation());

				session.setAttribute("education", education);

				session.setAttribute("dutiesList", DutiesDao.findAll());

				servletPath = "/inf_education/registerInput.jsp";

			} else if ("EducationRegisterInput_btn".equals(request.getParameter("action"))) {

				servletPath = "/inf_education/registerInput.jsp";

			} else if ("EducationRegisterCheck_btn".equals(request.getParameter("action"))) {

				Education education = new Education();

				/** アカウント情報 */
				Account account = (Account) session.getAttribute("accountEditing");

				education.setEducationNo(EducationDao.getLastId() + 1);

				education.setAccountNo(account.getAccountNo());

				education.setEducationName(request.getParameter("EducationName_txt"));

				education.setEducationKanaName(request.getParameter("EducationKanaName_txt"));

				education.setEducationKanaName(request.getParameter("EducationKanaName_txt"));

				education.setEducationGender(Integer.parseInt(request.getParameter("Gender_rdo")));

				education.setEducationBirthday(request.getParameter("Birthday_txt"));

				education.setEducationPostalcode(request.getParameter("PostalCode_txt"));

				education.setEducationAddress(request.getParameter("Address_txt"));

				education.setEducationPhoneNumber(request.getParameter("Phone_txt"));

				education.setEducationEmailAddress(request.getParameter("EmailAddress_txt"));

				education.setCorporation(account.getCorporation());

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

				session.setAttribute("education", education);

				/** 登録判定 */
				List<String> errorList = Check.checkEducation(education, true);

				if (errorList.size() > 0) {

					request.setAttribute("errorList", errorList);

					servletPath = "/inf_education/registerInput.jsp";

				} else {

					servletPath = "/inf_education/registerCheck.jsp";

				}

			} else if ("EducationRegisterComplete_btn".equals(request.getParameter("action"))) {

				/** 受講生情報 */
				Education education = (Education) session.getAttribute("education");

				EducationDao.insert(education);

				servletPath = "/inf_education/registerComplete.jsp";

			} else if ("EducationUpdate_btn".equals(request.getParameter("action"))) {

				/** チェックボックスのvalue情報 */
				String[] checkList = request.getParameterValues("InfEducation_chk");

				session.setAttribute("selectedCheckList", checkList);

				List<String> errorList = new ArrayList<>();

				/** 受講生情報一覧の受講生情報 */
				List<Education> educationList = (List<Education>) session.getAttribute("educationList");

				/** チェックボックス未選択エラーフラグ */
				errorList = Check.UpdateCheckbox(checkList, 3);

				if (errorList.size() > 0) {

					request.setAttribute("errorList", errorList);

					servletPath = "/inf_education/list.jsp";

				} else {

					for (String check : checkList) {

						for (Education education : educationList) {

							if (Integer.parseInt(check) == education.getEducationNo()) {

								session.setAttribute("education", education);

								break;

							}

						}

					}

					session.setAttribute("corporationList", CorporationDao.findAll());

					session.setAttribute("dutiesList", DutiesDao.findAll());

					servletPath = "/inf_education/updateInput.jsp";

				}

			} else if ("EducationUpdateInput_btn".equals(request.getParameter("action"))) {

				servletPath = "/inf_education/updateInput.jsp";

			} else if ("EducationUpdateCheck_btn".equals(request.getParameter("action"))) {

				/** 受講生情報 */
				Education education = (Education) session.getAttribute("education");

				/*
				 * education.setAccountNo(Integer.parseInt(request.getParameter(
				 * "AccoutNo_txt")));
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

				List<String> errorList = Check.checkEducation(education, true);

				if (errorList.size() > 0) {

					request.setAttribute("errorList", errorList);

					servletPath = "/inf_education/updateInput.jsp";

				} else {

					servletPath = "/inf_education/updateCheck.jsp";

				}

			} else if ("EducationUpdateComplete_btn".equals(request.getParameter("action"))) {

				Education education = (Education) session.getAttribute("education");

				/** update文を実行 */
				EducationDao.update(education);

				/** セッション削除 */
				session.removeAttribute("selectedCheckList");

				servletPath = "/inf_education/updateComplete.jsp";

			} else if ("EducationTopBack_btn".equals(request.getParameter("action"))) {

				String accountId = request.getParameter("NowloginId");

				/** アカウント情報リスト */
				Account account = LoginDao.findAccount(accountId, 0);

				Education education2 = EducationDao.search3(Integer.parseInt(request.getParameter("accountNo")));

				session.setAttribute("account", account);

				session.setAttribute("topicsList", TopicsDao.findTopics("", "topics_date DESC", 1));

				/** 社員情報リスト */
				List<Education> education = EducationDao.search1(account.getCorporationNo(),
						account.getAccountAuthority());

				if (account.getAccountAuthority() == 0) {

					session.setAttribute("JspFlg", 0);

				} else if (account.getAccountAuthority() == 1) {

					session.setAttribute("JspFlg", 1);

				} else if (account.getAccountAuthority() == 2) {

					session.setAttribute("JspFlg", 2);

				}

				session.setAttribute("education", education);

				Date date = new Date();

				String sdf1 = new SimpleDateFormat("yyyy/MM/dd").format(date);

				SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd");

				if (account.getAccountAuthority() == 2) {

					boolean attendanceflg = false;

					if (education2.getEnterningDate().substring(5, 7).equals("04")) {

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

							/*							attendanceflg = true;

							*/ } else {

							session.setAttribute("end1date", 0);

							session.setAttribute("end2date", 0);

							session.setAttribute("end3date", 0);

						}

					}

					session.setAttribute("attendanceflg", attendanceflg);

				}

				servletPath = "/top.jsp";

			} else if ("Training_btn".equals(request.getParameter("action"))) {

				servletPath = "/inf_education/trainingmanual.jsp";

			} else if ("Meeting_btn".equals(request.getParameter("action"))) {

				servletPath = "/inf_education/meetingmanual.jsp";

			} else if ("BackMaintenance_btn".equals(request.getParameter("action"))) {

				servletPath = "/inf_maintenance/index.jsp";

			}

		}

		return servletPath;

	}

}
