package cn.org.tpri.www.overload.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

import cn.org.tpri.www.overload.R;

/**
 * 作者:丁文 on 2017/3/8.
 * copyright: www.tpri.org.cn
 */
public class QueryActicity extends AppCompatActivity {

    private EditText vehicle_no;
    private TextView begin_date;
    private TextView end_date;
    private Button bt_guide_star;
    private int year;
    private int month;
    private int day;
    private String begin;
    private Calendar calendar;
    private ImageView activity_query_iv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);
        initView();
        initData();

    }

    private void initData() {
        activity_query_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        begin_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datepicker = new DatePickerDialog(QueryActicity.this, android.R.style.Theme_Material_Light_Dialog_Alert, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        calendar.set(Calendar.YEAR,year);
                        calendar.set(Calendar.MONTH,month);
                        calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                        begin = year + "-" + (month +1) + "-" + dayOfMonth;
                        begin_date.setText(begin);

                    }
                }, year, month, day);

                datepicker.setCancelable(true);
                datepicker.setCanceledOnTouchOutside(true);
                datepicker.show();

            }
        });
        end_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datepicker = new DatePickerDialog(QueryActicity.this, android.R.style.Theme_Material_Light_Dialog_Alert, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        calendar.set(Calendar.YEAR,year);
                        calendar.set(Calendar.MONTH,month);
                        calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                        begin = year + "-" + (month +1) + "-" + dayOfMonth;
                        end_date.setText(begin);

                    }
                }, year, month, day);
                datepicker.setCancelable(true);
                datepicker.setCanceledOnTouchOutside(true);
                datepicker.show();
            }
        });
        bt_guide_star.setOnClickListener(new View.OnClickListener() {

            private String end;
            private String begin;
            private String vehicleNo;

            @Override
            public void onClick(View v) {


                if(vehicle_no.getText() == null || vehicle_no.getText().toString().trim().length() < 1){
                     vehicleNo = "";
                }else {
                    vehicleNo = vehicle_no.getText().toString();
                }
                if(begin_date.getText() == null || begin_date.getText().toString().trim().length() < 1){
                    begin = "";
                }else {
                     begin =  begin_date.getText().toString();
                }
                if(end_date.getText() == null || end_date.getText().toString().trim().length() <1){
                    end = "";
                }else {
                    end =  end_date.getText().toString();
                }

                Intent intent = new Intent(QueryActicity.this,QueryDetails.class);
                intent.putExtra("vehicleNo",vehicleNo);
                intent.putExtra("end",end);
                intent.putExtra("begin",begin);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        vehicle_no = (EditText) findViewById(R.id.vehicle_no);
        begin_date = (TextView) findViewById(R.id.begin_date);
        end_date = (TextView) findViewById(R.id.end_date);
        bt_guide_star = (Button) findViewById(R.id.bt_guide_star);
        activity_query_iv = (ImageView) findViewById(R.id.activity_query_iv);
    }
}
