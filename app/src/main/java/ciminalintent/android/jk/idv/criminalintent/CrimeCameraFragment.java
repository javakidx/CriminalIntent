package ciminalintent.android.jk.idv.criminalintent;

import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.io.IOException;
import java.util.List;

/**
 * Created by bioyang on 15/8/6.
 */
public class CrimeCameraFragment extends Fragment
{
    private final String TAG = "CrimeCameraFragment";
    private Camera mCamera;
    private SurfaceView mSurfaceView;

    @Override
    public void onResume()
    {
        super.onResume();

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD)
        {
            mCamera = Camera.open(0);
        }
        else
        {
            mCamera = Camera.open();
        }
    }

    @Override
    public void onPause()
    {
        super.onPause();

        if(mCamera != null)
        {
            mCamera.release();
            mCamera = null;
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_crime_camera, container, false);

        Button takePictureButton = (Button)v.findViewById(R.id.crime_camera_tackPictureButton);
        takePictureButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                getActivity().finish();
            }
        });

        mSurfaceView = (SurfaceView)v.findViewById(R.id.crime_camera_surfaceView);
        SurfaceHolder holder = mSurfaceView.getHolder();
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        holder.addCallback(new SurfaceHolder.Callback()
        {
            @Override
            public void surfaceCreated(SurfaceHolder holder)
            {
                //Tell the camera to use this surface as its preview area
                try
                {
                    if (mCamera != null)
                    {
                        mCamera.setPreviewDisplay(holder);
                    }

                } catch (IOException e)
                {
                    Log.e(TAG, "Error setting up preview display", e);
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)
            {
                if (mCamera == null)
                {
                    return;
                }

                Camera.Parameters parameters = mCamera.getParameters();
                //Camera.Size s = null;
                Camera.Size s = getBestSupportedSize(parameters.getSupportedPreviewSizes(), width, height);
                parameters.setPreviewSize(s.width, s.height);
                mCamera.setParameters(parameters);

                try
                {
                    mCamera.startPreview();
                } catch (Exception e)
                {
                    Log.e(TAG, "Could not start preview", e);
                    mCamera.release();
                    mCamera = null;
                }

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder)
            {
                if (mCamera != null)
                {
                    mCamera.stopPreview();
                }
            }
        });
        return v;
    }

    private Camera.Size getBestSupportedSize(List<Camera.Size> sizeList, int width, int height)
    {
        Camera.Size bestSize = sizeList.get(0);
        int largestArea = bestSize.width * bestSize.height;

        for(Camera.Size s : sizeList)
        {
            int area = s.width * s.height;
            if(area > largestArea)
            {
                bestSize = s;
                largestArea = area;
            }
        }
        return bestSize;
    }
}
