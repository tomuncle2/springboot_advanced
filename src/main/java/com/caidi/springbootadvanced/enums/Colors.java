package com.caidi.springbootadvanced.enums;


public enum Colors{
    RED(1,"红色"),
    BLACK(2,"黑色"),
     YELLOW();

     private String describe;
     private Integer code;

     Colors(Integer code, String describe){
         this.code = code;
         this.describe = describe;
     }

     Colors(){
         this.code = 3;
         this.describe = "默认";
     }



     public String getDescribe() {
         return describe;
     }

     public void setDescribe(String describe) {
         this.describe = describe;
     }

     public Integer getCode() {
         return code;
     }

     public void setCode(Integer code) {
         this.code = code;
     }
 }
