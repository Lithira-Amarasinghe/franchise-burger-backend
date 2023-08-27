package com.example.paymentservice.controller;

import com.example.paymentservice.model.TappingCardSimulateRequest;
import com.example.paymentservice.service.TappingCardSimulateService;
import com.stripe.model.terminal.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/terminal/simulate")
public class TerminalSimulateController {
    @Autowired
    private TappingCardSimulateService tappingCardSimulateService;
    @PostMapping("/tappingCard")
    public ResponseEntity tappingCard(@RequestBody TappingCardSimulateRequest tappingCardSimulateRequest){
        Reader reader = tappingCardSimulateService.tapACard(tappingCardSimulateRequest.getTerminalId());
        return ResponseEntity.ok(reader.toJson());
    }
}
