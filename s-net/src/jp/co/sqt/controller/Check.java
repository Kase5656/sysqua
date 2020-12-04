/*
 *Check.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (受講生管理業務)
 *クラス一覧：
 * NO クラス名 概要
 * 1 Check 各アクションへ誘導するクラスです。
 *履歴：
 * NO 日付 Ver 更新者 内容
 * 1 2016/06/01 V1L1.0 SQT）加瀬 初版。
 */

package jp.co.sqt.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.sqt.dao.AccountDao;
import jp.co.sqt.dao.LoginDao;
import jp.co.sqt.entity.Account;
import jp.co.sqt.entity.Attendance;
import jp.co.sqt.entity.Corporation;
import jp.co.sqt.entity.Duties;
import jp.co.sqt.entity.Education;
import jp.co.sqt.entity.Interview;
import jp.co.sqt.entity.Report;
import jp.co.sqt.entity.TechnologyLevel;
import jp.co.sqt.entity.Topics;

/**
 * <dd>クラス名：入力値妥当性検証クラス
 * <dd>クラス説明：登録機能、変更機能、検索機能の入力値を受け取り、妥当性検証をします。 検証の結果によりエラー文を返します。
 *
 * @version 1.00 2016/06/01
 * @author SQT）加瀬
 *
 */
public class Check {

	static String accountId = "";
	static String accountRePassword = "";
	static String accountPassword = "";

	public static List<String> checkLogin(String accountId, String accountPassword) {

		/** 検索エラー文 */
		List<String> errorList = new ArrayList<String>();

		/** ユーザID */
		accountId = (accountId.replaceAll("　", " ")).trim();

		/** ログインPassword */
		accountPassword = (accountPassword.replaceAll("　", " ")).trim();

		if (accountId.equals("") || accountPassword.equals("")) {

			if (accountId.equals("")) {

				errorList.add("ユーザIDを入力してください。");

			}

			if (accountPassword.equals("")) {

				errorList.add("パスワードを入力してください。");

			}

		} else {

			if (LoginDao.findLogin(accountId, accountPassword) == 0) {

				errorList.add("ユーザIDまたはパスワードの入力が不正です。");

			}

		}

		return errorList;

	}

	/**
	 * <dd>メソッド名：登録妥当性検証メソッド
	 * <dd>メソッド説明：登録機能の入力値を受け取り、妥当性検証をします。 検証の結果によりエラー文を返します。
	 *
	 * @param corporation
	 *            検証する入力値
	 * @return errorList 検証結果のエラー文
	 */
	public static List<String> checkRegisterLogin(Account account) {

		/** 検索エラー文 */
		List<String> errorList = new ArrayList<String>();

		/** ログインID */
		accountId = account.getAccountId();
		accountId = (accountId.replaceAll("　", " ")).trim();

		/** ログインPassword */
		accountPassword = account.getAccountPassword();
		accountPassword = (accountPassword.replaceAll("　", " ")).trim();

		/** ログインRePassword */
		accountRePassword = account.getAccountRePassword();
		accountRePassword = (accountRePassword.replaceAll("　", " ")).trim();

		if (accountId.length() < 4 && accountId.length() > 0) {

			errorList.add("ログインIDは4文字以上8文字以内で入力してください。");

		} else {

			if (LoginDao.findLoginCnt(account, 0) > 0) {

				errorList.add("登録済みログインIDです。ログインIDを変更してください。");

			} else if (LoginDao.findLoginCnt(account, 1) > 0) {

				errorList.add("登録済みパスワードです。パスワードを変更してください。");

			} else {

				if (accountId.equals("")) {

					errorList.add("ログインIDを入力してください。");

					if (accountPassword.equals("")) {

						errorList.add("パスワードを入力してください。");

					}

					if (accountRePassword.equals("")) {

						errorList.add("パスワード再入力を入力してください。");

					}

				}

			}
			/*
			 * }else
			 * if(accountId.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{4,8}))"
			 * )) {
			 *
			 * errorList.add("パスワードは半角英字大小及び数値をそれぞれ1つ以上入れてください。");
			 */

		}

		return errorList;

	}

