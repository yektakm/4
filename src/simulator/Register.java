package simulator;

import simulator.control.Simulator;
import simulator.gates.sequential.Clock;
import simulator.gates.sequential.flipflops.DFlipFlop;
import simulator.gates.sequential.flipflops.FlipFlop;
import simulator.network.Link;

import java.util.ArrayList;

public class Register{
    //private Clock clock;
    public ArrayList<DFlipFlop> flipFlops = new ArrayList<DFlipFlop>();


    public void setFlipFlops(ArrayList<DFlipFlop> flipFlops) {
        this.flipFlops = flipFlops;
    }

    public ArrayList<DFlipFlop> getFlipFlops() {
        return flipFlops;
    }

    /*public void setClock(Clock clock) {
        this.clock = clock;
    }
    public Clock getClock() {
        return clock;
    }*/

    public void setFlipFlopsByIndex(int startIndex, int endIndex, int[] data, Clock clock){
        for (int i=startIndex ; i<endIndex ; i++ ){
            if (data[i] == 0){
                getFlipFlops().set(i, new DFlipFlop("d"+i, clock.getOutput(0),Simulator.falseLogic));
            }
            else if (data[i] == 1){
                getFlipFlops().set(i, new DFlipFlop("d"+i, clock.getOutput(0),Simulator.trueLogic));
            }

        }
    }


    public ArrayList<Link> dataToLogic(){
        ArrayList<Link> logicalData = new ArrayList<>();
        for (int i = 0 ; i < 4 ; i++){
            logicalData.add(getFlipFlops().get(i).getData());
        }
        return logicalData;
    }

    public void showReg(){
        for(int i=0 ; i<flipFlops.size(); i++){
            System.out.println(flipFlops.get(i).getData().getSignal().toString());
        }
    }


}