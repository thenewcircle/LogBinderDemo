package com.marakana.android.logcommon;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class LogMessage implements Parcelable {
	private int priority;
	private String tag;
	private String msg;

	public LogMessage(int priority, String tag, String msg) {
		this.priority = priority;
		this.tag = tag;
		this.msg = msg;
	}

	/** Constructors used implicitly by Parcelable */
	
	public LogMessage() {
		this.priority = Log.VERBOSE;
		this.tag = "";
		this.msg = "";
	}
	
	public LogMessage(Parcel in) {
		readFromParcel(in);
	}
	
	/** Public Accessors */
	
	public int getPriority() {
		return priority;
	}

	public String getTag() {
		return tag;
	}

	public String getMsg() {
		return msg;
	}

	/** Explicit Parcelable Requirements */
	
	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int flags) {
		parcel.writeInt(this.priority);
		parcel.writeString(this.tag);
		parcel.writeString(this.msg);
	}
	
	/** Implicit Parcelable Requirements */
	
	public void readFromParcel(Parcel in) {
		this.priority = in.readInt();
		this.tag = in.readString();
		this.msg = in.readString();
	}

	public static final Parcelable.Creator<LogMessage> CREATOR = new Parcelable.Creator<LogMessage>() {
		public LogMessage createFromParcel(Parcel in) {
			return new LogMessage(in);
		}

		public LogMessage[] newArray(int size) {
			return new LogMessage[size];
		}
	};
}
