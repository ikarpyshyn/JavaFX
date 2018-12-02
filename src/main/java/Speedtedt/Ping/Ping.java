package Speedtedt.Ping;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Ping {
    String text = "Sprawdzam polczenie";
    String text1;
    String text3;
    int timer;
    public static Ping pingclon;

    public Ping(String tex3, String text, String text1, int timer) {
    }

    public static void main(String text3, String text, String text1, int timer) {
        Ping ping = new Ping( text3, text, text1, timer );
        pingclon = ping;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public String getText() {
        return text;
    }

    public String getText3() {
        return text3;
    }

    public void setText3(String text3) {
        this.text3 = text3;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }
}
