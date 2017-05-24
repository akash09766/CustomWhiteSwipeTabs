package skylightdeveloper.com.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Akash Wangalwar on 22-05-2017.
 */
public class StatsFragment extends Fragment {

    private static StatsFragment fragment;

    public StatsFragment() {
        // Required empty public constructor
    }

    public static StatsFragment getNewInstance(){

        if(fragment == null){
            fragment = new StatsFragment();
        }
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.stats_fragment_layout, container, false);
    }

}


