package module;

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
}
