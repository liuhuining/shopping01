package com.qf.liuyong.shopping01.bean;

/**
 * Created by Administrator on 2016/9/16.
 */
public class DetailClother {


    /**
     * componentType : item
     * publish_date : 2016
     * picUrl : http://s2.mingxingyichu.cn/group6/M00/B0/0E/wKgBjVUc9biAYiMmAAEko-0l564130.jpg?imageMogr2/format/WEBP/thumbnail/320x%3E
     * price : 199
     * origin_price : 539
     * id : 3938564
     * description : 榭都 条纹高腰V领短款T恤
     * trackValue : item_sku_3938564
     * eventIcon :
     * stateMessage :
     * country : 国内
     * nationalFlag : http://s0.mingxingyichu.cn/group6/M00/53/AB/wKgBjVeqzaKAEw9BAAAD_m-28wU681.png
     * sales : 231
     * action : {"actionType":"detail","type":"sku","id":"3938564","source":"ecshop","sourceId":"1032380","width":"354","height":"530","main_image":0,"collectionCount":"0","trackValue":"item_sku_3938564"}
     * collectionCount : 0
     */

    private ComponentBean component;

    public ComponentBean getComponent() {
        return component;
    }

    public void setComponent(ComponentBean component) {
        this.component = component;
    }

    public static class ComponentBean {
        private String picUrl;
        private String price;
        private String origin_price;
        private String description;
        private String sales;
        /**
         * actionType : detail
         * type : sku
         * id : 3938564
         * source : ecshop
         * sourceId : 1032380
         * width : 354
         * height : 530
         * main_image : 0
         * collectionCount : 0
         * trackValue : item_sku_3938564
         */

        private ActionBean action;

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getOrigin_price() {
            return origin_price;
        }

        public void setOrigin_price(String origin_price) {
            this.origin_price = origin_price;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getSales() {
            return sales;
        }

        public void setSales(String sales) {
            this.sales = sales;
        }

        public ActionBean getAction() {
            return action;
        }

        public void setAction(ActionBean action) {
            this.action = action;
        }

        public static class ActionBean {
            private String sourceId;

            public String getSourceId() {
                return sourceId;
            }

            public void setSourceId(String sourceId) {
                this.sourceId = sourceId;
            }
        }
    }
}
