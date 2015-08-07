package ciminalintent.android.jk.idv.criminalintent;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;
import java.util.UUID;

/**
 * Created by javakid on 2014/9/12.
 */
public class Crime
{
    private static final String JSON_ID = "id";
    private static final String JSON_TITLE = "title";
    private static final String JSON_SOLVED = "solved";
    private static final String JSON_DATE = "date";
    private static final String JSON_PHOTO = "photo";

    private UUID mId;
    private String mTitle;

    private Date mDate;
    private boolean mSolved;

    private Photo mPhoto;

    public Crime()
    {
        this.mId = UUID.randomUUID();
        this.mDate = new Date();
    }

    public Crime(JSONObject json) throws JSONException
    {
        mId = UUID.fromString(json.getString(JSON_ID));
        if(json.has(JSON_TITLE))
        {
            mTitle = json.getString(JSON_TITLE);
        }

        mSolved = json.getBoolean(JSON_SOLVED);
        mDate = new Date(json.getLong(JSON_DATE));

        if(json.has(JSON_PHOTO))
        {
            mPhoto = new Photo(json.getJSONObject(JSON_PHOTO));
        }
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public boolean isSolved()
    {
        return mSolved;
    }

    public void setSolved(boolean solved)
    {
        mSolved = solved;
    }

    public Date getDate()
    {
        return mDate;
    }

    public void setDate(Date date)
    {
        mDate = date;
    }

    @Override
    public String toString()
    {
        return mTitle;
    }

    public JSONObject toJSON() throws JSONException
    {
        JSONObject json = new JSONObject();
        json.put(JSON_ID, getId().toString());
        json.put(JSON_TITLE, getTitle());
        json.put(JSON_SOLVED, isSolved());
        json.put(JSON_DATE, getDate().getTime());

        if(mPhoto != null)
        {
            json.put(JSON_PHOTO, mPhoto.toJSON());
        }
        return json;
    }

    public Photo getPhoto()
    {
        return mPhoto;
    }

    public void setPhoto(Photo photo)
    {
        mPhoto = photo;
    }
}
