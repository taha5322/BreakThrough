package com.siddiqui.mentalhealthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ChatroomActivity extends AppCompatActivity {

    Button btnSend;
    EditText tvMessage, tvNumber;
    IntentFilter intentFilter;

    private BroadcastReceiver intentReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            TextView inTxt = findViewById(R.id.textMsg);
            String current = inTxt.getText().toString();
            System.out.println(current);
            current +=  intent.getExtras().getString("message") + "\n";

            inTxt.setText(current);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom);

        //intent to filter for SMS messages recieved
        intentFilter = new IntentFilter();
        intentFilter.addAction("SMS_RECEIVED_ACTION");

        btnSend=findViewById(R.id.btnSend);
        tvMessage = findViewById(R.id.tvMessage);
        tvNumber = findViewById(R.id.tvNumber);

//        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myMsg = tvMessage.getText().toString();
                if(!myMsg.equals("")) {
                    String theNumber = tvNumber.getText().toString();
                    sendMsg(theNumber, myMsg);

                    TextView inTxt = findViewById(R.id.textMsg);
                    String current = inTxt.getText().toString();
                    current +=  theNumber + ": " + myMsg + "\n" + "\n";
                    inTxt.setText(current);
                    tvMessage.setText("");
                }
            }
        });

    }

    private void sendMsg(String theNumber, String myMsg) {
        String SENT = "Message Sent";
        String DELIVERED = "Message Delivered;";

        PendingIntent sentPI = PendingIntent.getBroadcast(this,0,
                new Intent(SENT), 0);
        PendingIntent deliveredPI = PendingIntent.getBroadcast(this,0,
                new Intent(DELIVERED), 0);

        SmsManager sms = SmsManager.getDefault();
//        sms.sendTextMessage(theNumber,null,myMsg,sentPI,deliveredPI);
        sms.sendTextMessage("3653382903",null,"user 2: "+myMsg,sentPI,deliveredPI);
    }

    @Override
    protected void onResume() {
        //register the receiver
        registerReceiver(intentReceiver,intentFilter);
        super.onResume();
    }

    @Override
    protected void onPause() {
        //unregister receiver
        unregisterReceiver(intentReceiver);
        super.onPause();
    }

}