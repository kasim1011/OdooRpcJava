package com.example.odoostandalonedemo.beans;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

import okhttp3.Cookie;

public class ClonedCookie {

    @NonNull
    @SerializedName("name")
    private String name = "";
    @NonNull
    @SerializedName("value")
    private String value = "";
    @NonNull
    @SerializedName("domain")
    private String domain = "";
    @NonNull
    @SerializedName("path")
    private String path = "";
    @SerializedName("expiresAt")
    private long expiresAt = 0L;
    @SerializedName("secure")
    private boolean secure = false;
    @SerializedName("httpOnly")
    private boolean httpOnly = false;
    @SerializedName("persistent")
    private boolean persistent = false;
    @SerializedName("hostOnly")
    private boolean hostOnly = false;

    // Required for gson
    public ClonedCookie() {
    }

    private ClonedCookie(
            @NonNull String name, @NonNull String value, @NonNull String domain, @NonNull String path,
            long expiresAt, boolean secure, boolean httpOnly, boolean persistent, boolean hostOnly
    ) {
        this.name = name;
        this.value = value;
        this.domain = domain;
        this.path = path;
        this.expiresAt = expiresAt;
        this.secure = secure;
        this.httpOnly = httpOnly;
        this.persistent = persistent;
        this.hostOnly = hostOnly;
    }

    public static ClonedCookie fromCookie(Cookie cookie) {
        return new ClonedCookie(
                cookie.name(), cookie.value(), cookie.domain(), cookie.path(),
                cookie.expiresAt(), cookie.secure(), cookie.httpOnly(),
                cookie.persistent(), cookie.hostOnly()
        );
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getValue() {
        return value;
    }

    public void setValue(@NonNull String value) {
        this.value = value;
    }

    @NonNull
    public String getDomain() {
        return domain;
    }

    public void setDomain(@NonNull String domain) {
        this.domain = domain;
    }

    @NonNull
    public String getPath() {
        return path;
    }

    public void setPath(@NonNull String path) {
        this.path = path;
    }

    public long getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(long expiresAt) {
        this.expiresAt = expiresAt;
    }

    public boolean isSecure() {
        return secure;
    }

    public void setSecure(boolean secure) {
        this.secure = secure;
    }

    public boolean isHttpOnly() {
        return httpOnly;
    }

    public void setHttpOnly(boolean httpOnly) {
        this.httpOnly = httpOnly;
    }

    public boolean isPersistent() {
        return persistent;
    }

    public void setPersistent(boolean persistent) {
        this.persistent = persistent;
    }

    public boolean isHostOnly() {
        return hostOnly;
    }

    public void setHostOnly(boolean hostOnly) {
        this.hostOnly = hostOnly;
    }

    public Cookie toCookie() {
        Cookie.Builder builder = new Cookie.Builder();
        builder.name(name);
        builder.value(value);
        builder.domain(domain);
        builder.path(path);
        builder.expiresAt(expiresAt);
        if (secure) {
            builder.secure();
        }
        if (httpOnly) {
            builder.httpOnly();
        }
        if (hostOnly) {
            builder.hostOnlyDomain(domain);
        }
        return builder.build();
    }

    @NotNull
    @Override
    public String toString() {
        return "ClonedCookie{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", domain='" + domain + '\'' +
                ", path='" + path + '\'' +
                ", expiresAt=" + expiresAt +
                ", secure=" + secure +
                ", httpOnly=" + httpOnly +
                ", persistent=" + persistent +
                ", hostOnly=" + hostOnly +
                '}';
    }
}
