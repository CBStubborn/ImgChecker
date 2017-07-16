package personal.img.checker.form;


import personal.img.checker.beans.RecognizeResult;

import java.util.List;

/**
 * Created by Stubborn on 2017/4/11.
 */
public class ImgForm {

    private int id;

    private int sequence;

    private List<RecognizeResult> recognizeResults;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public List<RecognizeResult> getRecognizeResults() {
        return recognizeResults;
    }

    public void setRecognizeResults(List<RecognizeResult> recognizeResults) {
        this.recognizeResults = recognizeResults;
    }

    @Override
    public String toString() {
        return "ImgForm{" +
                "id=" + id +
                ", sequence=" + sequence +
                ", recognizeResults=" + recognizeResults +
                '}';
    }
}
