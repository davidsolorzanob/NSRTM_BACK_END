package com.nsrtm.contribuyente.reportes.utils;

import org.springframework.http.ResponseEntity;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class util {
    public static String getDateComplete() {
        Calendar calendar = Calendar.getInstance();
        Integer day = calendar.get(Calendar.DAY_OF_MONTH);
        Integer month = calendar.get(Calendar.MONTH)+1;
        Integer year = calendar.get(Calendar.YEAR);
        String monthName="";
        Date today = new Date();
        switch (month){
            case 1: monthName = "ENERO"; break;
            case 2: monthName = "FEBRERO"; break;
            case 3: monthName = "MARZO"; break;
            case 4: monthName = "ABRIL"; break;
            case 5: monthName = "MAYO"; break;
            case 6: monthName = "JUNIO"; break;
            case 7: monthName = "JULIO"; break;
            case 8: monthName = "AGOSTO"; break;
            case 9: monthName = "SEPTIEMBRE"; break;
            case 10: monthName = "OCTUBRE"; break;
            case 11: monthName = "NOVIEMBRE"; break;
            case 12: monthName = "DICIEMBRE"; break;
            default: break;
        }

        return day.toString() + " DE " + monthName + " DEL " + year.toString();
    }
}
