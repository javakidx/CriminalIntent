package ciminalintent.android.jk.idv.criminalintent;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by bioyang on 15/8/8.
 */
public class ImageFragment extends DialogFragment
{
    public static final String EXTRA_IMAGE_PATH = "com.bignerdranch.android.criminalintent.image_path";
    private ImageView mImageView;

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        PictureUtils.cleanImageView(mImageView);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        mImageView = new ImageView(getActivity());
        String path = (String)getArguments().getSerializable(EXTRA_IMAGE_PATH);
        BitmapDrawable image = PictureUtils.getScaledDrawble(getActivity(), path);

        mImageView.setImageDrawable(image);

        return mImageView;
    }

    public static ImageFragment newInstance(String imagePath)
    {
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_IMAGE_PATH, imagePath);

        ImageFragment fragment = new ImageFragment();
        fragment.setArguments(args);
        fragment.setStyle(DialogFragment.STYLE_NO_TITLE, 0);

        return fragment;
    }
}
