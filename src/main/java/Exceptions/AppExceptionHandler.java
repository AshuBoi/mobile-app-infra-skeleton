package Exceptions;

import com.AshuBoi.app.ws.mobile_app_ws.Model.response.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

// if we do not have this then this part cannot listen to the executions that take place in this application
@ControllerAdvice                        // ResponseEntityExceptionHandler provides central exception handling across all controllers
public class AppExceptionHandler extends ResponseEntityExceptionHandler  { //

    @ExceptionHandler(value ={Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {
        String errorMessageDesc = ex.getLocalizedMessage();

        if(errorMessageDesc == null) errorMessageDesc = ex.toString();

        ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getLocalizedMessage());

        return new ResponseEntity<>(
                errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
                // public ResponseEntity(     @Nullable T body,
        //    @Nullable org. springframework. util. MultiValueMap<String, String> headers,
        //    @NotNull   org. springframework. http. HttpStatusCode statusCode )
    }

    @ExceptionHandler(value ={NullPointerException.class, UserServiceException.class})//you can add multiple classes to be handled by same function
    public ResponseEntity<Object> handleSpecificException(Exception ex, WebRequest request) {
        String errorMessageDesc = ex.getLocalizedMessage();

        if (errorMessageDesc == null) errorMessageDesc = ex.toString();

        ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getLocalizedMessage());

        return new ResponseEntity<>(
                errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

//    @ExceptionHandler(value ={UserServiceException.class})
//    public ResponseEntity<Object> handleUserServiceException(UserServiceException ex, WebRequest request) {
//        String errorMessageDesc = ex.getLocalizedMessage();
//
//        if (errorMessageDesc == null) errorMessageDesc = ex.toString();
//
//        ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getLocalizedMessage());
//
//        return new ResponseEntity<>(
//                errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}
