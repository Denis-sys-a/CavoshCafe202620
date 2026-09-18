package com.senatino.cavoshcafe202620.ui.productos;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.senatino.cavoshcafe202620.R;
import com.senatino.cavoshcafe202620.databinding.FragmentDetalleProductoBinding;

import java.util.Locale;

public class DetalleProductoFragment extends Fragment {

    FragmentDetalleProductoBinding binding;
    Context context;
    NavController navController;
    View view;

    private int cantidad = 1;
    private boolean favorito = false;
    private double precioUnitario = 4.70;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDetalleProductoBinding.inflate(inflater, container, false);
        return view = binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = getContext();
        navController = Navigation.findNavController(view);

        binding.tvNombreProductoDetalle.setText("Caramel Macchiato");
        actualizarTotal();

        binding.ivVolver.setOnClickListener(v -> navController.navigateUp());

        binding.ivFavoritoDetalle.setOnClickListener(v -> {
            favorito = !favorito;
            binding.ivFavoritoDetalle.setImageResource(
                    favorito ? R.drawable.ic_favoritos_selected : R.drawable.ic_favoritos);
        });

        binding.ivMas.setOnClickListener(v -> {
            cantidad++;
            binding.tvCantidad.setText(String.valueOf(cantidad));
            actualizarTotal();
        });

        binding.ivMenos.setOnClickListener(v -> {
            if (cantidad > 1) {
                cantidad--;
                binding.tvCantidad.setText(String.valueOf(cantidad));
                actualizarTotal();
            }
        });

        binding.tvTallaSmall.setOnClickListener(v -> seleccionarTalla(binding.tvTallaSmall));
        binding.tvTallaMedium.setOnClickListener(v -> seleccionarTalla(binding.tvTallaMedium));
        binding.tvTallaLarge.setOnClickListener(v -> seleccionarTalla(binding.tvTallaLarge));

        binding.ivChange.setOnClickListener(v ->
                Toast.makeText(context, "Abrir hoja de personalización", Toast.LENGTH_SHORT).show());

        binding.btnAgregarCarritoDetalle.setOnClickListener(v ->
                Toast.makeText(context, cantidad + " x Caramel Macchiato agregado al carrito", Toast.LENGTH_SHORT).show());
    }

    private void seleccionarTalla(android.widget.TextView seleccionada) {
        android.widget.TextView[] tallas = {
                binding.tvTallaSmall, binding.tvTallaMedium, binding.tvTallaLarge
        };
        for (android.widget.TextView talla : tallas) {
            boolean esSeleccionada = (talla == seleccionada);
            talla.setBackgroundResource(esSeleccionada ? R.drawable.sh_chip_seleccionado : R.drawable.sh_chip_normal);
            talla.setTextColor(esSeleccionada
                    ? getResources().getColor(R.color.white)
                    : getResources().getColor(R.color.gunmetal));
        }
    }

    private void actualizarTotal() {
        double total = precioUnitario * cantidad;
        binding.tvTotalPrice.setText(String.format(Locale.getDefault(), "S/%.2f", total));
    }
}