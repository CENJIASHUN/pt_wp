package com.chen.jason.utils;

import net.sf.json.JSONObject;
import net.sf.json.JSONArray;
import net.sf.json.xml.XMLSerializer;

/**
 * Created on 2019/7/11. By CenJS
 */
public class DataExchange {

    /**
     * xml格式的字符串转换为json类型
     * @param xml
     * @return
     */
    private static JSONObject xml2Json(String xml) {
        XMLSerializer xmlSerializer = new XMLSerializer();
        String resultStr = xmlSerializer.read(xml).toString();
        JSONObject resultJson = JSONObject.fromObject(resultStr);
        System.out.println("转换后的参数JSONObject：" + resultJson);
        return resultJson;
    }

    public static String json2xml(String json) {
        XMLSerializer xmlSerializer = new XMLSerializer();
        // 根节点名称
        xmlSerializer.setRootName("xml");
        // 不对类型进行设置
        xmlSerializer.setTypeHintsEnabled(false);
        String xmlStr = "";
        if (json.contains("[") && json.contains("]")) {
            // jsonArray
            JSONArray jobj = JSONArray.fromObject(json);
            xmlStr = xmlSerializer.write(jobj);
        } else {
            // jsonObject
            JSONObject jobj = JSONObject.fromObject(json);
            xmlStr = xmlSerializer.write(jobj);
        }
        System.out.println("转换后的参数String：" + xmlStr);
        return xmlStr;
    }

}
