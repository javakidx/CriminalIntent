package ciminalintent.android.jk.idv.criminalintent;

import android.os.Bundle;
import android.support.v4.app.ListFragment;

import java.util.List;

/**
 * Created by javakid on 2014/10/14.
 */
public class CrimeListFragment extends ListFragment
{
    private List<Crime> mCrimes;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.crimes_title);
        mCrimes = CrimeLab.get(getActivity()).getCrimes();
    }
}
