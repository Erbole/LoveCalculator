package com.geektach.lovecalculator.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.geektach.lovecalculator.App;
import com.geektach.lovecalculator.R;
import com.geektach.lovecalculator.databinding.FragmentHomeBinding;
import com.geektach.lovecalculator.network.LoveModel;
import com.geektach.lovecalculator.viewModel.HomeViewModel;

import java.io.Serializable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    NavController navController;
    FragmentHomeBinding binding;
    HomeViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        navController = NavHostFragment.findNavController(this);
        initClickers();
        rawAnimations();
    }

    private void rawAnimations() {
        binding.animationView.setAnimation(R.raw.button_next);
    }

    private void initClickers() {
        binding.tryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDataFromLoveApi();
            }
        });
    }

    private void getDataFromLoveApi() {
        String firstName = binding.firstNameEt.getText().toString();
        String secondName = binding.secondNameEt.getText().toString();
        viewModel.getLoveModelLoveData(firstName, secondName).observe(this, model -> {
            Bundle bundle = new Bundle();
            bundle.putString("fName", model.firstName);
            bundle.putString("sName", model.secondName);
            bundle.putString("percentage", model.percentage);
            bundle.putString("result", model.result);
            navController.navigate(R.id.secondFragment, bundle);
        });
    }
}
