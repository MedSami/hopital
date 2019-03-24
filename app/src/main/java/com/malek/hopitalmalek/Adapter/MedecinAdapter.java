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

public class MedecinAdapter extends RecyclerView.Adapter<MedecinAdapter.ActorViewHolder> {
String idPatient;
    List<DataModel> items;
    private Context ctx;

    public MedecinAdapter(List<DataModel> items, Context ctx,String idPatient) {
        this.items = items;
        this.ctx=ctx;
this.idPatient=idPatient;

    }

    @Override
    public MedecinAdapter.ActorViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_rows_medecin,viewGroup,false);

        MedecinAdapter.ActorViewHolder Actionview = new MedecinAdapter.ActorViewHolder(v);
        return Actionview;
    }

    @Override
    public void onBindViewHolder(MedecinAdapter.ActorViewHolder holder, int position) {
        DataModel dm = items.get(position);
        holder.txtNomPrenom.setText(dm.getNom()+" "+dm.getPrenom());
        holder.dm=dm;

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public  class ActorViewHolder extends RecyclerView.ViewHolder{
        TextView txtNomPrenom;
        ImageView tvImage;
        DataModel dm;
        public ActorViewHolder(View itemView) {
            super(itemView);

            txtNomPrenom =  itemView.findViewById(R.id.txtNomPrenom);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                        Intent intent = new Intent(ctx, AffecterRDV.class);
                        intent.putExtra("idPatient", idPatient);
                        intent.putExtra("idMedecin", dm.getId());
                        intent.putExtra("choix", dm.getNom()+" "+dm.getPrenom());
                        ctx.startActivity(intent);




                }
            });

        }
    }



}
