package lst.spring.Entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPlan is a Querydsl query type for Plan
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPlan extends EntityPathBase<Plan> {

    private static final long serialVersionUID = 1272756148L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPlan plan = new QPlan("plan");

    public final DateTimePath<java.util.Date> planDate = createDateTime("planDate", java.util.Date.class);

    public final StringPath planTime = createString("planTime");

    public final NumberPath<Long> seq = createNumber("seq", Long.class);

    public final StringPath title = createString("title");

    public final QUser user;

    public QPlan(String variable) {
        this(Plan.class, forVariable(variable), INITS);
    }

    public QPlan(Path<? extends Plan> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPlan(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPlan(PathMetadata metadata, PathInits inits) {
        this(Plan.class, metadata, inits);
    }

    public QPlan(Class<? extends Plan> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

