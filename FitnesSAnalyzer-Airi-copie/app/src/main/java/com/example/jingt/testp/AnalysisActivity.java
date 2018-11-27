package com.example.jingt.testp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AnalysisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis);

        configureBackButton();
    }


    private void configureBackButton(){

        Button backToHome = (Button) findViewById(R.id.backToHome);
        backToHome.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(AnalysisActivity.this, HomeActivity.class));
            }
        });
    }
}