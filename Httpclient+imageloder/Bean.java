package com.bw.shinelon.rikao8;

import java.io.Serializable;
import java.util.List;

/**
 * 创建时间： 2017/7/13
 * 创建人：Android 1506D 王野
 * 类作用：
 */

public class Bean {

    /**
     * result : success
     * data : [{"ID":"28442628","TITLE":"九三学社中央十三届十九次常委会举行","SUBTITLE":"7月5日至6日，九三学社第十三届中央常务委员会第十九次会议在内蒙古包头市举行。会","IMAGEURL":"http://www.93.gov.cn/11002/upload/webcms/content/image/2017/07/07/18_44_41_446_82185_2.jpg","FROMNAME":"九三学社中央宣传部","SHOWTIME":"2017-07-07","RN":1},{"ID":"28442743","TITLE":"坚定信念 风雨过后是彩虹","SUBTITLE":"自6月22日以来，受连日强降雨影响，湖南遭受了较为严重的洪涝灾害。伴随湘江水位不","IMAGEURL":null,"FROMNAME":"九三学社湖南省委","SHOWTIME":"2017-07-12","RN":2},{"ID":"28442737","TITLE":"赵雯赴九三学社同济大学委员会调研","SUBTITLE":"7月12日上午，九三学社中央副主席、上海市政协副主席、九三学社上海市委主委赵雯带","IMAGEURL":"http://www.93.gov.cn/11002/upload/webcms/content/image/2017/07/12/21_47_50_014_89256_20170712050901431.jpg","FROMNAME":"九三学社上海市委","SHOWTIME":"2017-07-12","RN":3},{"ID":"28442736","TITLE":"邵鸿祝贺唐有祺97岁寿辰 ","SUBTITLE":"7月11日上午，九三学社中央常务副主席邵鸿前往九三学社第十一届中央委员会顾问、中","IMAGEURL":"http://www.93.gov.cn/11002/upload/webcms/content/image/2017/07/12/21_32_24_197_92087_761898621619607968.jpg","FROMNAME":"九三学社中央办公厅","SHOWTIME":"2017-07-12","RN":4},{"ID":"28442735","TITLE":"赖明会见环保部副司长刘薇一行","SUBTITLE":"7月10日，全国政协常委、提案委副主任、九三学社中央副主席赖明在机关会见环保部环","IMAGEURL":"http://www.93.gov.cn/11002/upload/webcms/content/image/2017/07/12/21_38_02_221_15438_DSC05645.jpg","FROMNAME":"九三学社中央参政议政部","SHOWTIME":"2017-07-12","RN":5},{"ID":"28442734","TITLE":"屠鹏飞：造福百姓的\u201c肉苁蓉之父\u201d","SUBTITLE":"\u201c2017北京榜样\u201d大型主题活动由北京市委宣传部、首都文明办主办，北京广播电视台","IMAGEURL":"http://www.93.gov.cn/11002/upload/webcms/content/image/2017/07/12/17_43_28_782_14633_1.jpg","FROMNAME":"首都文明网","SHOWTIME":"2017-07-12","RN":6},{"ID":"28442733","TITLE":"九三学社中央机关支社参观香港回归20周年成就展","SUBTITLE":"邵鸿常务副主席参加活动","IMAGEURL":"http://www.93.gov.cn/11002/upload/webcms/content/image/2017/07/12/15_25_50_788_27236_DSC00628.jpg","FROMNAME":"九三学社中央机关支社","SHOWTIME":"2017-07-12","RN":7},{"ID":"60f8529723304071a3ec2bf4a43c0cdc","TITLE":"陈学俊同志遗体告别仪式在西安举行","SUBTITLE":"7月8日上午，西安殡仪馆咸宁厅庄严肃穆，我国著名的能源动力科学家，全国政协原常委","IMAGEURL":"http://www.93.gov.cn/11002/upload/webcms/content/image/2017/07/11/15_55_00_619_68862_9fd5be1376194346b7a697cc57155d67_4394704691488103150.jpg","FROMNAME":"九三学社陕西省委","SHOWTIME":"2017-07-11","RN":8},{"ID":"28442742","TITLE":"风雨中抱紧 抗洪抢险中的九三力量(五)","SUBTITLE":"这几日的朋友圈里，更多的是蓝天白云的长沙。道路不再拥堵，积水也渐渐退去，人们的生","IMAGEURL":"http://www.93.gov.cn/11002/upload/webcms/content/image/2017/07/12/22_25_09_815_44542_1.webp.jpg","FROMNAME":"九三学社湖南省委","SHOWTIME":"2017-07-10","RN":9},{"ID":"28442705","TITLE":"韩启德在党外人士调研协商座谈会上建言促进科技型中小企业发展","SUBTITLE":"6月30日，中共中央政治局常委、全国政协主席俞正声在京主持召开调研协商座谈会，围","IMAGEURL":"http://www.93.gov.cn/11002/upload/webcms/content/image/2017/07/10/11_21_03_076_70568_1121244261_14988300202611n.jpg","FROMNAME":"九三学社中央宣传部","SHOWTIME":"2017-07-10","RN":10},{"ID":"28442704","TITLE":"赵雯赴九三学社上海理工大学委员会调研","SUBTITLE":"7月7日上午，九三学社中央副主席、上海市政协副主席、九三学社上海市委主委赵雯带队","IMAGEURL":"http://www.93.gov.cn/11002/upload/webcms/content/image/2017/07/10/09_09_20_240_24550_201707081237475626.jpg","FROMNAME":"九三学社上海市委","SHOWTIME":"2017-07-10","RN":11},{"ID":"28442703","TITLE":"张桃林在乌海调研","SUBTITLE":"7月7日至8日，九三学社中央副主席、农业部副部长张桃林一行到乌海市调研。中共乌海","IMAGEURL":"http://www.93.gov.cn/11002/upload/webcms/content/image/2017/07/10/09_02_45_225_57753_2017071031309577.jpg","FROMNAME":"乌海日报","SHOWTIME":"2017-07-10","RN":12},{"ID":"28442741","TITLE":"风雨中抱紧 抗洪抢险中的九三力量(四)","SUBTITLE":"湘江畔的怒吼归于平静，屋顶旁的游鱼重回江河，大堤平复、屋舍重现，抗击洪魔我们已经","IMAGEURL":"http://www.93.gov.cn/11002/upload/webcms/content/image/2017/07/12/22_14_03_381_34020_1.webp.jpg","FROMNAME":"九三学社湖南省委","SHOWTIME":"2017-07-07","RN":13},{"ID":"28442702","TITLE":"韩启德一行与包头九三学社社员座谈","SUBTITLE":"7月4日，赴内蒙古包头出席九三学社中央十三届十九次常委会的全国政协副主席、九三学","IMAGEURL":"http://www.93.gov.cn/11002/upload/webcms/content/image/2017/07/07/19_11_42_580_65768_b.jpg","FROMNAME":"九三学社中央宣传部","SHOWTIME":"2017-07-07","RN":14},{"ID":"28442626","TITLE":"韩启德视察包头农科院科技成果展","SUBTITLE":"7月4日，全国政协副主席、九三学社中央主席韩启德率调研组赴包头农科院，视察包头市","IMAGEURL":"http://www.93.gov.cn/11002/upload/webcms/content/image/2017/07/07/15_09_25_446_32943_20170705113001603242.JPG","FROMNAME":"包头市农牧局","SHOWTIME":"2017-07-07","RN":15},{"ID":"28442624","TITLE":"韩启德出席\u201c东西方智慧携手\u2014\u2014聚焦超声手术治疗子宫肌瘤的飞跃\u201d成果发布会","SUBTITLE":"虽然在过去20多年里，中国一直领跑着HIFU技术的研发及其临床应用，但是由于缺乏","IMAGEURL":"http://www.93.gov.cn/11002/upload/webcms/content/image/2017/07/07/10_21_26_558_72490_896af658-3d28-48ef-a655-e11870496e33.jpg","FROMNAME":"重庆医科大学","SHOWTIME":"2017-07-07","RN":16},{"ID":"28442740","TITLE":"风雨中抱紧 抗洪抢险中的九三力量(三)","SUBTITLE":"洪水还在肆虐，抗洪救灾仍在最紧要的关头，不是旁观者的我们依然为此奔袭、为此忧心、","IMAGEURL":"http://www.93.gov.cn/11002/upload/webcms/content/image/2017/07/12/22_08_31_180_14212_1.webp.jpg","FROMNAME":"九三学社湖南省委","SHOWTIME":"2017-07-05","RN":17},{"ID":"28344321","TITLE":"九三学社关心天津伤医案受伤社员","SUBTITLE":"6月29日，九三学社天津市河东区委委员、天津市第三中心医院超声科主任经翔不幸遭遇","IMAGEURL":null,"FROMNAME":"九三学社中央宣传部","SHOWTIME":"2017-07-05","RN":18},{"ID":"28344320","TITLE":"九三学社辽宁省第八次代表大会在沈阳举行","SUBTITLE":"九三学社辽宁省第八次代表大会开幕 九三学社辽宁省第八次代表大会闭幕 7月3日至4","IMAGEURL":"http://www.93.gov.cn/11002/upload/webcms/content/image/2017/07/05/10_20_24_687_59816_IMG_0486.jpg","FROMNAME":"九三学社辽宁省委","SHOWTIME":"2017-07-05","RN":19},{"ID":"28442739","TITLE":"风雨中抱紧 抗洪抢险中的九三力量(二)","SUBTITLE":"大水压境，湘江全流域超历史最高水位，尽管目前湘江长沙站水位已经回落，但前有洞庭湖","IMAGEURL":"http://www.93.gov.cn/11002/upload/webcms/content/image/2017/07/12/22_01_50_389_63047_1.webp.jpg","FROMNAME":"九三学社湖南省委","SHOWTIME":"2017-07-04","RN":20}]
     * dataScroll : [{"ID":"28442626","TITLE":"韩启德视察包头农科院科技成果展","SUBTITLE":null,"IMAGEURL":"/11002/upload/webcms/content/image/2017/07/07/15_18_35_603_62786_11.jpg","FROMNAME":"包头市农牧局","SHOWTIME":"2017-07-07","RN":1},{"ID":"28442628","TITLE":"九三学社中央十三届十九次常委会举行","SUBTITLE":null,"IMAGEURL":"/11002/upload/webcms/content/image/2017/07/07/18_56_09_084_12207_1.1","FROMNAME":"九三学社中央宣传部","SHOWTIME":"2017-07-07","RN":2},{"ID":"28181027","TITLE":"赖明：脱贫攻坚要处理好五对关系","SUBTITLE":"\u2014\u2014九三学社中央召开扶贫监督调研座谈会","IMAGEURL":"/11002/upload/webcms/content/image/2017/06/30/15_17_18_482_75888_1.jpg","FROMNAME":"九三学社中央参政议政部","SHOWTIME":"2017-06-30","RN":3},{"ID":"28181004","TITLE":"九三学社7位社员建言\u201c改进校园餐食管理\u201d","SUBTITLE":null,"IMAGEURL":"/11002/upload/webcms/content/image/2017/06/26/22_45_39_827_54535_111.jpg","FROMNAME":"九三学社中央宣传部","SHOWTIME":"2017-06-26","RN":4},{"ID":"28180993","TITLE":"吴阶平：开创香港历史新纪元","SUBTITLE":null,"IMAGEURL":"/11002/upload/webcms/content/image/2017/06/22/15_29_36_046_84428_wjpxghg.jpg","FROMNAME":"九三学社中央宣传部","SHOWTIME":"2017-06-22","RN":5}]
     */

