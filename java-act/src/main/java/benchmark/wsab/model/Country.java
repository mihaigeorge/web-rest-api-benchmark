package benchmark.wsab.model;

import act.util.SimpleBean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Country")
public class Country implements SimpleBean {

    @Id
    public int id;

    @NotNull
    public String name;

}
