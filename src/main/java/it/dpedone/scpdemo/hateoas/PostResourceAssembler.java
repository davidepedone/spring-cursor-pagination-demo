package it.dpedone.scpdemo.hateoas;

import it.dpedone.scpdemo.entities.Post;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

/**
 * @author Davide Pedone https://github.com/davidepedone
 */
@Component
public class PostResourceAssembler implements RepresentationModelAssembler<Post, EntityModel<Post>> {

	@Override
	public EntityModel<Post> toModel(Post entity) {
		return EntityModel.of(entity);
	}

}
