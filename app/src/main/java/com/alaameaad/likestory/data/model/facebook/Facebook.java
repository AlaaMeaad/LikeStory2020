
package com.alaameaad.likestory.data.model.facebook;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Facebook {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("linkTypeId")
    @Expose
    private Integer linkTypeId;
    @SerializedName("linkTypeName")
    @Expose
    private String linkTypeName;
    @SerializedName("likeCount")
    @Expose
    private Integer likeCount;
    @SerializedName("dateFinished")
    @Expose
    private String dateFinished;
    @SerializedName("maxCount")
    @Expose
    private Integer maxCount;
    @SerializedName("typeAdd")
    @Expose
    private Boolean typeAdd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getLinkTypeId() {
        return linkTypeId;
    }

    public void setLinkTypeId(Integer linkTypeId) {
        this.linkTypeId = linkTypeId;
    }

    public String getLinkTypeName() {
        return linkTypeName;
    }

    public void setLinkTypeName(String linkTypeName) {
        this.linkTypeName = linkTypeName;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public String getDateFinished() {
        return dateFinished;
    }

    public void setDateFinished(String dateFinished) {
        this.dateFinished = dateFinished;
    }

    public Integer getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(Integer maxCount) {
        this.maxCount = maxCount;
    }

    public Boolean getTypeAdd() {
        return typeAdd;
    }

    public void setTypeAdd(Boolean typeAdd) {
        this.typeAdd = typeAdd;
    }

}
