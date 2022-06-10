package com.example.mythirdapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class BrandAdapter extends BaseAdapter {
    private List<Brand> contenu;
    private Context context;

    public BrandAdapter(List<Brand> contenu, Context context){
        this.contenu= contenu;
        this.context= context;
    }

    @Override
    public int getCount() {
        return this.contenu.size();
    }

    @Override
    public Object getItem(int i) {
        return this.contenu.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            LayoutInflater inflater = LayoutInflater.from(this.context);
            view = inflater.inflate(R.layout.row, null);
        }

        Brand current = (Brand) getItem(i);
        TextView tv_n = view.findViewById(R.id.tv_nom);



        tv_n.setText(current.getName());//just one here et dans un set text on peut pas envoyer d'int faut le transormer
        //tv_dc.setText(Integer.toString(current.getDevice_count()));


        return view;
    }
}
