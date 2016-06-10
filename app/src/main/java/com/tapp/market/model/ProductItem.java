package com.tapp.market.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by John Robert Dichoso on 6/8/2016.
 */
public class ProductItem {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("product")
    @Expose
    private Product product;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
