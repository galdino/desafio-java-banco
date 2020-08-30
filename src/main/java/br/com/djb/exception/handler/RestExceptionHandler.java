package br.com.djb.exception.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.djb.exception.CamposInvalidosDaoException;
import br.com.djb.model.DetalheErro;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
																  HttpHeaders headers, 
																  HttpStatus status, 
																  WebRequest request) {
		return handleExceptionInternal(ex, 
				DetalheErro.builder()
					.addDetalhe("A requisição possui valores inválidos, vazios ou nulos.")
					.addErro(ex.getMessage())
					.addStatus(HttpStatus.BAD_REQUEST)
					.addHttpMethod(getHttpMethod(request))
					.addPath(getPath(request))
					.build(), 
				new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	
	@ExceptionHandler({CamposInvalidosDaoException.class})
	public ResponseEntity<Object> camposInvalidos(CamposInvalidosDaoException ex, WebRequest request) {
		return handleExceptionInternal(ex, 
				DetalheErro.builder()
					.addDetalhe("A requisição possui valores inválidos, vazios ou nulos.")
					.addErro(ex.getMessage())
					.addStatus(HttpStatus.BAD_REQUEST)
					.addHttpMethod(getHttpMethod(request))
					.addPath(getPath(request))
					.build(), 
				new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	
	@ExceptionHandler({ NullPointerException.class, IllegalArgumentException.class })
	public ResponseEntity<Object> serverException(RuntimeException ex, WebRequest request) {

		return handleExceptionInternal(ex,
				DetalheErro.builder()
						.addDetalhe("Uma exceção foi lançada!")
						.addErro(ex.getMessage())
						.addStatus(HttpStatus.INTERNAL_SERVER_ERROR)
						.addHttpMethod(getHttpMethod(request))
						.addPath(getPath(request))
						.build(),
				new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
	}

	private String getPath(WebRequest request) {
		return ((ServletWebRequest) request).getRequest().getRequestURI();
	}

	private String getHttpMethod(WebRequest request) {
		return ((ServletWebRequest) request).getRequest().getMethod();
	}

}
