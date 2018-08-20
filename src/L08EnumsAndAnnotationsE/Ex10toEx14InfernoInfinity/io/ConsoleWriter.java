package L08EnumsAndAnnotationsE.Ex10toEx14InfernoInfinity.io;

import L08EnumsAndAnnotationsE.Ex10toEx14InfernoInfinity.contracts.OutputWriter;

public class ConsoleWriter implements OutputWriter {

    @Override
    public void write(String message) {
        System.out.println(message);
    }

}
