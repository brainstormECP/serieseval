package serieseval.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import serieseval.model.Datasource;
import serieseval.model.Dmresult;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2016-06-08T21:06:54")
@StaticMetamodel(Experimentgroup.class)
public class Experimentgroup_ { 

    public static volatile CollectionAttribute<Experimentgroup, Datasource> datasourceCollection;
    public static volatile SingularAttribute<Experimentgroup, Date> fecha;
    public static volatile SingularAttribute<Experimentgroup, String> description;
    public static volatile SingularAttribute<Experimentgroup, Dmresult> resultseleccionado;
    public static volatile SingularAttribute<Experimentgroup, Integer> idexperimentgroup;

}