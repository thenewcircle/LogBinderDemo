package com.marakana.android.logservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class LogService extends Service {
	private static final String TAG = "LogService";
	
	/* BINDER LAB: We'll need a reference to our Binder service */

	@Override
	public void onCreate() {
		super.onCreate();
		this.service = new ILogServiceImpl(super.getApplicationContext());
	}

	@Override
	public IBinder onBind(Intent intent) {
		/* BINDER LAB: Modify this to return a reference to the Binder service */
		return null;
	}

	@Override
	public boolean onUnbind(Intent intent) {
		return super.onUnbind(intent);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}
}
