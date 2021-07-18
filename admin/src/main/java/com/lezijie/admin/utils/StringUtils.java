package com.lezijie.admin.utils;

public class StringUtils {



    public static boolean equal(String value,String other){
        try {
            if (value == null) {
                throw new NullPointerException();
            }
            return value.equals(other);
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


}
