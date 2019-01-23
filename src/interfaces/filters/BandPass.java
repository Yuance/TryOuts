package interfaces.filters;

public class BandPass extends Filter {
	double highCutoff, lowCutoff;
	public BandPass(double highCutoff, double lowCutoff) {
		this.highCutoff = highCutoff;
		this.lowCutoff = lowCutoff;
		}
	public Waveform process(Waveform input) {return input;}
}