package com.example.mascotaruta;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;
import static android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ConfirmacionActivity extends AppCompatActivity {

    private TextView txtNombreMasctota, txtNombrePersona, txtCategoriaConfirmacion, txtCompromisos, txtVacunas;

    private Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_confirmacion);

        txtNombrePersona = findViewById(R.id.txtNombrePersona);
        txtNombreMasctota = findViewById(R.id.txtNombreMascota);
        txtCategoriaConfirmacion = findViewById(R.id.txtCategoriaConfirmacion);
        txtCompromisos = findViewById(R.id.txtCompromisos);
        btnVolver = findViewById(R.id.btnVolver);
        txtVacunas = findViewById(R.id.txtVacunas);


        String nombrePersona = getIntent().getStringExtra(RegistrarMascotaActivity.EXTRA_NOMBREPERSONA);
        String nombreMascota = getIntent().getStringExtra(RegistrarMascotaActivity.EXTRA_NOMBREMASCOTA);
        String categoria = getIntent().getStringExtra(RegistrarMascotaActivity.EXTRA_CATEGORIA);
        String compromisos = getIntent().getStringExtra(RegistrarMascotaActivity.EXTRA_COMPROMISOS);
        String vacunas = getIntent().getStringExtra(RegistrarMascotaActivity.EXTRA_VACUNA);


        txtNombrePersona.setText("Nombre de la persona: " + nombrePersona);
        txtNombreMasctota.setText("Nombre de la Mascota: " + nombreMascota);
        txtCategoriaConfirmacion.setText("Categoria: " + categoria);
        txtCompromisos.setText("Compromisos: " + compromisos);
        txtVacunas.setText("¿Vacunas al dia?: " + vacunas);

        btnVolver.setOnClickListener(v ->{

            Intent intent = new Intent(
                    ConfirmacionActivity.this,
                    MainActivity.class
            );

            intent.addFlags(FLAG_ACTIVITY_CLEAR_TOP | FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);


        });









        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}