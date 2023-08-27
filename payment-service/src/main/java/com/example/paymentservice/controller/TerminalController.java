package com.example.paymentservice.controller;

import com.example.paymentservice.model.ReaderRegistrationRequest;
import com.example.paymentservice.service.TerminalService;
import com.stripe.model.terminal.Reader;
import com.stripe.model.terminal.ReaderCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/terminal")
public class TerminalController {
    @Autowired
    private TerminalService terminalService;

    @PostMapping("/register")
    public ResponseEntity registerTerminal(@RequestBody ReaderRegistrationRequest readerRegistrationRequest) {
        Reader reader = terminalService.registerTerminal(readerRegistrationRequest);
        return ResponseEntity.status(200).body(reader.toJson());
    }

    @GetMapping()
    public ResponseEntity getTerminalDetails(@RequestParam String terminalId) {
        Reader reader = terminalService.getReader(terminalId);
        return ResponseEntity.status(200).body(reader.toJson());
    }

    @GetMapping("/{locationId}")
    public ResponseEntity getAllReadersAt(@PathVariable String locationId) {

        ReaderCollection allReadersAt = this.terminalService.getAllReadersAt(locationId);
        return ResponseEntity.ok(allReadersAt.toJson());
    }
}
