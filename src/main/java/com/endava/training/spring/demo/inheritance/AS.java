package com.endava.training.spring.demo.inheritance;

/**
 * Created by vsafronovici on 3/16/2017.
 */
public class AS {

    private String f1;
    private String f2;
    private String f3;

    public String getF1() {
        return f1;
    }

    public void setF1(String f1) {
        this.f1 = f1;
    }

    public String getF2() {
        return f2;
    }

    public void setF2(String f2) {
        this.f2 = f2;
    }

    public String getF3() {
        return f3;
    }

    public void setF3(String f3) {
        this.f3 = f3;
    }


    @Override
    public String toString() {
        return "AS{" +
                "f1='" + f1 + '\'' +
                ", f2='" + f2 + '\'' +
                ", f3='" + f3 + '\'' +
                '}';
    }
}
