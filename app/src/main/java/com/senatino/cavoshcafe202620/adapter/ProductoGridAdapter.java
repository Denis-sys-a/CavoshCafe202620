package com.senatino.cavoshcafe202620.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.senatino.cavoshcafe202620.R;
import com.senatino.cavoshcafe202620.databinding.ItemProductoGridBinding;
import com.senatino.cavoshcafe202620.model.Producto;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProductoGridAdapter extends RecyclerView.Adapter<ProductoGridAdapter.ProductoViewHolder> {

    public interface OnProductoGridListener {
        void onAgregarClick(Producto producto);
        void onFavoritoClick(Producto producto);
        void onProductoClick(Producto producto);
    }

    private List<Producto> productos = new ArrayList<>();
    private final OnProductoGridListener listener;

    public ProductoGridAdapter(OnProductoGridListener listener) {
        this.listener = listener;
    }

    public void setProductos(List<Producto> nuevaLista) {
        this.productos = (nuevaLista != null) ? nuevaLista : new ArrayList<>();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemProductoGridBinding binding = ItemProductoGridBinding.inflate(
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
        private final ItemProductoGridBinding binding;

        ProductoViewHolder(ItemProductoGridBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Producto producto, OnProductoGridListener listener) {
            binding.tvNombreProductoGrid.setText(producto.getNombre());
            binding.tvPrecioProductoGrid.setText(
                    String.format(Locale.getDefault(), "S/%.2f", producto.getPrecio()));

            if (producto.getImagenUrl() != null && !producto.getImagenUrl().isEmpty()) {
                Picasso.get().load(producto.getImagenUrl()).into(binding.ivProductoGrid);
            } else if (producto.getImagenResId() != 0) {
                binding.ivProductoGrid.setImageResource(producto.getImagenResId());
            }

            actualizarIconoFavorito(producto);

            // 2. CLIC EN TODA LA TARJETA DEL PRODUCTO
            binding.getRoot().setOnClickListener(v -> {
                if (listener != null) {
                    listener.onProductoClick(producto);
                } else {
                    Navigation.findNavController(v).navigate(R.id.action_navigation_menu_to_navigation_detalle_producto);
                }
            });

            binding.ivFavoritoGrid.setOnClickListener(v -> {
                producto.setFavorito(!producto.isFavorito());
                actualizarIconoFavorito(producto);
                if (listener != null) {
                    listener.onFavoritoClick(producto);
                }
            });

            binding.ivAgregarGrid.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onAgregarClick(producto);
                }
            });
        }

        private void actualizarIconoFavorito(Producto producto) {
            binding.ivFavoritoGrid.setImageResource(
                    producto.isFavorito() ? R.drawable.ic_favoritos_selected : R.drawable.ic_favoritos);
        }
    }
}