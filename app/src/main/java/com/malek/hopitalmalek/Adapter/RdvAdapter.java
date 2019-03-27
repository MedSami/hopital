package com.malek.hopitalmalek.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.malek.hopitalmalek.AffecterRDV;
import com.malek.hopitalmalek.ConsulterMsg;
import com.malek.hopitalmalek.Model.DataModel;
import com.malek.hopitalmalek.R;

import java.util.List;

public class RdvAdapter extends RecyclerView.Adapter<RdvAdapter.ActorViewHolder> {
    String idPatient;
    List<DataModel> items;
    private Context ctx;

    public RdvAdapter(List<DataModel> items, Context ctx,String idPatient) {
        this.items = items;
        this.ctx=ctx;
        this.idPatient=idPatient;

    }

    @Override
    public RdvAdapter.ActorViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_rows_rdv,viewGroup,false);

        RdvAdapter.ActorViewHolder Actionview = new RdvAdapter.ActorViewHolder(v);
        return Actionview;
    }

    @Override
    public void onBindViewHolder(RdvAdapter.ActorViewHolder holder, int position) {
        DataModel dm = items.get(position);
        holder.txtRDV.setText("Votre Rendez Vous Avec : "+dm.getChoix());
        String m=(dm.getMessage()==null) ? "pas de reponse" : "consulter message de reponse RDV";
        holder.txtMSG.setText(m);
        holder.dm=dm;

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public  class ActorViewHolder extends RecyclerView.ViewHolder{
        TextView txtRDV,txtMSG;
        ImageView tvImage;
        DataModel dm;
        public ActorViewHolder(View itemView) {
            super(itemView);

            txtRDV =  itemView.findViewById(R.id.txtrdv);
            txtMSG =  itemView.findViewById(R.id.txtmsg);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
if(dm.getMessage()!=null) {
   Intent intent = new Intent(ctx, ConsulterMsg.class);

    intent.putExtra("msg", dm.getMessage());

    ctx.startActivity(intent);
}



                }
            });

        }
    }



}
