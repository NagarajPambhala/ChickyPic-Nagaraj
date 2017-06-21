package com.infinite.chickypic.http;

import com.squareup.moshi.Json;

import moe.banana.jsonapi2.JsonApi;
import moe.banana.jsonapi2.Resource;

/**
 * ujwalv on 07-06-2017.
 */

@JsonApi(type = "mediaItems")
class MediaItems extends Resource{
    @Json(name="name") String name;
    @Json(name="title") String title;
    @Json(name="description") String description;
    @Json(name="filename") String filename;
    @Json(name="ordinal") String ordinal;
    @Json(name="mimeType") String mimeType;
    @Json(name="fileExtension") String fileExtension;
    @Json(name="fileSize") String fileSize;

    public String getFilename() {
        return filename;
    }
}