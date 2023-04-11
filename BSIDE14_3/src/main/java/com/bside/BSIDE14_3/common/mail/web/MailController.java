package com.bside.BSIDE14_3.common.mail.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bside.BSIDE14_3.common.domain.ResponseResult;
import com.bside.BSIDE14_3.common.domain.ResponseService;
import com.bside.BSIDE14_3.common.exception.UserException;
import com.bside.BSIDE14_3.common.mail.domain.SenderDto;
import com.bside.BSIDE14_3.common.mail.service.MailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


/**
* 메일 전송 Controller
* @author: HeeHee
* @CreateDate: 2023. 3. 24
*
*/

@RestController
@RequestMapping("/common/mail")
@RequiredArgsConstructor
public class MailController {
  
  private final MailService service;
  private final ResponseService resService;
  
  @GetMapping("/sendMail")
  public ResponseResult<Object> sendMeail(
      @RequestParam String to
      , @RequestParam String title
      , @RequestParam String content) {
    SenderDto dto = new SenderDto();
    dto.setTo(to);
    dto.setTitle(title);
    dto.setContent(content);
    try {
      service.sendMail(dto);
    } catch (UserException e) {
      return resService.getFailResult(-1, e.getMessage());
    }
    return resService.getSuccessResult(); 
  }

}
