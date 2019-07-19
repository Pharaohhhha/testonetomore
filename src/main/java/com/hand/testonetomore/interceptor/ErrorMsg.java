package com.hand.testonetomore.interceptor;

/**
 * @author 谭春
 * Date: 2019/7/17
 * Description:
 */
public class ErrorMsg {
    private String errorCode;
    private String errorMsg;

    public ErrorMsg(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}

