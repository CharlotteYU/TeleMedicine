package com.example.navigater.ui.home;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.navigater.DatabaseHelper;
import com.example.navigater.MainActivity;
import com.example.navigater.R;

import org.w3c.dom.Text;

import java.util.Objects;

import javax.xml.xpath.XPathException;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

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
            String str = activity.getMyDb().getPatient(1).getFirstname();
            int a = activity.getMyDb().getPatient(1).getAge();
            String sym = activity.getMyDb().getPatient(1).getSymptom();
            String age_1 = Integer.toString(a);
            TextView name = view.findViewById(R.id.patient_name);
            TextView age = view.findViewById(R.id.patient_age);
            TextView symptom = view.findViewById(R.id.patient_symptom);
            name.setText(str);
            age.setText(age_1);
            symptom.setText(sym);
        }
    }


}
