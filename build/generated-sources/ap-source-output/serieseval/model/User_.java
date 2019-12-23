package serieseval.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import serieseval.model.Dmresult;
import serieseval.model.Role;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2016-06-08T21:06:54")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> apellido2;
    public static volatile SingularAttribute<User, Integer> iduser;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, Role> idRole;
    public static volatile SingularAttribute<User, String> apellido1;
    public static volatile CollectionAttribute<User, Dmresult> dmresultCollection;
    public static volatile SingularAttribute<User, String> username;
    public static volatile SingularAttribute<User, String> nombres;
    public static volatile SingularAttribute<User, Boolean> activo;

}