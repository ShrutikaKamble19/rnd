package com.mongo.example.mongodemo.models;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mongo.example.mongodemo.repo.CarInterface;
import com.mongo.example.mongodemo.repo.CarRepository;
import com.mongodb.client.result.UpdateResult;

@Service
public class CarHandler implements CarInterface {

	@Autowired
	private CarRepository carRepo;
	
	@Autowired
    MongoTemplate mongoTemplate;
	
	@Override
	public String handling(String door) {
		// TODO Auto-generated method stub
		return String.format( door);
	}

	@Override
	public RestCar incSlider(int id, RestCar restCar) {
	      return restCar;
	}	
//		Optional<RestCar> findById = carRepo.findById(id);
//		List<RestCar> v = carRepo.incSlider();
//		carRepo.saveAll((Iterable<RestCar>) v);		
//		if(findById.isPresent()) {
//			RestCar use = findById.get();
//			System.out.println(use);
//			if(slider.getSunroofSlider() != -1 && slider.getSunroofSlider() != 6){
//			 use.setSunroofSlider(slider.getSunroofSlider()+1);		
//			System.out.println(slider.getSunroofSlider());
//			System.out.println("vvv1 " +v);	
//			carRepo.save(use);						
//			System.out.println("vvv " +v);
//			System.out.println("saveuse "+carRepo.save(use));
//			}		
//		 carRepo.incSlider();
//System.out.println(carRepo.incSlider());
//		}
//		System.out.println("id in handler "+restCar.getSunroofSlider());

		
}
