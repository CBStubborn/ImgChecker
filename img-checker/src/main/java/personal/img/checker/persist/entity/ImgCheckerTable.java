package personal.img.checker.persist.entity;

import javax.persistence.*;

/**
 * Created by Stubborn on 2017/4/8.
 */
@Entity
@Table(name = "img_checker")
public class ImgCheckerTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * sequence
     */
    @Column(name = "sequence")
    private int sequence;

    /**
     * img stored path
     */
    @Column(name = "img_url")
    private String imgUrl;

    /**
     * img has been checked or not
     */
    @Column(name = "checked")
    private boolean checked;

    /**
     * the result of recognition
     */
    @Column(name = "result")
    private String recognizeResults;

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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getRecognizeResults() {
        return recognizeResults;
    }

    public void setRecognizeResults(String recognizeResults) {
        this.recognizeResults = recognizeResults;
    }

    @Override
    public String toString() {
        return "ImgCheckerTable{" +
                "id=" + id +
                ", sequence=" + sequence +
                ", imgUrl='" + imgUrl + '\'' +
                ", checked=" + checked +
                ", recognizeResults=" + recognizeResults +
                '}';
    }

}
