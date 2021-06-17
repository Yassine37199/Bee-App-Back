package com.beeauto.Twilio;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController("twilio")
@RequestMapping("sms")
public class SmsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SmsController.class);
    private final TwilioConfig twilioConfiguration;

    @Autowired
    public SmsController(TwilioConfig twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }

    @PostMapping("/send")
    public SmsRequest sendSms(@RequestBody SmsRequest smsRequest) {
        if(isPhoneNumberValid(smsRequest.getPhoneNumber())) {
            MessageCreator creator = Message.creator(
                    new PhoneNumber(smsRequest.getPhoneNumber()),
                    new PhoneNumber(twilioConfiguration.getTrialNumber()),
                    smsRequest.getMessage()
            );
            creator.create();
            LOGGER.info("Send SMS " + smsRequest);
            return smsRequest;
        }
        else {
            throw new IllegalArgumentException("Phone Number not valid");
        }

    }

    private boolean isPhoneNumberValid(String phoneNumber) {
        return true;
    }
}
