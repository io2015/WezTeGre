package pl.weztegre.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "persistent_logins")
public class PersistentLogin {
    @Id
    @Column(length = 64)
    private String series;

    @NotNull
    @Column(length = 64)
    private String username;

    @NotNull
    @Column(length = 64)
    private String token;

    @NotNull
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "last_used")
    private Date lastUsed;
}
