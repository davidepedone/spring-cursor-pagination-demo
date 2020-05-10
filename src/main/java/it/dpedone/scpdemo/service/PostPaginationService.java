package it.dpedone.scpdemo.service;

import it.davidepedone.scp.service.CursorPaginationService;
import it.dpedone.scpdemo.entities.Post;
import it.dpedone.scpdemo.utils.PostSearchFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * @author Davide Pedone https://github.com/davidepedone
 */
@Service
@Slf4j
public class PostPaginationService extends CursorPaginationService<Post, PostSearchFilter> {

	public PostPaginationService(MongoOperations mongoOperations) {
		super(mongoOperations, List.of("createdAt", "author"), Post.class);
	}

	@Override
	public void configSearchQuery(Query query, PostSearchFilter filter, Principal principal) {
		Optional.ofNullable(filter.getAuthor()).ifPresent(a -> {
			query.addCriteria(where("author").is(a));
		});
	}

}
