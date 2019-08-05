package com.ansari.runtimeperdemo;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void permissionMethod(View view) {

        if(ActivityCompat.checkSelfPermission
                (MainActivity.this, Manifest.permission.SEND_SMS)== PackageManager.PERMISSION_GRANTED){

            Toast.makeText(this, "The permission is granted ...", Toast.LENGTH_LONG).show();

        } else
        {
            getMyPermission();
        }
    }

    private void getMyPermission() {

        if(ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,Manifest.permission.SEND_SMS))
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Alert Dialog");
            builder.setMessage("If you click on Deny .. you cannot send sms");
            builder.setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityCompat.requestPermissions(MainActivity.this,new
                            String[]{Manifest.permission.SEND_SMS},123);
                }
            });
            builder.setNegativeButton("Deny ", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            builder.show();

        }else {
            ActivityCompat.requestPermissions(MainActivity.this,new
                    String[]{Manifest.permission.SEND_SMS},123);

        }

    }
}
