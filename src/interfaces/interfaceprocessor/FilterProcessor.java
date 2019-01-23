package interfaces.interfaceprocessor;
import interfaces.filters.*;

class FilterAdapter implements Processor {
	Filter filter;
	public FilterAdapter(Filter filter) {
		this.filter = filter;
	}
	public String name() {return filter.name();}
	public Waveform process(Object input) {
		return filter.process((Waveform)input);
	}
}

class ChangePairAdapter implements Processor {
	String sname;
	public ChangePairAdapter(String s) {
		sname = s;
	}
	public Object process(Object input) {
		return sname + ": " + input + "ChangedPairResult";
	}
	public String name() {
		return sname;
	}
}

public class FilterProcessor {
	public static void main(String[] args) {
		Waveform w = new Waveform();
		String input = "INPUT";
		Apply.process(new FilterAdapter(new LowPass(1.0)), w);
		Apply.process(new FilterAdapter(new HighPass(2.0)), w);
		Apply.process(new FilterAdapter(new BandPass(3.0, 4.0)), w);
		Apply.process(new ChangePairAdapter("ChangePair"), input);
	}
}