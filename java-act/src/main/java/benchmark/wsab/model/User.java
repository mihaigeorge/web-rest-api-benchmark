package benchmark.wsab.model;


import act.util.SimpleBean;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "User")
public class User implements SimpleBean {

    @Id
    public int id;

    @Column(name ="firstName", nullable = false)
    @NotNull
    public String firstName;

    @Column(name ="lastname", nullable = false)
    @NotNull
    public String lastName;

    @Column(name ="email", nullable = false)
    @NotNull
    public String email;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE})
    @JoinTable(name = "UserCountryMapping",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "countryId"))
    public Set<Country> countries = new HashSet<Country>(0);

}
