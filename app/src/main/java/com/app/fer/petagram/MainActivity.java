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
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    private TextView nombreCompleto,telefono,email,descripcionContacto, fecha;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Confirmar Datos");
        }

        nombreCompleto = (TextView) findViewById(R.id.nombre);
        telefono = (TextView) findViewById(R.id.tel);
        email = (TextView) findViewById(R.id.mail);
        descripcionContacto = (TextView) findViewById(R.id.desc);
        fecha = (TextView) findViewById(R.id.fecha_nacimiento);
        button = (Button) findViewById(R.id.button2);

        Bundle extras = getIntent().getExtras();

        if(extras != null){
            nombreCompleto.setText(extras.getString("nombreCompleto"));
            telefono.setText(extras.getString("telefono"));
            email.setText(extras.getString("email"));
            descripcionContacto.setText(extras.getString("descripcionContacto"));
            fecha.setText(extras.getString("datePicker"));
        }else{
            nombreCompleto.setText("Fernando Gálvez Castillo");
            telefono.setText("5525365220");
            email.setText("cirith_gorgor666@hotmail.com");
            descripcionContacto.setText("Ejemplo del curso de aplicaciones de android");
            fecha.setText("1956/05/02");
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, DetalleActivity.class);
                in.putExtra("nombreCompleto", nombreCompleto.getText().toString());
                in.putExtra("telefono", telefono.getText().toString());
                in.putExtra("email", email.getText().toString());
                in.putExtra("descripcionContacto", descripcionContacto.getText().toString());
                in.putExtra("datePicker", fecha.getText().toString());
                in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(in);
                finish();
            }
        });
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