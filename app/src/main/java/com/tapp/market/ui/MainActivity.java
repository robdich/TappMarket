package com.tapp.market.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.tapp.market.R;
import com.tapp.market.adapter.CategoryAdapter;
import com.tapp.market.api.TappMarketService;
import com.tapp.market.model.Category;
import com.tapp.market.rest.RestClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by John Robert Dichoso on 6/9/2016.
 */
public class MainActivity extends AppCompatActivity
        implements CategoryAdapter.OnCategoryItemClickListener {

    private ProgressBar loadingView;
    private ImageView emptyImage;
    private TextView emptyText;
    private RecyclerView recyclerView;
    private CategoryAdapter categoryAdapter;

    private List<Category> categories = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        loadingView = (ProgressBar) findViewById(R.id.pbLoading);
        emptyImage = (ImageView) findViewById(R.id.emptyImage);
        emptyText = (TextView) findViewById(R.id.emptyText);

        recyclerView = (RecyclerView) findViewById(R.id.categoryRecyclerView);

        categoryAdapter = new CategoryAdapter(this, categories, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(categoryAdapter);

        getCategories();

    }

    private void getCategories() {
        loadingView.setVisibility(View.VISIBLE);
        TappMarketService tappMarketService = RestClient.getTappMarketService();
        Call<List<Category>> call = tappMarketService.getCategories();
        call.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                List<Category> categories =  response.body();
                if(categories != null) {
                    for(int i = 0; i < categories.size(); i++) {
                        Category category = categories.get(i);
                        if(category.getProductCategoryId() > 0) {
                            MainActivity.this.categories.add(category);
                        }
                    }
                    categoryAdapter.notifyDataSetChanged();
                    loadingView.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                loadingView.setVisibility(View.GONE);
                emptyImage.setVisibility(View.VISIBLE);
                emptyText.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void onCategoryItemClick(int itemId) {
        Intent intent = new Intent(this, SubcategoryActivity.class);
        intent.putExtra("itemId", itemId);
        startActivity(intent);
    }

}
