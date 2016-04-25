package com.uni.thomas.practical;

/**
 * Created by Thomas on 17/04/16.
 */
public class Post {
String postDesc, postTitle, img;

    Post()
    {
    }

    Post(String title, String desc, String imgSrc)
    {
        postTitle = title;
        postDesc = desc;
        img = imgSrc;
    }

    public String getPostDesc() {
        return postDesc;
    }

    public String getImg() {
        return img;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostDesc(String postDesc) {
        this.postDesc = postDesc;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
