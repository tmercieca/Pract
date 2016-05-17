package com.uni.thomas.practical;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.List;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    private List<String> imgResList;

    public ImageAdapter(Context c, List<String> imgResList) {
        mContext = c;
        this.imgResList = imgResList;
    }

    public int getCount() {
        return imgResList.size();
    }

    public Object getItem(int position) {
        return imgResList.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(200, 200)); //this sets size of img, for better resolutions http://stackoverflow.com/questions/6201484/resize-images-in-gridview-on-android
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);//center crop is like a zoom in
            imageView.setPadding(8, 8, 8, 8); //?? necessary ??
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageURI(Uri.parse(imgResList.get(position)));
        return imageView;
    }
}

