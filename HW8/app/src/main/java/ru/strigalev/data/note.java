package ru.strigalev.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class note implements Parcelable {

    private int id;
    private String title;
    private String body;
    private Date date;

    public note(int id, String title, String body, Date date) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.date = date;
    }

    protected note(Parcel in) {
        id = in.readInt();
        title = in.readString();
        body = in.readString();
    }

    public static final Creator<note> CREATOR = new Creator<note>() {
        @Override
        public note createFromParcel(Parcel in) {
            return new note(in);
        }

        @Override
        public note[] newArray(int size) {
            return new note[size];
        }
    };

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(body);
    }
}
