package com.example.yoga.dateandtimepickers;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText txtDate,txtTime;
    Button time,date;
    private int mYear,mMonth,mDay,mHour,mMin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtDate= (EditText) findViewById(R.id.txtDate);
        txtTime=(EditText)findViewById(R.id.txtTime);
        time= (Button) findViewById(R.id.time);
        date= (Button) findViewById(R.id.date);
        time.setOnClickListener(this);
        date.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View view) {
        if (view==date)
        {
            final Calendar c=Calendar.getInstance();
            mYear=c.get(Calendar.YEAR);
            mMonth=c.get(Calendar.MONTH);
                mDay=c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                    txtDate.setText(i2+"-"+(i1+1)+"-"+i);
                }
            },mYear,mMonth,mDay);
            datePickerDialog.show();
        }

        if (view==time)
        {
            final Calendar c=Calendar.getInstance();
            mHour=c.get(Calendar.HOUR_OF_DAY);
            mMin=c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int i, int i1) {
                    txtTime.setText(i+":"+i1);
                }
            },mHour,mMin,false);
            timePickerDialog.show();
        }
    }
}
