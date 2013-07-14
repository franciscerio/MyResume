package francis.cerio.myresume.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import francis.cerio.myresume.R;

public class TechnicalSkillsAdapter extends BaseAdapter {

	private Context context;
	private ArrayList<String> data = new ArrayList<String>();

	public TechnicalSkillsAdapter(Context context, ArrayList<String> data) {
		this.context = context;
		this.data = data;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return data.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

		ViewHolder holder;
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.item_list, parent, false);
			holder = new ViewHolder();
			holder.mTextView = (TextView) convertView
					.findViewById(R.id.txtName);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.mTextView.setText(data.get(position));

		return convertView;
	}

	class ViewHolder {
		public TextView mTextView;
	}

}
