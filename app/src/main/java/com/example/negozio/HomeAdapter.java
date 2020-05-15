package com.example.negozio;

import android.app.AlertDialog;
import android.content.Context;
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

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter <HomeAdapter.HomeViewHolder> implements View.OnClickListener{

    private ArrayList<HomeModel> mModelList = new ArrayList<>();
    private Context mContext;
    private HomeModel currentItem, viewHolderItem;
    private ImageView imgCategoria;
    private TextView txtCategoria;
    private RecyclerView mRecyclerView;
    private FragmentManager mFragmentManager;


    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_model_item, parent, false);
        HomeViewHolder holder = new HomeViewHolder(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        currentItem = mModelList.get(position);
        imgCategoria = holder.view.findViewById(R.id.imgCategoria);
        txtCategoria = holder.view.findViewById(R.id.categoria);
        imgCategoria.setImageResource(currentItem.getImage());
        txtCategoria.setText(currentItem.getText());


    }

    @Override
    public int getItemCount() {
        return mModelList.size();
    }

    @Override
    public void onClick(View v) {

        int position = mRecyclerView.getChildLayoutPosition(v);
         HomeModel viewHolderItem = mModelList.get(position);
        Fragment category=new CategoryFragment(position);
        mFragmentManager.beginTransaction().replace(R.id.container,category).addToBackStack(null).commit();
                /*View alertView=LayoutInflater.from(mContext).inflate(R.layout.home_model_item,null);
                ImageView img = alertView.findViewById(R.id.imgCategoria);
                img.setImageResource(viewHolderItem.getImage());
                TextView txt=alertView.findViewById(R.id.categoria);
                txt.setText(viewHolderItem.getText());
                AlertDialog.Builder alert=new AlertDialog.Builder(mContext);
                alert.setView(alertView)
                        .create()
                        .show();*/

    }

    public static class HomeViewHolder extends RecyclerView.ViewHolder{

        public View view;

        public HomeViewHolder (View v){
            super(v);
            view = v;
        }

    }

    public HomeAdapter (ArrayList<HomeModel> modelList, Context context, RecyclerView recyclerView, FragmentManager fm){
        mModelList=modelList;
        mContext=context;
        mRecyclerView= recyclerView;
        mFragmentManager=fm;
    }


}
