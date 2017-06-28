package com.qiandelai.dao;

import java.util.List;

import com.qiandelai.pojo.Customer;
import com.qiandelai.pojo.QueryVo;

public interface CustomerMapper {
      
      public List<Customer> findCustomerByVo(QueryVo queryVo);
      public Integer findCustomerByCount(QueryVo queryVo);
      public Customer findCustomerById(Long id);
      public void updateCustomerById(Customer customer);
      public void deleteCustomerById(Long id);
                  
}
