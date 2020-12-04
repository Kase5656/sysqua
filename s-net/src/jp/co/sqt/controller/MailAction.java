/*
 *MailAction.java V1L1.0 Copyright System Quart LIMITED 2018

 *システム名 (RMS) 業務区分名 (お知らせ管理業務)
 *クラス一覧：
 * NO クラス名 概要
 * 1 MailAction 各アクションへ誘導するクラスです。
 *履歴：
 * NO 日付 Ver 更新者 内容
 * 1 2016/06/01 V1L1.0 SQT）加瀬 初版。
 */

package jp.co.sqt.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.sqt.dao.MailDao;

/**
 * <dd>クラス名：
 * <dd>クラス説明：
 *
 * @version 1.00 2016/06/01
 * @author SQT）加瀬
 */
public class MailAction implements Action {

	private static final Logger LOGGER = Logger.getAnonymousLogger();

	private static final String SERVIDOR_SMTP = "smtp.office365.com";
	private static final int PORTA_SERVIDOR_SMTP = 587;
	private static final String CONTA_PADRAO = "kase@sqt.co.jp";
	private static final String SENHA_CONTA_PADRAO = "_3101Sqt";

	private final String from = "no-reply@sqt.co.jp";
	private final String to = "rms_support@sqt.co.jp";

	private final String subject = "［RMSシステム］パスワード再発行手続きについて";
	private final String messageContent = "［RMSシステム］パスワード再発行手続きについて\r\n" +
			"\r\n" +
			"パスワード再発行を行って頂くためには、下記の手続きを30分以内に完了していただく必要があります。\r\n" +
			"\r\n" +
			"下記にアクセスし、お早めに「パスワード再発行手続き」を完了させてください。\r\n" +
			"\r\n" +
			"パスワード再発行（リンク）\r\n" +
			"https://rms.sqt.co.jp/s-net/passReset.jsp\r\n" +
			"\r\n" +
			"※「パスワード再発行手続き」を完了せず30分を経過した場合、上記のパスワード再発行URLは無効となります。\r\n" +
			"その場合再度、手続きをお願いいたします。\r\n" +
			"\r\n" +
			"\r\n" +
			"個人情報は下記「個人情報保護方針」記載の要領に沿って取り扱います。\r\n" +
			"\r\n" +
			"■個人情報保護方針\r\n" +
			"\r\n" +
			"https://www.sqt.co.jp/privacy/index.html\r\n" +
			"\r\n" +
			"今後ともRMSシステムをどうぞよろしくお願いいたします。\r\n" +
			"\r\n" +
			"※本メールは、RMSシステムを登録されている方にのみ送信される自動配信メールです。\r\n" +
			"本メールにご返信いただいてもお答えできませんので、ご了承ください。\r\n" +
			"もし、このメールにお心当たりがない方は、本メールを削除ください。\r\n" +
			"また、ご不明の点がございましたら、下記問合せ窓口までお問合せはください。\r\n" +
			"\r\n" +
			"＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝\r\n" +
			"【発行元】\r\n" +
			"株式会社システムクォート\r\n" +
			"\r\n" +
			"【お問合せ窓口】\r\n" +
			"TEL：03-3239-3666　MAIL：rms_support@sqt.co.jp\r\n" +
			"\r\n" +
			"Copyright @ 1984 - 2020 Induction Course All Rights Reserved.\r\n" +
			"＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝\r\n" +
			"";

	private final String subjectFqa = "お問い合わせ連絡";
	private final String messageContentFqa = "左記アドレスの方よりお問い合わせが来ております。\r\nお問い合わせ内容：\r\n";

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
	@Override
	public String doService(HttpServletRequest request, HttpServletResponse response) {

		/** セッション */
		HttpSession session = request.getSession(false);

		/** サーブレットパス */
		String servletPath = request.getServletPath();

		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		if (session == null ) {

			servletPath = "/sessionLost.jsp";

		} else {

			if (request.getParameter("action") != null) {

				if ("Send_btn".equals(request.getParameter("action"))) {

					sendEmail(request.getParameter("Address_txt"));

					servletPath = "/passforgetComplete.jsp";

				} else if ("Sendfqa_btn".equals(request.getParameter("action"))) {

					sendEmail(request.getParameter("Address_txt"), request.getParameter("Content_txt"));

					servletPath = "/test.jsp";

				} else if ("PassReset_btn".equals(request.getParameter("action"))) {

					String accountId = request.getParameter("accountId");

					session.setAttribute("accountId", accountId);

					List<String> errorList = new ArrayList<>();

					errorList = Check.checkAccountId(accountId, MailDao.search(accountId));

					String password = request.getParameter("accountPassword");

					String repassword = request.getParameter("accountRePassword");

					errorList = Check.checkAccountPass(password, repassword);

					if (errorList.size() > 0) {

						request.setAttribute("errorList", errorList);

						servletPath = "/passReset.jsp";

					} else {

						MailDao.update(accountId, password);

						servletPath = "/passResetComplete.jsp";

					}

				} else if ("FqaBack_btn".equals(request.getParameter("action"))) {

					servletPath = "/index.jsp";

				} else if ("Login_btn".equals(request.getParameter("action"))) {

					servletPath = "/index.jsp";

				}

			} else {

				servletPath = "/index.jsp";

			}

		}

		return servletPath;

	}

	public void sendEmail(String address) {
		final Session session = Session.getInstance(this.getEmailProperties(), new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(CONTA_PADRAO, SENHA_CONTA_PADRAO);

			}

		});

		try {

			final MimeMessage message = new MimeMessage(session);

			message.setRecipient(Message.RecipientType.TO, new InternetAddress(address));

			message.setFrom(new InternetAddress(from));

			message.setContent(subject, "iso-2022-jp");

			message.setSubject(subject, "iso-2022-jp");

			message.setContent(messageContent, "iso-2022-jp");

			message.setText(messageContent, "iso-2022-jp");

			message.setSentDate(new Date());

			Transport.send(message);

		} catch (final MessagingException ex) {

			LOGGER.log(Level.WARNING, "Erro ao enviar mensagem: " + ex.getMessage(), ex);

		}

	}

	public void sendEmail(String address, String content) {
		final Session session = Session.getInstance(this.getEmailProperties(), new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(CONTA_PADRAO, SENHA_CONTA_PADRAO);

			}

		});

		try {

			final Message message = new MimeMessage(session);

			message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));

			message.setFrom(new InternetAddress(from));

			message.setContent(subjectFqa, "text/html;charset=UTF-8");

			message.setSubject(subjectFqa);

			message.setContent(messageContentFqa, "text/html;charset=UTF-8");

			message.setText("<" + address + ">" + messageContentFqa + content);

			message.setSentDate(new Date());

			Transport.send(message);

		} catch (final MessagingException ex) {

			LOGGER.log(Level.WARNING, "Erro ao enviar mensagem: " + ex.getMessage(), ex);

		}

	}

	public Properties getEmailProperties() {

		final Properties config = new Properties();

		config.put("mail.smtp.auth", "true");

		config.put("mail.smtp.starttls.enable", "true");

		config.put("mail.smtp.host", SERVIDOR_SMTP);

		config.put("mail.smtp.port", PORTA_SERVIDOR_SMTP);

		return config;

	}

}
