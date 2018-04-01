package in.shgupta.safe_u;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class addcontacts extends AppCompatActivity {
    EditText input1;
    Button btn1;
    TextView txt1;
    SharedPreferences preferences1;

    EditText input2;
    Button btn2;
    TextView txt2;
    SharedPreferences preferences2;

    EditText input3;
    Button btn3;
    TextView txt3;
    SharedPreferences preferences3;

    public static final String PREF_KEY_TEXT = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcontacs);
        input1 = (EditText) findViewById(R.id.input1);
        btn1 = (Button) findViewById(R.id.btn1);
        txt1 = (TextView) findViewById(R.id.txt1);
        preferences1 = getPreferences(MODE_PRIVATE);
        String SavedValue1 = preferences1.getString(PREF_KEY_TEXT,null);
        if (SavedValue1 != null){
            txt1.setText(SavedValue1);
        }
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt1.setText(input1.getText().toString());
                SharedPreferences.Editor editor = preferences1.edit();
                editor.putString(PREF_KEY_TEXT,input1.getText().toString());
                editor.apply();
            }
        });

        input2 = (EditText) findViewById(R.id.input2);
        btn2 = (Button) findViewById(R.id.btn2);
        txt2 = (TextView) findViewById(R.id.txt2);
        preferences2 = getPreferences(MODE_PRIVATE);
        String SavedValue2 = preferences2.getString(PREF_KEY_TEXT,null);
        if (SavedValue2 != null){
            txt2.setText(SavedValue2);
        }
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt2.setText(input2.getText().toString());
                SharedPreferences.Editor editor = preferences2.edit();
                editor.putString(PREF_KEY_TEXT,input2.getText().toString());
                editor.apply();
            }
        });

        input3 = (EditText) findViewById(R.id.input3);
        btn3 = (Button) findViewById(R.id.btn3);
        txt3 = (TextView) findViewById(R.id.txt3);
        preferences3 = getPreferences(MODE_PRIVATE);
        String SavedValue3 = preferences3.getString(PREF_KEY_TEXT,null);
        if (SavedValue3 != null){
            txt3.setText(SavedValue3);
        }
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt3.setText(input3.getText().toString());
                SharedPreferences.Editor editor = preferences3.edit();
                editor.putString(PREF_KEY_TEXT,input3.getText().toString());
                editor.apply();
            }
        });
    }
}
