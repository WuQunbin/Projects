package com.gs;

import com.gs.bean.Jklx;
import com.gs.bean.Sway;
import com.gs.service.SwayService;
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
public class SwayTest {

    @Resource
    private SwayService swayService;

    @Test
    public void Swaysavetest(){
        Sway sway=new Sway();
        sway.setSid(1L);
        sway.setWay("先息后本");
        sway.setFw("先息后本");
        sway.setState((byte)0);
        swayService.save(sway);
    }

    @Test
    public void Swayupdatetest(){
        Sway sway=new Sway();
        sway.setSid(1L);
        sway.setState((byte)1);
        swayService.update(sway);
    }

    @Test
    public void SwayremoveByIdtest(){
        swayService.removeById(1L);
    }

    @Test
    public void SwayListByPager(){
        swayService.listPagerCriteria(2,2,null);
    }


}
