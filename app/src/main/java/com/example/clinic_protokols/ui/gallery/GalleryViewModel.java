package com.example.clinic_protokols.ui.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GalleryViewModel extends ViewModel {
    private final String[] countries = {
            "Классификатор 1",
            "Классификатор 2",
            "Классификатор 3",
            "Классификатор 4",
            "Классификатор 5"
    };


    public String[] getCountries() {
        return countries;
    }
}