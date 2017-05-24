package skylightdeveloper.com.tabs;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akash Wangalwar on 22-05-2017.
 */
public class LandingActivity extends AppCompatActivity implements
        TabLayout.OnTabSelectedListener, ViewPager.OnPageChangeListener {

    private String TAG = LandingActivity.class.getSimpleName();

    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private FloatingActionButton mAddBpBtn;
    private Animation zoomin;
    private Animation zoomout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.landing_activity_layout);
        setIdsToViews();
        setListenersToViews();
        setUpToolBar();
        setViewPager();
        setupTabIcons();
        sentAnimationsToViews();
    }

    private void setUpToolBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.app_name));
    }

    private void setListenersToViews() {
        tabLayout.addOnTabSelectedListener(this);
        viewPager.addOnPageChangeListener(this);
    }

    private void sentAnimationsToViews() {
        zoomin = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
        zoomout = AnimationUtils.loadAnimation(this, R.anim.zoom_out);
        mAddBpBtn.setAnimation(zoomin);
        mAddBpBtn.setAnimation(zoomout);
        mAddBpBtn.startAnimation(zoomin);
    }

    private void setViewPager() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(HomeFragment.getNewInstance(), getResources().getString(R.string.home));
        adapter.addFragment(StatsFragment.getNewInstance(), getResources().getString(R.string.stats));
        adapter.addFragment(RecommendedFragment.getNewInstance(), getResources().getString(R.string.recommended));
        adapter.addFragment(ProfileFragment.getNewInstance(), getResources().getString(R.string.profile));
        viewPager.setAdapter(adapter);
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(ContextCompat.getDrawable(this, R.mipmap.home));
        tabLayout.getTabAt(1).setIcon(ContextCompat.getDrawable(this, R.mipmap.stats));
        tabLayout.getTabAt(2).setIcon(ContextCompat.getDrawable(this, R.mipmap.recommnded));
        tabLayout.getTabAt(3).setIcon(ContextCompat.getDrawable(this, R.mipmap.profile));
    }

    private void setIdsToViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        mAddBpBtn = (FloatingActionButton) findViewById(R.id.fab);
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.tab_strip_color));
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.tab_strip_color));
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setOffscreenPageLimit(4);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {

        if (position != 0) {
            if (mAddBpBtn.getVisibility() == View.INVISIBLE) {
                return;
            }
            mAddBpBtn.startAnimation(zoomout);
            mAddBpBtn.setVisibility(View.INVISIBLE);
        } else {
            mAddBpBtn.startAnimation(zoomin);
            mAddBpBtn.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        int tabIconColor = ContextCompat.getColor(LandingActivity.this, R.color.tab_strip_color);
        try {
            tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
        } catch (Exception e) {
            Log.e(TAG, "onTabSelected: " + e.getMessage());
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        int tabIconColor = ContextCompat.getColor(LandingActivity.this, R.color.grey);
        tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
//        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {

            Fragment fragment = mFragmentList.get(position);
            return fragment;
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
//            mFragmentTitleList.add(title);
        }
/*
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
