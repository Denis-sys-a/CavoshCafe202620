package com.senatino.cavoshcafe202620.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.senatino.cavoshcafe202620.databinding.ItemProductoNuevoBinding;
import com.senatino.cavoshcafe202620.model.Producto;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProductoNuevoAdapter extends RecyclerView.Adapter<ProductoNuevoAdapter.ProductoViewHolder> {

    public interface OnProductoAgregarListener {
        void onAgregarClick(Producto producto);
    }

    private List<Producto> productos = new ArrayList<>();
    private final OnProductoAgregarListener listener;

    public ProductoNuevoAdapter(OnProductoAgregarListener listener) {
        this.listener = listener;
    }

    public void setProductos(List<Producto> nuevaLista) {
        this.productos = (nuevaLista != null) ? nuevaLista : new ArrayList<>();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemProductoNuevoBinding binding = ItemProductoNuevoBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new ProductoViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        holder.bind(productos.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    static class ProductoViewHolder extends RecyclerView.ViewHolder {
        private final ItemProductoNuevoBinding binding;

        ProductoViewHolder(ItemProductoNuevoBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Producto producto, OnProductoAgregarListener listener) {
            binding.tvNombreProducto.setText(producto.getNombre());
            binding.tvPrecioProducto.setText(
                    String.format(Locale.getDefault(), "S/%.2f", producto.getPrecio()));

            if (producto.getImagenUrl() != null && !producto.getImagenUrl().isEmpty()) {
                Picasso.get().load(producto.getImagenUrl()).into(binding.ivProducto);
            } else if (producto.getImagenResId() != 0) {
                binding.ivProducto.setImageResource(producto.getImagenResId());
            }

            binding.ivAgregar.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onAgregarClick(producto);
                }
            });
        }
    }
}