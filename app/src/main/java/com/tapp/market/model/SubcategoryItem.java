package com.tapp.market.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by John Robert Dichoso on 6/8/2016.
 */
public class SubcategoryItem {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("category")
    @Expose
    private Category category;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
