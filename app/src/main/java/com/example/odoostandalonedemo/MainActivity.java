package com.example.odoostandalonedemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.odoostandalonedemo.beans.ClonedCookie;
import com.example.odoostandalonedemo.beans.OdooApis;
import com.example.odoostandalonedemo.beans.OdooError;
import com.example.odoostandalonedemo.beans.authenticate.Authenticate;
import com.example.odoostandalonedemo.beans.authenticate.AuthenticateReqBody;
import com.example.odoostandalonedemo.beans.searchread.SearchRead;
import com.example.odoostandalonedemo.beans.searchread.SearchReadReqBody;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    public static final String BASE_URL = "http://683633-13-0-aa0554.runbot28.odoo.com";
    public static final String LOGIN = "admin";
    public static final String PASSWORD = "admin";
    public static final String DATABASE = "683633-13-0-aa0554-base";

    private OdooApis apis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        apis = createRetrofit();

        boolean isLogin = isLogin();
        Timber.d("isLogin is %s", isLogin);
        if (isLogin) {
            searchRead();
        } else {
            authenticate();
        }
    }

    private boolean isLogin() {
        SharedPreferences preferences = getSharedPreferences("cookies_pref", Context.MODE_PRIVATE);
        String cookiesStr = preferences.getString("cookies", "[]");

        Gson gson = new Gson();
        Type clonedCookiesType = new TypeToken<ArrayList<ClonedCookie>>() {
        }.getType();
        ArrayList<ClonedCookie> clonedCookies = gson.fromJson(cookiesStr, clonedCookiesType);
        return clonedCookies.size() > 0;
    }

    private void searchRead() {
        Timber.d("searchRead:");

        SearchReadReqBody.SearchReadParams params = new SearchReadReqBody.SearchReadParams();
        params.setModel("res.partner");
        params.setFields(Arrays.asList("id", "name", "email"));
        params.setDomain(Arrays.asList(
                "|",
                Arrays.asList("is_company", "=", false),
                Arrays.asList("partner_share", "=", true)
        ));
        params.setSort("name ASC");
        SearchReadReqBody reqBody = new SearchReadReqBody();
        reqBody.setParams(params);
        apis.searchRead(reqBody).enqueue(new Callback<SearchRead>() {
            @Override
            public void onResponse(@NotNull Call<SearchRead> call, @NotNull Response<SearchRead> response) {
                if (response.isSuccessful()) {
                    SearchRead body = response.body();
                    if (body != null) {
                        if (body.isSuccessful()) {
                            SearchRead.Result result = body.getResult();
                            JsonArray records = result.getRecords();

                        } else {
                            Timber.w("searchRead: response failed with: code %s, message %s", body.errorCode(), body.errorMessage());
                            OdooError.Data data = body.getError().getData();
                            Timber.w("searchRead: message %s", data.getMessage());
                        }
                    } else {
                        Timber.w("searchRead: response body null!!");
                    }
                } else {
                    Timber.w("searchRead: request failed: code %s, message %s", response.code(), response.message());
                }
            }

            @Override
            public void onFailure(@NotNull Call<SearchRead> call, @NotNull Throwable t) {
                Timber.w("searchRead: request failure: %s", t.getMessage());
                t.printStackTrace();
            }
        });
    }

    private void authenticate() {
        Timber.d("authenticate:");
        AuthenticateReqBody.AuthenticateParams params = new AuthenticateReqBody.AuthenticateParams();
        params.setLogin(LOGIN);
        params.setPassword(PASSWORD);
        params.setDb(DATABASE);
        AuthenticateReqBody reqBody = new AuthenticateReqBody();
        reqBody.setParams(params);
        apis.authenticate(reqBody).enqueue(new Callback<Authenticate>() {
            @Override
            public void onResponse(@NotNull Call<Authenticate> call, @NotNull Response<Authenticate> response) {
                if (response.isSuccessful()) {
                    Authenticate body = response.body();
                    if (body != null) {
                        if (body.isSuccessful()) {
                            // Authenticate.Result result = body.getResult();
                            searchRead();
                        } else {
                            Timber.w("authenticate: response failed with: code %s, message %s", body.errorCode(), body.errorMessage());
                            OdooError.Data data = body.getError().getData();
                            Timber.w("authenticate: message %s", data.getMessage());
                        }
                    } else {
                        Timber.w("authenticate: response body null!!");
                    }
                } else {
                    Timber.w("authenticate: request failed: code %s, message %s", response.code(), response.message());
                }
            }

            @Override
            public void onFailure(@NotNull Call<Authenticate> call, @NotNull Throwable t) {
                Timber.w("authenticate: request failure: %s", t.getMessage());
                t.printStackTrace();
            }
        });
    }

    @NonNull
    private OdooApis createRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(prepareClientForRetrofit())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(OdooApis.class);
    }

    @NonNull
    private OkHttpClient prepareClientForRetrofit() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.cookieJar(new CookieJar() {

            @NonNull
            private List<Cookie> cookies = getCookies();

            @Override
            public void saveFromResponse(@NotNull HttpUrl url, @NotNull List<Cookie> cookies) {
                this.cookies = cookies;
                storeCookies(cookies);
            }

            @NotNull
            @Override
            public List<Cookie> loadForRequest(@NotNull HttpUrl url) {
                return cookies;
            }


            private void storeCookies(@NonNull List<Cookie> cookies) {
                ArrayList<ClonedCookie> clonedCookies = new ArrayList<>();
                for (Cookie cookie : cookies) {
                    clonedCookies.add(ClonedCookie.fromCookie(cookie));
                }
                Gson gson = new Gson();
                String cookiesStr = gson.toJson(clonedCookies);

                // save in sharedPreferences
                SharedPreferences preferences = getSharedPreferences("cookies_pref", Context.MODE_PRIVATE);
                preferences.edit().putString("cookies", cookiesStr).apply();
            }

            @NonNull
            private List<Cookie> getCookies() {
                SharedPreferences preferences = getSharedPreferences("cookies_pref", Context.MODE_PRIVATE);
                String cookiesStr = preferences.getString("cookies", "[]");

                Gson gson = new Gson();
                Type clonedCookiesType = new TypeToken<ArrayList<ClonedCookie>>() {
                }.getType();
                ArrayList<ClonedCookie> clonedCookies = gson.fromJson(cookiesStr, clonedCookiesType);

                ArrayList<Cookie> cookies = new ArrayList<>();
                for (ClonedCookie clonedCookie : clonedCookies) {
                    cookies.add(clonedCookie.toCookie());
                }

                return cookies;
            }
        });
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(new HttpLoggingInterceptor(message -> Timber.tag("OkHttp").d(message)).setLevel(HttpLoggingInterceptor.Level.BODY));
        }
        return builder.build();
    }
}
