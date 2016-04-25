package com.uni.thomas.practical;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView portalList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        portalList = (ListView) findViewById(R.id.portalList);
        final Intent myIntent = new Intent(MainActivity.this, PortalActivity.class);
        final Intent newsIntent = new Intent(MainActivity.this, NewsActivity.class);
        portalList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Object listItem = portalList.getItemAtPosition(position);
                switch (position)
                {
                    case 0: startActivity(myIntent);
                            break;
                    case 1: startActivity(newsIntent);
                            break;//necessary?
                }

                /*ListEntry entry= (ListEntry) parent.getAdapter().getItem(position);
                Intent intent = new Intent(MainActivity.this, SendMessage.class);
                String message = entry.getMessage();
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
*/
            }
        });

    }
}
    /*
         * Parameters:
            adapter - The AdapterView where the click happened.
            view - The view within the AdapterView that was clicked
            position - The position of the view in the adapter.
            id - The row id of the item that was clicked.
         */
