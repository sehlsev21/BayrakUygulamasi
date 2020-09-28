package com.example.bayrakuygulamas;

public class Bayraklar {
    private int bayrak_id;
    private String bayrak_ad;
    private String bayrak_resim;

    public Bayraklar() {
    }

    public Bayraklar(int bayrak_id, String bayrak_ad, String bayrak_resim) {
        this.bayrak_id = bayrak_id;
        this.bayrak_ad = bayrak_ad;
        this.bayrak_resim = bayrak_resim;
    }

    public int getBayrak_id() {
        return bayrak_id;
    }

    public void setBayrak_id(int bayrak_id) {
        this.bayrak_id = bayrak_id;
    }

    public String getBayrak_ad() {
        return bayrak_ad;
    }

    public void setBayrak_ad(String bayrak_ad) {
        this.bayrak_ad = bayrak_ad;
    }

    public String getBayrak_resim() {
        return bayrak_resim;
    }

    public void setBayrak_resim(String bayrak_resim) {
        this.bayrak_resim = bayrak_resim;
    }
}
