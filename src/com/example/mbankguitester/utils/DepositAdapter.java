package com.example.mbankguitester.utils;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mbankclient.beans.Deposit;
import com.example.mbankguitester.R;

public class DepositAdapter extends BaseAdapter {
	Context ctx;
	LayoutInflater lInflater;
	List<Deposit> objects;

	public DepositAdapter(Context context, List<Deposit> deposits) {
		ctx = context;
		objects = deposits;
		lInflater = (LayoutInflater) ctx
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	// number of elements
	@Override
	public int getCount() {
		return objects.size();
	}

	// element by position
	@Override
	public Object getItem(int position) {
		return objects.get(position);
	}

	// id of position
	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// use created but unused views
		View view = convertView;
		if (view == null) {
			view = lInflater.inflate(R.layout.layout_mbank_deposit, parent,
					false);
		}

		Deposit deposit = getDeposit(position);
		String balanceString = String.valueOf(deposit.getBalance());
		String estimatedBalanceString = String.valueOf(deposit
				.getEstimated_balance());
		String openingDate = deposit.getOpening_date().toString();
		String closingDate = deposit.getClosing_date().toString();

		TextView tvBalance = (TextView) view.findViewById(R.id.tv_balance);
		TextView tvEstimatedBalance = (TextView) view
				.findViewById(R.id.tv_estimated_balance);
		TextView tvOpeningDate = (TextView) view
				.findViewById(R.id.tv_opening_date);
		TextView tvClosingDate = (TextView) view
				.findViewById(R.id.tv_closing_date);

		tvBalance.setText(balanceString);
		tvEstimatedBalance.setText(estimatedBalanceString);
		tvOpeningDate.setText(openingDate);
		tvClosingDate.setText(closingDate);
		return view;
	}

	// deposit according to position
	public Deposit getDeposit(int position) {
		return (Deposit) getItem(position);
	}

}
