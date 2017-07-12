package com.bw.shinelon.day07;

import java.util.List;

public class RootBean {


    /**
     * newslist : {"news":[{"title":"程序员因写代码太乱被杀害","detail":"凶手是死者同事，维护死者代码时完全看不懂而痛下杀手","comment":"16359","image":"http://huixinguiyu.cn/Assets/images/a1.png"},{"title":"产品经理因频繁改需求被杀害","detail":"凶手是一名程序员，因死者对项目需求频繁改动而痛下杀手","comment":"14112","image":"http://huixinguiyu.cn/Assets/images/a2.png"},{"title":"3Q大战宣判: 腾讯获赔500万","detail":"最高法驳回360上诉, 维持一审宣判.","comment":"6427","image":"http://huixinguiyu.cn/Assets/images/a3.png"},{"title":"今日之声:北大雕塑被戴口罩","detail":"市民: 因雾霾起诉环保局; 公务员谈\"紧日子\": 坚决不出去.","comment":"681","image":"http://huixinguiyu.cn/Assets/images/a4.png"},{"title":"奥巴马见达赖是装蒜","detail":"外文局: 国际民众认可中国大国地位;法院: \"流量清零\"未侵权.","comment":"1359","image":"http://huixinguiyu.cn/Assets/images/a5.png"},{"title":"轻松一刻: 我要沉迷学习不自拔","detail":"放假时我醒了不代表我起床了, 如今我起床了不代表我醒了!","comment":"11616","image":"http://huixinguiyu.cn/Assets/images/a6.png"},{"title":"今日之声:北大雕塑被戴口罩","detail":"市民: 因雾霾起诉环保局; 公务员谈\"紧日子\": 坚决不出去.","comment":"681","image":"http://huixinguiyu.cn/Assets/images/a7.png"},{"title":"奥巴马见达赖是装蒜","detail":"外文局: 国际民众认可中国大国地位;法院: \"流量清零\"未侵权.","comment":"1359","image":"http://huixinguiyu.cn/Assets/images/a7.png"}]}
     */

    private NewslistEntity newslist;

    public void setNewslist(NewslistEntity newslist) {
        this.newslist = newslist;
    }

    public NewslistEntity getNewslist() {
        return newslist;
    }

    public static class
    NewslistEntity {
        /**
         * news : [{"title":"程序员因写代码太乱被杀害","detail":"凶手是死者同事，维护死者代码时完全看不懂而痛下杀手","comment":"16359","image":"http://huixinguiyu.cn/Assets/images/a1.png"},{"title":"产品经理因频繁改需求被杀害","detail":"凶手是一名程序员，因死者对项目需求频繁改动而痛下杀手","comment":"14112","image":"http://huixinguiyu.cn/Assets/images/a2.png"},{"title":"3Q大战宣判: 腾讯获赔500万","detail":"最高法驳回360上诉, 维持一审宣判.","comment":"6427","image":"http://huixinguiyu.cn/Assets/images/a3.png"},{"title":"今日之声:北大雕塑被戴口罩","detail":"市民: 因雾霾起诉环保局; 公务员谈\"紧日子\": 坚决不出去.","comment":"681","image":"http://huixinguiyu.cn/Assets/images/a4.png"},{"title":"奥巴马见达赖是装蒜","detail":"外文局: 国际民众认可中国大国地位;法院: \"流量清零\"未侵权.","comment":"1359","image":"http://huixinguiyu.cn/Assets/images/a5.png"},{"title":"轻松一刻: 我要沉迷学习不自拔","detail":"放假时我醒了不代表我起床了, 如今我起床了不代表我醒了!","comment":"11616","image":"http://huixinguiyu.cn/Assets/images/a6.png"},{"title":"今日之声:北大雕塑被戴口罩","detail":"市民: 因雾霾起诉环保局; 公务员谈\"紧日子\": 坚决不出去.","comment":"681","image":"http://huixinguiyu.cn/Assets/images/a7.png"},{"title":"奥巴马见达赖是装蒜","detail":"外文局: 国际民众认可中国大国地位;法院: \"流量清零\"未侵权.","comment":"1359","image":"http://huixinguiyu.cn/Assets/images/a7.png"}]
         */

        private List<NewsEntity> news;

        public void setNews(List<NewsEntity> news) {
            this.news = news;
        }

        public List<NewsEntity> getNews() {
            return news;
        }

        public static class NewsEntity {
            /**
             * title : 程序员因写代码太乱被杀害
             * detail : 凶手是死者同事，维护死者代码时完全看不懂而痛下杀手
             * comment : 16359
             * image : http://huixinguiyu.cn/Assets/images/a1.png
             */

            private String title;
            private String detail;
            private String comment;
            private String image;

            public void setTitle(String title) {
                this.title = title;
            }

            public void setDetail(String detail) {
                this.detail = detail;
            }

            public void setComment(String comment) {
                this.comment = comment;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getTitle() {
                return title;
            }

            public String getDetail() {
                return detail;
            }

            public String getComment() {
                return comment;
            }

            public String getImage() {
                return image;
            }
        }
    }
}
