package serieseval.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import serieseval.model.Dmgroup;
import serieseval.model.Dmresult;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2016-06-08T21:06:54")
@StaticMetamodel(Algorithm.class)
public class Algorithm_ { 

    public static volatile CollectionAttribute<Algorithm, Dmresult> dmresultCollection;
    public static volatile SingularAttribute<Algorithm, Dmgroup> idgroup;
    public static volatile SingularAttribute<Algorithm, String> name;
    public static volatile SingularAttribute<Algorithm, Integer> idalgorithm;

}