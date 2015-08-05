package ciminalintent.android.jk.idv.criminalintent;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by javakid on 2014/10/9.
 */
public class CrimeLab
{
    private static final String TAG = "CrimeLab";
    private static final String FILENAME = "crimes.json";

    private CriminalIntentJSONSerializer mSerializer;

    private List<Crime> mCrimeList;
    private static CrimeLab sCrimeLab;
    private Context mAppContext;

    private CrimeLab(Context context)
    {
        mAppContext = context;
        //mCrimeList = new ArrayList<Crime>();
        mSerializer = new CriminalIntentJSONSerializer(mAppContext, FILENAME);

        try
        {
            mCrimeList = mSerializer.logCrimes();
        }
        catch (Exception e)
        {
            mCrimeList = new ArrayList<Crime>();
            Log.e(TAG, "Error loading crimes", e);
        }
      /*  Crime theCrime;
        for(int i = 0; i < 100; i++)
        {
            theCrime = new Crime();
            theCrime.setTitle("Crime #" + i);
            theCrime.setSolved(i % 2 == 0);
            mCrimeList.add(theCrime);
        }*/
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

    public void deleteCrime(Crime c)
    {
        mCrimeList.remove(c);
    }

    public boolean saveCrimes()
    {
        try
        {
            mSerializer.saveCrime(mCrimeList);
            Log.d(TAG, "crimes saved to file");
            return true;
        }
        catch (Exception e)
        {
            Log.e(TAG, "Error saving crimes", e);
            return false;
        }
    }
}
