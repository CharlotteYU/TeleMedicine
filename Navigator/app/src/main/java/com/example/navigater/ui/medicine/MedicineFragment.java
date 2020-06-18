package com.example.navigater.ui.medicine;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.navigater.MainActivity;
import com.example.navigater.R;

import java.util.ArrayList;


public class MedicineFragment extends Fragment {

    private MedicineViewModel medicineViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_medicine, container, false);
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
            ListView listView = (ListView) view.findViewById(R.id.list_medicine);
            ArrayList<String> arrayList = new ArrayList<String>();
            ArrayList<String> list = activity.getMyDb().getMedicine(1).getMedicine();
            int max = activity.getMyDb().getMedicine(1).getNb();
            for(int i=0 ;i<max;i++){
                String a = list.get(i);
                arrayList.add(a);
            }

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(activity,android.R.layout.simple_list_item_1,arrayList);
            listView.setAdapter(arrayAdapter);
        }

    }


}
