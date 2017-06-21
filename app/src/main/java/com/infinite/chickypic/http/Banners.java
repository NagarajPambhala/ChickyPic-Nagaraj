package com.infinite.chickypic.http;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.squareup.moshi.Json;

import java.util.List;

import moe.banana.jsonapi2.HasMany;
import moe.banana.jsonapi2.HasOne;
import moe.banana.jsonapi2.JsonApi;
import moe.banana.jsonapi2.Resource;

/**
 * ujwalv on 27-04-2017.
 */
@JsonApi(type = "banners")
public class Banners extends Resource{

    //@Json(name="name") String name;
    @Json(name="title") String title;
    @Json(name="description") String description;
    @Json(name="ordinal") String ordinal;

    private HasOne<MediaItems> mediaItem;

    public MediaItems getMediaItems(){
        return mediaItem.get(getContext());
    }

}

