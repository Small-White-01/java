package com.lezijie.admin.utils;

import com.lezijie.admin.exception.MsgException;

public class Assert {


    public static boolean isNull(Object obj,String msg) throws MsgException {

            if (obj == null) {
                throw new MsgException(msg);
            }

        return false;
    }


    public static boolean isBlank(CharSequence charSequence,String msg){
        try {
            String s=(String)charSequence;
            if(s.equals("")){
                throw new MsgException(msg);
            }
            for (int i = 0; i <s.length() ; i++) {
                if(Character.isWhitespace(s.charAt(i))){
                    throw new MsgException(msg);
                };


            }
            return false;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static boolean isTrue(boolean b,String msg) throws MsgException {
        if(b){
            throw new MsgException(msg);
        }else {
            return false;
        }
    }
}
