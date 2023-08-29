package com.example.calculator; // Make sure this matches your package name

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private final StringBuilder input = new StringBuilder();
    private double operand1 = Double.NaN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
    }

    public void onButtonClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();

        switch (buttonText) {
            case "=":
                calculate();
                break;
            case "C":
                clear();
                break;
            default:
                input.append(buttonText);
                textView.setText(input.toString());
                break;
        }
    }

    private void calculate() {
        try {
            double operand2 = Double.parseDouble(input.toString());

            String operator = "";
            switch (operator) {
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
                        textView.setText("Error");
                        input.setLength(0);
                        return;
                    }
                    break;
                default:
                    break;
            }

            textView.setText(String.valueOf(operand1));
            input.setLength(0);
            operand1 = Double.NaN; // Reset for the next calculation

        } catch (Exception e) {
            textView.setText("Error");
            input.setLength(0);
        }
    }

    private void clear() {
        input.setLength(0);
        textView.setText("");
        operand1 = Double.NaN;
    }
}