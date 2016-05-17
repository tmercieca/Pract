package com.uni.thomas.practical;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MenuActivity extends AppCompatActivity {
    ListView portalList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        portalList = (ListView) findViewById(R.id.portalList);
        final Intent myIntent = new Intent(MenuActivity.this, PortalActivity.class);
        final Intent newsIntent = new Intent(MenuActivity.this, GalleryActivity.class);


        portalList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0: startActivity(myIntent);
                            break;
                    case 1: startActivity(newsIntent);
                        break;
                }
            }
        });

    }
}
    /*
            Parameters:
            adapter - The AdapterView where the click happened.
            view - The view within the AdapterView that was clicked
            position - The position of the view in the adapter.
            id - The row id of the item that was clicked.
         */
