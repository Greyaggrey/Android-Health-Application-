package com.example.monitorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {


        private String[][] packages =
                {
                        {"Package 1 : Full Body Checkup", "", "", "","5544"},
                        {"Package 2 : Blood Glucose", "", "", "","2852"},
                        {"Package 3 : Thyroid check", "", "", "","8244"},
                        {"Package 4 : Immunity check", "", "", "","5852"},
                        {"Package 5 : Covid checkup", "", "", "","5448"}
                };
        private String[] package_details = {
                "Blood Glucose Fasting\n" +
                        "Complete Haemogram\n" +
                        "HBA1C\n" +
                        "Iron studies\n" +
                        "Kidney function test\n" +
                        "LDA\n" +
                        "Liquid profile\n" +
                        "Liver function test",
                "Blood Glucose Fasting",
                "Covid anti-Body",
                "Thyroid profile-total(1,2,3)",
                "complete haemogram\n" +
                        "CRP( complete Reactive Protein) Quantitative,Serum\n" +
                        "Iron studies\n" +
                        "kidney function test\n" +
                        "Vitamin D total Hydroxy" +
                        "Liver function test\n" +
                        "Lipid profile"
        };
        HashMap<String,String> item;
        ArrayList list;
        SimpleAdapter sa;
        Button btnGoToCart,btnBack;
        ListView lst;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_lab_test);

            btnGoToCart = findViewById(R.id.buttonGoToCartLT);
            btnBack = findViewById(R.id.buttonLTBack);
            lst = findViewById(R.id.listViewLt);


            btnBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(LabTestActivity.this, HomeActivity.class));
                }
            });

            list = new ArrayList();
            for (int i = 0; i < packages.length; i++) {
                item = new HashMap<String, String>();
                item.put("line1",packages[i][0]);
                item.put("line2",packages[i][1]);
                item.put("line3",packages[i][2]);
                item.put("line4",packages[i][3]);
                item.put("line5","Total Cost:"+packages[i][4]+"/-");
                list.add( item );
            }
            sa = new SimpleAdapter(this, list,
                    R.layout.multi_lines,
                    new String[]{"line1","line2","line3","line4","line5"},
                    new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
            lst.setAdapter(sa);
            
            lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i,long l) {
                    Intent it = new Intent(LabTestActivity.this,LabTestDetailsActivity.class);
                    it.putExtra("text1",packages[i][0]);
                    it.putExtra("text2",package_details[i]);
                    it.putExtra("text3",packages[i][4]);
                    startActivity(it);
                }
            });
            btnGoToCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(LabTestActivity.this,CartLabActivity.class));
                }
            });

        }
    }