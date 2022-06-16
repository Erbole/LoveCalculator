package com.geektach.lovecalculator.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.geektach.lovecalculator.network.LoveModel;
import com.geektach.lovecalculator.repository.Repository;

public class HomeViewModel extends ViewModel {

    Repository repository = new Repository();

    public LiveData<LoveModel> getLoveModelLoveData(String first, String second) {
        return repository.getData(first, second);
    }
}