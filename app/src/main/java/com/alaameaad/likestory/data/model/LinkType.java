package com.alaameaad.likestory.data.model;

import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class LinkType {

    @SerializedName("linkTypeId")
    @Expose
    private Integer linkTypeId;
    @SerializedName("linkTypeName")
    @Expose
    private String linkTypeName;
    @SerializedName("countRun")
    @Expose
    private String countRun;
    @SerializedName("scriptJave")
    @Expose
    private String scriptJave;
    @SerializedName("facebookLinks")
    @Expose
    private Object facebookLinks;
    @SerializedName("twitterLinks")
    @Expose
    private Object twitterLinks;
    @SerializedName("instagramLinks")
    @Expose
    private Object instagramLinks;
    @SerializedName("youtubeLinks")
    @Expose
    private Object youtubeLinks;
    @SerializedName("buyFacebook")
    @Expose
    private Object buyFacebook;
    @SerializedName("buyInstagram")
    @Expose
    private Object buyInstagram;
    @SerializedName("buyTwiter")
    @Expose
    private Object buyTwiter;
    @SerializedName("buyYoutube")
    @Expose
    private Object buyYoutube;
    @SerializedName("createBy")
    @Expose
    private Integer createBy;
    @SerializedName("createDate")
    @Expose
    private String createDate;
    @SerializedName("updatedBy")
    @Expose
    private Object updatedBy;
    @SerializedName("updatedDate")
    @Expose
    private Object updatedDate;
    @SerializedName("deletedBy")
    @Expose
    private Object deletedBy;
    @SerializedName("deletedDate")
    @Expose
    private Object deletedDate;

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

    public String getCountRun() {
        return countRun;
    }

    public void setCountRun(String countRun) {
        this.countRun = countRun;
    }

    public String getScriptJave() {
        return scriptJave;
    }

    public void setScriptJave(String scriptJave) {
        this.scriptJave = scriptJave;
    }

    public Object getFacebookLinks() {
        return facebookLinks;
    }

    public void setFacebookLinks(Object facebookLinks) {
        this.facebookLinks = facebookLinks;
    }

    public Object getTwitterLinks() {
        return twitterLinks;
    }

    public void setTwitterLinks(Object twitterLinks) {
        this.twitterLinks = twitterLinks;
    }

    public Object getInstagramLinks() {
        return instagramLinks;
    }

    public void setInstagramLinks(Object instagramLinks) {
        this.instagramLinks = instagramLinks;
    }

    public Object getYoutubeLinks() {
        return youtubeLinks;
    }

    public void setYoutubeLinks(Object youtubeLinks) {
        this.youtubeLinks = youtubeLinks;
    }

    public Object getBuyFacebook() {
        return buyFacebook;
    }

    public void setBuyFacebook(Object buyFacebook) {
        this.buyFacebook = buyFacebook;
    }

    public Object getBuyInstagram() {
        return buyInstagram;
    }

    public void setBuyInstagram(Object buyInstagram) {
        this.buyInstagram = buyInstagram;
    }

    public Object getBuyTwiter() {
        return buyTwiter;
    }

    public void setBuyTwiter(Object buyTwiter) {
        this.buyTwiter = buyTwiter;
    }

    public Object getBuyYoutube() {
        return buyYoutube;
    }

    public void setBuyYoutube(Object buyYoutube) {
        this.buyYoutube = buyYoutube;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Object getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Object updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Object getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Object updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Object getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(Object deletedBy) {
        this.deletedBy = deletedBy;
    }

    public Object getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(Object deletedDate) {
        this.deletedDate = deletedDate;
    }

}