package hfad.com.ovdinfonew;


import android.os.Parcel;
import android.os.Parcelable;

class MyData implements Parcelable {
    private int nid;
    private String title;
    private String date;
    private String link;
    private String text;



    public MyData(int nid, String title, String date, String link, String text) {
        this.nid = nid;
        this.title = title;
        this.date = date;
        this.link = link;
        this.text = text;
    }




    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {

        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }



    protected MyData(Parcel in) {
        nid = in.readInt();
        title = in.readString();
        date = in.readString();
        link = in.readString();
        text = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(nid);
        dest.writeString(title);
        dest.writeString(date);
        dest.writeString(link);
        dest.writeString(text);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<MyData> CREATOR = new Parcelable.Creator<MyData>() {
        @Override
        public MyData createFromParcel(Parcel in) {
            return new MyData(in);
        }

        @Override
        public MyData[] newArray(int size) {
            return new MyData[size];
        }
    };
}