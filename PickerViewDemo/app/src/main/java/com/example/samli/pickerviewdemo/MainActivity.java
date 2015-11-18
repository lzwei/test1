package com.example.samli.pickerviewdemo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class MainActivity extends ActionBarActivity {

    private ArrayList<String> options1Items = new ArrayList<String>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<ArrayList<String>>();
    private ArrayList<ArrayList<ArrayList<String>>> options3Items = new ArrayList<ArrayList<ArrayList<String>>>();
    private TextView tvTime, tvOptions;
    TimePopupWindow pwTime;
    OptionsPopupWindow pwOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTime=(TextView) findViewById(R.id.tvTime);
        tvOptions=(TextView) findViewById(R.id.tvOptions);
        //ʱ��ѡ����
        pwTime = new TimePopupWindow(this, Type.ALL);
        //ʱ��ѡ���ص�
        pwTime.setOnTimeSelectListener(new OnTimeSelectListener() {

            @Override
            public void onTimeSelect(Date date) {
                tvTime.setText(getTime(date));
            }
        });
        //����ʱ��ѡ����
        tvTime.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                pwTime.showAtLocation(tvTime, Gravity.BOTTOM, 0, 0,new Date());
            }
        });

        //ѡ��ѡ����
        pwOptions = new OptionsPopupWindow(this);

        //ѡ��1
        options1Items.add("�㶫");
        options1Items.add("����");

        //ѡ��2
        ArrayList<String> options2Items_01=new ArrayList<String>();
        options2Items_01.add("����");
        options2Items_01.add("��ɽ");
        options2Items_01.add("��ݸ");
        ArrayList<String> options2Items_02=new ArrayList<String>();
        options2Items_02.add("��ɳ");
        options2Items_02.add("����");
        options2Items.add(options2Items_01);
        options2Items.add(options2Items_02);

        //ѡ��3
        ArrayList<ArrayList<String>> options3Items_01 = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> options3Items_02 = new ArrayList<ArrayList<String>>();
        ArrayList<String> options3Items_01_01=new ArrayList<String>();
        options3Items_01_01.add("����");
        options3Items_01_01.add("���");
        options3Items_01_01.add("����");
        options3Items_01_01.add("Խ��");
        options3Items_01.add(options3Items_01_01);
        ArrayList<String> options3Items_01_02=new ArrayList<String>();
        options3Items_01_02.add("�Ϻ�");
        options3Items_01.add(options3Items_01_02);
        ArrayList<String> options3Items_01_03=new ArrayList<String>();
        options3Items_01_03.add("��ƽ");
        options3Items_01_03.add("����");
        options3Items_01.add(options3Items_01_03);

        ArrayList<String> options3Items_02_01=new ArrayList<String>();
        options3Items_02_01.add("��ɳ1");
        options3Items_02.add(options3Items_02_01);
        ArrayList<String> options3Items_02_02=new ArrayList<String>();
        options3Items_02_02.add("��1");
        options3Items_02.add(options3Items_02_02);

        options3Items.add(options3Items_01);
        options3Items.add(options3Items_02);

        //��������Ч��
        pwOptions.setPicker(options1Items, options2Items, options3Items, true);
        //����ѡ���������λ
        pwOptions.setLabels("ʡ", "��", "��");
        //����Ĭ��ѡ�е�������Ŀ
        pwOptions.setSelectOptions(0, 0, 0);
        //����ȷ��ѡ��ť
        pwOptions.setOnoptionsSelectListener(new OptionsPopupWindow.OnOptionsSelectListener() {

            @Override
            public void onOptionsSelect(int options1, int option2, int options3) {
                //���صķֱ������������ѡ��λ��
                String tx = options1Items.get(options1)
                        +options2Items.get(options1).get(option2)
                        +options3Items.get(options1).get(option2).get(options3);
                tvOptions.setText(tx);
            }
        });
        //�������ѡ��ѡ����
        tvOptions.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                pwOptions.showAtLocation(tvTime, Gravity.BOTTOM, 0, 0);
            }
        });
    }

    public static String getTime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return format.format(date);
    }

}
