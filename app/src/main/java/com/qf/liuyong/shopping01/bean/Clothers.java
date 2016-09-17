package com.qf.liuyong.shopping01.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/9/6 0006.
 */
public class Clothers {

    /**
     * items : [{"component":{"componentType":"shopCategoryCell_v640","word":"连衣裙","picUrl":"http://s0.mingxingyichu.cn/group6/M00/3C/F6/wKgBjVdVmi2AbDLSAAA17pibmfg144.jpg","id":"194","en_title":"Jumper Dresses","action":{"title":"连衣裙","en_title":"Jumper Dresses","query":"连衣裙  ","id":"194","actionType":"searchWord"}}},{"component":{"componentType":"shopCategoryCell_v640","word":"半身裙","picUrl":"http://s0.mingxingyichu.cn/group6/M00/3C/F6/wKgBjVdVmjiALNIWAABe9V7WBSE541.jpg","id":"198","en_title":"Skirt","action":{"title":"半身裙","en_title":"Skirt","query":"半身裙","id":"198","actionType":"searchWord"}}},{"component":{"componentType":"shopCategoryCell_v640","word":"长裙","picUrl":"http://s0.mingxingyichu.cn/group6/M00/3C/F6/wKgBjVdVmkKAPtlMAAA2ewuetjg278.jpg","id":"203","en_title":"Long Dress","action":{"title":"长裙","en_title":"Long Dress","query":"长裙","id":"203","actionType":"searchWord"}}},{"component":{"componentType":"shopCategoryCell_v640","word":"礼服裙","picUrl":"http://s0.mingxingyichu.cn/group6/M00/3C/F6/wKgBjVdVmkiAManNAAAz2k8qtHk314.jpg","id":"286","en_title":"Evening Wear","action":{"title":"礼服裙","en_title":"Evening Wear","query":"礼服","id":"286","actionType":"searchWord"}}},{"component":{"componentType":"shopCategoryCell_v640","word":"A字裙","picUrl":"http://s0.mingxingyichu.cn/group6/M00/3C/F6/wKgBjVdVmlWAMuxKAABo4G6WUk4414.jpg","id":"192","en_title":"A-line Skirt","action":{"title":"A字裙","en_title":"A-line Skirt","query":"A字裙","id":"192","actionType":"searchWord"}}},{"component":{"componentType":"shopCategoryCell_v640","word":"铅笔裙","picUrl":"http://s0.mingxingyichu.cn/group6/M00/3C/F6/wKgBjVdVmmGAW5ZlAABtPL2ck8o068.jpg","id":"250","en_title":"Pencil skirts","action":{"title":"铅笔裙","en_title":"Pencil skirts","query":"铅笔裙","id":"250","actionType":"searchWord"}}},{"component":{"componentType":"shopCategoryCell_v640","word":"短裙","picUrl":"http://s0.mingxingyichu.cn/group6/M00/3C/F6/wKgBjVdVmm2AErIoAAAdCCyM2qU645.jpg","id":"285","en_title":"Mini Skirt","action":{"title":"短裙","en_title":"Mini Skirt","query":"短裙","id":"285","actionType":"searchWord"}}},{"component":{"componentType":"shopCategoryCell_v640","word":"百褶裙","picUrl":"http://s0.mingxingyichu.cn/group5/M00/89/9A/wKgBf1bKbUCAOfBOAAA4xemLEjo612.jpg","id":"288","en_title":"Pleated Skirts","action":{"title":"百褶裙","en_title":"Pleated Skirts","query":"百褶裙","id":"288","actionType":"searchWord"}}}]
     * cateimg : http://s0.mingxingyichu.cn/group5/M00/09/D3/wKgBfVeDSJSAUEt7AAJKrl5JLj0795.jpg
     * componentType : shopBigCategoryCell_v640
     * title : 裙子
     * en_title : Dresses
     * action : {"query":"裙子","title":"裙子","en_title":"Dresses","actionType":"searchWord"}
     */

    private ComponentBeans component;

    public ComponentBeans getComponent() {
        return component;
    }

    public void setComponent(ComponentBeans component) {
        this.component = component;
    }

    public static class ComponentBeans {
        private String title;
        /**
         * component : {"componentType":"shopCategoryCell_v640","word":"连衣裙","picUrl":"http://s0.mingxingyichu.cn/group6/M00/3C/F6/wKgBjVdVmi2AbDLSAAA17pibmfg144.jpg","id":"194","en_title":"Jumper Dresses","action":{"title":"连衣裙","en_title":"Jumper Dresses","query":"连衣裙  ","id":"194","actionType":"searchWord"}}
         */

        private List<ItemsBean> items;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean {
            /**
             * componentType : shopCategoryCell_v640
             * word : 连衣裙
             * picUrl : http://s0.mingxingyichu.cn/group6/M00/3C/F6/wKgBjVdVmi2AbDLSAAA17pibmfg144.jpg
             * id : 194
             * en_title : Jumper Dresses
             * action : {"title":"连衣裙","en_title":"Jumper Dresses","query":"连衣裙  ","id":"194","actionType":"searchWord"}
             */

            private ComponentBean component;

            public ComponentBean getComponent() {
                return component;
            }

            public void setComponent(ComponentBean component) {
                this.component = component;
            }

            public static class ComponentBean {
                private String word;
                private String picUrl;

                public String getWord() {
                    return word;
                }

                public void setWord(String word) {
                    this.word = word;
                }

                public String getPicUrl() {
                    return picUrl;
                }

                public void setPicUrl(String picUrl) {
                    this.picUrl = picUrl;
                }
            }
        }
    }
}
