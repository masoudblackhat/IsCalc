package com.example.masoud.iscalc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView txt_plus, txt_minus, txt_multiplier, txt_devide, txt_delete,
            txt_equal, txt_result, txt_double_zero, txt_clear, txt_sqrt,
            txt_ce, txt_dot, txt_step, txt_power, txt_remainder;
    String Click;
    String old, New;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        txt_delete.setOnClickListener(new onDeleteClick());
        txt_dot.setOnClickListener(new ondotClick());
        txt_clear.setOnClickListener(new onClearClick());
        txt_plus.setOnClickListener(new onPlusClick());
        txt_devide.setOnClickListener(new onDevideClick() );
        txt_multiplier.setOnClickListener(new onMultiplierClick() );
        txt_minus.setOnClickListener(new onMinusClick());
        txt_power.setOnClickListener(new onPowerClick());
        txt_sqrt.setOnClickListener(new onSqrtClick());
        txt_equal.setOnClickListener(new onEqualClick());
    }

    //cast variables...
    private void init() {
        txt_result = (TextView) findViewById(R.id.txt_result);
        txt_step = (TextView) findViewById(R.id.textView25);
        txt_clear = (TextView) findViewById(R.id.txt_clear);
        txt_plus = (TextView) findViewById(R.id.txt_plus);
        txt_equal = (TextView) findViewById(R.id.txt_equal);
        txt_minus = (TextView) findViewById(R.id.txt_minus);
        txt_multiplier = (TextView) findViewById(R.id.txt_multiplier);
        txt_devide = (TextView) findViewById(R.id.txt_devide);
        txt_delete = (TextView) findViewById(R.id.txt_delete);
        txt_dot = (TextView) findViewById(R.id.txt_dot);
        txt_power = (TextView) findViewById(R.id.txt_power);
        txt_sqrt = (TextView) findViewById(R.id.txt_sqrt);
    }

    private void Method_All() {
        String oldValue = txt_result.getText().toString();
        int finDot = oldValue.indexOf(".");
        int findPlus = oldValue.indexOf("+");
        if (findPlus != -1) {
            old = oldValue.substring(0, findPlus);
            New = oldValue.substring(findPlus + 1, oldValue.length());
            if (finDot != -1) {
                float num1 = Float.parseFloat(old);
                float num2 = Float.parseFloat(New);
                txt_step.setText("" + (num1 + num2));
            } else {
                int num1 = Integer.parseInt(old);
                int num2 = Integer.parseInt(New);
                txt_step.setText("" + (num1 + num2));

            }
        }

        int findMines = oldValue.indexOf("-");
        if (findMines != -1) {
            old = oldValue.substring(0, findMines);
            New = oldValue.substring(findMines + 1, oldValue.length());
            if (finDot != -1) {
                float num1 = Float.parseFloat(old);
                float num2 = Float.parseFloat(New);
                txt_step.setText("" + (num1 - num2));
            } else {
                int num1 = Integer.parseInt(old);
                int num2 = Integer.parseInt(New);
                txt_step.setText("" + (num1 - num2));
            }
        }

        int findMultiplay = oldValue.indexOf("*");
        if (findMultiplay != -1) {
            old = oldValue.substring(0, findMultiplay);
            New = oldValue.substring(findMultiplay + 1, oldValue.length());
            if (finDot != -1) {
                float num1 = Float.parseFloat(old);
                float num2 = Float.parseFloat(New);
                txt_step.setText("" + (num1 * num2));
            } else {
                int num1 = Integer.parseInt(old);
                int num2 = Integer.parseInt(New);
                txt_step.setText("" + (num1 * num2));
            }
        }

        int findDevided = oldValue.indexOf("/");
        if (findDevided != -1) {
            old = oldValue.substring(0, findDevided);
            New = oldValue.substring(findDevided + 1, oldValue.length());
            if (finDot != -1) {
                float num1 = Float.parseFloat(old);
                float num2 = Float.parseFloat(New);
                txt_step.setText("" + (num1 / num2));
            } else {
                int num1 = Integer.parseInt(old);
                int num2 = Integer.parseInt(New);
                txt_step.setText("" + (num1 / num2));
            }
        }
    }

    public void onClick(View view) {

        int length = txt_result.length();
        if (length <= 14) {
            int getTagNum = Integer.parseInt(view.getTag().toString());
            Click = view.getTag().toString();
            appendNumerToTextView(getTagNum);
        } else {
            return;
        }
    }

    private void appendNumerToTextView(int getTagNum) {
        String oldValue = txt_result.getText().toString();
        txt_result.setText(oldValue + getTagNum);
    }

    private class onSqrtClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String show = null;
            int findDot;
            Double old = Double.parseDouble(txt_result.getText().toString());
            if (old < 0) {
                txt_result.setText("Invalid Input");
            } else {
                String txt_old = old.toString();
                if (txt_old.contains(".")) {
                    txt_step.setText("√(" + txt_old + ")");
                } else {
                    findDot = txt_old.indexOf(".");
                    String num = txt_old.substring(0, findDot);
                    txt_step.setText(num);
                }
                Double sqrt_old = Math.sqrt(old);
                String check = sqrt_old.toString();
                int length = check.length();
                if (length > 8) {
                    show = check.substring(0, 8);
                }
                //  Toast.makeText(getApplicationContext(),show, Toast.LENGTH_LONG).show();
                findDot = show.indexOf(".");
                if (Integer.parseInt(show.substring(findDot + 1, show.length())) == 0) {
                    String sahih = show.substring(0, findDot);
                    txt_result.setText(sahih);
                } else {
                    txt_result.setText(show);
                }
            }

        }
    }

    private class onDeleteClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String value = txt_result.getText().toString();
            if (!value.isEmpty()) {
                String oldValue = value.substring(0, value.length() - 1);
                txt_result.setText(oldValue);
            } else {
                return;
            }
        }
    }

    private class ondotClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String oldValue = txt_result.getText().toString();
            txt_result.setText(oldValue + ".");
        }
    }

    private class onClearClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            txt_result.setText("");
            txt_step.setText("");
        }
    }

    private class onPlusClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String oldValue = txt_result.getText().toString();
            txt_result.setText(oldValue + "+");
        }
    }

    private class onDevideClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String oldValue = txt_result.getText().toString();
            txt_result.setText(oldValue + "/");
        }
    }

    private class onMultiplierClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String oldValue = txt_result.getText().toString();
            txt_result.setText(oldValue + "*");
        }
    }

    private class onMinusClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String oldValue = txt_result.getText().toString();
            txt_result.setText(oldValue + "-");
        }
    }

    private class onPowerClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Double oldValue = Double.parseDouble(txt_result.getText().toString());
            oldValue = Math.pow(oldValue, 2);
            String check = oldValue.toString();
            int finddot = check.indexOf(".");
            if (Integer.parseInt(check.substring(finddot + 1, check.length())) == 0) {
                String sahih = check.substring(0, finddot);
                txt_result.setText(sahih);
            } else {
                txt_result.setText(check);
            }
        }
    }


    private class onEqualClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Method_All();
        }
    }
}