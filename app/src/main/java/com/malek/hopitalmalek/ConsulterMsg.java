package com.malek.hopitalmalek;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ConsulterMsg extends AppCompatActivity {
TextView txtMsg;
String Msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulter_msg);
    txtMsg=findViewById(R.id.txtMsg);
        Bundle data = getIntent().getExtras();
        if (data != null) {
            Msg = data.getString("msg");
            txtMsg.setText(Msg);

        }

    }
}
