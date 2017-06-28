package com.qiandelai.controller.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
/**
 * S  source    源
 * T  target    目标
 * @author Administrator
 *
 */
public class CustomGlobalStrToDateConverter implements Converter<String,Date> {

      @Override
      public Date convert(String source) {
            try {
            SimpleDateFormat forMat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                  Date date = forMat.parse(source);
                  
                  return date;
            } catch (ParseException e) {
                  e.printStackTrace();
            }
            
            return null;
      }
      
      
      
}
