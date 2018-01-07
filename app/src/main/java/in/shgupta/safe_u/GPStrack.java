package in.shgupta.safe_u;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

/**
 * Created by shubhanshugupta on 07/01/18.
 */

public class GPStrack implements LocationListener {

    private final Context mContext;


    Location location; // location
    double latitude; // latitude
    double longitude; // longitude

    private static final long mintime=1;
    private static final long mindistance=10;

    private LocationManager lm;

    public GPStrack(Context context) {
        this.mContext = context;
        getLocation();
    }

    public Location getLocation(){

        return location;
    }


    @Override
    public void onLocationChanged(Location location) {
        this.location = location;
        getLocation().getLatitude();
        getLocation().getLongitude();

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
}
