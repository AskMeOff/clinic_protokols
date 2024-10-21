package com.example.clinic_protokols.ui.gallery;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.clinic_protokols.R;
import com.example.clinic_protokols.databinding.FragmentGalleryBinding;
import com.example.clinic_protokols.ui.ProtocolItem;
import com.google.android.material.snackbar.Snackbar;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);
        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        ListView countriesList = binding.countriesList;
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_list_item_1, galleryViewModel.getCountries());
        countriesList.setAdapter(adapter);

        countriesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedClassifier = adapter.getItem(position);
                String textInfo = "";
                switch (position){
                    case 0:
                        textInfo = "информация по первому протоколу";
                        break;
                    case 1:
                        textInfo = "информация по второму протоколу";
                        break;
                    case 2:
                        textInfo = "информация по третьему протоколу";
                        break;
                    case 3:
                        textInfo = "информация по четвертому протоколу";
                        break;
                    case 4:
                        textInfo = "информация по пятому протоколу";
                        break;
                }
                System.out.println(selectedClassifier);
                Intent intent = new Intent(requireActivity(), ProtocolItem.class);

                intent.putExtra("classifier_name", selectedClassifier);
                intent.putExtra("classifier_info", textInfo);

                startActivity(intent);
            }
        });

        return root;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}