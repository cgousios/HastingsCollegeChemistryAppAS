package edu.hastings.HastingsCollegeChemistry;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import edu.hastings.HastingsCollegeChemistry.Menus.MainMenuList;

public class MyActivity extends Activity {
/**
 * Called when the activity is first created.
 */

private final long SPLASH_TIME_OUT = 1500;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.splash);
}

@Override
protected void onResume(){
    super.onResume();

    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            MyActivity.this.finish();
            Intent intent = new Intent(MyActivity.this, MainMenuList.class);
            MyActivity.this.startActivity(intent);
        }
    }, SPLASH_TIME_OUT);
}
}
