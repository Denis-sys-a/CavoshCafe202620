package com.senatino.cavoshcafe202620.ui;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.support.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.senatino.cavoshcafe202620.R;
import com.senatino.cavoshcafe202620.adapter.ProductoFrecuenteAdapter;
import com.senatino.cavoshcafe202620.adapter.ProductoNuevoAdapter;
import com.senatino.cavoshcafe202620.databinding.FragmentInicioBinding;
import com.senatino.cavoshcafe202620.model.Producto;

import java.util.ArrayList;
import java.util.List;

public class Inicio extends Fragment {

    FragmentInicioBinding binding;
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
        binding = FragmentInicioBinding.inflate(inflater, container, false);
        return view = binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = getContext();
        navController = Navigation.findNavController(view);

        configurarListaNuevos();
        configurarListaFrecuentes();
    }

    private void configurarListaNuevos() {
        binding.rvNuevos.setLayoutManager(
                new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));

        ProductoNuevoAdapter adapter = new ProductoNuevoAdapter(producto ->
                Toast.makeText(context, producto.getNombre() + " agregado al carrito", Toast.LENGTH_SHORT).show());

        adapter.setProductos(obtenerProductosNuevosMock());
        binding.rvNuevos.setAdapter(adapter);
    }

    private void configurarListaFrecuentes() {
        binding.rvFrecuentes.setLayoutManager(
                new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));

        ProductoFrecuenteAdapter adapter = new ProductoFrecuenteAdapter(producto ->
                Toast.makeText(context, producto.getNombre() + " agregado al carrito", Toast.LENGTH_SHORT).show());

        adapter.setProductos(obtenerProductosFrecuentesMock());
        binding.rvFrecuentes.setAdapter(adapter);
    }

    private List<Producto> obtenerProductosNuevosMock() {
        List<Producto> lista = new ArrayList<>();
        lista.add(new Producto(1, "Caramel Macchiato", 4.70, "Espresso con caramelo", R.drawable.logo, null));
        lista.add(new Producto(2, "Vanilla Latte", 3.00, "Espresso con vainilla", R.drawable.logo, null));
        lista.add(new Producto(3, "White Chocolate Mocha", 5.20, "Chocolate blanco", R.drawable.logo, null));
        return lista;
    }

    private List<Producto> obtenerProductosFrecuentesMock() {
        List<Producto> lista = new ArrayList<>();
        lista.add(new Producto(4, "Caramel Macchiato", 4.70, "Large, Oat milk", R.drawable.logo, null));
        lista.add(new Producto(5, "Traditional Cappuccino", 3.50, "Medium, Whole milk", R.drawable.logo, null));
        lista.add(new Producto(6, "Blueberry Muffin", 3.20, "Unidad", R.drawable.logo, null));
        lista.add(new Producto(7, "Vanilla Latte", 3.00, "Medium, Almond milk", R.drawable.logo, null));
        return lista;
    }
}