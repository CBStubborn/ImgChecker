package personal.img.checker.persist.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import personal.img.checker.persist.entity.ImgCheckerTable;

import java.util.List;

/**
 * Created by Stubborn on 2017/4/8.
 */
@Repository
public interface ImgCheckerDAO extends JpaRepository<ImgCheckerTable, Integer> {

    List<ImgCheckerTable> findAllBySequenceAndChecked(int sequence, boolean checked);

    ImgCheckerTable findById(int id);
}
