/*
 *AttendanceAction.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (受講生管理業務)
 *クラス一覧：
 * NO クラス名 概要
 * 1 AttendanceAction 各アクションへ誘導するクラスです。
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

import jp.co.sqt.dao.AttendanceDao;
import jp.co.sqt.dao.CalenderDao;
import jp.co.sqt.dao.CommentDao;
import jp.co.sqt.dao.EducationDao;
import jp.co.sqt.dao.ReportDao;
import jp.co.sqt.dao.TestDao;
import jp.co.sqt.dao.TopicsDao;
import jp.co.sqt.entity.Account;
import jp.co.sqt.entity.Attendance;
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
public class AttendanceAction implements Action {

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
	@SuppressWarnings("unused")
	@Override
	public String doService(HttpServletRequest request, HttpServletResponse response) {

		/** セッション */
		HttpSession session = request.getSession(false);

		/** サーブレットパス */
		String servletPath = request.getServletPath();

		if (session == null || session.getAttribute("accountId") == null) {

			servletPath = "sessionLost.jsp";

		} else {

			if ("InfAttendance_btn".equals(request.getParameter("action"))) {

				/** 社員情報 */
				Education education = (Education) session.getAttribute("education2");

				Attendance attendance = new Attendance();

				String sdf1 = null;

				if (request.getParameter("month") == null) {

					/** 年月日 時分秒 */
					Date date = new Date();

					//				sdf1 = "04";
					sdf1 = new SimpleDateFormat("MM").format(date);

				} else {

					sdf1 = "0" + request.getParameter("month");

					session.setAttribute("monthSearch", request.getParameter("month"));

				}

				attendance.setAccountNo(education.getAccountNo());

				List<Attendance> attendanceList = AttendanceDao.checkAttendanceDate(education.getAccountNo());

				List<CalendarUnq> calenderList = null;

				if (education.getEnterningDate().substring(5, 7).equals("04")) {

					calenderList = CalenderDao.search(
							String.valueOf(session.getAttribute("year")),
							String.valueOf(session.getAttribute("startMonth4")),
							String.valueOf(session.getAttribute("endMonth4")), "ASC");

				} else {

					calenderList = CalenderDao.search(
							String.valueOf(session.getAttribute("year")),
							String.valueOf(session.getAttribute("startMonth10")),
							String.valueOf(session.getAttribute("endMonth10")), "ASC");

				}

				session.setAttribute("attendance", attendance);

				session.setAttribute("attendanceList", attendanceList);

				session.setAttribute("calenderList", calenderList);

				servletPath = "/inf_attendance/list.jsp";

			} else if ("AttendanceStart_btn".equals(request.getParameter("action"))) {

				Attendance attendance = new Attendance();

				Account account = (Account) session.getAttribute("account");

				/** エラーリスト */
				List<String> errorList = Check.checkAttendanceData(AttendanceDao.findAttendanceDate(account, 0), 0);

				if (errorList.size() > 0) {

					request.setAttribute("errorList2", errorList);

					servletPath = "/top.jsp";

				} else {

					/** 出退勤年月日 時分秒 */
					Date date = new Date();

					String sdf1 = new SimpleDateFormat("yyyy-MM-dd").format(date);

					String sdf2 = new SimpleDateFormat("HH:mm:ss").format(date);

					attendance.setAttendanceDate(sdf1);

					//			attendance.setAttendanceDate("2019-04-01");

					attendance.setAttendanceStart(sdf2);

					session.setAttribute("attendance", attendance);

					request.setAttribute("cmbFlg", 0);

					session.setAttribute("jspId", 0);

					servletPath = "/inf_attendance/registerInput.jsp";

				}

			} else if ("AttendanceEnd_btn".equals(request.getParameter("action"))) {

				Attendance attendance = new Attendance();

				Account account = (Account) session.getAttribute("account");

				/** エラーリスト */
				List<String> errorList = Check.checkAttendanceData(AttendanceDao.findAttendanceDate(account, 1), 1);

				if (errorList.size() > 0) {

					request.setAttribute("errorList2", errorList);

					servletPath = "/top.jsp";

				} else {
					/** 出退勤年月日 時分秒 */
					Date date = new Date();

					String sdf1 = new SimpleDateFormat("yyyy-MM-dd").format(date);

					String sdf2 = new SimpleDateFormat("HH:mm:ss").format(date);

					attendance.setAttendanceDate(sdf1);

					attendance.setAttendanceEnd(sdf2);

					session.setAttribute("attendance", attendance);

					request.setAttribute("cmbFlg", 0);

					session.setAttribute("jspId", 1);

					servletPath = "/inf_attendance/registerInput.jsp";

				}

			} else if ("AttendanceRegisterInput_btn".equals(request.getParameter("action"))) {

				Attendance attendance = (Attendance) session.getAttribute("attendance");

				if (request.getParameter("jspId").equals("0")) {

					request.setAttribute("cmbFlg", attendance.getAttendanceStartStatus());

				} else {

					request.setAttribute("cmbFlg", attendance.getAttendanceEndStatus());

				}

				session.setAttribute("attendance", attendance);

				servletPath = "/inf_attendance/registerInput.jsp";

			} else if ("AttendanceRegisterCheck_btn".equals(request.getParameter("action"))) {

				Attendance attendance = (Attendance) session.getAttribute("attendance");

				Account account = (Account) session.getAttribute("account");

				String status = request.getParameter("Status_cmb");

				attendance.setAttendanceNo(AttendanceDao.getLastNo() + 1);

				attendance.setAccountNo(account.getAccountNo());

				if (request.getParameter("jspId").equals("0")) {

					attendance.setAttendanceStartStatus(status);

					attendance.setAttendanceStartRemarks(Check.change(request.getParameter("Remarks_txt")));

				} else {

					attendance.setAttendanceEndStatus(status);

					attendance.setAttendanceEndRemarks(Check.change(request.getParameter("Remarks_txt")));

				}

				/** 登録判定 */
				List<String> errorList = Check.checkRegisterAttendance(attendance,
						Integer.parseInt(request.getParameter("jspId")));

				if (errorList.size() > 0) {

					request.setAttribute("cmbFlg", status);

					request.setAttribute("errorList", errorList);

					servletPath = "/inf_attendance/registerInput.jsp";

				} else {

					request.setAttribute("jspId", request.getParameter("jspId"));

					session.setAttribute("attendance", attendance);

					servletPath = "/inf_attendance/registerCheck.jsp";

				}

			} else if ("AttendanceRegisterComplete_btn".equals(request.getParameter("action"))) {

				/** 出退勤情報 */
				Attendance attendance = (Attendance) session.getAttribute("attendance");

				if (request.getParameter("jspId").equals("0")) {

					AttendanceDao.insert(attendance);

				} else {

					AttendanceDao.update(attendance);

				}

				session.setAttribute("jspId", request.getParameter("jspId"));

				servletPath = "/inf_attendance/registerComplete.jsp";

			} else if ("EducationTopSearch_btn".equals(request.getParameter("action"))) {

				session.setAttribute("topicsList", TopicsDao.findTopics("", "topics_date DESC", 1));

				Account account = (Account) session.getAttribute("account");

				Education education2 = EducationDao.search3(account.getAccountNo());

				/** 社員情報リスト */
				List<Education> education = EducationDao.search1(account.getCorporationNo(),
						account.getAccountAuthority());

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
