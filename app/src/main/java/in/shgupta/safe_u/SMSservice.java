package in.shgupta.safe_u;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by shubhanshugupta on 07/01/18.
 */

public class SMSservice extends Service  {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
