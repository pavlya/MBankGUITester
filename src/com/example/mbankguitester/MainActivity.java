package com.example.mbankguitester;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ExpandableListView;
import android.widget.ListView;

import com.example.mbankclient.beans.Deposit;
import com.example.mbankclient.beans.MbankClientActivity;
import com.example.mbankguitester.utils.ExpandableActivityView;
import com.example.mbankguitester.utils.ExpandableDepositView;
import com.example.mbankguitester.utils.MbankDataContainer;

public class MainActivity extends Activity {

	private ListView lvTest;
	private int resourceID;
	private com.example.mbankguitester.utils.DepositAdapter depositAdapter;
	private ExpandableDepositView expandableDepositView;
	private ExpandableActivityView expandableActivityView;

	public static String MBANK_GUI_TESTER = "Mbank_Gui_tester";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(MBANK_GUI_TESTER, "onCreate");
		super.onCreate(savedInstanceState);
		List<Deposit> deposits = MbankDataContainer.getInstance().getDeposits();
		List<MbankClientActivity> activities = MbankDataContainer.getInstance().getActivities();
		
		setContentView(R.layout.activity_main);
		lvTest = (ListView) findViewById(R.id.lv_myListView);
		Log.d(MBANK_GUI_TESTER, "onCreate.lvTest: " +lvTest.toString());

		
		Log.d(MBANK_GUI_TESTER, "onCreate: " + "getDeposits");
		depositAdapter = new com.example.mbankguitester.utils.DepositAdapter(this, deposits);
		
		// change between views to see the effect
		expandableDepositView = new ExpandableDepositView(this, deposits);
		expandableActivityView = new ExpandableActivityView(this, activities);
		ExpandableListView exListView = (ExpandableListView)findViewById(R.id.elv_myExpandableVuew);
		exListView.setAdapter(expandableActivityView);

		resourceID = R.layout.layout_mbank_deposit_small;
		Log.d(MBANK_GUI_TESTER, "onCreate." + "resourceID: " +resourceID);
//		Log.d(MBANK_GUI_TESTER, "onCreate.depostsAdapter: " +depositsAdapter.toString());
//		lvTest.setAdapter(depositAdapter);
		
	}

	private List<String> getTestStrings() {
		List<String> testStringArray = new ArrayList<String>();
		testStringArray.add("Hello");
		testStringArray.add("Word");
		testStringArray.add("!!!");
		return testStringArray;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
