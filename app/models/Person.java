package models;

/**
 * Created by brian on 9/20/15.
 */

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person extends com.avaje.ebean.Model {
    @Id
    public String id;

    public String name;
}
