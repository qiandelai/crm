package com.qiandelai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiandelai.dao.CustomerMapper;
import com.qiandelai.dao.DictMapper;
import com.qiandelai.pojo.BaseDict;
import com.qiandelai.pojo.Customer;
import com.qiandelai.pojo.QueryVo;
@Service
public class CustomerServiceImpl implements CustomerService{
      
      @Autowired
      private DictMapper dictMapper;
      @Autowired
      private CustomerMapper customerMapper;
      
      public List<BaseDict> findDictByCode(String code) {
            List<BaseDict> list = dictMapper.findDictByCode(code);
            return list;
      }
      
      public List<Customer> findCustomerByVo(QueryVo queryVo) {
            List<Customer> list = customerMapper.findCustomerByVo(queryVo);
            return list;
      }
      
      public Integer findCustomerByCount(QueryVo queryVo) {
            Integer integer = customerMapper.findCustomerByCount(queryVo);
            return integer;
            
      }

      public Customer findCustomerById(Long id) {
           Customer customer = customerMapper.findCustomerById(id);
            return customer;
            
      }

      public void updateCustomerById(Customer customer) {
            
            customerMapper.updateCustomerById(customer);
            
      }

      public void deleteCustomerById(Long id) {
            customerMapper.deleteCustomerById(id);
            
      }
      

}
