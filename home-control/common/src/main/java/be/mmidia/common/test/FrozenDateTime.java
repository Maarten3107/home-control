package be.mmidia.common.test;

import com.google.common.base.Preconditions;
import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;

import org.junit.rules.ExternalResource;

public class FrozenDateTime extends ExternalResource {

    private final DateTime dateTime;

    public FrozenDateTime() {
        this(DateTime.now());
    }

    public FrozenDateTime(String frozenDate) {
        this(DateTime.parse(frozenDate));
    }

    public FrozenDateTime(DateTime frozenDateTime) {
        this.dateTime = frozenDateTime;
        Preconditions.checkArgument(frozenDateTime != null, "frozenDateTime may not be null");
    }

    @Override
    protected void before() throws Throwable {
        freeze();
    }

    @Override
    protected void after() {
        unfreeze();
    }

    public void freeze() {
        DateTimeUtils.setCurrentMillisFixed(dateTime.getMillis());
    }

    public void unfreeze() {
        DateTimeUtils.setCurrentMillisSystem();
    }

    public DateTime getDateTime() {
        return dateTime;
    }
}