    private String result;
    private List<DataBean> data;
    private List<DataScrollBean> dataScroll;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public List<DataScrollBean> getDataScroll() {
        return dataScroll;
    }

    public void setDataScroll(List<DataScrollBean> dataScroll) {
        this.dataScroll = dataScroll;
    }

    public static class DataBean implements Serializable{
        /**
         * ID : 28442628
         * TITLE : 九三学社中央十三届十九次常委会举行
         * SUBTITLE : 7月5日至6日，九三学社第十三届中央常务委员会第十九次会议在内蒙古包头市举行。会
         * IMAGEURL : http://www.93.gov.cn/11002/upload/webcms/content/image/2017/07/07/18_44_41_446_82185_2.jpg
         * FROMNAME : 九三学社中央宣传部
         * SHOWTIME : 2017-07-07
         * RN : 1
         */

        private String ID;
        private String TITLE;
        private String SUBTITLE;
        private String IMAGEURL;
        private String FROMNAME;
        private String SHOWTIME;
        private int RN;


        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public String getTITLE() {
            return TITLE;
        }

        public void setTITLE(String TITLE) {
            this.TITLE = TITLE;
        }

        public String getSUBTITLE() {
            return SUBTITLE;
        }

        public void setSUBTITLE(String SUBTITLE) {
            this.SUBTITLE = SUBTITLE;
        }

