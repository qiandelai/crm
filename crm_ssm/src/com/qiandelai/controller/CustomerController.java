package com.qiandelai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qiandelai.pojo.BaseDict;
import com.qiandelai.pojo.Customer;
import com.qiandelai.pojo.QueryVo;
import com.qiandelai.service.CustomerService;

import cn.itcast.utils.Page;


@Controller
@RequestMapping("/customer")
@SuppressWarnings("all")
public class CustomerController {
      @Autowired
      private CustomerService customerService;
      @Value("${customer.dict.source}")
      private String source;
      @Value("${customer.dict.industry}")
      private String industry;
      @Value("${customer.dict.level}")
      private String level;
      
      @RequestMapping("/list")
      public String list(QueryVo queryVo,Model model)throws Exception{
            //客户来源
            List<BaseDict> sourceList = customerService.findDictByCode(source);
            
            //所属行业
            List<BaseDict> industryList = customerService.findDictByCode(industry);
             
            //客户级别
            List<BaseDict> levelList = customerService.findDictByCode(level);
            
            //放入model中跳转页面
            model.addAttribute("fromType",sourceList);
            model.addAttribute("industryType",industryList);
            model.addAttribute("levelType",levelList);
            //转码
            if(queryVo.getCustName()!=null){
            queryVo.setCustName( new String(queryVo.getCustName().getBytes("iso8859-1"),"utf-8") );
            }
            
            if(queryVo.getPage()!=null){
                  queryVo.setPage(1);
                  
            }
            //设置开始查询的位置(计算出的)
            queryVo.setStart((queryVo.getPage()-1)*queryVo.getSize());
            
            //查询数据列表和数据总数
            List<Customer> list = customerService.findCustomerByVo(queryVo);
            Integer integer = customerService.findCustomerByCount(queryVo);
            
            Page<Customer>page = new Page<>();
            page.setTotal(integer); //总数
            page.setSize(queryVo.getSize());
            page.setPage(queryVo.getPage());
            page.setRows(list);
            
            model.addAttribute("page",page);
            
            //高级选中数据回显
            model.addAttribute("custName",queryVo.getCustName()); 
            model.addAttribute("custSource",queryVo.getCustSource()); 
            model.addAttribute("custIndustry",queryVo.getCustIndustry()); 
            model.addAttribute("custLevel",queryVo.getCustLevel()); 
            return "customer"; 
            
      } 

      @RequestMapping("/detail")
      @ResponseBody
      public Customer detail(Long id) throws Exception {
            Customer customer = customerService.findCustomerById(id);
            return customer;
            
      }
      @RequestMapping("/update")
      public String update(Customer customer)throws Exception{
            customerService.updateCustomerById(customer);
            return "customer"; 
      }
      
      @RequestMapping("/delete")
      public String delete(Long id)throws Exception{
            customerService.deleteCustomerById(id);
            return "customer"; 
      }
      
      
}
