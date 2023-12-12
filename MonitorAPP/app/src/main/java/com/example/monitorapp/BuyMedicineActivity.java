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

public class BuyMedicineActivity extends AppCompatActivity {

    private String[][] packages =
            {
                    {"uprise capsule", "", "", "","620"},
                    {"Vitamin A1", "", "", "","500"},
                    {"Brufen","", "", "","950"},
                    {"Paracetamol", "", "", "","200"},
                    {"Benacoff", "", "", "","800"},
                    {"Aspirin", "", "", "","850"},
                    {"Omega 6/8", "", "", "","600"},
                    {"Penicilin", "", "", "","870"},
                    {"Augmentin", "", "", "","500"},
                    {"Cough Syrup", "", "", "","300"},
            };
    private String[]package_details = {
            "Pain reliever for headache and ore throats\n" +
                    "Reduce fatigue faster and quicker\n" +
                    "Hard immunity acquired quicker",
            "Chromium is essential to trace mineral that plays an important role in helping insulin regulation",
            "Provides relief for vitamin B deficiencies\n" +
                    "Helps in formation of red blood cells\n" +
                    "Maintains healthy nervous system",
            "Promotes health as well as skin benefits\n" +
                    "Reduce skin blemish and pigmentation\n" +
                    "Acts as safeguard for the skin against harsh UV sunlight rays",
            "Hedex 650 tablet helps relieve pain and fever by blocking chemicals releasing pain.",
            "Reliever for headache and also body temperature\n" +
                    "Suitable for people with heart condition and blood pressure\n" +
                    "Hard immunity acquired quicker",
            "Relieves symptoms of bacterial infection and soothes the recovery process\n" +
                    "Provides comforting feeling to the sore throat.\n" +
                    "Reduces risk of calcium deficiency,rickets and anaemia",
            "Pain reliever for headache and ore throats\n" +
                    "Reduce fatigue faster and quicker\n" +
                    "Promote mobility and flexibility of joints",
            "Helps reduce the iron deficiency due to chronic blood loss or low intake of iron"
    };
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnBack,btnGoToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        lst =findViewById(R.id.listViewBuyMedicine);
        btnBack= findViewById(R.id.buttonBMBack);
        btnGoToCart=findViewById(R.id.buttonGoToCartBM);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this,HomeActivity.class));
            }
        });
        list = new ArrayList();
        for (int i = 0; i < packages.length; i++) {
            item = new HashMap<String, String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Total Cost:"+packages[i][4]+"/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it =new Intent(BuyMedicineActivity.this,BuyMedicineDetailsActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });
        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineActivity.this,CartBuyMedicineActivity.class));
            }
        });
    }
}