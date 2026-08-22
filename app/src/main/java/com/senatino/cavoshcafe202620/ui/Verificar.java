package com.senatino.cavoshcafe202620.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.support.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.senatino.cavoshcafe202620.R;
import com.senatino.cavoshcafe202620.databinding.FragmentVerificarBinding;
import com.senatino.cavoshcafe202620.databinding.FragmentVerificarBinding;

public class Verificar extends Fragment {
    FragmentVerificarBinding binding;
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
        binding = FragmentVerificarBinding.inflate(inflater, container, false );
        return view = binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = getContext();
        navController = Navigation.findNavController( view );
    }
}