package com.example.welcome.mvvm.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * @ClassName NewListEntity
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/8/20 14:53
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class NewListEntity {

    private Integer code;
    private List<DataBean> data;
    private String msg;

    public NewListEntity() {
    }

    public NewListEntity(Integer code, List<DataBean> data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataBean implements MultiItemEntity {
        private Integer id;
        private String newscode;
        private Integer newstypeid;
        private Integer sourcesiteid;
        private String sourcesitename;
        private String title;
        private String description;
        private String auth;
        private String sourceurl;
        private String mainimgurl;
        private String istop;
        private Integer Itemtype;

        public DataBean(Integer id, String newscode, Integer newstypeid, Integer sourcesiteid, String sourcesitename, String title, String description, String auth, String sourceurl, String mainimgurl, String istop, Integer itemtype) {
            this.id = id;
            this.newscode = newscode;
            this.newstypeid = newstypeid;
            this.sourcesiteid = sourcesiteid;
            this.sourcesitename = sourcesitename;
            this.title = title;
            this.description = description;
            this.auth = auth;
            this.sourceurl = sourceurl;
            this.mainimgurl = mainimgurl;
            this.istop = istop;
            Itemtype = itemtype;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getNewscode() {
            return newscode;
        }

        public void setNewscode(String newscode) {
            this.newscode = newscode;
        }

        public Integer getNewstypeid() {
            return newstypeid;
        }

        public void setNewstypeid(Integer newstypeid) {
            this.newstypeid = newstypeid;
        }

        public Integer getSourcesiteid() {
            return sourcesiteid;
        }

        public void setSourcesiteid(Integer sourcesiteid) {
            this.sourcesiteid = sourcesiteid;
        }

        public String getSourcesitename() {
            return sourcesitename;
        }

        public void setSourcesitename(String sourcesitename) {
            this.sourcesitename = sourcesitename;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getAuth() {
            return auth;
        }

        public void setAuth(String auth) {
            this.auth = auth;
        }

        public String getSourceurl() {
            return sourceurl;
        }

        public void setSourceurl(String sourceurl) {
            this.sourceurl = sourceurl;
        }

        public String getMainimgurl() {
            return mainimgurl;
        }

        public void setMainimgurl(String mainimgurl) {
            this.mainimgurl = mainimgurl;
        }

        public String getIstop() {
            return istop;
        }

        public void setIstop(String istop) {
            this.istop = istop;
        }

        public void setItemtype(Integer itemtype) {
            Itemtype = itemtype;
        }

        @Override
        public int getItemType() {
            return Itemtype;
        }
    }
}
