package com.canpekdemir.mail.api.controller;


import com.canpekdemir.mail.api.model.request.MailRequest;
import com.canpekdemir.mail.api.model.response.MailResponse;
import com.canpekdemir.mail.api.model.response.ResponseStatusType;
import com.canpekdemir.mail.api.service.converter.MailRequestToMessageConverter;
import com.canpekdemir.mail.api.service.queue.MailMQPublisherService;
import com.canpekdemir.mail.api.service.queue.model.MailMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    @Autowired
    protected MailMQPublisherService mailMQPublisherService;
    @Autowired
    private MailRequestToMessageConverter mailRequestToMessageConverter;

    @RequestMapping(value = "/mail", method = RequestMethod.POST)
    public MailResponse send(@RequestBody MailRequest request) {
        MailResponse response = new MailResponse();

        try {
            MailMessage message = mailRequestToMessageConverter.convert(request);
            mailMQPublisherService.publishMailMessage(message);
            response.setStatus(ResponseStatusType.SUCCESS.getValue());

        } catch(Exception e){
            response.setStatus(ResponseStatusType.FAILURE.getValue());
        }
        return response;
    }

}
