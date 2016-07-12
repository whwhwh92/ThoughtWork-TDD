package module;

import info.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sora on 2016/7/11.
 */
public class Receipt {

    private List<String> itemMsgList = new ArrayList<>();
    private List<String> offerMsgList = new ArrayList<>();

    private String costMsg = "";
    private String saveMsg = "";

    private String getHeader() {
        return "***<没钱赚商店>购物清单***\n";
    }

    private String getTail() {
        return "**********************\n";
    }

    private String getPartLine() {
        return "----------------------\n";
    }

    private static String getListInfo(List<String> strList) {
        String info = "";
        for (String msg : strList) {
            info += msg + "\n";
        }
        return info;
    }

    public void addItemCostInfo(String msg) {
        itemMsgList.add(msg);
    }

    private String getItemsInfo() {
        return getListInfo(itemMsgList);
    }

    public void addItemOfferInfo(String msg) {
        if (!msg.isEmpty()) {
            offerMsgList.add(msg);
        }
    }

    private String getOfferInfo() {
        String info = getListInfo(offerMsgList);
        if (!info.isEmpty()) {
            info = "买三免一商品：\n" + info;
        }
        return info;
    }

    public void setTotalCostInfo(String msg) {
        costMsg = msg;
    }

    private String getCostInfo() {
        return costMsg + "\n";
    }

    public void setTotalSaveInfo(String msg) {
        saveMsg = msg;
    }

    private String getSaveInfo() {
        if (!saveMsg.isEmpty()) {
            return saveMsg + "\n";
        } else {
            return "";
        }
    }

    public String getText() {
        String text = "";

        text += getHeader();

        text += getItemsInfo();
        text += getPartLine();

        if (!getOfferInfo().isEmpty()) {
            text += getOfferInfo();
            text += getPartLine();
        }

        text += getCostInfo();
        text += getSaveInfo();

        text += getTail();

        return text;
    }

    public static String itemText(Item item, float cost) {
        return String.format(
                "名称：%s，数量：%d%s，单价：%.2f(元)，小计：%.2f(元)",
                item.getGoods().getName(),
                item.getQuantity(), item.getGoods().getUnit(),
                item.getGoods().getPrice(), cost);
    }

    public static String itemOfferText(Item item, int quan) {
        if (quan > 0) {
            return String.format(
                    "名称：%s，数量：%d%s",
                    item.getGoods().getName(),
                    quan, item.getGoods().getUnit());
        } else {
            return "";
        }
    }

    public static String totalCostText(float cost) {
        return String.format("总计：%.2f(元)", cost);
    }

    public static String totalSaveText(float save) {
        if (save > 0.0f) {
            return String.format("节省：%.2f(元)", save);
        } else {
            return "";
        }
    }

    public void addItem(Item item, float cost, int offer) {
        addItemCostInfo(itemText(item, cost));
        addItemOfferInfo(itemOfferText(item, offer));
    }

    public void setTotal(float cost, float save) {
        setTotalCostInfo(totalCostText(cost));
        setTotalSaveInfo(totalSaveText(save));
    }
}
