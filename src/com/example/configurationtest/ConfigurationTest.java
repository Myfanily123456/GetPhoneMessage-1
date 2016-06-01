package com.example.configurationtest;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.method.Touch;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

//��ȡϵͳ�豸״̬
public class ConfigurationTest extends Activity {
	
	EditText ori;
	EditText navigation;
	EditText touch;
	EditText mnc;
	Button bn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ori = (EditText)findViewById(R.id.ori);
        navigation = (EditText)findViewById(R.id.navigation);
        touch = (EditText)findViewById(R.id.touch);
        mnc = (EditText)findViewById(R.id.mnc);
        bn = (Button)findViewById(R.id.bn);
        
        bn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View source) {
				Configuration cfg = getResources().getConfiguration(); //��ȡϵͳ��Configuration����
				String screen = cfg.orientation == Configuration.ORIENTATION_LANDSCAPE ? "������Ļ" : "������Ļ";
				String mncCode = cfg.mnc + "";
				String naviName = cfg.orientation == Configuration.NAVIGATION_NONAV ? "û�з������":
					cfg.orientation == Configuration.NAVIGATION_WHEEL ? "���ֿ��Ʒ���":
						cfg.orientation == Configuration.NAVIGATION_DPAD ? "��������Ʒ���":"�켣����Ʒ���";
				navigation.setText(naviName);
				String touchName = cfg.touchscreen == Configuration.TOUCHSCREEN_NOTOUCH ? "�޴�����":
					cfg.orientation == Configuration.TOUCHSCREEN_STYLUS ? "������ʽ������":"������ָ�Ĵ�����";
				ori.setText(screen);
				mnc.setText(mncCode);
				touch.setText(touchName);
			}
		});   
        
    }
}
