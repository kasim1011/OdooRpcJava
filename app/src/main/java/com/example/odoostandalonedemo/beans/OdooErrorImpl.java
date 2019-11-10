package com.example.odoostandalonedemo.beans;

import androidx.annotation.NonNull;

public interface OdooErrorImpl {

    boolean isSuccessful();

    int errorCode();

    @NonNull
    String errorMessage();
}
