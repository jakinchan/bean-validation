package sample.bean_validation.bean.group;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({HogeGroup.class, Default.class})
public interface HogeDefault {
}
