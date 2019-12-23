package serieseval.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import serieseval.model.Algorithm;
import serieseval.model.Datasource;
import serieseval.model.DmresultPK;
import serieseval.model.Experimentgroup;
import serieseval.model.Testoption;
import serieseval.model.User;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2016-06-08T21:06:54")
@StaticMetamodel(Dmresult.class)
public class Dmresult_ { 

    public static volatile SingularAttribute<Dmresult, Double> correlationCoefficient;
    public static volatile SingularAttribute<Dmresult, Double> rootRelativeSquareError;
    public static volatile SingularAttribute<Dmresult, Double> meanAbsoluteError;
    public static volatile SingularAttribute<Dmresult, Testoption> testoption;
    public static volatile CollectionAttribute<Dmresult, Experimentgroup> experimentgroupCollection;
    public static volatile SingularAttribute<Dmresult, DmresultPK> dmresultPK;
    public static volatile SingularAttribute<Dmresult, Double> rootMeanSquaredError;
    public static volatile SingularAttribute<Dmresult, Datasource> datasource;
    public static volatile SingularAttribute<Dmresult, Integer> testoptionparam;
    public static volatile SingularAttribute<Dmresult, Double> relativeAbsoluteError;
    public static volatile SingularAttribute<Dmresult, Integer> id;
    public static volatile SingularAttribute<Dmresult, User> user;
    public static volatile SingularAttribute<Dmresult, Algorithm> algorithm;

}