package francis.cerio.myresume;

import java.util.ArrayList;

import android.os.Bundle;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;

import francis.cerio.myresume.adapter.TechnicalSkillsAdapter;

public class TechnicalSkillsActivity extends SherlockFragmentActivity {

	private ListView mList;
	private ArrayList<String> data = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.technical_skills);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		mList = (ListView) findViewById(R.id.tech_list);
		init();

	}

	public void init() {
		// MediaPlayer, MenuDrawer, Google Maps API, Camera API, Fragments, API
		// 8-
		// 16, ActionBarSherlock, and other open source libraries
		// Operating Systems:
		// Ubuntu or Windows
		// Other Skills:
		// Git and Subversion, Eclipse, XML, JSON
		// References available upon request

		data.add("MediaPlayer API");
		data.add("Google Maps API");
		data.add("Camera API");
		data.add("Fragments");
		data.add("Android Open Source Libraries");
		data.add("Ubuntu");
		data.add("Git");
		data.add("SVN");
		data.add("SQLite");
		data.add("Eclipse");
		data.add("XML");
		data.add("JSON");

		TechnicalSkillsAdapter adapter = new TechnicalSkillsAdapter(
				TechnicalSkillsActivity.this, data);

		mList.setAdapter(adapter);

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case android.R.id.home:
			finish();
		default:
		}

		return super.onOptionsItemSelected(item);
	}
}
