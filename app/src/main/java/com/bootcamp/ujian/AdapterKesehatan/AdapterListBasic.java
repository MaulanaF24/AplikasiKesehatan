package com.bootcamp.ujian.AdapterKesehatan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.bootcamp.ujian.MainActivity;
import com.bootcamp.ujian.R;
import com.bootcamp.ujian.model.Data;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;


public class AdapterListBasic extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Data> items;
    OriginalViewHolder view;

    private Context ctx;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, Data obj, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public AdapterListBasic(Context context, List<Data> items) {
        this.items = items;
        ctx = context;
    }

    public class OriginalViewHolder extends RecyclerView.ViewHolder {

        TextView txtNama,txtUmur,txtBerat,txtDarah,txtAlamat ;
        Button btnDelete;


        public OriginalViewHolder(View view) {
              super(view);

              txtNama = (TextView) view.findViewById(R.id.txtNama);
              txtUmur = (TextView) view.findViewById(R.id.txtUmur);
              txtBerat = (TextView) view.findViewById(R.id.txtBerat);
              txtDarah = (TextView) view.findViewById(R.id.txtDarah);
              txtAlamat = (TextView) view.findViewById(R.id.txtAlamat);
              btnDelete = (Button) view.findViewById(R.id.btnDelete);


        }
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_user, parent, false);
        vh = new OriginalViewHolder(v);
        return vh ;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof OriginalViewHolder) {
            view = (OriginalViewHolder) holder;

            final Data data = items.get(position);

            view.txtNama.setText(data.getNama());
            view.txtUmur.setText(String.valueOf(data.getUmur()));
            view.txtBerat.setText(String.valueOf(data.getBeratBadan()));
            view.txtDarah.setText(data.getTekananDarah());
            view.txtAlamat.setText(data.getAlamat());
            view.btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    data.delete();
                    view.itemView.setVisibility(View.GONE);

                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}