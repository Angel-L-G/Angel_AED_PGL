package es.iespto.agl.dosier1;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Practica42 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practica_42_activity);

        //REVISAR
        File file = new File(getApplicationContext().getFilesDir(), "personas.csv");
        try(
           BufferedWriter bw = Files.newBufferedWriter(file.toPath());
        ){
            List<String> listaEscribir = Arrays.asList(
                    "ana; pérez; 27",
                    "lidia; Hernandez; 21",
                    "Rigoberto; Afonso; 37"
            );

            for (String linea: listaEscribir) {
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try(
                BufferedReader br = Files.newBufferedReader(file.toPath());
           ){
            List<String> listaLeida = br.lines().collect(Collectors.toList());
            listaLeida.forEach(linea -> Log.d("Linea: ", linea));

            TextView txtResults = findViewById(R.id.txtResults42);
            txtResults.setText(listaLeida.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
