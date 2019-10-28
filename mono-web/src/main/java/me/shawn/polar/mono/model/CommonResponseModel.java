package me.shawn.polar.mono.model;

import java.time.LocalDateTime;

public class CommonResponseModel<T> {
    private String status;
    private String message;
    private T data;
    private LocalDateTime requestAt;

    public CommonResponseModel(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.requestAt = LocalDateTime.now();
    }

    public static CommonResponseModel.Builder builder() {
        return new Builder();
    }

    public String getStatus() {
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

    static class Builder<T> {
        private String status;
        private String message;
        private T data;

        public Builder status(String status) {
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
