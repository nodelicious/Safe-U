package in.shgupta.safe_u;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by shubhanshugupta on 03/01/18.
 */

public class Login extends AppCompatActivity {

    EditText et1;

    public static final String TAG="check2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage);
        Log.d(TAG, "onCreate: ");


        SharedPreferences sp= PreferenceManager.getDefaultSharedPreferences(this);
        String vi=sp.getString("mobileno","");
        if(!vi.equals("mobileno")){

        Intent i=new Intent(this,danger.class);
        startActivity(i);
        finish();}

        et1= (EditText) findViewById(R.id.etsubmit);

        Button btn= (Button) findViewById(R.id.btnregister);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mobileno = et1.getText().toString() ;

                if(mobileno.equals("")){
                    Toast.makeText(Login.this, "please enter number", Toast.LENGTH_SHORT).show();
                }else {
                    SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()) ;
                    sp.edit().putString("mobileno" , mobileno).apply();

                    Intent changeintent = new Intent(getApplicationContext() , danger.class) ;
                    startActivity(changeintent);
                    finish();
                }
            }
        });

    }
}
