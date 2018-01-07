package in.shgupta.safe_u;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG="check";
    int Splashtime=2500 ;
    TextView logotext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent changeactivity  = new Intent(MainActivity.this , Login.class) ;
                Log.d(TAG, "run1: ");
                startActivity(changeactivity) ;
                Log.d(TAG, "run: ");
                finish();

            }
        } , Splashtime) ;
    }
}