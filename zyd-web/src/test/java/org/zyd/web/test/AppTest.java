package org.zyd.web.test;

import java.math.BigDecimal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zyd.common.exception.ZydException;
import org.zyd.service.inf.UserInf;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AppTest extends TestCase {
	private ApplicationContext ctx = null;

    public AppTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        ctx = new ClassPathXmlApplicationContext("application-context.xml");
    }
    
    
    public void testApp() throws ZydException {
//    	UserInf userInf = ctx.getBean(UserInf.class);
//
//    	PartyPointDto rlt = userInf.queryPartyPoint(BigDecimal.valueOf(15));
//
//    	assertNull(rlt);
    }
}
