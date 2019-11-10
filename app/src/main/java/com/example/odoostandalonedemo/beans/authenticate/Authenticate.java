package com.example.odoostandalonedemo.beans.authenticate;

import androidx.annotation.NonNull;

import com.example.odoostandalonedemo.beans.OdooError;
import com.example.odoostandalonedemo.beans.OdooErrorImpl;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class Authenticate implements OdooErrorImpl {

    @NonNull
    @SerializedName("result")
    private Result result = new Result();

    @NonNull
    @SerializedName("error")
    private OdooError error = new OdooError();

    public Authenticate() {
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
        return "Authenticate{" +
                "result=" + result +
                ", error=" + error +
                '}';
    }

    public static class Result {

        @SerializedName("uid")
        private long uid = 0L;

        @SerializedName("is_system")
        private boolean isSystem = false;

        @SerializedName("is_admin")
        private boolean isAdmin = false;

        @NonNull
        @SerializedName("user_context")
        private JsonObject userContext = new JsonObject();

        @NonNull
        @SerializedName("db")
        private String db = "";

        @NonNull
        @SerializedName("server_version")
        private String serverVersion = "";

        @NonNull
        @SerializedName("server_version_info")
        private JsonArray serverVersionInfo = new JsonArray();

        @NonNull
        @SerializedName("name")
        private String name = "";

        @NonNull
        @SerializedName("username")
        private String username = "";

        @NonNull
        @SerializedName("partner_display_name")
        private String partnerDisplayName = "";

        @SerializedName("company_id")
        private long companyId = 0L;

        @SerializedName("partner_id")
        private long partnerId = 0L;

        @NonNull
        @SerializedName("user_companies")
        private JsonObject userCompanies = new JsonObject();

        @NonNull
        @SerializedName("currencies")
        private JsonObject currencies = new JsonObject();

        @NonNull
        @SerializedName("web.base.url")
        private String webBaseUrl = "";

        public Result() {
        }

        public long getUid() {
            return uid;
        }

        public void setUid(long uid) {
            this.uid = uid;
        }

        public boolean isSystem() {
            return isSystem;
        }

        public void setSystem(boolean system) {
            isSystem = system;
        }

        public boolean isAdmin() {
            return isAdmin;
        }

        public void setAdmin(boolean admin) {
            isAdmin = admin;
        }

        @NonNull
        public JsonObject getUserContext() {
            return userContext;
        }

        public void setUserContext(@NonNull JsonObject userContext) {
            this.userContext = userContext;
        }

        @NonNull
        public String getDb() {
            return db;
        }

        public void setDb(@NonNull String db) {
            this.db = db;
        }

        @NonNull
        public String getServerVersion() {
            return serverVersion;
        }

        public void setServerVersion(@NonNull String serverVersion) {
            this.serverVersion = serverVersion;
        }

        @NonNull
        public JsonArray getServerVersionInfo() {
            return serverVersionInfo;
        }

        public void setServerVersionInfo(@NonNull JsonArray serverVersionInfo) {
            this.serverVersionInfo = serverVersionInfo;
        }

        @NonNull
        public String getName() {
            return name;
        }

        public void setName(@NonNull String name) {
            this.name = name;
        }

        @NonNull
        public String getUsername() {
            return username;
        }

        public void setUsername(@NonNull String username) {
            this.username = username;
        }

        @NonNull
        public String getPartnerDisplayName() {
            return partnerDisplayName;
        }

        public void setPartnerDisplayName(@NonNull String partnerDisplayName) {
            this.partnerDisplayName = partnerDisplayName;
        }

        public long getCompanyId() {
            return companyId;
        }

        public void setCompanyId(long companyId) {
            this.companyId = companyId;
        }

        public long getPartnerId() {
            return partnerId;
        }

        public void setPartnerId(long partnerId) {
            this.partnerId = partnerId;
        }

        @NonNull
        public JsonObject getUserCompanies() {
            return userCompanies;
        }

        public void setUserCompanies(@NonNull JsonObject userCompanies) {
            this.userCompanies = userCompanies;
        }

        @NonNull
        public JsonObject getCurrencies() {
            return currencies;
        }

        public void setCurrencies(@NonNull JsonObject currencies) {
            this.currencies = currencies;
        }

        @NonNull
        public String getWebBaseUrl() {
            return webBaseUrl;
        }

        public void setWebBaseUrl(@NonNull String webBaseUrl) {
            this.webBaseUrl = webBaseUrl;
        }

        @NotNull
        @Override
        public String toString() {
            return "AuthenticateResult{" +
                    "uid=" + uid +
                    ", isSystem=" + isSystem +
                    ", isAdmin=" + isAdmin +
                    ", userContext=" + userContext +
                    ", db='" + db + '\'' +
                    ", serverVersion='" + serverVersion + '\'' +
                    ", serverVersionInfo=" + serverVersionInfo +
                    ", name='" + name + '\'' +
                    ", username='" + username + '\'' +
                    ", partnerDisplayName='" + partnerDisplayName + '\'' +
                    ", companyId=" + companyId +
                    ", partnerId=" + partnerId +
                    ", userCompanies=" + userCompanies +
                    ", currencies=" + currencies +
                    ", webBaseUrl='" + webBaseUrl + '\'' +
                    '}';
        }
    }

}
