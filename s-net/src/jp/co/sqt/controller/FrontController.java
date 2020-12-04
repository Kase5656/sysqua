/*
 *FrontController.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (社員管理業務)
 *クラス一覧：
 * NO クラス名 概要
 * 1 FrontController 各アクションへ誘導するクラスです。
 *履歴：
 * NO 日付 Ver 更新者 内容
 * 1 2016/06/01 V1L1.0 SQT）加瀬 初版。
 */

package jp.co.sqt.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <dd>クラス名：Action中継クラス
 * <dd>クラス説明：全ての画面からの要求を受け付け、各Actionへ振り分けます。
 *
 * @version 1.00 2016/06/01
 * @author SQT）加瀬
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {

	/** 直列化ＩＤ */
	private static final long serialVersionUID = 1L;

	/**
	 * <dd>メソッド名：Action中継メソッド
	 * <dd>メソッド説明：全ての画面からの要求を受け付け、各Actionへ振り分けます。
	 *
	 * @param request
	 *            リクエスト
	 * @param response
	 *            レスポンス
	 * @exception ServletException
	 *                サーブレット内でエラーが発生した場合
	 * @exception IOException
	 *                入出力処理でエラーが発生した場合
	 */
	protected void doService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		response.setContentType("text/html; charset=UTF-8");

		if (request.getParameter("action") != null) {

			PropertiesGetAction.property(request, response);

			/** 移動先アクション */
			Action action = ActionFactory.getAction(request.getServletPath());

			/** 移動先ＵＲＬ */
			String forwardPath = action.doService(request, response);

			if (forwardPath != null) {

				request.getRequestDispatcher(forwardPath).forward(request, response);

			}

		} else {

			response.sendRedirect("index.jsp");

		}

	}

	/**
	 * <dd>メソッド名：Getメソッド
	 * <dd>メソッド説明：全ての画面からのGetメソッドを受け、doServiceメソッドを呼び出します。
	 *
	 * @param request
	 *            リクエスト
	 * @param response
	 *            レスポンス
	 * @exception ServletException
	 *                サーブレット内でエラーが発生した場合
	 * @exception IOException
	 *                入出力処理でエラーが発生した場合
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		response.setContentType("text/html; charset=UTF-8");

		PropertiesGetAction.property(request, response);

		/** 移動先アクション */
		Action action = ActionFactory.getAction(request.getParameter("pv1"));

		String forwardPath = null;

		if (action != null) {

			/** 移動先ＵＲＬ */
			forwardPath = action.doService(request, response);

			request.getRequestDispatcher(forwardPath).forward(request, response);

		} else {

			response.sendRedirect("index.jsp");

		}

		/*		doService(request, response);
		*/
	}

	/**
	 * <dd>メソッド名：Postメソッド
	 * <dd>メソッド説明：全ての画面からのPostメソッドを受け、doServiceメソッドを呼び出します。
	 *
	 * @param request
	 *            リクエスト
	 * @param response
	 *            レスポンス
	 * @exception ServletException
	 *                サーブレット内でエラーが発生した場合
	 * @exception IOException
	 *                入出力処理でエラーが発生した場合
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doService(request, response);

	}

}
