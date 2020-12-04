/*
 *ActionFactory.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (社員管理業務)
 *クラス一覧：
 * NO クラス名 概要
 * 1 ActionFactory 各アクションへ誘導するクラスです。
 *履歴：
 * NO 日付 Ver 更新者 内容
 * 1 2016/06/01 V1L1.0 SQT）加瀬 初版。
 */

package jp.co.sqt.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;

/**
 * <dd>クラス名：Action誘導クラス
 * <dd>クラス説明：web.xmlを読み込み、指定されたActionの情報を返します。
 *
 * @version 1.00 2016/06/01
 * @author SQT）加瀬
 */
@WebListener
public class ActionFactory implements ServletContextListener {

	/** コンテキスト情報 */
	private static ServletContext context;

	/**
	 * <dd>メソッド名：Action誘導メソッド
	 * <dd>メソッド説明：web.xmlで定義されたActionの情報を返します。
	 * <dd>備考：
	 *
	 * @param servletPath
	 *            サーブレットパス
	 * @return action web.xmlで定義されたAction
	 * @exception ServletException
	 *                インスタンスを生成できない場合 指定されたクラスにアクセスできない場合 指定されたクラスが見つからない場合
	 */
	public static Action getAction(String servletPath) throws ServletException {

		/** 移動先アクション */
		Action action = null;

		if (servletPath != null) {

			/** 移動先アクションクラス名 */
			String actioinClassName = context.getInitParameter(servletPath);

			try {

				action = (Action) Class.forName(actioinClassName).newInstance();

			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {

				throw new ServletException(e);

			}

		}

		return action;

	}

	/**
	 * <dd>メソッド名：Webアプリケーション起動時メソッド
	 * <dd>メソッド説明：Webアプリケーション起動時にコンテキスト情報を取得します。
	 *
	 * @param sce
	 *            Webアプリケーション情報
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {

		context = sce.getServletContext();

	}

	/**
	 * <dd>メソッド名：Webアプリケーション終了時メソッド
	 * <dd>メソッド説明：処理なし。
	 *
	 * @param sce
	 *            Webアプリケーション情報
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

}
