package allthatbeer.android.beer.com.whatisbeer;

/**
 * Created by T on 2015-11-27.
 */
public class RecylerItem {

    int image,likeCount,point,profileimg;
    String bName;
    String id;
    String content;


    int getImage(){
        return this.image;
    }
    int getProfileimg(){
        return this.profileimg;
    }

    int getLikeCount(){
        return this.likeCount;
    }
    int getPoint(){
        return this.point;
    }

    String getbName(){
        return this.bName;
    }
    String getId(){
        return this.id;
    }
    String getContent(){
        return this.content;
    }

    RecylerItem(int image, String bName,String id,String content){
        this.image=image;
        this.bName=bName;
        this.id=id;
        this.content=content;
    }

    RecylerItem(int image,int profileimg, String bName,String content,int likeCount,int point){
        this.image=image;
        this.profileimg=profileimg;
        this.bName=bName;
        this.content=content;
        this.likeCount=likeCount;
        this.point=point;
    }

    RecylerItem(int image, String bName){
        this.image=image;
        this.bName=bName;
    }

}
