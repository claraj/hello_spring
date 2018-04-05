package com.example.hello;

/**
 * Created by clara on 4/5/18.
 */

class Compliment {
    private String text;
    Compliment(String text){ this.text = text;}
   
    Compliment() {}
    
    public String getText() {
        return text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
}