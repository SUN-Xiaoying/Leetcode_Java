package klarna;

import java.util.*;

// ToDo: NOT ALL PASS
class MovingAverage {
    private int size;
    private double total=0d;
    private int index=0;
    private double samples[];

    public MovingAverage(Integer N){
        //...
        this.size=N;
        samples=new double[N];
        for(int i=0; i<size; i++){ samples[i]=0d;}
    }

    public Double add(Integer X) {
        //...
        total-=samples[index];
        samples[index]=X;
        total+=X;
        if(++index==size) index=0;
        return total/size;
    }
}
