package app.jimmy.foodybuddy;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.Timer;
import java.util.TimerTask;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

/**
 * @author Jimmy
 * Created on 7/3/19.
 */
public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private ViewPager mPager;
    private ImageView toolBarImage;
    private CollapsingToolbarLayout collapsingToolbarLayout;

    int currentPage = 0;
    Timer timer;
    final long DELAY_MS = 5000;
    final long PERIOD_MS = 8000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiate a ViewPager and a SlidingPagerAdapter.
        mPager = findViewById(R.id.pager);
        PagerAdapter pagerAdapter = new SlidingPagerAdapter(getSupportFragmentManager());
        toolBarImage = findViewById(R.id.image);
        collapsingToolbarLayout = findViewById(R.id.toolbar_layout);

        mPager.setAdapter(pagerAdapter);
        mPager.addOnPageChangeListener(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setUpTimer();
    }

    private void setUpTimer() {
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == SlidingPagerAdapter.NUM_PAGES - 1) {
                    currentPage = 0;
                }else {
                    currentPage++;
                }
                mPager.setCurrentItem(currentPage, true);
            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        },DELAY_MS, PERIOD_MS);

    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        switch (position){
            case 0:{
                collapsingToolbarLayout.setTitle(getString(R.string.cake_header));
                toolBarImage.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_cake_black_24dp));
                break;
            }
            case 1:{
                collapsingToolbarLayout.setTitle(getString(R.string.pizza_header));
                toolBarImage.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_local_pizza_black_24dp));
                break;

            }
            case 2:{
                collapsingToolbarLayout.setTitle(getString(R.string.drink_header));
                toolBarImage.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_local_drink_black_24dp));
                break;

            }
        }
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
