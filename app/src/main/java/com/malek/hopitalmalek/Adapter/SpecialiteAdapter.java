package com.malek.hopitalmalek.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.malek.hopitalmalek.AffecterRDV;
import com.malek.hopitalmalek.Model.DataModel;
import com.malek.hopitalmalek.R;

import java.util.List;

public class SpecialiteAdapter extends RecyclerView.Adapter<SpecialiteAdapter.ActorViewHolder> {
    String idPatient;
    List<DataModel> items;
    private Context ctx;

    public SpecialiteAdapter(List<DataModel> items, Context ctx,String idPatient) {
        this.items = items;
        this.ctx=ctx;
        this.idPatient=idPatient;

    }

    @Override
    public SpecialiteAdapter.ActorViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_rows_specialite,viewGroup,false);

        SpecialiteAdapter.ActorViewHolder Actionview = new SpecialiteAdapter.ActorViewHolder(v);
        return Actionview;
    }

    @Override
    public void onBindViewHolder(SpecialiteAdapter.ActorViewHolder holder, int position) {
        DataModel dm = items.get(position);
        holder.txtSpecialite.setText(dm.getSpecialite());
        holder.dm=dm;

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public  class ActorViewHolder extends RecyclerView.ViewHolder{
        TextView txtSpecialite;
        ImageView tvImage;
        DataModel dm;
        public ActorViewHolder(View itemView) {
            super(itemView);

            txtSpecialite =  itemView.findViewById(R.id.txtSpecialite);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ctx, AffecterRDV.class);
                    intent.putExtra("idPatient", idPatient);
                    intent.putExtra("idMedecin", "4");
                    intent.putExtra("choix", dm.getSpecialite());
                    ctx.startActivity(intent);




                }
            });

        }
    }


}
