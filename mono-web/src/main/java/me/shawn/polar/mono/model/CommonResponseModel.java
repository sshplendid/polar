package me.shawn.polar.mono.model;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class CommonResponseModel<T> {
    private HttpStatus status;
    private String message;
    private T data;
    private LocalDateTime requestAt;

    public CommonResponseModel(HttpStatus status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.requestAt = LocalDateTime.now();
    }

    public String toJson() {
        return toString();
    }

    @Override
    public String toString() {
        return "CommonResponseModel{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data.toString() +
                ", requestAt=" + requestAt +
                '}';
    }

    public static CommonResponseModel.Builder builder() {
        return new Builder();
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public LocalDateTime getRequestAt() {
        return requestAt;
    }

    public static class Builder<T> {
        private HttpStatus status;
        private String message;
        private T data;

        public Builder status(HttpStatus status) {
            this.status = status;
            return this;
        }
        public Builder message(String message) {
            this.message = message;
            return this;
        }
        public Builder data(T data) {
            this.data = data;
            return this;
        }

        public CommonResponseModel<T> build() {
            return new CommonResponseModel<>(status, message, data);
        }

    }
}
