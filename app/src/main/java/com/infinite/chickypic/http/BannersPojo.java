package com.infinite.chickypic.http;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import moe.banana.jsonapi2.Resource;

/**
 * ujwalv on 27-04-2017.
 */

public class BannersPojo extends Resource{

    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    @SerializedName("included")
    @Expose
    private List<Included> included = null;

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public List<Included> getIncluded() {
        return included;
    }

    public void setIncluded(List<Included> included) {
        this.included = included;
    }

    public class Attributes {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("ordinal")
        @Expose
        private Integer ordinal;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Integer getOrdinal() {
            return ordinal;
        }

        public void setOrdinal(Integer ordinal) {
            this.ordinal = ordinal;
        }

    }

    public class Attributes_ {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("description")
        @Expose
        private Object description;
        @SerializedName("filename")
        @Expose
        private String filename;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Object getDescription() {
            return description;
        }

        public void setDescription(Object description) {
            this.description = description;
        }

        public String getFilename() {
            return filename;
        }

        public void setFilename(String filename) {
            this.filename = filename;
        }

    }

    public class Data {

        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("id")
        @Expose
        private String id;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

    }

    public class Datum {

        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("attributes")
        @Expose
        private Attributes attributes;
        @SerializedName("relationships")
        @Expose
        private Relationships relationships;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Attributes getAttributes() {
            return attributes;
        }

        public void setAttributes(Attributes attributes) {
            this.attributes = attributes;
        }

        public Relationships getRelationships() {
            return relationships;
        }

        public void setRelationships(Relationships relationships) {
            this.relationships = relationships;
        }

    }

    public class Included {

        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("attributes")
        @Expose
        private Attributes_ attributes;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Attributes_ getAttributes() {
            return attributes;
        }

        public void setAttributes(Attributes_ attributes) {
            this.attributes = attributes;
        }

    }

    public class MainImage {

        @SerializedName("data")
        @Expose
        private Data data;

        public Data getData() {
            return data;
        }

        public void setData(Data data) {
            this.data = data;
        }

    }

    public class Relationships {

        @SerializedName("mainImage")
        @Expose
        private MainImage mainImage;

        public MainImage getMainImage() {
            return mainImage;
        }

        public void setMainImage(MainImage mainImage) {
            this.mainImage = mainImage;
        }

    }

}

