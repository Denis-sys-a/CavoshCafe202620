package com.senatino.cavoshcafe202620.ui.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.senatino.cavoshcafe202620.databinding.ItemFavoritoBinding;
import com.senatino.cavoshcafe202620.domain.model.Producto;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FavoritoAdapter extends RecyclerView.Adapter<FavoritoAdapter.FavoritoViewHolder> {

    public interface OnFavoritoAgregarListener {
        void onAgregarClick(Producto producto);
    }

    private List<Producto> favoritos = new ArrayList<>();
    private final OnFavoritoAgregarListener listener;

    public FavoritoAdapter(OnFavoritoAgregarListener listener) {
        this.listener = listener;
    }

    public void setFavoritos(List<Producto> nuevaLista) {
        this.favoritos = (nuevaLista != null) ? nuevaLista : new ArrayList<>();
        notifyDataSetChanged();
    }

    public int getCantidadItems() {
        return favoritos.size();
    }

    @NonNull
    @Override
    public FavoritoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFavoritoBinding binding = ItemFavoritoBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new FavoritoViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritoViewHolder holder, int position) {
        holder.bind(favoritos.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return favoritos.size();
    }

    static class FavoritoViewHolder extends RecyclerView.ViewHolder {
        private final ItemFavoritoBinding binding;

        FavoritoViewHolder(ItemFavoritoBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Producto producto, OnFavoritoAgregarListener listener) {
            binding.tvNombreFavorito.setText(producto.getNombre());
            binding.tvDetalleFavorito.setText(producto.getDetalle());
            binding.tvMontoFavorito.setText(String.format(Locale.getDefault(), "%.2f", producto.getPrecio()));

            if (producto.getImagenUrl() != null && !producto.getImagenUrl().isEmpty()) {
                Picasso.get().load(producto.getImagenUrl()).into(binding.ivProductoFavorito);
            } else if (producto.getImagenResId() != 0) {
                binding.ivProductoFavorito.setImageResource(producto.getImagenResId());
            }

            binding.ivAgregarFavorito.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onAgregarClick(producto);
                }
            });
        }
    }
}