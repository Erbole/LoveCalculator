package com.geektach.lovecalculator.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geektach.lovecalculator.R;
import com.geektach.lovecalculator.databinding.FragmentSecondBinding;
import com.geektach.lovecalculator.network.LoveModel;

public class SecondFragment extends Fragment {

    FragmentSecondBinding binding;
    NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = NavHostFragment.findNavController(this);
        getResult();
        rawAnim();
        initClick();
    }

    private void rawAnim() {
        binding.backBtn.setAnimation(R.raw.back_btn);
        binding.secondBack.setAnimation(R.raw.second_back);
        binding.animationView.setAnimation(R.raw.love_anim);
    }

    private void initClick() {
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigateUp();
            }
        });
    }

    private void getResult() {
        assert getArguments() != null;
        String firstName = getArguments().getString("fName");
        binding.firstName.setText(firstName);
        String secondName = getArguments().getString("sName");
        binding.secondName.setText(secondName);
        String percentage = getArguments().getString("percentage");
        binding.resultTv.setText(percentage);
        String result = getArguments().getString("result");
        binding.result.setText(result);
    }
}