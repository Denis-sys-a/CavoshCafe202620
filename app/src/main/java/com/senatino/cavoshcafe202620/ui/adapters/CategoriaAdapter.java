package com.senatino.cavoshcafe202620.ui.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.senatino.cavoshcafe202620.R;
import com.senatino.cavoshcafe202620.databinding.ItemCategoriaBinding;
import com.senatino.cavoshcafe202620.domain.model.Categoria;

import java.util.ArrayList;
import java.util.List;

public class CategoriaAdapter extends RecyclerView.Adapter<CategoriaAdapter.CategoriaViewHolder> {

    public interface OnCategoriaClickListener {
        void onCategoriaClick(Categoria categoria);
    }

    private List<Categoria> categorias = new ArrayList<>();
    private int posicionSeleccionada = 0;
    private final OnCategoriaClickListener listener;

    public CategoriaAdapter(OnCategoriaClickListener listener) {
        this.listener = listener;
    }

    public void setCategorias(List<Categoria> nuevaLista) {
        this.categorias = (nuevaLista != null) ? nuevaLista : new ArrayList<>();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoriaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCategoriaBinding binding = ItemCategoriaBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new CategoriaViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriaViewHolder holder, int position) {
        Categoria categoria = categorias.get(position);
        boolean seleccionada = (position == posicionSeleccionada);

        holder.binding.tvNombreCategoria.setText(categoria.getNombre());
        holder.binding.ivIconoCategoria.setImageResource(categoria.getIconoResId());

        int colorTexto = seleccionada
                ? holder.itemView.getResources().getColor(R.color.white)
                : holder.itemView.getResources().getColor(R.color.gunmetal);

        holder.binding.getRoot().setBackgroundResource(
                seleccionada ? R.drawable.sh_chip_seleccionado : R.drawable.sh_chip_normal);
        holder.binding.tvNombreCategoria.setTextColor(colorTexto);
        holder.binding.ivIconoCategoria.setColorFilter(colorTexto);

        holder.itemView.setOnClickListener(v -> {
            int posicionAnterior = posicionSeleccionada;
            posicionSeleccionada = holder.getBindingAdapterPosition();
            notifyItemChanged(posicionAnterior);
            notifyItemChanged(posicionSeleccionada);

            if (listener != null) {
                listener.onCategoriaClick(categoria);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categorias.size();
    }

    static class CategoriaViewHolder extends RecyclerView.ViewHolder {
        private final ItemCategoriaBinding binding;

        CategoriaViewHolder(ItemCategoriaBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}