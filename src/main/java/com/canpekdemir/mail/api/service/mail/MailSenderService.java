package com.canpekdemir.mail.api.service.mail;


import com.canpekdemir.mail.api.service.queue.model.MailMessage;

public interface MailSenderService {

    void sendMail(MailMessage mailMessage);
}
