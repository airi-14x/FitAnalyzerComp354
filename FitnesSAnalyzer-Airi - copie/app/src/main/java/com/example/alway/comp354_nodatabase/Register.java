package com.example.alway.comp354_nodatabase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Register extends AppCompatActivity {

   private  final String FILE_NAME = "localFile.txt";

    Button bRegister;
    EditText etUsername, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etUsername  = (EditText) findViewById(R.id.etUsername);
        etPassword  = (EditText) findViewById(R.id.etPassword);

        bRegister = (Button) findViewById(R.id.bRegister);

    }


    public void Register(View v) {

            String textUsername = etUsername.getText().toString();
            String textPassword = etPassword.getText().toString();

            String newLine = "\n";

            // FileOutputStream fos = null;
            //OutputStreamWriter fosWriter = new OutputStreamWriter(fos);

        FileOutputStream fosWriter = null;

        try {
            fosWriter = openFileOutput(FILE_NAME, MODE_PRIVATE);
            try {
                fosWriter.write(textUsername.getBytes());
                //fosWriter.append("\r\n");
                fosWriter.write(newLine.getBytes());
                fosWriter.write(textPassword.getBytes());

            } catch (IOException e) {
                e.printStackTrace();
            }

            etUsername.getText().clear();
            Toast.makeText(this, "Saved to " + getFilesDir() + "/" + FILE_NAME,
                    Toast.LENGTH_LONG).show();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (fosWriter != null) {
                try {
                   fosWriter.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        Intent intent = new Intent (Register.this, ConnectToEndomondo.class);
       // intent.putExtra("tempUsername",textUsername );
        //intent.putExtra("tempPassword", textPassword);

        Register.this.startActivity(intent);
    }


    public String getFile(){
        return FILE_NAME;
    }

    public EditText getEtUsername(){
        return etUsername;
    }

    public EditText getEtPassword() {
        return etPassword;
    }
    }



