package com.spotsoont.test.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by sharana.b on 7/18/2017.
 */

public class VideoModel implements Parcelable {

    private int imageId ;
    private String mPath;
    private String songName;
    private int postedBefore;

    public VideoModel() {
    }


    protected VideoModel(Parcel in) {
        imageId = in.readInt();
        mPath = in.readString();
        songName = in.readString();
        postedBefore = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imageId);
        dest.writeString(mPath);
        dest.writeString(songName);
        dest.writeInt(postedBefore);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<VideoModel> CREATOR = new Creator<VideoModel>() {
        @Override
        public VideoModel createFromParcel(Parcel in) {
            return new VideoModel(in);
        }

        @Override
        public VideoModel[] newArray(int size) {
            return new VideoModel[size];
        }
    };

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getmPath() {
        return mPath;
    }

    public void setmPath(String mPath) {
        this.mPath = mPath;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public int getPostedBefore() {
        return postedBefore;
    }

    public void setPostedBefore(int postedBefore) {
        this.postedBefore = postedBefore;
    }
}
