package com.senatino.cavoshcafe202620.ui;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.senatino.cavoshcafe202620.R;
import com.senatino.cavoshcafe202620.adapter.FavoritoAdapter;
import com.senatino.cavoshcafe202620.databinding.FragmentFavoritosBinding;
import com.senatino.cavoshcafe202620.model.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Favoritos extends Fragment {

    FragmentFavoritosBinding binding;
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
        binding = FragmentFavoritosBinding.inflate(inflater, container, false);
        return view = binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = getContext();
        navController = Navigation.findNavController(view);

        configurarListaFavoritos();

        binding.tvEditarFavoritos.setOnClickListener(v ->
                Toast.makeText(context, "Modo edicion de favoritos", Toast.LENGTH_SHORT).show());
    }

    private void configurarListaFavoritos() {
        binding.rvFavoritos.setLayoutManager(new LinearLayoutManager(context));

        FavoritoAdapter adapter = new FavoritoAdapter(producto ->
                Toast.makeText(context, producto.getNombre() + " agregado al carrito", Toast.LENGTH_SHORT).show());

        List<Producto> favoritosMock = obtenerFavoritosMock();
        adapter.setFavoritos(favoritosMock);
        binding.rvFavoritos.setAdapter(adapter);

        binding.tvContadorFavoritos.setText(
                String.format(Locale.getDefault(), getString(R.string.items_formato), favoritosMock.size()));
    }

    private List<Producto> obtenerFavoritosMock() {
        List<Producto> lista = new ArrayList<>();
        lista.add(new Producto(1, "Caramel Macchiato", 6.70, "Large, Oat milk", R.drawable.logo, null));
        lista.add(new Producto(2, "Caffe Mocha", 5.90, "Medium, Whole milk", R.drawable.logo, null));
        lista.add(new Producto(3, "Traditional Cappuccino", 4.50, "Medium, Almond milk", R.drawable.logo, null));
        lista.add(new Producto(4, "Cinnamon Roll", 3.90, "Unidad", R.drawable.logo, null));
        return lista;
    }
}