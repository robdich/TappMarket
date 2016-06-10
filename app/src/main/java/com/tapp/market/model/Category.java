package com.tapp.market.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by John Robert Dichoso on 6/8/2016.
 */
public class Category {

    @SerializedName("product-category-id")
    @Expose
    private Integer productCategoryId;
    @SerializedName("product-category-image-id")
    @Expose
    private Integer productCategoryImageId;
    @SerializedName("product-category-rank")
    @Expose
    private Integer productCategoryRank;
    @SerializedName("category-key")
    @Expose
    private String categoryKey;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("category-localized-title")
    @Expose
    private String categoryLocalizedTitle;

    public Integer getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Integer productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public Integer getProductCategoryImageId() {
        return productCategoryImageId;
    }

    public void setProductCategoryImageId(Integer productCategoryImageId) {
        this.productCategoryImageId = productCategoryImageId;
    }

    public Integer getProductCategoryRank() {
        return productCategoryRank;
    }

    public void setProductCategoryRank(Integer productCategoryRank) {
        this.productCategoryRank = productCategoryRank;
    }

    public String getCategoryKey() {
        return categoryKey;
    }

    public void setCategoryKey(String categoryKey) {
        this.categoryKey = categoryKey;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategoryLocalizedTitle() {
        return categoryLocalizedTitle;
    }

    public void setCategoryLocalizedTitle(String categoryLocalizedTitle) {
        this.categoryLocalizedTitle = categoryLocalizedTitle;
    }
}
