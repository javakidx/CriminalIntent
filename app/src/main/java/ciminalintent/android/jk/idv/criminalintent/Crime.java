package ciminalintent.android.jk.idv.criminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * Created by javakid on 2014/9/12.
 */
public class Crime
{
    private UUID mId;
    private String mTitle;

    private Date mDate;
    private boolean mSolved;

    public Crime()
    {
        this.mId = UUID.randomUUID();
        this.mDate = new Date();
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
}
