package com.wrathspectre.computercontrol;

import android.arch.lifecycle.Lifecycle;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class KeyboardFragment extends Fragment {
    NetworkConnection net;

    @Override
    public Lifecycle getLifecycle() {
        return super.getLifecycle();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.keyboard, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Keyboard");

        net = NetworkConnection.getInstance();

        view.findViewById(R.id.esc).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.f1).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.f2).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.f3).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.f4).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.f5).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.f6).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.f7).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.f8).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.f9).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.f10).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.f11).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.f12).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.prtscr).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.tilde).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.one).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.two).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.three).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.four).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.five).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.six).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.seven).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.eight).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.nine).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.zero).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.dash).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.equal).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.backspace).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.tab).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.q).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.w).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.e).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.r).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.t).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.y).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.u).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.i).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.o).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.p).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.bracket_left).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.bracket_right).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.back_slash).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.capslock).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.a).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.s).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.d).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.f).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.g).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.h).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.j).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.k).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.l).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.semicolon).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.quote).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.enter).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.shift).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.z).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.x).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.c).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.v).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.b).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.n).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.m).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.comma).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.point).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.forward_slash).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.arrow_up).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.mouse).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.ctrl_left).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.fn).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.special).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.alt_left).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.space).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.alt_right).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.ctrl_right).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.arrow_left).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.arrow_down).setOnClickListener(buttonClickListener);
        view.findViewById(R.id.arrow_right).setOnClickListener(buttonClickListener);
    }

    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        boolean capslock = false;

        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.esc:
                    new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "esc");
                    break;

                case R.id.f1:
                    new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "f1");
                    break;

                case R.id.f2:
                    new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "f2");
                    break;

                case R.id.f3:
                    new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "f3");
                    break;

                case R.id.f4:
                    new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "f4");
                    break;

                case R.id.f5:
                    new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "f5");
                    break;

                case R.id.f6:
                    new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "f6");
                    break;

                case R.id.f7:
                    new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "f7");
                    break;

                case R.id.f8:
                    new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "f8");
                    break;

                case R.id.f9:
                    new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "f9");
                    break;

                case R.id.f10:
                    new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "f10");
                    break;

                case R.id.f11:
                    new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "f11");
                    break;

                case R.id.f12:
                    new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "f12");
                    break;

                case R.id.prtscr:
                    new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "prtscr");
                    break;

                case R.id.delete:
                    new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "delete");
                    break;

                case R.id.tilde:
                    new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "~");
                    break;

                case R.id.one:
                    new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "1");
                    break;

                case R.id.two:
                    new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "2");
                    break;

                case R.id.three:
                    new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "3");
                    break;

                case R.id.four:
                    new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "4");
                    break;

                case R.id.five:
                    new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "5");
                    break;

                case R.id.six:
                    new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "6");
                    break;

                case R.id.seven:
                    new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "7");
                    break;

                case R.id.eight:
                    new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "8");
                    break;

                case R.id.nine:
                    new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "9");
                    break;

                case R.id.zero:
                    new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "0");
                    break;

                case R.id.dash:
                    new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "-");
                    break;

                case R.id.equal:
                    new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "=");
                    break;

                case R.id.backspace:
                    new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "backspace");
                    break;

                case R.id.tab:
                    new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "tab");
                    break;

                case R.id.q:
                    if(capslock) new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "Q");
                    else new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "q");
                    break;

                case R.id.w:
                    if(capslock) new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "W");
                    else new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "w");
                    break;

                case R.id.e:
                    if(capslock) new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "E");
                    else new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "e");
                    break;

                case R.id.r:
                    if(capslock) new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "R");
                    else new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "r");
                    break;

                case R.id.t:
                    if(capslock) new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "T");
                    else new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "t");
                    break;

                case R.id.y:
                    if(capslock) new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "Y");
                    else new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "y");
                    break;

                case R.id.u:
                    if(capslock) new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "U");
                    else new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "u");
                    break;

                case R.id.i:
                    if(capslock) new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "I");
                    else new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "i");
                    break;

                case R.id.o:
                    if(capslock) new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "O");
                    else new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "o");
                    break;

                case R.id.p:
                    if(capslock) new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "P");
                    else new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "p");
                    break;

                case R.id.bracket_left:
                    new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "[");
                    break;

                case R.id.bracket_right:
                    new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "]");
                    break;

                case R.id.back_slash:
                    new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "\\");
                    break;

                case R.id.capslock:
                    if(!capslock) capslock = true;
                    else capslock = false;
                    break;

                case R.id.a:
                    if(capslock) new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "A");
                    else new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "a");
                    break;

                case R.id.s:
                    if(capslock) new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "S");
                    else new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "s");
                    break;

                case R.id.d:
                    if(capslock) new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "D");
                    else new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "d");
                    break;

                case R.id.f:
                    if(capslock) new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "F");
                    else new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "f");
                    break;

                case R.id.g:
                    if(capslock) new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "G");
                    else new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "g");
                    break;

                case R.id.h:
                    if(capslock) new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "H");
                    else new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "h");
                    break;

                case R.id.j:
                    if(capslock) new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "J");
                    else new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "j");
                    break;

                case R.id.k:
                    if(capslock) new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "K");
                    else new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "k");
                    break;

                case R.id.l:
                    if(capslock) new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "L");
                    else new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "l");
                    break;

                case R.id.semicolon:
                    if(view.findViewById(R.id.shift).isPressed())
                        new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, ":");
                    else
                        new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, ";");
                    break;

                case R.id.quote:
                    if(view.findViewById(R.id.shift).isPressed())
                        new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "\"");
                    else
                        new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "'");
                    break;

                case R.id.enter:
                    new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "enter");
                    break;

                 //shift

                case R.id.z:
                    if(capslock) new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "Z");
                    else new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "z");
                    break;

                case R.id.x:
                    if(capslock) new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "X");
                    else new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "x");
                    break;

                case R.id.c:
                    if(capslock) new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "C");
                    else new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "c");
                    break;

                case R.id.v:
                    if(capslock) new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "V");
                    else new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "v");
                    break;

                case R.id.b:
                    if(capslock) new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "B");
                    else new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "b");
                    break;

                case R.id.n:
                    if(capslock) new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "N");
                    else new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "n");
                    break;

                case R.id.m:
                    if(capslock) new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "M");
                    else new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "m");
                    break;

                case R.id.comma:
                    if(view.findViewById(R.id.shift).isPressed())
                        new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "<");
                    else
                        new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, ",");
                    break;

                case R.id.point:
                    if(view.findViewById(R.id.shift).isPressed())
                        new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, ">");
                    else
                        new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, ".");
                    break;

                case R.id.forward_slash:
                    if(view.findViewById(R.id.shift).isPressed())
                        new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "?");
                    else
                        new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "/");
                    break;

                case R.id.arrow_up:
                    new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "up");
                    break;

                case R.id.mouse:
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_area, new MouseFragment());
                    fragmentTransaction.commit();
                    break;

                case R.id.ctrl_left:
                    break;

                case R.id.fn:
                    break;

                case R.id.alt_left:
                    break;

                case R.id.space:
                    new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, " ");
                    break;

                case R.id.alt_right:
                    break;

                case R.id.ctrl_right:
                    break;

                case R.id.arrow_left:
                    new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "left");
                    break;

                case R.id.arrow_down:
                    new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "down");
                    break;

                case R.id.arrow_right:
                    new sendTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "right");
                    break;
            }
        }
    };

    private class sendTask extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params) {
            net.send(params[0]);
            return null;
        }
    }
}
