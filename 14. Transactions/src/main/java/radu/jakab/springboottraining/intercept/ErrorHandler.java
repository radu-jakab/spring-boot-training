package radu.jakab.springboottraining.intercept;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.zalando.problem.Problem;
import org.zalando.problem.ThrowableProblem;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({DeliveryI18NException.class})
    public ResponseEntity<I18NErrorDTO> handleI18NException(DeliveryI18NException ex) {
        I18NErrorDTO response = new I18NErrorDTO();
        response.setCode(HttpStatus.IM_USED.toString());
        response.setMessage(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.IM_USED);
    }

    @ExceptionHandler({ThrowableProblem.class})
    public ResponseEntity<Problem> handleProblem(ThrowableProblem ex) {
        return new ResponseEntity<>(ex, HttpStatus.I_AM_A_TEAPOT);
    }
}
