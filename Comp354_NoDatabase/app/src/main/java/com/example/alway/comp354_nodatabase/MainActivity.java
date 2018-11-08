package com.example.alway.comp354_nodatabase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //private static final String FILE_NAME =

    Button bLogin;
    EditText etUsername, etPassword;
    TextView registerLink;
    Register register;
    //String FILE ;
    EditText tempUsername;
    EditText tempPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = (EditText) findViewById(R.id.etUsername);

        etPassword = (EditText) findViewById(R.id.etPassword);

        bLogin  = (Button) findViewById(R.id.bLogin);

        registerLink = (TextView) findViewById(R.id.tvRegisterHere);

        registerLink.setOnClickListener(this);

        bLogin.setOnClickListener(this);

      //  FILE = register.getFile();

        //Bundle bu;
        //bu = getIntent().getExtras();
        //tempUsername.setText(bu.getString("tempUsername"));
        //tempPassword.setText(bu.getString("tempPassword"));


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.tvRegisterHere:

                Intent registerIntent = new Intent(MainActivity.this, Register.class);
                MainActivity.this.startActivity(registerIntent);

                break;

            case R.id.bLogin:

                boolean match = false;
                //String tempUsername;
                //String tempPassword;

               // BufferedReader br = null;
                //File file = new File(FILE);

                    //FileInputStream fin = openFileInput(FILE);
                    //br = new BufferedReader(new FileReader(file));
                   //tempUsername = br.readLine();
                   //tempPassword = br.readLine();

                    if(etUsername.getText().toString() == tempUsername.getText().toString() && etPassword.getText().toString()==tempPassword.getText().toString())
                   {
                       Toast.makeText(this, "login Successful", Toast.LENGTH_LONG).show();

                       match = true;
                   }

                if(match == true){
                    Intent intent = new Intent (MainActivity.this, ConnectToEndomondo.class);
                    MainActivity.this.startActivity(intent);
                }else{
                    Toast.makeText(this, "no account exists", Toast.LENGTH_LONG).show();
                }

                break;

                }
                }



        }