	/**
	 * <dd>メソッド名：登録妥当性検証メソッド
	 * <dd>メソッド説明：登録機能の入力値を受け取り、妥当性検証をします。 検証の結果によりエラー文を返します。
	 *
	 * @param education
	 *            検証する入力値
	 * @return errorList 検証結果のエラー文
	 */
	public static List<String> checkEducation(Education Education, boolean flg) {

		/** 登録変更エラー文 */
		List<String> errorList = new ArrayList<String>();

		/** 氏名 */
		String EducationName = Education.getEducationName();

		EducationName = (EducationName.replaceAll("　", " ")).trim();

		if (EducationName.equals("")) {

			errorList.add("「氏名」を入力してください。");

		}

		/** 氏名（カナ） */
		String educationKanaName = Education.getEducationKanaName();

		educationKanaName = (educationKanaName.replaceAll("　", " ")).trim();

		if (educationKanaName.equals("")) {

			errorList.add("「氏名（カナ）」を入力してください。");

		} else {

			if (!educationKanaName.equals("") && !educationKanaName.matches("^[ァ-ヶー－]+$")) {

				errorList.add("「氏名（カナ）」は、全角カタカナのみで入力してください。");

			}

		}

		/** 生年月日 */
		String birthDate = Education.getEducationBirthday();

		birthDate = (birthDate.replaceAll("　", " ")).trim();

		birthDate = birthDate.replaceAll("-", "");

		if (birthDate.equals("")) {

			errorList.add("「生年月日」を入力してください。");

		}

		/** 郵便番号 */
		String postalcode = Education.getEducationPostalcode();

		postalcode = (postalcode.replaceAll("　", " ")).trim();

		if (postalcode.equals("")) {

			errorList.add("「郵便番号」を入力してください。");

		} else {

			if (!postalcode.equals("") && !postalcode.matches("^[0-9]{3}-[0-9]{4}$")) {

				errorList.add("「郵便番号」を、正しい形式で入力してください。");

			}

		}

		/** 住所 */
		String address = Education.getEducationAddress();

		address = (address.replaceAll("　", " ")).trim();

		address = address.replaceAll("-", "");

		if (address.equals("")) {

			errorList.add("「住所」を入力してください。");

		}

		/** 電話番号 */
		String phone = Education.getEducationPhoneNumber();

		phone = (phone.replaceAll("　", " ")).trim();

		if (phone.equals("")) {

			errorList.add("「電話番号」を入力してください。");

		} else {

			if (!phone.equals("") && !phone.matches("^[0-9]{1,5}-[0-9]{1,4}-[0-9]{4}$")) {

				errorList.add("「電話番号」を、正しい形式で入力してください。");

			}

		}

		/** メールアドレス */
		String mailAddress = Education.getEducationEmailAddress();

		mailAddress = (mailAddress.replaceAll("　", " ")).trim();

		mailAddress = mailAddress.replaceAll("-", "");

		if (mailAddress.equals("")) {

			errorList.add("「アドレス」を入力してください。");

		}

		/** 入社年月日 */
		String enterningDate = Education.getEnterningDate();

		enterningDate = (enterningDate.replaceAll("　", " ")).trim();

		enterningDate = enterningDate.replaceAll("-", "");

		if (enterningDate.equals("")) {

			errorList.add("「入社年月日」を入力してください。");

		}

		/** 備考 */
		String remarks = Education.getEducationRemarks();

		if (!remarks.equals("")) {

			if (remarks.length() > 300) {

				errorList.add("「備考」は、300文字以内で入力してください。");

			}

		}

		return errorList;

	}

	/**
	 * <dd>メソッド名：検索妥当性検証メソッド
	 * <dd>メソッド説明：検索機能の入力値を受け取り、妥当性検証をします。 検証の結果によりエラー文を返します。
	 *
	 * @param educationKanaName
	 *            検証する入力値
	 * @return errorList 検証結果のエラー文
	 */
	public static List<String> checkEducationSearch(String educationKanaName) {

		/** 検索エラー文 */
		List<String> errorList = new ArrayList<String>();

		if (!educationKanaName.equals("") && !educationKanaName.matches("^[ァ-ヶー－]+$")) {

			errorList.add("「氏名（カナ）」は、全角カタカナのみで入力してください。");

		}

		return errorList;

	}

	/**
	 * <dd>メソッド名：検索妥当性検証メソッド
	 * <dd>メソッド説明：検索機能の入力値を受け取り、妥当性検証をします。 検証の結果によりエラー文を返します。
	 *
	 * @param corporationName
	 *            検証する入力値
	 * @return errorList 検証結果のエラー文
	 */
	public static List<String> checkCorporationSearch(String corporationName) {

		/** 検索エラー文 */
		List<String> errorList = new ArrayList<String>();

		if (!corporationName.equals("") && !corporationName.matches("^[ぁ-んー]+$")
				&& !corporationName.matches("^[ァ-ヶー]+$")) {

			errorList.add("「企業名」は、全角ひらがな又はカタカナで入力してください。");

		}

		return errorList;

	}

