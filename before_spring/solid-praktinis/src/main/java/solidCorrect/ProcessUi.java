package solidCorrect;

import solidCorrect.exceptions.ProcessExceptionUi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessUi {
    TextTransformer transformer;

    public ProcessUi(TextTransformer transformer) {
        this.transformer = transformer;
    }

    public void processUi() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input;

            System.out.print("$ ");

            while ((input = reader.readLine()) != null) {
                int colonIdx = input.indexOf(':');
                TransformType transformType = TransformType.valueOf(input.substring(0, colonIdx));
                String text = input.substring(colonIdx + 1);

                String transformed = transformer.transform(transformType, text);
                System.out.println("Transformed:" + transformed);

                System.out.print("$ ");
            }
        } catch (IOException e) {
            throw new ProcessExceptionUi(e);
        }
    }
}
