package it.dpedone.scpdemo.hateoas;

import it.dpedone.scpdemo.entities.Tweet;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

/**
 * @author Davide Pedone https://github.com/davidepedone
 */
@Component
public class TweetResourceAssembler implements RepresentationModelAssembler<Tweet, EntityModel<Tweet>> {

	@Override
	public EntityModel<Tweet> toModel(Tweet entity) {
		return EntityModel.of(entity);
	}

}