	/**
	 * <dd>メソッド名：登録妥当性検証メソッド
	 * <dd>メソッド説明：登録機能の入力値を受け取り、妥当性検証をします。 検証の結果によりエラー文を返します。
	 *
	 * @param corporation
	 *            検証する入力値
	 * @return errorList 検証結果のエラー文
	 */
	public static List<String> checkCorporation(Corporation corporation) {

		/** 検索エラー文 */
		List<String> errorList = new ArrayList<String>();

		/** 企業名 */
		String name = corporation.getCorporationName();

		name = (name.replaceAll("　", " ")).trim();

		if (name.equals("")) {

			errorList.add("「企業名」を入力してください。");

		}

		/** 企業カナ */
		String kanaName = corporation.getCorporationKanaName();

		kanaName = (kanaName.replaceAll("　", " ")).trim();

		if (kanaName.equals("")) {

			errorList.add("「企業カナ」を入力してください。");

		}

		/** 郵便番号 */
		String postalcode = corporation.getCorporationPostalcode();

		postalcode = (postalcode.replaceAll("　", " ")).trim();

		if (postalcode.equals("")) {

			errorList.add("「郵便番号」を入力してください。");

		} else {

			if (!postalcode.equals("") && !postalcode.matches("^[0-9]{3}-[0-9]{4}$")) {

				errorList.add("「郵便番号」を、正しい形式で入力してください。");

			}

		}

		/** 住所 */
		String address = corporation.getCorporationAddress();

		address = (address.replaceAll("　", " ")).trim();

		if (address.equals("")) {

			errorList.add("「住所」を入力してください。");

		}

		/** 電話番号 */
		String phone = corporation.getCorporationTel();

		phone = (phone.replaceAll("　", " ")).trim();

		if (phone.equals("")) {

			errorList.add("「電話番号」を入力してください。");

		} else {

			if (!phone.equals("") && !phone.matches("^[0-9]{1,5}-[0-9]{1,4}-[0-9]{4}$")) {

				errorList.add("「電話番号」を、正しい形式で入力してください。");

			}

		}

		/** 代表者氏名 */
		String representativeName = corporation.getCorporationRepresentativeName();

		representativeName = (representativeName.replaceAll("　", " ")).trim();

		if (representativeName.equals("")) {

			errorList.add("「代表者氏名」を入力してください。");

		}

		return errorList;

	}

	/**
	 * <dd>メソッド名：登録妥当性検証メソッド
	 * <dd>メソッド説明：登録機能の入力値を受け取り、妥当性検証をします。 検証の結果によりエラー文を返します。
	 *
	 * @param test
	 *            検証する入力値
	 * @return errorList 検証結果のエラー文
	 */
	public static List<String> checkRegisterTest(String[] test) {

		/** 検索エラー文 */
		List<String> errorList = new ArrayList<String>();

		for (int i = 0; i < test.length; i++) {

			if (test[i].equals("null")) {

				errorList.add("「第" + (i + 1) + "問」を選択してください。");

			}

		}

		return errorList;

	}

	/**
	 * <dd>メソッド名：検索妥当性検証メソッド
	 * <dd>メソッド説明：検索機能の入力値を受け取り、妥当性検証をします。 検証の結果によりエラー文を返します。
	 *
	 * @param dutiesName
	 *            検証する入力値
	 * @return errorList 検証結果のエラー文
	 */
	public static List<String> checkDutiesSearch(String dutiesName) {

		/** 検索エラー文 */
		List<String> errorList = new ArrayList<String>();

		if (!dutiesName.equals("") && !dutiesName.matches("^[ぁ-んー]+$") && !dutiesName.matches("^[ァ-ヶー]+$")) {

			errorList.add("「役割名」は、全角ひらがな又はカタカナで入力してください。");

		}

		return errorList;

	}

	/**
	 * <dd>メソッド名：登録妥当性検証メソッド
	 * <dd>メソッド説明：登録機能の入力値を受け取り、妥当性検証をします。 検証の結果によりエラー文を返します。
	 *
	 * @param duties
	 *            検証する入力値
	 * @return errorList 検証結果のエラー文
	 */
	public static List<String> checkDuties(Duties duties) {

		/** 検索エラー文 */
		List<String> errorList = new ArrayList<String>();

		/** 役割名 */
		String name = duties.getDutiesName();

		name = (name.replaceAll("　", " ")).trim();

		if (name.equals("")) {

			errorList.add("「役割名」を入力してください。");

		}

		/** 役割詳細 */
		String remarks = duties.getDutiesRemarks();

		remarks = (remarks.replaceAll("　", " ")).trim();

		if (remarks.equals("")) {

			errorList.add("「役割詳細」を入力してください。");

		}

		return errorList;

	}

	/**
	 * <dd>メソッド名：登録妥当性検証メソッド
	 * <dd>メソッド説明：登録機能の入力値を受け取り、妥当性検証をします。 検証の結果によりエラー文を返します。
	 *
	 * @param interview
	 *            検証する入力値
	 * @return errorList 検証結果のエラー文
	 */
	public static List<String> checkInterview(Interview interview) {

		/** 検索エラー文 */
		List<String> errorList = new ArrayList<String>();

		return errorList;

	}

