package com.example.phonecall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private boolean checkPermission(String permission){
        int permissionCheck = ContextCompat.checkSelfPermission(this, permission);
        return(permissionCheck == PackageManager.PERMISSION_GRANTED);
    }

    public void dialPhone(View view){
        if(checkPermission("android.permission.CALL_PHONE")){
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:07843171803"));
            startActivity(intent);
        }
    }
}
