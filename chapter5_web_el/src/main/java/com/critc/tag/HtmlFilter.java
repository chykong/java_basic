package com.critc.tag;

/**
 * Created by 孔垂云 on 2017/5/21.
 */
public class HtmlFilter {
    /**
     * @param message 要转义的内容
     * @return 转义后的内容
     * @Method: filter
     * @Description: 静态方法，html标签转义处理
     */
    public static String filter(String message) {

        if (message == null)
            return (null);

        char content[] = new char[message.length()];
        message.getChars(0, message.length(), content, 0);
        StringBuffer result = new StringBuffer(content.length + 50);
        for (int i = 0; i < content.length; i++) {
            switch (content[i]) {
                case '<':
                    result.append("<");
                    break;
                case '>':
                    result.append(">");
                    break;
                case '&':
                    result.append("&");
                    break;
                case '"':
                    result.append("\"");
                    break;
                default:
                    result.append(content[i]);
            }
        }
        return (result.toString());
    }
}
