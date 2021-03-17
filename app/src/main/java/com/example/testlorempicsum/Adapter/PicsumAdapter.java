package com.example.testlorempicsum.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testlorempicsum.Model.Picsum;
import com.example.testlorempicsum.PicsumDetailsActivity;
import com.example.testlorempicsum.R;
import com.example.testlorempicsum.Rest.ApiClient;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PicsumAdapter extends RecyclerView.Adapter<PicsumAdapter.DataViewHolder> {
    Context context;
    ArrayList<Picsum> arrayList;

    public PicsumAdapter(Context context, ArrayList<Picsum> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item, parent, false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        Picsum picsum = arrayList.get(position);
        Picasso.get().load(ApiClient.BASE_URL + "300/300?image=" + picsum.getId()).into(holder.imageView);
        holder.tvTitle.setText(picsum.getAuthor());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PicsumDetailsActivity.class);
                intent.putExtra("data", picsum);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class DataViewHolder extends RecyclerView.ViewHolder {
        TextView tvId, tvTitle;
        ImageView imageView;
        CardView cardView;

        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.picsum_title);
            imageView = itemView.findViewById(R.id.img_picsum);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
