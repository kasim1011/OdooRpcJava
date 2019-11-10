package com.example.odoostandalonedemo.beans.authenticate;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class AuthenticateReqBody {

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
    private AuthenticateParams params = new AuthenticateParams();

    public AuthenticateReqBody() {
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
    public AuthenticateParams getParams() {
        return params;
    }

    public void setParams(@NonNull AuthenticateParams params) {
        this.params = params;
    }

    @NotNull
    @Override
    public String toString() {
        return "AuthenticateReqBody{" +
                "id='" + id + '\'' +
                ", jsonRPC='" + jsonRPC + '\'' +
                ", method='" + method + '\'' +
                ", params=" + params +
                '}';
    }

    public static class AuthenticateParams {

        @NonNull
        @SerializedName("login")
        private String login = "";

        @NonNull
        @SerializedName("password")
        private String password = "";

        @NonNull
        @SerializedName("db")
        private String db = "";

        public AuthenticateParams() {
        }

        @NonNull
        public String getLogin() {
            return login;
        }

        public void setLogin(@NonNull String login) {
            this.login = login;
        }

        @NonNull
        public String getPassword() {
            return password;
        }

        public void setPassword(@NonNull String password) {
            this.password = password;
        }

        @NonNull
        public String getDb() {
            return db;
        }

        public void setDb(@NonNull String db) {
            this.db = db;
        }

        @NotNull
        @Override
        public String toString() {
            return "AuthenticateParams{" +
                    "login='" + login + '\'' +
                    ", password='" + password + '\'' +
                    ", db='" + db + '\'' +
                    '}';
        }
    }

}
