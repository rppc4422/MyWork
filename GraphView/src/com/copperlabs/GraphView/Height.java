package com.copperlabs.GraphView;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;

public class Height extends Activity {
	MyView myView;
	LinearLayout ll;
	static double baby_months[] = {0,3,5,7};
	static double baby_height[] = {1,2.5,3.3,5};
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graphs);
        
//        myView = new MyView(this,2);
        myView.setBackgroundColor(Color.WHITE);
        myView.setMinimumWidth(840);
        
        ll = (LinearLayout) findViewById(R.id.linlay);
        ll.addView(myView);

    }

   }

