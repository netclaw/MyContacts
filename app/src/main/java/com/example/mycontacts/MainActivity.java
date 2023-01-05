package com.example.mycontacts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int Perm_CTC=2;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_CONTACTS}, Perm_CTC);

        tv=(TextView) findViewById(R.id.textView);


    }


    public void onContactid(View view){

        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setData(Uri.parse("content://contacts/people"));
        startActivityForResult(intent,123);

    }

    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        Log.i("HELP:","heelellelelelelelellelelelellelelel");
        if (requestCode == 123) {
            tv.setText("opération annulée");
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//check the permission type using the requestCode
        if (requestCode == Perm_CTC) {
//the array is empty if not granted
            if (grantResults.length > 0 && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED) { Toast.makeText(this, "GRANTED CALL",
                Toast.LENGTH_SHORT).show();
            }
        } }
}