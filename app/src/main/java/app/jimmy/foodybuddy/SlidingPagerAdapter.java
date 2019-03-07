package app.jimmy.foodybuddy;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

/**
 * @author Jimmy
 * Created on 7/3/19.
 */
public class SlidingPagerAdapter extends FragmentStatePagerAdapter {
    public static final int NUM_PAGES = 3;


    public SlidingPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:{
                return ScrollingFragment.newInstance(R.string.text_cake);
            }
            case 1:{
                return ScrollingFragment.newInstance(R.string.text_pizza);
            }
            case 2:{
                return ScrollingFragment.newInstance(R.string.text_drink);
            }
            default:
                return ScrollingFragment.newInstance(R.string.text_cake);
        }
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}
