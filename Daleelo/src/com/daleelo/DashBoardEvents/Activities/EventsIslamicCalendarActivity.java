package com.daleelo.DashBoardEvents.Activities;

import android.util.Log;

public class EventsIslamicCalendarActivity {   
    
    
    public double gmod(double n,double  m) {   
        return ((n % m) + m) % m;   
    }   
  
    public double[] kuwaiticalendar(double day1,double month1,double year1) {   
          
 
        double day = day1;
        double  month = month1;   
        double  year = year1;   
           
           
        double  m = month;   
        double  y = year;   
        if (m < 3) {   
            y -= 1;   
            m += 12;   
        }   
  
        double a = Math.floor(y / 100.);   
        double b = 2 - a + Math.floor(a / 4.);   
       
        if (y < 1583)   
            b = 0;   
        if (y == 1582) {   
            if (m > 10)   
                b = -10;   
            if (m == 10) {   
                b = 0;   
                if (day > 4)   
                    b = -10;   
            }   
        }   
  
        double jd = Math.floor(365.25 * (y + 4716)) + Math.floor(30.6001 * (m + 1)) + day   
                + b - 1524;   
           
        b = 0;   
        if (jd > 2299160) {   
            a = Math.floor((jd - 1867216.25) / 36524.25);   
            b = 1 + a - Math.floor(a / 4.);   
        }   
        double bb = jd + b + 1524;   
        double cc = Math.floor((bb - 122.1) / 365.25);   
        double dd = Math.floor(365.25 * cc);   
        double ee = Math.floor((bb - dd) / 30.6001);   
        day = (bb - dd) - Math.floor(30.6001 * ee);   
        month = ee - 1;   
        if (ee > 13) {   
            cc += 1;   
            month = ee - 13;   
        }   
        year = cc - 4716;   
  
        double wd = gmod(jd + 1, 7) + 1;   
  
        double iyear = 10631. / 30.;   
        double epochastro = 1948084;   
        double epochcivil = 1948085;   
  
        double shift1 = 8.01 / 60.;   
  
        double z = jd - epochastro;   
        double cyc = Math.floor(z / 10631.);   
        z = z - 10631 * cyc;   
        double j = Math.floor((z - shift1) / iyear);   
        double iy = 30 * cyc + j;   
        z = z - Math.floor(j * iyear + shift1);   
        double im = Math.floor((z + 28.5001) / 29.5);   
        if (im == 13)   
            im = 12;   
        double id = z - Math.floor(29.5001 * im - 29);   
  
        double[]  myRes = new double[8];   
  
        myRes[0] = day; // calculated day (CE)   
        myRes[1] = month - 1; // calculated month (CE)   
        myRes[2] = year; // calculated year (CE)   
        myRes[3] = jd - 1; // julian day number   
        myRes[4] = wd - 1; // weekday number   
        myRes[5] = id; // islamic date   
        myRes[6] = im - 1; // islamic month   
        myRes[7] = iy; // islamic year   
  
        return myRes;   
    }   
   public String getIslamicDate(double day,double month,double year) {  
    	
        String[] wdNames = {"Ahad", "Ithnin", "Thulatha", "Arbaa", "Khams",   
                "Jumuah", "Sabt"};   
        String[] iMonthNames = {"Muharram", "Safar", "Rabi'ul Awwal",   
                "Rabi'ul Akhir", "Jumadal Ula", "Jumadal Akhira", "Rajab",   
                "Sha'ban", "Ramadan", "Shawwal", "Dhul Qa'ada", "Dhul Hijja"};   
        // This Value is used to give the correct day +- 1 day   
          
        double[] iDate = kuwaiticalendar(day, month,year);    
//        String outputIslamicDate = wdNames[(int) iDate[4]] + ", " + iDate[5] + " "  
//                + iMonthNames[(int) iDate[6]] + " " + iDate[7] + " AH";
        
       // String outputIslamicDate = wdNames[(int)iDate[5]]+"/ "+iMonthNames[(int) iDate[6]]+"/"+iDate[7];
        int current_month = (int)iDate[6];
        Log.v("current month",""+current_month);
        String date = ""+iDate[5];
        Log.v("date",""+iDate[5]);
        if(current_month==0){
        	 
//        	String month_year = iMonthNames[11]+" - "+iMonthNames[current_month]+" "+new Double(iDate[7]).intValue()+"A.H";
        	String month_year = iMonthNames[current_month]+"/"+new Double(iDate[7]).intValue()+"A.H";
        	String outputIslamicDate = date+"/"+month_year;
        	return outputIslamicDate;
        	
        }else{
//        	String month_year = iMonthNames[current_month-1]+" - "+iMonthNames[current_month]+" "+new Double(iDate[7]).intValue()+"A.H";
        	String month_year = iMonthNames[current_month];
        	String outputIslamicDate = date+"/"+month_year+"/"+new Double(iDate[7]).intValue()+"A.H";
        	return outputIslamicDate;
        }
        
      
       // String outputIslamicDate = iDate[5]+"/"+iMonthNames[current_month-1]+" "+iMonthNames[current_month]+" "+new Double(iDate[7]).intValue()+"A.H";
        
           
        
    }   
}  