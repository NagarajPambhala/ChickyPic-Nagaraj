package com.infinite.chickypic.http;

import android.content.Context;
import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * ujwalv on 1/30/2017.
 */

public class RequestResponseInterseptor implements Interceptor {

    private static final String TAG = "RequestResponseInterseptor";
    private Context context;
    RequestResponseInterseptor(Context context){
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        //String session_token = SharedPrefsUtils.getSPinstance().getAccessToken(context);

        /*Request.Builder request = chain
                        .request()
                        .newBuilder()
                        .header("Authorization","Basic aGFzaGNodW5hX2FwcDo3YmIyNWJiNzg5ZGY0NjljYTVkZTY2MDNhZjJhODFmNQ");
                        if(session_token!=null){
                            request.header("Authorization","Bearer "+session_token);
                        }*/
        //if(session_cookie !=null){
            //request.addHeader("Cookie", session_cookie);
            //request.addHeader("Cookie", "PHPSESSID=43kn9775rhtrv8lhm50hu97pr3");
        //}

       // Response response = chain.proceed(request.build());

        /*if(response.code() == 401){
            Log.e("SESSION EDDED","RESTART SESSION");
                *//*RequestBody requestBody = new MultipartBody.Builder()
                        .setType(MultipartBody.FORM)
                        .addFormDataPart("grant_type", "password")
                        .addFormDataPart("client_id", "app")
                        .addFormDataPart("client_secret", "7bb25bb789df469ca5de6603af2a81f5")
                        .addFormDataPart("username", "app")
                        .addFormDataPart("password", "12345")
                        .build();
                Request requestNew = new Request.Builder()
                        .url("http://hashchuna.nn-assets.com/api/account/token")
                        .header("Content-Type", "application/x-www-form-urlencoded")
                        .method("POST", RequestBody.create(null, new byte[0]))
                        .post(requestBody)
                        .build();

                OkHttpClient client = new OkHttpClient.Builder().cookieJar(HttpConstants.getInstance().getCookieJar(context)).build();
                Response nTokenResp = client.newCall(requestNew).execute();
                Gson gson = new Gson();
                TypeAdapter<ApiToken> apiType = gson.getAdapter(ApiToken.class);
                ApiToken token = apiType.fromJson(nTokenResp.body().string());
                SharedPrefsUtils.getSPinstance().saveAccessToken(context, token.getAccessToken());
            if(response.header("Set-Cookie")!=null && !response.header("Set-Cookie").isEmpty()){
                session_cookie = response.header("Set-Cookie");
                session_cookie = session_cookie.substring(0, session_cookie.indexOf(";"));
                SharedPrefsUtils.getSPinstance().saveCookieToken(context, session_cookie);
            }

                request = chain
                        .request()
                        .newBuilder()
                        .header("Authorization", "Bearer " + SharedPrefsUtils.getSPinstance().getAccessToken(context));
                        if(session_cookie !=null){
                            request.addHeader("Cookie", session_cookie);
                        }
                return chain.proceed(request.build());*//*
        }else {
            //return response;
        }
        return response;*/
        return null;
    }
}
