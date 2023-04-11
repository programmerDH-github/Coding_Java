package com.bside.BSIDE14_3.common.mail.service;

import java.util.ArrayList;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.bside.BSIDE14_3.common.exception.UserException;
import com.bside.BSIDE14_3.common.mail.domain.SenderDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
*
* @author: HeeHee
* @CreateDate: 2023. 3. 24
*
*/

@Slf4j
@RequiredArgsConstructor
@Service
public class MailService {

  @Value("${mail.from.address}")
  private String mailFromAddr;

  @Value("${mail.from.userid}")
  private String mailUserId;

  @Value("${mail.from.passwd}")
  private String mailPasswd;

  @Value("${mail.smtp.auth}")
  private String smtpAuth;

  @Value("${mail.smtp.starttls.enable}")
  private String starttts;

  @Value("${mail.smtp.host}")
  private String host;

  @Value("${mail.smtp.port}")
  private String port;

  /**
   * 메일 전송
   * 
   * @param mailDto
   * @return String "success" or "fail"
   */
  public String sendMail(SenderDto mailDto) throws UserException {
    String retMsg = "";

    // --# 제목 공통
    String title = "[GOMING] ";
    mailDto.setTitle(title + mailDto.getTitle());

    // --# 보내는 사람
    if (mailDto.getFrom() == null || "".equals(mailDto.getFrom())) {
      mailDto.setFrom(mailFromAddr);
    }

    // --# 받는 사람
    if (mailDto.getToList() == null || mailDto.getToList().isEmpty()) {
      mailDto.setToList(new ArrayList<>());
      mailDto.addTo(mailDto.getTo());
    }

    sendSmtpMail(mailDto);

    retMsg = "success";
    return retMsg;
  }

  private void sendSmtpMail(SenderDto mailDto) throws UserException {
    try {
      // SMTP 인증 정보 설정
      Properties props = new Properties();
      props.put("mail.smtp.auth", smtpAuth);
      props.put("mail.smtp.starttls.enable", starttts);
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", port);

      // 인증 정보를 담은 세션 생성
      Session session = Session.getInstance(props, new Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
          return new PasswordAuthentication(mailUserId, mailPasswd);
        }
      });

      Transport.send(mailDto.toSendMessage(session));
    } catch (MessagingException ex) {
      log.info(ExceptionUtils.getStackTrace(ex));
      throw new UserException(-1, ex.getMessage());
    }
  }


}
