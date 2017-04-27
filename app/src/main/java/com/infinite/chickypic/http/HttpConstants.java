package com.infinite.chickypic.http;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.infinite.chickypic.R;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * jwalv on 27-04-2017.
 */

public class HttpConstants {

    public static final String BASE_URL = "http://109.226.9.246/api/";
    private static HttpConstants instance=null;
    private static final String TAG = "HttpConstants";

    public static HttpConstants getInstance(){
        if(instance==null){
            instance = new HttpConstants();
        }
        return instance;
    }

    private Api getApiInstance(Context context) {

        //CookieJar cookieJar =   new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(context));
        //CookieHandler cookieHandler = new CookieManager(new Persis)

        // CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));

        //CookieManager cookieManager = new CookieManager();
        //cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);

        HttpLoggingInterceptor logInter = new HttpLoggingInterceptor();
        logInter.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient mIntercepter = new OkHttpClient.Builder()

            /*.cookieJar(new CookieJar() {
                private final HashMap<String, List<Cookie>> cookieStore = new HashMap<>();

                @Override
                public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                    cookieStore.put(url.host(), cookies);
                }

                @Override
                public List<Cookie> loadForRequest(HttpUrl url) {
                    List<Cookie> cookies = cookieStore.get(url.host());
                    return cookies != null ? cookies : new ArrayList<Cookie>();
                }
            })*/
                // .cookieJar(new JavaNetCookieJar(cookieManager))
                //.addInterceptor(new RequestResponseInterseptor(context))
                .addInterceptor(logInter)
                .build();

        Retrofit retrofitInstance = new Retrofit.Builder()
                .addConverterFactory(new NullOnEmptyConverterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(mIntercepter)
                .build();
        return retrofitInstance.create(Api.class);
    }

    public void bannersList(final Fragment fragment, String banner, int offset, String sort,int size) {

        Call<BannersPojo> response = HttpConstants.getInstance().getApiInstance(fragment.getContext()).banners(banner,offset,sort,size);
        response.enqueue(new Callback<BannersPojo>(){
            @Override
            public void onResponse(Call<BannersPojo> call, Response<BannersPojo> response) {
                try {
                    BannersPojo postsPojo;
                    if(response.code()>=400) {
                        Gson gson = new Gson();
                        TypeAdapter<BannersPojo> errorResponseT = gson.getAdapter(BannersPojo.class);
                        postsPojo = errorResponseT.fromJson(response.errorBody().string());
                    }else{
                        postsPojo = response.body();
                        Log.i(TAG, "onResponse: ");
                    }
                    ((BannersListCallback) fragment).BannersList(postsPojo);
                } catch (IOException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<BannersPojo> call, Throwable t) {
                ((BannersListCallback) fragment).BannersList(fragment.getString(R.string.check_network));
            }
        });
    }

    public interface BannersListCallback{
        void BannersList(BannersPojo bannersPojo);
        void BannersList(String string);

    }
    private class NullOnEmptyConverterFactory extends Converter.Factory {

        @Override
        public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
            final Converter<ResponseBody, ?> delegate = retrofit.nextResponseBodyConverter(this, type, annotations);
            return new Converter<ResponseBody, Object>() {
                @Override
                public Object convert(ResponseBody body) throws IOException {
                    if (body.contentLength() == 0) return null;
                    return delegate.convert(body);                }
            };
        }
    }
}
