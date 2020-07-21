//Dedicated to Goli

package simulator;

import simulator.control.Simulator;
import simulator.gates.combinational.And;
import simulator.gates.combinational.Not;
import simulator.gates.combinational.Or;
import simulator.gates.sequential.Clock;
import simulator.gates.sequential.flipflops.DFlipFlop;
import simulator.network.Link;
import simulator.wrapper.wrappers.RealDFlipFlop;

import java.util.concurrent.TimeUnit;

public class Sample {
    public static void main(String[] args) throws InterruptedException {

        Register r1 = new Register();
        Register r2 = new Register();
        Clock c1 = new Clock("clock", 200);
        DFlipFlop d1 = new DFlipFlop("D" ,c1.getOutput(0), Simulator.falseLogic);
        DFlipFlop d2 = new DFlipFlop("D" ,c1.getOutput(0) , Simulator.trueLogic);
        DFlipFlop d3 = new DFlipFlop("D" ,c1.getOutput(0), Simulator.trueLogic);
        DFlipFlop d4 = new DFlipFlop("D" ,c1.getOutput(0), Simulator.trueLogic);
        r1.flipFlops.add(d1);
        r1.flipFlops.add(d2);
        r1.flipFlops.add(d3);
        r1.flipFlops.add(d4);

        DFlipFlop d5 = new DFlipFlop("D2" ,c1.getOutput(0) , Simulator.falseLogic);
        DFlipFlop d6 = new DFlipFlop("D2" ,c1.getOutput(0), Simulator.falseLogic);
        DFlipFlop d7 = new DFlipFlop("D2" ,c1.getOutput(0), Simulator.falseLogic);
        DFlipFlop d8 = new DFlipFlop("D2" ,c1.getOutput(0), Simulator.falseLogic);
        r2.flipFlops.add(d5);
        r2.flipFlops.add(d6);
        r2.flipFlops.add(d7);
        r2.flipFlops.add(d8);

        /*
        for (int i = 0; i < 32; i++) {
            DFlipFlop d1 = new DFlipFlop("d1", c1.getOutput(0), Simulator.trueLogic);
            DFlipFlop d2 = new DFlipFlop("d2", c1.getOutput(0) , Simulator.falseLogic );
            r1.getFlipFlops().add(d1);
            r2.getFlipFlops().add(d2);
            Simulator.debugger.addTrackItem(d1 , d2);
            Simulator.debugger.setDelay(100);
        }*/

        int i = 0;
        Link[] data = new Link[16];
        for (i =0 ; i<16 ; i++){
            data[i] = Simulator.trueLogic;
        }
        data[0] = Simulator.falseLogic;




        //Adder adder = new Adder("Adder" , "8X5" , r1.flipFlops.get(3).getOutput(0) , r1.flipFlops.get(2).getOutput(0) , r1.flipFlops.get(1).getOutput(0) , r1.flipFlops.get(0).getOutput(0) , r2.flipFlops.get(3).getOutput(0) , r2.flipFlops.get(2).getOutput(0) , r2.flipFlops.get(1).getOutput(0) , r2.flipFlops.get(0).getOutput(0));
        //Adder adder = new Adder("Adder" , "64X33");
        //Subtractor subtractor = new Subtractor("Sub" , "64X33");
        //OR32Bit or32Bit = new OR32Bit("OR32" , "64X32");
        //AND32Bit and32Bit = new AND32Bit("And32" , "64X32");
        //Mux4X1 m1 = new Mux4X1("Mux" , "6X1");
        //Mux16X1 m2 = new Mux16X1("Mux" , "20X1");
        //m2.addInput(data);
        //SignExtend16X32 s1 = new SignExtend16X32("SignEx" , "16X32");
        //s1.addInput(data);
        //FullAdder f = new FullAdder("FA" , "3X2" , r2.flipFlops.get(0).getOutput(0) , r2.flipFlops.get(0).getOutput(0) , r1.flipFlops.get(0).getOutput(0));
        //HalfAdder h = new HalfAdder("H1" , "2X2" , r1.flipFlops.get(0).getOutput(0) , r2.flipFlops.get(0).getOutput(0));
        //DoNothing doNothing = new DoNothing("D" , "8X10" );

        //Dec5X32 dec5X32 = new Dec5X32("DEC", "5X9", Simulator.falseLogic , Simulator.falseLogic , Simulator.trueLogic, Simulator.falseLogic , Simulator.falseLogic);
        //adder.addInput(data);
        //doNothing.addInput(data);
        //subtractor.addInput(data);
        //or32Bit.addInput(data);
        //and32Bit.addInput(data);
        //m1.addInput(Simulator.falseLogic , Simulator.trueLogic , Simulator.trueLogic , Simulator.trueLogic , Simulator.falseLogic , Simulator.trueLogic);

        ControlUnit u = new ControlUnit("Control" , "6X9" , Simulator.falseLogic , Simulator.falseLogic , Simulator.falseLogic , Simulator.trueLogic , Simulator.falseLogic , Simulator.falseLogic);

        Simulator.debugger.addTrackItem(d1,d2,d3,d4,d5,d6,d7,d8, u);
        Simulator.debugger.setDelay(100);
        Simulator.circuit.startCircuit("FAST");
    }
}