package com.lezijie.admin.info;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseInfo {

    private int code;
    private String msg;
    private Object obj;


    public static ResponseInfo success(String msg){
        return ResponseInfo.success(msg,null);
    }

    public static ResponseInfo success(String msg,Object obj){
        return new ResponseInfo(200,msg,obj);
    }

    public static ResponseInfo error(String msg){
        return ResponseInfo.error(msg,null);
    }

    public static ResponseInfo error(String msg,Object obj){
        return new ResponseInfo(500,msg,obj);
    }



}
