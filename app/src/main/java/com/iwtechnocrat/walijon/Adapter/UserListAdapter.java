package com.iwtechnocrat.walijon.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iwtechnocrat.walijon.Model.UserListModel;
import com.iwtechnocrat.walijon.R;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder> {
    Context context;
    List<UserListModel> userListModels;

    public UserListAdapter(Context context, List<UserListModel> userListModels) {
        this.context = context;
        this.userListModels = userListModels;
    }

    @NonNull
    @Override
    public UserListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.usercustom_lay,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserListAdapter.ViewHolder holder, int position) {
        UserListModel userListModel = userListModels.get(position);
        holder.username.setText(userListModel.getUsername());
        holder.usernumber.setText(userListModel.getUsernumber());
        holder.userclass.setText(userListModel.getUserclass());

    }

    @Override
    public int getItemCount() {
        return userListModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView username,usernumber,userclass;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            username = itemView.findViewById(R.id.username);
            usernumber = itemView.findViewById(R.id.usernumber);
            userclass = itemView.findViewById(R.id.userclass);
        }
    }
}
