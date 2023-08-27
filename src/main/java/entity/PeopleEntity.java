package entity;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@MongoEntity(collection = "people")
public class PeopleEntity extends PanacheMongoEntity {

	@NotNull
	@Size(min = 3, max = 50)
	public String name;

	public Integer age;
	
}