	/**
	 * <dd>メソッド名：登録妥当性検証メソッド
	 * <dd>メソッド説明：登録機能の入力値を受け取り、妥当性検証をします。 検証の結果によりエラー文を返します。
	 *
	 * @param technologylevel
	 *            検証する入力値
	 * @return errorList 検証結果のエラー文
	 */
	public static List<String> checkTechnologyLevel(TechnologyLevel technologylevel, int flg) {

		/** 検索エラー文 */
		List<String> errorList = new ArrayList<String>();

		if (flg == 0) {
			/** 技術レベル */
			String level4 = technologylevel.getLevel4();

			level4 = (level4.replaceAll("　", " ")).trim();

			if (!level4.equals("A") && !level4.equals("B") && !level4.equals("C") && !level4.equals("D")
					&& !level4.equals("E") && !level4.equals("F")) {

				errorList.add("技術レベルは「A～F」の値を入力してください。（小文字不可）");

			}

			/** 5月目標技術レベル */
			String level5Goal = technologylevel.getLevel5Goal();

			level5Goal = (level5Goal.replaceAll("　", " ")).trim();

			if (!level5Goal.equals("A") && !level5Goal.equals("B") && !level5Goal.equals("C") && !level5Goal.equals("D")
					&& !level5Goal.equals("E") && !level5Goal.equals("F")) {

				errorList.add("5月目標技術レベルは「A～F」の値を入力してください。（小文字不可）");

			}

			/** 5月目標技術レベルに対しての行動目標 */
			String level4Action = technologylevel.getLevel4Action();

			level4Action = (level4Action.replaceAll("　", " ")).trim();

			if (level4Action.equals("")) {

				errorList.add("「5月目標技術レベルに対しての行動目標」は必ず入力してください。");

			}

		} else if (flg == 1) {

			/** 技術レベル */
			String level5 = technologylevel.getLevel5();

			level5 = (level5.replaceAll("　", " ")).trim();

			if (!level5.equals("A") && !level5.equals("B") && !level5.equals("C") && !level5.equals("D")
					&& !level5.equals("E") && !level5.equals("F")) {

				errorList.add("技術レベルは「A～F」の値を入力してください。（小文字不可）");

			}

			/** 6月目標技術レベル */
			String level6Goal = technologylevel.getLevel6Goal();

			level6Goal = (level6Goal.replaceAll("　", " ")).trim();

			if (!level6Goal.equals("A") && !level6Goal.equals("B") && !level6Goal.equals("C") && !level6Goal.equals("D")
					&& !level6Goal.equals("E") && !level6Goal.equals("F")) {

				errorList.add("6月目標技術レベルは「A～F」の値を入力してください。（小文字不可）");

			}

			/** 5月の目標はなぜ達成できた（できなかった） */
			String level5GoalReason = technologylevel.getLevel5GoalReason();

			level5GoalReason = (level5GoalReason.replaceAll("　", " ")).trim();

			if (level5GoalReason.equals("")) {

				errorList.add("「5月の目標はなぜ達成できた（できなかった）」は必ず入力してください。");

			}

			/** 6月目標技術レベルに対しての行動目標 */
			String level5Action = technologylevel.getLevel5Action();

			level5Action = (level5Action.replaceAll("　", " ")).trim();

			if (level5Action.equals("")) {

				errorList.add("「6月目標技術レベルに対しての行動目標」は必ず入力してください。");

			}

		} else {

			/** 技術レベル */
			String level6 = technologylevel.getLevel6();

			level6 = (level6.replaceAll("　", " ")).trim();

			if (!level6.equals("A") && !level6.equals("B") && !level6.equals("C") && !level6.equals("D")
					&& !level6.equals("E") && !level6.equals("F")) {

				errorList.add("技術レベルは「A～F」の値を入力してください。（小文字不可）");

			}

			/** 研修終了時目標技術レベル */
			String level7Goal = technologylevel.getLevel7Goal();

			level7Goal = (level7Goal.replaceAll("　", " ")).trim();

			if (!level7Goal.equals("A") && !level7Goal.equals("B") && !level7Goal.equals("C") && !level7Goal.equals("D")
					&& !level7Goal.equals("E") && !level7Goal.equals("F")) {

				errorList.add("研修終了時目標技術レベルは「A～F」の値を入力してください。（小文字不可）");

			}

			/** 6月の目標はなぜ達成できた（できなかった） */
			String level6GoalReason = technologylevel.getLevel6GoalReason();

			level6GoalReason = (level6GoalReason.replaceAll("　", " ")).trim();

			if (level6GoalReason.equals("")) {

				errorList.add("「6月の目標はなぜ達成できた（できなかった）」は必ず入力してください。");

			}

			/** 研修終了時目標技術レベルに対しての行動目標 */
			String level6Action = technologylevel.getLevel6Action();

			level6Action = (level6Action.replaceAll("　", " ")).trim();

			if (level6Action.equals("")) {

				errorList.add("「研修終了時目標技術レベルに対しての行動目標」は必ず入力してください。");

			}

		}

		return errorList;

	}

