package com.uni.thomas.practical;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "Posts")
public class Post extends com.activeandroid.Model {

    @Column(name = "Post_Title")
    String postTitle;

    @Column(name = "Post_Description")
    String postDesc;

    /* category field commented: this field is not used

    @Column(name = "Post_Category") //if you use space instead of _, db will malfunction
    String postCategory;
    */

    //image stored by its path on mobile
    @Column(name = "image_path")
    String img;

    public Post()
    {

    }

    public Post(String title, String desc, String imgSrc)
    {
        postTitle = title;
        postDesc = desc;
        //postCategory = category;
        img = imgSrc;

    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostDesc() {
        return postDesc;
    }

    /*
    public String getCategory(){
        return postCategory;
    }
    */

    public void setPostDesc(String postDesc) {
        this.postDesc = postDesc;
    }

    public String getImg() {
        return img;
    }

    /*
public void setPostCategory (String postCategory)
{
    this.postCategory = postCategory;
}
*/

    public void setImg(String img) {
        this.img = img;
    }
}
