package personal.img.checker.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import personal.img.checker.beans.RecognizeResult;
import personal.img.checker.form.ImgForm;
import personal.img.checker.persist.entity.ImgCheckerTable;
import personal.img.checker.service.ImgCheckerService;

import java.util.List;
import java.util.Map;

/**
 * Created by Stubborn on 2017/4/8.
 */
@Controller
@RequestMapping("/img-checker")
public class ImgChecker {

    private static final Logger LOG = LoggerFactory.getLogger(ImgChecker.class);

    private static final String ROOT = "img-checker/";

    @Autowired
    ImgCheckerService imgCheckerService;

    @RequestMapping("/")
    public String enter(Map<String, Object> model) {
        return ROOT + "enter";
    }

    @RequestMapping("checking")
    public String checking(@RequestParam("sequence") int sequence, Map<String, Object> model) {
        LOG.info("start checking...");
        List<ImgCheckerTable> uncheckedImgs = imgCheckerService.getUnCheckedImg(sequence);
        if(uncheckedImgs != null && uncheckedImgs.size() > 0) {
            model.put("imgCheckerTable", uncheckedImgs.get(0));
            model.put("sequence", sequence);
            model.put("recognizeResults", RecognizeResult.values());
        }
        return ROOT + "checking";
    }

    @RequestMapping(value = "checked", method = RequestMethod.POST)
    public String checked(ImgForm imgForm, Map<String, Object>model) {
        LOG.info("receive checked info: {}", imgForm);
        imgCheckerService.updateImgInfo(imgForm);
        List<ImgCheckerTable> uncheckedImgs = imgCheckerService.getUnCheckedImg(imgForm.getSequence());
        if(uncheckedImgs != null && uncheckedImgs.size() > 0) {
            model.put("imgCheckerTable", uncheckedImgs.get(0));
            model.put("sequence", imgForm.getSequence());
            model.put("recognizeResults", RecognizeResult.values());
        }
        return ROOT + "checking";
    }
}
