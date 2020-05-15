package com.example.negozio;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.negozio.fragment.CategoryFragment;
import com.example.negozio.fragment.TransformerFragment;

import java.util.ArrayList;

public class TransformerAdapter extends RecyclerView.Adapter <TransformerAdapter.TransformerViewHolder> implements View.OnClickListener {

private ArrayList <CapiAbbigliamento> mCapiAbbigliamento=new ArrayList<>();
private CapiAbbigliamento currentItem, viewHolderItem;
private ImageView mImgCapo;
private TextView mTextNome, mTextBrand, mTextPrezzo;
private RecyclerView mRecyclerView;
private FragmentManager mFragmentManager;




public TransformerAdapter(ArrayList<CapiAbbigliamento> capiAbbigliamento){
        mCapiAbbigliamento=capiAbbigliamento;

    }

    @NonNull
    @Override
    public TransformerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_capo_abbigliamento, parent, false);
        TransformerAdapter.TransformerViewHolder holder = new TransformerAdapter.TransformerViewHolder(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TransformerAdapter.TransformerViewHolder holder, int position) {
        currentItem=mCapiAbbigliamento.get(position);
        mImgCapo=holder.view.findViewById(R.id.img_capo);
        mTextNome=holder.view.findViewById(R.id.textNome);
        mTextBrand=holder.view.findViewById(R.id.textBrand);
        mTextPrezzo=holder.view.findViewById(R.id.textPrezzo);
        mImgCapo.setImageBitmap(currentItem.getImmagine());
        mTextNome.setText(currentItem.getDescrizione());
        mTextBrand.setText(currentItem.getBrand());
        mTextPrezzo.setText((CharSequence) currentItem.getPrezzo());
    }

    @Override
    public void onClick(View v) {

        int position = mRecyclerView.getChildLayoutPosition(v);
        CapiAbbigliamento viewHolderItem = mCapiAbbigliamento.get(position);
        Fragment transformer=new TransformerFragment(position);
        mFragmentManager.beginTransaction().replace(R.id.box,transformer).addToBackStack(null).commit();

    }

    @Override
    public int getItemCount() {
        return mCapiAbbigliamento.size();
    }

    public class TransformerViewHolder extends RecyclerView.ViewHolder{

        public View view;

    public TransformerViewHolder(View v) {
            super(v);
            view=v;

        }
    }
}
