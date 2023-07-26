package com.bside.BSIDE.user.service;

public interface EmailService {
	 String sendCodeMessage(String to)throws Exception;
	 String sendTemporaryPassword(String to, String temporaryPassword)throws Exception;
	 void sendByMonth(String email,String sendEmail, String date) throws Exception;
	 void scheduleMonthlyEmail() throws Exception;
}
