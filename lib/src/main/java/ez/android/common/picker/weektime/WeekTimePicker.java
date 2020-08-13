package ez.android.common.picker.weektime;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeekTimePicker extends FrameLayout {
    private TimePicker mTimePicker;
    private LinearLayout mWeeks;

    public WeekTimePicker(@NonNull Context context) {
        this(context, null, 0);
    }

    public WeekTimePicker(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WeekTimePicker(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, 0, 0);
    }

    public WeekTimePicker(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.week_time_picker, this, false);
        addView(view);

        mTimePicker = view.findViewById(R.id.timePicker);
        mWeeks = view.findViewById(R.id.weeks);
    }
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.week_time_picker, container, false);
//    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        mTimePicker = view.findViewById(R.id.time);
//        mWeeks = view.findViewById(R.id.weeks);
//    }

    /**
     * Get selected hour
     * @return
     */
    public int getHour() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return mTimePicker.getHour();
        } else {
            return mTimePicker.getCurrentHour();
        }
    }

    /**
     * Set current hour
     * @param hour
     */
    public void setHour(int hour) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mTimePicker.setHour(hour);
        } else {
            mTimePicker.setCurrentHour(hour);
        }
    }

    /**
     * Get selected minute
     * @return
     */
    public int getMinute() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return mTimePicker.getMinute();
        } else {
            return mTimePicker.getCurrentMinute();
        }
    }

    /**
     * Set current minute
     * @param minute
     */
    public void setMinute(int minute) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mTimePicker.setMinute(minute);
        } else {
            mTimePicker.setCurrentMinute(minute);
        }
    }

    /**
     * Get selected weeks {@link Calendar}
     * @return
     */
    public List<Integer> getWeeks() {
        List<Integer> mSelectedWeeks = new ArrayList<>();
        for(int i = 0; i < mWeeks.getChildCount(); i++) {
            CheckBox checkBox = (CheckBox) mWeeks.getChildAt(i);
            mSelectedWeeks.add(Integer.parseInt(checkBox.getTag().toString()));
        }
        return mSelectedWeeks;
    }

    /**
     * Set selected weeks
     * @return
     */
    public void setWeeks(List<Integer> weeks) {
        for(int i = 0; i < mWeeks.getChildCount(); i++) {
            CheckBox checkBox = (CheckBox) mWeeks.getChildAt(i);
            checkBox.setChecked(weeks.contains(Integer.parseInt(checkBox.getTag().toString())));
        }
    }
}
