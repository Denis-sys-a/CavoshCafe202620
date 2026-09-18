package com.senatino.cavoshcafe202620.ui.auth;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.senatino.cavoshcafe202620.R;
import com.senatino.cavoshcafe202620.databinding.FragmentLoginBinding;

public class Login extends Fragment {

    FragmentLoginBinding binding;
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
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return view = binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = getContext();
        navController = Navigation.findNavController(view);

        binding.btnIniciarSesion.setOnClickListener(v -> navController.navigate(R.id.navigation_inicio));

        binding.tvRegistrar.setOnClickListener(v ->
                navController.navigate(R.id.action_navigation_login_to_navigation_registrar));

        binding.tvRegistrarAhora.setOnClickListener(v ->
                navController.navigate(R.id.action_navigation_login_to_navigation_registrar));
    }
}