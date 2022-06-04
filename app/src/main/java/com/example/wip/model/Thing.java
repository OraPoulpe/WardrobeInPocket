package com.example.wip.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity
public class Thing implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "size")
    public int size;

    @ColumnInfo(name = "color")
    public String color;

    @ColumnInfo(name = "category")
    public String category;

    public Thing(){

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Thing clothes = (Thing) o;
        return uid == clothes.uid && size == clothes.size && name.equals(clothes.name) && color.equals(clothes.color) && category.equals(clothes.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, name, size, color, category);
    }

    protected Thing(Parcel in) {
        uid = in.readInt();
        name = in.readString();
        size = in.readInt();
        color = in.readString();
        category = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(uid);
        dest.writeString(name);
        dest.writeInt(size);
        dest.writeString(color);
        dest.writeString(category);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Thing> CREATOR = new Creator<Thing>() {
        @Override
        public Thing createFromParcel(Parcel in) {
            return new Thing(in);
        }

        @Override
        public Thing[] newArray(int size) {
            return new Thing[size];
        }
    };
}
