package com.example.paymentservice.controller;

import com.example.paymentservice.model.ReaderRegistrationRequest;
import com.example.paymentservice.model.Response;
import com.example.paymentservice.service.TerminalService;
import com.stripe.model.terminal.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/terminal")
public class TerminalController {
    @Autowired
    private TerminalService terminalService;

    @PostMapping("/register")
    public Response<Reader> registerTerminal(@RequestBody ReaderRegistrationRequest readerRegistrationRequest) {
        return new Response<>(
                HttpStatus.OK,
                terminalService.registerTerminal(readerRegistrationRequest)
        );
    }

    @GetMapping()
    public Response<Reader> getTerminalDetails(@RequestParam String terminalId) {
        return new Response<>(
                HttpStatus.OK,
                terminalService.getReader(terminalId)
        );
    }

    @GetMapping("/{locationId}")
    public Response getAllReadersAt(@PathVariable String locationId) {
        return
                new Response(
                        HttpStatus.OK,
                        this.terminalService.getAllReadersAt(locationId)
                );
    }
}
