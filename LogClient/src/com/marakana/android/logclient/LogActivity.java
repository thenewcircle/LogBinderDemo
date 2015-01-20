package com.marakana.android.logclient;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class LogActivity extends Activity implements OnClickListener,
		ServiceConnection {
	private static final String TAG = "LogActivity";
	private static final int[] LOG_LEVEL = { Log.VERBOSE, Log.DEBUG, Log.INFO,
			Log.WARN, Log.ERROR };

	private Spinner priority;

	private EditText tag;

	private EditText msg;

	private Button button;

	/* BINDER LAB: We'll need a reference to our Binder service */

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		this.priority = (Spinner) super.findViewById(R.id.log_priority);
		this.tag = (EditText) super.findViewById(R.id.log_tag);
		this.msg = (EditText) super.findViewById(R.id.log_msg);
		this.button = (Button) super.findViewById(R.id.log_button);
		this.button.setOnClickListener(this);
		this.button.setEnabled(false);
	}

	@Override
	protected void onStart() {
		super.onStart();
		/* BINDER LAB:
		 * We need to bind to our app service when coming
		 * into the foreground.
		 */
	}

	@Override
	protected void onStop() {
		super.onStop();
		/* BINDER LAB:
		 * We need to unbind from our app service when going
		 * into the background.
		 */
	}

	@Override
	public void onServiceConnected(ComponentName name, IBinder service) {
		/* BINDER LAB: Attach to your Binder service here */
		
		this.button.setEnabled(true);
	}

	@Override
	public void onServiceDisconnected(ComponentName name) {
		/* BINDER LAB: Clear your Binder service reference here */
		
		this.button.setEnabled(false);
	}

	public void onClick(View v) {
		int priorityPosition = this.priority.getSelectedItemPosition();
		if (priorityPosition != AdapterView.INVALID_POSITION) {
			int priority = LOG_LEVEL[priorityPosition];
			String tag = this.tag.getText().toString();
			String msg = this.msg.getText().toString();
			
			/* 
			 * BINDER LAB:
			 * Call your new log service here, passing in the parameters
			 * we've obtained above
			 */
		}
	}
}
