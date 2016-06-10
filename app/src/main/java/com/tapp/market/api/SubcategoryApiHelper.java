package com.tapp.market.api;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.tapp.market.model.ProductItem;
import com.tapp.market.model.SubcategoryItem;
import com.tapp.market.rest.RestClient;

import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by John Robert Dichoso on 6/10/2016.
 */
public class SubcategoryApiHelper {

    public interface OnResponseListener {
        void onResponseProducts(List<ProductItem> products, String title);
        void onResponseSubcategories(List<SubcategoryItem> subcategories, String title);
        void onResponseEmpty(String title);
    }

    private Gson gson;
    private OnResponseListener listener;

    public SubcategoryApiHelper(Gson gson, OnResponseListener listener) {
        this.gson = gson;
        this.listener = listener;
    }

    public void requestData(String itemId) {
        TappMarketService tappMarketService = RestClient.getTappMarketService();
        Call<JsonObject> call = tappMarketService.getSubcategoriesJsonObject(itemId);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                String title = "";
                boolean responseEmpty = true;
                JsonObject jsonObject =  response.body();
                if(jsonObject != null) {
                    JsonArray jsonArray = jsonObject.getAsJsonArray("items");
                    title = jsonObject.getAsJsonPrimitive("category-localized-title")
                            .getAsString();
                    if (jsonArray != null && jsonArray.size() > 0) {
                        JsonObject itemJsonObject = jsonArray.get(0).getAsJsonObject();
                        if (itemJsonObject != null) {
                            String typeStr = itemJsonObject.getAsJsonPrimitive("type").getAsString();
                            if (typeStr.equals("product")) {
                                Type listType = new TypeToken<List<ProductItem>>() {
                                }.getType();
                                List<ProductItem> products = gson.fromJson(jsonArray.toString(), listType);
                                responseEmpty = false;
                                if (listener != null) {
                                    listener.onResponseProducts(products, title);
                                }
                            } else if (typeStr.equals("category")) {
                                Type listType = new TypeToken<List<SubcategoryItem>>() {
                                }.getType();
                                List<SubcategoryItem> subcategories = gson.fromJson(jsonArray.toString(), listType);
                                responseEmpty = false;
                                if (listener != null) {
                                    listener.onResponseSubcategories(subcategories, title);
                                }
                            }
                        }
                    }
                }

                if(responseEmpty) {
                    if(listener != null) {
                        listener.onResponseEmpty(title);
                    }
                }

            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                if(listener != null) {
                    listener.onResponseEmpty(null);
                }
            }
        });

    }

}
