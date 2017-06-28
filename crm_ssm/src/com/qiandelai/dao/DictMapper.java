package com.qiandelai.dao;

import java.util.List;

import com.qiandelai.pojo.BaseDict;

public interface DictMapper {
      
      
      public List<BaseDict> findDictByCode(String code);
      
      
}
