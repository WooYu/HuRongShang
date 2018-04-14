package com.lcworld.shopdemo.base;

public class LoginResponse {

    /**
     * errCode : 0
     * expire : 604800
     * msg : success
     * token : 50d1cab9-fb22-4739-8365-9d6789f12f0a
     * user : {"areaId":0,"areainfo":"","avatar":"http://image.lcworld.cn/20170628/ced68edd770e4d339763019c82bd5fb0","cityId":0,"createTime":"2017-10-10 18:23:56","financialNumber":100000213,"loginTime":"2018-04-14 19:43:29","mainAccount":0,"mobile":"18627814613","nickname":"100000213","oldLoginTime":"2018-04-14 19:41:37","password":"e10adc3949ba59abbe56e057f20f883e","provinceId":0,"qrcode":"http://image.lcworld.cn/20171010/46e53ac2e4e34e3f8df86a6de8f1bb91","sex":0,"signature":"","status":"online","userId":213,"username":""}
     * userSettings : {"createTime":"2017-10-10 18:23:56","enterSend":"0","handsetPlayVoice":"1","id":192,"messageDetails":"1","messageShaking":"0","messageSound":"1","messageTone":"","mineBackgroundImage":"","nearbyPeopleAdd":"0","nearbyPeopleView":"0","newsNotification":"1","notDisturb":"0","reminder":"1","searchPhoneNumber":"1","strangerView":"1","temporaryGroupTime":"259200000","userId":213,"verification":"1"}
     */

    private int errCode;
    private int expire;
    private String msg;
    private String token;
    private UserBean user;
    private UserSettingsBean userSettings;

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public int getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public UserSettingsBean getUserSettings() {
        return userSettings;
    }

    public void setUserSettings(UserSettingsBean userSettings) {
        this.userSettings = userSettings;
    }

    public static class UserBean {
        /**
         * areaId : 0
         * areainfo :
         * avatar : http://image.lcworld.cn/20170628/ced68edd770e4d339763019c82bd5fb0
         * cityId : 0
         * createTime : 2017-10-10 18:23:56
         * financialNumber : 100000213
         * loginTime : 2018-04-14 19:43:29
         * mainAccount : 0
         * mobile : 18627814613
         * nickname : 100000213
         * oldLoginTime : 2018-04-14 19:41:37
         * password : e10adc3949ba59abbe56e057f20f883e
         * provinceId : 0
         * qrcode : http://image.lcworld.cn/20171010/46e53ac2e4e34e3f8df86a6de8f1bb91
         * sex : 0
         * signature :
         * status : online
         * userId : 213
         * username :
         */

        private int areaId;
        private String areainfo;
        private String avatar;
        private int cityId;
        private String createTime;
        private int financialNumber;
        private String loginTime;
        private int mainAccount;
        private String mobile;
        private String nickname;
        private String oldLoginTime;
        private String password;
        private int provinceId;
        private String qrcode;
        private int sex;
        private String signature;
        private String status;
        private int userId;
        private String username;

        public int getAreaId() {
            return areaId;
        }

        public void setAreaId(int areaId) {
            this.areaId = areaId;
        }

        public String getAreainfo() {
            return areainfo;
        }

