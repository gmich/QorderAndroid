package com.example.clientalphaprototype;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class Details extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details);
		
		String title = "title";

		Bundle extras = getIntent().getExtras();

		if (extras != null) {
			title = extras.getString("product");
		}
		initializeActionBar();
		ParseJson(title);		
		
	}
	
	void initializeActionBar()
	{
		  ActionBar actionBar = getActionBar();

		    actionBar.setCustomView(R.layout.actionbar_view);
		    actionBar.setDisplayShowCustomEnabled(true);
		    actionBar.getCustomView().setOnClickListener(new OnClickListener() {
		        @Override
		        public void onClick(View view) {
					Intent i = new Intent(getApplicationContext(), Basket.class);
					startActivity(i);
		        }
		    });
		    actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM | ActionBar.DISPLAY_SHOW_HOME);
	}
	
	void ParseJson(String product)
	{
		TextView tv_title = (TextView)findViewById(R.id.textView_title);
		tv_title.setText(product);
		
		TextView tv_description = (TextView)findViewById(R.id.textView_description);
		tv_description.setText("A description for " + product + " goes here" );
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.details, menu);
		return true;
	}

}