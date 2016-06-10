package com.tapp.market.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.tapp.market.R;
import com.tapp.market.adapter.CategoryAdapter;
import com.tapp.market.adapter.ProductAdapter;
import com.tapp.market.api.SubcategoryApiHelper;
import com.tapp.market.model.Category;
import com.tapp.market.model.Product;
import com.tapp.market.model.ProductItem;
import com.tapp.market.model.SubcategoryItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by John Robert Dichoso on 6/9/2016.
 */
public class SubcategoryActivity extends AppCompatActivity
        implements CategoryAdapter.OnCategoryItemClickListener,
        ProductAdapter.OnProductItemClickListener,
        SubcategoryApiHelper.OnResponseListener{

    private ProgressBar loadingView;
    private ImageView emptyImage;
    private TextView emptyText;
    private RecyclerView recyclerView;

    private int itemId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            itemId = bundle.getInt("itemId");
        }

        recyclerView = (RecyclerView) findViewById(R.id.categoryRecyclerView);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        loadingView = (ProgressBar) findViewById(R.id.pbLoading);
        emptyImage = (ImageView) findViewById(R.id.emptyImage);
        emptyText = (TextView) findViewById(R.id.emptyText);

        getSubCategories();
    }

    private void getSubCategories() {
        loadingView.setVisibility(View.VISIBLE);
        SubcategoryApiHelper apiHelper = new SubcategoryApiHelper(new Gson(), this);
        apiHelper.requestData("" + itemId);
    }

    @Override
    public void onResponseProducts(List<ProductItem> products, String title) {
        setToolbarTitle(title);
        ProductAdapter adapter = new ProductAdapter(this, products, this);
        recyclerView.setAdapter(adapter);
        loadingView.setVisibility(View.GONE);
    }

    @Override
    public void onResponseSubcategories(List<SubcategoryItem> subcategories, String title) {
        setToolbarTitle(title);
        List<Category> categories = new ArrayList<>();
        for(int i = 0; i < subcategories.size(); i++) {
            categories.add(subcategories.get(i).getCategory());
        }

        CategoryAdapter adapter = new CategoryAdapter(this, categories, this);
        recyclerView.setAdapter(adapter);
        loadingView.setVisibility(View.GONE);
    }

    @Override
    public void onResponseEmpty(String title) {
        setToolbarTitle(title);
        emptyImage.setVisibility(View.VISIBLE);
        emptyText.setVisibility(View.VISIBLE);
        loadingView.setVisibility(View.GONE);
    }

    private void setToolbarTitle(String title) {
        if(title != null && !title.isEmpty()) {
            setTitle(title);
        }
    }

    @Override
    public void onCategoryItemClick(int itemId) {
        Intent intent = new Intent(this, SubcategoryActivity.class);
        intent.putExtra("itemId", itemId);
        startActivity(intent);
    }

    @Override
    public void onProductItemClick(Product product) {
        float price = product.getPrice() / 100.00f;
        String priceString = String.format(product.getCurrency() + " %.2f", price);

        Intent intent = new Intent(this, ProductDetailsActivity.class);
        intent.putExtra("title", product.getLocalizedDescription());
        intent.putExtra("price", priceString);
        intent.putExtra("imageId",product.getProductImageId() != null ?
                product.getProductImageId().toString() : "");
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
