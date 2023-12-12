package com.example.monitorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

private String[][] doctor_details1 =
        {
                {"Doctor Name : A ","Hospital Address : 51556-2511","Exp : 24yrs ","Mobile Number : +5455455454","900"},
                {"Doctor Name : B ","Hospital Address : 86541-5515 ","Exp : 14yrs ","Mobile Number : +878541356","550"},
                {"Doctor Name : C","Hospital Address : 87221-5484","Exp : 15yrs ","Mobile Number : +5984891","800"},
                {"Doctor Name : D ","Hospital Address : 47120-9310","Exp : 20yrs ","Mobile Number : +8746123","600"},
                {"Doctor Name : E","Hospital Address : 87420-9320","Exp : 55yrs ","Mobile Number : +98545312","500"}
        };
    private String[][] doctor_details2 =
            {
                    {"Doctor Name : F ","Hospital Address : 51556-2511","Exp : 21yrs ","Mobile Number : +852642","900"},
                    {"Doctor Name : G ","Hospital Address : 86541-5515 ","Exp : 12yrs ","Mobile Number : +878541556","550"},
                    {"Doctor Name : H","Hospital Address : 87221-5484","Exp : 13yrs ","Mobile Number : +5984552","800"},
                    {"Doctor Name : I ","Hospital Address : 47120-9310","Exp : 24yrs ","Mobile Number : +87462593","600"},
                    {"Doctor Name : J","Hospital Address : 87420-9320","Exp : 56yrs ","Mobile Number : +9855925","500"}
            };
    private String[][] doctor_details3 =
            {
                    {"Doctor Name : K ","Hospital Address : 51556-2511","Exp : 29yrs ","Mobile Number : +54595524","900"},
                    {"Doctor Name : L ","Hospital Address : 86541-5515 ","Exp : 18yrs ","Mobile Number : +87881356","550"},
                    {"Doctor Name : M ","Hospital Address : 87221-5484","Exp : 17yrs ","Mobile Number : +5982811","800"},
                    {"Doctor Name : N ","Hospital Address : 47120-9310","Exp : 26yrs ","Mobile Number : +87461813","600"},
                    {"Doctor Name : O ","Hospital Address : 87420-9320","Exp : 51yrs ","Mobile Number : +9854512","500"}
            };
    private String[][] doctor_details4 =
            {
                    {"Doctor Name : P ","Hospital Address : 51556-2511","Exp : 25yrs ","Mobile Number : +5448475454","900"},
                    {"Doctor Name : Q ","Hospital Address : 86541-5515 ","Exp : 12yrs ","Mobile Number : +85541356","550"},
                    {"Doctor Name : R ","Hospital Address : 87221-5484","Exp : 17yrs ","Mobile Number : +5984891","800"},
                    {"Doctor Name : S ","Hospital Address : 47120-9310","Exp : 26yrs ","Mobile Number : +8746123","600"},
                    {"Doctor Name : T ","Hospital Address : 87420-9320","Exp : 58yrs ","Mobile Number : +98545312","500"}
            };
    private String[][] doctor_details5 =
            {
                    {"Doctor Name : U ","Hospital Address : 51556-2511","Exp : 29yrs ","Mobile Number : +5455455454","900"},
                    {"Doctor Name : V ","Hospital Address : 86541-5515 ","Exp : 14yrs ","Mobile Number : +878541356","550"},
                    {"Doctor Name : W ","Hospital Address : 87221-5484","Exp : 14yrs ","Mobile Number : +5984891","800"},
                    {"Doctor Name : X","Hospital Address : 47120-9310","Exp : 29yrs ","Mobile Number : +8746123","600"},
                    {"Doctor Name : Y","Hospital Address : 87420-9320","Exp : 53yrs ","Mobile Number : +98545312","500"}
            };
    TextView tv;
    Button btn;
    String[][] doctor_details ={};
    ArrayList list;
    HashMap<String,String>item;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonDDBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0)
            doctor_details = doctor_details1;
       else
        if(title.compareTo("Dietitians")==0)
            doctor_details = doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details = doctor_details3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0;i<doctor_details.length;i++) {
            item = new HashMap<String, String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Cons Fees: " +doctor_details[i][4]+"/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );
        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });

    }
}