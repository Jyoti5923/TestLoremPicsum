package com.example.testlorempicsum.Model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Picsum implements Serializable {

    @SerializedName("format")
    @Expose
    private String format;

    @SerializedName("width")
    @Expose
    private int width;

    @SerializedName("height")
    @Expose
    private int height;

    @SerializedName("filename")
    @Expose
    private String filename;

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("author")
    @Expose
    private String author;

    @SerializedName("author_url")
    @Expose
    private String authorUrl;

    @SerializedName("post_url")
    @Expose
    private String postUrl;

    /**
     * No args constructor for use in serialization
     *
     */
    public Picsum() {
    }

    /**
     *
     * @param postUrl
     * @param filename
     * @param author
     * @param authorUrl
     * @param format
     * @param width
     * @param id
     * @param height
     */
    public Picsum(String format, int width, int height, String filename, int id, String author, String authorUrl, String postUrl) {
        super();
        this.format = format;
        this.width = width;
        this.height = height;
        this.filename = filename;
        this.id = id;
        this.author = author;
        this.authorUrl = authorUrl;
        this.postUrl = postUrl;
    }

    public String getFormat() {
        return format;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getFilename() {
        return filename;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getAuthorUrl() {
        return authorUrl;
    }

    public String getPostUrl() {
        return postUrl;
    }
}