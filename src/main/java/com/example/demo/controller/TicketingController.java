package com.example.demo.controller;

import com.example.demo.dto.ResponseDto;
import com.example.demo.dto.TicketingDto;
import com.example.demo.service.TicketingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/ticket")
public class TicketingController {
    @Autowired
    private TicketingService ticketingService;

    @PostMapping("/insert")
    public ResponseDto insert(@RequestBody TicketingDto ticketingDto) {
        return ticketingService.insert(ticketingDto);
    }

    @PutMapping("/update")
    public ResponseDto update(@RequestBody TicketingDto ticketingDto) {
        return ticketingService.update(ticketingDto);
    }

    @GetMapping("/all")
    public ResponseDto allData() {
        return ticketingService.allData();
    }

    @DeleteMapping("/delete")
    public ResponseDto delete(@RequestParam int id) {
        return ticketingService.delete(id);
    }
}
