package com.example.msproductcatalog.client;

import com.example.msproductcatalog.model.request.UserRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



    @FeignClient(name = "ms-mail-sender", url = "http://localhost:8080")
    public interface MailSenderClient {
        @PostMapping("/send")
        ResponseEntity<Void> sendMail(@RequestBody UserRequest userRequest);
    }