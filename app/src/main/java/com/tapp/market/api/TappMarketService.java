package com.tapp.market.api;

import com.google.gson.JsonObject;
import com.tapp.market.model.Category;
import com.tapp.market.model.ProductList;
import com.tapp.market.model.Subcategory;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by John Robert Dichoso on 6/9/2016.
 */
public interface TappMarketService {

    @GET("product-categories")
    Call<List<Category>> getCategories();

    @GET("product-categories/{id}")
    Call<JsonObject> getSubcategoriesJsonObject(
            @Path("id") String id);

    @GET("product-categories/{id}")
    Call<Subcategory> getSubcategories(
            @Path("id") String id);

    @GET("product-categories/{id}")
    Call<ProductList> getProducts(
            @Path("id") String id);

}
