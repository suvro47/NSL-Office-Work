package spring.nosql.redis;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExcepton extends RuntimeException {
    
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundExcepton(String message){
		super(message);
	}
}
