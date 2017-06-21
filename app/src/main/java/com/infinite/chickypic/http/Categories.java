package com.infinite.chickypic.http;

import com.squareup.moshi.Json;

import moe.banana.jsonapi2.HasOne;
import moe.banana.jsonapi2.JsonApi;
import moe.banana.jsonapi2.Resource;

/**
 * ujwalv on 08-06-2017.
 */
@JsonApi(type = "categories")
public class Categories extends Resource {

    @Json(name="name") String name;
    @Json(name="title") String title;
    @Json(name="description") String description;
    //@Json(name="parent") String parent;
    @Json(name="ordinal") String ordinal;


    private HasOne<MediaItems> featuredImage;
    private HasOne<MediaItems> mainImage;

    public MediaItems getFeaturedImage(){ return featuredImage.get(getContext()); }
    public MediaItems getMainImage(){ return mainImage.get(getContext()); }

}
