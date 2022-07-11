package com.mongo.example.mongodemo.controller;

//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.options;

import java.io.Console;
import java.lang.reflect.Field;
import java.util.List;
//import com.mongodb.client.MongoDatabase.getCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import com.mongo.example.mongodemo.config.SpringMongoConfig;
import com.mongo.example.mongodemo.models.CarHandler;
import com.mongo.example.mongodemo.models.RestCar;
import com.mongo.example.mongodemo.repo.CarInterface;
import com.mongo.example.mongodemo.repo.CarRepository;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;

@RestController
@RequestMapping("/car")
public class MyController {

	@Autowired
	private CarRepository carRepo;
	
	@Autowired 
	private MongoOperations mongo;

	@Autowired
	private CarHandler carHandler;

	@Autowired
	private CarInterface carService;

	private final CarInterface handler = new CarHandler();

	@Autowired
	MongoTemplate mongoTemplate;

	MongoClient mongoClient;
//	ApplicationContext ctx = 
//			new AnnotationConfigApplicationContext(SpringMongoConfig.class);
//	MongoOperations mongoOperation = 
//			(MongoOperations) ctx.getBean("mongoTemplate");

	private RestCar vw;

	@GetMapping("/speed")
	public ResponseEntity<?> getSpeed() {
		return ResponseEntity.ok(this.carRepo.findAll());
	}

//	@PostMapping("/addSpeed")
//	public ResponseEntity<?> addSpeed(@RequestBody RestCar restCar) {
////		RestCar save = this.carRepo.save(restCar);
//		RestCar save = this.carRepo.insert(restCar);
////		System.out.println("hhhhhhhhh");
//		return ResponseEntity.ok(save);
//	}
	
	@PostMapping("/addSpeed")
	public ResponseEntity<?> addSpeedtry(@RequestBody RestCar restCar) {
//		RestCar save = this.carRepo.save(restCar);
		if(restCar.getSpeed() >= 0 && restCar.getSpeed() <=20)
		{
			restCar.setLevel(1);
		}
		else if(restCar.getSpeed() > 20 && restCar.getSpeed() <= 40) {
			restCar.setLevel(2);
		}
		else if(restCar.getSpeed() > 40 && restCar.getSpeed() <= 60) {
			restCar.setLevel(3);
		}
		else if(restCar.getSpeed() > 60 && restCar.getSpeed() <= 80) {
			restCar.setLevel(4);
		}
		else if(restCar.getSpeed() > 80 && restCar.getSpeed() <= 100) {
			restCar.setLevel(5);
		}
		RestCar save = this.carRepo.insert(restCar);
//		System.out.println("hhhhhhhhh");
		return ResponseEntity.ok(save);
	}

	@PutMapping("/doorlock/{id}")
	public String handlingDoorUnlock( @PathVariable("id") int id) {
		Query query=new Query(Criteria.where("_id").is(id));
	    List<RestCar> restCar=mongoTemplate.find(query,RestCar.class);

	    if(restCar!=null){
//	    	System.out.println("if");
	        Update update=new Update().set("door","LOCK");
//	        Update up = new Update().set("sunroofSlider", 3);
	        UpdateResult result = mongoTemplate.updateFirst(query,update,RestCar.class);	
//	        System.out.println("count incre"+result.getModifiedCount());
	    }else{
System.out.println("else");		   
}		    
	return  "success";
	}

	@RequestMapping("/doorunlock/{id}")
	public String handlingDoorOff(@PathVariable("id") int id) {
		Query query=new Query(Criteria.where("_id").is(id));
	    List<RestCar> restCar=mongoTemplate.find(query,RestCar.class);

	    if(restCar!=null){
//	    	System.out.println("if");
	        Update update=new Update().set("door","UNLOCK");
//	        Update up = new Update().set("sunroofSlider", 3);
	        UpdateResult result = mongoTemplate.updateFirst(query,update,RestCar.class);	
//	        System.out.println("count incre"+result.getModifiedCount());
	    }else{
System.out.println("else");		   
}		    
	return  "success";
	}

	@RequestMapping("/trunkopen/{id}")
	public String handlingTrunkOpen(@PathVariable("id") int id) {
		Query query=new Query(Criteria.where("_id").is(id));
	    List<RestCar> restCar=mongoTemplate.find(query,RestCar.class);

	    if(restCar!=null){
	        Update update=new Update().set("trunk","OPEN");
	        UpdateResult result = mongoTemplate.updateFirst(query,update,RestCar.class);	
	        System.out.println("count incre"+result.getModifiedCount());
	    }else{
System.out.println("else");		   
}		    
	return  "success";
	}

