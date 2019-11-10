package com.example.odoostandalonedemo.beans.searchread;

import androidx.annotation.NonNull;

import com.example.odoostandalonedemo.beans.OdooError;
import com.example.odoostandalonedemo.beans.OdooErrorImpl;
import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class SearchRead implements OdooErrorImpl {

    @NonNull
    @SerializedName("result")
    private Result result = new Result();

    @NonNull
    @SerializedName("error")
    private OdooError error = new OdooError();

    public SearchRead() {
    }

    @NonNull
    public Result getResult() {
        return result;
    }

    public void setResult(@NonNull Result result) {
        this.result = result;
    }

    @NonNull
    public OdooError getError() {
        return error;
    }

    public void setError(@NonNull OdooError error) {
        this.error = error;
    }

    @Override
    public boolean isSuccessful() {
        return error.getMessage().isEmpty();
    }

    @Override
    public int errorCode() {
        return error.getCode();
    }

    @NonNull
    @Override
    public String errorMessage() {
        return error.getMessage();
    }

    @NotNull
    @Override
    public String toString() {
        return "SearchRead{" +
                "result=" + result +
                ", error=" + error +
                '}';
    }

    public static class Result {

        @NonNull
        @SerializedName("records")
        private JsonArray records = new JsonArray();

        @SerializedName("length")
        private int length = 0;

        public Result() {
        }

        @NonNull
        public JsonArray getRecords() {
            return records;
        }

        public void setRecords(@NonNull JsonArray records) {
            this.records = records;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        @NotNull
        @Override
        public String toString() {
            return "Result{" +
                    "records=" + records +
                    ", length=" + length +
                    '}';
        }
    }
}
