package com.product.autotourapp.ui.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class BaseListViewAdaper<T> extends BaseAdapter{
	
	private ArrayList<T> data;
	private Context context;
	private LayoutInflater inflater;
	public BaseListViewAdaper(Context context) {
		this.context = context;
		this.data = new ArrayList<T>();
		this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	public void addData(T model){
		data.add(model);
		notifyDataSetChanged();
	}
	
	public void addData(List<T> models) {
		if (models == null) {
			return;
		}
		
		for (T model : models) {
			data.add(model);
		}
		
		notifyDataSetChanged();
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
		View view;
		if (convertView == null) {
			view = inflater.inflate(getLayoutResouceId(), null);
		} else {
			view = convertView;
		}
		T model = data.get(position);
		view = makeContentForRow(position, view, model); 
		return view;
	}
	
	protected abstract View makeContentForRow (int position, View rowView, T model);
	protected abstract int getLayoutResouceId();

}
