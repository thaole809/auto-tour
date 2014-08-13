package com.product.autotourapp.ui.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class EnterPasswordDialog extends DialogFragment{
	private View contentView;
	private EditText etPassword;
	
	public interface IEnterPassDelegate{
		public void onEnterPassSuccess();
		public void onEnterPassFails();
	}
	
	private IEnterPassDelegate delegate;
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
//		contentView = getActivity().getLayoutInflater().inflate(R.layout.dialog_enter_setting_password, null);
		Dialog dialog = new Dialog(getActivity());
//		dialog.setTitle(getString(R.string.enter_pass));
//		dialog.setContentView(contentView);
//		initViews();
//		addEvents();
		return dialog;
	}
	
	public void setDelegate(IEnterPassDelegate delegate) {
		this.delegate = delegate;
	}
	
	private void initViews() {
//		etPassword = (EditText) contentView.findViewById(R.id.et_enter_password);
	}
	
	private void addEvents(){
//		contentView.findViewById(R.id.bt_enter_pass_ok).setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				String settingPassString = StorageManager.loadSettingPassCache(getActivity());
//				if (settingPassString.equals(etPassword.getText().toString())) {
//					if (delegate != null) {
//						delegate.onEnterPassSuccess();
//					}
//				} else {
//					if (delegate != null) {
//						delegate.onEnterPassFails();
//					}
//				}
//				dismiss();
//			}
//		});
//		contentView.findViewById(R.id.bt_enter_pass_cancel).setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				dismiss();
//			}
//		});
	}
}
