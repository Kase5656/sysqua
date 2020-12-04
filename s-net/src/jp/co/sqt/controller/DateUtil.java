/*
 *DateUtil.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (社員管理業務)
 *クラス一覧：
 * NO クラス名 概要
 * 1 DateUtil 各アクションへ誘導するクラスです。
 *履歴：
 * NO 日付 Ver 更新者 内容
 * 1 2016/06/01 V1L1.0 SQT）加瀬 初版。
 */

package jp.co.sqt.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <dd>クラス名：年月処理クラス
 * <dd>クラス説明：年月の処理を行います。
 *
 * @version 1.00 2016/06/01
 * @author SQT）加瀬
 *
 */
public class DateUtil {

	/**
	 * <dd>メソッド名：年取得メソッド
	 * <dd>メソッド説明：現在の年を取得します。
	 *
	 * @return sdf 取得した現在の年
	 */
	public static String getCurrentYear() {

		/** 年 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");

		return sdf.format(new Date());

	}

	/**
	 * <dd>メソッド名：月取得メソッド
	 * <dd>メソッド説明：現在の月を取得します。
	 *
	 * @return sdf 取得した現在の月
	 */
	public static String getCurrentMonth() {

		/** 月 */
		SimpleDateFormat sdf = new SimpleDateFormat("MM");

		return sdf.format(new Date());

	}

	/**
	 * <dd>メソッド名：月変更
	 * <dd>メソッド説明：月の入力値が1桁の場合、10の位に0を付与します。
	 *
	 * @param month
	 *            月の入力値
	 * @return month 変更した月の値
	 */
	public static String getMonth(String month) {

		/** 付与文 */
		String month0 = "0";

		if (month.length() == 1) {

			month = month0 + month;

		}

		return month;

	}

	public static int getDateDiff(String dateFromStrig, String dateToString) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

		Date dateTo = null;

		Date dateFrom = null;

		// Date型に変換
		try {

			dateFrom = sdf.parse(dateFromStrig);

			dateTo = sdf.parse(dateToString);

		} catch (java.text.ParseException e) {

			e.printStackTrace();

		}

		// 差分の日数を計算する
		long dateTimeTo = dateTo.getTime();

		long dateTimeFrom = dateFrom.getTime();

		long dayDiff = (dateTimeTo - dateTimeFrom) / (1000 * 60 * 60 * 24);

		return (int) dayDiff;

	}

}
