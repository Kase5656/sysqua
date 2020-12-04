/*
 *TechnologyLevel.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (社員管理業務)
 *クラス一覧：
 * NO クラス名 概要
 * 1 TechnologyLevel データベースから取得した情報を保持するクラスです。
 *履歴：
 * NO 日付 Ver 更新者 内容
 * 1 2017/00/00 V1L1.0 SQT）加瀬 初版。
 */

package jp.co.sqt.entity;

import java.io.Serializable;

/**
 * <dd>クラス名：技術目標情報エンティティクラス
 * <dd>クラス説明：技術目標No、技術目標名を扱います。
 * データベースから取得した情報を保持します。
 *
 * @version 1.00 2017/00/00
 * @author SQT）加瀬
 */
public class TechnologyLevel implements Serializable {

	/**　直列化ID　*/
	private static final long serialVersionUID = 1L;

	/**　技術目標No　*/
	private int technologylevelNo;

	/**　アカウントNo　*/
	private int accountNo;

	/**　4月レベル　*/
	private String level4;

	/**　5月目標レベル　*/
	private String level5Goal;

	/**　4月行動目標　*/
	private String level4Action;

	/**　5月レベル　*/
	private String level5;

	/**　6月目標レベル　*/
	private String level6Goal;

	/**　5月目標レベルに対する　*/
	private String level5GoalReason;

	/**　5月行動目標　*/
	private String level5Action;

	/**　6月レベル　*/
	private String level6;

	/**　7月目標レベル　*/
	private String level7Goal;

	/**　6月目標レベルに対する　*/
	private String level6GoalReason;

	/**　6月行動目標　*/
	private String level6Action;

	/**
	 * <dd>メソッド名：Dutiesデフォルトコンストラクタメソッド
	 * <dd>メソッド説明：インスタンスの生成を可能にします。
	 */
	public TechnologyLevel() {
	}

	/**
	 * <dd>メソッド名：TechnologyLevelコンストラクタメソッド
	 * <dd>メソッド説明：技術目標情報を初期化します。
	 * @param technologylevelNo 技術目標No
	 * @param technologylevelNo 技術目標No
	 * @param technologylevelNo 技術目標No
	 * @param technologylevelNo 技術目標No
	 * @param technologylevelNo 技術目標No
	 * @param technologylevelNo 技術目標No
	 * @param technologylevelNo 技術目標No
	 * @param technologylevelNo 技術目標No
	 * @param technologylevelNo 技術目標No
	 * @param technologylevelNo 技術目標No
	 * @param technologylevelNo 技術目標No
	 * @param technologylevelNo 技術目標No
	 * @param technologylevelNo 技術目標No
	 */
	public TechnologyLevel(int technologylevelNo, int accountNo, String level4, String level5Goal, String level4Action,
			String level5, String level6Goal, String level5GoalReason, String level5Action, String level6,
			String level7Goal, String level6GoalReason, String level6Action) {

		super();

		this.technologylevelNo = technologylevelNo;

		this.accountNo = accountNo;

		this.level4 = level4;

		this.level5Goal = level5Goal;

		this.level4Action = level4Action;

		this.level5 = level5;

		this.level6Goal = level6Goal;

		this.level5GoalReason = level5GoalReason;

		this.level5Action = level5Action;

		this.level6 = level6;

		this.level7Goal = level7Goal;

		this.level6GoalReason = level6GoalReason;

		this.level6Action = level6Action;

	}

	/**
	 * <dd>メソッド名：技術目標No取得メソッド
	 * <dd>メソッド説明：技術目標Noを取得します。
	 * @return technologylevelNo 技術目標No
	 */
	public int getTechnologyLevelNo() {

		return technologylevelNo;

	}

	/**
	 * <dd>メソッド名：技術目標No設定メソッド
	 * <dd>メソッド説明：技術目標Noを設定します。
	 * @param technologylevelNo 技術目標No
	 */
	public void setTechnologyLevelNo(int technologylevelNo) {

		this.technologylevelNo = technologylevelNo;

	}

	/**
	 * <dd>メソッド名：アカウントNo取得メソッド
	 * <dd>メソッド説明：アカウントNoを取得します。
	 * @return accountNo アカウントNo
	 */
	public int getAccountNo() {

		return accountNo;

	}

	/**
	 * <dd>メソッド名：アカウントNo設定メソッド
	 * <dd>メソッド説明：アカウントNoを設定します。
	 * @param accountNo アカウントNo
	 */
	public void setAccountNo(int accountNo) {

		this.accountNo = accountNo;

	}

	/**
	 * <dd>メソッド名：4月レベル取得メソッド
	 * <dd>メソッド説明：4月レベルを取得します。
	 * @return level4 4月レベル
	 */
	public String getLevel4() {

		return level4;

	}

	/**
	 * <dd>メソッド名：4月レベル設定メソッド
	 * <dd>メソッド説明：4月レベルを設定します。
	 * @param level4 4月レベル
	 */
	public void setLevel4(String level4) {

		this.level4 = level4;

	}

	/**
	 * <dd>メソッド名：5月目標レベル取得メソッド
	 * <dd>メソッド説明：5月目標レベルを取得します。
	 * @return level5Goal 5月目標レベル
	 */
	public String getLevel5Goal() {

		return level5Goal;

	}

