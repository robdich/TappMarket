package com.tapp.market.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by John Robert Dichoso on 6/8/2016.
 */
public class ProductList {

    @SerializedName("category-key")
    @Expose
    private String categoryKey;
    @SerializedName("category-localized-title")
    @Expose
    private String categoryLocalizedTitle;
    @SerializedName("items")
    @Expose
    private List<ProductItem> items = new ArrayList<ProductItem>();

    public String getCategoryKey() {
        return categoryKey;
    }

    public void setCategoryKey(String categoryKey) {
        this.categoryKey = categoryKey;
    }

    public String getCategoryLocalizedTitle() {
        return categoryLocalizedTitle;
    }

    public void setCategoryLocalizedTitle(String categoryLocalizedTitle) {
        this.categoryLocalizedTitle = categoryLocalizedTitle;
    }

    public List<ProductItem> getItems() {
        return items;
    }

    public void setItems(List<ProductItem> items) {
        this.items = items;
    }

}
