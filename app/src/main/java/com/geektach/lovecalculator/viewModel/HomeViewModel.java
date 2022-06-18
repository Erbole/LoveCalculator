package com.geektach.lovecalculator.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.geektach.lovecalculator.network.LoveModel;
import com.geektach.lovecalculator.repository.Repository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class HomeViewModel extends ViewModel {

    Repository repository;

    @Inject
    public HomeViewModel(Repository repository) {
        this.repository = repository;
    }

    public LiveData<LoveModel> getLoveModelLoveData(String first, String second) {
        return repository.getData(first, second);
    }
}