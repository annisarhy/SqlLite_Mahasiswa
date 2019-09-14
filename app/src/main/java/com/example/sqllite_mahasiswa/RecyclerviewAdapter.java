package com.example.sqllite_mahasiswa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.UserViewHolder> {

    Context context;
    OnUserClickListener Listener;
    List<PersonBean> listPersonInfo;


    public RecyclerviewAdapter(Context context, List<PersonBean> listPersonInfo, OnUserClickListener listener){
        this.context = context;
        this.listPersonInfo = listPersonInfo;
        this.Listener = listener;
    }

    public interface OnUserClickListener{
        void onUserClick(PersonBean currentPerson, String action);
    }



    @NonNull
    @Override
    public RecyclerviewAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mahasiswa_row_item,parent,false);
        UserViewHolder userViewHolder = new UserViewHolder(view);


        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerviewAdapter.UserViewHolder holder, int position) {
        final PersonBean currentPerson = listPersonInfo.get(position);
        holder.txtName.setText(currentPerson.getNama());
    }

    @Override
    public int getItemCount() {
        return listPersonInfo.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        TextView txtName;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txtName);
        }
    }
}