package com.example.vitalpreesoficial;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SeccionDatosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seccion_datos);

        // Botón Exportar PDF
        Button btnExportarPDF = findViewById(R.id.btn_exportar_pdf);
        btnExportarPDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para exportar PDF
            }
        });

        // Botón Importar Archivo
        Button btnImportarArchivo = findViewById(R.id.btn_importar_archivo);
        btnImportarArchivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para importar archivo
            }
        });

        // Botón Enviar Info al Correo
        Button btnEnviarCorreo = findViewById(R.id.btn_enviar_correo);
        btnEnviarCorreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para enviar por correo
            }
        });

        // Botón Pendiente
        Button btnPendiente = findViewById(R.id.btn_pendiente_datos);
        btnPendiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SeccionDatosActivity.this, PendienteActivity.class);
                startActivity(intent);
            }
        });

        // Botón Recomendaciones
        Button btnRecomendaciones = findViewById(R.id.btn_recomendaciones_datos);
        btnRecomendaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SeccionDatosActivity.this, RecomendacionesActivity.class);
                startActivity(intent);
            }
        });

        // Botón Regresar
        Button btnRegresar = findViewById(R.id.btn_regresar_datos);
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
