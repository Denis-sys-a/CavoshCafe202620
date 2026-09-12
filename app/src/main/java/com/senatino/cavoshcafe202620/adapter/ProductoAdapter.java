package com.senatino.cavoshcafe202620.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.List;

import com.senatino.cavoshcafe202620.R;
import com.senatino.cavoshcafe202620.model.Producto;
import com.squareup.picasso.Picasso;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ViewHolder> {
    Context context;
    List<Producto> productos = null;
    public ProductoAdapter(Context context, List<Producto> productos) {
        this.context = context;
        this.productos = productos;
    }

    @NonNull
    @Override
    public ProductoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_producto_grid, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoAdapter.ViewHolder holder, int position) {
        Producto producto = productos.get( position );
        holder.tvNombreProducto.setText( String.format( "%s\n%s", producto.getDetalle(), producto.getDescripcion() ) );
        holder.tvPrecioProducto.setText( new DecimalFormat( "###.##").format( producto.getPrecio() ) );

        Picasso.get()
                .load("URL...." + producto.getId() + ".jpg" )
                .fit().centerCrop()
                .placeholder(R.drawable.ic_imagen)
                .error( R.drawable.ic_imagen )
                .into( holder.ivProducto );

        holder.itemView.setOnClickListener(v -> {

        } );
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgProducto, imgPlus, imgFavorite;
        TextView tvNombreProducto, tvPrecioProducto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProducto = itemView.findViewById(R.id.ivProducto);
            imgPlus = itemView.findViewById(R.id.ivAgregar);
            tvNombreProducto = itemView.findViewById(R.id.tvNombreProducto);
            tvPrecioProducto = itemView.findViewById(R.id.tvPrecioProducto);
        }
    }

}
