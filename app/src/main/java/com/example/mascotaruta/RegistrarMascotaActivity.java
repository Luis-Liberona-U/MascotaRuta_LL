package com.example.mascotaruta;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegistrarMascotaActivity extends AppCompatActivity {

    private Button btnRegistrar;
    private RadioGroup rgCategoria;
    private CheckBox cbEsterilizacion;
    private CheckBox cbSeguimiento;

    private Switch swVacunas;


    private EditText edtNombrePersona, edtNombreMascota;

    public static final String EXTRA_NOMBREPERSONA = "NOMBREPERSONA";
    public static final String EXTRA_NOMBREMASCOTA = "NOMBREMASCOTA";
    public static final String EXTRA_CATEGORIA = "CATEGORIA";
    public static final String EXTRA_COMPROMISOS = "COMPROMISOS";

    public static final String EXTRA_VACUNA = "VACUNA";






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registrar_mascota);

        btnRegistrar = findViewById(R.id.btnRegistrar);
        rgCategoria = findViewById(R.id.rgCategoria);
        cbEsterilizacion = findViewById(R.id.cbEsterilizacion);
        cbSeguimiento = findViewById(R.id.cbSeguimiento);
        edtNombrePersona = findViewById(R.id.edtNombrePersona);
        edtNombreMascota = findViewById(R.id.edtNombreMascota);
        swVacunas = findViewById(R.id.swVacunas);



        btnRegistrar.setOnClickListener(v ->{

            String nombrePersona = edtNombrePersona.getText().toString().trim();
            String nombreMascota = edtNombreMascota.getText().toString().trim();

            if (nombrePersona.isEmpty()) {
                edtNombrePersona.setError("Debes ingresar tu nombre");
                edtNombrePersona.requestFocus();
                return;
            }

            if (nombreMascota.isEmpty()) {
                edtNombreMascota.setError("Debes ingresar el nombre del animal");
                edtNombreMascota.requestFocus();
                return;
            }

            int idCategoria = rgCategoria.getCheckedRadioButtonId();

            if (idCategoria == -1) {
                Toast.makeText(RegistrarMascotaActivity.this,"Debes elegir una categoria",Toast.LENGTH_SHORT).show();
                return;

            }

            RadioButton btnSelecionado = rgCategoria.findViewById(idCategoria);

            String categoria = btnSelecionado.getText().toString();

            String compromisos = "";



            if (cbEsterilizacion.isChecked()) {
                compromisos += " Esterilizacion";
            }
            if (cbSeguimiento.isChecked()) {

                compromisos += "Seguimiento";
            }

            if (compromisos.isEmpty()) {
                Toast.makeText(RegistrarMascotaActivity.this,"Debes selecionar al menos un compromiso", Toast.LENGTH_SHORT).show();
                return;

            }

            Intent intent = new Intent(
                    RegistrarMascotaActivity.this,
                    ConfirmacionActivity.class
            );

            String vacunas = "";

            if (swVacunas.isActivated()) {
                vacunas += "Si";

            }
            else {
                vacunas += "No";
            }



            intent.putExtra(EXTRA_NOMBREPERSONA, nombrePersona);
            intent.putExtra(EXTRA_NOMBREMASCOTA, nombreMascota);
            intent.putExtra(EXTRA_CATEGORIA, categoria);
            intent.putExtra(EXTRA_COMPROMISOS, compromisos);
            intent.putExtra(EXTRA_VACUNA, vacunas);

            startActivity(intent);








        });






        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}