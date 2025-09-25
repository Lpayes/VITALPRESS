package com.example.vitalpreesoficial;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ModoAprendizajeActivity extends AppCompatActivity {

    private TextView txtRespuestaIA;
    private EditText editPregunta;
    private ScrollView scrollRespuestas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modo_aprendizaje);

        // Referencias
        txtRespuestaIA = findViewById(R.id.txt_respuesta_ia);
        editPregunta = findViewById(R.id.edit_pregunta);
        scrollRespuestas = findViewById(R.id.scroll_respuestas);

        // Botón Enviar Pregunta
        Button btnEnviar = findViewById(R.id.btn_enviar_pregunta);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pregunta = editPregunta.getText().toString().trim();
                if (!pregunta.isEmpty()) {
                    procesarPregunta(pregunta);
                    editPregunta.setText("");
                }
            }
        });

        // Botón Limpiar Chat
        Button btnLimpiar = findViewById(R.id.btn_limpiar_chat);
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtRespuestaIA.setText("Bienvenido al Modo Aprendizaje de VitalPress IA.\n\nHaz una pregunta sobre salud cardiovascular, presión arterial o el uso de la aplicación.");
                scrollRespuestas.scrollTo(0, 0);
            }
        });

        // Botón Regresar
        Button btnRegresar = findViewById(R.id.btn_regresar_aprendizaje);
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Inicializar mensaje de bienvenida
        txtRespuestaIA.setText("Bienvenido al Modo Aprendizaje de VitalPress IA.\n\nHaz una pregunta sobre salud cardiovascular, presión arterial o el uso de la aplicación.");
    }

    private void procesarPregunta(String pregunta) {
        // Esta es una simulación de respuestas de IA
        // En una implementación real, aquí iría la conexión con el servicio de IA

        String respuesta = generarRespuestaSimulada(pregunta.toLowerCase());

        // Agregar pregunta y respuesta al chat
        String chatActual = txtRespuestaIA.getText().toString();
        String nuevoTexto = chatActual + "\n\n👤 PREGUNTA: " + pregunta +
                           "\n\n🤖 IA: " + respuesta;

        txtRespuestaIA.setText(nuevoTexto);

        // Scroll automático hacia abajo
        scrollRespuestas.post(new Runnable() {
            @Override
            public void run() {
                scrollRespuestas.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });
    }

    private String generarRespuestaSimulada(String pregunta) {
        if (pregunta.contains("presión") || pregunta.contains("arterial")) {
            return "La presión arterial normal está entre 120/80 mmHg. Es importante monitorearla regularmente y mantener hábitos saludables como ejercicio regular y una dieta balanceada.";
        } else if (pregunta.contains("corazón") || pregunta.contains("cardiovascular")) {
            return "Para mantener un corazón saludable: haz ejercicio regularmente, mantén una dieta rica en frutas y verduras, evita el tabaco, controla el estrés y monitorea tu presión arterial.";
        } else if (pregunta.contains("app") || pregunta.contains("aplicación") || pregunta.contains("vitalpress")) {
            return "VitalPress te ayuda a monitorear tu salud cardiovascular. Puedes registrar tus datos, recibir recomendaciones, configurar recordatorios y exportar informes para tu médico.";
        } else if (pregunta.contains("imc")) {
            return "El IMC (Índice de Masa Corporal) se calcula dividiendo tu peso en kg entre tu altura en metros al cuadrado. Un IMC normal está entre 18.5 y 24.9.";
        } else {
            return "Gracias por tu pregunta. Te recomiendo consultar con un profesional de la salud para obtener información médica específica. ¿Hay algo más sobre VitalPress en lo que pueda ayudarte?";
        }
    }
}
