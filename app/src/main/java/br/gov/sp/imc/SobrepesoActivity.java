package br.gov.sp.imc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class SobrepesoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobrepeso);

        TextView txtSaudacao = findViewById(R.id.txt_saudacao);
        TextView txtImc = findViewById(R.id.txt_imc);
        Button btnVoltar = findViewById(R.id.btn_voltar);

        String nome = getIntent().getStringExtra("nome");
        double imc = getIntent().getDoubleExtra("imc", 0);

        txtSaudacao.setText("Olá, " + nome + "!");
        txtImc.setText(String.format(Locale.getDefault(), "Seu IMC é %.2f.", imc));

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