	/**
	 * <dd>メソッド名：5月目標レベル設定メソッド
	 * <dd>メソッド説明：5月目標レベルを設定します。
	 * @param level5Goal 5月目標レベル
	 */
	public void setLevel5Goal(String level5Goal) {

		this.level5Goal = level5Goal;

	}

	/**
	 * <dd>メソッド名：4月行動目標取得メソッド
	 * <dd>メソッド説明：4月行動目標を取得します。
	 * @return level4Action 4月行動目標
	 */
	public String getLevel4Action() {

		return level4Action;

	}

	/**
	 * <dd>メソッド名：4月行動目標設定メソッド
	 * <dd>メソッド説明：4月行動目標を設定します。
	 * @param level4Action 4月行動目標
	 */
	public void setLevel4Action(String level4Action) {

		this.level4Action = level4Action;

	}



	/**
	 * <dd>メソッド名：5月レベル取得メソッド
	 * <dd>メソッド説明：5月レベルを取得します。
	 * @return level5 5月レベル
	 */
	public String getLevel5() {

		return level5;

	}

	/**
	 * <dd>メソッド名：5月レベル設定メソッド
	 * <dd>メソッド説明：5月レベルを設定します。
	 * @param level5 5月レベル
	 */
	public void setLevel5(String level5) {

		this.level5 = level5;

	}

	/**
	 * <dd>メソッド名：6月目標レベル取得メソッド
	 * <dd>メソッド説明：6月目標レベルを取得します。
	 * @return level6Goal 6月目標レベル
	 */
	public String getLevel6Goal() {

		return level6Goal;

	}

	/**
	 * <dd>メソッド名：6月目標レベル設定メソッド
	 * <dd>メソッド説明：6月目標レベルを設定します。
	 * @param level6Goal 6月目標レベル
	 */
	public void setLevel6Goal(String level6Goal) {

		this.level6Goal = level6Goal;

	}

	/**
	 * <dd>メソッド名：5月目標レベルに対する取得メソッド
	 * <dd>メソッド説明：5月目標レベルに対するを取得します。
	 * @return level5GoalReason 5月目標レベルに対する
	 */
	public String getLevel5GoalReason() {

		return level5GoalReason;

	}

	/**
	 * <dd>メソッド名：5月目標レベルに対する設定メソッド
	 * <dd>メソッド説明：5月目標レベルに対するを設定します。
	 * @param level5GoalReason 5月目標レベルに対する
	 */
	public void setLevel5GoalReason(String level5GoalReason) {

		this.level5GoalReason = level5GoalReason;

	}

	/**
	 * <dd>メソッド名：5月行動目標取得メソッド
	 * <dd>メソッド説明：5月行動目標を取得します。
	 * @return level5Action 5月行動目標
	 */
	public String getLevel5Action() {

		return level5Action;

	}

	/**
	 * <dd>メソッド名：5月行動目標設定メソッド
	 * <dd>メソッド説明：5月行動目標を設定します。
	 * @param level5Action 5月行動目標
	 */
	public void setLevel5Action(String level5Action) {

		this.level5Action = level5Action;

	}

	/**
	 * <dd>メソッド名：6月レベル取得メソッド
	 * <dd>メソッド説明：6月レベルを取得します。
	 * @return level6 6月レベル
	 */
	public String getLevel6() {

		return level6;

	}

	/**
	 * <dd>メソッド名：6月レベル設定メソッド
	 * <dd>メソッド説明：6月レベルを設定します。
	 * @param level6 6月レベル
	 */
	public void setLevel6(String level6) {

		this.level6 = level6;

	}

	/**
	 * <dd>メソッド名：7月目標レベル取得メソッド
	 * <dd>メソッド説明：7月目標レベルを取得します。
	 * @return level7Goal 7月目標レベル
	 */
	public String getLevel7Goal() {

		return level7Goal;

	}

	/**
	 * <dd>メソッド名：7月目標レベル設定メソッド
	 * <dd>メソッド説明：7月目標レベルを設定します。
	 * @param level7Goal 7月目標レベル
	 */
	public void setLevel7Goal(String level7Goal) {

		this.level7Goal = level7Goal;

	}

	/**
	 * <dd>メソッド名：6月目標レベルに対する取得メソッド
	 * <dd>メソッド説明：6月目標レベルに対するを取得します。
	 * @return level6GoalReason 6月目標レベルに対する
	 */
	public String getLevel6GoalReason() {

		return level6GoalReason;

	}

	/**
	 * <dd>メソッド名：6月目標レベルに対する設定メソッド
	 * <dd>メソッド説明：6月目標レベルに対するを設定します。
	 * @param level6GoalReason 6月目標レベルに対する
	 */
	public void setLevel6GoalReason(String level6GoalReason) {

		this.level6GoalReason = level6GoalReason;

	}

	/**
	 * <dd>メソッド名：6月行動目標取得メソッド
	 * <dd>メソッド説明：6月行動目標を取得します。
	 * @return level6Action 6月行動目標
	 */
	public String getLevel6Action() {

		return level6Action;

	}

	/**
	 * <dd>メソッド名：6月行動目標設定メソッド
	 * <dd>メソッド説明：6月行動目標を設定します。
	 * @param level6Action 6月行動目標
	 */
	public void setLevel6Action(String level6Action) {

		this.level6Action = level6Action;

	}

}
