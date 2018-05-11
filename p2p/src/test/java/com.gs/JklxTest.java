package com.gs;

import com.gs.bean.Jklx;
import com.gs.service.JklxService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by ：余鹏
 * time：2018/1/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/config/spring-*.xml"})
public class JklxTest {

    @Resource
    private JklxService jklxService;

    @Test
    public void Jklxsavetest(){
        Jklx jklx=new Jklx();
        jklx.setLxid(4L);
        jklx.setLxname("净值贷1");
        jklx.setState((byte)1);
        jklxService.save(jklx);
    }

    @Test
    public void Jklxupdatetest(){
        Jklx jklx=new Jklx();
        jklx.setLxid(4L);
        jklx.setState((byte)0);
        jklxService.update(jklx);
    }

    @Test
    public void JklxremoveByIdtest(){
        jklxService.removeById(4L);
    }

    @Test
    public void JklxListByPager(){
        jklxService.listPagerCriteria(2,2,null);
    }


}
