package com.kakaopaysec.test.customException;

public class BizRuntimeException extends RuntimeException{

    private static final long serialVersionUID = 7718828512143293558L;
    private final String code;

    public BizRuntimeException(String code) {
        super();
        this.code = code;
    }
    public BizRuntimeException(String message, Throwable cause, String code) {
        super(message, cause);
        this.code = code;
    }

    public BizRuntimeException(String code, String message) {
        super(message);
        this.code = code;
    }
    public BizRuntimeException(Throwable cause, String code) {
        super(cause);
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}
