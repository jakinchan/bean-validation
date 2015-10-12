package sample.bean_validation.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="sample_table")
public class Sample {
    @Id
    private int id;
    @NotNull
    private String value;
}