	/**
	 * <dd>メソッド名：登録妥当性検証メソッド
	 * <dd>メソッド説明：登録機能の入力値を受け取り、妥当性検証をします。 検証の結果によりエラー文を返します。
	 *
	 * @param duties
	 *            検証する入力値
	 * @return errorList 検証結果のエラー文
	 */
	public static List<String> checkRegisterReport(Report report) {

		/** 検索エラー文 */
		List<String> errorList = new ArrayList<String>();

		/*		*//** 役割名 *//*
							 * String name = duties.getDutiesName();
							 *
							 * name = (name.replaceAll("　", " ")).trim();
							 *
							 * if (name.equals("")) {
							 *
							 * errorList.add("「役割名」を入力してください。");
							 *
							 * }
							 */

		return errorList;

	}

	/**
	 * <dd>メソッド名：登録妥当性検証メソッド
	 * <dd>メソッド説明：登録機能の入力値を受け取り、妥当性検証をします。 検証の結果によりエラー文を返します。
	 *
	 * @param topics
	 *            検証する入力値
	 * @return errorList 検証結果のエラー文
	 */
	public static List<String> checkTopics(Topics topics) {

		/** 検索エラー文 */
		List<String> errorList = new ArrayList<String>();

		/** お知らせタイトル */
		String title = topics.getTopicsTitle();

		title = (title.replaceAll("　", " ")).trim();

		if (title.equals("")) {

			errorList.add("「お知らせタイトル」を入力してください。");

		}

		/** お知らせ内容 */
		String contents = topics.getTopicsContents();

		contents = (contents.replaceAll("　", " ")).trim();

		if (contents.equals("")) {

			errorList.add("「お知らせ内容」を入力してください。");

		}

		return errorList;

	}

	/**
	 * <dd>メソッド名：変更、削除妥当性検証メソッド
	 * <dd>メソッド説明：変更、削除機能の選択値を受け取り、妥当性検証をします。 検証の結果によりエラー文を返します。
	 *
	 * @param Strrol
	 *            検証する入力値
	 * @return errorList 検証結果のエラー文
	 */
	public static List<String> checkSearchDuties(String[] duties) {

		/** 検索エラー文 */
		List<String> errorList = new ArrayList<String>();

		if (duties.length == 0) {

			errorList.add("変更する場合、役割を一つ選択してください。");

		} else if (duties.length > 1) {

			errorList.add("変更する場合、役割は複数選択しないでください。");

		}

		return errorList;

	}

	/**
	 * <dd>メソッド名：登録妥当性検証メソッド
	 * <dd>メソッド説明：登録機能の入力値を受け取り、妥当性検証をします。 検証の結果によりエラー文を返します。
	 *
	 * @param attendance
	 *            検証する入力値
	 * @return errorList 検証結果のエラー文
	 */
	public static List<String> checkRegisterAttendance(Attendance attendance, int flg) {

		/** 登録変更エラー文 */
		List<String> errorList = new ArrayList<String>();

		if (flg == 0) {

			if (attendance.getAttendanceStartStatus().equals("0")) {

				errorList.add("「ステータス」を選択してください。");

			} else if (!attendance.getAttendanceStartStatus().equals("1")
					&& attendance.getAttendanceStartRemarks().equals("")) {

				errorList.add("ステータスが通常以外の場合、理由を備考に入力してください。");

			}

		} else {

			if (attendance.getAttendanceEndStatus().equals("0")) {

				errorList.add("ステータスを選択してください。");

			} else if (!attendance.getAttendanceEndStatus().equals("1")
					&& attendance.getAttendanceEndRemarks().equals("")) {

				errorList.add("ステータスが通常以外の場合、理由を備考に入力してください。");

			}

		}

		return errorList;

	}

	/**
	 * <dd>メソッド名：登録妥当性検証メソッド
	 * <dd>メソッド説明：登録機能の入力値を受け取り、妥当性検証をします。 検証の結果によりエラー文を返します。
	 *
	 * @param attendance
	 *            検証する入力値
	 * @return errorList 検証結果のエラー文
	 */
	public static List<String> checkAttendanceData(int cnt, int flg) {

		/** 登録変更エラー文 */
		List<String> errorList = new ArrayList<String>();

		if (flg == 0) {

			if (cnt != 0) {

				errorList.add("本日分の出勤情報は打刻済みです。");

			}

		} else if (flg == 1) {

			if (cnt != 0) {

				errorList.add("本日分の退勤情報は打刻済みです。");

			}

		} else {

			errorList.add("出勤情報がありません。出勤を行うか、管理者へお問合せください。");

		}

		return errorList;

	}

	/**
	 * <dd>メソッド名：半角数字入力妥当性検証メソッド
	 * <dd>メソッド説明：入力値を受け取り、半角数字の検証をします。 検証の結果によりエラー文を返します。
	 *
	 * @param input
	 *            検証する入力値
	 * @return Check 検証結果 全角が1文字でも存在したらtrue, それ以外ならfalse
	 */
	public static boolean checkChar(String input) {

		char[] chars = input.toCharArray();

		boolean check = false;

		for (int i = 0; i < chars.length; i++) {

			char c = chars[i];

			if (!(c <= '\u007e') || (c == '\u00a5') || (c == '\u203e') || (c >= '\uff61' && c <= '\uff9f')) {

				check = true;

				break;

			}

		}

		return check;

	}

