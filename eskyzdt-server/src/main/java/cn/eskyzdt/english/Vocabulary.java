package cn.eskyzdt.english;

/**
 *
 * @since 2020/7/22
 * @author dongtian
 */
public enum Vocabulary {

    /**
     *
     */
    PERCEIVE("察觉,意识,感知 Voters perceive him as a decisive and resolute international leader. ")
    ,
    relevant("相关的 Do you have the relevant experience?"),
    resident("居民, 和president校长只差一个"),
    survey("调查"),
    district("区域 the district is under consideration for ..."),
    restricted("受限制的,保密的"),  // I restrict myself to one cup of coffee a day
    journal("日报,日记"),
    alternative("可选择的,二选一的"),
    convention("社会习俗It's just a social convention that men don't wear skirts."),
     impose("强行使人接受,勉强"),
    approximate("大约的  The approximate cost varies from around $150 to $250 大致的费用在$150至$250之间不等")
    ;



    private String key;

    private String value;

    Vocabulary(String a) {
        this.key = a;
    }

}
