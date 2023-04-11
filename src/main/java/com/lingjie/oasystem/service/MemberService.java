package com.lingjie.oasystem.service;


import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class MemberService {



    @Transactional(propagation = Propagation.MANDATORY,isolation = Isolation.READ_COMMITTED)
    public void aaa(){

    }





}
