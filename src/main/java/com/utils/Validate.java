package com.utils;

import javax.servlet.http.HttpServletRequest;

public class Validate {

    public static String checkParam(HttpServletRequest request, String param){
        return request.getParameter(param)== null? "" : request.getParameter(param);
    }

    public static boolean validateYearRange(String year){
        if(validateYearFormat(year)) {
            System.out.println((Integer.valueOf(year) >= 1990 && Integer.valueOf(year) <= 2017));
            return (Integer.valueOf(year) >= 1990 && Integer.valueOf(year) <= 2017);
        }
        else return false;
    }

    public static boolean validateYearFormat(String year){
        return year.matches("\\d+");
    }
    public static boolean validateTitle(String title){
        return title.length()>=2;
    }
}