        public void setAreainfo(String areainfo) {
            this.areainfo = areainfo;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public int getCityId() {
            return cityId;
        }

        public void setCityId(int cityId) {
            this.cityId = cityId;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getFinancialNumber() {
            return financialNumber;
        }

        public void setFinancialNumber(int financialNumber) {
            this.financialNumber = financialNumber;
        }

        public String getLoginTime() {
            return loginTime;
        }

        public void setLoginTime(String loginTime) {
            this.loginTime = loginTime;
        }

        public int getMainAccount() {
            return mainAccount;
        }

        public void setMainAccount(int mainAccount) {
            this.mainAccount = mainAccount;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getOldLoginTime() {
            return oldLoginTime;
        }

        public void setOldLoginTime(String oldLoginTime) {
            this.oldLoginTime = oldLoginTime;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public int getProvinceId() {
            return provinceId;
        }

        public void setProvinceId(int provinceId) {
            this.provinceId = provinceId;
        }

        public String getQrcode() {
            return qrcode;
        }

        public void setQrcode(String qrcode) {
            this.qrcode = qrcode;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }

    public static class UserSettingsBean {
        /**
         * createTime : 2017-10-10 18:23:56
         * enterSend : 0
         * handsetPlayVoice : 1
         * id : 192
         * messageDetails : 1
         * messageShaking : 0
         * messageSound : 1
         * messageTone :
         * mineBackgroundImage :
         * nearbyPeopleAdd : 0
         * nearbyPeopleView : 0
         * newsNotification : 1
         * notDisturb : 0
         * reminder : 1
         * searchPhoneNumber : 1
         * strangerView : 1
         * temporaryGroupTime : 259200000
         * userId : 213
         * verification : 1
         */

        private String createTime;
        private String enterSend;
        private String handsetPlayVoice;
        private int id;
        private String messageDetails;
        private String messageShaking;
        private String messageSound;
        private String messageTone;
        private String mineBackgroundImage;
        private String nearbyPeopleAdd;
        private String nearbyPeopleView;
        private String newsNotification;
        private String notDisturb;
        private String reminder;
        private String searchPhoneNumber;
        private String strangerView;
        private String temporaryGroupTime;
        private int userId;
        private String verification;

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getEnterSend() {
            return enterSend;
        }

        public void setEnterSend(String enterSend) {
            this.enterSend = enterSend;
        }

        public String getHandsetPlayVoice() {
            return handsetPlayVoice;
        }

        public void setHandsetPlayVoice(String handsetPlayVoice) {
            this.handsetPlayVoice = handsetPlayVoice;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMessageDetails() {
            return messageDetails;
        }

        public void setMessageDetails(String messageDetails) {
            this.messageDetails = messageDetails;
        }

        public String getMessageShaking() {
            return messageShaking;
        }

        public void setMessageShaking(String messageShaking) {
            this.messageShaking = messageShaking;
        }

        public String getMessageSound() {
            return messageSound;
        }

        public void setMessageSound(String messageSound) {
            this.messageSound = messageSound;
        }

        public String getMessageTone() {
            return messageTone;
        }

        public void setMessageTone(String messageTone) {
            this.messageTone = messageTone;
        }

        public String getMineBackgroundImage() {
            return mineBackgroundImage;
        }

        public void setMineBackgroundImage(String mineBackgroundImage) {
            this.mineBackgroundImage = mineBackgroundImage;
        }

        public String getNearbyPeopleAdd() {
            return nearbyPeopleAdd;
        }

        public void setNearbyPeopleAdd(String nearbyPeopleAdd) {
            this.nearbyPeopleAdd = nearbyPeopleAdd;
        }

        public String getNearbyPeopleView() {
            return nearbyPeopleView;
        }

        public void setNearbyPeopleView(String nearbyPeopleView) {
            this.nearbyPeopleView = nearbyPeopleView;
        }

        public String getNewsNotification() {
            return newsNotification;
        }

        public void setNewsNotification(String newsNotification) {
            this.newsNotification = newsNotification;
        }

        public String getNotDisturb() {
            return notDisturb;
        }

        public void setNotDisturb(String notDisturb) {
            this.notDisturb = notDisturb;
        }

        public String getReminder() {
            return reminder;
        }

        public void setReminder(String reminder) {
            this.reminder = reminder;
        }

        public String getSearchPhoneNumber() {
            return searchPhoneNumber;
        }

        public void setSearchPhoneNumber(String searchPhoneNumber) {
            this.searchPhoneNumber = searchPhoneNumber;
        }

        public String getStrangerView() {
            return strangerView;
        }

        public void setStrangerView(String strangerView) {
            this.strangerView = strangerView;
        }

        public String getTemporaryGroupTime() {
            return temporaryGroupTime;
        }

        public void setTemporaryGroupTime(String temporaryGroupTime) {
            this.temporaryGroupTime = temporaryGroupTime;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getVerification() {
            return verification;
        }

        public void setVerification(String verification) {
            this.verification = verification;
        }
    }
}
