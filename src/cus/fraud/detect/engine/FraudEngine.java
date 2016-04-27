package cus.fraud.detect.engine;

import java.util.Iterator;

import jess.Filter;
import jess.JessException;
import jess.Rete;
import cus.fraud.detect.model.Risk;

public class FraudEngine {
	private Rete engine;

	public FraudEngine() throws JessException {
		engine = new Rete();
		engine.reset();
		engine.batch("rules.clp");
	}

	public void add(Object obj) throws JessException {
		engine.add(obj);
	}

	public Iterator<?> run() throws JessException {
		engine.run();
		return engine.getObjects(new Filter.ByClass(Risk.class));
	}
}