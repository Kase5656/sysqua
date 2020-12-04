/*
 *PropertiesGetAction.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (プロパティ取得)
 *クラス一覧：
 * NO クラス名 概要
 * 1 PropertiesGetAction 各プロパティを取得するクラスです。
 *履歴：
 * NO 日付 Ver 更新者 内容
 * 1 2020/01/01 V1L1.0 SQT）加瀬
 */
package jp.co.sqt.controller;

import java.util.ResourceBundle;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PropertiesGetAction
 */
@WebServlet("/PropertiesGetAction")
public class PropertiesGetAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PropertiesGetAction() {
		super();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	public static void property(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();

		ResourceBundle rb = ResourceBundle.getBundle("rms");

		session.setAttribute("serverFlg", rb.getString("serverFlg"));

		session.setAttribute("year", rb.getString("year"));

		session.setAttribute("startMonth4", rb.getString("startMonth4"));

		session.setAttribute("endMonth4", rb.getString("endMonth4"));

		session.setAttribute("testLastDate4", rb.getString("testLastDate4"));

		session.setAttribute("startMonth10", rb.getString("startMonth10"));

		session.setAttribute("endMonth10", rb.getString("endMonth10"));

		session.setAttribute("testLastDate10", rb.getString("testLastDate10"));

		session.setAttribute("end1Date4", rb.getString("end1Date4"));

		session.setAttribute("end2Date4", rb.getString("end2Date4"));

		session.setAttribute("end3Date4", rb.getString("end3Date4"));

		session.setAttribute("end1Date10", rb.getString("end1Date10"));

		session.setAttribute("end2Date10", rb.getString("end2Date10"));

		session.setAttribute("end3Date10", rb.getString("end3Date10"));

		session.setAttribute("questionLastDate", rb.getString("questionLastDate"));

		session.setAttribute("month4GoalDate4", rb.getString("month4GoalDate4"));

		session.setAttribute("month4GoalDate5", rb.getString("month4GoalDate5"));

		session.setAttribute("month4GoalDate6", rb.getString("month4GoalDate6"));

		session.setAttribute("month10GoalDate4", rb.getString("month10GoalDate4"));

		session.setAttribute("month10GoalDate5", rb.getString("month10GoalDate5"));

		session.setAttribute("month10GoalDate6", rb.getString("month10GoalDate6"));

		session.setAttribute("testUnqDate", rb.getString("testUnqDate"));

		session.setAttribute("testUnqDateTime", rb.getString("testUnqDateTime"));

		session.setAttribute("commentary4Date1", rb.getString("commentary4Date1"));

		session.setAttribute("commentary4Date2", rb.getString("commentary4Date2"));

		session.setAttribute("commentary4Date3", rb.getString("commentary4Date3"));

		session.setAttribute("commentary4Date4", rb.getString("commentary4Date4"));

		session.setAttribute("commentary4Date5", rb.getString("commentary4Date5"));

		session.setAttribute("commentary4Date6", rb.getString("commentary4Date6"));

		session.setAttribute("commentary4Date7", rb.getString("commentary4Date7"));

		session.setAttribute("commentary4Date8", rb.getString("commentary4Date8"));

		session.setAttribute("commentary4Date9", rb.getString("commentary4Date9"));

		session.setAttribute("commentary4Date10", rb.getString("commentary4Date10"));

		session.setAttribute("commentary4Date11", rb.getString("commentary4Date11"));

		session.setAttribute("commentary4Date12", rb.getString("commentary4Date12"));

		session.setAttribute("commentary4Date13", rb.getString("commentary4Date13"));

		session.setAttribute("commentary4Date14", rb.getString("commentary4Date14"));

		session.setAttribute("commentary10Date1", rb.getString("commentary10Date1"));

		session.setAttribute("commentary10Date2", rb.getString("commentary10Date2"));

		session.setAttribute("commentary10Date3", rb.getString("commentary10Date3"));

		session.setAttribute("commentary10Date4", rb.getString("commentary10Date4"));

		session.setAttribute("commentary10Date5", rb.getString("commentary10Date5"));

		session.setAttribute("commentary10Date6", rb.getString("commentary10Date6"));

		session.setAttribute("commentary10Date7", rb.getString("commentary10Date7"));

		session.setAttribute("commentary10Date8", rb.getString("commentary10Date8"));

		session.setAttribute("commentary10Date9", rb.getString("commentary10Date9"));

		session.setAttribute("commentary10Date10", rb.getString("commentary10Date10"));

		session.setAttribute("commentary10Date11", rb.getString("commentary10Date11"));

		session.setAttribute("commentary10Date12", rb.getString("commentary10Date12"));

		session.setAttribute("commentary10Date13", rb.getString("commentary10Date13"));

		session.setAttribute("commentary10Date14", rb.getString("commentary10Date14"));
	}

}
