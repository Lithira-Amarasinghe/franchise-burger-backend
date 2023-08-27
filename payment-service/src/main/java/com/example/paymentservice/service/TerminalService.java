package com.example.paymentservice.service;

import com.example.paymentservice.model.ReaderRegistrationRequest;
import com.stripe.model.terminal.Reader;
import com.stripe.model.terminal.ReaderCollection;
import org.springframework.stereotype.Service;

@Service
public interface TerminalService {
    ReaderCollection getAllReadersAt(String locationId);

    Reader registerTerminal(ReaderRegistrationRequest readerRegistrationRequest);

    Reader getReader(String terminalId);
}
