package org.zyd.domain;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zyd.common.exception.ZydException;
import org.zyd.domain.factory.UserInfoFactory;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class PartyIdentifyBeanTest extends TestCase{
	
	private ApplicationContext ctx = null;
	
	public PartyIdentifyBeanTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(PartyIdentifyBeanTest.class);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();

        ctx = new ClassPathXmlApplicationContext("application-context.xml");
    }
    
    public void testApp() throws ZydException {
    	UserInfoFactory factory = ctx.getBean("partyFactory", UserInfoFactory.class);
    	
//    	PartyIdentifyBean bean = factory.createPartyIdentifyBean();
//    	bean.setRecommendCode("code");
//    	bean.setRegisterDate(new Timestamp(new Date().getTime()));
//    	bean.save();
//
//    	assertNotNull(bean.getPartyId());
//
//    	bean.remove();
//
//    	assertNull(bean.getPartyId());
    }
}