	@RequestMapping("/trunkclose/{id}")
	public String handlingTrunkClose(@PathVariable("id") int id) {
		Query query=new Query(Criteria.where("_id").is(id));
	    List<RestCar> restCar=mongoTemplate.find(query,RestCar.class);

	    if(restCar!=null){
	        Update update=new Update().set("trunk","CLOSE");
	        UpdateResult result = mongoTemplate.updateFirst(query,update,RestCar.class);	
	        System.out.println("count incre"+result.getModifiedCount());
	    }else{
System.out.println("else");		   
}		    
	return  "success";
	}

//    @PutMapping("/actempincrease")
//    public String AcTempPlus(@RequestBody RestCar restCar) {
//    	
//    	if(restCar.getMinTemp()<16 && restCar.getMaxTemp()>30)
//    		System.out.println("InVlid Tempurature");
//    	return "tempurature changed";
//    }

	@RequestMapping("/acon/{id}")
	public String handlingACOn(@PathVariable("id") int id) {
		Query query=new Query(Criteria.where("_id").is(id));
	    List<RestCar> restCar=mongoTemplate.find(query,RestCar.class);

	    if(restCar!=null){
	        Update update=new Update().set("ac","ON");
	        UpdateResult result = mongoTemplate.updateFirst(query,update,RestCar.class);	
	        System.out.println("count incre"+result.getModifiedCount());
	    }else{
System.out.println("else");		   
}		    
	return  "success";
	}

	@RequestMapping("/acoff/{id}")
	public String handlingACOff(@PathVariable("id") int id) {
		Query query=new Query(Criteria.where("_id").is(id));
	    List<RestCar> restCar=mongoTemplate.find(query,RestCar.class);

	    if(restCar!=null){
	        Update update=new Update().set("ac","OFF");
	        UpdateResult result = mongoTemplate.updateFirst(query,update,RestCar.class);	
	        System.out.println("count incre"+result.getModifiedCount());
	    }else{
System.out.println("else");		   
}		    
	return  "success";
	}

	@PutMapping("/actempchange")
	public ResponseEntity<?> AcTempPlus(@RequestBody RestCar restCar) {
		RestCar save = this.carRepo.save(restCar);
		if (restCar.getMinTemp() < 16 && restCar.getMaxTemp() > 30)
			System.out.println("InVlid Tempurature");

		return ResponseEntity.ok(save);
	}

	@PutMapping("/decrsunroofslider/{id}")
	public String DecreSunroofSlider( @PathVariable("id") int id) {
		    Query query=new Query(Criteria.where("_id").is(id));
		    List<RestCar> restCar=mongoTemplate.find(query,RestCar.class);

		    if(restCar!=null){
//		    	System.out.println("if");
		        Update update=new Update().inc("sunroofSlider",-1);
//		        Update up = new Update().set("sunroofSlider", 3);
		        UpdateResult result = mongoTemplate.updateFirst(query,update,RestCar.class);	
		        System.out.println("count decre"+result.getModifiedCount());
		    }else{
System.out.println("else");		   
}		    
		return  "success";
	}

