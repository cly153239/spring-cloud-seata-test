package com.cly.seata.common.constant;

public interface CommonConstant {
	
	/** {@code 500 Server Error} (HTTP/1.0 - RFC 1945) */
    public static final Integer SC_INTERNAL_SERVER_ERROR_500 = 500;
    /** {@code 200 OK} (HTTP/1.0 - RFC 1945) */
    public static final Integer SC_OK_200 = 200;
    
    /**访问权限认证未通过 510*/
    public static final Integer SC_JEECG_NO_AUTHZ=510;

    /** 用户重复登录 */
    public static final Integer SC_REPEAT_LOGIN=520;

    /** 用户未选择当前项目 */
    public static final Integer SC_PROJECT_NOT_SELECT=530;


}
