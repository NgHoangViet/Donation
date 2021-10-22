package com.example.donation.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.donation.R;

public class MainActivity extends AppCompatActivity {
    private NumberPicker numberPicker;
    private Button button;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private ProgressBar progressBar;
    private EditText editTextAmount;
    private TextView textViewTotalDonated;

    private int totalDonated = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        numberPicker.setMaxValue(1000);
        numberPicker.setMinValue(0);
        numberPicker.setValue(0);

        progressBar.setMax(10000);

        textViewTotalDonated.setText("$0");
        radioButton.setChecked(true);
        ButtonPressed();
    }

    public void ButtonPressed() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int amount = numberPicker.getValue();
                int radioId = radioGroup.getCheckedRadioButtonId();
                String method = "";
                if (radioId == R.id.PayPal)
                {
                    method = "PayPal";
                }
                else
                {
                    method = "Direct";
                }
                totalDonated += numberPicker.getValue();
                textViewTotalDonated.setText(totalDonated + "$");
                progressBar.setProgress(totalDonated);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_donate, menu);
        return true;
    }

    public void settings(MenuItem item) {
        Toast.makeText(MainActivity.this, "Setting Selected", Toast.LENGTH_SHORT).show();
    }
    public void report(MenuItem item) {
        Toast.makeText(MainActivity.this, "Report Selected", Toast.LENGTH_SHORT).show();
    }

    private void AnhXa() {
        editTextAmount = (EditText) findViewById(R.id.editText);
        textViewTotalDonated = (TextView) findViewById(R.id.textTotal);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        radioButton = (RadioButton) findViewById(R.id.PayPal);
        numberPicker = (NumberPicker) findViewById(R.id.amountPicker);
        button = (Button) findViewById(R.id.donateButton);
        radioGroup = (RadioGroup) findViewById(R.id.paymentMethod);

    }


}