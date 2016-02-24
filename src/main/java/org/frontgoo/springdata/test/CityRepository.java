package org.frontgoo.springdata.test;

import org.springframework.data.domain.*;
import org.springframework.data.repository.*;

public interface CityRepository extends CrudRepository<City, Long> {

    Page<City> findAll(Pageable pageable);

//    City findByNameAndCountryAllIgnoringCase(String name, String country);

}
