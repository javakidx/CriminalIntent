package ciminalintent.android.jk.idv.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by javakid on 2014/10/9.
 */
public class CrimeLab
{

    private List<Crime> mCrimeList;
    private static CrimeLab sCrimeLab;
    private Context mContext;
    private CrimeLab(Context context)
    {
        mContext = context;
        mCrimeList = new ArrayList<Crime>();

        Crime theCrime;
        for(int i = 0; i < 100; i++)
        {
            theCrime = new Crime();
            theCrime.setTitle("Crime #" + i);
            theCrime.setSolved(i % 2 == 0);
            mCrimeList.add(theCrime);
        }
    }

    public static CrimeLab newInstance(Context context)
    {
        if(sCrimeLab == null)
        {
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    public List<Crime> getCrimeList()
    {
        return mCrimeList;
    }
}
