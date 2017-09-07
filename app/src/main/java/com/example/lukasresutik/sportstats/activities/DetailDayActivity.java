package com.example.lukasresutik.sportstats.activities;

import android.graphics.RectF;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.alamkanak.weekview.MonthLoader;
import com.alamkanak.weekview.WeekView;
import com.alamkanak.weekview.WeekViewEvent;
import com.example.lukasresutik.sportstats.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DetailDayActivity extends AppCompatActivity implements WeekView.EventClickListener, MonthLoader.MonthChangeListener, WeekView.EventLongPressListener {

    private WeekView mWeekView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_day);
        init();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.hide();
    }

    private void init() {
        mWeekView = (WeekView) findViewById(R.id.weekView);
        mWeekView.setOnEventClickListener(this);
        mWeekView.setMonthChangeListener(this);
        mWeekView.setEventLongPressListener(this);
        mWeekView.setNumberOfVisibleDays(1);
    }

    @Override
    public void onEventClick(WeekViewEvent event, RectF eventRect) {
        Log.d("CLICK", "Kliknutie na udalost");
    }


    @Override
    public List<? extends WeekViewEvent> onMonthChange(int newYear, int newMonth) {
        List<WeekViewEvent> events = new ArrayList<WeekViewEvent>();

        Calendar startTime = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, 14);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        Calendar endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.HOUR, 3);

        WeekViewEvent event = new WeekViewEvent(1,"Testovanie vyvoja kalendar",startTime,endTime);
        event.setColor(getResources().getColor(R.color.colorPrimary));
        events.add(event);
        return events;
    }

    @Override
    public void onEventLongPress(WeekViewEvent event, RectF eventRect) {

    }
}
