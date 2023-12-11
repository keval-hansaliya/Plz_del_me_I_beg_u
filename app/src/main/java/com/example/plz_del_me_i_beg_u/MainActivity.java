package com.example.plz_del_me_i_beg_u;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (! Python.isStarted()) {
            Python.start(new AndroidPlatform(this));
        }

        Python py = Python.getInstance();
        PyObject module = py.getModule("script");

        PyObject pyNumber = module.callAttr("get_number");
        int number = pyNumber.toInt(); // Assuming 'number' is an integer
        System.out.println(number);

        PyObject pyString = module.callAttr("get_string");
        String str = pyString.toString(); // Assuming 'str' is a string
        System.out.println(str);

    }
}