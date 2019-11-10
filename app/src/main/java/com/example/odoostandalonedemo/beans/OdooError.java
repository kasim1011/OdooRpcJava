package com.example.odoostandalonedemo.beans;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class OdooError {

    @NonNull
    @SerializedName("message")
    private String message = "";

    @SerializedName("code")
    private int code = 200;

    @NonNull
    @SerializedName("data")
    private Data data = new Data();

    public OdooError() {
    }

    @NonNull
    public String getMessage() {
        return message;
    }

    public void setMessage(@NonNull String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @NonNull
    public Data getData() {
        return data;
    }

    public void setData(@NonNull Data data) {
        this.data = data;
    }

    @NotNull
    @Override
    public String toString() {
        return "OdooError{" +
                "message='" + message + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }

    public static class Data {

        @NonNull
        @SerializedName("debug")
        private String debug = "";

        @NonNull
        @SerializedName("exception_type")
        private String exceptionType = "";

        @NonNull
        @SerializedName("message")
        private String message = "";

        @NonNull
        @SerializedName("name")
        private String name = "";

        @NonNull
        @SerializedName("arguments")
        private List<String> arguments = new ArrayList<>();

        public Data() {
        }

        @NonNull
        public String getDebug() {
            return debug;
        }

        public void setDebug(@NonNull String debug) {
            this.debug = debug;
        }

        @NonNull
        public String getExceptionType() {
            return exceptionType;
        }

        public void setExceptionType(@NonNull String exceptionType) {
            this.exceptionType = exceptionType;
        }

        @NonNull
        public String getMessage() {
            return message;
        }

        public void setMessage(@NonNull String message) {
            this.message = message;
        }

        @NonNull
        public String getName() {
            return name;
        }

        public void setName(@NonNull String name) {
            this.name = name;
        }

        @NonNull
        public List<String> getArguments() {
            return arguments;
        }

        public void setArguments(@NonNull List<String> arguments) {
            this.arguments = arguments;
        }

        @NotNull
        @Override
        public String toString() {
            return "Data{" +
                    "debug='" + debug + '\'' +
                    ", exceptionType='" + exceptionType + '\'' +
                    ", message='" + message + '\'' +
                    ", name='" + name + '\'' +
                    ", arguments=" + arguments +
                    '}';
        }
    }
}
