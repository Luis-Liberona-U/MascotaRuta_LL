package com.example.mascotaruta;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btnConfirmar;
    private RadioGroup rgPerfil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnConfirmar = findViewById(R.id.btnConfirmar);
        rgPerfil = findViewById(R.id.rgPerfil);

        btnConfirmar.setOnClickListener(v ->{


            int idSelecionado = rgPerfil.getCheckedRadioButtonId();


            if (idSelecionado == -1) {
                Toast.makeText(MainActivity.this,"Debes selecionar un perfil",Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(
                    MainActivity.this,
                    RegistrarMascotaActivity.class
            );

            startActivity(intent);






        });






        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}