package com.ironghui.datatree.DataBean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class DictionaryEntity implements Serializable {

    /**
     * result : 000
     * parentId : 902805256168013824
     * map : {"3":"待离职","2":"正式员工","1":"试用期","0":"入职待审批","6":"托管","5":"退休","4":"已离职"}
     * list : [{"createTime":"2018-01-17 14:14:35","dicValName":"入职待审批","dicvalId":"953510841943064576","memo":"","parentId":"902805256168013824","value":"0"},{"createTime":"2017-08-30 16:09:39","dicValName":"试用期","dicvalId":"902805498129022976","memo":"","parentId":"902805256168013824","value":"1"},{"createTime":"2017-08-30 16:09:50","dicValName":"正式员工","dicvalId":"902805544404779008","memo":"","parentId":"902805256168013824","value":"2"},{"createTime":"2017-08-30 16:09:59","dicValName":"待离职","dicvalId":"902805582082211840","memo":"","parentId":"902805256168013824","value":"3"},{"createTime":"2017-08-30 16:10:07","dicValName":"已离职","dicvalId":"902805617884790784","memo":"","parentId":"902805256168013824","value":"4"},{"createTime":"2017-08-30 16:10:17","dicValName":"退休","dicvalId":"902805659727167488","memo":"","parentId":"902805256168013824","value":"5"},{"createTime":"2018-01-16 15:20:39","dicValName":"托管","dicvalId":"953165080810225664","memo":"","parentId":"902805256168013824","value":"6"}]
     * msg : success
     */

    private String result;
    private long parentId;
    private MapBean map;
    private String msg;
    private List<ListBean> list;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public MapBean getMap() {
        return map;
    }

    public void setMap(MapBean map) {
        this.map = map;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class MapBean implements Serializable {
        /**
         * 3 : 待离职
         * 2 : 正式员工
         * 1 : 试用期
         * 0 : 入职待审批
         * 6 : 托管
         * 5 : 退休
         * 4 : 已离职
         */

        @SerializedName("3")
        private String _$3;
        @SerializedName("2")
        private String _$2;
        @SerializedName("1")
        private String _$1;
        @SerializedName("0")
        private String _$0;
        @SerializedName("6")
        private String _$6;
        @SerializedName("5")
        private String _$5;
        @SerializedName("4")
        private String _$4;

        public String get_$3() {
            return _$3;
        }

        public void set_$3(String _$3) {
            this._$3 = _$3;
        }

        public String get_$2() {
            return _$2;
        }

        public void set_$2(String _$2) {
            this._$2 = _$2;
        }

        public String get_$1() {
            return _$1;
        }

        public void set_$1(String _$1) {
            this._$1 = _$1;
        }

        public String get_$0() {
            return _$0;
        }

        public void set_$0(String _$0) {
            this._$0 = _$0;
        }

        public String get_$6() {
            return _$6;
        }

        public void set_$6(String _$6) {
            this._$6 = _$6;
        }

        public String get_$5() {
            return _$5;
        }

        public void set_$5(String _$5) {
            this._$5 = _$5;
        }

        public String get_$4() {
            return _$4;
        }

        public void set_$4(String _$4) {
            this._$4 = _$4;
        }
    }

    public static class ListBean {
        /**
         * createTime : 2018-01-17 14:14:35
         * dicValName : 入职待审批
         * dicvalId : 953510841943064576
         * memo :
         * parentId : 902805256168013824
         * value : 0
         */

        private String createTime;
        private String dicValName;
        private String dicvalId;
        private String memo;
        private String parentId;
        private String value;

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getDicValName() {
            return dicValName;
        }

        public void setDicValName(String dicValName) {
            this.dicValName = dicValName;
        }

        public String getDicvalId() {
            return dicvalId;
        }

        public void setDicvalId(String dicvalId) {
            this.dicvalId = dicvalId;
        }

        public String getMemo() {
            return memo;
        }

        public void setMemo(String memo) {
            this.memo = memo;
        }

        public String getParentId() {
            return parentId;
        }

        public void setParentId(String parentId) {
            this.parentId = parentId;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
