package br.gov.sp.imc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editNome;
    private EditText editPeso;
    private EditText editAltura;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNome = findViewById(R.id.edit_nome);
        editPeso = findViewById(R.id.edit_peso);
        editAltura = findViewById(R.id.edit_altura);
        btnCalcular = findViewById(R.id.btn_calcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularIMC();
            }
        });
    }

    private void calcularIMC() {
        String nome = editNome.getText().toString().trim();
        String pesoStr = editPeso.getText().toString().trim();
        String alturaStr = editAltura.getText().toString().trim();

        if (nome.isEmpty() || pesoStr.isEmpty() || alturaStr.isEmpty()) {
            Toast.makeText(this, R.string.erro_campos_vazios, Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double peso = Double.parseDouble(pesoStr.replace(",", "."));
            double altura = Double.parseDouble(alturaStr.replace(",", "."));

            if (peso <= 0 || altura <= 0) {
                Toast.makeText(this, R.string.erro_valores_invalidos, Toast.LENGTH_SHORT).show();
                return;
            }

            double imc = peso / (altura * altura);

            abrirActivityResultado(nome, imc);

        } catch (NumberFormatException e) {
            Toast.makeText(this, R.string.erro_valores_invalidos, Toast.LENGTH_SHORT).show();
        }
    }

    private void abrirActivityResultado(String nome, double imc) {
        Intent intent;

        if (imc < 18.5) {
            intent = new Intent(this, AbaixoDoPesoActivity.class);
        } else if (imc <= 24.9) {
            intent = new Intent(this, PesoNormalActivity.class);
        } else if (imc <= 29.9) {
            intent = new Intent(this, SobrepesoActivity.class);
        } else if (imc <= 34.9) {
            intent = new Intent(this, ObesidadeGrau1Activity.class);
        } else if (imc <= 39.9) {
            intent = new Intent(this, ObesidadeGrau2Activity.class);
        } else {
            intent = new Intent(this, ObesidadeGrau3Activity.class);
        }

        intent.putExtra("nome", nome);
        intent.putExtra("imc", imc);
        startActivity(intent);
    }
}
