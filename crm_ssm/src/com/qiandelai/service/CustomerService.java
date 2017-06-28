package com.qiandelai.service;

import java.util.List;

import com.qiandelai.pojo.BaseDict;
import com.qiandelai.pojo.Customer;
import com.qiandelai.pojo.QueryVo;

public interface CustomerService {
      
      public List<BaseDict> findDictByCode(String code);
      
      public List<Customer> findCustomerByVo(QueryVo queryVo);
      public Integer findCustomerByCount(QueryVo queryVo);

      public Customer findCustomerById(Long id);

      public void updateCustomerById(Customer customer);

      public void deleteCustomerById(Long id);
      
      
}
