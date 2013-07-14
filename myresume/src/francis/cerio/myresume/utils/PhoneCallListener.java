package francis.cerio.myresume.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

public class PhoneCallListener extends PhoneStateListener {
	
	
	 
	private boolean isPhoneCalling = false;

	String LOG_TAG = "LOGGING 123";

	private Context context;
	
	public PhoneCallListener(Context context){
		this.context = context;
	}
	
	
	
	@Override
	public void onCallStateChanged(int state, String incomingNumber) {
		
		if (TelephonyManager.CALL_STATE_RINGING == state) {
			// phone ringing
			Log.i(LOG_TAG, "RINGING, number: " + incomingNumber);
		}

		if (TelephonyManager.CALL_STATE_OFFHOOK == state) {
			// active
			Log.i(LOG_TAG, "OFFHOOK");

			isPhoneCalling = true;
		}

		if (TelephonyManager.CALL_STATE_IDLE == state) {
			// run when class initial and phone call ended, 
			// need detect flag from CALL_STATE_OFFHOOK
			Log.i(LOG_TAG, "IDLE");

			if (isPhoneCalling) {

				Log.i(LOG_TAG, "restart app");

				// restart app
				Intent i = ((Activity) context).getBaseContext().getPackageManager()
					.getLaunchIntentForPackage(
							((Activity) context).getBaseContext().getPackageName());
				i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				((Activity) context).startActivity(i);

				isPhoneCalling = false;
			}

		}
	}
}
