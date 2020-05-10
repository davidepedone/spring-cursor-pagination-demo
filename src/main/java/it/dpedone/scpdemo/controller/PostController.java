package it.dpedone.scpdemo.controller;

import it.davidepedone.scp.hateoas.SlicedModel;
import it.davidepedone.scp.hateoas.SlicedResourcesAssembler;
import it.davidepedone.scp.pagination.CursorPaginationSlice;
import it.dpedone.scpdemo.entities.Post;
import it.dpedone.scpdemo.hateoas.PostResourceAssembler;
import it.dpedone.scpdemo.service.PostPaginationService;
import it.dpedone.scpdemo.utils.PostSearchFilter;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Davide Pedone https://github.com/davidepedone
 */
@AllArgsConstructor
@RestController
@RequestMapping(value = "/posts")
public class PostController {

	private final PostPaginationService postPaginationService;

	private final PostResourceAssembler postResourceAssembler;

	private final SlicedResourcesAssembler<Post> postSlicedResourcesAssembler;

	@GetMapping
	public CursorPaginationSlice<Post> getAll(PostSearchFilter postSearchFilter) throws Exception {
		return postPaginationService.executeQuery(postSearchFilter, null);
	}

	@GetMapping("/hateoas")
	public ResponseEntity<SlicedModel<EntityModel<Post>>> getAllHateoas(PostSearchFilter postSearchFilter)
			throws Exception {
		CursorPaginationSlice<Post> posts = postPaginationService.executeQuery(postSearchFilter, null);
		return new ResponseEntity<>(postSlicedResourcesAssembler.toModel(posts, postResourceAssembler), HttpStatus.OK);
	}

}
