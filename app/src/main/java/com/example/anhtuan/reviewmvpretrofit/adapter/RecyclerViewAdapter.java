package com.example.anhtuan.reviewmvpretrofit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.anhtuan.reviewmvpretrofit.R;
import com.example.anhtuan.reviewmvpretrofit.model.Users;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ANH TUAN on 2/1/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.DataViewHolder> {

    private List<Users> usersList;
    private Context context;

    public RecyclerViewAdapter(Context context, List<Users> usersList) {
        this.usersList = usersList;
        this.context = context;
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.items, parent, false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {
        Users users = usersList.get(position);
        Glide.with(context).load(users.getAvatar_url()).into(holder.img_avatar);
        holder.tvLogin.setText(users.getLogin());
        holder.tvId.setText(String.valueOf(users.getId()));
    }

    @Override
    public int getItemCount() {
        return usersList != null ? usersList.size() : 0;
    }

    public static class DataViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_avatar)
        ImageView img_avatar;
        @BindView(R.id.tv_login)
        TextView tvLogin;
        @BindView(R.id.tv_id)
        TextView tvId;

        public DataViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
