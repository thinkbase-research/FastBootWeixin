package com.example.myproject.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.fasterxml.jackson.annotation.JsonProperty;

// 待支持：参数从变量中取
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WxButton {

    // 按钮属于哪一组
    Group group();

    /**
     * 显示名称
     * @return
     */
    String name();

    // 菜单类型
    Type type() default Type.CLICK;

    // 是否是主菜单(下面的菜单)
    boolean main() default false;

    // 顺序
    Order order() default Order.FIRST;

    /**
     * 这里可以写一个自动生成key的策略
     * @return
     */
    String key() default "";

    String url() default "";

    String mediaId() default "";

    // 哪个按钮组
    enum Group {
        LEFT, MIDDLE, RIGHT
    }

    // 顺序，最多五个
    enum Order {
        FIRST, SECOND, THIRD, FORTH, FIFTH
    }

    // 类型
    enum Type {

        /**
         * 点击推事件
         */
        @JsonProperty("click")
        CLICK,

        /**
         * 跳转URL
         */
        @JsonProperty("view")
        VIEW,

        /**
         * 扫码推事件
         */
        @JsonProperty("scancode_push")
        SCANCODE_PUSH,

        /**
         * 扫码推事件且弹出“消息接收中”提示框
         */
        @JsonProperty("scancode_waitmsg")
        SCANCODE_WAITMSG,

        /**
         * 弹出系统拍照发图
         */
        @JsonProperty("pic_sysphoto")
        PIC_SYSPHOTO,

        /**
         * 弹出拍照或者相册发图
         */
        @JsonProperty("pic_photo_or_album")
        PIC_PHOTO_OR_ALBUM,

        /**
         * 弹出微信相册发图器
         */
        @JsonProperty("pic_weixin")
        PIC_WEIXIN,

        /**
         * 弹出地理位置选择器
         */
        @JsonProperty("location_select")
        LOCATION_SELECT,

        /**
         * 下发消息（除文本消息）
         */
        @JsonProperty("media_id")
        MEDIA_ID,

        /**
         * 跳转图文消息URL
         */
        @JsonProperty("view_limited")
        VIEW_LIMITED;

    }

}
