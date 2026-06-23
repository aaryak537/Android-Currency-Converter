package com.example.convertcurrency;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Spinner sp1,sp2;
    EditText amt;
    TextView tvShow;
    Button btn1;
    String[] country={"USD-United Dollar","INR-Indian Rupee","EUR-Euro","KRW-South Korean Won","JPY-Japanese Yen"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        sp1 = findViewById(R.id.spFrom);
        sp2 = findViewById(R.id.spTo);
        amt = findViewById(R.id.etAmount);
        tvShow = findViewById(R.id.tvResult);
        btn1 = findViewById(R.id.btnConvert);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,
                country);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(adapter);
        sp2.setAdapter(adapter);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amountText = amt.getText().toString();
                if (amountText.isEmpty()) {
                    tvShow.setText("Enter number first");
                    return;
                }
                double amount = Double.parseDouble(amountText);
                String start = sp1.getSelectedItem().toString();
                String end = sp2.getSelectedItem().toString();

                double result = Conversion(amount, start, end);
                tvShow.setText(" " + result);
            }
        });
    }
        private double Conversion(double amount,String sp1,String sp2){

            if(sp1.equals(sp2)) {
                return amount;
            }
            else if(sp1.equals("USD-United Dollar")&&sp2.equals("INR-Indian Rupee")) {
                return amount * 94.40;
            }
            else if(sp1.equals("USD-United Dollar")&&sp2.equals("KRW-South Korean Won")) {
                return amount * 1537.37;
            }
            else if(sp1.equals("USD-United Dollar")&&sp2.equals("EUR-Euro")) {
                return amount * 0.87;
            }
            else if(sp1.equals("USD-United Dollar")&&sp2.equals("JPY-Japanese Yen")) {
                return amount * 161.69;
            }

            else if(sp1.equals("INR-Indian Rupee")&&sp2.equals("USD-United Dollar")) {
                return amount * 0.011;
            }
            else if(sp1.equals("INR-Indian Rupee")&&sp2.equals("KRW-South Korean Won")) {
                return amount * 16.24;
            }
            else if(sp1.equals("INR-Indian Rupee")&&sp2.equals("EUR-Euro")) {
                return amount * 0.0092;
            }
            else if(sp1.equals("INR-Indian Rupee")&&sp2.equals("JPY-Japanese Yen")) {
                return amount * 1.71;
            }

            else if(sp1.equals("KRW-South Korean Won")&&sp2.equals("USD-United Dollar")){
                return amount * 0.00065;
            }
            else if(sp1.equals("KRW-South Korean Won")&&sp2.equals("INR-Indian Rupee")){
                return amount * 0.062;
            }
            else if(sp1.equals("KRW-South Korean Won")&&sp2.equals("EUR-Euro")){
                return amount * 0.00057;
            }
            else if(sp1.equals("KRW-South Korean Won")&&sp2.equals("JPY-Japanese Yen")){
                return amount * 0.11;
            }

            else if(sp1.equals("EUR-Euro")&&sp2.equals("USD-United Dollar")){
                return amount * 1.15;
            }
            else if(sp1.equals("EUR-Euro")&&sp2.equals("INR-Indian Rupee")){
                return amount * 108.14;
            }
            else if (sp1.equals("EUR-Euro")&&sp2.equals("KRW-South Korean Won")){
                return amount * 1762.09;
            }
            else if(sp1.equals("EUR-Euro")&&sp2.equals("JPY-Japanese Yen")){
                return amount * 185.28;
            }

            else if(sp1.equals("JPY-Japanese Yen")&&sp2.equals("USD-United Dollar")){
                return amount * 0.0062;
            }
            else if(sp1.equals("JPY-Japanese Yen")&&sp2.equals("INR-Indian Rupee")){
                return amount * 0.59;
            }
            else if(sp1.equals("JPY-Japanese Yen")&&sp2.equals("EUR-Euro")){
                return amount * 0.0054;
            }
            else if(sp1.equals("JPY-Japanese Yen")&&sp2.equals("KRW-South Korean Won")){
                return amount * 9.51;
            }

            else{
                return 0;
            }

        }

    }
