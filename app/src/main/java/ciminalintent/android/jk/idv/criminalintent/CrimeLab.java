package ciminalintent.android.jk.idv.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    public static CrimeLab get(Context context)
    {
        if(sCrimeLab == null)
        {
            sCrimeLab = new CrimeLab(context.getApplicationContext());
        }
        return sCrimeLab;
    }

    public List<Crime> getCrimes()
    {
        return mCrimeList;
    }

    public Crime getCrime(UUID id)
    {
        for(Crime c : mCrimeList)
        {
            if(c.getId().equals(id))
            {
                return c;
            }
        }
        return null;
    }

    public void addCrime(Crime c)
    {
        mCrimeList.add(c);
    }
}
