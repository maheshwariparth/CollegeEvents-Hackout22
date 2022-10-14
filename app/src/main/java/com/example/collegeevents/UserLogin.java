package com.example.collegeevents;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;
import com.google.api.services.calendar.Calendar;

public class UserLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_login);
        TextView textView = (TextView) findViewById(R.id.login_sign);
        Typeface typeface= Typeface.createFromAsset(getAssets(),"assets/fonts/lobster.ttf");
        textView.setTypeface(typeface);
    }
}