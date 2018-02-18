package com.wrathspectre.computercontrol;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public class MouseAndKeyboardFragment extends Fragment{
    NetworkConnection net = NetworkConnection.getInstance();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.keyboard, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                final int action = motionEvent.getAction();
                switch (action & MotionEvent.ACTION_MASK) {

                    //Click action
                    case MotionEvent.ACTION_DOWN: {
                      /*  try {
                            instance.getMessage(Float.toString(motionEvent.getX())+"\n");
                        } catch(IOException e) {
                            e.printStackTrace();
                        }*/

                        new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, Float.toString(motionEvent.getX()).toString()+"\n");
                        Log.d("D", Float.toString(motionEvent.getX()));
                        Log.d("D", Float.toString(motionEvent.getY()));
                        break;
                    }

                    //Move action
                    case MotionEvent.ACTION_MOVE: {
                        new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, Float.toString(motionEvent.getX()).toString()+"\n");
                        Log.d("D", Float.toString(motionEvent.getX()));
                        Log.d("D", Float.toString(motionEvent.getY()));
                        break;
                    }
                }
                return true;

            }
        });
    }

    public class sendTask extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params) {
            Log.d("Q", "QQQQQQQQQQQQQQQQ");
            net.send(params[0]);
            return null;
        }
    }
}