	/**
	 * <dd>メソッド名：検索妥当性検証メソッド
	 * <dd>メソッド説明：検索機能の入力値を受け取り、妥当性検証をします。 検証の結果によりエラー文を返します。
	 *
	 * @param educationKanaName
	 *            検証する入力値
	 * @return errorList 検証結果のエラー文
	 */
	public static List<String> checkEducationKananameSearch(String educationKanaName) {

		/** 検索エラー文 */
		List<String> errorList = new ArrayList<String>();

		if (!educationKanaName.equals("") && !educationKanaName.matches("^[ァ-ヶー]+$")) {

			errorList.add("「氏名(カナ)」は、全角カタカナで入力してください。");

		}

		return errorList;

	}

	/**
	 * <dd>メソッド名：各情報変更妥当性検証メソッド
	 * <dd>メソッド説明：各情報、チェックの入力値を受け取り、妥当性検証をします。 検証の結果によりエラー文を返します。
	 *
	 * @param checkList
	 *            検証する入力値
	 *
	 * @param flg
	 *            検証する機能
	 *
	 * @return errorList 検証結果のエラー文
	 */
	public static List<String> UpdateCheckbox(String[] checkList, int flg) {

		List<String> errorList = new ArrayList<String>();

		switch (flg) {
		case 0:

			if (checkList == null) {

				errorList.add("アカウント情報を選択してください。");

			} else if (checkList.length > 1) {

				errorList.add("変更するアカウント情報の選択は1件のみにしてください。");

			}

			break;

		case 1:

			if (checkList == null) {

				errorList.add("お知らせ情報を選択してください。");

			} else if (checkList.length > 1) {

				errorList.add("変更するお知らせ情報の選択は1件のみにしてください。");

			}

			break;

		case 2:

			if (checkList == null) {

				errorList.add("企業情報を選択してください。");

			} else if (checkList.length > 1) {

				errorList.add("変更する企業情報の選択は1件のみにしてください。");

			}

			break;

		case 3:

			if (checkList == null) {

				errorList.add("受講生情報を選択してください。");

			} else if (checkList.length > 1) {

				errorList.add("変更する受講生情報の選択は1件のみにしてください。");

			}

			break;

		case 4:

			if (checkList == null) {

				errorList.add("役割情報を選択してください。");

			} else if (checkList.length > 1) {

				errorList.add("変更する役割情報の選択は1件のみにしてください。");

			}

			break;

		case 5:

			if (checkList == null) {

				errorList.add("面談者を選択してください。");

			} else if (checkList.length > 1) {

				errorList.add("変更する面談情報の選択は1件のみにしてください。");

			}

			break;

		}

		return errorList;

	}

	/**
	 * <dd>メソッド名：各情報変更妥当性検証メソッド
	 * <dd>メソッド説明：各情報、チェックの入力値を受け取り、妥当性検証をします。 検証の結果によりエラー文を返します。
	 *
	 * @param checkList
	 *            検証する入力値
	 *
	 * @param flg
	 *            検証する機能
	 *
	 * @return errorList 検証結果のエラー文
	 */
	public static List<String> DeleteCheckbox(String[] checkList, int flg) {

		List<String> errorList = new ArrayList<String>();

		switch (flg) {
		case 0:

			if (checkList == null) {

				errorList.add("アカウント情報を選択してください。");

			}

			break;

		case 1:

			if (checkList == null) {

				errorList.add("お知らせ情報を選択してください。");

			}

			break;

		case 2:

			if (checkList == null) {

				errorList.add("企業情報を選択してください。");

			}

			break;

		case 3:

			if (checkList == null) {

				errorList.add("役割情報を選択してください。");

			}

			break;

		}

		return errorList;

	}

