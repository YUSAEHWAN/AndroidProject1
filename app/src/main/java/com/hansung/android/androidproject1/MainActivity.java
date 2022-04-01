package com.hansung.android.androidproject1;

import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView titleText;
    private Button prevButton, nextButton;
    private CalendarAdapter mCalendarAdapter;
    private GridView calendarGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleText = findViewById(R.id.titleText);

        prevButton = findViewById(R.id.prevButton);
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {                        // 이전 버튼이 눌리면
                mCalendarAdapter.prevMonth();                    // 달을 이전 달로 바꾸고
                titleText.setText(mCalendarAdapter.getTitle());  // 바뀐 달을 타이틀로 세팅
            }
        });

        nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {                       // 다음 버튼이 눌리면
                mCalendarAdapter.nextMonth();                   // 달을 다음 달로 바꾸고
                titleText.setText(mCalendarAdapter.getTitle()); // 바뀐 달을 타이틀로 세팅
            }
        });

        calendarGridView = findViewById(R.id.calendarGridView);
        mCalendarAdapter = new CalendarAdapter(this);
        calendarGridView.setAdapter(mCalendarAdapter);
        titleText.setText(mCalendarAdapter.getTitle());

        // 달력 클릭 메소드
        calendarGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"" + mCalendarAdapter.toast_show_year_month() + "." + (position-1),Toast.LENGTH_SHORT).show();
            }
        });
    }
}