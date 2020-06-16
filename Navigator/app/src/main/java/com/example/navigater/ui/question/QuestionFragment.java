package com.example.navigater.ui.question;

import androidx.lifecycle.ViewModelProviders;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.navigater.MainActivity;
import com.example.navigater.R;
import com.google.android.material.textfield.TextInputEditText;

public class QuestionFragment extends Fragment {

    private QuestionViewModel questionViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_question, container, false);
        return root;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onStart() {
        super.onStart();
        final View view = getView();
        final MainActivity activity = (MainActivity) getActivity();
        if (view != null) {
            assert activity != null;
            Button btn = view.findViewById(R.id.button_submit);
            final TextInputEditText question_1 = (TextInputEditText) view.findViewById(R.id.text_question_1);
            final TextInputEditText question_2 = (TextInputEditText) view.findViewById(R.id.text_question_2);
            final TextInputEditText question_3 = (TextInputEditText) view.findViewById(R.id.text_question_3);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String answer_1 = question_1.getText().toString();
                    String answer_2 = question_2.getText().toString();
                    String answer_3 = question_3.getText().toString();
                    activity.getMyDb().AddQuestion(answer_1,answer_2,answer_3,1);
                }
            });
        }
    }

}