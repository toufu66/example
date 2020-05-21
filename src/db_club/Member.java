package db_club;

import java.io.Serializable;

public class Member implements Serializable{
    private int mid;
    private String name;
    private String address;
    public Member() {}

    public Member(int a,String b,String c){
        this.mid = a;
        this.name = b;
        this.address = c;
    }

    public void setMid(int a) {
    	this.mid = a;
    }
    public int getMid() {
    	return this.mid ;
    }

    public void setName(String a) {
    	this.name = a;
    }
    public String getName() {
    	return this.name ;
    }

    public void setAddress(String a) {
    	this.name = a;
    }
    public String getAddress() {
    	return this.address ;
    }


}