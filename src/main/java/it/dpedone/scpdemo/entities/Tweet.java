package it.dpedone.scpdemo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Davide Pedone https://github.com/davidepedone
 */
@Data
@Document(collection = "tweets")
@NoArgsConstructor
public class Tweet {

	@JsonIgnore
	private ObjectId id;

	private String author;

	private String content;

	private Long createdAt;

	public Tweet(String author, String content, Long createdAt) {
		this.author = author;
		this.content = content;
		this.createdAt = createdAt;
	}
}
