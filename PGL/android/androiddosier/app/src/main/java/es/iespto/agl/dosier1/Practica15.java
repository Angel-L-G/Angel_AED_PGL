package es.iespto.agl.dosier1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Practica15 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practica_15_16_17_18_activity);
        Button btn = (Button)findViewById(R.id.btnCalculate);
        btn.setOnClickListener(
                view -> {
                    calcular();
                }
        );

        Button btn1 = (Button)findViewById(R.id.btnLimpiar);
        btn1.setOnClickListener(
                view -> {
                    limpiar();
                }
        );

        Button btn2 = (Button)findViewById(R.id.btnLongClick);
        btn2.setOnLongClickListener(
                view -> {
                    Toast t = Toast.makeText(
                            this,
                            "AAAAAA",
                            Toast.LENGTH_LONG
                    );
                    t.show();
                    return true;
                }
        );
    }

    private void limpiar(){
        EditText input1 = findViewById(R.id.inputNum1_15);
        EditText input2 = findViewById(R.id.inputNum2_15);

        input1.setText("");
        input2.setText("");
    }

    private void calcular(){
        TextView txtResults = findViewById(R.id.txtResults15);

        EditText input1 = findViewById(R.id.inputNum1_15);
        EditText input2 = findViewById(R.id.inputNum2_15);

        int num1 = Integer.parseInt(input1.getText().toString());
        int num2 = Integer.parseInt(input2.getText().toString());

        int res = num1+num2;

        txtResults.setText(res+"");
    }

}
