package kg.megacom.ChannelGo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ChannelNotFoundException extends RuntimeException{
    public ChannelNotFoundException(String message){
        super(message);
    }
}
