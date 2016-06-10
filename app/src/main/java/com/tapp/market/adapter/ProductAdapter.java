package com.tapp.market.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tapp.market.R;
import com.tapp.market.model.Product;
import com.tapp.market.model.ProductItem;
import com.tapp.market.utils.Constants;

import java.util.List;

/**
 * Created by John Robert Dichoso on 6/9/2016.
 */
public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    public interface OnProductItemClickListener {
        void onProductItemClick(Product product);
    }

    private Context context;
    private OnProductItemClickListener listener;
    private List<ProductItem> productItems;

    public ProductAdapter(Context context, List<ProductItem> productItems,
                          OnProductItemClickListener listener) {
        this.context = context;
        this.productItems = productItems;
        this.listener = listener;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);

        return new ProductViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        final Product product = productItems.get(position).getProduct();
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null) {
                    listener.onProductItemClick(product);
                }
            }
        });
        holder.title.setText(product.getLocalizedDescription());
        float price = product.getPrice() / 100.00f;
        String priceString = String.format(product.getCurrency() + " %.2f", price);
        holder.price.setText(priceString);
        String url = Constants.ICON_BASE_URL + product.getProductImageId();
        Picasso.with(context)
                .load(url)
                .placeholder(R.drawable.placeholder_image)
                .into(holder.icon);
    }

    @Override
    public int getItemCount() {
        return productItems.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        public View container;
        public ImageView icon;
        public TextView title;
        public TextView price;

        public ProductViewHolder(View view) {
            super(view);
            container = view.findViewById(R.id.item_container);
            icon = (ImageView) view.findViewById(R.id.icon);
            title = (TextView) view.findViewById(R.id.title);
            price = (TextView) view.findViewById(R.id.price);
        }
    }

}
