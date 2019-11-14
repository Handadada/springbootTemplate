package com.example.bootDemo.response;



import com.example.bootDemo.enums.ErrorEnum;
import lombok.Data;


@Data
public class ResponseVO<T> {

    private Integer code;

    private String msg;

    private T data;

    private ResponseVO(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private ResponseVO(ErrorEnum error) {
        this.code = error.getCode();
        this.msg = error.getDesc();
    }

    public static ResponseVO success() {
        return new ResponseVO(ErrorEnum.SUCCESS);
    }

    public static <T> ResponseVO success(T data) {
        ResponseVO responseVO = new ResponseVO(ErrorEnum.SUCCESS);
        responseVO.setData(data);
        return responseVO;
    }

    public static ResponseVO fail(ErrorEnum error) {
        return new ResponseVO(error);
    }

    public static ResponseVO fail(String msg) {
        ResponseVO responseVO = new ResponseVO(ErrorEnum.FAIL);
        responseVO.setMsg(msg);
        return responseVO;
    }


}
