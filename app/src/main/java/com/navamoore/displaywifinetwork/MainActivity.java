package com.navamoore.displaywifinetwork;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

 public class MainActivity extends AppCompatActivity {

    private TextView mWifiTextView;
    private Button mShowwifiButton;

    WifiManager wifiManager;
    WifiInfo connection;

    String displayNetworkInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mWifiTextView = (TextView) findViewById(R.id.wifiTextView);
        mShowwifiButton = (Button) findViewById(R.id.showWifiButton);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //When button is clicked, display will show wifi information

                wifiManager = (WifiManager)getSystemService(Context.WIFI_SERVICE);
                connection = wifiManager.getConnectionInfo();

                displayNetworkInfo += "SSID :" +connection.getSSID() + "\n" + "RSSi" +connection.getRssi() + "\n"+ "Mac Address :"+connection.getMacAddress() + "\n" + "Ip Address :" + connection.getIpAddress();

                mWifiTextView.setText(displayNetworkInfo);

            }
        };
        mShowwifiButton.setOnClickListener(listener);

    }
}


