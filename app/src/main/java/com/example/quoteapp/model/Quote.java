package com.example.quoteapp.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import java.util.List;
import javax.annotation.Generated;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Quote extends BaseObservable {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("tags")
    @Expose
    private List<String> tags;
    @SerializedName("authorSlug")
    @Expose
    private String authorSlug;
    @SerializedName("length")
    @Expose
    private Integer length;
    @SerializedName("dateAdded")
    @Expose
    private String dateAdded;
    @SerializedName("dateModified")
    @Expose
    private String dateModified;

    @Bindable
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
notifyPropertyChanged(BR.id);
    }

    @Bindable
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
        notifyPropertyChanged(BR.author);

    }
    @Bindable
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        notifyPropertyChanged(BR.content);

    }
    @Bindable
    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
        notifyPropertyChanged(BR.tags);

    }
    @Bindable
    public String getAuthorSlug() {
        return authorSlug;
    }

    public void setAuthorSlug(String authorSlug) {
        this.authorSlug = authorSlug;
        notifyPropertyChanged(BR.authorSlug);

    }
    @Bindable
    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
        notifyPropertyChanged(BR.length);

    }
    @Bindable
    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
        notifyPropertyChanged(BR.dateAdded);

    }
    @Bindable
    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
        notifyPropertyChanged(BR.dateModified);

    }

}
