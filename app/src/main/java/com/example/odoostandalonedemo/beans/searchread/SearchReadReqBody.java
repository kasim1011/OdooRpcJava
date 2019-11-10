package com.example.odoostandalonedemo.beans.searchread;

import androidx.annotation.NonNull;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class SearchReadReqBody {

    @NonNull
    @SerializedName("id")
    private String id = "0";

    @NonNull
    @SerializedName("jsonrpc")
    private String jsonRPC = "2.0";

    @NonNull
    @SerializedName("method")
    private String method = "call";

    @NonNull
    @SerializedName("params")
    private SearchReadParams params = new SearchReadParams();

    public SearchReadReqBody() {
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    @NonNull
    public String getJsonRPC() {
        return jsonRPC;
    }

    public void setJsonRPC(@NonNull String jsonRPC) {
        this.jsonRPC = jsonRPC;
    }

    @NonNull
    public String getMethod() {
        return method;
    }

    public void setMethod(@NonNull String method) {
        this.method = method;
    }

    @NonNull
    public SearchReadParams getParams() {
        return params;
    }

    public void setParams(@NonNull SearchReadParams params) {
        this.params = params;
    }

    @NotNull
    @Override
    public String toString() {
        return "SearchReadReqBody{" +
                "id='" + id + '\'' +
                ", jsonRPC='" + jsonRPC + '\'' +
                ", method='" + method + '\'' +
                ", params=" + params +
                '}';
    }

    public static class SearchReadParams {

        @NonNull
        @SerializedName("model")
        private String model = "";

        @NonNull
        @SerializedName("fields")
        private List<String> fields = new ArrayList<>();

        @NonNull
        @SerializedName("domain")
        private List<Object> domain = new ArrayList<>();

        @SerializedName("offset")
        private int offser = 0;

        @SerializedName("limit")
        private int limit = 0;

        @NonNull
        @SerializedName("sort")
        private String sort = "";

        @NonNull
        @SerializedName("context")
        private JsonObject context = new JsonObject();

        public SearchReadParams() {
        }

        @NonNull
        public String getModel() {
            return model;
        }

        public void setModel(@NonNull String model) {
            this.model = model;
        }

        @NonNull
        public List<String> getFields() {
            return fields;
        }

        public void setFields(@NonNull List<String> fields) {
            this.fields = fields;
        }

        @NonNull
        public List<Object> getDomain() {
            return domain;
        }

        public void setDomain(@NonNull List<Object> domain) {
            this.domain = domain;
        }

        public int getOffser() {
            return offser;
        }

        public void setOffser(int offser) {
            this.offser = offser;
        }

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        @NonNull
        public String getSort() {
            return sort;
        }

        public void setSort(@NonNull String sort) {
            this.sort = sort;
        }

        @NonNull
        public JsonObject getContext() {
            return context;
        }

        public void setContext(@NonNull JsonObject context) {
            this.context = context;
        }

        @NotNull
        @Override
        public String toString() {
            return "SearchReadParams{" +
                    "model='" + model + '\'' +
                    ", fields=" + fields +
                    ", domain=" + domain +
                    ", offser=" + offser +
                    ", limit=" + limit +
                    ", sort='" + sort + '\'' +
                    ", context=" + context +
                    '}';
        }
    }
}
