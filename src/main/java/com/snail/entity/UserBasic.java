package com.snail.entity;

/**
 * User: jinchao.xu
 * Date: 14-10-15
 * Time: 下午2:57
 */
public class UserBasic {

    private int id;

    private String name;

    private String headUrl;

    private String userType;

    private String sex;

    private String declaration;

    /**
     * 0:default image;1:upload image
     */
    private String headUrlFlag;

    private String guideStep;

    private String hot;


    /**
     * 认证员工的标志：1为认证 2为取消
     */
    private int validFlag;

    /**
     * 用户身份信息:
     * type: 1为教育经历，2为工作经验;
     */
    private int namecardInfoType;
    private int namecardInfoId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDeclaration() {
        return declaration;
    }

    public void setDeclaration(String declaration) {
        this.declaration = declaration;
    }

    public String getHeadUrlFlag() {
        return headUrlFlag;
    }

    public void setHeadUrlFlag(String headUrlFlag) {
        this.headUrlFlag = headUrlFlag;
    }

    public String getGuideStep() {
        return guideStep;
    }

    public void setGuideStep(String guideStep) {
        this.guideStep = guideStep;
    }

    public String getHot() {
        return hot;
    }

    public void setHot(String hot) {
        this.hot = hot;
    }

    public int getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(int validFlag) {
        this.validFlag = validFlag;
    }

    public int getNamecardInfoType() {
        return namecardInfoType;
    }

    public void setNamecardInfoType(int namecardInfoType) {
        this.namecardInfoType = namecardInfoType;
    }

    public int getNamecardInfoId() {
        return namecardInfoId;
    }

    public void setNamecardInfoId(int namecardInfoId) {
        this.namecardInfoId = namecardInfoId;
    }
}
