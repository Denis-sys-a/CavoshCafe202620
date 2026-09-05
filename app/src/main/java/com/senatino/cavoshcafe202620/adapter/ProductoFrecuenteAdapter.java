package com.senatino.cavoshcafe202620.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.senatino.cavoshcafe202620.databinding.ItemProductoFrecuenteBinding;
import com.senatino.cavoshcafe202620.model.Producto;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProductoFrecuenteAdapter extends RecyclerView.Adapter<ProductoFrecuenteAdapter.ProductoViewHolder> {

    public interface OnProductoAgregarListener {
        void onAgregarClick(Producto producto);
    }

    private List<Producto> productos = new ArrayList<>();
    private final OnProductoAgregarListener listener;

    public ProductoFrecuenteAdapter(OnProductoAgregarListener listener) {
        this.listener = listener;
    }

    public void setProductos(List<Producto> nuevaLista) {
        this.productos = (nuevaLista != null) ? nuevaLista : new ArrayList<>();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemProductoFrecuenteBinding binding = ItemProductoFrecuenteBinding.inflate(
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
        private final ItemProductoFrecuenteBinding binding;

        ProductoViewHolder(ItemProductoFrecuenteBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Producto producto, OnProductoAgregarListener listener) {
            binding.tvNombreFrecuente.setText(producto.getNombre());
            binding.tvDetalleFrecuente.setText(producto.getDetalle());
            binding.tvPrecioFrecuente.setText(
                    String.format(Locale.getDefault(), "S/%.2f", producto.getPrecio()));

            if (producto.getImagenUrl() != null && !producto.getImagenUrl().isEmpty()) {
                Picasso.get().load(producto.getImagenUrl()).into(binding.ivProductoFrecuente);
            } else if (producto.getImagenResId() != 0) {
                binding.ivProductoFrecuente.setImageResource(producto.getImagenResId());
            }

            binding.ivAgregarFrecuente.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onAgregarClick(producto);
                }
            });
        }
    }
}