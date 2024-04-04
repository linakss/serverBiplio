package bip.online.biplio2023.response;

import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DataResponse<T> extends BaseResponse{
    private T data;
    public DataResponse(boolean success, String message, T data){
        super(success,message);
        this.data = data;
    }
}
