package com.example.jingbei.dao;




import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.jingbei.dbUtil.MyDbOpenHelper;

import java.util.ArrayList;
import java.util.List;

import com.example.jingbei.bean.Goods;

public class GoodsDao {
    private Context context;

    public GoodsDao(Context context){

        this.context=context;
    }


    //定义插入操作
    public void addGoods(){
        MyDbOpenHelper myDbOpenHelper=new MyDbOpenHelper(context);
        SQLiteDatabase sqLiteDatabase=myDbOpenHelper.getWritableDatabase();
        sqLiteDatabase.beginTransaction();
        try {
            ContentValues contentValues=new ContentValues();
            //插入数据
            contentValues.put("title","Kyrie 6 EP");
            contentValues.put("introduce","Kyrie 6 EP 篮球鞋采用匠心打造，专为凯里·欧文在球场上的变幻莫测创造力而设计。该鞋款设计注重舒适感、可控性和能量回馈，助力疾速畅跑，保持出色状态。弹性缓震配置结合柔软但富有支撑力的泡棉，塑就灵敏响应力，营造从后跟到鞋头的平稳过渡。中足固定带和柔软加垫鞋口可有效锁定双足，助力在比赛中保持领先。");
            contentValues.put("price","77826");
            contentValues.put("photo","https://c.static-nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/10900ec8-c7a3-42d6-8256-02a74fae5970/kyrie-6-ep-%E7%94%B7%E5%AD%90%E7%AF%AE%E7%90%83%E9%9E%8B-NxC374.jpg");
            contentValues.put("type","耐克");
            sqLiteDatabase.insert("goods","",contentValues);
            contentValues.clear();
            contentValues.put("title","Kobe IV Protro Wizenard");
            contentValues.put("introduce","Kobe IV Protro Wizenard 在元年款低帮出色设计基础上推出升级版贴合款型，装饰细节灵感源自科比·布莱恩特最新的青年向小说 《Wizenard 系列》。忠实再现令人难忘的出众美学，革新设计造就响应灵敏的性能和顺畅平稳的舒适步履体验。");
            contentValues.put("price","57630");
            contentValues.put("photo","https://c.static-nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/ctq7qlako18houdymbuc/kobe-4-protro-wizenard-%E7%94%B7%E5%AD%90%E7%AF%AE%E7%90%83%E9%9E%8B-QtlRnW.jpg");
            contentValues.put("type","耐克");
            sqLiteDatabase.insert("goods","",contentValues);
            contentValues.clear();
            contentValues.put("title","Kyrie 6 (GS)");
            contentValues.put("introduce","Kyrie 6 (GS) 大童篮球童鞋采用匠心材质，宽版固定带包覆足面，帮助锁定双足。底部弧形设计，橡胶抓附设计包覆两侧，在快速切入篮筐时助你掌控身体。");
            contentValues.put("price","77630");
            contentValues.put("photo","https://c.static-nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/5e02b3e7-496e-479c-a26d-1f1015d71b30/kyrie-6-%E5%A4%A7%E7%AB%A5%E7%AF%AE%E7%90%83%E7%AB%A5%E9%9E%8B-g2qz4D.jpg");
            contentValues.put("type","耐克");
            sqLiteDatabase.insert("goods","",contentValues);
            contentValues.clear();
            contentValues.put("title","Air Jordan XXXIV PF");
            contentValues.put("introduce","Air Jordan XXXIV PF 男子篮球鞋续写文化符号传承的辉煌篇章。");
            contentValues.put("price","73230");
            contentValues.put("photo","https://c.static-nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/qtplrviyysdhul1pgslk/air-jordan-34-pf-%E7%94%B7%E5%AD%90%E7%AF%AE%E7%90%83%E9%9E%8B-GpTLJF.jpg");
            contentValues.put("type","耐克");
            sqLiteDatabase.insert("goods","",contentValues);
            contentValues.clear();
            contentValues.put("title","Nike AF1-Type");
            contentValues.put("introduce","作为向 Steve Prefontaine 迅疾速度致敬的 N354 系列的一部分，Nike AF1-Type 男子运动鞋旨在向运动历史表达敬意。贴合系统搭载可调节技术，打造独特造型和专属贴合感受，呈现风格多变的个性。");
            contentValues.put("price","82530");
            contentValues.put("photo","https://c.static-nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/b7bunno8cjsra3rnstp4/af1-type-%E7%94%B7%E5%AD%90%E8%BF%90%E5%8A%A8%E9%9E%8B-F12rCK.jpg");
            contentValues.put("type","耐克");
            sqLiteDatabase.insert("goods","",contentValues);
            contentValues.clear();
            contentValues.put("title","Nike Air Force 1 '07 NXN\n");
            contentValues.put("introduce","Olivia Kim 对 90 年代的纽约铭记于心。整个城市都沉浸在热舞狂欢之中，彻夜不眠。Bomb Dot Com 就是时尚的代名词。Nike Air Force 1 '07 NXN 运动鞋采用蓝色灯芯绒鞋面搭配荧光细节，彰显狂放不羁的 90 年代锐舞精神。");
            contentValues.put("price","96420");
            contentValues.put("photo","https://c.static-nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/cwf9pcbh6if2sskinovs/air-force-1-07-nxn-%E5%A5%B3%E5%AD%90%E8%BF%90%E5%8A%A8%E9%9E%8B-V97BHW.jpg");
            contentValues.put("type","耐克");
            sqLiteDatabase.insert("goods","",contentValues);
            contentValues.clear();
            contentValues.put("title","Nike Air Max 98 PRM");
            contentValues.put("introduce","Nike Air Max 98 PRM 女子运动鞋依托现代创新设计和舒适性能再现复古 Air Max 风格。织物和合成材质组合鞋面耐穿透气，同时搭载全掌型 Max Air 缓震配置，塑就灵敏回弹的缓震性能。");
            contentValues.put("price","156420");
            contentValues.put("photo","https://c.static-nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/zhjhvgjlhvtpp3ca4ydt/air-max-98-prm-%E5%A5%B3%E5%AD%90%E8%BF%90%E5%8A%A8%E9%9E%8B-mHsKH3.jpg");
            contentValues.put("type","耐克");
            sqLiteDatabase.insert("goods","",contentValues);
            contentValues.clear();
            contentValues.put("title","Nike Daybreak");
            contentValues.put("introduce","该款 Nike Daybreak 女子运动鞋诞生于 1979 年，致敬辉煌过往。鞋款采用同款华夫格橡胶外底和匠心鞋面，带来复古风范。");
            contentValues.put("price","136220");
            contentValues.put("photo","https://c.static-nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/razmgzwhwuuszbac0oen/daybreak-%E5%A5%B3%E5%AD%90%E8%BF%90%E5%8A%A8%E9%9E%8B-X8Hf9d.jpg");
            contentValues.put("type","耐克");
            sqLiteDatabase.insert("goods","",contentValues);

            contentValues.clear();
            contentValues.put("title","I-4D PK 经典运动鞋");
            contentValues.put("introduce","这款经典鞋，以现代工艺将复古科技推向未来。以70年代跑步鞋I-5923的设计为灵感，结合网材和绒面革材质。印花图案呈现数码风格。采用adidas 4D中底，力求给你专注和舒适。");
            contentValues.put("price","2799");
            contentValues.put("photo","https://img.adidas.com.cn/resources/2019/11/6/15730054849222770.jpg?x-oss-process=image/resize,m_pad,w_500,h_500,limit_0,color_ffffff");
            contentValues.put("type","阿迪达斯");
            sqLiteDatabase.insert("goods","",contentValues);
            contentValues.clear();
            contentValues.put("title","I-5923 经典鞋");
            contentValues.put("introduce","这款经典鞋，以现代工艺将复古科技推向未来。以70年代跑步鞋I-5923的设计为灵感，结合adidas Primeknit和绒面革材质。印花图案呈现数码风格。采用adidas 4D中底，力求给你专注和舒适。");
            contentValues.put("price","2799");
            contentValues.put("photo","https://img.adidas.com.cn/resources/2019/11/6/1573005488324415.jpg?x-oss-process=image/resize,m_pad,w_500,h_500,limit_0,color_ffffff");
            contentValues.put("type","阿迪达斯");
            sqLiteDatabase.insert("goods","",contentValues);
            contentValues.clear();
            contentValues.put("title","ULTRABOOST 20 跑步运动鞋");
            contentValues.put("introduce","adidas携手国际空间站国家实验室（ISS National Lab），遵循共同目标，打破跑鞋设计传统，迎来太空探索新时代。穿上这款Ultraboost 20，“起飞”。");
            contentValues.put("price","1499");
            contentValues.put("photo","https://img.adidas.com.cn/resources/2019/11/19/15741271267479264.jpg?x-oss-process=image/resize,m_pad,w_500,h_500,limit_0,color_ffffff");
            contentValues.put("type","阿迪达斯");
            sqLiteDatabase.insert("goods","",contentValues);
            contentValues.clear();
            contentValues.put("title","RAPIDAZEN C 训练运动鞋");
            contentValues.put("introduce","玩出创意。这款adidas运动鞋，旨在为儿童打造，力求陪伴他们定义自己的规则。一片式宽掌乙烯/乙酸乙烯酯（EVA）外底，搭配撞色设计，醒目靓丽。");
            contentValues.put("price","399");
            contentValues.put("photo","https://img.adidas.com.cn/resources/2019/12/9/15758731287399922.jpg?x-oss-process=image/resize,m_pad,w_500,h_500,limit_0,color_ffffff");
            contentValues.put("type","阿迪达斯");
            sqLiteDatabase.insert("goods","",contentValues);
            contentValues.clear();
            contentValues.put("title","RAPIDAFLEX MICKEY EL I 训练运动学步鞋");
            contentValues.put("introduce","嘿，米奇！这款婴童adidas运动鞋，力求陪伴孩子们在沙坑玩耍。穿着舒适，配可调节束带，打造舒适贴合的脚感。饰迪士尼米奇图案，增添趣味感。");
            contentValues.put("price","399");
            contentValues.put("photo","https://img.adidas.com.cn/resources/2019/12/6/15755969606692913.jpg?x-oss-process=image/resize,m_pad,w_500,h_500,limit_0,color_ffffff");
            contentValues.put("type","阿迪达斯");
            sqLiteDatabase.insert("goods","",contentValues);
            contentValues.clear();
            contentValues.put("title","PREDATOR 19+ FG ADV 足球鞋硬天然草坪运动鞋）");
            contentValues.put("introduce","保持专注可不是三分钟热度。这款无系带足球鞋，以Predator 19鞋款为蓝本，将袋鼠皮鞋面和弹力针织鞋领相结合，带来舒适脚感。前掌缀Mania式细节，纪念Predator问世25周年，致敬一路走来的峥嵘岁月。。");
            contentValues.put("price","2999");
            contentValues.put("photo","https://img.adidas.com.cn/resources/2019/11/6/1573006369714172.jpg?x-oss-process=image/resize,m_pad,w_500,h_500,limit_0,color_ffffff");
            contentValues.put("type","冷兵器");
            sqLiteDatabase.insert("goods","",contentValues);
            contentValues.clear();
            contentValues.put("title","HARDEN VOL. 4 GCA 场上篮球鞋");
            contentValues.put("introduce","这款篮球鞋，致敬James Harden詹姆斯·哈登的标志性风格，助你如MVP般突破防守。含别致中足设计，搭配Lightstrike技术，穿着舒适，同时助力轻松运动。橡胶外底旨在助你急停急起。");
            contentValues.put("price","1299");
            contentValues.put("photo","https://img.adidas.com.cn/resources/2019/10/28/15722618164184351.jpg?x-oss-process=image/resize,m_pad,w_500,h_500,limit_0,color_ffffff");
            contentValues.put("type","阿迪达斯");
            sqLiteDatabase.insert("goods","",contentValues);
            contentValues.clear();
            contentValues.put("title","D ROSE 10 场上篮球运动鞋");
            contentValues.put("introduce","这款篮球鞋，灵感源自Derrick Rose德里克·罗斯的标志性风格。采用加工皮革鞋面和热塑性聚氨酯弹性体（TPU）鞋跟单元，搭配Bounce中底，力求舒适。人字形外底力求助力急停急转。");
            contentValues.put("price","899");
            contentValues.put("photo","https://img.adidas.com.cn/resources/2019/11/22/15744136880994177.jpg?x-oss-process=image/resize,m_pad,w_500,h_500,limit_0,color_ffffff");
            contentValues.put("type","阿迪达斯");
            sqLiteDatabase.insert("goods","",contentValues);

            contentValues.clear();
            contentValues.put("title","女子经典小白鞋 DB940008");
            contentValues.put("introduce","商品功能： 休闲时尚 舒适 鞋面材料合成革");
            contentValues.put("price","259");
            contentValues.put("photo","https://img11.360buyimg.com/n7/jfs/t1/69262/26/8596/313987/5d677fcaE1ffca6ed/817c246e6c700384.jpg!q90");
            contentValues.put("type","匹克");
            sqLiteDatabase.insert("goods","",contentValues);
            contentValues.clear();
            contentValues.put("title","女子文化棉鞋 E94038M");
            contentValues.put("introduce","商品功能： 保暖 鞋面材料合成革");
            contentValues.put("price","369");
            contentValues.put("photo","https://img12.360buyimg.com/n7/jfs/t1/101167/10/3216/309759/5dddd024Ebdacfe11/ac877bcd62c258c8.jpg!q90");
            contentValues.put("type","匹克");
            sqLiteDatabase.insert("goods","",contentValues);
            contentValues.clear();
            contentValues.put("title","男子耐磨防滑篮球外场鞋 DA820071");
            contentValues.put("introduce","BM-革网拼接帮面 有效提升透气性，干爽舒适，给予双脚稳定 支撑。");
            contentValues.put("price","219");
            contentValues.put("photo","https://img13.360buyimg.com/n7/jfs/t1/63606/3/14157/247829/5db94cbfEef81b844/66e043360b8b48b5.jpg");
            contentValues.put("type","匹克");
            sqLiteDatabase.insert("goods","",contentValues);
            contentValues.clear();
            contentValues.put("title","【闪现】篮球鞋男子态极球鞋 E94451A");
            contentValues.put("introduce","全掌态极科技中底实现自适应缓震回弹");
            contentValues.put("price","599");
            contentValues.put("photo","https://img12.360buyimg.com/n7/jfs/t1/74711/36/15742/230790/5dd4aca6E18ff8c57/4730293316d624d1.jpg!q90");
            contentValues.put("type","匹克");
            sqLiteDatabase.insert("goods","",contentValues);
            contentValues.clear();
            contentValues.put("title","男子态极1.0PLUS天择缓震跑鞋 E92557H");
            contentValues.put("introduce","全新TAICHI1.0PLUS-态极自适应科技跑鞋");
            contentValues.put("price","429");
            contentValues.put("photo","https://img13.360buyimg.com/n7/jfs/t1/33860/27/14678/232219/5d148672E7e01223e/c77bb2bdaf61c983.jpg!q90");
            contentValues.put("type","匹克");
            sqLiteDatabase.insert("goods","",contentValues);
            contentValues.clear();
            contentValues.put("title","男子态极1.0plus缓震跑鞋 E92577H");
            contentValues.put("introduce","态极科技中底高分子智能材料与鞋中底材料EVA复合发泡而成的“态极’使跑鞋拥有软硬兼顾的两个不同形态");
            contentValues.put("price","499");
            contentValues.put("photo","https://img14.360buyimg.com/n7/jfs/t1/47439/4/3562/233933/5d148617E255ff24b/2df81915bd2a88b3.jpg!q90");
            contentValues.put("type","匹克");
            sqLiteDatabase.insert("goods","",contentValues);
            contentValues.clear();
            contentValues.put("title","【态极爱定客联名】男子缓震跑鞋 DH940667");
            contentValues.put("introduce","全新大开窗抗扭转TPU引入立体加强筋，强化抗扭转性底花纹路借鉴轮胎花纹排列方式增加触地面积强化抗磨损表现，抛掉-切顾虑");
            contentValues.put("price","499");
            contentValues.put("photo","https://img13.360buyimg.com/n7/jfs/t1/34341/11/10560/322347/5cecf1feE0cf66294/5bd702732615f7ad.jpg");
            contentValues.put("type","匹克");
            sqLiteDatabase.insert("goods","",contentValues);
            contentValues.clear();
            contentValues.put("title","【态极】复刻910男子高帮板鞋 E93087B");
            contentValues.put("introduce","经典回潮，出街造型干净利落");
            contentValues.put("price","499");
            contentValues.put("photo","https://img11.360buyimg.com/n7/jfs/t1/65767/16/9433/294387/5d71af84E142be97b/fc27947c2f95386f.jpg!q90");
            contentValues.put("type","匹克");
            sqLiteDatabase.insert("goods","",contentValues);
            contentValues.clear();
            contentValues.put("title","匹克态极探索者x人民日报联名款男鞋潮流机能跑步鞋运动休闲鞋男");
            contentValues.put("introduce","匹克与人民日报新媒体 推出态极科技联名鞋 用实际行动践行 科技是第一生产力");
            contentValues.put("price","699");
            contentValues.put("photo","https://img13.360buyimg.com/n7/jfs/t1/67262/15/7360/223765/5d566bb2Ea61724cc/a0825e931fbd443c.jpg");
            contentValues.put("type","匹克");
            sqLiteDatabase.insert("goods","",contentValues);

            contentValues.clear();
            contentValues.put("title","【2019新品】李宁䨻飞电男子马拉松竞速跑鞋 精英运动员版");
            contentValues.put("introduce","李宁䨻飞电马拉松竞速跑鞋 精英运动员版，运用简洁的色彩搭配，简约休闲 鞋面采用网眼布材质，更具透气力，让你的双脚保持干爽。鞋身李宁品牌标识设计，彰显品牌魅力。");
            contentValues.put("price","2099");
            contentValues.put("photo","https://cdns.lining.com/postsystem/docroot/images/goods/201909/499927/display_499927_1.jpg");
            contentValues.put("type","李宁");
            sqLiteDatabase.insert("goods","",contentValues);
            contentValues.clear();
            contentValues.put("title","【2019新品】男子减震跑鞋");
            contentValues.put("introduce","轻质跑鞋，运用简洁的色彩搭配，简单时尚 鞋面网布材质设计，舒适透气，给足部带来畅快呼吸的空间，提升穿着体验感。鞋面李宁品牌标识搭配字母元素设计，细致做工，彰显品牌魅力。");
            contentValues.put("price","178");
            contentValues.put("photo","https://cdns.lining.com/postsystem/docroot/images/goods/201908/499008/display_499008_1.jpg");
            contentValues.put("type","李宁");
            sqLiteDatabase.insert("goods","",contentValues);
            contentValues.clear();
            contentValues.put("title","【2019新品】男子高帮篮球专业比赛鞋");
            contentValues.put("introduce","高帮篮球专业比赛鞋，运用简洁的色彩搭配，简约休闲 高帮领口设计，束紧保护脚踝。一脚蹬搭配后跟提带设计，方便穿脱，自在出行。鞋面李宁品牌标识设计，细致做工，彰显品牌魅力。");
            contentValues.put("price","498");
            contentValues.put("photo","https://cdns.lining.com/postsystem/docroot/images/goods/201907/495297/display_495297_1.jpg");
            contentValues.put("type","李宁");
            sqLiteDatabase.insert("goods","",contentValues);
            contentValues.clear();
            contentValues.put("title","【2019新品】ALL CITY 7男子减震回弹中帮篮球专业比赛鞋");
            contentValues.put("introduce","ALL CITY 7减震回弹中帮篮球专业比赛鞋，运用简洁的色彩搭配，简约休闲 中底使用李宁云科技，兼具缓震/反弹性能，提供良好的运动体验。鞋面魔术贴绑带提供良好的包裹性能。NBA球员PE配色。");
            contentValues.put("price","568");
            contentValues.put("photo","https://cdns.lining.com/postsystem/docroot/images/goods/201910/510463/display_510463_1.jpg");
            contentValues.put("type","李宁");
            sqLiteDatabase.insert("goods","",contentValues);
            contentValues.clear();
            contentValues.put("title","男子减震中帮篮球专业比赛鞋");
            contentValues.put("introduce","LI-NING CLOUD\"李宁云\"是李宁的鞋底减震科技，全掌中底使用高分子材料配方，有效积累缓震时的冲击力，并转化为回弹时的能量，形成能量循环体系。同时具备柔软、轻量的特性。减少外界冲击，提升运动表现。");
            contentValues.put("price","498");
            contentValues.put("photo","https://cdns.lining.com/postsystem/docroot/images/goods/201912/517145/display_517145_1.jpg");
            contentValues.put("type","李宁");
            sqLiteDatabase.insert("goods","",contentValues);
            contentValues.clear();
            contentValues.put("title","【2019新品】男大童轻便童休闲鞋");
            contentValues.put("introduce","男大童轻便童休闲鞋，运用简洁的色彩搭配，简约休闲 鞋面采用合成革织物设计，立体有型，上脚舒适。鞋身撞色设计，个性潮流。魔术贴设计，舒适包裹，穿脱更方便。鞋底由EVA打造，脚感轻便，孩子行走更加放心。");
            contentValues.put("price","229");
            contentValues.put("photo","https://cdns.lining.com/postsystem/docroot/images/goods/201908/499734/display_499734_1.jpg");
            sqLiteDatabase.insert("goods","",contentValues);
            contentValues.clear();
            contentValues.put("title","【2020新品】男子轻质透气羽毛球训练鞋");
            contentValues.put("introduce","羽毛球训练鞋，采用简洁的色彩搭配，简单大方，时尚百搭。 大眼网布结合局部PU设计，外观简约时尚，提供出色透气的同时有效支撑；特殊透气区域设计，透气效果更好。全掌李宁云中底，舒适缓震。");
            contentValues.put("price","349");
            contentValues.put("photo","https://cdns.lining.com/postsystem/docroot/images/goods/201911/514609/display_514609_1.jpg");
            contentValues.put("type","李宁");
            sqLiteDatabase.insert("goods","",contentValues);
            contentValues.clear();
            contentValues.put("title","【2019新品】男子乒乓球训练鞋");
            contentValues.put("introduce","鞋面采用合成革结合透气网布，包裹双脚的同时提升鞋面透气性。中底采用轻质EVA材料，减震回弹，脚感舒适，让步伐移动更灵活。外侧防侧翻结构设计，提供稳固的侧向支撑，提升双脚在运动中的稳定性。");
            contentValues.put("price","258");
            contentValues.put("photo","https://cdns.lining.com/postsystem/docroot/images/goods/201910/512328/display_512328_1.jpg");
            contentValues.put("type","李宁");
            sqLiteDatabase.insert("goods","",contentValues);

            contentValues.clear();
            contentValues.put("title","奥康男鞋 时尚布洛克雕花系带商务正装英伦皮鞋德比鞋 2019秋季新款");
            contentValues.put("introduce","鞋头款式：圆头闭合方式：系带鞋底材质：橡胶");
            contentValues.put("price","209");
            contentValues.put("photo","https://img.aipaike.com/group1/M00/20/B2/eSufwF03rZmATZhAAAKFMZCwScs665_640x640.jpg");
            contentValues.put("type","皮鞋");
            sqLiteDatabase.insert("goods","",contentValues);
            contentValues.clear();
            contentValues.put("title","奥康男鞋 真皮商务正装皮鞋 英伦布洛克鞋");
            contentValues.put("introduce","鞋面材质：头层牛皮鞋制作工艺：胶粘鞋跟底款式：平跟");
            contentValues.put("price","599");
            contentValues.put("photo","https://img.aipaike.com//group1/M00/16/FD/Cvv7ZVsiNPSAF9WbAABVPiiqsnc800_640x640.jpg");
            contentValues.put("type","皮鞋");
            sqLiteDatabase.insert("goods","",contentValues);
            contentValues.clear();
            contentValues.put("title","奥康男鞋 商务正装皮鞋透气舒适英伦办公室德比鞋男 2019秋季新款");
            contentValues.put("introduce","鞋跟高：低跟(1-3cm)适用对象：青年流行元素：车缝线");
            contentValues.put("price","189");
            contentValues.put("photo","https://img.aipaike.com/group1/M00/23/25/eSufwF3fW7SAbvkhAANKVRAQuKc209_800x800.jpg");
            contentValues.put("type","皮鞋");
            sqLiteDatabase.insert("goods","",contentValues);
            contentValues.clear();
            contentValues.put("title","奥康男鞋 真皮牛皮皮鞋男套脚休闲鞋舒适软底爸爸鞋 2019秋季新款");
            contentValues.put("introduce","风格：商务款式：商务休闲鞋功能：透气");
            contentValues.put("price","299");
            contentValues.put("photo","https://img.aipaike.com/group1/M00/21/02/eSufwF1aU42ABqG4AAJSTzAaLWk323_800x800.jpg");
            contentValues.put("type","皮鞋");
            sqLiteDatabase.insert("goods","",contentValues);
            contentValues.clear();
            contentValues.put("title","19冬 男士 优质牛皮商务皮鞋");
            contentValues.put("introduce","鞋款采用了优质牛皮，细腻有质感，真皮内里，舒适透气，橡胶大底，防滑耐磨，金属扣件装饰鞋身，时尚简约。");
            contentValues.put("price","569");
            contentValues.put("photo","http://www.cnhqt.com/media/upload/image/products/zoom/2019/s/20191121_146_0762.png");
            contentValues.put("type","皮鞋");
            sqLiteDatabase.insert("goods","",contentValues);
            contentValues.clear();
            contentValues.put("title","防滑安全正装皮鞋");
            contentValues.put("introduce","鞋款采用真皮面料，舒适透气，鞋底采用止滑耐磨材质，提高行走安全性，同时配合脚掌弹力按摩区，有效缓解行走疲劳。鞋耳压纹设计，使鞋子更具质感。");
            contentValues.put("price","639");
            contentValues.put("photo","http://www.cnhqt.com/media/upload/image/products/zoom/2019/s/2019111_152_17699.png");
            contentValues.put("type","皮鞋");
            sqLiteDatabase.insert("goods","",contentValues);
            contentValues.clear();
            contentValues.put("title","时尚皮鞋");
            contentValues.put("introduce","优质水牛皮擦色皮革，更具质感，经典的正装楦型、极简风元素共同打造利落的结构，款式精致考究满足正式场合的时尚需求。");
            contentValues.put("price","769");
            contentValues.put("photo","http://www.cnhqt.com/media/upload/image/products/zoom/2019/s/2019815_1623_26849.png");
            contentValues.put("type","皮鞋");
            sqLiteDatabase.insert("goods","",contentValues);
            contentValues.clear();
            contentValues.put("title","Zero零度男士正装鞋 ");
            contentValues.put("introduce","春季新品真皮皮鞋时尚套脚正装皮鞋婚庆鞋子 鳄纹压花 炫亮扣饰 橡胶大底 头层牛皮C71081");
            contentValues.put("price","639");
            contentValues.put("photo","http://www.ezeroshop.com/attachment/images/16/2018/06/Le6n6a28zymYq6Gz126SanN2g8g6qC.jpg");
            contentValues.put("type","皮鞋");
            sqLiteDatabase.insert("goods","",contentValues);

            contentValues.put("title","拖鞋女夏季家用室内厚底情侣男家居拖洗澡防滑浴室软底居家凉拖鞋");
            contentValues.put("introduce","优质选材 环保无异味 防滑耐磨 品质保障");
            contentValues.put("price","28");
            contentValues.put("photo","https://img11.360buyimg.com/n7/jfs/t24994/85/1338393495/399724/abb84038/5baeee61N081ee309.jpg");
            contentValues.put("type","拖鞋");
            sqLiteDatabase.insert("goods","",contentValues);
            contentValues.clear();
            contentValues.put("title","coqui酷趣家用女室内夏季浴室洗澡情侣托鞋家居防滑eva凉拖鞋男士");
            contentValues.put("introduce","eva 男生 女式 女士拖鞋夏天");
            contentValues.put("price","39");
            contentValues.put("photo","https://img10.360buyimg.com/n7/jfs/t1/36190/9/2898/429826/5cb6edb6E111e0d5f/59aa06f5b6e8b1c0.jpg");
            contentValues.put("type","拖鞋");
            sqLiteDatabase.insert("goods","",contentValues);
            contentValues.clear();
            contentValues.put("title","回力保暖男士包跟棉鞋秋冬季带跟毛绒拖鞋女室内家居家用棉拖鞋男");
            contentValues.put("introduce","拖鞋非常暖和，回力这个品牌不错，耐用又经济。感觉非常好。 ");
            contentValues.put("price","98");
            contentValues.put("photo","https://img12.360buyimg.com/n7/jfs/t1/4482/6/11236/312907/5bcef231Ec4980348/921cd6b8697ba833.jpg");
            contentValues.put("type","拖鞋");
            sqLiteDatabase.insert("goods","",contentValues);
            contentValues.clear();
            contentValues.put("title","2019新款凉拖鞋男夏季室内防滑软底家用居家厚底外穿潮流浴室托鞋");
            contentValues.put("introduce","柔软不磨脚 久穿不臭脚 ");
            contentValues.put("price","68");
            contentValues.put("photo","https://img10.360buyimg.com/n7/jfs/t1/73723/30/14159/690608/5db92185E183238a0/c11429d7d55799d6.jpg");
            contentValues.put("type","拖鞋");
            sqLiteDatabase.insert("goods","",contentValues);
            contentValues.clear();
            contentValues.put("title","回力凉拖鞋男夏家用浴室洗澡防滑耐磨软底按摩潮流情侣凉鞋女托鞋");
            contentValues.put("introduce","适用对象: 一家三口中底材质: PVC帮面材质: PVC");
            contentValues.put("price","108");
            contentValues.put("photo","https://img10.360buyimg.com/n7/jfs/t1/24120/36/10469/200162/5c87b7d9E4640d273/14df696ceff15c53.jpg");
            contentValues.put("type","拖鞋");
            sqLiteDatabase.insert("goods","",contentValues);
            contentValues.clear();
            contentValues.put("title","Nike Benassi Jdi");
            contentValues.put("introduce","诞生于1995年的经典拖鞋款式Nike Benassi JDI 经过一众大牌明星的自愿代言，以及一系列让人眼前一亮的配色、联名及各种主题，简直是当下最火");
            contentValues.put("price","209");
            contentValues.put("photo","https://img13.360buyimg.com/n7/jfs/t1/66157/37/1573/90527/5cff28b2E5c8e6de5/dacf94b765acbc28.jpg");
            contentValues.put("type","拖鞋");
            sqLiteDatabase.insert("goods","",contentValues);
            contentValues.clear();
            contentValues.put("title","匹克 态极拖鞋 E92037L");
            contentValues.put("introduce","在全新中底黑科技态极火爆球鞋市场后，匹克趁着热度又随之发布了一款搭载态极技术的拖鞋，于2019年6月上市。态极拖鞋采用了一体式造型EVA构建鞋身，风格最棒");
            contentValues.put("price","129");
            contentValues.put("photo","https://img10.360buyimg.com/n7/jfs/t1/46667/7/4660/172486/5d255352Ec74d0b6c/144f16a563805c45.jpg");
            contentValues.put("type","拖鞋");
            sqLiteDatabase.insert("goods","",contentValues);

            sqLiteDatabase.setTransactionSuccessful();

        }catch (Exception e){

            e.printStackTrace();
        }finally {
            sqLiteDatabase.endTransaction();
            sqLiteDatabase.close();
        }

    }

