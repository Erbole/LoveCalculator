package com.geektach.lovecalculator.board;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geektach.lovecalculator.OnClickListener;
import com.geektach.lovecalculator.Prefs;
import com.geektach.lovecalculator.R;
import com.geektach.lovecalculator.databinding.FragmentBoardragmentBinding;

import java.util.ArrayList;

import javax.inject.Inject;

public class BoardFragment extends Fragment implements OnClickListener {
    FragmentBoardragmentBinding binding;
    NavController navController;

    @Inject
    Prefs prefs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentBoardragmentBinding.inflate(getLayoutInflater());
        return (binding.getRoot());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        prefs.setContext(requireActivity());
        BoardAdapter adapter = new BoardAdapter(this);
        ViewPager2 viewPager2 = view.findViewById(R.id.viewPager);
        viewPager2.setAdapter(adapter);
        binding.dotsIndicator.setViewPager2(viewPager2);
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                requireActivity().finish();
            }
        });
        binding.btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                close();
            }
        });
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if (position == 3) {
                    binding.btnSkip.setVisibility(View.INVISIBLE);
                } else {
                    binding.btnSkip.setVisibility(View.VISIBLE);
                }
            }
        });
        binding.btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClick();
            }
        });
    }

    private void close() {
        prefs.saveBoard();
        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
        navController.navigateUp();
    }

    @Override
    public void itemClick() {
        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
        navController.navigateUp();
    }
}