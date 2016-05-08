package com.app.fer.petagram;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class DetalleActivity extends ActionBarActivity {

    private EditText nombreCompleto,telefono,email,descripcionContacto;
    private DatePicker datePicker;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nombreCompleto = (EditText) findViewById(R.id.nombreCompleto);
        telefono = (EditText) findViewById(R.id.telefono);
        email = (EditText) findViewById(R.id.email);
        descripcionContacto = (EditText) findViewById(R.id.descripcionContacto);
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        button = (Button) findViewById(R.id.button);
        telefono = (EditText) findViewById(R.id.telefono);
        email = (EditText) findViewById(R.id.email);

        Bundle extras = getIntent().getExtras();

        if(extras != null){
            nombreCompleto.setText(extras.getString("nombreCompleto"));
            telefono.setText(extras.getString("telefono"));
            email.setText(extras.getString("email"));
            descripcionContacto.setText(extras.getString("descripcionContacto"));
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nombreCompleto.getText().toString().equals("")){
                    nombreCompleto.setError("Campo Obligatorio");
                }else if(telefono.getText().toString().equals("")){
                    telefono.setError("Campo Obligatorio");
                }else if(email.getText().toString().equals("")){
                    email.setError("Campo Obligatorio");
                }else if(descripcionContacto.getText().toString().equals("")){
                    descripcionContacto.setError("Campo Obligatorio");
                }else{
                    Intent in = new Intent(DetalleActivity.this, MainActivity.class);
                    in.putExtra("nombreCompleto",nombreCompleto.getText().toString());
                    in.putExtra("telefono",telefono.getText().toString());
                    in.putExtra("email",email.getText().toString());
                    in.putExtra("descripcionContacto",descripcionContacto.getText().toString());
                    in.putExtra("datePicker",datePicker.getYear()+"/"+datePicker.getMonth()+"/"+datePicker.getDayOfMonth());
                    in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(in);
                    finish();
                }
            }
        });

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Datos Personales");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }




}
