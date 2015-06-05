package pl.weztegre.filters;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import static org.junit.Assert.*;

/**
 * Created by st3rn on 14.05.15.
 */
@RunWith(MockitoJUnitRunner.class)
public class SimpleCORSFilterTest {

    private SimpleCORSFilter simpleCORSFilter;
    @Mock HttpServletResponse httpServletResponseMock;
    @Mock ServletResponse servletResponseMock;
    @Mock ServletRequest servletRequestMock;
    @Mock FilterChain filterChainMock;

    @Before
    public void setUp() throws Exception {
        this.simpleCORSFilter = new SimpleCORSFilter();
    }

    @Test
    public void testDoFilter() throws Exception {
        //Mockito.when(httpServletResponseMock);
        //Mockito.when(httpServletResponseMock.setHeader();
        simpleCORSFilter.doFilter(servletRequestMock, httpServletResponseMock, filterChainMock);

        Mockito.verify(httpServletResponseMock).setHeader("Access-Control-Allow-Origin", "*");
        Mockito.verify(httpServletResponseMock).setHeader("Access-Control-Allow-Methods",
				"POST, GET, OPTIONS, DELETE, PUT");
        Mockito.verify(httpServletResponseMock).setHeader("Access-Control-Max-Age", "3600");
        Mockito.verify(httpServletResponseMock).setHeader("Access-Control-Allow-Headers",
                "Origin, X-Requested-With, Content-Type, Accept");
        Mockito.verify(filterChainMock).doFilter(servletRequestMock, httpServletResponseMock);
    }
}