package com.uni.thomas.practical;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.query.Select;

import java.util.ArrayList;
import java.util.List;

// In this case, the fragment displays simple text based on the page
public class SportFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;
    public static SportFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        SportFragment fragment = new SportFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActiveAndroid.initialize(getActivity());
        // IMP http://stackoverflow.com/questions/6495898/findviewbyid-in-fragment

        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sport, container, false);


        ArrayList<String> post_img_path = new ArrayList<String>();
        List<Post> posts = new Select().from(Post.class).execute();

        //for each post p in posts
        for (Post p : posts) {
            post_img_path.add(p.getImg());
        }

        //executeSingle is just one
        GridView gridView = (GridView) view.findViewById(R.id.gridview);
        gridView.setAdapter(new ImageAdapter(getActivity(), post_img_path));
        return view;
    }
}
