package com.uni.thomas.practical;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

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
        mPage = getArguments().getInt(ARG_PAGE);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sport, container, false);
        TextView textView = (TextView) view; //sunday evening: problem is that xml is showing gridview and this line assumes it's listview
        textView.setText("Fragment #" + mPage);
        /////GridView gridview = (GridView) getView().findViewById(R.id.gridview);
        /////gridview.setAdapter(new ImageAdapter(this));

        //gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          //  public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
              //  Toast.makeText(SportFragment.this, "" + position, Toast.LENGTH_SHORT).show();
            //}
        //});
        return view;
    }
}
