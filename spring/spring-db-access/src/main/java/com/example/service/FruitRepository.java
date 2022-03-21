//package com.example.service;
//
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.Optional;
//
//@Component
//public class FruitRepository {
//    public List<Fruit> findAll() {
//        return null;
//    }
//
//    public Fruit save(Fruit fruit) {
//
//        return fruit;
//    }
//
//    public Optional<Fruit> findById(Long id) {
//        return null;
//    }
//
//    public void deleteById(Long id) {
//
//    }
//}


package com.example.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FruitRepository extends CrudRepository<Fruit, Long> {
	  List<Fruit> findByName(String name);

	    default List<Fruit> findAllFruitsByName(String name) {
	        return findByName(name);
	    }

	    @Query("select f from Fruit f where f.name like %?1")
	    List<Fruit> findByNameLike(String name);
// TODO query methods
}
