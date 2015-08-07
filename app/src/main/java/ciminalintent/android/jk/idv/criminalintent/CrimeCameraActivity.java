package ciminalintent.android.jk.idv.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by bioyang on 15/8/6.
 */
public class CrimeCameraActivity extends SingleFragmentActivity
{
    @Override
    protected Fragment createFragment()
    {
        return new CrimeCameraFragment();
    }
}
