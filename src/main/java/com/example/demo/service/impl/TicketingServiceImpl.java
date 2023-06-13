package com.example.demo.service.impl;

import com.example.demo.dto.ResponseDto;
import com.example.demo.dto.TicketingDto;
import com.example.demo.model.Ticketing;
import com.example.demo.repository.TicketingRepository;
import com.example.demo.service.TicketingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketingServiceImpl implements TicketingService {
    @Autowired
    private TicketingRepository ticketingRepository;

    @Override
    public ResponseDto insert(TicketingDto ticketingDto) {
        ResponseDto responseDto = new ResponseDto();
        Ticketing ticketing = new Ticketing();
        try {
            ticketing.setContactNumber(ticketingDto.getContactNumber());
            ticketing.setName(ticketingDto.getName());
            ticketing.setEmail(ticketingDto.getEmail());
            ticketing.setStudentId(ticketingDto.getStudentId());
            ticketing.setIsSentEmail(ticketingDto.getIsSentEmail());
            ticketing.setStatus(ticketingDto.getStatus());
            ticketing.setIsSentMessage(ticketingDto.getIsSentMessage());
            ticketingRepository.save(ticketing);
            responseDto.setCode(200);
            responseDto.setMzg("Insert data");
            return responseDto;
        } catch (Exception e) {
            responseDto.setCode(500);
            responseDto.setMzg("Internal server error");
            return responseDto;
        }
    }

    public ResponseDto update(TicketingDto ticketingDto) {
        ResponseDto responseDto = new ResponseDto();
        try {
            Optional<Ticketing> optionalTicketing = ticketingRepository.findById(ticketingDto.getId());
            if (optionalTicketing.isPresent()) {
                Ticketing ticketing = optionalTicketing.get();
                ticketing.setContactNumber(ticketingDto.getContactNumber());
                ticketing.setName(ticketingDto.getName());
                ticketing.setEmail(ticketingDto.getEmail());
                ticketing.setStudentId(ticketingDto.getStudentId());
                ticketing.setIsSentMessage(ticketingDto.getIsSentMessage());
                ticketing.setIsSentEmail(ticketingDto.getIsSentEmail());
                ticketing.setStatus(ticketingDto.getStatus());
                ticketingRepository.save(ticketing);
                responseDto.setCode(200);
                responseDto.setMzg("Updated data");
                return responseDto;
            } else {
                responseDto.setCode(404);
                responseDto.setMzg("user not found");
                return responseDto;
            }
        } catch (Exception e) {
            responseDto.setCode(500);
            responseDto.setMzg("Internal server error");
            return responseDto;

        }
    }

    @Override
    public ResponseDto delete(int id) {
        ResponseDto responseDto = new ResponseDto();
        try {
            ticketingRepository.deleteById(id);
            responseDto.setCode(200);
            responseDto.setMzg("Deleted data");
            return responseDto;
        } catch (Exception e) {
            responseDto.setCode(500);
            responseDto.setMzg("Internal server error");
            return responseDto;

        }
    }

    @Override
    public ResponseDto allData() {
        ResponseDto responseDto = new ResponseDto();
        List<Ticketing> all = ticketingRepository.findAll();
        responseDto.setMzg("all data");
        responseDto.setCode(200);
        responseDto.setData(all);
        return responseDto;
    }

    public ResponseDto isEmail(String isSentEmail, int id) {
        ResponseDto responseDto = new ResponseDto();
        Optional<Ticketing> optionalTicketing = ticketingRepository.findById(id);
        if (optionalTicketing.isPresent()) {
            Ticketing ticketing = optionalTicketing.get();
            ticketing.setIsSentEmail(isSentEmail);
            ticketingRepository.save(ticketing);
            responseDto.setCode(200);
            responseDto.setMzg("updated isSentEmail");
            return responseDto;
        } else {
            responseDto.setCode(404);
            responseDto.setMzg("User not found");
            return responseDto;
        }

    }

    public ResponseDto isMessage(String isSentMessage, int id) {
        ResponseDto responseDto = new ResponseDto();
        Optional<Ticketing> optionalTicketing = ticketingRepository.findById(id);
        if (optionalTicketing.isPresent()) {
            Ticketing ticketing = optionalTicketing.get();
            ticketing.setIsSentMessage(isSentMessage);
            ticketingRepository.save(ticketing);
            responseDto.setCode(200);
            responseDto.setMzg("updated isMessage");
            return responseDto;
        } else {
            responseDto.setCode(404);
            responseDto.setMzg("User not found");
            return responseDto;
        }
    }

    public ResponseDto status(String status, int id) {
        ResponseDto responseDto = new ResponseDto();
        Optional<Ticketing> optionalTicketing = ticketingRepository.findById(id);
        if (optionalTicketing.isPresent()) {
            Ticketing ticketing = optionalTicketing.get();
            ticketing.setStatus(status);
            ticketingRepository.save(ticketing);
            responseDto.setCode(200);
            responseDto.setMzg("updated status");
            return responseDto;
        } else {
            responseDto.setCode(404);
            responseDto.setMzg("User not found");
            return responseDto;
        }
    }
}
