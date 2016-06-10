package com.tapp.market.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tapp.market.R;
import com.tapp.market.utils.Constants;

/**
 * Created by John Robert Dichoso on 6/10/2016.
 */
public class ProductDetailsActivity extends AppCompatActivity {

    private String title;
    private String price;
    private String url;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            title = bundle.getString("title");
            price = bundle.getString("price");
            url = bundle.getString("imageId");
        }

        ImageView icon = (ImageView) findViewById(R.id.icon);
        url = Constants.ICON_BASE_URL + url;
        Picasso.with(this)
                .load(url)
                .placeholder(R.drawable.placeholder_image)
                .into(icon);

        ((TextView) findViewById(R.id.title)).setText(title);
        ((TextView) findViewById(R.id.price)).setText(price);
        ((TextView) findViewById(R.id.text_details)).setText(title);

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
