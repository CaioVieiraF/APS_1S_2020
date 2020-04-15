
 public class Time{
     long counter = 1100000000L;

     public void Sleep(int time){
         counter *= time;
         for(long x=0L; x<=counter; x++){
         }
         time = 0;
     }
 }
