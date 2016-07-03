package com.knaujolimac.miformulario;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private SimpleDateFormat formatoFecha;
    private TextInputEditText tieNombre;
    private TextInputEditText tieFechaNacimiento;
    private TextInputEditText tieTelefono;
    private TextInputEditText tieEmail;
    private TextInputEditText tieDescripcion;
    private Button btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        formatoFecha = new SimpleDateFormat("dd-MM-yyyy");


        Calendar calendar = Calendar.getInstance();
        final int anio = calendar.get(Calendar.YEAR);
        final int mes= calendar.get(Calendar.MONTH);
        final int dia = calendar.get(Calendar.DAY_OF_MONTH);

        tieNombre= (TextInputEditText) findViewById(R.id.tieNombre);
        tieFechaNacimiento = (TextInputEditText) findViewById(R.id.tieFechaNacimiento);
        tieTelefono = (TextInputEditText) findViewById(R.id.tieTelefono);
        tieEmail = (TextInputEditText) findViewById(R.id.tieEmail);
        tieDescripcion = (TextInputEditText) findViewById(R.id.tieDescripcion);

        tieFechaNacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePiccker = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        Calendar fechaCalendar = Calendar.getInstance();
                        fechaCalendar.set(year, monthOfYear, dayOfMonth);
                        tieFechaNacimiento.setText(formatoFecha.format(fechaCalendar.getTime()));
                    }
                },anio,mes,dia);
                datePiccker.show();
            }

        });

        Bundle parametros = getIntent().getExtras();
        //Si existen parametros
        if(parametros !=null && !parametros.isEmpty()){
            //Se actualizan los valores en el formulario
            String nombre = parametros.getString(getResources().getString(R.string.param_nombre));
            String fechaNacimiento= parametros.getString(getResources().getString(R.string.param_fechaNa));
            String telefono = parametros.getString(getResources().getString(R.string.param_telefono));
            String email = parametros.getString(getResources().getString(R.string.param_email));
            String descripcion= parametros.getString(getResources().getString(R.string.param_descripcion));

            tieNombre.setText(nombre);
            tieFechaNacimiento.setText(fechaNacimiento);
            tieTelefono.setText(telefono);
            tieEmail.setText(email);
            tieDescripcion.setText(descripcion);
        }


        btnSiguiente = (Button)findViewById(R.id.btnSiguiente);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,ConfirmarDatosContacto.class);
                //Se pasan los datos ingresados en el formulario
                intent.putExtra(getResources().getString(R.string.param_nombre),tieNombre.getText().toString());
                intent.putExtra(getResources().getString(R.string.param_fechaNa),tieFechaNacimiento.getText().toString());
                intent.putExtra(getResources().getString(R.string.param_telefono),tieTelefono.getText().toString());
                intent.putExtra(getResources().getString(R.string.param_email),tieEmail.getText().toString());
                intent.putExtra(getResources().getString(R.string.param_descripcion),tieDescripcion.getText().toString());

                startActivity(intent);
                //se finaliza el activity para optimizar la memoria
                finish();

            }
        });


    }
}
