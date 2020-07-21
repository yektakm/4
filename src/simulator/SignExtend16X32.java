package simulator;

import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class SignExtend16X32 extends Wrapper {
    public SignExtend16X32(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {

    }
}
