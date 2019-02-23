package com.artificial.intelligence;

import org.tensorflow.Graph;
import org.tensorflow.Session;
import org.tensorflow.Tensor;
import org.tensorflow.TensorFlow;

import java.nio.charset.StandardCharsets;

/**
 * @author xiongcaesar
 * @date 2019-02-23
 */
public class HelloTensorflow {

    public static void main(String[] args) throws Exception {
        try (Graph graph = new Graph()) {
            final String value = "Hello from " + TensorFlow.version();

            try (Tensor tensor = Tensor.create(value.getBytes(StandardCharsets.UTF_8))) {
                graph.opBuilder("Const", "MyConst")
                        .setAttr("dtype", tensor.dataType())
                        .setAttr("value", tensor)
                        .build();
            }

            try (Session session = new Session(graph);
                 Tensor output = session.runner().fetch("MyConst").run().get(0)) {
                System.out.println(new String(output.bytesValue(), StandardCharsets.UTF_8));
            }
        }
    }

}
