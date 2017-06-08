package com.alex.controller;


import com.alex.service.KK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JTA {

    @Autowired
  private KK kk;

    @RequestMapping("/one")

    public String kk() {

       kk.save();

        return "ok";
    }

}
