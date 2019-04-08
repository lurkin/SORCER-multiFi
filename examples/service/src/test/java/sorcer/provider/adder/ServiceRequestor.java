package sorcer.provider.adder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sorcer.test.ProjectContext;
import org.sorcer.test.SorcerTestRunner;
import sorcer.core.requestor.ServiceConsumer;
import sorcer.eo.operator;
import sorcer.requestor.adder.AdderConsumer;
import sorcer.service.Context;

import static org.junit.Assert.assertEquals;
import static sorcer.co.operator.*;
import static sorcer.eo.operator.*;
import static sorcer.mo.operator.value;
import static sorcer.so.operator.exec;

/**
 * @author Mike Sobolewski
 */
@RunWith(SorcerTestRunner.class)
@ProjectContext("examples/service")
public class ServiceRequestor {
	private final static Logger logger = LoggerFactory.getLogger(ServiceRequestor.class);

	@Test
	public void adderRequestorAsService() throws Exception {

//		ExertRequestor req = new ExertRequestor(AdderConsumer.class, "exertion");
//		Context cxt = (Context) req.execEnt();

		ServiceConsumer req = consumer(AdderConsumer.class, "exertion");
//		sorcer.core.consumer.ServiceConsumer req = consumer(AdderConsumer.class, "netlet");

		Context cxt = (Context) exec(req);

		logger.info("outGovernance context: " + cxt);
		logger.info("context @ arg/x1: " + get(cxt, "arg/x1"));
		logger.info("context @ arg/x2: " + value(cxt, "arg/x2"));
		logger.info("context @ outGovernance/y: " + value(cxt, "outGovernance/y"));

		// get a single context argument
		assertEquals(300.0, value(cxt, "outGovernance/y"));
	}

}
	
	
