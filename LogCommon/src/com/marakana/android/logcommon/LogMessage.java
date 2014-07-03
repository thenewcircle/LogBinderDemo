package com.marakana.android.logcommon;

import android.os.Parcel;
import android.os.Parcelable;

public class LogMessage implements Parcelable {
	private final int priority;
	private final String tag;
	private final String msg;

	public LogMessage(int priority, String tag, String msg) {
		this.priority = priority;
		this.tag = tag;
		this.msg = msg;
	}

	public LogMessage(Parcel in) {
		this.priority = in.readInt();
		this.tag = in.readString();
		this.msg = in.readString();
	}
	
	public int getPriority() {
		return priority;
	}

	public String getTag() {
		return tag;
	}

	public String getMsg() {
		return msg;
	}

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

	public static final Parcelable.Creator<LogMessage> CREATOR = new Parcelable.Creator<LogMessage>() {
		public LogMessage createFromParcel(Parcel in) {
			return new LogMessage(in);
		}

		public LogMessage[] newArray(int size) {
			return new LogMessage[size];
		}
	};
}
