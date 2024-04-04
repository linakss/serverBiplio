package bip.online.biplio2023.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse {
    protected boolean success;
    protected String message;
}
