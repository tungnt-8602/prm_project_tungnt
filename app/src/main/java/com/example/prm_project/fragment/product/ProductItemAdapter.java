package com.example.prm_project.fragment.product;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.prm_project.R;
import com.example.prm_project.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductItemAdapter extends RecyclerView.Adapter<ProductItemAdapter.ViewHolder> {

    private Context context;
    private List<Product> productArrayList;

    public ProductItemAdapter(Context context, List<Product> productArrayList) {
        this.context = context;
        this.productArrayList = productArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View productView = inflater.inflate(R.layout.item_product, parent, false);
        return new ViewHolder(productView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product p = productArrayList.get(position);
        Glide.with(context).load(p.getThumbnail()).into(holder.productThumb);
        holder.productName.setText(p.getProductName());
        holder.productPrice.setText(p.getPrice().toString());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

    @Override
    public int getItemCount() {
        return productArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView productThumb;
        private TextView productName;
        private TextView productPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productThumb = itemView.findViewById(R.id.productThumb);
            productName = itemView.findViewById(R.id.productName);
            productPrice = itemView.findViewById(R.id.price);
        }
    }
}
