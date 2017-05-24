package skylightdeveloper.com.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Akash Wangalwar on 22-05-2017.
 */
public class RecommendedFragment extends Fragment {

    private static RecommendedFragment fragment;

    public RecommendedFragment() {
        // Required empty public constructor
    }

    public static RecommendedFragment getNewInstance(){

        if(fragment == null){
            fragment = new RecommendedFragment();
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
        return inflater.inflate(R.layout.recommended_fragment_layout, container, false);
    }

}