    /*
     根据商品名查商品
     */
  public List<Goods> queryByName(String name){
        List goodlist=new ArrayList();//定义一个集合存储商品对象
         Goods goods=null;
        MyDbOpenHelper myDbOpenHelper=new MyDbOpenHelper(context);
        SQLiteDatabase sqLiteDatabase=myDbOpenHelper.getWritableDatabase();
        try{
            Cursor cursor=sqLiteDatabase.query("goods",new String[]{"title","introduce","price","photo","type"},"title like ?",new String[]{"%"+name+"%"},null,null,null);
            while (cursor.moveToNext()){
                String title=cursor.getString(cursor.getColumnIndex("title"));
                String introduce=cursor.getString(cursor.getColumnIndex("introduce"));
                double price=cursor.getDouble(cursor.getColumnIndex("price"));
                String photo=cursor.getString(cursor.getColumnIndex("photo"));
                String type=cursor.getString(cursor.getColumnIndex("type"));
                 goods=new Goods(title,introduce,price,photo,type);
                goodlist.add(goods);
            }
            cursor.close();
        }catch (Exception e){
            Toast.makeText(context,"查询错误",Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }finally {

            sqLiteDatabase.close();
        }
        return goodlist;
    }
    /*
    根据商品类型查询
     */
    public List<Goods> queryByType(String typename){
        List goodlist=new ArrayList();//定义一个集合存储商品对象
        Goods goods=null;
        MyDbOpenHelper myDbOpenHelper=new MyDbOpenHelper(context);
        SQLiteDatabase sqLiteDatabase=myDbOpenHelper.getWritableDatabase();
        try{
            Cursor cursor=sqLiteDatabase.query("goods",new String[]{"title","introduce","price","photo","type"},"type=?",new String[]{typename},null,null,null);
            while (cursor.moveToNext()){
                String title=cursor.getString(cursor.getColumnIndex("title"));
                String introduce=cursor.getString(cursor.getColumnIndex("introduce"));
                double price=cursor.getDouble(cursor.getColumnIndex("price"));
                String photo=cursor.getString(cursor.getColumnIndex("photo"));
                String type=cursor.getString(cursor.getColumnIndex("type"));
                goods=new Goods(title,introduce,price,photo,type);
                goodlist.add(goods);
            }
            cursor.close();
        }catch (Exception e){
            Toast.makeText(context,"查询错误",Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }finally {

            sqLiteDatabase.close();
        }
        return goodlist;
    }
    /*
    根据id查询商品
     */
    public Goods queryById(int id){
        Goods goods=null;
        MyDbOpenHelper myDbOpenHelper=new MyDbOpenHelper(context);
        SQLiteDatabase sqLiteDatabase=myDbOpenHelper.getWritableDatabase();
        try{
            Cursor cursor=sqLiteDatabase.query("goods",new String[]{"title","introduce","price","photo","type"},"goodsid=?",new String[]{String.valueOf(id)},null,null,null);
            while (cursor.moveToNext()){
                String title=cursor.getString(cursor.getColumnIndex("title"));
                String introduce=cursor.getString(cursor.getColumnIndex("introduce"));
                double price=cursor.getDouble(cursor.getColumnIndex("price"));
                String photo=cursor.getString(cursor.getColumnIndex("photo"));
                String type=cursor.getString(cursor.getColumnIndex("type"));
                goods=new Goods(title,introduce,price,photo,type);
            }
            cursor.close();
        }catch (Exception e){
            Toast.makeText(context,"查询错误",Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }finally {

            sqLiteDatabase.close();
        }
       return goods;
    }
}
