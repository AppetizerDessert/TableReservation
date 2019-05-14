package c346.rp.edu.reservation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;

public class MainActivity extends AppCompatActivity {


    EditText etName;
    EditText etPhone;
    EditText etPax;
    CheckBox cbSmoking;
    Button btnConfirm;
    Button btnClear;
    Button btnReset;
    TextView tvDisplay;
    DatePicker dp;
    TimePicker tp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.Name);
        etPhone = findViewById(R.id.Phone);
        etPax = findViewById(R.id.Pax);
        cbSmoking = findViewById(R.id.Smoking);
        btnClear = findViewById(R.id.Clear);
        btnConfirm = findViewById(R.id.confirm);
        btnReset = findViewById(R.id.reset);
        tvDisplay = findViewById(R.id.TextViewDisplay);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);


        tvDisplay.setText(tp.getCurrentHour() + ":" + tp.getCurrentMinute());
        tvDisplay.setText(dp.getDayOfMonth() + "/" + (dp.getMonth()+1) + "/" + dp.getYear());

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time = "Time is " + tp.getCurrentHour() + ":" + tp.getCurrentMinute();
                int day = dp.getDayOfMonth();
                int month = dp.getMonth();
                int year = dp.getYear();
                String date = "Date is " + day + "/" + month + "/" + year;
                String smoke = "";
                if (cbSmoking.isChecked()){
                    smoke = "Smoking Corner";
                } else {
                    smoke = "Non-smoking Corner";
                }
                String message = ("Name is " + etName.getText().toString() + "\nPhone is " + etPhone.getText().toString() + "\nPax is " +
                        etPax.getText().toString()+ "\n" +smoke + "\n" + date + "\n" + time );
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tp.setCurrentHour(12);
                tp.setCurrentMinute(00);
                dp.updateDate(2019, 5, 1);
            }
        });


    }
}
