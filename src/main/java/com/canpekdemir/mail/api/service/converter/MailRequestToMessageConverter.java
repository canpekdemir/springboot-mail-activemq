package com.canpekdemir.mail.api.service.converter;

import com.canpekdemir.mail.api.model.request.MailRequest;
import com.canpekdemir.mail.api.service.queue.model.MailMessage;
import org.springframework.stereotype.Component;

@Component
public class MailRequestToMessageConverter {

    public MailMessage convert(MailRequest request) {
        MailMessage mailMessage = new MailMessage();
        mailMessage.setSubject(request.getSubject());
        mailMessage.setSender(request.getSender());
        mailMessage.setToList(request.getToList());
        mailMessage.setBccList(request.getBccList());
        mailMessage.setCcList(request.getCcList());
        mailMessage.setReplyTo(request.getReplyTo());
        mailMessage.setBody(request.getBody());
        return mailMessage;
    }
}
