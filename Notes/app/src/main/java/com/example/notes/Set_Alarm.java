package com.example.notes;

import android.content.Intent;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Set_Alarm extends AppCompatActivity {

    EditText mHourEditText;
    EditText mMinuteEditText;

    Button mSetAlarmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set__alarm);

        mHourEditText = (EditText) findViewById(R.id.hour_edit_text);
        mMinuteEditText = (EditText) findViewById(R.id.minute_edit_text);
        mSetAlarmButton = (Button) findViewById(R.id.set_alarm_button);

        mSetAlarmButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int hour = Integer.parseInt(mHourEditText.getText().toString());
                int minute = Integer.parseInt(mMinuteEditText.getText().toString());

                Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                intent.putExtra(AlarmClock.EXTRA_HOUR, hour);
                intent.putExtra(AlarmClock.EXTRA_MINUTES, minute);

                if (hour <= 24 && minute <= 60) {
                    startActivity(intent);
                }
            }

        });
    }
}
