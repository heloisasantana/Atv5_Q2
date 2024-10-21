package com.example.atv5_q2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

/*
 *@author:Heloísa Santana da Silva
 */

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerTipoDado;
    private RadioGroup radioGroupQuantidadeDados;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerTipoDado = findViewById(R.id.spinnerTipoDado);
        radioGroupQuantidadeDados = findViewById(R.id.radioGroupQuantidadeDados);
        Button buttonJogar = findViewById(R.id.buttonJogar);
        textViewResultado = findViewById(R.id.textViewResultado);

        buttonJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jogarDados();
            }
        });
    }

    private void jogarDados() {
        String tipoDado = spinnerTipoDado.getSelectedItem().toString();
        int numFaces = Integer.parseInt(tipoDado.substring(1));

        int quantidadeDados = 1;
        int radioIdSelecionado = radioGroupQuantidadeDados.getCheckedRadioButtonId();
        if (radioIdSelecionado != -1) {
            RadioButton radioButtonSelecionado = findViewById(radioIdSelecionado);
            quantidadeDados = Integer.parseInt(radioButtonSelecionado.getText().toString());
        }

        Random random = new Random();
        StringBuilder resultado = new StringBuilder("Resultado:\n");
        for (int i = 1; i <= quantidadeDados; i++) {
            int valor = random.nextInt(numFaces) + 1;
            resultado.append("Dado ").append(i).append(": ").append(valor).append("\n");
        }

        textViewResultado.setText(resultado.toString());
    }
}