package com.bside.BSIDE14_3.common.mail.domain;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import lombok.Data;

/**
*
* @author: HeeHee
* @CreateDate: 2023. 3. 24
*
*/

@Data
public class SenderDto {

  private String from; // 보내는 사람
  private String to; // 받는 사람
  private List<String> toList = new ArrayList<>(); // 받는 사람 (list)
  private List<String> toCCList = new ArrayList<>(); // 참조
  private List<String> toBCCList = new ArrayList<>(); // 숨은 참조
  private String title; // 제목
  private String content; // 내용

  private List<File> files; // Attached Files

  private String[] filePath; // Attached File 전체 경로
  private String[] fileName; // Attached File name

  public void addTo(String email) {
    this.toList.add(email);
  }

  // CC 등록
  public void addCC(String email) {
    this.toCCList.add(email);
  }

  // BCC 등록
  public void addBCC(String email) {
    this.toBCCList.add(email);
  }

  private InternetAddress[] makeEmailAddress(List<String> lstEmailAddress) throws AddressException {
    InternetAddress[] result = new InternetAddress[lstEmailAddress.size()];
    for (int i = 0; i < lstEmailAddress.size(); i++) {
      result[i] = new InternetAddress(lstEmailAddress.get(i));
    }
    return result;
  }

  public MimeMessage toSendMessage(Session session) throws MessagingException {
    MimeMessage result = new MimeMessage(session);
    result.setFrom(new InternetAddress(this.from));

    // TO
    List<InternetAddress> lstToAddress = new ArrayList<>();
    if (!"".equals(this.to)) {
      lstToAddress.add(new InternetAddress(this.to));
    }
    if (!toList.isEmpty()) {
      lstToAddress.addAll(Arrays.asList(makeEmailAddress(toList)));
    }
    InternetAddress[] toArrays = new InternetAddress[lstToAddress.size()];
    result.setRecipients(javax.mail.Message.RecipientType.TO, lstToAddress.toArray(toArrays));

    // CC 참
    if (!toCCList.isEmpty()) {
      result.setRecipients(javax.mail.Message.RecipientType.CC, makeEmailAddress(toCCList));
    }

    // BCC 숨은참조.
    if (!toBCCList.isEmpty()) {
      result.setRecipients(javax.mail.Message.RecipientType.BCC, makeEmailAddress(toBCCList));
    }

    result.setSubject(this.title);

    MimeBodyPart messageBodyPart = new MimeBodyPart();
    messageBodyPart.setContent(this.content, "text/html");
    MimeMultipart multipart = new MimeMultipart();
    // 본문을 첨부 파일 목록에 추가
    multipart.addBodyPart(messageBodyPart);

    if (fileName != null && filePath != null && fileName.length > 0 && filePath.length > 0
        && fileName.length == filePath.length) {
      for (int i = 0; i < fileName.length; i++) {
        String name = fileName[i];
        String path = filePath[i];
        MimeBodyPart attachmentBodyPart = new MimeBodyPart();
        DataSource fds = new FileDataSource(path);
        attachmentBodyPart.setDataHandler(new DataHandler(fds));
        attachmentBodyPart.setFileName(name);

        // Add the attachment to the message.
        multipart.addBodyPart(attachmentBodyPart);
      }
    }

    // 파일 첨부
    if (this.files != null && !this.files.isEmpty()) {
      for (File file : files) {
        MimeBodyPart attachmentBodyPart = new MimeBodyPart();
        FileDataSource fileDataSource = new FileDataSource(file);
        attachmentBodyPart.setDataHandler(new DataHandler(fileDataSource));
        attachmentBodyPart.setFileName(file.getName());
        multipart.addBodyPart(attachmentBodyPart);
      }
    }
    // 메일에 첨부 파일 목록 추가
    result.setContent(multipart);
    return result;
  }

}
