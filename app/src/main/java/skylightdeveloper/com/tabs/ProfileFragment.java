package skylightdeveloper.com.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Akash Wangalwar on 22-05-2017.
 */
public class ProfileFragment extends Fragment {

    private static ProfileFragment fragment;

    public ProfileFragment() {
        // Required empty public constructor
    }

    public static ProfileFragment getNewInstance(){

        if(fragment == null){
            fragment = new ProfileFragment();
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
        return inflater.inflate(R.layout.profile_fragment_layout, container, false);
    }

}


