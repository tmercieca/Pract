package com.uni.thomas.practical;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.media.Image;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PortalActivity extends AppCompatActivity implements View.OnClickListener {
    static final int PICK_IMAGE_REQUEST = 1;  // The request code
    //private View dummy = (View) View.inflate(this, R.layout.dummy, null);
    //private EditText addmoney = (EditText) dummy.findViewById(R.id.addmoney);

    //private View portal = (View) View.inflate(this, R.layout.activity_portal, null);
    //private Button submit = (Button) portal.findViewById(R.id.submit_button);
    //private ImageButton button_select_image = (ImageButton) portal.findViewById(R.id.button_select_image);

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portal);

        ImageButton button_select_image = (ImageButton) findViewById(R.id.button_select_image);
        Button submit = (Button)findViewById(R.id.submit_button);
        // not needed button_select_image.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        button_select_image.setOnClickListener(this);
        submit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        List<Post> postList = new ArrayList<Post>();
        Post tempPost = new Post();
        switch(v.getId()){
            case R.id.button_select_image: Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_PICK);
                //sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
                sendIntent.setType("image/*");
                startActivityForResult(sendIntent, PICK_IMAGE_REQUEST);
                break;
            case R.id.submit_button:
                EditText postDesc = (EditText) findViewById(R.id.post_description); //extract info
                EditText postTitle = (EditText) findViewById(R.id.post_title);// same
                ImageButton img = (ImageButton) findViewById(R.id.button_select_image);
                tempPost.setPostDesc(postDesc.toString()); //set extracted info as data
                tempPost.setPostTitle(postTitle.toString()); //same
                tempPost.setImg(img.toString());


                postList.add(tempPost); //new Post (postTitle, postDesc, img)
                //t.setVisibility(t.INVISIBLE);
               postTitle.setVisibility(View.INVISIBLE);
                postDesc.setText("DONE!");
                img.setVisibility(View.INVISIBLE);
                Intent intent2 = new Intent(this, NewsActivity.class);
/*
ArrayList<String> myList = new ArrayList<String>();
intent.putExtra("mylist", myList);
In the other Activity:

ArrayList<String> myList = (ArrayList<String>) getIntent().getSerializableExtra("mylist");
 */
                //Bundle b=new Bundle();
                //b.putStringArray(key, new String[]{value1, value2});
              //  Intent i=new Intent(context, Class);
            //    i.putExtras(b);
  //              And for receiveing
//save()
        //        Bundle b=this.getIntent().getExtras();
          //      String[] array=b.getStringArray(key);





                //Intent sendIntent = new Intent();
                //sendIntent.setAction(Intent.ACTION_PICK);
                ////sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
                //sendIntent.setType("image/*");
                //startActivityForResult(sendIntent, PICK_IMAGE_REQUEST);
                break;
            case R.id.cancel_button: //goback
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == PICK_IMAGE_REQUEST) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                //ImageView img = (ImageView)findViewById(R.id.selected_image);
                //img.setImageURI(data.getData());
                ImageButton button_select_image = (ImageButton) findViewById(R.id.button_select_image);
                button_select_image.setImageURI(data.getData());
                button_select_image.setScaleType(ImageButton.ScaleType.FIT_CENTER);

                //124 pointing to null
                //button_select_image.setBackgroundColor(124);
                //button_select_image.setBackground(null);


                //button_select_image.setVisibility(View.INVISIBLE);
                //button_select_image.setVisibility(View.GONE);

                //ViewParent layout = button_select_image.getParent();

                /*if(null!=layout) {//for safety only  as you are doing onClick
                    layout.removeView(button_select_image);
                }*/
            }
        }
    }
}
                /*ListEntry entry= (ListEntry) parent.getAdapter().getItem(position);
                Intent intent = new Intent(MainActivity.this, SendMessage.class);
                String message = entry.getMessage();
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
*/

    /*
         * Parameters:
            adapter - The AdapterView where the click happened.
            view - The view within the AdapterView that was clicked
            position - The position of the view in the adapter.
            id - The row id of the item that was clicked.
         */
