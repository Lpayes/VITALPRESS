package com.example.vitalpreesoficial;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActualizarDatosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_datos);

        // Botón Actualizar
        Button btnActualizar = findViewById(R.id.btn_actualizar);
        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para actualizar datos
                // Por ahora solo simula la actualización
            }
        });

        // Botón Regresar
        Button btnRegresar = findViewById(R.id.btn_regresar_actualizar);
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Cálculo automático del IMC al actualizar datos
        EditText editPeso = findViewById(R.id.edit_peso_actualizar);
        EditText editEstatura = findViewById(R.id.edit_estatura_actualizar);
        TextView txtIMC = findViewById(R.id.txt_imc_actualizar);

        View.OnFocusChangeListener imcCalculator = new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    calcularIMC(editPeso, editEstatura, txtIMC);
                }
            }
        };

        editPeso.setOnFocusChangeListener(imcCalculator);
        editEstatura.setOnFocusChangeListener(imcCalculator);
    }

    private void calcularIMC(EditText editPeso, EditText editEstatura, TextView txtIMC) {
        try {
            String pesoStr = editPeso.getText().toString();
            String estaturaStr = editEstatura.getText().toString();

            if (!pesoStr.isEmpty() && !estaturaStr.isEmpty()) {
                double peso = Double.parseDouble(pesoStr);
                double estatura = Double.parseDouble(estaturaStr);

                if (estatura > 0) {
                    double imc = peso / (estatura * estatura);
                    txtIMC.setText(String.format("%.2f", imc));
                }
            }
        } catch (NumberFormatException e) {
            // Error en el formato de números
        }
    }
}
