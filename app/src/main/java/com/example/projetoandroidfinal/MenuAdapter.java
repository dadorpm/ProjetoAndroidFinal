package com.example.projetoandroid;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder>{
    private final ArrayList<Menu> menus;
    private Context context;

    public MenuAdapter(ArrayList<Menu> menus, Context context) {
        this.menus = menus;
        this.context = context;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cartoes, null);
        return new MenuViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.MenuViewHolder holder, final int position) {
        holder.imagemMenu.setImageResource(menus.get(position).getImagem());
        holder.nomeMenu.setText(menus.get(position).getTitulo());
        holder.infMenu.setText(menus.get(position).getDescricao());
        holder.cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                switch (position){

                    case 0:
                        Intent intent = new Intent(context, SobreActivity.class);
                        context.startActivity(intent);
                        break;

                    case 1:
                         intent = new Intent(context, LivroActivity.class);
                        context.startActivity(intent);
                        break;
                    case 2:
                         intent = new Intent(context, ListarAlunosActivity.class);
                        context.startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(context, WebServicesActivity.class);
                        context.startActivity(intent);
                        break;

                }

            }
        });

        Animation animacao = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
        holder.itemView.startAnimation(animacao);
    }

    @Override
    public int getItemCount() {
        return menus.size();
    }


    static class MenuViewHolder extends RecyclerView.ViewHolder{
        private ImageView imagemMenu;
        private TextView nomeMenu;
        private TextView infMenu;
        private LinearLayout cardView;


        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            nomeMenu=itemView.findViewById(R.id.nomeMenu);
            infMenu=itemView.findViewById(R.id.infMenu);
            imagemMenu=itemView.findViewById(R.id.imageView);
            cardView = itemView.findViewById(R.id.cardView);
        }

    }
}
