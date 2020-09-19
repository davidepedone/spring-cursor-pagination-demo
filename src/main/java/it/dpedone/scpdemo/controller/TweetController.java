package it.dpedone.scpdemo.controller;

import it.davidepedone.scp.data.CursorPageable;
import it.davidepedone.scp.hateoas.SlicedModel;
import it.davidepedone.scp.hateoas.SlicedResourcesAssembler;
import it.davidepedone.scp.pagination.CursorPaginationSlice;
import it.dpedone.scpdemo.entities.Tweet;
import it.dpedone.scpdemo.hateoas.TweetResourceAssembler;
import it.dpedone.scpdemo.service.TweetPaginationService;
import it.dpedone.scpdemo.utils.TweetSearchFilter;
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
@RequestMapping(value = "/tweets")
public class TweetController {

	private final TweetPaginationService tweetPaginationService;

	private final TweetResourceAssembler tweetResourceAssembler;

	private final SlicedResourcesAssembler<Tweet> tweetSlicedResourcesAssembler;

	@GetMapping
	public CursorPaginationSlice<Tweet> getAll(TweetSearchFilter tweetSearchFilter, CursorPageable cursorPageable)
			throws Exception {
		return tweetPaginationService.executeQuery(cursorPageable, tweetSearchFilter, null);
	}

	@GetMapping("/hateoas")
	public ResponseEntity<SlicedModel<EntityModel<Tweet>>> getAllHateoas(TweetSearchFilter tweetSearchFilter,
																		 CursorPageable cursorPageable) throws Exception {
		CursorPaginationSlice<Tweet> tweets = tweetPaginationService.executeQuery(cursorPageable, tweetSearchFilter, null);
		return new ResponseEntity<>(tweetSlicedResourcesAssembler.toModel(tweets, tweetResourceAssembler), HttpStatus.OK);
	}

}
