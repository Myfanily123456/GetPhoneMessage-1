package com.example.configurationtest;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.method.Touch;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

//获取系统设备状态
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
				Configuration cfg = getResources().getConfiguration(); //获取系统的Configuration对象
				String screen = cfg.orientation == Configuration.ORIENTATION_LANDSCAPE ? "横向屏幕" : "竖向屏幕";
				String mncCode = cfg.mnc + "";
				String naviName = cfg.orientation == Configuration.NAVIGATION_NONAV ? "没有方向控制":
					cfg.orientation == Configuration.NAVIGATION_WHEEL ? "滚轮控制方向":
						cfg.orientation == Configuration.NAVIGATION_DPAD ? "方向键控制方向":"轨迹球控制方向";
				navigation.setText(naviName);
				String touchName = cfg.touchscreen == Configuration.TOUCHSCREEN_NOTOUCH ? "无触摸屏":
					cfg.orientation == Configuration.TOUCHSCREEN_STYLUS ? "触摸笔式触摸屏":"接受手指的触摸屏";
				ori.setText(screen);
				mnc.setText(mncCode);
				touch.setText(touchName);
			}
		});   
        
    }
}
