package com.example.mbankguitester.utils;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.example.mbankclient.beans.Deposit;
import com.example.mbankclient.beans.MbankClientActivity;

public class MbankDataContainer {

	private static final int MILLIS_IN_SECOND = 1000;
	private static final int SECONDS_IN_MINUTE = 60;
	private static final int MINUTES_IN_HOUR = 60;
	private static final int HOURS_IN_DAY = 24;
	private static final int DAYS_IN_YEAR = 365; // I know this value is more
													// like 365.24...
	private static final long MILLISECONDS_IN_YEAR = (long) MILLIS_IN_SECOND
			* SECONDS_IN_MINUTE * MINUTES_IN_HOUR * HOURS_IN_DAY * DAYS_IN_YEAR;

	public static MbankDataContainer container;
	private List<Deposit> deposits;
	private List<MbankClientActivity> activities;

	public static MbankDataContainer getInstance() {
		if (container == null) {
			container = new MbankDataContainer();
		}
		return container;
	}

	private MbankDataContainer() {
		initData();
	}

	private void initData() {
		deposits = new ArrayList<Deposit>();
		activities = new ArrayList<MbankClientActivity>();

		deposits.add(new Deposit(1, 1, 500, "LONG", 550, new Date(System
				.currentTimeMillis()), new Date(System.currentTimeMillis()
				+ MILLISECONDS_IN_YEAR)));
		deposits.add(new Deposit(2, 1, 1500, "LONG", 1550, new Date(System
				.currentTimeMillis()), new Date(System.currentTimeMillis()
				+ MILLISECONDS_IN_YEAR)));
		deposits.add(new Deposit(3, 1, 2500, "LONG", 2550, new Date(System
				.currentTimeMillis()), new Date(System.currentTimeMillis()
				+ 2 * MILLISECONDS_IN_YEAR)));
		
		activities.add(new MbankClientActivity(1, 1, 50, new Date(System
				.currentTimeMillis()), 50, "Withdrawing"));
		activities.add(new MbankClientActivity(2, 1, 250, new Date(System
				.currentTimeMillis()), 50, "Depositing"));
		activities.add(new MbankClientActivity(3, 1, 80, new Date(System
				.currentTimeMillis()), 50, "Withdrawing"));
	}

	public List<MbankClientActivity> getActivities() {
		return activities;
	}

	public List<Deposit> getDeposits() {
		return deposits;
	}
}
