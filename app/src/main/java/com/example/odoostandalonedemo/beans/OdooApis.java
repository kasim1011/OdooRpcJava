package com.example.odoostandalonedemo.beans;

import androidx.annotation.NonNull;

import com.example.odoostandalonedemo.beans.authenticate.Authenticate;
import com.example.odoostandalonedemo.beans.authenticate.AuthenticateReqBody;
import com.example.odoostandalonedemo.beans.searchread.SearchRead;
import com.example.odoostandalonedemo.beans.searchread.SearchReadReqBody;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface OdooApis {

    @NonNull
    @POST("/web/session/authenticate")
    Call<Authenticate> authenticate(
            @NonNull @Body AuthenticateReqBody reqBody
    );

    @NonNull
    @POST("/web/dataset/search_read")
    Call<SearchRead> searchRead(
            @NonNull @Body SearchReadReqBody reqBody
    );
}
