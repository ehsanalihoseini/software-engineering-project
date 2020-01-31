package com.example.mohandesinarm;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mohandesinarm.Model.ElanModel;

import java.util.List;

public class ShowList extends RecyclerView.Adapter<ShowList.ElanViewHolder> {


    List<ElanModel> elanModels;

    Context context;

    public ShowList(List<ElanModel> elanModelList , Context context) {
        elanModels = elanModelList;
        this.context=context;
    }

    @NonNull
    @Override
    public ElanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.elan_item, parent, false);
        return new ElanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ElanViewHolder holder, int position) {
        final ElanModel elanModel = elanModels.get(position);
        holder.txtName.setText(elanModel.name);
        holder.txtSathm.setText(elanModel.sath + "");
        String kind = "";
        if (!elanModel.email.equals("")) {
            kind += "ایمیل ";
        }
        if (!elanModel.phone.equals("")) {
            kind += "پیامک ";
        }
        holder.txtKind.setText(kind);
        holder.txtGroup.setText(elanModel.group);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog= new Dialog(context);
                dialog.setContentView(R.layout.dialog_item);
                TextView textMatn = dialog.findViewById(R.id.text_dialog_matn);
                textMatn.setText(elanModel.matn);
                dialog.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return elanModels.size();
    }

    class ElanViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtSathm, txtGroup, txtKind;
        CardView cardView;

        public ElanViewHolder(@NonNull View itemView) {
            super(itemView);
            txtGroup = itemView.findViewById(R.id.txt_item_group);
            txtKind = itemView.findViewById(R.id.txt_item_kind);
            txtSathm = itemView.findViewById(R.id.txt_item_sath);
            txtName = itemView.findViewById(R.id.txt_item_name);
            cardView = itemView.findViewById(R.id.card_elan_item);

        }
    }


}
