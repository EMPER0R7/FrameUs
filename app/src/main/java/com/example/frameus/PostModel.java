package com.example.frameus;

public class PostModel {
    public String likebtn;
    private String imgprof;
    private String username;
    private String postimg;
    private String likecnt;

    public PostModel(String likebtn, String imgprof, String username, String postimg, String likecnt) {
        this.likebtn = likebtn;
        this.imgprof = imgprof;
        this.username = username;
        this.postimg = postimg;
        this.likecnt = likecnt;
    }

    public String getLikebtn() {
        return likebtn;
    }

    public void setLikebtn(String likebtn) {
        this.likebtn = likebtn;
    }

    public String getImgprof() {
        return imgprof;
    }

    public void setImgprof(String imgprof) {
        this.imgprof = imgprof;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPostimg() {
        return postimg;
    }

    public void setPostimg(String postimg) {
        this.postimg = postimg;
    }

    public String getLikecnt() {
        return likecnt;
    }

    public void setLikecnt(String likecnt) {
        this.likecnt = likecnt;
    }
}
