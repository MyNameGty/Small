package com.jiyun.mvp_wb.bean;

import java.util.List;

public class LeiXingBean {

    /**
     * ERRORCODE : 0
     * RESULT : ["hot","top","novelty","bangdan","gaoxiao","shehui","fashion","movie","girl","sports","dongman"]
     */

    private String ERRORCODE;
    private List<String> RESULT;

    public String getERRORCODE() {
        return ERRORCODE;
    }

    public void setERRORCODE(String ERRORCODE) {
        this.ERRORCODE = ERRORCODE;
    }

    public List<String> getRESULT() {
        return RESULT;
    }

    public void setRESULT(List<String> RESULT) {
        this.RESULT = RESULT;
    }
}
