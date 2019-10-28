package me.shawn.polar.mono.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CommonResponseModelTest {

    @Test
    public void beanTest() {
        // GIVEN
        String status = "SUCCESS";
        String message = "JUnit test";
        String data = "This is secret data.";
        LocalDateTime beforeGenerate = LocalDateTime.now();

        // WHEN
        CommonResponseModel<String> responseModel = new CommonResponseModel<>(status, message, data);
        LocalDateTime afterGenerate = LocalDateTime.now();

        // THEN
        assertEquals(status, responseModel.getStatus());
        assertEquals(message, responseModel.getMessage());
        assertEquals(data, responseModel.getData());
        assertTrue(beforeGenerate.isBefore(responseModel.getRequestAt())
        || beforeGenerate.isEqual(responseModel.getRequestAt()));
        assertTrue(afterGenerate.isAfter(responseModel.getRequestAt())
                || afterGenerate.isEqual(responseModel.getRequestAt()));
    }

    @Test
    public void builderTest() {
        // GIVEN
        String status = "SUCCESS";
        String message = "JUnit test";
        String data = "This is secret data.";
        LocalDateTime beforeGenerate = LocalDateTime.now();

        // WHEN
        CommonResponseModel<String> responseModel = CommonResponseModel.builder()
                .status(status)
                .message(message)
                .data(data)
                .build();
        LocalDateTime afterGenerate = LocalDateTime.now();

        // THEN
        assertEquals(status, responseModel.getStatus());
        assertEquals(message, responseModel.getMessage());
        assertEquals(data, responseModel.getData());
        assertTrue(beforeGenerate.isBefore(responseModel.getRequestAt())
                || beforeGenerate.isEqual(responseModel.getRequestAt()));
        assertTrue(afterGenerate.isAfter(responseModel.getRequestAt())
                || afterGenerate.isEqual(responseModel.getRequestAt()));
    }
}
