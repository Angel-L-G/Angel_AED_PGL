package es.iespto.agl.dosier1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Practica20 extends AppCompatActivity {

    private TextView txtResults;
    private double operand1 = Double.NaN;
    private String pendingOperation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practica_08_activity);

        txtResults = findViewById(R.id.txtResults20);
    }

    public void onDigitClick(View view) {
        Button button = (Button) view;
        String digit = button.getText().toString();
        String currentText = txtResults.getText().toString();

        if ("0".equals(currentText)) {
            txtResults.setText(digit);
        } else {
            txtResults.append(digit);
        }
    }

    public void onOperationClick(View view) {
        Button button = (Button) view;
        String operation = button.getText().toString();

        if (!Double.isNaN(operand1)) {
            calculate();
            pendingOperation = operation;
            txtResults.setText(String.valueOf(operand1));
        } else {
            operand1 = Double.parseDouble(txtResults.getText().toString());
            pendingOperation = operation;
            txtResults.setText("");
        }
    }

    public void onEqualClick(View view) {
        calculate();
        pendingOperation = "";
        operand1 = Double.NaN;
    }

    public void onClearClick(View view){
        txtResults.setText("");
        operand1 = 0;
        pendingOperation = "";
    }

    private void calculate() {
        double operand2 = Double.parseDouble(txtResults.getText().toString());

        switch (pendingOperation) {
            case "+":
                operand1 += operand2;
                break;
            case "-":
                operand1 -= operand2;
                break;
            case "*":
                operand1 *= operand2;
                break;
            case "/":
                if (operand2 != 0) {
                    operand1 /= operand2;
                } else {
                    txtResults.setText("Error");
                    operand1 = Double.NaN;
                    return;
                }
                break;
            default:
                operand1 = operand2;
                break;
        }

        txtResults.setText(String.valueOf(operand1));
    }
}
