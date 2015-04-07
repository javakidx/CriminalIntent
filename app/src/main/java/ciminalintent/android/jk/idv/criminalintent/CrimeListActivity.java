package ciminalintent.android.jk.idv.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by javakid on 2014/10/14.
 */
public class CrimeListActivity extends SingleFragmentActivity
{
    @Override
    protected Fragment createFragment()
    {
        return new CrimeListFragment();
    }
}
