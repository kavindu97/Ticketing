package com.example.demo.service;

import com.example.demo.dto.ResponseDto;
import com.example.demo.dto.TicketingDto;

public interface TicketingService {
    ResponseDto insert (TicketingDto ticketingDto);
    ResponseDto update(TicketingDto ticketingDto);
    ResponseDto delete(int id);
    ResponseDto allData();
    ResponseDto isEmail(String isSentEmail,int id);
    ResponseDto status(String status,int id);
    ResponseDto isMessage(String isSentMessage,int id);

}
