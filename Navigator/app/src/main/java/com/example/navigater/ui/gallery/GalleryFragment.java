package com.example.navigater.ui.gallery;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.navigater.MainActivity;
import com.example.navigater.R;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
/*        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);*/
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
/*        final TextView textView = root.findViewById(R.id.text_gallery);
        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        return root;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        MainActivity activity = (MainActivity)getActivity();
        if(view!= null){
            assert activity != null;
            ListView listView = (ListView) view.findViewById(R.id.list_view);
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("123");
            arrayList.add("sdf");
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(activity,android.R.layout.simple_list_item_1,arrayList);
            listView.setAdapter(arrayAdapter);
        }

    }
}
