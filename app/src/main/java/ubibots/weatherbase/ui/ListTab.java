package ubibots.weatherbase.ui;

import android.graphics.Color;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ubibots.weatherbase.R;
import ubibots.weatherbase.DisplayHistoryActivity;

public class ListTab {

    private int currentTab;
    private ListView listView;
    private LinearLayout point;

    public int getCurrentTab() {
        return currentTab;
    }

    public ListView getListView() {
        return listView;
    }

    public ListTab() {
        point = (LinearLayout)DisplayHistoryActivity.getActivity().findViewById(R.id.point);

        listView = (ListView) DisplayHistoryActivity.getActivity().findViewById(R.id.listview);
        listView.setBackgroundColor(Color.GRAY);
        listView.setCacheColorHint(0);
        final List<String> data = new ArrayList<>();
        data.add("每时");
        data.add("每日");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(DisplayHistoryActivity.getActivity(), android.R.layout.simple_expandable_list_item_1, data);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            String click = data.get(position);
            switch (click) {
                case "每时":
                    hourVisible();
                    currentTab = 0;
                    break;
                case "每日":
                    dayVisible();
                    currentTab = 1;
                    break;
            }
        });
        hourVisible();
        currentTab = 0;
    }

    private void hourVisible() {
        if (HourView.getHourViewPager() != null) {
            HourView.getHourViewPager().setVisibility(View.VISIBLE);
            dayInvisible();
        }
        if (HourView.getHourProgressBar().getVisibility() != View.GONE) {
            HourView.getHourProgressBar().setVisibility(View.VISIBLE);
        }
        if (point != null) {
            point.setVisibility(View.VISIBLE);
        }
    }

    private void hourInvisible() {
        if (HourView.getHourViewPager() != null) {
            HourView.getHourViewPager().setVisibility(View.INVISIBLE);
            if (HourView.getHourProgressBar().getVisibility() != View.GONE) {
                HourView.getHourProgressBar().setVisibility(View.INVISIBLE);
            }
        }
    }

    private void dayVisible() {
        if (DayView.getDayViewPager() != null) {
            DayView.getDayViewPager().setVisibility(View.VISIBLE);
            hourInvisible();
        }
        if (DayView.getDayProgressBar().getVisibility() != View.GONE) {
            DayView.getDayProgressBar().setVisibility(View.VISIBLE);
        }
        if (point != null) {
            point.setVisibility(View.VISIBLE);
        }
    }

    private void dayInvisible() {
        if (DayView.getDayViewPager() != null) {
            DayView.getDayViewPager().setVisibility(View.INVISIBLE);
            if (DayView.getDayProgressBar().getVisibility() != View.GONE) {
                DayView.getDayProgressBar().setVisibility(View.INVISIBLE);
            }
        }
    }
}
