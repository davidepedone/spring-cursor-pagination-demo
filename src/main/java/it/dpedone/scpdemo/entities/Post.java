package it.dpedone.scpdemo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Davide Pedone https://github.com/davidepedone
 */
@Data
@Document(collection = "posts")
public class Post {

	@JsonIgnore
	private ObjectId id;

	private String author;

	private String content;

	private Long createdAt;

}
