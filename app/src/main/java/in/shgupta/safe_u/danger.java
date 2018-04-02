package in.shgupta.safe_u;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by shubhanshugupta on 03/01/18.
 */

public class danger extends AppCompatActivity {

    LocationManager lm;
    Button danger,addcontacts;
    models m;


    public static final String TAG="location";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        final double[] lati = new double[1];
        final double[] longi = new double[1];
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangerhome);
        danger = (Button) findViewById(R.id.danger);
        addcontacts= (Button) findViewById(R.id.btnaddcontacts);


        lm = (LocationManager) getSystemService(LOCATION_SERVICE);


        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

            Toast.makeText(this, "GPS is enabled", Toast.LENGTH_SHORT).show();


        } else {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION
                    , Manifest.permission.ACCESS_FINE_LOCATION}, 121);


        }
        LocationListener loclis=new LocationListener() {

            @Override
            public void onLocationChanged(Location location) {

                Log.d(TAG, "onLocationChanged: latitude="+location.getLatitude());

                lati[0] =location.getLatitude();
                longi[0] =location.getLongitude();
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        };

        lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,10*1000,0,loclis);


        danger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    String message = "http://maps.google.com/maps?saddr=" + lati[0] + "," + longi[0];
                    String number1 = m.getNo1();
                    String number2 = m.getNo2();
                    String number3 = m.getNo3();
                    SmsManager smsManager = SmsManager.getDefault();
                    StringBuffer smsBody = new StringBuffer();
                    smsBody.append(Uri.parse(message));
                    if(m.getNo1()!=null) {
                        android.telephony.SmsManager.getDefault().sendTextMessage(number1, null, smsBody.toString(), null, null);
                    }
                    else if(m.getNo2()!=null) {
                        android.telephony.SmsManager.getDefault().sendTextMessage(number2, null, smsBody.toString(), null, null);
                    }
                    else if(m.getNo3()!=null) {
                        android.telephony.SmsManager.getDefault().sendTextMessage(number3, null, smsBody.toString(), null, null);
                    }else{
                        Toast.makeText(danger.this, "please add numbers", Toast.LENGTH_SHORT).show();
                    }

            }
        });

        addcontacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(danger.this, in.shgupta.safe_u.addcontacts.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult ( int requestCode, @NonNull String[] permissions,
                                             @NonNull int[] grantResults){
        if (requestCode == 121) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED || grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "GPS is enabled", Toast.LENGTH_SHORT).show();
            } else {

            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }



}
