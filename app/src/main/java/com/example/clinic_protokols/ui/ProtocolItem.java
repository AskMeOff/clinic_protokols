package com.example.clinic_protokols.ui;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.clinic_protokols.R;

public class ProtocolItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_protocol_item);
        String classifierName = getIntent().getStringExtra("classifier_name");
        String classifierInfo = getIntent().getStringExtra("classifier_info");

        TextView textView = findViewById(R.id.text_view_classifier_name);
        textView.setText(classifierInfo);
        setTitle(classifierName);
    }
}