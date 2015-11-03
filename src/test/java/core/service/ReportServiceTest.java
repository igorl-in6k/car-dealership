package core.service;

import core.entity.Brand;
import core.entity.Manager;
import core.service.impl.ReportServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ReportServiceTest {

    /*
    ReportService rs;
    FakeDealDaoImpl dd;

    @Before
    public void initialize() {
        dd = new FakeDealDaoImpl();
        rs = new ReportServiceImpl(dd);
    }

    @Test
    public void testPreferredBrandByDealsAmount() {
        assertThat(new Brand("BMW"),
                is(rs.getManagerPreferredBrandByPriceAmount(
                        new Manager("Man1", 20))));
        assertThat(new Brand("Ferrari"),
                is(rs.getManagerPreferredBrandByPriceAmount(
                        new Manager("Man2", 25))));
    }

    @Test
    public void testPreferredBrandByPriceAmount() {
        assertThat(new Brand("Ferrari"),
                is(rs.getManagerPreferredBrandByDealsAmount(
                        new Manager("Man1", 20))));
        assertThat(new Brand("Lamborghini"),
                is(rs.getManagerPreferredBrandByDealsAmount(
                        new Manager("Man2", 25))));
    }
    */
}
