package sample.bean_validation.bean.group;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({Default.class, HogeGroup.class})
public interface DefaultHoge {
}
