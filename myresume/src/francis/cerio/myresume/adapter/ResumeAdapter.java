package francis.cerio.myresume.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.tabcarousel.R;

public class ResumeAdapter extends BaseAdapter {

	private Context context;
	private ArrayList<String> data = new ArrayList<String>();
	private View mHeader;
	private ArrayList<Integer> images = new ArrayList<Integer>();

	public ResumeAdapter(Context context, ArrayList<String> data,
			ArrayList<Integer> images) {
		this.context = context;
		this.data = data;
		this.images = images;
		mHeader = LayoutInflater.from(context).inflate(R.layout.faux_carousel,
				null);

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
		if (position == 0) {
			return mHeader;
		}

		// Recycle ViewHolder's items
		ViewHolder holder;
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(R.layout.list,
					parent, false);
			holder = new ViewHolder();
			holder.mTextView = (TextView) convertView
					.findViewById(R.id.txtName);
			holder.mImageView = (ImageView) convertView
					.findViewById(R.id.imgIcon);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.mTextView.setText(data.get(position));
		holder.mImageView.setImageResource(images.get(position));
	
		return convertView;
	}

	class ViewHolder {
		public TextView mTextView;
		public ImageView mImageView;
	}

}