	/**
	 * <dd>メソッド名：登録妥当性検証メソッド
	 * <dd>メソッド説明：登録機能の入力値を受け取り、妥当性検証をします。 検証の結果によりエラー文を返します。
	 *
	 * @param account
	 *            検証する入力値
	 * @param accountName
	 *            検証する入力値
	 * @param accountPassword
	 *            検証する入力値
	 * @param accountPassword
	 *            検証する入力値
	 *
	 * @return errorList 検証結果のエラー文
	 */
	public static List<String> checkAccount(Account account, String accountName, String accountPassword,
			String accountRePassword) {

		/** 検索エラー文 */
		List<String> errorList = new ArrayList<String>();

		/** 企業名 */
		/*
		 * String corporationName =
		 * account.getCorporation().getCorporationName();
		 */
		/** 画面表示名 */
		accountName = (accountName.replaceAll("　", " ")).trim();

		/** ログインID */
		accountId = account.getAccountId();
		accountId = (accountId.replaceAll("　", " ")).trim();

		/** ログインPassword */
		accountPassword = (accountPassword.replaceAll("　", " ")).trim();

		/** ログインRePassword */
		accountRePassword = (accountRePassword.replaceAll("　", " ")).trim();

		/** 権限 */
		int accountAuthority = account.getAccountAuthority();

		/*
		 * if (corporationName.equals("")) {
		 *
		 * errorList.add("企業名を選択してください。");
		 *
		 * }
		 */
		if (accountId.length() < 4 && accountId.length() > 0) {

			errorList.add("ログインIDは4文字以上8文字以内で入力してください。");

		} else if (AccountDao.findAccountCnt(accountId, account.getAccountNo()) > 0) {

			errorList.add("登録済みログインIDです。ログインIDを変更してください。");

		} else if (accountId.equals("")) {

			errorList.add("ログインIDを入力してください。");

		}

		if (accountPassword.equals("")) {

			errorList.add("パスワードを入力してください。");

		}

		if (accountRePassword.equals("")) {

			errorList.add("パスワード再入力を入力してください。");

		}

		if (!accountPassword.equals(accountRePassword)) {

			errorList.add("パスワードとパスワード再入力が一致しません。");

		}

		if (accountName.equals("")) {

			errorList.add("画面表示名を入力してください。");

		}

		if (accountAuthority == 0) {

			errorList.add("権限を選択してください。");

		}

		return errorList;

	}

	/**
	 * <dd>メソッド名：登録妥当性検証メソッド
	 * <dd>メソッド説明：登録機能の入力値を受け取り、妥当性検証をします。 検証の結果によりエラー文を返します。
	 *
	 * @param account
	 *            検証する入力値
	 * @param accountName
	 *            検証する入力値
	 * @param accountPassword
	 *            検証する入力値
	 * @param accountPassword
	 *            検証する入力値
	 *
	 * @return errorList 検証結果のエラー文
	 */
	public static List<String> checkAccount(Account account) {

		/** 検索エラー文 */
		List<String> errorList = new ArrayList<String>();

		/** ログインID */
		accountId = account.getAccountId();
		accountId = (accountId.replaceAll("　", " ")).trim();

		/** ログインPassword */
		accountPassword = account.getAccountPassword();
		accountPassword = (accountPassword.replaceAll("　", " ")).trim();

		/** ログインRePassword */
		accountRePassword = account.getAccountRePassword();
		accountRePassword = (accountRePassword.replaceAll("　", " ")).trim();

		if (accountId.length() < 4 && accountId.length() > 0) {

			errorList.add("ログインIDは4文字以上8文字以内で入力してください。");

		} else if (AccountDao.findAccountCnt(accountId, account.getAccountNo()) > 0) {

			errorList.add("登録済みログインIDです。ログインIDを変更してください。");

		} else if (accountId.equals("")) {

			errorList.add("ログインIDを入力してください。");

		}

		if (accountPassword.equals("")) {

			errorList.add("パスワードを入力してください。");

		}

		if (accountRePassword.equals("")) {

			errorList.add("パスワード再入力を入力してください。");

		}

		if (!accountPassword.equals(accountRePassword)) {

			errorList.add("パスワードとパスワード再入力が一致しません。");

		}

		return errorList;

	}

	/**
	 * <dd>メソッド名：登録妥当性検証メソッド
	 * <dd>メソッド説明：登録機能の入力値を受け取り、妥当性検証をします。 検証の結果によりエラー文を返します。
	 *
	 * @param account
	 *            検証する入力値
	 * @param accountName
	 *            検証する入力値
	 * @param accountPassword
	 *            検証する入力値
	 * @param accountPassword
	 *            検証する入力値
	 *
	 * @return errorList 検証結果のエラー文
	 */
	public static List<String> checkAccount2(String accountId, String accountPassword, String accountRePassword,
			Integer accountNo) {

		/** 検索エラー文 */
		List<String> errorList = new ArrayList<String>();

		/** ログインID */
		accountId = (accountId.replaceAll("　", " ")).trim();

		/** ログインPassword */
		accountPassword = (accountPassword.replaceAll("　", " ")).trim();

		/** ログインRePassword */
		accountRePassword = (accountRePassword.replaceAll("　", " ")).trim();

		if (accountId.length() < 4 && accountId.length() > 0) {

			errorList.add("ログインIDは4文字以上8文字以内で入力してください。");

		} else if (AccountDao.findAccountCnt(accountId, accountNo) > 0) {

			errorList.add("登録済みログインIDです。ログインIDを変更してください。");

		} else if (accountId.equals("")) {

			errorList.add("ログインIDを入力してください。");

		}

		if (accountPassword.equals("")) {

			errorList.add("パスワードを入力してください。");

		}

		if (accountRePassword.equals("")) {

			errorList.add("パスワード再入力を入力してください。");

		}

		if (!accountPassword.equals(accountRePassword)) {

			errorList.add("パスワードとパスワード再入力が一致しません。");

		}

		if (accountPassword.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]){4,8}$")) {

