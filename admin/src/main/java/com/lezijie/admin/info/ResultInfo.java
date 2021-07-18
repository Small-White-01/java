package com.lezijie.admin.info;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultInfo<T> {
    private boolean flag;
    private T t;
    private String info;
}
