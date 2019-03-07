package app.jimmy.foodybuddy;

import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.material.appbar.CollapsingToolbarLayout;

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
