package com.mengxuegu.springboot.utils;

public enum MessageConstants {

    PB_STATUS_FAIL(0, "失败"),
    PB_STATUS_SUCCESS(1, "成功"),
    PB_STATUS_UPLOAD_SUCCESS(2, "文件上传成功"),
    PB_STATUS_UPLOAD_FAILED(3, "文件上传失败"),
    PB_STATUS_DELETE_SUCCESS(4, "文件删除成功"),
    PB_STATUS_COLUMN_NOT_EXISTS(5, "接口参数缺少必要的字段: "),
    PB_STATUS_MENU_REDUPLICATED(6, "该菜单名已被使用"),
    PB_STATUS_MENU_CREATE_SUCCESS(7, "菜单创建成功"),
    PB_STATUS_MENU_UPDATE_SUCCESS(8, "菜单修改成功"),
    PB_STATUS_EMAIL_INPUT_ERROR(9, "请输入正确的电子邮箱"),
    PB_STATUS_PHONE_INPUT_ERROR(10, "请输入正确的手机号码"),
    PB_STATUS_USER_REDUPLICATED(11, "该用户名已被使用"),
    PB_STATUS_USER_CREATE_SUCCESS(12, "用户创建成功"),
    PB_STATUS_USER_UPDATE_SUCCESS(13, "用户信息修改成功"),
    PB_STATUS_USER_OVERTIME(14, "您未登录或者登录已超时,请先登录!"),
    PB_STATUS_PASSWORD_UPDATE_SUCCESS(18, "密码修改成功"),
    PB_STATUS_IMAGE_FILE_ERROR(19, "不支持的文件类型，仅支持图片!"),
    PB_STATUS_IMAGE_UPDATE_SUCCESS(20, "上传成功!"),
    PB_STATUS_IMAGE_UPDATE_FAIL(21, "上传失败!"),
    PB_STATUS_ROLE_CREATE_SUCCESS(22, "角色创建成功!"),
    PB_STATUS_ROLE_UPDATE_SUCCESS(23, "角色修改成功!"),
    PB_STATUS_ROLE_DELETE_SUCCESS(24, "角色删除成功!"),
    PB_STATUS_ROLE_DELETE_CHOOSE(25, "请选择要删除的角色!"),
    PB_STATUS_ERROR(999, "服务器错误"),
    EX_METHODNOTSUPPORTED(901, "服务端不支持特定的请求方法"),
    EX_MEDIATYPENOTSUPPORTED(902, "服务端不支持的类型"),
    EX_MEDIATYPENOTACCEPTABLE(903, "服务端不能生成客户端可以接受的响应"),
    EX_MISSINGPATHVARIABLE(904, "缺少URI变量"),
    EX_TYPEMISMATCH(905, "类型不匹配"),
    EX_METHODARGUMENTNOTVALID(906, "请求方法参数不合法"),
    FALLBACK_ERROR(907, "远程服务调用失败！"),
    GATEWAY_STATUS_PARAM_MISS(991, "缺少必要的参数"),
    GATEWAY_STATUS_TOKEN_MISS(992, "缺少必要的token"),
    GATEWAY_STATUS_TOKEN_VALID(993, "不合法的token"),
    GATEWAY_STATUS_USER_UNAUTH(994, "此账号尚未开通访问权限"),
    GATEWAY_STATUS_PARAM_ERROR(996, "参数错误"),
    GATEWAY_STATUS_LOGIN_ERROR(997, "登录失败! 用户或密码错误! "),
    GATEWAY_STATUS_GRANT_ERROR(998, "授权失败! ClientId或ClientKey错误! ");

    private Integer code;
    private String message;

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    private MessageConstants(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
