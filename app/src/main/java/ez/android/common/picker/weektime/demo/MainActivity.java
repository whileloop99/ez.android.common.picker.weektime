package ez.android.common.picker.weektime.demo;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import ez.android.common.picker.weektime.WeekTimePickerDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.enable).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.enable:
                WeekTimePickerDialog dialog = new WeekTimePickerDialog(this);
                dialog.setOnClickListener((dialog1, which) -> {
                    dialog.getPicker();
                });
                dialog.show();
                break;
        }
    }

}