        public String getIMAGEURL() {
            return IMAGEURL;
        }

        public void setIMAGEURL(String IMAGEURL) {
            this.IMAGEURL = IMAGEURL;
        }

        public String getFROMNAME() {
            return FROMNAME;
        }

        public void setFROMNAME(String FROMNAME) {
            this.FROMNAME = FROMNAME;
        }

        public String getSHOWTIME() {
            return SHOWTIME;
        }

        public void setSHOWTIME(String SHOWTIME) {
            this.SHOWTIME = SHOWTIME;
        }

        public int getRN() {
            return RN;
        }

        public void setRN(int RN) {
            this.RN = RN;
        }
    }

    public static class DataScrollBean {
        /**
         * ID : 28442626
         * TITLE : 韩启德视察包头农科院科技成果展
         * SUBTITLE : null
         * IMAGEURL : /11002/upload/webcms/content/image/2017/07/07/15_18_35_603_62786_11.jpg
         * FROMNAME : 包头市农牧局
         * SHOWTIME : 2017-07-07
         * RN : 1
         */

        private String ID;
        private String TITLE;
        private Object SUBTITLE;
        private String IMAGEURL;
        private String FROMNAME;
        private String SHOWTIME;
        private int RN;

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public String getTITLE() {
            return TITLE;
        }

        public void setTITLE(String TITLE) {
            this.TITLE = TITLE;
        }

        public Object getSUBTITLE() {
            return SUBTITLE;
        }

        public void setSUBTITLE(Object SUBTITLE) {
            this.SUBTITLE = SUBTITLE;
        }

        public String getIMAGEURL() {
            return IMAGEURL;
        }

        public void setIMAGEURL(String IMAGEURL) {
            this.IMAGEURL = IMAGEURL;
        }

        public String getFROMNAME() {
            return FROMNAME;
        }

        public void setFROMNAME(String FROMNAME) {
            this.FROMNAME = FROMNAME;
        }

        public String getSHOWTIME() {
            return SHOWTIME;
        }

        public void setSHOWTIME(String SHOWTIME) {
            this.SHOWTIME = SHOWTIME;
        }

        public int getRN() {
            return RN;
        }

        public void setRN(int RN) {
            this.RN = RN;
        }
    }
}
