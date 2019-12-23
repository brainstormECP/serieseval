package serieseval.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import serieseval.model.Dmresult;
import serieseval.model.Experimentgroup;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2016-06-08T21:06:54")
@StaticMetamodel(Datasource.class)
public class Datasource_ { 

    public static volatile SingularAttribute<Datasource, Integer> iddatasource;
    public static volatile CollectionAttribute<Datasource, Dmresult> dmresultCollection;
    public static volatile SingularAttribute<Datasource, String> name;
    public static volatile SingularAttribute<Datasource, Experimentgroup> idexperimentgroup;

}