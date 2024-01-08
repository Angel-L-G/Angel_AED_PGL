package es.iespto.agl.dosier1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Practica23_2 extends AppCompatActivity {
    private EditText numeroEditText;
    private Button descomponerButton;
    private TextView resultadoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practica_23_two_activity);

        numeroEditText = findViewById(R.id.numeroEditText);
        descomponerButton = findViewById(R.id.descomponerButton);
        resultadoTextView = findViewById(R.id.resultadoTextView);

        descomponerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                descomponerEnPrimos();
            }
        });
    }

    private void descomponerEnPrimos() {
        String numeroStr = numeroEditText.getText().toString();
        try {
            int numero = Integer.parseInt(numeroStr);
            String resultado = obtenerFactoresPrimos(numero);
            resultadoTextView.setText(resultado);
        } catch (NumberFormatException e) {
            resultadoTextView.setText("Ingrese un número válido.");
        }
    }

    private String obtenerFactoresPrimos(int numero) {
        StringBuilder resultado = new StringBuilder();

        for (int i = 2; i <= numero; i++) {
            while (numero % i == 0) {
                resultado.append(i).append(" ");
                numero /= i;
            }
        }

        return resultado.toString().trim();
    }
}