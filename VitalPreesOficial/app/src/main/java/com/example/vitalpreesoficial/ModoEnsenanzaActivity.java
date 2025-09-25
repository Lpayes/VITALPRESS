package com.example.vitalpreesoficial;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ModoEnsenanzaActivity extends AppCompatActivity {

    private TextView txtContenidoEnsenanza;
    private EditText editRespuestaUsuario;
    private ScrollView scrollContenido;
    private int leccionActual = 0;
    private String[] lecciones = {
        "LECCIÓN 1: ¿Qué es la presión arterial?\n\nLa presión arterial es la fuerza que ejerce la sangre contra las paredes de las arterias cuando el corazón bombea.\n\nSe mide en dos números:\n• Sistólica (mayor): presión cuando el corazón late\n• Diastólica (menor): presión cuando el corazón descansa\n\nPREGUNTA: ¿Cuál consideras que es una presión arterial normal? Escribe tu respuesta.",

        "LECCIÓN 2: Factores de riesgo cardiovascular\n\nFactores que NO puedes controlar:\n• Edad\n• Sexo\n• Genética familiar\n\nFactores que SÍ puedes controlar:\n• Dieta\n• Ejercicio\n• Tabaquismo\n• Estrés\n• Peso corporal\n\nPREGUNTA: Menciona 3 hábitos saludables que puedes adoptar para mejorar tu salud cardiovascular.",

        "LECCIÓN 3: Interpretando los valores de presión arterial\n\n• Normal: Menos de 120/80 mmHg\n• Elevada: 120-129 sistólica y menos de 80 diastólica\n• Etapa 1: 130-139/80-89 mmHg\n• Etapa 2: 140/90 mmHg o mayor\n• Crisis: Mayor a 180/120 mmHg\n\nPREGUNTA: Si una persona tiene 135/85 mmHg, ¿en qué categoría estaría?",

        "LECCIÓN 4: Usando VitalPress efectivamente\n\nPara obtener mejores resultados:\n• Mide tu presión a la misma hora\n• Descansa 5 minutos antes de medir\n• Registra todos los valores en la app\n• Revisa las recomendaciones regularmente\n• Comparte los reportes con tu médico\n\nPREGUNTA: ¿Por qué es importante medir la presión arterial a la misma hora cada día?"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modo_ensenanza);

        // Referencias
        txtContenidoEnsenanza = findViewById(R.id.txt_contenido_ensenanza);
        editRespuestaUsuario = findViewById(R.id.edit_respuesta_usuario);
        scrollContenido = findViewById(R.id.scroll_contenido_ensenanza);

        // Botón Siguiente Lección
        Button btnSiguiente = findViewById(R.id.btn_siguiente_leccion);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (leccionActual < lecciones.length - 1) {
                    leccionActual++;
                    mostrarLeccion();
                } else {
                    // Mostrar mensaje de finalización
                    txtContenidoEnsenanza.setText("¡Felicitaciones! 🎉\n\nHas completado todas las lecciones del Modo Enseñanza de VitalPress.\n\nAhora tienes conocimientos básicos sobre:\n• Presión arterial\n• Factores de riesgo\n• Interpretación de valores\n• Uso efectivo de la aplicación\n\n¡Sigue cuidando tu salud cardiovascular!");
                }
                editRespuestaUsuario.setText("");
                scrollToTop();
            }
        });

        // Botón Lección Anterior
        Button btnAnterior = findViewById(R.id.btn_leccion_anterior);
        btnAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (leccionActual > 0) {
                    leccionActual--;
                    mostrarLeccion();
                    editRespuestaUsuario.setText("");
                    scrollToTop();
                }
            }
        });

        // Botón Reiniciar Curso
        Button btnReiniciar = findViewById(R.id.btn_reiniciar_curso);
        btnReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leccionActual = 0;
                mostrarLeccion();
                editRespuestaUsuario.setText("");
                scrollToTop();
            }
        });

        // Botón Regresar
        Button btnRegresar = findViewById(R.id.btn_regresar_ensenanza);
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Mostrar primera lección
        mostrarLeccion();
    }

    private void mostrarLeccion() {
        if (leccionActual < lecciones.length) {
            txtContenidoEnsenanza.setText(lecciones[leccionActual]);
        }
    }

    private void scrollToTop() {
        scrollContenido.post(new Runnable() {
            @Override
            public void run() {
                scrollContenido.scrollTo(0, 0);
            }
        });
    }
}
