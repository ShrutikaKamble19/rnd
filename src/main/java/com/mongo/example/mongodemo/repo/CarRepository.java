package com.mongo.example.mongodemo.repo;

import java.util.List;

//import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mongo.example.mongodemo.models.RestCar;

@Repository
public interface CarRepository extends MongoRepository<RestCar, Integer>{
	
	
//mysql
//	@Query(value="UPDATE cars SET car_slider = car_slider + 1  WHERE id = :id", nativeQuery = true)
//	@Modifying
//	void incSlider(@Param("id") long id);
	
//	@Modifying
//	@Query(value="UPDATE cars SET car_slider = car_slider + 1  WHERE id = :id", upsert = true)
//	void incSlider(@Param("id") long id);
	
	
//	@Query(value="db.cars.update({ \"_id\":\"?\"},{ $inc: { SunroofSlider: 1 } }, {upsert:true})")
//	List<RestCar> incSlider();

//    @Query(value="{ \"_id\":\"?1\" }", fields="{ $inc: { \"SunroofSlider\": 1 } }")
//    List<RestCar> incSlider();
    
//	@Modifying
//	@Query(value="db.cars.updateOne({ \"_id\":\"?1\" },{ $inc: { \"SunroofSlider\": 1 } } )")
//	List<RestCar> incSlider();
	
//	@Query("{'_id':?0 }, {'$inc':{'sunroofSlider':1}}")
//	public List<RestCar> incFreq(int id);
	
	
//	@Query("{'_id': ?0},{'$inc': {'sunroofSlider':1}}")
	@Query("{ speed: {$eq: ?0} }")
	public List<RestCar> incSlider(int speed);
//	db.cars.update({ _id:1 },{ $inc: { SunroofSlider: 1 } }, {upsert:true})
}


