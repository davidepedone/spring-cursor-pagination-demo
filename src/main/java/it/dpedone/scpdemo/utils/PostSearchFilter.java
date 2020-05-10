package it.dpedone.scpdemo.utils;

import it.davidepedone.scp.search.CursorPaginationSearchFilter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Davide Pedone https://github.com/davidepedone
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostSearchFilter extends CursorPaginationSearchFilter implements Serializable {

	private static final long serialVersionUID = -3265178356980370638L;

	private String author;

}
