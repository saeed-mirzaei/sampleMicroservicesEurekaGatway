package com.example.sampleMicroservice.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.NotFoundException;

import java.io.IOException;
import java.io.InputStream;

public class CustomErrorHandling implements ErrorDecoder {
    private final ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        String message = null;
        try (InputStream bodyIs = response.body().asInputStream()) {
            ObjectMapper mapper = new ObjectMapper();
            message = mapper.readValue(bodyIs, String.class);
        } catch (IOException e) {
            return new Exception(e.getMessage());
        }        switch (response.status()) {
            case 400:
                return new BadRequestException(message != null ? message : "Bad Request");
            case 404:
                return new NotFoundException(message != null ? message : "Not found");
            default:
                return errorDecoder.decode(methodKey, response);
        }    }
}
