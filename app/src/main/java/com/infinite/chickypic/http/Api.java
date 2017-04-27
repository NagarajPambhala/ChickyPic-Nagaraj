package com.infinite.chickypic.http;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * ujwalv on 27-04-2017.
 */

public interface Api {

    @GET("banners")
    Call<BannersPojo> banners(@Query("fields[banner]") String fields,
                                     @Query("page[offset]") Integer offset,
                                     @Query("sort") String sort,
                                     @Query("page[size]") Integer size);
}