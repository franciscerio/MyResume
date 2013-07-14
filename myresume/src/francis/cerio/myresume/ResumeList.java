package francis.cerio.myresume;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources.Theme;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockListFragment;
import com.actionbarsherlock.view.Window;
import com.android.tabcarousel.BackScrollManager;
import com.android.tabcarousel.CarouselContainer;

import francis.cerio.myresume.adapter.ResumeAdapter;
import francis.cerio.myresume.utils.MyDialogFragment;

public class ResumeList extends SherlockListFragment {

	private CarouselContainer mCarousel;

	private ArrayList<String> items = new ArrayList<String>();
	private ArrayList<Integer> images = new ArrayList<Integer>();

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mCarousel = (CarouselContainer) activity
				.findViewById(R.id.carousel_header);
		mCarousel.setUsesDualTabs(true);

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Simple ArrayAdapter

		items.add("");
		items.add("Work Experince");
		items.add("Qualifications");
		items.add("Technical Skills");
		items.add("Education");
		items.add("Additional Info");

		images.add(R.drawable.ic_launcher);
		images.add(R.drawable.experience);
		images.add(R.drawable.qualification);
		images.add(R.drawable.skills);
		images.add(R.drawable.education);
		images.add(R.drawable.interest);

		ResumeAdapter adapter = new ResumeAdapter(getActivity(), items, images);
		// Bind the data
		setListAdapter(adapter);

		return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		final ListView listView = getListView();
		// Attach the BackScrollManager
		listView.setOnScrollListener(new BackScrollManager(mCarousel, null,
				CarouselContainer.TAB_INDEX_FIRST));
		// Register the onItemClickListener
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent;
				// TODO Auto-generated method stub
				if (position == 1) {
					intent = new Intent(getActivity(), ExperienceActivity.class);
					getActivity().startActivity(intent);
					intent = null;
				} 
				else if(position == 3){
					intent = new Intent(getActivity(),TechnicalSkillsActivity.class);
					getActivity().startActivity(intent);
					intent = null;
				}else {
					showDialog(position);
				}
			}
		});
		// We disable the scroll bar because it would otherwise be incorrect
		// because of the hidden
		// header
		listView.setVerticalScrollBarEnabled(false);
	}

	public void showDialog(int position) {
		MyDialogFragment dialog = MyDialogFragment.newInstance(position);
		dialog.show(getActivity().getSupportFragmentManager(), "dialog");
	}

}
