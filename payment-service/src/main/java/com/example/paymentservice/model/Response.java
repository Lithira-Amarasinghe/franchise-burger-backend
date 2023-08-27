package com.example.paymentservice.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
public class Response <T>{
private HttpStatus httpStatus;
private T response;
}
