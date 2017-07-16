package personal.img.checker.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stubborn on 2017/4/11.
 */
public enum RecognizeResult {

    unknown(0),
    识别正确(1),
    号牌号码错误(2),
    号牌种类错误(3),
    号牌颜色错误(4),
    车辆品牌错误(5),
    车身颜色错误(6),
    车辆类型错误(7),
    子品牌识别错误(8),;

    private int code;

    /**
     * constructor function
     *
     * @param code
     */
    RecognizeResult(int code) {
        this.code = code;
    }

    /**
     * @return an enum's code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code
     * @return an recognize-result object
     */
    public static RecognizeResult codeOf(int code) {
        for (RecognizeResult d : RecognizeResult.values()) {
            if (d.code == code) {
                return d;
            }
        }
        return null;
    }

    /**
     * convert a code string to a list of recognize-result
     *
     * @param recognizeResultStr
     * @return
     */
    public static List<RecognizeResult> fromPersistentStr(String recognizeResultStr) {
        List<RecognizeResult> recognizeResults = new ArrayList<>();
        if (recognizeResultStr != null && recognizeResultStr.trim().length() >= 1) {
            String[] recognizeResultArr = recognizeResultStr.split(",");
            for (String recognizeResult : recognizeResultArr) {
                try {
                    recognizeResults.add(RecognizeResult.codeOf(Integer.parseInt(recognizeResult)));
                } catch (Exception e) {
                    recognizeResults.add(RecognizeResult.unknown);
                }

            }
        }
        return recognizeResults;
    }

    /**
     * convert a list of recognize-result to a code string
     *
     * @param recognizeResults
     * @return
     */
    public static String toPersistentStr(List<RecognizeResult> recognizeResults) {
        String recognizeResultStr = null;
        if (recognizeResults == null) recognizeResultStr = null;
        else {
            StringBuilder sb = new StringBuilder();
            for (RecognizeResult recognizeResult : recognizeResults) {
                sb.append(recognizeResult.getCode()).append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            recognizeResultStr = sb.toString();
        }
        return recognizeResultStr;
    }

}
