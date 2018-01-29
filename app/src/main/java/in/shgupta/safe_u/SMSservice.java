package in.shgupta.safe_u;

import android.app.AlarmManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.telephony.SmsManager;

/**
 * Created by shubhanshugupta on 07/01/18.
 */

public class SMSservice extends Service  {

    AlarmManager alarmManager= (AlarmManager) getSystemService(ALARM_SERVICE);
    SmsManager sms=SmsManager.getDefault();
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }



}
