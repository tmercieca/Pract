package com.uni.thomas.practical;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.activeandroid.ActiveAndroid;

public class PortalActivity extends AppCompatActivity implements View.OnClickListener {
    static final int PICK_IMAGE_REQUEST = 1;
    String URIloc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActiveAndroid.initialize(this);
        setContentView(R.layout.activity_portal);
        ImageButton button_select_image = (ImageButton) findViewById(R.id.button_select_image);
        Button submit = (Button)findViewById(R.id.submit_button);
        Button cancel = (Button) findViewById(R.id.cancel_button);
        button_select_image.setOnClickListener(this);
        button_select_image.setTag("not clicked");
        submit.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
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
                tempPost.setPostDesc(postDesc.getText().toString()); //set extracted info as data
                tempPost.setPostTitle(postTitle.getText().toString()); //same

                tempPost.setImg(URIloc);

                //PROGRAM CRAHSES IF YOU SUBMIT THE + ICON and you try to view it in gallery
                if (img.getTag() == "clicked") {
                    tempPost.save();
                    Toast.makeText(this, "SUCCESSFULY posted image", Toast.LENGTH_SHORT).show();
                    img.setTag("not clicked"); //reset
                } else {
                    Toast.makeText(this, "ERROR: can't submit + icon.", Toast.LENGTH_SHORT).show();

                }

                //after saving, RESET everything back to how it was
                postDesc.setText("Post Description");
                postTitle.setText("");//empty string =>not a null value (null value can cause problems)
                img.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.plus_icon));
                img.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                break;

            case R.id.cancel_button:
                finish();//finish activity, thus going back
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == PICK_IMAGE_REQUEST) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                ImageButton button_select_image = (ImageButton) findViewById(R.id.button_select_image);
                button_select_image.setImageURI(data.getData());
                URIloc = data.getDataString();
                button_select_image.setScaleType(ImageButton.ScaleType.FIT_CENTER);
                button_select_image.setTag("clicked");

                //124 pointing to null - alternative
                //button_select_image.setBackgroundColor(124);
                //button_select_image.setBackground(null);

            }
        }
    }
}

