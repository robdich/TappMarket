package com.tapp.market.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by John Robert Dichoso on 6/8/2016.
 */
public class Product {

    @SerializedName("engine-product-id")
    @Expose
    private String engineProductId;
    @SerializedName("localization-key")
    @Expose
    private String localizationKey;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("localized-description")
    @Expose
    private String localizedDescription;
    @SerializedName("category-key")
    @Expose
    private String categoryKey;
    @SerializedName("denomination-currency")
    @Expose
    private String denominationCurrency;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("product-promotion-message")
    @Expose
    private String productPromotionMessage;
    @SerializedName("denomination-amount")
    @Expose
    private Integer denominationAmount;
    @SerializedName("parent-category-id")
    @Expose
    private Integer parentCategoryId;
    @SerializedName("form")
    @Expose
    private String form;
    @SerializedName("merchant")
    @Expose
    private String merchant;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("product-id")
    @Expose
    private Integer productId;
    @SerializedName("product-image-id")
    @Expose
    private Integer productImageId;
    @SerializedName("srp")
    @Expose
    private Integer srp;

    public String getEngineProductId() {
        return engineProductId;
    }

    public void setEngineProductId(String engineProductId) {
        this.engineProductId = engineProductId;
    }

    public String getLocalizationKey() {
        return localizationKey;
    }

    public void setLocalizationKey(String localizationKey) {
        this.localizationKey = localizationKey;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocalizedDescription() {
        return localizedDescription;
    }

    public void setLocalizedDescription(String localizedDescription) {
        this.localizedDescription = localizedDescription;
    }

    public String getCategoryKey() {
        return categoryKey;
    }

    public void setCategoryKey(String categoryKey) {
        this.categoryKey = categoryKey;
    }

    public String getDenominationCurrency() {
        return denominationCurrency;
    }

    public void setDenominationCurrency(String denominationCurrency) {
        this.denominationCurrency = denominationCurrency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getProductPromotionMessage() {
        return productPromotionMessage;
    }

    public void setProductPromotionMessage(String productPromotionMessage) {
        this.productPromotionMessage = productPromotionMessage;
    }

    public Integer getDenominationAmount() {
        return denominationAmount;
    }

    public void setDenominationAmount(Integer denominationAmount) {
        this.denominationAmount = denominationAmount;
    }

    public Integer getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(Integer parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductImageId() {
        return productImageId;
    }

    public void setProductImageId(Integer productImageId) {
        this.productImageId = productImageId;
    }

    public Integer getSrp() {
        return srp;
    }

    public void setSrp(Integer srp) {
        this.srp = srp;
    }

}
