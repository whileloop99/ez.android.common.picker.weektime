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

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class WeekTimePicker extends FrameLayout {
    private TimePicker mTimePicker;
    private LinearLayout mWeeks;
    private Map<Integer, Boolean> mSelectedWeeks = new HashMap<>();

    {
        mSelectedWeeks.put(Calendar.MONDAY, false);
        mSelectedWeeks.put(Calendar.TUESDAY, false);
        mSelectedWeeks.put(Calendar.WEDNESDAY, false);
        mSelectedWeeks.put(Calendar.THURSDAY, false);
        mSelectedWeeks.put(Calendar.FRIDAY, false);
        mSelectedWeeks.put(Calendar.SATURDAY, false);
        mSelectedWeeks.put(Calendar.SUNDAY, false);
    }

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
     *
     * @return
     */
    public Map<Integer, Boolean> getWeeks() {
        for(int i = 0; i < mWeeks.getChildCount(); i++) {
            CheckBox checkBox = (CheckBox) mWeeks.getChildAt(i);
            mSelectedWeeks.put(Integer.parseInt(checkBox.getTag().toString()), checkBox.isChecked());
        }
        return mSelectedWeeks;
    }
}
