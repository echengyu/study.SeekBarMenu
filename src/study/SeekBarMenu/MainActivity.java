package study.SeekBarMenu;

import java.util.ArrayList;

import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;
import study.SeekBarMenu.Adapter.SeekBarListener;

public class MainActivity extends Activity implements OnNavigationListener {

	TextView TextView1, TextView2, TextView3, TextView4;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TextView1 = (TextView) findViewById(R.id.TextView1);
		TextView2 = (TextView) findViewById(R.id.TextView2);
		TextView3 = (TextView) findViewById(R.id.TextView3);
		TextView4 = (TextView) findViewById(R.id.TextView4);
		
		ActionBar bar = getActionBar();
		ArrayList<String> list = new ArrayList<String>();
		list.add("bar 0 ");
		list.add("bar 2 ");
		list.add("bar 3 ");
		list.add("bar 4 ");
		Adapter adapter = new Adapter();

		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		bar.setListNavigationCallbacks(adapter.getAdapter(this, list, "Controls"), this);
		adapter.setSeekBarListener( new SeekBarListener() {

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser, int positionInList) {
				Log.e("", "onProgressChanged " + progress + " position in list" + positionInList);
				
				if(positionInList == 0){
					TextView1.setText("onProgressChanged " + progress + " position in list" + positionInList);
				}
				if(positionInList == 1){
					TextView2.setText("onProgressChanged " + progress + " position in list" + positionInList);
				}
				if(positionInList == 2){
					TextView3.setText("onProgressChanged " + progress + " position in list" + positionInList);
				}
				if(positionInList == 3){
					TextView4.setText("onProgressChanged " + progress + " position in list" + positionInList);
				}
				
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar, int positionInList) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar, int positionInList) {
				// TODO Auto-generated method stub

			}

		});
	}

	@Override
	public boolean onNavigationItemSelected(int itemPosition, long itemId) {
		// TODO Auto-generated method stub
		return false;
	}
}
