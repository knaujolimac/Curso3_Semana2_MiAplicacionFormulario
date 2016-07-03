package com.knaujolimac.miformulario;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarDatosContacto extends AppCompatActivity {

    private TextView tvNombreContacto ;
    private TextView tvFechaNaContacto;
    private TextView tvTelefonoContacto;
    private TextView tvEmailContacto;
    private TextView tvDescContacto;
    private Button btnEditarDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos_contacto);

        Bundle parametros = getIntent().getExtras();
        //Se obtienen los valores ingresados por el usuario
        String nombre = parametros.getString(getResources().getString(R.string.param_nombre));
        String fechaNacimiento= parametros.getString(getResources().getString(R.string.param_fechaNa));
        String telefono = parametros.getString(getResources().getString(R.string.param_telefono));
        String email = parametros.getString(getResources().getString(R.string.param_email));
        String descripcion= parametros.getString(getResources().getString(R.string.param_descripcion));

        //Se setean los valores ingresados por el usuario
        tvNombreContacto = (TextView) findViewById(R.id.tvNombreContacto);
        tvFechaNaContacto = (TextView) findViewById(R.id.tvFechaNaContacto);
        tvTelefonoContacto = (TextView) findViewById(R.id.tvTelefonoContacto);
        tvEmailContacto = (TextView) findViewById(R.id.tvEmailContacto);
        tvDescContacto = (TextView) findViewById(R.id.tvDescContacto);

        tvNombreContacto.setText(nombre);
        tvFechaNaContacto.setText(fechaNacimiento);
        tvTelefonoContacto.setText(telefono);
        tvEmailContacto.setText(email);
        tvDescContacto.setText(descripcion);


        btnEditarDatos = (Button)findViewById(R.id.btnEditarDatos);
        btnEditarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Se obtienen los valores de los campos
                tvNombreContacto = (TextView) findViewById(R.id.tvNombreContacto);
                tvFechaNaContacto = (TextView) findViewById(R.id.tvFechaNaContacto);
                tvTelefonoContacto = (TextView) findViewById(R.id.tvTelefonoContacto);
                tvEmailContacto = (TextView) findViewById(R.id.tvEmailContacto);
                tvDescContacto = (TextView) findViewById(R.id.tvDescContacto);

                Intent intent = new Intent(ConfirmarDatosContacto.this,MainActivity.class);
                //Se pasan los datos ingresados en el formulario para edición
                intent.putExtra(getResources().getString(R.string.param_nombre),tvNombreContacto.getText().toString());
                intent.putExtra(getResources().getString(R.string.param_fechaNa),tvFechaNaContacto.getText().toString());
                intent.putExtra(getResources().getString(R.string.param_telefono),tvTelefonoContacto.getText().toString());
                intent.putExtra(getResources().getString(R.string.param_email),tvEmailContacto.getText().toString());
                intent.putExtra(getResources().getString(R.string.param_descripcion),tvDescContacto.getText().toString());

                startActivity(intent);
                //se finaliza el activity para optimizar la memoria
                finish();
            }
        });


    }
}
