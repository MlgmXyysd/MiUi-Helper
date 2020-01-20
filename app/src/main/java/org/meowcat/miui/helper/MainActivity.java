package org.meowcat.miui.helper;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import org.meowcat.bugcatcher.MeowCatApplication;

import java.io.File;
import java.io.IOException;

@SuppressLint("Registered")
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView mXposedTextView = findViewById(R.id.tv_xposed_status);
        if (getXposedStatus(false)) {
            mXposedTextView.setText(R.string.xposed_enabled);
        } else {
            mXposedTextView.setText(R.string.xposed_disabled);
        }
    }

    public boolean getXposedStatus(boolean status) {
        return status;
    }
}