	@PutMapping("/incrsunroofslider/{id}")
	public String IncreSunroofSlider( @PathVariable("id") int id) {

		    Query query=new Query(Criteria.where("_id").is(id));
		    List<RestCar> restCar=mongoTemplate.find(query,RestCar.class);

		    if(restCar!=null){
//		    	System.out.println("if");
		        Update update=new Update().inc("sunroofSlider",1);
//		        Update up = new Update().set("sunroofSlider", 3);
		        UpdateResult result = mongoTemplate.updateFirst(query,update,RestCar.class);	
		        System.out.println("count incre"+result.getModifiedCount());
		    }else{
System.out.println("else");		   
}		    
		return  "success";
	}
	
//	@PutMapping("/incsunroofslider/{id}")
//	public String IncrementSunroofSlider( @PathVariable("id") int id) {
//		    Query query=new Query(Criteria.where("_id").is(id));
//		    List<RestCar> restCar=mongoTemplate.find(query,RestCar.class);
//		    System.out.println("restCar"+restCar);
//			   
//		    if(restCar!=null){
//		    	try {
//		    		System.out.println("try");
//				Update update=new Update().inc("sunroofSlider",1);
//		        RestCar r1= new RestCar();
//		        if(r1.getSunroofSlider()<6)
//	    		{
//		        	System.out.println("if");
//	    			System.out.println("r1.getSunroofSlider()"+r1.getSunroofSlider());
//
////		        		update.max("sunroofSlider",0);
////		        Update up = new Update().set("sunroofSlider", 3);
//		        UpdateResult result = mongoTemplate.updateFirst(query,update,RestCar.class);	
//		        System.out.println("result.getModifiedCount()"+result.getModifiedCount());
//		    		}
//		    	}
//		    	catch (Exception e) {
//		    		System.out.println("catch");
//		    		e.printStackTrace();
//}
//		    }else{
//System.out.println("else");		   
//}		    
//		return  "success";
//	}
//	
//	@PutMapping("/decsunroofslider/{id}")
//	public String DecrementSunroofSlider( @PathVariable("id") int id) {
//		    Query query=new Query(Criteria.where("_id").is(id));
//		    List<RestCar> restCar=mongoTemplate.find(query,RestCar.class);
//		   System.out.println("restCar"+restCar);
//		    if(restCar!=null ){
////		    	try {
////		    		System.out.println("try");
//		        Update update=new Update().inc("sunroofSlider",-1);
//		        UpdateResult result = mongoTemplate.updateFirst(query,update,RestCar.class);	
//		        System.out.println(result.getModifiedCount());
//RestCar r1 = new RestCar();
//Class cls = r1.getClass();
//try {
//Field sField = cls.getField("sunroofSlider");
//System.out.println("Public field found: " + sField);
//}
//catch (Exception e) {
//    System.out.println(e.toString());}
////	    			System.out.println("r1.getSunroofSlider() =>"+r1.getSunroofSlider());
////		        if(r1.getSunroofSlider()>0 && r1.getSunroofSlider()<=5)
////	    		{
////	    			System.out.println("if");
////
////		    		}
////		    	}
////		    	catch (Exception e) {
////		    		System.out.println("catch");
////		    		e.printStackTrace();
////}
//		    }
//		    else{
//System.out.println("else");		    } 
//		return  "Success";
//	}

//	@PutMapping("/sunroofslider/{id}")
//	public int SunroofSlider(@RequestBody RestCar restCar, @PathVariable("id") int id) {
//		System.out.println(id);
//		Query q = new Query().addCriteria(Criteria.where("_id").is(id));
//		System.out.println("qqqqqqqq");
//		int v = restCar.getSunroofSlider() + 1;
//		Update up = new Update().set("sunroofSlider", v);
//		System.out.println("up =" + up);
//		UpdateResult updateResult = mongoTemplate.updateFirst(q, up, RestCar.class);
//		System.out.println("updateResult " + updateResult);
//		return updateResult.getModifiedCount();	
//	}

//	@PutMapping("/sunroofslider/{_id}")
//	public String SunroofSlider(@RequestBody RestCar restCar,@PathVariable("_id") int id){
//  RestCar v = carHandler.incSlider(id, restCar);
//  carRepo.save(v);
//	System.out.println("id in controller "+id);
//	return "controll";
//	
//}

//private MongoClient getMongoClient() {
//	if (mongoClient== null)
//	{
//		mongoClient = new MongoClient("localhost",27017);
//	}
//}
	
//    @PostMapping
//	public Vendor addVendor(@Valid @RequestBody Vendor v) {
//		return vendorService.addVendor(v);
//	}
//
//	@PutMapping
//	public ResponseEntity<?> updateVendor(@Valid @RequestBody Vendor v) {
//		return new ResponseEntity<>(vendorService.addVendor(v), HttpStatus.ACCEPTED);
//	}

//    
//    @PostMapping("/ACTempDecrease")
//    public int AcTempMinus() {
//    	
//    }
//	@GetMapping("/fan/{level}")
//	public Fan getSpeed(@PathVariable String level) {
//		return this.fanService.getFanSpeedByLevel(Integer.parseInt(level));
//	}

//	@PostMapping("/doors/{id}")
//    public String DoorHandlingOff (@PathVariable String id,@RequestParam(value="name", defaultValue="OFF")String name) {
//            return handler.handlingDoor(Integer.parseInt(id),name);
//    }
}
