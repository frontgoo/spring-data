package org.frontgoo.springdata.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

/**
 * Created by sunny on 16-2-15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class PersistT {

    @Autowired
    CityRepository cityRepository;

    @Before
    public void doBerfore(){

    }

    @Test
    @Rollback(false)
    public void  testPersist(){
        City xc = new City("上海","中国");
        cityRepository.save(xc);
        System.out.println("---OK---");
        ArrayList<City> all = (ArrayList<City>) cityRepository.findAll();
        for (City city: all){
            System.out.println("城市名称："+city.getName());
            System.out.println("国家名称："+city.getState());
        }
    }

}
