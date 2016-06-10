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
import com.tapp.market.model.Category;
import com.tapp.market.utils.Constants;

import java.util.List;

/**
 * Created by John Robert Dichoso on 6/9/2016.
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    public interface OnCategoryItemClickListener {
        void onCategoryItemClick(int itemId);
    }

    private Context context;
    private OnCategoryItemClickListener listener;
    private List<Category> categories;

    public CategoryAdapter(Context context, List<Category> categories,
                           OnCategoryItemClickListener listener) {
        this.context = context;
        this.categories = categories;
        this.listener = listener;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_category, parent, false);

        return new CategoryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        final Category category = categories.get(position);
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null) {
                    listener.onCategoryItemClick(category.getProductCategoryId());
                }
            }
        });
        holder.title.setText(category.getCategoryLocalizedTitle());
        String url = Constants.ICON_BASE_URL + category.getProductCategoryImageId();
        Picasso.with(context)
                .load(url)
                .placeholder(R.drawable.placeholder_image)
                .into(holder.icon);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        public View container;
        public ImageView icon;
        public TextView title;

        public  CategoryViewHolder(View view) {
            super(view);
            container = view.findViewById(R.id.item_container);
            title = (TextView) view.findViewById(R.id.title);
            icon = (ImageView) view.findViewById(R.id.icon);
        }
    }

}
