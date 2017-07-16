package personal.img.checker.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.img.checker.beans.RecognizeResult;
import personal.img.checker.form.ImgForm;
import personal.img.checker.persist.dao.ImgCheckerDAO;
import personal.img.checker.persist.entity.ImgCheckerTable;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Stubborn on 2017/4/9.
 */
@Service
public class ImgCheckerService {

    private static final Logger LOG = LoggerFactory.getLogger(ImgCheckerService.class);

    @Autowired
    ImgCheckerDAO imgCheckerDAO;

    /**
     * @param sequence the sequence of img
     * @return a unchecked img
     */
    public List<ImgCheckerTable> getUnCheckedImg(int sequence) {
        List<ImgCheckerTable> imgCheckerTables = imgCheckerDAO.findAllBySequenceAndChecked(sequence, false);
        imgCheckerTables.sort(new Comparator<ImgCheckerTable>() {
            @Override
            public int compare(ImgCheckerTable o1, ImgCheckerTable o2) {
                String imgUrl_1 = o1.getImgUrl();
                String imgUrl_2 = o2.getImgUrl();
                return imgUrl_1.compareToIgnoreCase(imgUrl_2);
            }
        });
        return imgCheckerTables;
    }

    /**
     * update img information
     *
     * @param form
     */
    public void updateImgInfo(ImgForm form) {
        ImgCheckerTable imgCheckerTable = imgCheckerDAO.findById(form.getId());
        if (imgCheckerTable != null) {
            LOG.info("found img check entry: {}", imgCheckerTable);
            imgCheckerTable.setChecked(true);
            imgCheckerTable.setRecognizeResults(RecognizeResult.toPersistentStr(form.getRecognizeResults()));
            imgCheckerDAO.save(imgCheckerTable);
        } else {
            LOG.info("cannot found img check entry");
        }
    }
}
