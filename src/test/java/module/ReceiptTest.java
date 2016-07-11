package module;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sora on 2016/7/11.
 */
public class ReceiptTest {

    private static final String R1_MSG_ITEM1 =
            "名称：可口可乐，数量：3瓶，单价：3.00(元)，小计：6.00(元)";
    private static final String R1_MSG_ITEM2 =
            "名称：羽毛球，数量：5个，单价：1.00(元)，小计：4.00(元)";
    private static final String R1_MSG_ITEM3 =
            "名称：苹果，数量：2斤，单价：5.50(元)，小计：11.00(元)";

    private static final String R1_MSG_OFFER1 =
            "名称：可口可乐，数量：1瓶";
    private static final String R1_MSG_OFFER2 =
            "名称：羽毛球，数量：1个";

    private static final String R1_MSG_TOTAL =
            "总计：21.00(元)";
    private static final String R1_MSG_SAVE =
            "节省：4.00(元)";

    private static final String R1_RECEIPT =
            "***<没钱赚商店>购物清单***\n" +
            "名称：可口可乐，数量：3瓶，单价：3.00(元)，小计：6.00(元)\n" +
            "名称：羽毛球，数量：5个，单价：1.00(元)，小计：4.00(元)\n" +
            "名称：苹果，数量：2斤，单价：5.50(元)，小计：11.00(元)\n" +
            "----------------------\n" +
            "买三免一商品：\n" +
            "名称：可口可乐，数量：1瓶\n" +
            "名称：羽毛球，数量：1个\n" +
            "----------------------\n" +
            "总计：21.00(元)\n" +
            "节省：4.00(元)\n" +
            "**********************\n";

    @Test
    public void should_return_receipt_with_offer_goods()
            throws Exception {
        Receipt receipt = new Receipt();

        receipt.addItemCostInfo(R1_MSG_ITEM1);
        receipt.addItemCostInfo(R1_MSG_ITEM2);
        receipt.addItemCostInfo(R1_MSG_ITEM3);

        receipt.addItemOfferInfo(R1_MSG_OFFER1);
        receipt.addItemOfferInfo(R1_MSG_OFFER2);

        receipt.setTotalCostInfo(R1_MSG_TOTAL);
        receipt.setTotalSaveInfo(R1_MSG_SAVE);

        assertEquals(R1_RECEIPT, receipt.getText());
    }

    public static final String R2_MSG_ITEM1 =
            "名称：可口可乐，数量：3瓶，单价：3.00(元)，小计：9.00(元)";
    public static final String R2_MSG_ITEM2 =
            "名称：羽毛球，数量：5个，单价：1.00(元)，小计：5.00(元)";
    public static final String R2_MSG_ITEM3 =
            "名称：苹果，数量：2斤，单价：5.50(元)，小计：11.00(元)";

    public static final String R2_MSG_TOTAL =
            "总计：25.00(元)";

    public static final String R2_RECEIPT =
            "***<没钱赚商店>购物清单***\n" +
            "名称：可口可乐，数量：3瓶，单价：3.00(元)，小计：9.00(元)\n" +
            "名称：羽毛球，数量：5个，单价：1.00(元)，小计：5.00(元)\n" +
            "名称：苹果，数量：2斤，单价：5.50(元)，小计：11.00(元)\n" +
            "----------------------\n" +
            "总计：25.00(元)\n" +
            "**********************\n";

    @Test
    public void should_return_receipt_without_offer_goods()
            throws Exception {
        Receipt receipt = new Receipt();

        receipt.addItemCostInfo(R2_MSG_ITEM1);
        receipt.addItemCostInfo(R2_MSG_ITEM2);
        receipt.addItemCostInfo(R2_MSG_ITEM3);

        receipt.setTotalCostInfo(R2_MSG_TOTAL);

        assertEquals(R2_RECEIPT, receipt.getText());
    }
}