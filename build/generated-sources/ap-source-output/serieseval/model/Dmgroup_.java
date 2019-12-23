package serieseval.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import serieseval.model.Algorithm;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2016-06-08T21:06:54")
@StaticMetamodel(Dmgroup.class)
public class Dmgroup_ { 

    public static volatile SingularAttribute<Dmgroup, Integer> idgroup;
    public static volatile SingularAttribute<Dmgroup, String> name;
    public static volatile CollectionAttribute<Dmgroup, Algorithm> algorithmCollection;

}