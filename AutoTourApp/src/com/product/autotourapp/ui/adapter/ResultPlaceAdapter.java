package com.product.autotourapp.ui.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.product.autotourapp.data.model.PlaceResultModel;

public class ResultPlaceAdapter extends BaseAdapter{

	private Context context;
	private ArrayList<PlaceResultModel> data;
	
	public interface IResultPlaceAdapterDelegate {
		public void handleClickAddInfo(PlaceResultModel model);
		public void handleClickAddRevenue(PlaceResultModel model);
	}
	
	
	private IResultPlaceAdapterDelegate delegate;
	
	public ResultPlaceAdapter(Context context, ArrayList<PlaceResultModel> data, IResultPlaceAdapterDelegate delegate) {
		this.context = context;
		this.data = data;
		this.delegate = delegate;
	}
	
	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
//		if (convertView == null) {
//			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//			convertView = inflater.inflate(R.layout.result_row, null);
//		}

		return convertView;
	}

}
