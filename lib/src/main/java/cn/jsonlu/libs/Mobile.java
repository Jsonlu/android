package cn.jsonlu.libs;

import cn.jsonlu.libs.data.vo.BaseVo;

public class Mobile extends BaseVo{


    private MobileResult result;
    private String reason;
    private int error_code;

    public MobileResult getResult() {
        return this.result;
    }

    public void setResult(MobileResult result) {
        this.result = result;
    }

    public String getReason() {
        return this.reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getError_code() {
        return this.error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }
}
