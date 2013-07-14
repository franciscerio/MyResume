package francis.cerio.myresume;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.android.tabcarousel.CarouselContainer;
import com.android.tabcarousel.CarouselPagerAdapter;

import francis.cerio.myresume.utils.PhoneCallListener;

public class MainActivity extends SherlockFragmentActivity {

	private static final int FIRST_TAB = CarouselContainer.TAB_INDEX_FIRST;
	private static final int SECOND_TAB = CarouselContainer.TAB_INDEX_SECOND;
	public ViewPager carouselPager;
	private CarouselContainer carousel;
	private int position;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Set the layout
		setContentView(R.layout.carousel_container);

		// Resources
		final Resources res = getResources();

		// Initialize the header
		  carousel = (CarouselContainer) findViewById(R.id.carousel_header);
		// Indicates that the carousel should only show a fraction of the
		// secondary tab
		carousel.setUsesDualTabs(true);
		// Add some text to the labels
		carousel.setLabel(FIRST_TAB, getResources().getString(R.string.name));
		carousel.setLabel(SECOND_TAB, "@francis_cerio");
		// Add some images to the tabs
		carousel.setImageDrawable(FIRST_TAB,
				res.getDrawable(R.drawable.android_bg_left));
		carousel.setImageDrawable(SECOND_TAB,
				res.getDrawable(R.drawable.android_bg_right));
		
		// The Bundle for the color fragment
		final Bundle blue = new Bundle();
//		blue.putInt("color", Color.parseColor("#ff33b5e5"));
		blue.putInt("color", Color.TRANSPARENT);
		
		// Initialize the pager adatper
		final PagerAdapter pagerAdapter = new PagerAdapter(MainActivity.this);
		pagerAdapter.add(ResumeList.class, new Bundle());
		pagerAdapter.add(ColorFragment.class, blue);

		// Initialize the pager
		carouselPager = (ViewPager) findViewById(R.id.carousel_pager);
		// This is used to communicate between the pager and header
		carouselPager.setOnPageChangeListener(new CarouselPagerAdapter(
				carouselPager, carousel));
		carouselPager.setAdapter(pagerAdapter);
		
		// for phone
		PhoneCallListener phoneListener = new PhoneCallListener(
				MainActivity.this);
		TelephonyManager telephonyManager = (TelephonyManager) this
				.getSystemService(Context.TELEPHONY_SERVICE);
		telephonyManager.listen(phoneListener,
				PhoneStateListener.LISTEN_CALL_STATE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater menuInflater = getSupportMenuInflater();
		menuInflater.inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(
			com.actionbarsherlock.view.MenuItem item) {
		switch (item.getItemId()) {
		case R.id.phone:
			Intent callIntent = new Intent(Intent.ACTION_CALL);
			callIntent.setData(Uri.parse("tel:+639331701158"));
			startActivity(callIntent);
			return true;
		case R.id.mail:
			Intent i = new Intent(Intent.ACTION_SEND);
			i.setType("message/rfc822");
			i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"fran.cerio1990@gmail.com"});
			i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
			i.putExtra(Intent.EXTRA_TEXT   , "body of email");
			try {
			    startActivity(Intent.createChooser(i, "Send mail..."));
			} catch (android.content.ActivityNotFoundException ex) {
			    Toast.makeText(MainActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
			}

			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

}
