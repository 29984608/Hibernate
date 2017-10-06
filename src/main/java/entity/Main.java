package entity;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
    Scanner main = new Scanner(System.in);
       while(main.hasNext()){
            String string= main.next();
            String[] timeStrings=string.split("/");
            int[] time=new int[timeStrings.length];
            int day=0;
            for(int i=0;i<timeStrings.length;i++){
                time[i]=Integer.parseInt(timeStrings[i]);
            }
            int []month;
            if ((time[0]%400==0)||(time[0]%4==0)&&(time[0]%100!=0)){
                month=new int[]{31,29,31,30,31,30,31,31,30,31,30,31};
            } else {
                month=new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
            }
            for(int i=0;i<time[1]-1;i++){
                day+=month[i];
            }
            day+=time[2];
            System.out.println(day);
        }
    }
}