package com.demo;

import com.demo.message.MessageServiceImpl;
import  org.junit.Test;
import  org.junit.runner.RunWith;
import  org.springframework.beans.factory.annotation.Autowired;
import  org.springframework.boot.test.context.SpringBootTest;
import  org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public  class  RabbitmqApplicationTests  {

    @Autowired
    private MessageServiceImpl messageService;

    @Test
    public  void  send()  {
        messageService.sendMsg("test_queue_1","hello  i  am  delay  msg");
    }

}
