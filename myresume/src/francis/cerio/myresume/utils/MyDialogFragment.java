package francis.cerio.myresume.utils;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockDialogFragment;
import com.actionbarsherlock.view.Window;

import francis.cerio.myresume.R;

public class MyDialogFragment extends SherlockDialogFragment {

	private int position;
	private static MyDialogFragment dialogFragment;

	public static MyDialogFragment newInstance(int position) {
		MyDialogFragment dialog = new MyDialogFragment();

		Bundle bundle = new Bundle();
		bundle.putInt("position", position);
		dialog.setArguments(bundle);
		dialogFragment = dialog;

		return dialog;

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		position = getArguments().getInt("position");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = null;
		dialogFragment.getDialog().requestWindowFeature(
				(int) Window.FEATURE_NO_TITLE);
		if (position == 2) {
			view = inflater.inflate(R.layout.qualifications, container, false);
		} else if (position == 4) {
			// education
			view = inflater.inflate(R.layout.education, container, false);
		} else if (position == 5) {
			view = inflater.inflate(R.layout.additionalinfo, container, false);
		}

		return view;
	}
}
