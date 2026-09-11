package com.senatino.cavoshcafe202620.ui;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.senatino.cavoshcafe202620.R;
import com.senatino.cavoshcafe202620.adapter.CategoriaAdapter;
import com.senatino.cavoshcafe202620.adapter.ProductoGridAdapter;
import com.senatino.cavoshcafe202620.databinding.FragmentMenuBinding;
import com.senatino.cavoshcafe202620.model.Categoria;
import com.senatino.cavoshcafe202620.model.Producto;

import java.util.ArrayList;
import java.util.List;

public class Menu extends Fragment {

    FragmentMenuBinding binding;
    Context context;
    NavController navController;
    View view;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMenuBinding.inflate(inflater, container, false);
        return view = binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = getContext();
        navController = Navigation.findNavController(view);

        configurarCategorias();
        configurarGrillaProductos();
    }

    private void configurarCategorias() {
        binding.rvCategorias.setLayoutManager(
                new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));

        CategoriaAdapter adapter = new CategoriaAdapter(categoria ->
                Toast.makeText(context, categoria.getNombre(), Toast.LENGTH_SHORT).show());

        adapter.setCategorias(obtenerCategoriasMock());
        binding.rvCategorias.setAdapter(adapter);
    }

    private void configurarGrillaProductos() {
        binding.rvProductosGrid.setLayoutManager(new GridLayoutManager(getContext(), 2));

        ProductoGridAdapter adapter = new ProductoGridAdapter(new ProductoGridAdapter.OnProductoGridListener() {
            @Override
            public void onAgregarClick(Producto producto) {
                Toast.makeText(context, producto.getNombre() + " agregado al carrito", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFavoritoClick(Producto producto) {
                String mensaje = producto.isFavorito()
                        ? producto.getNombre() + " agregado a favoritos"
                        : producto.getNombre() + " quitado de favoritos";
                Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onProductoClick(Producto producto) {
                Navigation.findNavController(requireView()).navigate(R.id.action_navigation_menu_to_navigation_detalle_producto);
            }
        });

        adapter.setProductos(obtenerProductosGridMock());
        binding.rvProductosGrid.setAdapter(adapter);
    }

    private List<Categoria> obtenerCategoriasMock() {
        List<Categoria> lista = new ArrayList<>();
        lista.add(new Categoria(1, getString(R.string.cat_todos), R.drawable.ic_cat_todos));
        lista.add(new Categoria(2, getString(R.string.cat_bebidas_calientes), R.drawable.ic_cat_bebidas_calientes));
        lista.add(new Categoria(3, getString(R.string.cat_bebidas_frias), R.drawable.ic_cat_bebidas_frias));
        lista.add(new Categoria(4, getString(R.string.cat_snacks), R.drawable.ic_cat_snacks));
        return lista;
    }

    private List<Producto> obtenerProductosGridMock() {
        List<Producto> lista = new ArrayList<>();
        lista.add(new Producto(1, "Caramel Macchiato", 4.70, "Espresso con caramelo", R.drawable.logo, null));
        lista.add(new Producto(2, "Vanilla Latte", 3.00, "Espresso con vainilla", R.drawable.logo, null));
        lista.add(new Producto(3, "White Chocolate Mocha", 5.20, "Chocolate blanco", R.drawable.logo, null));
        lista.add(new Producto(4, "Traditional Cappuccino", 3.50, "Espuma clásica", R.drawable.logo, null));
        lista.add(new Producto(5, "Blueberry Muffin", 3.20, "Con arándanos", R.drawable.logo, null));
        lista.add(new Producto(6, "Cinnamon Roll", 3.90, "Glaseado dulce", R.drawable.logo, null));
        return lista;
    }
}