			errorList.add("パスワードは半角英字大小及び数値をそれぞれ1つ以上入れてください。");

		}

		return errorList;

	}

	/**
	 * <dd>メソッド名：
	 * <dd>メソッド説明：
	 *
	 * @param
	 *
	 * @return errorList 検証結果のエラー文
	 */
	public static List<String> checkEducationSelect(String educationNo) {

		/** 検索エラー文 */
		List<String> errorList = new ArrayList<String>();

		if (educationNo.equals("0")) {

			errorList.add("受講生を選択してください。");

		}

		return errorList;

	}

	/**
	 * <dd>メソッド名：
	 * <dd>メソッド説明：
	 *
	 * @param
	 *
	 * @return errorList 検証結果のエラー文
	 */
	public static List<String> checkTestSelect(int testContentsSize) {

		/** 検索エラー文 */
		List<String> errorList = new ArrayList<String>();

		if (testContentsSize == 0) {

			errorList.add("該当日以外のテストは実施できません。");

		}

		return errorList;

	}

	public static List<String> checkQuestionAnswer(Map<String, Integer> answer1, Map<String, Boolean> answer2) {

		List<String> errorList = new ArrayList<String>();

		// 入力内容チェック
		for (Map.Entry<String, Integer> answerMap : answer1.entrySet()) {

			if (answerMap.getValue() == 0) {

				errorList.add(answerMap.getKey() + " ");

			}

		}

		// 全角半角入力チェック
		for (Map.Entry<String, Boolean> answerMap2 : answer2.entrySet()) {

			if (answerMap2.getValue()) {

				errorList.add(answerMap2.getKey() + "は半角で入力してください。");

			}

		}

		return errorList;

	}

	/**
	 * <dd>メソッド名：
	 * <dd>メソッド説明：
	 *
	 * @param
	 *
	 * @return errorList 検証結果のエラー文
	 */
	public static List<String> checkComment(String commnet) {

		/** 検索エラー文 */
		List<String> errorList = new ArrayList<String>();

		if (commnet.equals("")) {

			errorList.add("コメントを入力してください。");

		}

		return errorList;

	}

	/**
	 * <dd>メソッド名：
	 * <dd>メソッド説明：
	 *
	 * @param
	 *
	 * @return errorList 検証結果のエラー文
	 */
	public static List<String> checkFqa(String address, String comment) {

		/** 検索エラー文 */
		List<String> errorList = new ArrayList<String>();

		/** メールアドレス */
		String mailAddress = address;

		mailAddress = (mailAddress.replaceAll("　", " ")).trim();

		mailAddress = mailAddress.replaceAll("-", "");

		if (mailAddress.equals("")) {

			errorList.add("「アドレス」を入力してください。");

		}

		/** お問合せ内容 */
		String commentlist = comment;

		commentlist = (commentlist.replaceAll("　", " ")).trim();

		commentlist = commentlist.replaceAll("-", "");

		if (commentlist.equals("")) {

			errorList.add("「アドレス」を入力してください。");

		}

		return errorList;

	}

	/**
	 * <dd>メソッド名：登録妥当性検証メソッド
	 * <dd>メソッド説明：登録機能の入力値を受け取り、妥当性検証をします。 検証の結果によりエラー文を返します。
	 *
	 * @param accountId
	 *            検証する入力値
	 * @param cnt
	 *            検証する入力値
	 *
	 * @return errorList 検証結果のエラー文
	 */
	public static List<String> checkAccountId(String accountId, int cnt) {

		/** 検索エラー文 */
		List<String> errorList = new ArrayList<String>();

		if (accountId.equals("")) {

			errorList.add("アカウントIDが未入力です。入力してください。");

		} else if (cnt == 0) {

			errorList.add("アカウントIDが不正です。再度入力してください。");

		}

		return errorList;

	}

	/**
	 * <dd>メソッド名：登録妥当性検証メソッド
	 * <dd>メソッド説明：登録機能の入力値を受け取り、妥当性検証をします。 検証の結果によりエラー文を返します。
	 *
	 * @param Pass
	 *            検証する入力値
	 * @param RePass
	 *            検証する入力値
	 *
	 * @return errorList 検証結果のエラー文
	 */
	public static List<String> checkAccountPass(String Pass, String RePass) {

		/** 検索エラー文 */
		List<String> errorList = new ArrayList<String>();

		if (!Pass.equals(RePass)) {

			errorList.add("パスワードが一致していません。再度入力してください。");

		}

		return errorList;

	}

	public static String change(String inputText) {

		inputText = inputText.replaceAll("\r\n", "<br>");

		return inputText;

	}

	public static String change2(String loadText) {

		loadText = loadText.replaceAll("<br>", "\r\n");

		return loadText;

	}

}
