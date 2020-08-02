package ez.android.common.picker.weektime;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;

public class WeekTimePickerDialog extends AlertDialog {
    private WeekTimePicker mPicker;
    private DialogInterface.OnClickListener mOnClickListener;

    public WeekTimePickerDialog(Context context) {
        this(context, 0);
    }

    protected WeekTimePickerDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        this(context, 0);
        setCancelable(cancelable);
        setOnCancelListener(cancelListener);
    }

    protected WeekTimePickerDialog(Context context, int themeResId) {
        super(context, themeResId);

        final Context themeContext = getContext();
        final LayoutInflater inflater = LayoutInflater.from(themeContext);
        final View view = inflater.inflate(R.layout.week_time_picker_dialog, null);
        setView(view);

        this.mPicker = view.findViewById(R.id.weekTimePicker);
        setButton(BUTTON_POSITIVE, themeContext.getString(android.R.string.ok), mOnClickListener);
        setButton(BUTTON_NEGATIVE, themeContext.getString(android.R.string.cancel), mOnClickListener);
    }


    /**
     * Returns the {@link WeekTimePicker} contained in this dialog.
     *
     * @return the date picker
     */
    @NonNull
    public WeekTimePicker getPicker() {
        return mPicker;
    }

    /**
     *
     * @param onClickListener
     */
    public void setOnClickListener(OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        final Context themeContext = getContext();
        setButton(BUTTON_POSITIVE, themeContext.getString(android.R.string.ok), mOnClickListener);
        setButton(BUTTON_NEGATIVE, themeContext.getString(android.R.string.cancel), mOnClickListener);
    }
}
