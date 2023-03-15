package med.vol.api.infra;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ErrorHandling {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<Void> errorHandler404() {
		return ResponseEntity.notFound().build();
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<DataErrorValidation>> errorHandler400(MethodArgumentNotValidException e) {
		var error = e.getFieldErrors();
		return ResponseEntity.badRequest().body(error.stream().map(DataErrorValidation::new).toList());
	}

	
	private record DataErrorValidation(String message, String field) {
		public DataErrorValidation(FieldError erro) {
			this(erro.getField(), erro.getDefaultMessage());
		}
	}
}
